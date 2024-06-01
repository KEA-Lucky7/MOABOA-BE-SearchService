package kea.project.searchservice.domain.post.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.blog.entity.BlogEntity;
import kea.project.searchservice.domain.member.entity.MemberEntity;
import kea.project.searchservice.domain.post.vo.PostEntityState;
import kea.project.searchservice.domain.post.vo.PostEntityType;
import kea.project.searchservice.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private BlogEntity blog;

    @Column(name = "post_type")
    @Enumerated(EnumType.STRING)
    private PostEntityType postEntityType;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "preview")
    private String preview;

    @Column(name = "thumbnail")
    @Lob
    private String thumbnail;

    @Column(name = "main_hashtag")
    private String mainHashtag;

    @Column(name = "post_state")
    @Enumerated(EnumType.STRING)
    private PostEntityState postState;

    @Builder
    public PostEntity(MemberEntity member, BlogEntity blog, PostEntityType postEntityType, String title, String content, String preview, String thumbnail, String mainHashtag, PostEntityState postState) {
        this.member = member;
        this.blog = blog;
        this.postEntityType = postEntityType;
        this.title = title;
        this.content = content;
        this.preview = preview;
        this.thumbnail = thumbnail;
        this.mainHashtag = mainHashtag;
        this.postState = postState;
    }
    public static PostEntity of(MemberEntity member, BlogEntity blog, PostEntityType postEntityType, String title, String content, String preview, String thumbnail, String mainHashtag, PostEntityState postState) {
        return PostEntity.builder()
                .member(member)
                .blog(blog)
                .postEntityType(postEntityType)
                .title(title)
                .content(content)
                .preview(preview)
                .thumbnail(thumbnail)
                .mainHashtag(mainHashtag)
                .postState(postState)
                .build();
    }
}
