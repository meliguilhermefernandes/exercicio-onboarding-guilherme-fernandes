package br.com.meli.onboarding.preferencia.service;

import br.com.meli.onboarding.preferencia.v1.rs.request.PreferenciaRequestDTO;

public interface IPreferenciaService {

    String criar(PreferenciaRequestDTO preferenciaRequestDTO);
}
