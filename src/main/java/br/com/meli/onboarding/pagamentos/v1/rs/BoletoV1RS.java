package br.com.meli.onboarding.pagamentos.v1.rs;

import br.com.meli.onboarding.pagamentos.service.IPagamentoService;
import br.com.meli.onboarding.pagamentos.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.pagamentos.v1.rs.response.BoletoResponseDTO;
import br.com.meli.onboarding.pagamentos.v1.rs.response.PixResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "v1/boleto", tags = "Boleto")
@RequestMapping("v1/boleto")
public class BoletoV1RS {

    @Autowired
    private IPagamentoService cartaoService;

    @ApiOperation(value = "Pagar Boleto")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BoletoResponseDTO> pagamento(@RequestBody @Valid PagamentoRequestDTO pagamentoRequestDTO) {
        return new ResponseEntity<>(cartaoService.criarPagamentoBoleto(pagamentoRequestDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
