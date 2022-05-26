package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.dto.request.PictureDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PictureDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.Picture;
import br.com.victorcaselli.frameworkchallenge.repositories.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.victorcaselli.frameworkchallenge.dto.response.PictureDtoResponse.toDto;

@RequiredArgsConstructor
@Service
public class PictureService {

    private final PictureRepository pictureRepository;
    private final PhotoCollectionService photoCollectionService;

    @Transactional(readOnly = true)
    public PictureDtoResponse findById(Long id){
        return toDto(pictureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Picture not found")));
    }

    @Transactional
    public PictureDtoResponse save(PictureDtoRequest request, Long id){
        Picture picture = request.toEntity();
        picture.setCollection(photoCollectionService.findById(id).toEntity());
        return toDto(pictureRepository.save(picture));
    }

    @Transactional
    public void deleteById(Long id){
        findById(id);
        pictureRepository.deleteById(id);
    }
}
