package br.com.meli.onboarding.commons.exception;

import br.com.meli.onboarding.commons.enums.EErrorCode;
import lombok.Getter;

@Getter
public class CriarPreferenciaException extends RuntimeException{

    private final String errorCode = EErrorCode.CRIAR_PREFERENCIA_EXCEPTION.getErrorCode();
    private final String message = "Erro criar preferencia";
}
