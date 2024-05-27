package kea.project.searchservice.domain.member.entity;

import jakarta.persistence.*;
import kea.project.searchservice.domain.member.vo.MemberEntityState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity()
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "about")
    private String about;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "social_id")
    private String socialId;

    @Column(name = "social_type")
    private String socialType;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private MemberEntityState memberEntityState;
}
