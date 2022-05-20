package br.com.meli.onboarding.preferencia.v1.rs;

import br.com.meli.onboarding.preferencia.service.IPreferenciaService;
import br.com.meli.onboarding.preferencia.v1.rs.request.PreferenciaRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "v1/preferencia", tags = "Preferencia")
@RequestMapping("v1/preferencia")
public class PreferenciaV1RS {

    @Autowired
    private IPreferenciaService preferenciaService;

    @ApiOperation(value = "Criar preferencia")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> criar(@RequestBody @Valid PreferenciaRequestDTO preferenciaRequestDTO) {
        return new ResponseEntity<>(preferenciaService.criar(preferenciaRequestDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
