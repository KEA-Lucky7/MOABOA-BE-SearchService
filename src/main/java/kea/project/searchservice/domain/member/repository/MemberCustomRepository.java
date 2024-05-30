package kea.project.searchservice.domain.member.repository;

import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberCustomRepository {
    Page<MemberSearchResponse> search(String value, Pageable pageable);
}
