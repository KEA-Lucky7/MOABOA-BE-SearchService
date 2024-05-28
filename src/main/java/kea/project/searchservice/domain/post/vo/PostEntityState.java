package kea.project.searchservice.domain.post.vo;

import lombok.Getter;

@Getter
public enum PostEntityState {
    ACTIVE("활동"), TEMPORARY("임시"), DELETE("삭제");

    private final String name;

    PostEntityState(String name) {
        this.name = name;
    }
}
