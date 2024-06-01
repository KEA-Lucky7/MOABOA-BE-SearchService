package kea.project.searchservice.domain.post.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.member.entity.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "POST_LIKE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostLikeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public PostLikeEntity(MemberEntity member, PostEntity post) {
        this.member = member;
        this.post = post;
    }

    public static PostLikeEntity of(MemberEntity member, PostEntity post) {
        return PostLikeEntity.builder()
                .member(member)
                .post(post)
                .build();
    }
}
