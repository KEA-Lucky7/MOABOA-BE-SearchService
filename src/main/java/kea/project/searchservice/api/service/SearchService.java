package kea.project.searchservice.api.service;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import org.springframework.data.domain.Page;

public interface SearchService {

    Page<BlogSearchResponse> blogSearch(BlogSearchDto of);
}
