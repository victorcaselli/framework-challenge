package br.com.victorcaselli.frameworkchallenge.utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//TODO - Can be better... Change in the future.

@RequiredArgsConstructor
@Component
public class ModelMapperUtils {

    private final ModelMapper modelMapper;
    private static ModelMapper staticModelMapper;

    @PostConstruct
    public void setup(){
        staticModelMapper = modelMapper;
    }


    public static <T,S> T map(S source, Class<T> dest){
        return staticModelMapper.map(source, dest);
    }
}
