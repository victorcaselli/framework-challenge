package br.com.victorcaselli.frameworkchallenge.dto.response;


import br.com.victorcaselli.frameworkchallenge.entities.PhotoCollection;
import br.com.victorcaselli.frameworkchallenge.utils.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhotoCollectionDtoResponse implements Serializable {
    private static final long serialVersionUID = -7145203904246710360L;

    private Long id;
    private String title;
    private String description;
    private List<PictureDtoResponse> pictures = new ArrayList<>();
    private UserDtoResponse user;


    public static PhotoCollectionDtoResponse toDto(PhotoCollection photoCollection){
        return ModelMapperUtils.map(photoCollection, PhotoCollectionDtoResponse.class);
    }

    public PhotoCollection toEntity(){
        return ModelMapperUtils.map(this, PhotoCollection.class);
    }
}
