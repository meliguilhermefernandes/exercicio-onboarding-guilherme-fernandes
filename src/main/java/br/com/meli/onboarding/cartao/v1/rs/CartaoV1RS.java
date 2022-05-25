package br.com.meli.onboarding.cartao.v1.rs;

import br.com.meli.onboarding.cartao.service.ICartaoService;
import br.com.meli.onboarding.cartao.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.preferencia.service.IPreferenciaService;
import br.com.meli.onboarding.preferencia.v1.rs.request.PreferenciaRequestDTO;
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
@Api(value = "v1/cartao", tags = "Cartão")
@RequestMapping("v1/cartao")
public class CartaoV1RS {

    @Autowired
    private ICartaoService cartaoService;

    @ApiOperation(value = "Pagar Cartão")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> pagamento(@RequestBody @Valid PagamentoRequestDTO pagamentoRequestDTO) {
        return new ResponseEntity<>(cartaoService.criarPagamento(pagamentoRequestDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
