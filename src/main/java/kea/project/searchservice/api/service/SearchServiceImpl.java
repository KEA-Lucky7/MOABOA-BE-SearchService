package kea.project.searchservice.api.service;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import kea.project.searchservice.api.service.dto.MemberSearchDto;
import kea.project.searchservice.domain.blog.repository.BlogCustomRepository;
import kea.project.searchservice.domain.blog.repository.BlogJPARepository;
import kea.project.searchservice.domain.member.repository.MemberCustomRepository;
import kea.project.searchservice.domain.post.repository.PostCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {
    private final PostCustomRepository postCustomRepository;
    private final MemberCustomRepository memberCustomRepository;
    private final BlogCustomRepository blogCustomRepository;
    private final BlogJPARepository blogJPARepository;

    @Override
    public Page<BlogSearchResponse> blogSearch(BlogSearchDto dto) {
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by(Sort.Direction.DESC, "updated_at"));
        return blogCustomRepository.search(dto.getValue(), pageable);
    }

    @Override
    public Page<MemberSearchResponse> memberSearch(MemberSearchDto dto) {
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by(Sort.Direction.DESC, "updated_at"));
        return memberCustomRepository.search(dto.getValue(), pageable);
    }
}
