package br.com.meli.onboarding.cliente.v1.rs.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartoesResponseDTO {

    @JsonProperty
    private String id;

    @JsonProperty("expiration_month")
    private String expirationMonth;

    @JsonProperty("expiration_year")
    private String expirationYear;

    @JsonProperty("first_six_digits")
    private String firstSixDigits;

    @JsonProperty("last_four_digits")
    private String last_four_digits;
}
