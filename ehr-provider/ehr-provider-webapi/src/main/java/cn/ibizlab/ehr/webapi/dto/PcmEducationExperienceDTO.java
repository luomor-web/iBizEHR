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
 * 服务DTO对象[PcmEducationExperienceDTO]
 */
@Data
public class PcmEducationExperienceDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MAJORDESCRIPTION]
     *
     */
    @JSONField(name = "majordescription")
    @JsonProperty("majordescription")
    private String majordescription;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [SUBJECTRESEARCH]
     *
     */
    @JSONField(name = "subjectresearch")
    @JsonProperty("subjectresearch")
    private String subjectresearch;

    /**
     * 属性 [TRAININGMODE]
     *
     */
    @JSONField(name = "trainingmode")
    @JsonProperty("trainingmode")
    private String trainingmode;

    /**
     * 属性 [MAJORCATEGORY]
     *
     */
    @JSONField(name = "majorcategory")
    @JsonProperty("majorcategory")
    private String majorcategory;

    /**
     * 属性 [PCMEDUCATIONEXPERIENCENAME]
     *
     */
    @JSONField(name = "pcmeducationexperiencename")
    @JsonProperty("pcmeducationexperiencename")
    private String pcmeducationexperiencename;

    /**
     * 属性 [FORMSOFLEARNING]
     *
     */
    @JSONField(name = "formsoflearning")
    @JsonProperty("formsoflearning")
    private String formsoflearning;

    /**
     * 属性 [EDUCATIONLEVEL]
     *
     */
    @JSONField(name = "educationlevel")
    @JsonProperty("educationlevel")
    private String educationlevel;

    /**
     * 属性 [XWZ]
     *
     */
    @JSONField(name = "xwz")
    @JsonProperty("xwz")
    private String xwz;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [MAJORCOURSES]
     *
     */
    @JSONField(name = "majorcourses")
    @JsonProperty("majorcourses")
    private String majorcourses;

    /**
     * 属性 [COLLEGENAME]
     *
     */
    @JSONField(name = "collegename")
    @JsonProperty("collegename")
    private String collegename;

    /**
     * 属性 [BYZ]
     *
     */
    @JSONField(name = "byz")
    @JsonProperty("byz")
    private String byz;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XLYZ]
     *
     */
    @JSONField(name = "xlyz")
    @JsonProperty("xlyz")
    private String xlyz;

    /**
     * 属性 [ISABROAD]
     *
     */
    @JSONField(name = "isabroad")
    @JsonProperty("isabroad")
    private String isabroad;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd")
    @JsonProperty("starttime")
    private Timestamp starttime;

    /**
     * 属性 [SFXZY]
     *
     */
    @JSONField(name = "sfxzy")
    @JsonProperty("sfxzy")
    private String sfxzy;

    /**
     * 属性 [XKML]
     *
     */
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;

    /**
     * 属性 [HIGESTXL]
     *
     */
    @JSONField(name = "higestxl")
    @JsonProperty("higestxl")
    private String higestxl;

    /**
     * 属性 [MAJORNAME]
     *
     */
    @JSONField(name = "majorname")
    @JsonProperty("majorname")
    private String majorname;

    /**
     * 属性 [SCHOOLNAME]
     *
     */
    @JSONField(name = "schoolname")
    @JsonProperty("schoolname")
    private String schoolname;

    /**
     * 属性 [CITY]
     *
     */
    @JSONField(name = "city")
    @JsonProperty("city")
    private String city;

    /**
     * 属性 [XXXZ]
     *
     */
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;

    /**
     * 属性 [XL]
     *
     */
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [DEGREE]
     *
     */
    @JSONField(name = "degree")
    @JsonProperty("degree")
    private String degree;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [FIRSTXL]
     *
     */
    @JSONField(name = "firstxl")
    @JsonProperty("firstxl")
    private String firstxl;

    /**
     * 属性 [PCMEDUCATIONEXPERIENCEID]
     *
     */
    @JSONField(name = "pcmeducationexperienceid")
    @JsonProperty("pcmeducationexperienceid")
    private String pcmeducationexperienceid;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [XZNF]
     *
     */
    @JSONField(name = "xznf")
    @JsonProperty("xznf")
    private String xznf;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [MAJORDESCRIPTION]
     */
    public void setMajordescription(String  majordescription){
        this.majordescription = majordescription ;
        this.modify("majordescription",majordescription);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [SUBJECTRESEARCH]
     */
    public void setSubjectresearch(String  subjectresearch){
        this.subjectresearch = subjectresearch ;
        this.modify("subjectresearch",subjectresearch);
    }

    /**
     * 设置 [TRAININGMODE]
     */
    public void setTrainingmode(String  trainingmode){
        this.trainingmode = trainingmode ;
        this.modify("trainingmode",trainingmode);
    }

    /**
     * 设置 [MAJORCATEGORY]
     */
    public void setMajorcategory(String  majorcategory){
        this.majorcategory = majorcategory ;
        this.modify("majorcategory",majorcategory);
    }

    /**
     * 设置 [PCMEDUCATIONEXPERIENCENAME]
     */
    public void setPcmeducationexperiencename(String  pcmeducationexperiencename){
        this.pcmeducationexperiencename = pcmeducationexperiencename ;
        this.modify("pcmeducationexperiencename",pcmeducationexperiencename);
    }

    /**
     * 设置 [FORMSOFLEARNING]
     */
    public void setFormsoflearning(String  formsoflearning){
        this.formsoflearning = formsoflearning ;
        this.modify("formsoflearning",formsoflearning);
    }

    /**
     * 设置 [EDUCATIONLEVEL]
     */
    public void setEducationlevel(String  educationlevel){
        this.educationlevel = educationlevel ;
        this.modify("educationlevel",educationlevel);
    }

    /**
     * 设置 [XWZ]
     */
    public void setXwz(String  xwz){
        this.xwz = xwz ;
        this.modify("xwz",xwz);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [MAJORCOURSES]
     */
    public void setMajorcourses(String  majorcourses){
        this.majorcourses = majorcourses ;
        this.modify("majorcourses",majorcourses);
    }

    /**
     * 设置 [COLLEGENAME]
     */
    public void setCollegename(String  collegename){
        this.collegename = collegename ;
        this.modify("collegename",collegename);
    }

    /**
     * 设置 [BYZ]
     */
    public void setByz(String  byz){
        this.byz = byz ;
        this.modify("byz",byz);
    }

    /**
     * 设置 [XLYZ]
     */
    public void setXlyz(String  xlyz){
        this.xlyz = xlyz ;
        this.modify("xlyz",xlyz);
    }

    /**
     * 设置 [ISABROAD]
     */
    public void setIsabroad(String  isabroad){
        this.isabroad = isabroad ;
        this.modify("isabroad",isabroad);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [SFXZY]
     */
    public void setSfxzy(String  sfxzy){
        this.sfxzy = sfxzy ;
        this.modify("sfxzy",sfxzy);
    }

    /**
     * 设置 [XKML]
     */
    public void setXkml(String  xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [HIGESTXL]
     */
    public void setHigestxl(String  higestxl){
        this.higestxl = higestxl ;
        this.modify("higestxl",higestxl);
    }

    /**
     * 设置 [MAJORNAME]
     */
    public void setMajorname(String  majorname){
        this.majorname = majorname ;
        this.modify("majorname",majorname);
    }

    /**
     * 设置 [SCHOOLNAME]
     */
    public void setSchoolname(String  schoolname){
        this.schoolname = schoolname ;
        this.modify("schoolname",schoolname);
    }

    /**
     * 设置 [CITY]
     */
    public void setCity(String  city){
        this.city = city ;
        this.modify("city",city);
    }

    /**
     * 设置 [XXXZ]
     */
    public void setXxxz(String  xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [XL]
     */
    public void setXl(String  xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [DEGREE]
     */
    public void setDegree(String  degree){
        this.degree = degree ;
        this.modify("degree",degree);
    }

    /**
     * 设置 [FIRSTXL]
     */
    public void setFirstxl(String  firstxl){
        this.firstxl = firstxl ;
        this.modify("firstxl",firstxl);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

