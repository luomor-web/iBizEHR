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
 * 服务DTO对象[ParJxmtfkDTO]
 */
@Data
public class ParJxmtfkDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MTNR]
     *
     */
    @JSONField(name = "mtnr")
    @JsonProperty("mtnr")
    private String mtnr;

    /**
     * 属性 [YGCS]
     *
     */
    @JSONField(name = "ygcs")
    @JsonProperty("ygcs")
    private String ygcs;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PARJXMTFKNAME]
     *
     */
    @JSONField(name = "parjxmtfkname")
    @JsonProperty("parjxmtfkname")
    private String parjxmtfkname;

    /**
     * 属性 [PARJXMTFKID]
     *
     */
    @JSONField(name = "parjxmtfkid")
    @JsonProperty("parjxmtfkid")
    private String parjxmtfkid;

    /**
     * 属性 [FJXX]
     *
     */
    @JSONField(name = "fjxx")
    @JsonProperty("fjxx")
    private String fjxx;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SSZZ]
     *
     */
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

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
     * 设置 [MTNR]
     */
    public void setMtnr(String  mtnr){
        this.mtnr = mtnr ;
        this.modify("mtnr",mtnr);
    }

    /**
     * 设置 [YGCS]
     */
    public void setYgcs(String  ygcs){
        this.ygcs = ygcs ;
        this.modify("ygcs",ygcs);
    }

    /**
     * 设置 [PARJXMTFKNAME]
     */
    public void setParjxmtfkname(String  parjxmtfkname){
        this.parjxmtfkname = parjxmtfkname ;
        this.modify("parjxmtfkname",parjxmtfkname);
    }

    /**
     * 设置 [FJXX]
     */
    public void setFjxx(String  fjxx){
        this.fjxx = fjxx ;
        this.modify("fjxx",fjxx);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

