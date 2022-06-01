package br.com.meli.onboarding.commons.enums;

public enum EPaymentMethod {
    VISA("visa"),
    PIX("pix"),

    BOLETO("bolbradesco");

    private String value;

    EPaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
