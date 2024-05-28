package kea.project.searchservice;

import kea.project.searchservice.api.service.SearchService;
import kea.project.searchservice.domain.blog.repository.BlogCustomRepository;
import kea.project.searchservice.domain.blog.repository.BlogJPARepository;
import kea.project.searchservice.domain.member.repository.MemberCustomRepository;
import kea.project.searchservice.domain.member.repository.MemberJPARepository;
import kea.project.searchservice.domain.post.repository.PostCustomRepository;
import kea.project.searchservice.domain.post.repository.PostJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class IntegrationTestSupport {

    @Autowired
    protected SearchService searchService;

    @Autowired
    protected BlogJPARepository blogJPARepository;

    @Autowired
    protected BlogCustomRepository blogCustomRepository;

    @Autowired
    protected PostJPARepository postJPARepository;

    @Autowired
    protected PostCustomRepository postCustomRepository;

    @Autowired
    protected MemberJPARepository memberJPARepository;

    @Autowired
    protected MemberCustomRepository memberCustomRepository;

    @AfterEach
    void tearDown() {
        blogJPARepository.deleteAllInBatch();
        postJPARepository.deleteAllInBatch();
        memberJPARepository.deleteAllInBatch();
    }
}
