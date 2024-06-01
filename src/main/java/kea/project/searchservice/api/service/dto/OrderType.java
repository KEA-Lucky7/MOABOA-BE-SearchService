package kea.project.searchservice.api.service.dto;

import com.querydsl.core.types.Order;
import lombok.Getter;

@Getter
public enum OrderType {
    latestASC("최신순", "updated_at", Order.ASC),
    likeDESC("인기순", "like_count", Order.DESC);

    private final String name;
    private final String type;
    private final Order order;

    OrderType(String name, String type, Order order) {
        this.name = name;
        this.type = type;
        this.order = order;
    }
}
