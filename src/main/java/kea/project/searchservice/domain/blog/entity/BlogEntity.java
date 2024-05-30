package kea.project.searchservice.domain.blog.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.blog.vo.BlogEntityState;
import kea.project.searchservice.domain.member.entity.MemberEntity;
import kea.project.searchservice.global.common.entity.BaseEntity;
import lombok.*;

@Entity()
@Table(name = "BLOG")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BlogEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;

    @Column(name = "about")
    private String about;

    @Column(name = "name")
    private String name;

    @Column(name = "header_image")
    private String headerImage;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private BlogEntityState blogEntityState;

    @Builder
    public BlogEntity(MemberEntity member, String about, String name, String headerImage, BlogEntityState blogEntityState) {
        this.member = member;
        this.about = about;
        this.name = name;
        this.headerImage = headerImage;
        this.blogEntityState = blogEntityState;
    }
    public static BlogEntity of(MemberEntity member, String about, String name, String headerImage,BlogEntityState blogEntityState) {
        return BlogEntity.builder()
                .member(member)
                .about(about)
                .name(name)
                .headerImage(headerImage)
                .blogEntityState(blogEntityState)
                .build();
    }

    public BlogEntity updateName(String blogName) {
        this.name = blogName;
        return null;
    }
}
