package kea.project.searchservice.api.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostSearchDto {
    private String value;
    private Integer size;
    private Integer page;
    private OrderType order;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public PostSearchDto(String value, Integer size, Integer page, OrderType order, LocalDate startDate, LocalDate endDate) {
        this.value = value;
        this.size = size;
        this.page = page;
        this.order = order;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public static PostSearchDto of(String value, Integer size, Integer page, OrderType order, LocalDate startDate, LocalDate endDate) {
        return PostSearchDto.builder()
                .value(value)
                .size(size)
                .page(page)
                .order(order)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
