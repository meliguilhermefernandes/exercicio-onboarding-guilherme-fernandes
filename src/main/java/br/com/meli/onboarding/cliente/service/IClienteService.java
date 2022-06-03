package br.com.meli.onboarding.cliente.service;

import com.mercadopago.resources.customer.Customer;
import com.mercadopago.resources.customer.CustomerCard;

import java.util.List;

public interface IClienteService {

    List<CustomerCard> listarCartoes(final String email);

    Customer consultarCliente(final String email);

    Customer cadastrarCliente(final String email);

    void associarCartaoCredito(String email, String token, String paymentMethodId, String issuerId);
}
