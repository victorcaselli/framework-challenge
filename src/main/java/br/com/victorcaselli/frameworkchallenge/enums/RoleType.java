package br.com.victorcaselli.frameworkchallenge.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleType {

    ADMIN(0, "ADMIN"),
    USER(1, "USER");

    private final Integer code;
    private final String description;


    public static RoleType toEnum(Integer code){
        if(code == null)
            return null;

        for(RoleType rt : RoleType.values()){
            if(rt.getCode().equals(code))
                return rt;
        }

        throw new IllegalArgumentException("Invalid code, code: "+code);
    }
}