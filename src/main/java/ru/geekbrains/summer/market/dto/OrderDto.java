package ru.geekbrains.summer.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.Product;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private BigDecimal price;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
    }
}
