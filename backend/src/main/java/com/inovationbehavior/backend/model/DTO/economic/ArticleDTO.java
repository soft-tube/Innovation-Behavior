package com.inovationbehavior.backend.model.DTO.economic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用文章类
 * 用于存储仅需要标题、作者、概要和外链的文章信息。
 *
 * @author litianlololo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    Long _id;
    String title_en;
    String title_zn;
    String title_de;
    String abstract_en;
    String abstract_zn;
    String abstract_de;
    String url;
    String type;
    List<AuthorDTO> authors;
}
