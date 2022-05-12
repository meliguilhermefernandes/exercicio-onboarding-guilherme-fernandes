package br.com.meli.onboarding.preferencia.v1.rs.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPreferenciaDTO {

    @JsonProperty
    @ApiModelProperty(example = "Titulo")
    private String title;

    @JsonProperty
    @ApiModelProperty(example = "Descricao")
    private String description;

    @JsonProperty("picture_url")
    @ApiModelProperty(example = "http://urlimage")
    private String pictureUrl;

    @JsonProperty("category_id")
    private String categoryId;

    @NotNull
    @JsonProperty
    private Integer quantity;

    @JsonProperty("currency_id")
    private String currencyId;

    @NotNull
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;
}
