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
 * 实体[实习经验]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMPRACTICEEXPERIENCE",resultMap = "PcmPracticeExperienceResultMap")
public class PcmPracticeExperience extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 证明人职务
     */
    @TableField(value = "practicereferencesposition")
    @JSONField(name = "practicereferencesposition")
    @JsonProperty("practicereferencesposition")
    private String practicereferencesposition;
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
     * 单位介绍
     */
    @TableField(value = "practicecompanydescription")
    @JSONField(name = "practicecompanydescription")
    @JsonProperty("practicecompanydescription")
    private String practicecompanydescription;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 结束时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd")
    @JsonProperty("endtime")
    private Timestamp endtime;
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
     * 实习单位
     */
    @TableField(value = "practicecompanyname")
    @JSONField(name = "practicecompanyname")
    @JsonProperty("practicecompanyname")
    private String practicecompanyname;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 实习内容
     */
    @TableField(value = "practicecontent")
    @JSONField(name = "practicecontent")
    @JsonProperty("practicecontent")
    private String practicecontent;
    /**
     * 证明人
     */
    @TableField(value = "practicereferencesname")
    @JSONField(name = "practicereferencesname")
    @JsonProperty("practicereferencesname")
    private String practicereferencesname;
    /**
     * 证明人联系方式
     */
    @TableField(value = "practicereferencescontact")
    @JSONField(name = "practicereferencescontact")
    @JsonProperty("practicereferencescontact")
    private String practicereferencescontact;
    /**
     * 实习评价
     */
    @TableField(value = "sxpj")
    @JSONField(name = "sxpj")
    @JsonProperty("sxpj")
    private String sxpj;
    /**
     * 实习经验名称
     */
    @TableField(value = "pcmpracticeexperiencename")
    @JSONField(name = "pcmpracticeexperiencename")
    @JsonProperty("pcmpracticeexperiencename")
    private String pcmpracticeexperiencename;
    /**
     * 实习经验标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmpracticeexperienceid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmpracticeexperienceid")
    @JsonProperty("pcmpracticeexperienceid")
    private String pcmpracticeexperienceid;
    /**
     * 实习地点
     */
    @TableField(value = "practiceaddress")
    @JSONField(name = "practiceaddress")
    @JsonProperty("practiceaddress")
    private String practiceaddress;
    /**
     * 实习岗位
     */
    @TableField(value = "sxgw")
    @JSONField(name = "sxgw")
    @JsonProperty("sxgw")
    private String sxgw;
    /**
     * 证明人关系
     */
    @TableField(value = "practicereferencesrelation")
    @JSONField(name = "practicereferencesrelation")
    @JsonProperty("practicereferencesrelation")
    private String practicereferencesrelation;
    /**
     * 开始时间
     */
    @TableField(value = "starttime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd")
    @JsonProperty("starttime")
    private Timestamp starttime;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-实习经验
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [证明人职务]
     */
    public void setPracticereferencesposition(String practicereferencesposition){
        this.practicereferencesposition = practicereferencesposition ;
        this.modify("practicereferencesposition",practicereferencesposition);
    }

    /**
     * 设置 [单位介绍]
     */
    public void setPracticecompanydescription(String practicecompanydescription){
        this.practicecompanydescription = practicecompanydescription ;
        this.modify("practicecompanydescription",practicecompanydescription);
    }

    /**
     * 设置 [结束时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 格式化日期 [结束时间]
     */
    public String formatEndtime(){
        if (this.endtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(endtime);
    }
    /**
     * 设置 [实习单位]
     */
    public void setPracticecompanyname(String practicecompanyname){
        this.practicecompanyname = practicecompanyname ;
        this.modify("practicecompanyname",practicecompanyname);
    }

    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
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
     * 设置 [实习内容]
     */
    public void setPracticecontent(String practicecontent){
        this.practicecontent = practicecontent ;
        this.modify("practicecontent",practicecontent);
    }

    /**
     * 设置 [证明人]
     */
    public void setPracticereferencesname(String practicereferencesname){
        this.practicereferencesname = practicereferencesname ;
        this.modify("practicereferencesname",practicereferencesname);
    }

    /**
     * 设置 [证明人联系方式]
     */
    public void setPracticereferencescontact(String practicereferencescontact){
        this.practicereferencescontact = practicereferencescontact ;
        this.modify("practicereferencescontact",practicereferencescontact);
    }

    /**
     * 设置 [实习评价]
     */
    public void setSxpj(String sxpj){
        this.sxpj = sxpj ;
        this.modify("sxpj",sxpj);
    }

    /**
     * 设置 [实习经验名称]
     */
    public void setPcmpracticeexperiencename(String pcmpracticeexperiencename){
        this.pcmpracticeexperiencename = pcmpracticeexperiencename ;
        this.modify("pcmpracticeexperiencename",pcmpracticeexperiencename);
    }

    /**
     * 设置 [实习地点]
     */
    public void setPracticeaddress(String practiceaddress){
        this.practiceaddress = practiceaddress ;
        this.modify("practiceaddress",practiceaddress);
    }

    /**
     * 设置 [实习岗位]
     */
    public void setSxgw(String sxgw){
        this.sxgw = sxgw ;
        this.modify("sxgw",sxgw);
    }

    /**
     * 设置 [证明人关系]
     */
    public void setPracticereferencesrelation(String practicereferencesrelation){
        this.practicereferencesrelation = practicereferencesrelation ;
        this.modify("practicereferencesrelation",practicereferencesrelation);
    }

    /**
     * 设置 [开始时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 格式化日期 [开始时间]
     */
    public String formatStarttime(){
        if (this.starttime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(starttime);
    }
    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


