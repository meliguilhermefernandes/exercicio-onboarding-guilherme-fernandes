package br.com.meli.onboarding.v1.rs.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class PreferenciaResponseDTO {

    private String url;
}
