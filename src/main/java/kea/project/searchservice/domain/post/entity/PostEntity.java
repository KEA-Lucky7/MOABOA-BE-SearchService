package kea.project.searchservice.domain.post.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.post.vo.PostEntityState;
import kea.project.searchservice.domain.post.vo.PostEntityType;
import kea.project.searchservice.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "POST")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostEntity extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="member_id")
    private Long memberId;

    @Column(name="blog_id")
    private Long blogId;

    @Column(name="post_type")
    @Enumerated(EnumType.STRING)
    private PostEntityType postEntityType;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="main_hashtah")
    private String mainHashtag;

    @Column(name="post_state")
    @Enumerated(EnumType.STRING)
    private PostEntityState postState;
}
