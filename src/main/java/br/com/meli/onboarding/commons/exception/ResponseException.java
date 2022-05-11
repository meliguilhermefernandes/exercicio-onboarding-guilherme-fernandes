package br.com.meli.onboarding.commons.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseException {

    @JsonProperty("error-code")
    private String code;

    @JsonProperty("error-description")
    private String description;
}
