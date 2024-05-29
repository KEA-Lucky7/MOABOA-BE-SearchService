package kea.project.searchservice.domain.blog.repository;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogCustomRepository {
    Page<BlogSearchResponse> search(String value, Pageable pageable);
}
