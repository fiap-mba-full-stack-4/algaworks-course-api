package com.algaworks.courseapi.core.mapper;

import com.algaworks.courseapi.core.entity.Content;
import com.algaworks.courseapi.entrypoint.request.CreateContentRequest;
import com.algaworks.courseapi.entrypoint.response.ContentResponse;
import org.springframework.stereotype.Service;

@Service
public class ContentMapper {

    public Content toContent(final CreateContentRequest createContentRequest) {
        return Content.builder()
                .description(createContentRequest.getDescription())
                .build();
    }

    public ContentResponse toResponse(final Content content) {
        return ContentResponse.builder()
                .description(content.getDescription())
                .build();
    }
}
