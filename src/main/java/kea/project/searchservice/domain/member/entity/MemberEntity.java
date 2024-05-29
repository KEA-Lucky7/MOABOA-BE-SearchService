package kea.project.searchservice.domain.member.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import kea.project.searchservice.domain.member.vo.MemberEntityState;
import kea.project.searchservice.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity()
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberEntity extends BaseEntity {
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

    @Builder
    public MemberEntity(LocalDate birth, String about, String nickname, String profileImage, String socialId, String socialType, MemberEntityState memberEntityState) {
        this.birth = birth;
        this.about = about;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.socialId = socialId;
        this.socialType = socialType;
        this.memberEntityState = memberEntityState;
    }

    public static MemberEntity of(LocalDate birth, String about, String nickname, String profileImage, String socialId, String socialType) {
        return  MemberEntity.builder()
                .birth(birth)
                .about(about)
                .nickname(nickname)
                .profileImage(profileImage)
                .socialId(socialId)
                .socialType(socialType)
                .build();
    }
}
