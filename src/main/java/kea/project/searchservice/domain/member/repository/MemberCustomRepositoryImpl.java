package kea.project.searchservice.domain.member.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.controller.dto.QMemberSearchResponse;
import kea.project.searchservice.domain.member.vo.MemberEntityRole;
import kea.project.searchservice.domain.member.vo.MemberEntityState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static kea.project.searchservice.domain.blog.entity.QBlogEntity.blogEntity;
import static kea.project.searchservice.domain.member.entity.QMemberEntity.memberEntity;
import static kea.project.searchservice.domain.post.entity.QPostEntity.postEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<MemberSearchResponse> search(String value, Pageable pageable) {
        JPAQuery<MemberSearchResponse> query = jpaQueryFactory.
                select(new QMemberSearchResponse(
                        memberEntity.id,
                        memberEntity.blog.id,
                        memberEntity.nickname,
                        memberEntity.about,
                        memberEntity.profileImage
                ))
                .from(memberEntity)
                .leftJoin(memberEntity.blog,blogEntity)
                .where(
                        memberEntity.memberEntityState.eq(MemberEntityState.ACTIVE).and(
                                memberEntity.nickname.contains(value)).and(memberEntity.memberEntityRole.eq(MemberEntityRole.MEMBER))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(new OrderSpecifier<>(Order.DESC, memberEntity.updatedAt));
        Long count = jpaQueryFactory
                .select(memberEntity.count())
                .from(memberEntity)
                .leftJoin(memberEntity.blog,blogEntity)
                .where(
                        memberEntity.memberEntityState.eq(MemberEntityState.ACTIVE).and(
                                        memberEntity.nickname.contains(value))
                )
                .fetchOne();
        return new PageImpl<>(query.fetch(), pageable, Objects.requireNonNullElse(count, 0L));
    }
}
