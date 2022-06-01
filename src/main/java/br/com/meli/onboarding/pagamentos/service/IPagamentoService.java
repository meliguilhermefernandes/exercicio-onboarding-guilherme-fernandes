package br.com.meli.onboarding.pagamentos.service;

import br.com.meli.onboarding.pagamentos.v1.rs.request.PagamentoRequestDTO;
import br.com.meli.onboarding.pagamentos.v1.rs.response.BoletoResponseDTO;
import br.com.meli.onboarding.pagamentos.v1.rs.response.PixResponseDTO;

public interface IPagamentoService {
    String criarPagamentoCartao(PagamentoRequestDTO pagamentoRequestDTO);

    PixResponseDTO criarPagamentoPix(PagamentoRequestDTO pagamentoRequestDTO);

    BoletoResponseDTO criarPagamentoBoleto(PagamentoRequestDTO pagamentoRequestDTO);
}
