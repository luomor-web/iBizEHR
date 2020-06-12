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
 * 服务DTO对象[PimPersonChangeDTO]
 */
@Data
public class PimPersonChangeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [CZDXMC]
     *
     */
    @JSONField(name = "czdxmc")
    @JsonProperty("czdxmc")
    private String czdxmc;

    /**
     * 属性 [JLBH]
     *
     */
    @JSONField(name = "jlbh")
    @JsonProperty("jlbh")
    private String jlbh;

    /**
     * 属性 [CZDXBH]
     *
     */
    @JSONField(name = "czdxbh")
    @JsonProperty("czdxbh")
    private String czdxbh;

    /**
     * 属性 [SXSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj" , format="yyyy-MM-dd")
    @JsonProperty("sxsj")
    private Timestamp sxsj;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [BGLX]
     *
     */
    @JSONField(name = "bglx")
    @JsonProperty("bglx")
    private String bglx;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PIMPERSONCHANGEID]
     *
     */
    @JSONField(name = "pimpersonchangeid")
    @JsonProperty("pimpersonchangeid")
    private String pimpersonchangeid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BGNR]
     *
     */
    @JSONField(name = "bgnr")
    @JsonProperty("bgnr")
    private String bgnr;

    /**
     * 属性 [BGSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bgsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("bgsj")
    private Timestamp bgsj;

    /**
     * 属性 [PIMPERSONCHANGENAME]
     *
     */
    @JSONField(name = "pimpersonchangename")
    @JsonProperty("pimpersonchangename")
    private String pimpersonchangename;

    /**
     * 属性 [SQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqsj" , format="yyyy-MM-dd")
    @JsonProperty("sqsj")
    private Timestamp sqsj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [CZDXMC]
     */
    public void setCzdxmc(String  czdxmc){
        this.czdxmc = czdxmc ;
        this.modify("czdxmc",czdxmc);
    }

    /**
     * 设置 [JLBH]
     */
    public void setJlbh(String  jlbh){
        this.jlbh = jlbh ;
        this.modify("jlbh",jlbh);
    }

    /**
     * 设置 [CZDXBH]
     */
    public void setCzdxbh(String  czdxbh){
        this.czdxbh = czdxbh ;
        this.modify("czdxbh",czdxbh);
    }

    /**
     * 设置 [SXSJ]
     */
    public void setSxsj(Timestamp  sxsj){
        this.sxsj = sxsj ;
        this.modify("sxsj",sxsj);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [BGLX]
     */
    public void setBglx(String  bglx){
        this.bglx = bglx ;
        this.modify("bglx",bglx);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [BGNR]
     */
    public void setBgnr(String  bgnr){
        this.bgnr = bgnr ;
        this.modify("bgnr",bgnr);
    }

    /**
     * 设置 [BGSJ]
     */
    public void setBgsj(Timestamp  bgsj){
        this.bgsj = bgsj ;
        this.modify("bgsj",bgsj);
    }

    /**
     * 设置 [PIMPERSONCHANGENAME]
     */
    public void setPimpersonchangename(String  pimpersonchangename){
        this.pimpersonchangename = pimpersonchangename ;
        this.modify("pimpersonchangename",pimpersonchangename);
    }

    /**
     * 设置 [SQSJ]
     */
    public void setSqsj(Timestamp  sqsj){
        this.sqsj = sqsj ;
        this.modify("sqsj",sqsj);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

