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
 * 服务DTO对象[SalSchemeItemDTO]
 */
@Data
public class SalSchemeItemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SITEMTYPE]
     *
     */
    @JSONField(name = "sitemtype")
    @JsonProperty("sitemtype")
    private String sitemtype;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SALSCHEMEITEMNAME]
     *
     */
    @JSONField(name = "salschemeitemname")
    @JsonProperty("salschemeitemname")
    private String salschemeitemname;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [GS]
     *
     */
    @JSONField(name = "gs")
    @JsonProperty("gs")
    private String gs;

    /**
     * 属性 [SALSCHEMEITEMID]
     *
     */
    @JSONField(name = "salschemeitemid")
    @JsonProperty("salschemeitemid")
    private String salschemeitemid;

    /**
     * 属性 [SITEMADD]
     *
     */
    @JSONField(name = "sitemadd")
    @JsonProperty("sitemadd")
    private String sitemadd;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [SALSCHEMENAME]
     *
     */
    @JSONField(name = "salschemename")
    @JsonProperty("salschemename")
    private String salschemename;

    /**
     * 属性 [SALRULENAME]
     *
     */
    @JSONField(name = "salrulename")
    @JsonProperty("salrulename")
    private String salrulename;

    /**
     * 属性 [SALITEMNAME]
     *
     */
    @JSONField(name = "salitemname")
    @JsonProperty("salitemname")
    private String salitemname;

    /**
     * 属性 [SALSCHEMEID]
     *
     */
    @JSONField(name = "salschemeid")
    @JsonProperty("salschemeid")
    private String salschemeid;

    /**
     * 属性 [SALRULEID]
     *
     */
    @JSONField(name = "salruleid")
    @JsonProperty("salruleid")
    private String salruleid;

    /**
     * 属性 [SALITEMID]
     *
     */
    @JSONField(name = "salitemid")
    @JsonProperty("salitemid")
    private String salitemid;

    /**
     * 属性 [XH2]
     *
     */
    @JSONField(name = "xh2")
    @JsonProperty("xh2")
    private Integer xh2;


    /**
     * 设置 [BZ]
     */
    public void setBz(Double  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [SITEMTYPE]
     */
    public void setSitemtype(String  sitemtype){
        this.sitemtype = sitemtype ;
        this.modify("sitemtype",sitemtype);
    }

    /**
     * 设置 [SALSCHEMEITEMNAME]
     */
    public void setSalschemeitemname(String  salschemeitemname){
        this.salschemeitemname = salschemeitemname ;
        this.modify("salschemeitemname",salschemeitemname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [GS]
     */
    public void setGs(String  gs){
        this.gs = gs ;
        this.modify("gs",gs);
    }

    /**
     * 设置 [SITEMADD]
     */
    public void setSitemadd(String  sitemadd){
        this.sitemadd = sitemadd ;
        this.modify("sitemadd",sitemadd);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [SALSCHEMEID]
     */
    public void setSalschemeid(String  salschemeid){
        this.salschemeid = salschemeid ;
        this.modify("salschemeid",salschemeid);
    }

    /**
     * 设置 [SALRULEID]
     */
    public void setSalruleid(String  salruleid){
        this.salruleid = salruleid ;
        this.modify("salruleid",salruleid);
    }

    /**
     * 设置 [SALITEMID]
     */
    public void setSalitemid(String  salitemid){
        this.salitemid = salitemid ;
        this.modify("salitemid",salitemid);
    }


}

