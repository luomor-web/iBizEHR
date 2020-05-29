package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[PcmYpzjkxxDTO]
 */
@Data
public class PcmYpzjkxxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CADIDATEID]
     *
     */
    @JSONField(name = "cadidateid")
    @JsonProperty("cadidateid")
    private String cadidateid;

    /**
     * 属性 [APPLICANTID]
     *
     */
    @JSONField(name = "applicantid")
    @JsonProperty("applicantid")
    private Integer applicantid;

    /**
     * 属性 [TESTRESULTS]
     *
     */
    @JSONField(name = "testresults")
    @JsonProperty("testresults")
    private String testresults;

    /**
     * 属性 [EDUCATIONEXPERIENCE]
     *
     */
    @JSONField(name = "educationexperience")
    @JsonProperty("educationexperience")
    private String educationexperience;

    /**
     * 属性 [PCMYPZJKXXID]
     *
     */
    @JSONField(name = "pcmypzjkxxid")
    @JsonProperty("pcmypzjkxxid")
    private String pcmypzjkxxid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PRACTICEEXPERIENCE]
     *
     */
    @JSONField(name = "practiceexperience")
    @JsonProperty("practiceexperience")
    private String practiceexperience;

    /**
     * 属性 [PCMYPZJKXXNAME]
     *
     */
    @JSONField(name = "pcmypzjkxxname")
    @JsonProperty("pcmypzjkxxname")
    private String pcmypzjkxxname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [INTERVIEWSUMMARIES]
     *
     */
    @JSONField(name = "interviewsummaries")
    @JsonProperty("interviewsummaries")
    private String interviewsummaries;

    /**
     * 属性 [SCHOOLOFFICE]
     *
     */
    @JSONField(name = "schooloffice")
    @JsonProperty("schooloffice")
    private String schooloffice;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [AWARDSWONS]
     *
     */
    @JSONField(name = "awardswons")
    @JsonProperty("awardswons")
    private String awardswons;

    /**
     * 属性 [PROFILE]
     *
     */
    @JSONField(name = "profile")
    @JsonProperty("profile")
    private String profile;


    /**
     * 设置 [CADIDATEID]
     */
    public void setCadidateid(String  cadidateid){
        this.cadidateid = cadidateid ;
        this.modify("cadidateid",cadidateid);
    }

    /**
     * 设置 [APPLICANTID]
     */
    public void setApplicantid(Integer  applicantid){
        this.applicantid = applicantid ;
        this.modify("applicantid",applicantid);
    }

    /**
     * 设置 [TESTRESULTS]
     */
    public void setTestresults(String  testresults){
        this.testresults = testresults ;
        this.modify("testresults",testresults);
    }

    /**
     * 设置 [EDUCATIONEXPERIENCE]
     */
    public void setEducationexperience(String  educationexperience){
        this.educationexperience = educationexperience ;
        this.modify("educationexperience",educationexperience);
    }

    /**
     * 设置 [PRACTICEEXPERIENCE]
     */
    public void setPracticeexperience(String  practiceexperience){
        this.practiceexperience = practiceexperience ;
        this.modify("practiceexperience",practiceexperience);
    }

    /**
     * 设置 [PCMYPZJKXXNAME]
     */
    public void setPcmypzjkxxname(String  pcmypzjkxxname){
        this.pcmypzjkxxname = pcmypzjkxxname ;
        this.modify("pcmypzjkxxname",pcmypzjkxxname);
    }

    /**
     * 设置 [INTERVIEWSUMMARIES]
     */
    public void setInterviewsummaries(String  interviewsummaries){
        this.interviewsummaries = interviewsummaries ;
        this.modify("interviewsummaries",interviewsummaries);
    }

    /**
     * 设置 [SCHOOLOFFICE]
     */
    public void setSchooloffice(String  schooloffice){
        this.schooloffice = schooloffice ;
        this.modify("schooloffice",schooloffice);
    }

    /**
     * 设置 [AWARDSWONS]
     */
    public void setAwardswons(String  awardswons){
        this.awardswons = awardswons ;
        this.modify("awardswons",awardswons);
    }

    /**
     * 设置 [PROFILE]
     */
    public void setProfile(String  profile){
        this.profile = profile ;
        this.modify("profile",profile);
    }


}

