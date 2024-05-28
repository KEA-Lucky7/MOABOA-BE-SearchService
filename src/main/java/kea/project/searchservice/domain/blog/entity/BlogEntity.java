package kea.project.searchservice.domain.blog.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.blog.vo.BlogEntityState;
import kea.project.searchservice.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Table(name = "BLOG")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BlogEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "about")
    private String about;

    @Column(name = "name")
    private String name;

    @Column(name = "header_image")
    private String headerImage;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private BlogEntityState blogEntityState;
}
