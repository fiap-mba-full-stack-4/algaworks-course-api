package com.algaworks.courseapi.entrypoint.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateContentRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("descricao")
    private String description;
}
