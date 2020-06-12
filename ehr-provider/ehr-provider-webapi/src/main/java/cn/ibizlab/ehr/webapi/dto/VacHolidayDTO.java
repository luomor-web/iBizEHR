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
 * 服务DTO对象[VacHolidayDTO]
 */
@Data
public class VacHolidayDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [VACHOLIDAYNAME]
     *
     */
    @JSONField(name = "vacholidayname")
    @JsonProperty("vacholidayname")
    private String vacholidayname;

    /**
     * 属性 [VACHOLIDAYID]
     *
     */
    @JSONField(name = "vacholidayid")
    @JsonProperty("vacholidayid")
    private String vacholidayid;

    /**
     * 属性 [AGE]
     *
     */
    @JSONField(name = "age")
    @JsonProperty("age")
    private Integer age;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JJRLX]
     *
     */
    @JSONField(name = "jjrlx")
    @JsonProperty("jjrlx")
    private String jjrlx;

    /**
     * 属性 [KSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;

    /**
     * 属性 [SEX]
     *
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [VACHOLIDAYRULESNAME]
     *
     */
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [VACHOLIDAYRULESID]
     *
     */
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;


    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [ENABLE]
     */
    public void setEnable(Integer  enable){
        this.enable = enable ;
        this.modify("enable",enable);
    }

    /**
     * 设置 [VACHOLIDAYNAME]
     */
    public void setVacholidayname(String  vacholidayname){
        this.vacholidayname = vacholidayname ;
        this.modify("vacholidayname",vacholidayname);
    }

    /**
     * 设置 [AGE]
     */
    public void setAge(Integer  age){
        this.age = age ;
        this.modify("age",age);
    }

    /**
     * 设置 [JSSJ]
     */
    public void setJssj(Timestamp  jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JJRLX]
     */
    public void setJjrlx(String  jjrlx){
        this.jjrlx = jjrlx ;
        this.modify("jjrlx",jjrlx);
    }

    /**
     * 设置 [KSSJ]
     */
    public void setKssj(Timestamp  kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }

    /**
     * 设置 [SEX]
     */
    public void setSex(String  sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [VACHOLIDAYRULESID]
     */
    public void setVacholidayrulesid(String  vacholidayrulesid){
        this.vacholidayrulesid = vacholidayrulesid ;
        this.modify("vacholidayrulesid",vacholidayrulesid);
    }


}

