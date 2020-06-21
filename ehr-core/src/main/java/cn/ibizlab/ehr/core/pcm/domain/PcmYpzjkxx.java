package cn.ibizlab.ehr.core.pcm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[应聘者接口信息管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYPZJKXX",resultMap = "PcmYpzjkxxResultMap")
public class PcmYpzjkxx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应聘者编号
     */
    @TableField(value = "cadidateid")
    @JSONField(name = "cadidateid")
    @JsonProperty("cadidateid")
    private String cadidateid;
    /**
     * 应聘者ID
     */
    @TableField(value = "applicantid")
    @JSONField(name = "applicantid")
    @JsonProperty("applicantid")
    private Integer applicantid;
    /**
     * 测评结果摘要信息
     */
    @TableField(value = "testresults")
    @JSONField(name = "testresults")
    @JsonProperty("testresults")
    private String testresults;
    /**
     * 教育经历
     */
    @TableField(value = "educationexperience")
    @JSONField(name = "educationexperience")
    @JsonProperty("educationexperience")
    private String educationexperience;
    /**
     * 应聘者标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmypzjkxxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmypzjkxxid")
    @JsonProperty("pcmypzjkxxid")
    private String pcmypzjkxxid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 实习经验
     */
    @TableField(value = "practiceexperience")
    @JSONField(name = "practiceexperience")
    @JsonProperty("practiceexperience")
    private String practiceexperience;
    /**
     * 应聘者接口信息管理名称
     */
    @TableField(value = "pcmypzjkxxname")
    @JSONField(name = "pcmypzjkxxname")
    @JsonProperty("pcmypzjkxxname")
    private String pcmypzjkxxname;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 面试评价信息
     */
    @TableField(value = "interviewsummaries")
    @JSONField(name = "interviewsummaries")
    @JsonProperty("interviewsummaries")
    private String interviewsummaries;
    /**
     * 在校职务
     */
    @TableField(value = "schooloffice")
    @JSONField(name = "schooloffice")
    @JsonProperty("schooloffice")
    private String schooloffice;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 获奖情况
     */
    @TableField(value = "awardswons")
    @JSONField(name = "awardswons")
    @JsonProperty("awardswons")
    private String awardswons;
    /**
     * 应聘者基本信息
     */
    @TableField(value = "profile")
    @JSONField(name = "profile")
    @JsonProperty("profile")
    private String profile;



    /**
     * 设置 [应聘者编号]
     */
    public void setCadidateid(String cadidateid){
        this.cadidateid = cadidateid ;
        this.modify("cadidateid",cadidateid);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setApplicantid(Integer applicantid){
        this.applicantid = applicantid ;
        this.modify("applicantid",applicantid);
    }

    /**
     * 设置 [测评结果摘要信息]
     */
    public void setTestresults(String testresults){
        this.testresults = testresults ;
        this.modify("testresults",testresults);
    }

    /**
     * 设置 [教育经历]
     */
    public void setEducationexperience(String educationexperience){
        this.educationexperience = educationexperience ;
        this.modify("educationexperience",educationexperience);
    }

    /**
     * 设置 [实习经验]
     */
    public void setPracticeexperience(String practiceexperience){
        this.practiceexperience = practiceexperience ;
        this.modify("practiceexperience",practiceexperience);
    }

    /**
     * 设置 [应聘者接口信息管理名称]
     */
    public void setPcmypzjkxxname(String pcmypzjkxxname){
        this.pcmypzjkxxname = pcmypzjkxxname ;
        this.modify("pcmypzjkxxname",pcmypzjkxxname);
    }

    /**
     * 设置 [面试评价信息]
     */
    public void setInterviewsummaries(String interviewsummaries){
        this.interviewsummaries = interviewsummaries ;
        this.modify("interviewsummaries",interviewsummaries);
    }

    /**
     * 设置 [在校职务]
     */
    public void setSchooloffice(String schooloffice){
        this.schooloffice = schooloffice ;
        this.modify("schooloffice",schooloffice);
    }

    /**
     * 设置 [获奖情况]
     */
    public void setAwardswons(String awardswons){
        this.awardswons = awardswons ;
        this.modify("awardswons",awardswons);
    }

    /**
     * 设置 [应聘者基本信息]
     */
    public void setProfile(String profile){
        this.profile = profile ;
        this.modify("profile",profile);
    }


}


