package br.com.meli.onboarding.v1.rs;

import br.com.meli.onboarding.service.IPreferenciaService;
import br.com.meli.onboarding.v1.rs.request.PreferenciaRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "v1/preferencia", tags = "Preferencia")
@RequestMapping("v1/preferencia")
public class PreferenciaV1RS {

    private IPreferenciaService preferenciaService;

    @ApiOperation(value = "Criar preferencia")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity criar(@RequestBody @Valid PreferenciaRequestDTO preferenciaRequestDTO) {
        return new ResponseEntity<>(preferenciaService.criar(preferenciaRequestDTO), HttpStatus.CREATED);
    }
}
