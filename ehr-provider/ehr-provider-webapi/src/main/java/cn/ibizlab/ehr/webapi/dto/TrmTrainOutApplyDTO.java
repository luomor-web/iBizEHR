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
 * 服务DTO对象[TrmTrainOutApplyDTO]
 */
@Data
public class TrmTrainOutApplyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WBPXJG]
     *
     */
    @JSONField(name = "wbpxjg")
    @JsonProperty("wbpxjg")
    private String wbpxjg;

    /**
     * 属性 [DJBH]
     *
     */
    @JSONField(name = "djbh")
    @JsonProperty("djbh")
    private String djbh;

    /**
     * 属性 [SQRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqrq" , format="yyyy-MM-dd")
    @JsonProperty("sqrq")
    private Timestamp sqrq;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PXFS]
     *
     */
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;

    /**
     * 属性 [PXLB]
     *
     */
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;

    /**
     * 属性 [PXNR]
     *
     */
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;

    /**
     * 属性 [YWLX]
     *
     */
    @JSONField(name = "ywlx")
    @JsonProperty("ywlx")
    private String ywlx;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PXJSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjsrq" , format="yyyy-MM-dd")
    @JsonProperty("pxjsrq")
    private Timestamp pxjsrq;

    /**
     * 属性 [PXMB]
     *
     */
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXKSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxksrq" , format="yyyy-MM-dd")
    @JsonProperty("pxksrq")
    private Timestamp pxksrq;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [TRMTRAINOUTAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainoutapplyname")
    @JsonProperty("trmtrainoutapplyname")
    private String trmtrainoutapplyname;

    /**
     * 属性 [TRMTRAINOUTAPPLYID]
     *
     */
    @JSONField(name = "trmtrainoutapplyid")
    @JsonProperty("trmtrainoutapplyid")
    private String trmtrainoutapplyid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [WBPXJG]
     */
    public void setWbpxjg(String  wbpxjg){
        this.wbpxjg = wbpxjg ;
        this.modify("wbpxjg",wbpxjg);
    }

    /**
     * 设置 [DJBH]
     */
    public void setDjbh(String  djbh){
        this.djbh = djbh ;
        this.modify("djbh",djbh);
    }

    /**
     * 设置 [SQRQ]
     */
    public void setSqrq(Timestamp  sqrq){
        this.sqrq = sqrq ;
        this.modify("sqrq",sqrq);
    }

    /**
     * 设置 [PXFS]
     */
    public void setPxfs(String  pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [PXLB]
     */
    public void setPxlb(String  pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [PXNR]
     */
    public void setPxnr(String  pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [YWLX]
     */
    public void setYwlx(String  ywlx){
        this.ywlx = ywlx ;
        this.modify("ywlx",ywlx);
    }

    /**
     * 设置 [PXJSRQ]
     */
    public void setPxjsrq(Timestamp  pxjsrq){
        this.pxjsrq = pxjsrq ;
        this.modify("pxjsrq",pxjsrq);
    }

    /**
     * 设置 [PXMB]
     */
    public void setPxmb(String  pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [PXKSRQ]
     */
    public void setPxksrq(Timestamp  pxksrq){
        this.pxksrq = pxksrq ;
        this.modify("pxksrq",pxksrq);
    }

    /**
     * 设置 [PXDD]
     */
    public void setPxdd(String  pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [TRMTRAINOUTAPPLYNAME]
     */
    public void setTrmtrainoutapplyname(String  trmtrainoutapplyname){
        this.trmtrainoutapplyname = trmtrainoutapplyname ;
        this.modify("trmtrainoutapplyname",trmtrainoutapplyname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

