package br.com.meli.onboarding.commons.enums;

public enum EErrorCode {
    INTEGRACAO_MERCADO_PAGO_EXCEPTION("E10001"),
    CRIAR_PREFERENCIA_EXCEPTION("E10002"),
    CRIAR_PAGAMENTO_EXCEPTION("E10003"),
    LISTAR_MEIOS_PAGAMENTO_EXCEPTION("E10004");

    private String errorCode;

    EErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
