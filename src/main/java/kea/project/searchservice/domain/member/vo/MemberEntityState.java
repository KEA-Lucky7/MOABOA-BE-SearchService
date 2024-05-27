package kea.project.searchservice.domain.member.vo;

import lombok.Getter;

@Getter
public enum MemberEntityState {
    ACTIVE("활동"), DELETE("삭제");

    private final String name;

    MemberEntityState(String name) {
        this.name = name;
    }
}
