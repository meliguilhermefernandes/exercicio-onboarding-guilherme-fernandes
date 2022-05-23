package br.com.meli.onboarding.commons.exception;

import br.com.meli.onboarding.commons.enums.EErrorCode;
import lombok.Getter;

@Getter
public class CriarPagamentoCartaoException extends RuntimeException{

    private final String errorCode = EErrorCode.CRIAR_PAGAMENTO_CARTAO_EXCEPTION.getErrorCode();
    private final String message = "Erro criar pagamento cartao";
}
