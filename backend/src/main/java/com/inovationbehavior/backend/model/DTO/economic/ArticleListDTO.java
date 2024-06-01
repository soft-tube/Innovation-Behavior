package com.inovationbehavior.backend.model.DTO.economic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListDTO {

    List<ArticleDTO> lists;
    Long count;
}
