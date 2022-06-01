package br.com.meli.onboarding.meios.pagamento.service;

import br.com.meli.onboarding.commons.exception.CriarPagamentoException;
import br.com.meli.onboarding.commons.exception.MPIntegrationException;
import com.mercadopago.client.paymentmethod.PaymentMethodClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPResourceList;
import com.mercadopago.resources.paymentmethod.PaymentMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MeiosPagamentoService implements IMeiosPagamentoService {

    @Override
    public List<PaymentMethod> listar() {
        try {
            PaymentMethodClient paymentMethodClient = new PaymentMethodClient();
            MPResourceList methods = paymentMethodClient.list();
            return methods.getResults();
        } catch (MPException | MPApiException exception) {
            log.error("Error integracao MeiosPagamentoService.listar() " + exception.getMessage(), exception);
            throw new MPIntegrationException();
        } catch (Exception exception) {
            log.error("Error MeiosPagamentoService.listar() " + exception.getMessage(), exception);
            throw new CriarPagamentoException();
        }
    }
}
