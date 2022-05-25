package br.com.meli.onboarding.meios.pagamento.v1.rs.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayerDTO {

    @JsonProperty
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("identification")
    private IdentificationDTO identificationDTO;
}
