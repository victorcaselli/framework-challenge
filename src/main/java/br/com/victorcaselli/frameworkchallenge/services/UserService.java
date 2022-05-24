package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.dto.request.UserDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.UserDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.repositories.UserRepository;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.victorcaselli.frameworkchallenge.dto.response.UserDtoResponse.toDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDtoResponse> findAll(){
        return userRepository.findAll()
                .stream().map(UserDtoResponse::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDtoResponse findById(Long id){
        return toDto( userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"))
        );
    }

    @Transactional
    public UserDtoResponse save(UserDtoRequest userDtoRequest){
        return toDto(
                userRepository.save(userDtoRequest.toEntity())
        );
    }

    /**
     * Patch method it's better than update method. I'll create patch method using reflection.
     */

    @Transactional
    public UserDtoResponse update(UserDtoRequest userDtoRequest, Long id){
        findById(id); //Check if the user exists
        User data = userDtoRequest.toEntity(); // create new user based on dto body
        data.setId(id); // set checked id
        return toDto(userRepository.save(data)); //save new information
    }

    @Transactional
    public void deleteById(Long id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
            throw new UserNotFoundException("Id not found");
        }

    }
}
