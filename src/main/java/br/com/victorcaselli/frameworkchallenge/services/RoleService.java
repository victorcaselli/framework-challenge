package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.entities.Role;
import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.enums.RoleType;
import br.com.victorcaselli.frameworkchallenge.observables.UserObservable;
import br.com.victorcaselli.frameworkchallenge.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleService implements UserObservable {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @PostConstruct
    public void setup(){
        userService.subscribe(this);
    }

    @Transactional
    public void checkIfRolesExists(List<RoleType> roleTypes){

        List<Role> roles = roleRepository.findAll();

        if(!roles.isEmpty()){
            List<RoleType> unsaved = roleTypes.stream()
                    .filter(object -> {
                        for (Role role : roles) {
                            String r = "ROLE_"+object.getDescription();
                            return r.equalsIgnoreCase(role.getAuthority());

                        }
                        return false;
                    }).collect(Collectors.toList());

            roleRepository.saveAll(
                    unsaved.stream()
                            .map(object -> new Role(null, "ROLE_"+object.getDescription()))
                            .collect(Collectors.toList())
            );
        }else{
            roleRepository.saveAll(
                    roleTypes.stream()
                            .map(object -> new Role(null, "ROLE_"+object.getDescription()))
                            .collect(Collectors.toList())
            );
        }
    }
    @Transactional
    public void save(Role role){
        roleRepository.save(role);
    }

    public Role findById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        //TODO - create custom exception for roles
    }

    @Override
    public void onSave(User user) {
        Role role = roleRepository.findAll()
                        .stream().filter(object -> object.getAuthority().equalsIgnoreCase("ROLE_"+RoleType.USER.getDescription())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        user.getRoles().add(role);
    }
}
