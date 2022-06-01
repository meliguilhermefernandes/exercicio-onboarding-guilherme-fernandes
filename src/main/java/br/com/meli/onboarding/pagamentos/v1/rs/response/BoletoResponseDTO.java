package br.com.meli.onboarding.pagamentos.v1.rs.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.payment.PaymentTransactionData;
import com.mercadopago.resources.payment.PaymentTransactionDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoletoResponseDTO {

    @JsonProperty
    private String url;

    public BoletoResponseDTO(PaymentTransactionDetails paymentTransactionDetails) {
        this.url = paymentTransactionDetails.getExternalResourceUrl();
    }
}
