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
 * 实体[教育背景]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMEDUCATIONEXPERIENCE",resultMap = "PcmEducationExperienceResultMap")
public class PcmEducationExperience extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业描述
     */
    @TableField(value = "majordescription")
    @JSONField(name = "majordescription")
    @JsonProperty("majordescription")
    private String majordescription;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
    /**
     * 课题研究
     */
    @TableField(value = "subjectresearch")
    @JSONField(name = "subjectresearch")
    @JsonProperty("subjectresearch")
    private String subjectresearch;
    /**
     * 培养方式
     */
    @TableField(value = "trainingmode")
    @JSONField(name = "trainingmode")
    @JsonProperty("trainingmode")
    private String trainingmode;
    /**
     * 专业类别
     */
    @TableField(value = "majorcategory")
    @JSONField(name = "majorcategory")
    @JsonProperty("majorcategory")
    private String majorcategory;
    /**
     * 教育背景名称
     */
    @TableField(value = "pcmeducationexperiencename")
    @JSONField(name = "pcmeducationexperiencename")
    @JsonProperty("pcmeducationexperiencename")
    private String pcmeducationexperiencename;
    /**
     * 学习形式
     */
    @TableField(value = "formsoflearning")
    @JSONField(name = "formsoflearning")
    @JsonProperty("formsoflearning")
    private String formsoflearning;
    /**
     * 受教育程度
     */
    @TableField(value = "educationlevel")
    @JSONField(name = "educationlevel")
    @JsonProperty("educationlevel")
    private String educationlevel;
    /**
     * 学位证
     */
    @TableField(value = "xwz")
    @JSONField(name = "xwz")
    @JsonProperty("xwz")
    private String xwz;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 专业课程
     */
    @TableField(value = "majorcourses")
    @JSONField(name = "majorcourses")
    @JsonProperty("majorcourses")
    private String majorcourses;
    /**
     * 学院名称
     */
    @TableField(value = "collegename")
    @JSONField(name = "collegename")
    @JsonProperty("collegename")
    private String collegename;
    /**
     * 毕业证
     */
    @TableField(value = "byz")
    @JSONField(name = "byz")
    @JsonProperty("byz")
    private String byz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 学历验证
     */
    @TableField(value = "xlyz")
    @JSONField(name = "xlyz")
    @JsonProperty("xlyz")
    private String xlyz;
    /**
     * 是否为海外留学
     */
    @TableField(value = "isabroad")
    @JSONField(name = "isabroad")
    @JsonProperty("isabroad")
    private String isabroad;
    /**
     * 入学时间
     */
    @TableField(value = "starttime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd")
    @JsonProperty("starttime")
    private Timestamp starttime;
    /**
     * 是否小专业
     */
    @TableField(value = "sfxzy")
    @JSONField(name = "sfxzy")
    @JsonProperty("sfxzy")
    private String sfxzy;
    /**
     * 一级学科
     */
    @TableField(value = "xkml")
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;
    /**
     * 是否最高学历
     */
    @DEField(defaultValue = "0")
    @TableField(value = "higestxl")
    @JSONField(name = "higestxl")
    @JsonProperty("higestxl")
    private String higestxl;
    /**
     * 专业名称
     */
    @TableField(value = "majorname")
    @JSONField(name = "majorname")
    @JsonProperty("majorname")
    private String majorname;
    /**
     * 毕业院校
     */
    @TableField(value = "schoolname")
    @JSONField(name = "schoolname")
    @JsonProperty("schoolname")
    private String schoolname;
    /**
     * 城市
     */
    @TableField(value = "city")
    @JSONField(name = "city")
    @JsonProperty("city")
    private String city;
    /**
     * 学校性质
     */
    @TableField(value = "xxxz")
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;
    /**
     * 学历
     */
    @TableField(value = "xl")
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;
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
     * 毕业时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd")
    @JsonProperty("endtime")
    private Timestamp endtime;
    /**
     * 学位
     */
    @TableField(value = "degree")
    @JSONField(name = "degree")
    @JsonProperty("degree")
    private String degree;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否第一学历
     */
    @DEField(defaultValue = "0")
    @TableField(value = "firstxl")
    @JSONField(name = "firstxl")
    @JsonProperty("firstxl")
    private String firstxl;
    /**
     * 教育背景标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmeducationexperienceid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmeducationexperienceid")
    @JsonProperty("pcmeducationexperienceid")
    private String pcmeducationexperienceid;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 招聘年份
     */
    @TableField(exist = false)
    @JSONField(name = "xznf")
    @JsonProperty("xznf")
    private String xznf;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-教育背景
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [专业描述]
     */
    public void setMajordescription(String majordescription){
        this.majordescription = majordescription ;
        this.modify("majordescription",majordescription);
    }

    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [课题研究]
     */
    public void setSubjectresearch(String subjectresearch){
        this.subjectresearch = subjectresearch ;
        this.modify("subjectresearch",subjectresearch);
    }

    /**
     * 设置 [培养方式]
     */
    public void setTrainingmode(String trainingmode){
        this.trainingmode = trainingmode ;
        this.modify("trainingmode",trainingmode);
    }

    /**
     * 设置 [专业类别]
     */
    public void setMajorcategory(String majorcategory){
        this.majorcategory = majorcategory ;
        this.modify("majorcategory",majorcategory);
    }

    /**
     * 设置 [教育背景名称]
     */
    public void setPcmeducationexperiencename(String pcmeducationexperiencename){
        this.pcmeducationexperiencename = pcmeducationexperiencename ;
        this.modify("pcmeducationexperiencename",pcmeducationexperiencename);
    }

    /**
     * 设置 [学习形式]
     */
    public void setFormsoflearning(String formsoflearning){
        this.formsoflearning = formsoflearning ;
        this.modify("formsoflearning",formsoflearning);
    }

    /**
     * 设置 [受教育程度]
     */
    public void setEducationlevel(String educationlevel){
        this.educationlevel = educationlevel ;
        this.modify("educationlevel",educationlevel);
    }

    /**
     * 设置 [学位证]
     */
    public void setXwz(String xwz){
        this.xwz = xwz ;
        this.modify("xwz",xwz);
    }

    /**
     * 设置 [版本时间]
     */
    public void setBbsj(Timestamp bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 格式化日期 [版本时间]
     */
    public String formatBbsj(){
        if (this.bbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bbsj);
    }
    /**
     * 设置 [专业课程]
     */
    public void setMajorcourses(String majorcourses){
        this.majorcourses = majorcourses ;
        this.modify("majorcourses",majorcourses);
    }

    /**
     * 设置 [学院名称]
     */
    public void setCollegename(String collegename){
        this.collegename = collegename ;
        this.modify("collegename",collegename);
    }

    /**
     * 设置 [毕业证]
     */
    public void setByz(String byz){
        this.byz = byz ;
        this.modify("byz",byz);
    }

    /**
     * 设置 [学历验证]
     */
    public void setXlyz(String xlyz){
        this.xlyz = xlyz ;
        this.modify("xlyz",xlyz);
    }

    /**
     * 设置 [是否为海外留学]
     */
    public void setIsabroad(String isabroad){
        this.isabroad = isabroad ;
        this.modify("isabroad",isabroad);
    }

    /**
     * 设置 [入学时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 格式化日期 [入学时间]
     */
    public String formatStarttime(){
        if (this.starttime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(starttime);
    }
    /**
     * 设置 [是否小专业]
     */
    public void setSfxzy(String sfxzy){
        this.sfxzy = sfxzy ;
        this.modify("sfxzy",sfxzy);
    }

    /**
     * 设置 [一级学科]
     */
    public void setXkml(String xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [是否最高学历]
     */
    public void setHigestxl(String higestxl){
        this.higestxl = higestxl ;
        this.modify("higestxl",higestxl);
    }

    /**
     * 设置 [专业名称]
     */
    public void setMajorname(String majorname){
        this.majorname = majorname ;
        this.modify("majorname",majorname);
    }

    /**
     * 设置 [毕业院校]
     */
    public void setSchoolname(String schoolname){
        this.schoolname = schoolname ;
        this.modify("schoolname",schoolname);
    }

    /**
     * 设置 [城市]
     */
    public void setCity(String city){
        this.city = city ;
        this.modify("city",city);
    }

    /**
     * 设置 [学校性质]
     */
    public void setXxxz(String xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [学历]
     */
    public void setXl(String xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [毕业时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 格式化日期 [毕业时间]
     */
    public String formatEndtime(){
        if (this.endtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(endtime);
    }
    /**
     * 设置 [学位]
     */
    public void setDegree(String degree){
        this.degree = degree ;
        this.modify("degree",degree);
    }

    /**
     * 设置 [是否第一学历]
     */
    public void setFirstxl(String firstxl){
        this.firstxl = firstxl ;
        this.modify("firstxl",firstxl);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


