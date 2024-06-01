package kea.project.searchservice.domain.post.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kea.project.searchservice.api.controller.dto.PostSearchResponse;
import kea.project.searchservice.api.controller.dto.QPostSearchResponse;
import kea.project.searchservice.api.service.dto.OrderType;
import kea.project.searchservice.api.service.dto.PostSearchDto;
import kea.project.searchservice.domain.post.vo.PostEntityState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static kea.project.searchservice.domain.member.entity.QMemberEntity.memberEntity;
import static kea.project.searchservice.domain.post.entity.QPostEntity.postEntity;
import static kea.project.searchservice.domain.post.entity.QPostLikeEntity.postLikeEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<PostSearchResponse> search(PostSearchDto dto) {
        JPAQuery<PostSearchResponse> query = jpaQueryFactory
                .select(new QPostSearchResponse(
                        postEntity.id,
                        postEntity.title,
                        postEntity.preview,
                        postEntity.createdAt,
                        postEntity.thumbnail,
                        postEntity.mainHashtag,
                        postEntity.member.nickname,
                        postEntity.mainHashtag
                ))
                .from(postEntity)
                .leftJoin(postEntity.member,memberEntity)
                .where(
                        postEntity.postState.eq(PostEntityState.ACTIVE).and(
                                postEntity.content.contains(dto.getValue()).or(postEntity.title.contains(dto.getValue())))
                )
                .offset(dto.getPage())
                .limit(dto.getSize());
        orderSpecifierAndAdditionalCondition(query, dto.getOrder());
        Long count = jpaQueryFactory
                .select(postEntity.count())
                .from(postEntity)
                .where(
                        postEntity.postState.eq(PostEntityState.ACTIVE).and(
                                postEntity.content.contains(dto.getValue()).and(postEntity.title.contains(dto.getValue())))
                )
                .fetchOne();
        Pageable pageable = Pageable.ofSize(dto.getSize());
        return new PageImpl<>(query.fetch(), pageable, Objects.requireNonNullElse(count, 0L));
    }

    private void orderSpecifierAndAdditionalCondition(JPAQuery<PostSearchResponse> query, OrderType orderType) {
        if (orderType.equals(OrderType.latestASC)) {
            query.orderBy(postEntity.updatedAt.desc());
        } else if (orderType.equals(OrderType.likeDESC)) {
            query.leftJoin(postLikeEntity).on(postLikeEntity.post.id.eq(postEntity.id))
                    .groupBy(postEntity.id)
                    .orderBy(postLikeEntity.count().desc());
        }
    }
}
