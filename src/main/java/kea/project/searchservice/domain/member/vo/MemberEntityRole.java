package kea.project.searchservice.domain.member.vo;

import lombok.Getter;

@Getter
public enum MemberEntityRole {
    GUEST("게스트"),
    MEMBER("멤버");
    private final String name;

    MemberEntityRole(String name) {
        this.name = name;
    }
}
