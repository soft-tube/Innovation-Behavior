package com.inovationbehavior.backend.provider;

import com.inovationbehavior.backend.entity.economic.Article;
import com.inovationbehavior.backend.provider.ArticleSqlProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleSqlProviderTest {

    private ArticleSqlProvider sqlProvider;
    private Article article;

    @Before
    public void setUp() {
        sqlProvider = new ArticleSqlProvider();
        article = new Article();
        article.set_id(1L); // Correct type for ID used in your entity
    }

    @Test
    public void testUpdateSql_AllFieldsProvided() {
        article.setType("news");
        article.setTitle_en("English Title");
        article.setTitle_zn("Chinese Title");
        article.setAbstract_en("English Abstract");
        article.setAbstract_zn("Chinese Abstract");
        article.setAbstract_de("German Abstract");
        article.setUrl("http://example.com");

        String expectedSql = "UPDATE article\nSET type = #{article.type}, title_en = #{article.title_en}, title_zn = #{article.title_zn}, abstract_en = #{article.abstract_en}, abstract_zn = #{article.abstract_zn}, abstract_de = #{article.abstract_de}, url = #{article.url}\nWHERE (_id = #{article._id})";
        assertEquals(expectedSql, sqlProvider.updateArticleSql(article));
    }

    @Test
    public void testUpdateSql_SomeFieldsNull() {
        article.setType("news");
        article.setTitle_en(null);
        article.setTitle_zn("Chinese Title");
        article.setAbstract_en(null);
        article.setAbstract_zn(null);
        article.setAbstract_de("German Abstract");
        article.setUrl("http://example.com");

        String expectedSql = "UPDATE article\nSET type = #{article.type}, title_zn = #{article.title_zn}, abstract_de = #{article.abstract_de}, url = #{article.url}\nWHERE (_id = #{article._id})";
        assertEquals(expectedSql, sqlProvider.updateArticleSql(article));
    }

    @Test
    public void testUpdateSql_NoFieldsProvided() {
        String expectedSql = "UPDATE article\nWHERE (_id = #{article._id})";
        assertEquals(expectedSql, sqlProvider.updateArticleSql(article));
    }
}
