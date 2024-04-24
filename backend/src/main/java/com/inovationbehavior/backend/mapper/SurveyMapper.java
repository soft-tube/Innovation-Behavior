package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface SurveyMapper {
    @Insert("insert into survey (patent_no, identification, enterprise, value) values (#{patentNo},#{identification},#{evaluate},#{value})")
    void postSurvey(Survey survey);

    @Insert("INSERT INTO survey (patent_no, identification,invitationCode ,time) \n" +
            "VALUES (#{patentNo}, #{identification},#{invitationCode}, #{time} ) \n" +
            "ON DUPLICATE KEY UPDATE identification = VALUES(identification), time = VALUES(time);")
    void postIdentification(String patentNo, String identification,String invitationCode, LocalDateTime time);

    @Insert("INSERT INTO survey (patent_no, enterprise,invitationCode ,time) \n" +
            "VALUES (#{patentNo}, #{enterprise},#{invitationCode}, #{time}) \n" +
            "ON DUPLICATE KEY UPDATE enterprise = VALUES(enterprise), time = VALUES(time);")
    void postEnterprise(String patentNo, String enterprise,String invitationCode, LocalDateTime time);

    @Insert("INSERT INTO survey (patent_no, value,invitationCode, time) \n" +
            "VALUES (#{patentNo}, #{value},#{invitationCode}, #{time}) \n" +
            "ON DUPLICATE KEY UPDATE value = VALUES(value), time = VALUES(time);")
    void postValue(String patentNo, String value,String invitationCode, LocalDateTime time);

    @Insert("INSERT INTO survey (patent_no, `use`,invitationCode, time) \n" +
            "VALUES (#{patentNo}, #{use},#{invitationCode}, #{time}) \n" +
            "ON DUPLICATE KEY UPDATE `use` = VALUES(`use`), time = VALUES(time);")
    void postUsage(String patentNo, String use,String invitationCode, LocalDateTime time);


    @Insert("INSERT INTO survey (patent_no, policy,invitationCode, time) \n" +
            "VALUES (#{patentNo}, #{policy},#{invitationCode}, #{time}) \n" +
            "ON DUPLICATE KEY UPDATE policy = VALUES(policy), time = VALUES(time);")
    void postPolicy(String patentNo, String policy,String invitationCode, LocalDateTime time);

    @Insert("INSERT INTO survey (patent_no, award, address) " +
            "VALUES (#{patentNo}, #{award}, #{address}) " +
            "ON DUPLICATE KEY UPDATE award = IFNULL(award, VALUES(award)), address = VALUES(address);")
    int postAwardInfo(String patentNo, String award, String address);

    @Select("SELECT COUNT(*) FROM survey WHERE patent_no = #{patentNo} AND award IS NOT NULL")
    int checkAward(String patentNo);
}
