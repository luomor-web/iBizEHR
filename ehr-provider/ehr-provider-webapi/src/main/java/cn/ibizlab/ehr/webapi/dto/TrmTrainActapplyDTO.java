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
 * 服务DTO对象[TrmTrainActapplyDTO]
 */
@Data
public class TrmTrainActapplyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JHPXRS]
     *
     */
    @JSONField(name = "jhpxrs")
    @JsonProperty("jhpxrs")
    private Integer jhpxrs;

    /**
     * 属性 [PXMB]
     *
     */
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;

    /**
     * 属性 [PXNR]
     *
     */
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;

    /**
     * 属性 [TRMTRAINACTAPPLYID]
     *
     */
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PXFS]
     *
     */
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;

    /**
     * 属性 [PXJB]
     *
     */
    @JSONField(name = "pxjb")
    @JsonProperty("pxjb")
    private String pxjb;

    /**
     * 属性 [SJPXRS]
     *
     */
    @JSONField(name = "sjpxrs")
    @JsonProperty("sjpxrs")
    private Integer sjpxrs;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXHDBM]
     *
     */
    @JSONField(name = "pxhdbm")
    @JsonProperty("pxhdbm")
    private String pxhdbm;

    /**
     * 属性 [PXND]
     *
     */
    @JSONField(name = "pxnd")
    @JsonProperty("pxnd")
    private String pxnd;

    /**
     * 属性 [SFQDXY]
     *
     */
    @JSONField(name = "sfqdxy")
    @JsonProperty("sfqdxy")
    private Integer sfqdxy;

    /**
     * 属性 [PXYF]
     *
     */
    @JSONField(name = "pxyf")
    @JsonProperty("pxyf")
    private String pxyf;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PXLB]
     *
     */
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;

    /**
     * 属性 [TRMTRAINACTAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PXDXLB]
     *
     */
    @JSONField(name = "pxdxlb")
    @JsonProperty("pxdxlb")
    private String pxdxlb;

    /**
     * 属性 [CBDW]
     *
     */
    @JSONField(name = "cbdw")
    @JsonProperty("cbdw")
    private String cbdw;

    /**
     * 属性 [ZBDW]
     *
     */
    @JSONField(name = "zbdw")
    @JsonProperty("zbdw")
    private String zbdw;

    /**
     * 属性 [PXJD]
     *
     */
    @JSONField(name = "pxjd")
    @JsonProperty("pxjd")
    private String pxjd;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XBDW]
     *
     */
    @JSONField(name = "xbdw")
    @JsonProperty("xbdw")
    private String xbdw;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [JHPXRS]
     */
    public void setJhpxrs(Integer  jhpxrs){
        this.jhpxrs = jhpxrs ;
        this.modify("jhpxrs",jhpxrs);
    }

    /**
     * 设置 [PXMB]
     */
    public void setPxmb(String  pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [PXNR]
     */
    public void setPxnr(String  pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [PXFS]
     */
    public void setPxfs(String  pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [PXJB]
     */
    public void setPxjb(String  pxjb){
        this.pxjb = pxjb ;
        this.modify("pxjb",pxjb);
    }

    /**
     * 设置 [SJPXRS]
     */
    public void setSjpxrs(Integer  sjpxrs){
        this.sjpxrs = sjpxrs ;
        this.modify("sjpxrs",sjpxrs);
    }

    /**
     * 设置 [PXHDBM]
     */
    public void setPxhdbm(String  pxhdbm){
        this.pxhdbm = pxhdbm ;
        this.modify("pxhdbm",pxhdbm);
    }

    /**
     * 设置 [PXND]
     */
    public void setPxnd(String  pxnd){
        this.pxnd = pxnd ;
        this.modify("pxnd",pxnd);
    }

    /**
     * 设置 [SFQDXY]
     */
    public void setSfqdxy(Integer  sfqdxy){
        this.sfqdxy = sfqdxy ;
        this.modify("sfqdxy",sfqdxy);
    }

    /**
     * 设置 [PXYF]
     */
    public void setPxyf(String  pxyf){
        this.pxyf = pxyf ;
        this.modify("pxyf",pxyf);
    }

    /**
     * 设置 [PXLB]
     */
    public void setPxlb(String  pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [TRMTRAINACTAPPLYNAME]
     */
    public void setTrmtrainactapplyname(String  trmtrainactapplyname){
        this.trmtrainactapplyname = trmtrainactapplyname ;
        this.modify("trmtrainactapplyname",trmtrainactapplyname);
    }

    /**
     * 设置 [PXDXLB]
     */
    public void setPxdxlb(String  pxdxlb){
        this.pxdxlb = pxdxlb ;
        this.modify("pxdxlb",pxdxlb);
    }

    /**
     * 设置 [CBDW]
     */
    public void setCbdw(String  cbdw){
        this.cbdw = cbdw ;
        this.modify("cbdw",cbdw);
    }

    /**
     * 设置 [ZBDW]
     */
    public void setZbdw(String  zbdw){
        this.zbdw = zbdw ;
        this.modify("zbdw",zbdw);
    }

    /**
     * 设置 [PXJD]
     */
    public void setPxjd(String  pxjd){
        this.pxjd = pxjd ;
        this.modify("pxjd",pxjd);
    }

    /**
     * 设置 [XBDW]
     */
    public void setXbdw(String  xbdw){
        this.xbdw = xbdw ;
        this.modify("xbdw",xbdw);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

