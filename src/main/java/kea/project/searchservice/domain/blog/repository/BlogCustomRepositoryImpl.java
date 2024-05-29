package kea.project.searchservice.domain.blog.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.QBlogSearchResponse;
import kea.project.searchservice.domain.blog.vo.BlogEntityState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static kea.project.searchservice.domain.blog.entity.QBlogEntity.blogEntity;
import static kea.project.searchservice.domain.member.entity.QMemberEntity.memberEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BlogCustomRepositoryImpl implements BlogCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<BlogSearchResponse> search(String value, Pageable pageable) {
        JPAQuery<BlogSearchResponse> query = jpaQueryFactory
                .select(new QBlogSearchResponse(
                        blogEntity.id,
                        blogEntity.name,
                        blogEntity.about,
                        blogEntity.member.nickname,
                        blogEntity.member.profileImage
                ))
                .from(blogEntity)
                .leftJoin(blogEntity.member, memberEntity)
                .where(
                        blogEntity.blogEntityState.eq(BlogEntityState.ACTIVE)
                                .and(blogEntity.name.contains(value)
                                        .or(blogEntity.about.contains(value))
                                )
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(new OrderSpecifier<>(Order.DESC, blogEntity.updatedAt));

        Long count = jpaQueryFactory
                .select(blogEntity.count())
                .from(blogEntity)
                .where(
                        blogEntity.blogEntityState.eq(BlogEntityState.ACTIVE).and
                                (blogEntity.name.contains(value).or(
                                        blogEntity.about.contains(value)))
                )
                .fetchOne();
        return new PageImpl<>(query.fetch(), pageable, Objects.requireNonNullElse(count, 0L));
    }

}
