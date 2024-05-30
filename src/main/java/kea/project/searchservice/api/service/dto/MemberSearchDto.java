package kea.project.searchservice.api.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSearchDto {
    private String value;
    private Integer size;
    private Integer page;

    @Builder
    public MemberSearchDto(String value, Integer size, Integer page) {
        this.value = value;
        this.size = size;
        this.page = page;
    }
    public static MemberSearchDto of(String value, Integer size, Integer page) {
        return MemberSearchDto.builder()
                .value(value)
                .size(size)
                .page(page)
                .build();
    }
}
