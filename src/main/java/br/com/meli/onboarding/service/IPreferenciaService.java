package br.com.meli.onboarding.service;

import br.com.meli.onboarding.v1.rs.request.PreferenciaRequestDTO;
import br.com.meli.onboarding.v1.rs.response.PreferenciaResponseDTO;

public interface IPreferenciaService {

    String criar(PreferenciaRequestDTO preferenciaRequestDTO);
}
