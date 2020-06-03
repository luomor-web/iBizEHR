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
 * 服务DTO对象[ParLdndlhmbDTO]
 */
@Data
public class ParLdndlhmbDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARLDNDLHMBNAME]
     *
     */
    @JSONField(name = "parldndlhmbname")
    @JsonProperty("parldndlhmbname")
    private String parldndlhmbname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SSTZ]
     *
     */
    @JSONField(name = "sstz")
    @JsonProperty("sstz")
    private String sstz;

    /**
     * 属性 [SSZZ]
     *
     */
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;

    /**
     * 属性 [PARLDNDLHMBID]
     *
     */
    @JSONField(name = "parldndlhmbid")
    @JsonProperty("parldndlhmbid")
    private String parldndlhmbid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [SSBM]
     *
     */
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;

    /**
     * 属性 [JXJD]
     *
     */
    @JSONField(name = "jxjd")
    @JsonProperty("jxjd")
    private String jxjd;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PARLDNDLHMBNAME]
     */
    public void setParldndlhmbname(String  parldndlhmbname){
        this.parldndlhmbname = parldndlhmbname ;
        this.modify("parldndlhmbname",parldndlhmbname);
    }

    /**
     * 设置 [SSTZ]
     */
    public void setSstz(String  sstz){
        this.sstz = sstz ;
        this.modify("sstz",sstz);
    }

    /**
     * 设置 [SSZZ]
     */
    public void setSszz(String  sszz){
        this.sszz = sszz ;
        this.modify("sszz",sszz);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [SSBM]
     */
    public void setSsbm(String  ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [JXJD]
     */
    public void setJxjd(String  jxjd){
        this.jxjd = jxjd ;
        this.modify("jxjd",jxjd);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

