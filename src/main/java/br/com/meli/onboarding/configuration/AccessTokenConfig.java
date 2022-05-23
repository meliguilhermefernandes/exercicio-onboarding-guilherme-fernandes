package br.com.meli.onboarding.configuration;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessTokenConfig {

    @Value("${mercadolivre.user.access.token}")
    private String acessToken;

    @Bean
    public void loadAccessToken() {
        MercadoPagoConfig.setAccessToken(acessToken);
    }
}
