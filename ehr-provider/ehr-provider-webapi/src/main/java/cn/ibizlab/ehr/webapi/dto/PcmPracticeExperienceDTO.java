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
 * 服务DTO对象[PcmPracticeExperienceDTO]
 */
@Data
public class PcmPracticeExperienceDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PRACTICEREFERENCESPOSITION]
     *
     */
    @JSONField(name = "practicereferencesposition")
    @JsonProperty("practicereferencesposition")
    private String practicereferencesposition;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PRACTICECOMPANYDESCRIPTION]
     *
     */
    @JSONField(name = "practicecompanydescription")
    @JsonProperty("practicecompanydescription")
    private String practicecompanydescription;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PRACTICECOMPANYNAME]
     *
     */
    @JSONField(name = "practicecompanyname")
    @JsonProperty("practicecompanyname")
    private String practicecompanyname;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [PRACTICECONTENT]
     *
     */
    @JSONField(name = "practicecontent")
    @JsonProperty("practicecontent")
    private String practicecontent;

    /**
     * 属性 [PRACTICEREFERENCESNAME]
     *
     */
    @JSONField(name = "practicereferencesname")
    @JsonProperty("practicereferencesname")
    private String practicereferencesname;

    /**
     * 属性 [PRACTICEREFERENCESCONTACT]
     *
     */
    @JSONField(name = "practicereferencescontact")
    @JsonProperty("practicereferencescontact")
    private String practicereferencescontact;

    /**
     * 属性 [SXPJ]
     *
     */
    @JSONField(name = "sxpj")
    @JsonProperty("sxpj")
    private String sxpj;

    /**
     * 属性 [PCMPRACTICEEXPERIENCENAME]
     *
     */
    @JSONField(name = "pcmpracticeexperiencename")
    @JsonProperty("pcmpracticeexperiencename")
    private String pcmpracticeexperiencename;

    /**
     * 属性 [PCMPRACTICEEXPERIENCEID]
     *
     */
    @JSONField(name = "pcmpracticeexperienceid")
    @JsonProperty("pcmpracticeexperienceid")
    private String pcmpracticeexperienceid;

    /**
     * 属性 [PRACTICEADDRESS]
     *
     */
    @JSONField(name = "practiceaddress")
    @JsonProperty("practiceaddress")
    private String practiceaddress;

    /**
     * 属性 [SXGW]
     *
     */
    @JSONField(name = "sxgw")
    @JsonProperty("sxgw")
    private String sxgw;

    /**
     * 属性 [PRACTICEREFERENCESRELATION]
     *
     */
    @JSONField(name = "practicereferencesrelation")
    @JsonProperty("practicereferencesrelation")
    private String practicereferencesrelation;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd")
    @JsonProperty("starttime")
    private Timestamp starttime;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [PRACTICEREFERENCESPOSITION]
     */
    public void setPracticereferencesposition(String  practicereferencesposition){
        this.practicereferencesposition = practicereferencesposition ;
        this.modify("practicereferencesposition",practicereferencesposition);
    }

    /**
     * 设置 [PRACTICECOMPANYDESCRIPTION]
     */
    public void setPracticecompanydescription(String  practicecompanydescription){
        this.practicecompanydescription = practicecompanydescription ;
        this.modify("practicecompanydescription",practicecompanydescription);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [PRACTICECOMPANYNAME]
     */
    public void setPracticecompanyname(String  practicecompanyname){
        this.practicecompanyname = practicecompanyname ;
        this.modify("practicecompanyname",practicecompanyname);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [PRACTICECONTENT]
     */
    public void setPracticecontent(String  practicecontent){
        this.practicecontent = practicecontent ;
        this.modify("practicecontent",practicecontent);
    }

    /**
     * 设置 [PRACTICEREFERENCESNAME]
     */
    public void setPracticereferencesname(String  practicereferencesname){
        this.practicereferencesname = practicereferencesname ;
        this.modify("practicereferencesname",practicereferencesname);
    }

    /**
     * 设置 [PRACTICEREFERENCESCONTACT]
     */
    public void setPracticereferencescontact(String  practicereferencescontact){
        this.practicereferencescontact = practicereferencescontact ;
        this.modify("practicereferencescontact",practicereferencescontact);
    }

    /**
     * 设置 [SXPJ]
     */
    public void setSxpj(String  sxpj){
        this.sxpj = sxpj ;
        this.modify("sxpj",sxpj);
    }

    /**
     * 设置 [PCMPRACTICEEXPERIENCENAME]
     */
    public void setPcmpracticeexperiencename(String  pcmpracticeexperiencename){
        this.pcmpracticeexperiencename = pcmpracticeexperiencename ;
        this.modify("pcmpracticeexperiencename",pcmpracticeexperiencename);
    }

    /**
     * 设置 [PRACTICEADDRESS]
     */
    public void setPracticeaddress(String  practiceaddress){
        this.practiceaddress = practiceaddress ;
        this.modify("practiceaddress",practiceaddress);
    }

    /**
     * 设置 [SXGW]
     */
    public void setSxgw(String  sxgw){
        this.sxgw = sxgw ;
        this.modify("sxgw",sxgw);
    }

    /**
     * 设置 [PRACTICEREFERENCESRELATION]
     */
    public void setPracticereferencesrelation(String  practicereferencesrelation){
        this.practicereferencesrelation = practicereferencesrelation ;
        this.modify("practicereferencesrelation",practicereferencesrelation);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

