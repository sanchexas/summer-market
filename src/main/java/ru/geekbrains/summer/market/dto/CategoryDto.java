package ru.geekbrains.summer.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.Product;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }

}
