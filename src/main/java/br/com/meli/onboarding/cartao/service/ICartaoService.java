package br.com.meli.onboarding.cartao.service;

import br.com.meli.onboarding.cartao.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.preferencia.v1.rs.request.PreferenciaRequestDTO;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

public interface ICartaoService {
    String criarPagamento(PagamentoRequestDTO pagamentoRequestDTO);
}
