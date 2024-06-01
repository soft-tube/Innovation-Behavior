package com.inovationbehavior.backend.model.PO.economic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPO {
    Long _id;
    String name_en;
    String name_zn;
    String name_de;
    Long article_id;
}
