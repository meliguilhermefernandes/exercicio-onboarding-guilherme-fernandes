package br.com.meli.onboarding.pagamentos.v1.rs.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.payment.PaymentTransactionData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixResponseDTO {

    @JsonProperty("qr_code")
    private String qrCode;

    @JsonProperty("ticket_url")
    private String ticketUrl;

    @JsonProperty("qr_code_base64")
    private String qrCodeBase64;

    public PixResponseDTO(PaymentTransactionData transactionData) {


        this.qrCode = transactionData.getQrCode();
        this.ticketUrl = transactionData.getTicketUrl()
                .replaceAll("beta.", "")
                .replaceAll("/payments", "/sandbox/payments");
        this.qrCodeBase64 = transactionData.getQrCodeBase64();
    }
}
