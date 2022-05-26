package br.com.meli.onboarding.meios.pagamento.service;

import com.mercadopago.resources.paymentmethod.PaymentMethod;

import java.util.List;

public interface IMeiosPagamentoService {
    List<PaymentMethod> listar();
}
