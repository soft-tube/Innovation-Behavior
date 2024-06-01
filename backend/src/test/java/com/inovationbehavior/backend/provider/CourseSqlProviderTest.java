package com.inovationbehavior.backend.provider;

import com.inovationbehavior.backend.entity.intelligence.Course;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseSqlProviderTest {

    private CourseSqlProvider sqlProvider;
    private Course course;

    @Before
    public void setUp() {
        sqlProvider = new CourseSqlProvider();
        course = new Course();
        course.set_id(1L);
    }

    @Test
    public void testUpdateCourseSql_AllFieldsProvided() {
        course.setType("online");
        course.setTitle_en("English Course Title");
        course.setTitle_zn("Chinese Course Title");
        course.setTitle_de("German Course Title");

        String expectedSql = "UPDATE course\nSET type = #{course.type}, title_en = #{course.title_en}, title_zn = #{course.title_zn}, title_de = #{course.title_de}\nWHERE (_id = #{course._id})";
        assertEquals(expectedSql, sqlProvider.updateCourseSql(course));
    }

    @Test
    public void testUpdateCourseSql_SomeFieldsNull() {
        course.setType("offline");
        course.setTitle_en(null);
        course.setTitle_zn("Chinese Course Title");
        course.setTitle_de(null);

        String expectedSql = "UPDATE course\nSET type = #{course.type}, title_zn = #{course.title_zn}\nWHERE (_id = #{course._id})";
        assertEquals(expectedSql, sqlProvider.updateCourseSql(course));
    }

    @Test
    public void testUpdateCourseSql_NoFieldsProvided() {
        String expectedSql = "UPDATE course\nWHERE (_id = #{course._id})";
        assertEquals(expectedSql, sqlProvider.updateCourseSql(course));
    }
}
