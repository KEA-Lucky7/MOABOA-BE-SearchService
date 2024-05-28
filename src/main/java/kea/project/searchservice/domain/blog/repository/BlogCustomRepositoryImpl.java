package kea.project.searchservice.domain.blog.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BlogCustomRepositoryImpl implements BlogCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

}
