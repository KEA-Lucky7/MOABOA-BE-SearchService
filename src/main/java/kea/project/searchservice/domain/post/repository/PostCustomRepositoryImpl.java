package kea.project.searchservice.domain.post.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kea.project.searchservice.domain.post.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public String getTest() {
        return "";
    }
}
