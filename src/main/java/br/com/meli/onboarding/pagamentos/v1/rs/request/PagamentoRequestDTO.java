package br.com.meli.onboarding.pagamentos.v1.rs.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagamentoRequestDTO {

    @JsonProperty("transaction_amount")
    private BigDecimal transactionAmount;

    @JsonProperty
    private String token;

    @JsonProperty
    private String description;

    @JsonProperty
    private Integer installments;

    @JsonProperty("payment_method_id")
    private String paymentMethodId;

    @JsonProperty("payer")
    private PayerDTO payerDTO;
}
