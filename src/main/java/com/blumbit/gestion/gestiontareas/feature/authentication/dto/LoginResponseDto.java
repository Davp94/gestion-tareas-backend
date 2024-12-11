package com.blumbit.gestion.gestiontareas.feature.authentication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDto {

    private String token;

}
