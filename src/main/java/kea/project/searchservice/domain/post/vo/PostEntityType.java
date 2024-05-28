package kea.project.searchservice.domain.post.vo;

import lombok.Getter;

@Getter
public enum PostEntityType {
    FREE("자유글"), WALLET("가계부");

    private final String name;

    PostEntityType(String name) {
        this.name = name;
    }
}
