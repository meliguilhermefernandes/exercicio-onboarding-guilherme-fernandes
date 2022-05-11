package br.com.meli.onboarding.commons.exception;

import br.com.meli.onboarding.commons.enums.EErrorCode;
import lombok.Getter;

@Getter
public class MPIntegrationException extends RuntimeException{

    private final String errorCode = EErrorCode.INTEGRACAO_MERCADO_PAGO_EXCEPTION.getErrorCode();
    private final String message = "Erro integracao Mercado Pago";
}
