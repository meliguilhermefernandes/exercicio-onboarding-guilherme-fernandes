package br.com.meli.onboarding.cliente.service;

import com.mercadopago.client.customer.CustomerCardClient;
import com.mercadopago.client.customer.CustomerCardCreateRequest;
import com.mercadopago.client.customer.CustomerClient;
import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPResultsResourcesPage;
import com.mercadopago.net.MPSearchRequest;
import com.mercadopago.resources.customer.Customer;
import com.mercadopago.resources.customer.CustomerCard;
import com.mercadopago.resources.customer.CustomerCardIssuer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ClienteService implements IClienteService {

    @Override
    public List<CustomerCard> listarCartoes(String email) {
        CustomerClient customerClient = new CustomerClient();
        try {
            Customer customer = consultarCliente(email);
            if(customer == null) {
                customer = cadastrarCliente(email);
            }
            return customerClient.listCards(customer.getId()).getResults();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer consultarCliente(String email) {
        try {
            Map<String, Object> filter = new HashMap<>();
            filter.put("email", email);
            MPSearchRequest request = MPSearchRequest.builder().limit(1).offset(0).filters(filter).build();
            MPResultsResourcesPage<Customer> resultado = new CustomerClient().search(request);
            return !resultado.getResults().isEmpty() ? resultado.getResults().get(0) : null;
        } catch (MPException | MPApiException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer cadastrarCliente(String email) {
        CustomerClient customerClient = new CustomerClient();
        try {
            return customerClient.create(
                CustomerRequest.
                    builder().
                    email(email).
                    build()
            );
        } catch (MPException | MPApiException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void associarCartaoCredito(String email, String token, String paymentMethodId, String issuerId) {
        CustomerCardClient customerCardClient = new CustomerCardClient();
        Customer customer = consultarCliente(email);
        if(customer == null) {
            customer = cadastrarCliente(email);
        }
        CustomerCardIssuer issuer = CustomerCardIssuer.builder()
                .id(issuerId)
                .build();
        CustomerCardCreateRequest cardCreateRequest = CustomerCardCreateRequest.builder()
                .token(token)
                .issuer(issuer)
                .paymentMethodId(paymentMethodId)
                .build();

        try {
            customerCardClient.create(customer.getId(), cardCreateRequest);
        } catch (MPException | MPApiException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
