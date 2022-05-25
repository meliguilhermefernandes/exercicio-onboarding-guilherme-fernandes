package br.com.meli.onboarding.cartao.service;

import br.com.meli.onboarding.cartao.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.commons.exception.CriarPagamentoCartaoException;
import br.com.meli.onboarding.commons.exception.MPIntegrationException;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartaoService implements ICartaoService{

    @Override
    public String criarPagamento(PagamentoRequestDTO pagamentoRequestDTO) {
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

            return paymentClient.create(paymentCreateRequest).getResponse().getContent();
        } catch (MPException | MPApiException exception) {
            log.error("Error integracao CartaoService.criarPagamento() " + exception.getMessage(), exception);
            throw new MPIntegrationException();
        } catch (Exception exception) {
            log.error("Error CartaoService.criarPagamento() " + exception.getMessage(), exception);
            throw new CriarPagamentoCartaoException();
        }
    }
}
