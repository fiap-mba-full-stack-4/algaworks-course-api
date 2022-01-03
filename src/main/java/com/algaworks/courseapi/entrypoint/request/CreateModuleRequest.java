package com.algaworks.courseapi.entrypoint.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateModuleRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("carga_horaria")
    private String workload;

    @JsonProperty("conteudos")
    private List<CreateContentRequest> contents;
}
