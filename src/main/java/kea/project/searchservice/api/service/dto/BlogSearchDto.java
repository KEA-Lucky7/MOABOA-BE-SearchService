package kea.project.searchservice.api.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogSearchDto {
    private String value;
    private Integer limit;
    private Integer page;

    @Builder
    public BlogSearchDto(String value, Integer limit, Integer page) {
        this.value = value;
        this.limit = limit;
        this.page = page;
    }
    public static BlogSearchDto of(String value, Integer limit, Integer page) {
        return BlogSearchDto.builder()
                .value(value)
                .limit(limit)
                .page(page)
                .build();
    }
}
