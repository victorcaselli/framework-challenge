package br.com.victorcaselli.frameworkchallenge.config;

import br.com.victorcaselli.frameworkchallenge.enums.RoleType;
import br.com.victorcaselli.frameworkchallenge.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class RoleConfig {

    private final RoleService roleService;

    @PostConstruct
    public void rolesInitialize(){
        roleService.checkIfRolesExists(List.of(RoleType.values()));
    }
}
