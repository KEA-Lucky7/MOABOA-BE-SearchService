package kea.project.searchservice.api.service;

import kea.project.searchservice.domain.blog.repository.BlogCustomRepository;
import kea.project.searchservice.domain.member.repository.MemberCustomRepository;
import kea.project.searchservice.domain.post.repository.PostCustomRepository;
import kea.project.searchservice.domain.post.repository.PostCustomRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void test(){
        String test = postCustomRepository.getTest();
    }
}
