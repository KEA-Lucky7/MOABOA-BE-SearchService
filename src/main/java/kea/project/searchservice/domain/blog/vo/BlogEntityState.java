package kea.project.searchservice.domain.blog.vo;

import lombok.Getter;

@Getter
public enum BlogEntityState {
    ACTIVE("활동"), DELETE("삭제");

    private final String name;

    BlogEntityState(String name) {
        this.name = name;
    }
}
