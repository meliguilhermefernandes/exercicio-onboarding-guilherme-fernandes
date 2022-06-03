package br.com.meli.onboarding;

import br.com.meli.onboarding.cliente.service.ClienteService;
import br.com.meli.onboarding.cliente.service.IClienteService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.resources.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    @BeforeEach
    void setUp() {
        MercadoPagoConfig.setAccessToken("TEST-7734846494415149-052513-c77bc9b1b9620138fcb73cf3d012417f-1130236298");
        clienteService = new ClienteService();
    }

    @Test
    void testaCriarCliente() {
        Customer cliente = clienteService.cadastrarCliente("emailtestegui@email.com");
        cliente.getId();
    }

    @Test
    void testaConsultarCliente() {
        Customer cliente = clienteService.consultarCliente("emailtestegui@email.com");
        cliente.getId();
    }
}
