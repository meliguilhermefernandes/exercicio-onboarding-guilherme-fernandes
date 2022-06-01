package br.com.meli.onboarding.pagamentos.service;

import br.com.meli.onboarding.commons.enums.EPaymentMethod;
import br.com.meli.onboarding.pagamentos.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.commons.exception.CriarPagamentoException;
import br.com.meli.onboarding.commons.exception.MPIntegrationException;
import br.com.meli.onboarding.pagamentos.v1.rs.response.BoletoResponseDTO;
import br.com.meli.onboarding.pagamentos.v1.rs.response.PixResponseDTO;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PagamentoService implements IPagamentoService {

    @Override
    public String criarPagamentoCartao(PagamentoRequestDTO pagamentoRequestDTO) {
        pagamentoRequestDTO.setPaymentMethodId(EPaymentMethod.VISA.getValue());
        return criar(pagamentoRequestDTO).getResponse().getContent();
    }

    @Override
    public PixResponseDTO criarPagamentoPix(PagamentoRequestDTO pagamentoRequestDTO) {
        pagamentoRequestDTO.setPaymentMethodId(EPaymentMethod.PIX.getValue());
        pagamentoRequestDTO.setInstallments(null);
        return new PixResponseDTO(criar(pagamentoRequestDTO).getPointOfInteraction().getTransactionData());
    }

    @Override
    public BoletoResponseDTO criarPagamentoBoleto(PagamentoRequestDTO pagamentoRequestDTO) {
        pagamentoRequestDTO.setPaymentMethodId(EPaymentMethod.BOLETO.getValue());
        pagamentoRequestDTO.setInstallments(null);
        return new BoletoResponseDTO(criar(pagamentoRequestDTO).getTransactionDetails());
    }

    private Payment criar(PagamentoRequestDTO pagamentoRequestDTO) {
        PaymentClient paymentClient = new PaymentClient();

        try {
            PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                    .transactionAmount(pagamentoRequestDTO.getTransactionAmount())
                    .token(pagamentoRequestDTO.getToken())
                    .description(pagamentoRequestDTO.getDescription())
                    .installments(pagamentoRequestDTO.getInstallments())
                    .paymentMethodId(pagamentoRequestDTO.getPaymentMethodId())
                    .payer(
                        PaymentPayerRequest.builder()
                            .email(pagamentoRequestDTO.getPayerDTO() != null ?
                                pagamentoRequestDTO.getPayerDTO().getEmail() : null)
                            .firstName(pagamentoRequestDTO.getPayerDTO() != null ?
                                pagamentoRequestDTO.getPayerDTO().getFirstName() : null)
                            .lastName(pagamentoRequestDTO.getPayerDTO() != null ?
                                    pagamentoRequestDTO.getPayerDTO().getLastName() : null)
                            .identification(
                                IdentificationRequest.builder()
                                    .type(pagamentoRequestDTO.getPayerDTO() != null &&
                                        pagamentoRequestDTO.getPayerDTO().getIdentificationDTO() != null ?
                                        pagamentoRequestDTO.getPayerDTO().getIdentificationDTO().getType() : null)
                                    .number(pagamentoRequestDTO.getPayerDTO() != null &&
                                        pagamentoRequestDTO.getPayerDTO().getIdentificationDTO() != null ?
                                        pagamentoRequestDTO.getPayerDTO().getIdentificationDTO().getNumber() : null)
                                    .build())
                            .build())
                    .build();

            return paymentClient.create(paymentCreateRequest);
        } catch (MPException | MPApiException exception) {
            log.error("Error integracao PagamentoService.criar() " + exception.getMessage(), exception);
            throw new MPIntegrationException();
        } catch (Exception exception) {
            log.error("Error PagamentoService.criar() " + exception.getMessage(), exception);
            throw new CriarPagamentoException();
        }
    }
}
