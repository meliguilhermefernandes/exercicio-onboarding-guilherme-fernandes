package br.com.meli.onboarding.meios.pagamento.v1.rs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1/meios-pagamento", tags = "Meios Pagamento")
@RequestMapping("v1/meios-pagamento")
public class MeiosPagamentoV1RS {

    @ApiOperation(value = "Listar Meios Pagamento")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<String> listarMeiosPagamento() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
