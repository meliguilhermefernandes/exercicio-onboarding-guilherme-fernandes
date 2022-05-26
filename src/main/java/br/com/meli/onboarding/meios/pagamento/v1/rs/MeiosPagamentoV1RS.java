package br.com.meli.onboarding.meios.pagamento.v1.rs;

import br.com.meli.onboarding.meios.pagamento.service.MeiosPagamentoService;
import com.mercadopago.resources.paymentmethod.PaymentMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "v1/meios-pagamento", tags = "Meios Pagamento")
@RequestMapping("v1/meios-pagamento")
public class MeiosPagamentoV1RS {

    @Autowired
    private MeiosPagamentoService service;

    @ApiOperation(value = "Listar Meios Pagamento")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentMethod>> listarMeiosPagamento() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }
}
