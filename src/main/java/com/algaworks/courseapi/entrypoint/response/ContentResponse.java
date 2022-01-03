package com.algaworks.courseapi.entrypoint.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("descricao")
    private String description;
}
