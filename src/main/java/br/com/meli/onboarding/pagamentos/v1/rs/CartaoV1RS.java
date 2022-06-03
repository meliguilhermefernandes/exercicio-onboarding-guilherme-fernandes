package br.com.meli.onboarding.pagamentos.v1.rs;

import br.com.meli.onboarding.pagamentos.service.IPagamentoService;
import br.com.meli.onboarding.pagamentos.v1.rs.request.PagamentoRequestDTO;
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
    private IPagamentoService pagamentoService;

    @ApiOperation(value = "Pagar Cartão")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> pagamento(@RequestBody @Valid PagamentoRequestDTO pagamentoRequestDTO) {
        return new ResponseEntity<>(pagamentoService.criarPagamentoCartao(pagamentoRequestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Pagar Cartão")
    @RequestMapping(value = "/pagar-cartao-salvo", method = RequestMethod.POST)
    public ResponseEntity<String> pagarCartaoSalvo(@RequestBody @Valid PagamentoRequestDTO pagamentoRequestDTO) {
        return new ResponseEntity<>(pagamentoService.criarPagamentoCartaoSalvo(pagamentoRequestDTO), HttpStatus.CREATED);
    }
}
