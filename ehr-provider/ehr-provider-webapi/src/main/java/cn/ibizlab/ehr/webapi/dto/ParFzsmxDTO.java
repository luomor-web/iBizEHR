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
 * 服务DTO对象[ParFzsmxDTO]
 */
@Data
public class ParFzsmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARFZSMXNAME]
     *
     */
    @JSONField(name = "parfzsmxname")
    @JsonProperty("parfzsmxname")
    private String parfzsmxname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARFZSMXID]
     *
     */
    @JSONField(name = "parfzsmxid")
    @JsonProperty("parfzsmxid")
    private String parfzsmxid;

    /**
     * 属性 [BZSM]
     *
     */
    @JSONField(name = "bzsm")
    @JsonProperty("bzsm")
    private String bzsm;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [LDPX]
     *
     */
    @JSONField(name = "ldpx")
    @JsonProperty("ldpx")
    private Integer ldpx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [SSZZ]
     *
     */
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;

    /**
     * 属性 [PARTZGGNAME]
     *
     */
    @JSONField(name = "partzggname")
    @JsonProperty("partzggname")
    private String partzggname;

    /**
     * 属性 [SSBM]
     *
     */
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PARTZGGID]
     *
     */
    @JSONField(name = "partzggid")
    @JsonProperty("partzggid")
    private String partzggid;


    /**
     * 设置 [PARFZSMXNAME]
     */
    public void setParfzsmxname(String  parfzsmxname){
        this.parfzsmxname = parfzsmxname ;
        this.modify("parfzsmxname",parfzsmxname);
    }

    /**
     * 设置 [BZSM]
     */
    public void setBzsm(String  bzsm){
        this.bzsm = bzsm ;
        this.modify("bzsm",bzsm);
    }

    /**
     * 设置 [LDPX]
     */
    public void setLdpx(Integer  ldpx){
        this.ldpx = ldpx ;
        this.modify("ldpx",ldpx);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PARTZGGID]
     */
    public void setPartzggid(String  partzggid){
        this.partzggid = partzggid ;
        this.modify("partzggid",partzggid);
    }


}

