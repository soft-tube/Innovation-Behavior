package com.inovationbehavior.backend.entity.economic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleList {

    List<Article> lists;
    Long count;
}
