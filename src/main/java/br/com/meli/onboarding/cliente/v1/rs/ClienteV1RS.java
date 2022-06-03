package br.com.meli.onboarding.cliente.v1.rs;

import br.com.meli.onboarding.cliente.service.IClienteService;
import com.mercadopago.resources.customer.CustomerCard;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "v1/cliente", tags = "Cliente")
@RequestMapping("v1/cliente")
public class ClienteV1RS {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "/listar-cartoes", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerCard>> listarCartoes(@RequestParam String email) {
        return new ResponseEntity<>(clienteService.listarCartoes(email), HttpStatus.OK);
    }
}
