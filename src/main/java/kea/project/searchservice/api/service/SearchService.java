package kea.project.searchservice.api.service;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.controller.dto.PostSearchResponse;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import kea.project.searchservice.api.service.dto.MemberSearchDto;
import kea.project.searchservice.api.service.dto.PostSearchDto;
import org.springframework.data.domain.Page;

public interface SearchService {

    Page<BlogSearchResponse> blogSearch(BlogSearchDto of);

    Page<MemberSearchResponse> memberSearch(MemberSearchDto of);

    Page<PostSearchResponse> postSearch(PostSearchDto of);
}
