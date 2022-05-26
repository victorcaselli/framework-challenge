package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.dto.request.PhotoCollectionDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PhotoCollectionDtoResponse;

import br.com.victorcaselli.frameworkchallenge.entities.PhotoCollection;
import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.repositories.PhotoCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.victorcaselli.frameworkchallenge.dto.response.PhotoCollectionDtoResponse.toDto;
import static br.com.victorcaselli.frameworkchallenge.utils.AuthenticatedUserUtils.getAuthUser;

@RequiredArgsConstructor
@Service
public class PhotoCollectionService {

    private final PhotoCollectionRepository photoCollectionRepository;


    @Transactional(readOnly = true)
    public List<PhotoCollectionDtoResponse> findAll(){
        return photoCollectionRepository.findAll()
                .stream().map(PhotoCollectionDtoResponse::toDto)
                .collect(Collectors.toList());
    }

    public PhotoCollectionDtoResponse findById(Long id){
        return toDto(photoCollectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Photo Collection not found")));
    }

    public PhotoCollectionDtoResponse save(PhotoCollectionDtoRequest request){
        PhotoCollection photoCollection = request.toEntity();
        photoCollection.setUser(getAuthUser());
        return toDto(photoCollectionRepository.save(photoCollection));
    }

    public void deleteById(Long id){
        User user = getAuthUser();
        PhotoCollection response = findById(id).toEntity();

        if(!response.getUser().equals(user)){
            throw new IllegalArgumentException("Photo Collection not found");
        }

        photoCollectionRepository.deleteById(id);
    }
}
