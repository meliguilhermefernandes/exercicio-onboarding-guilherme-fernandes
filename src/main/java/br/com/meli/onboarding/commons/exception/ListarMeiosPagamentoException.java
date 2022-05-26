package br.com.meli.onboarding.commons.exception;

import br.com.meli.onboarding.commons.enums.EErrorCode;
import lombok.Getter;

@Getter
public class ListarMeiosPagamentoException extends RuntimeException{

    private final String errorCode = EErrorCode.LISTAR_MEIOS_PAGAMENTO_EXCEPTION.getErrorCode();
    private final String message = "Erro listar meios de pagamento";
}
