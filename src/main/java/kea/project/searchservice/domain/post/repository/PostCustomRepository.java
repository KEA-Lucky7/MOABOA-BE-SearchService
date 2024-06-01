package kea.project.searchservice.domain.post.repository;

import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.controller.dto.PostSearchResponse;
import kea.project.searchservice.api.service.dto.PostSearchDto;
import org.springframework.data.domain.Page;

public interface PostCustomRepository {

    Page<PostSearchResponse> search(PostSearchDto dto);
}
