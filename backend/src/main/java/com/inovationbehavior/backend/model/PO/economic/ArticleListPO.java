package com.inovationbehavior.backend.model.PO.economic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListPO {

    List<ArticlePO> lists;
    Long count;
}
