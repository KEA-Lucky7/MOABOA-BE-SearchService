package kea.project.searchservice.api.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogSearchDto {
    private String value;
    private Integer size;
    private Integer page;

    @Builder
    public BlogSearchDto(String value, Integer size, Integer page) {
        this.value = value;
        this.size = size;
        this.page = page;
    }
    public static BlogSearchDto of(String value, Integer size, Integer page) {
        return BlogSearchDto.builder()
                .value(value)
                .size(size)
                .page(page)
                .build();
    }
}
