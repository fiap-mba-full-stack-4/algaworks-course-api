package com.algaworks.courseapi.entrypoint.request;

import java.util.List;

import com.algaworks.courseapi.core.enums.CourseLevelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateCourseRequest {

    @JsonProperty("nivel")
    private CourseLevelEnum level;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("preco_original")
    private Double originalPrice;

    @JsonProperty("preco_promocional")
    private Double promotionalPrice;

    @JsonProperty("porc_desconto")
    private Double percentageDiscount;

    @JsonProperty("url_imagem")
    private String imageUrl;

    @JsonProperty("modulos")
    private List<CreateModuleRequest> modules;
}
