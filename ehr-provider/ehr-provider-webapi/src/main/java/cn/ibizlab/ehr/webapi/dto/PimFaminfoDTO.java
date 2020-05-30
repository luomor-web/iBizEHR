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
 * 服务DTO对象[PimFaminfoDTO]
 */
@Data
public class PimFaminfoDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [ZJH]
     *
     */
    @JSONField(name = "zjh")
    @JsonProperty("zjh")
    private String zjh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [SFJJLLR]
     *
     */
    @JSONField(name = "sfjjllr")
    @JsonProperty("sfjjllr")
    private String sfjjllr;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PIMFAMINFONAME]
     *
     */
    @JSONField(name = "pimfaminfoname")
    @JsonProperty("pimfaminfoname")
    private String pimfaminfoname;

    /**
     * 属性 [ZJLX]
     *
     */
    @JSONField(name = "zjlx")
    @JsonProperty("zjlx")
    private String zjlx;

    /**
     * 属性 [CSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [SRUVIVORS]
     *
     */
    @JSONField(name = "sruvivors")
    @JsonProperty("sruvivors")
    private Integer sruvivors;

    /**
     * 属性 [YBRGX]
     *
     */
    @JSONField(name = "ybrgx")
    @JsonProperty("ybrgx")
    private String ybrgx;

    /**
     * 属性 [GZDW]
     *
     */
    @JSONField(name = "gzdw")
    @JsonProperty("gzdw")
    private String gzdw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [PIMFAMINFOID]
     *
     */
    @JSONField(name = "pimfaminfoid")
    @JsonProperty("pimfaminfoid")
    private String pimfaminfoid;

    /**
     * 属性 [NJ]
     *
     */
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TELPHONE]
     *
     */
    @JSONField(name = "telphone")
    @JsonProperty("telphone")
    private String telphone;

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
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [ZJH]
     */
    public void setZjh(String  zjh){
        this.zjh = zjh ;
        this.modify("zjh",zjh);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [SFJJLLR]
     */
    public void setSfjjllr(String  sfjjllr){
        this.sfjjllr = sfjjllr ;
        this.modify("sfjjllr",sfjjllr);
    }

    /**
     * 设置 [ZZMM]
     */
    public void setZzmm(String  zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [PIMFAMINFONAME]
     */
    public void setPimfaminfoname(String  pimfaminfoname){
        this.pimfaminfoname = pimfaminfoname ;
        this.modify("pimfaminfoname",pimfaminfoname);
    }

    /**
     * 设置 [ZJLX]
     */
    public void setZjlx(String  zjlx){
        this.zjlx = zjlx ;
        this.modify("zjlx",zjlx);
    }

    /**
     * 设置 [CSRQ]
     */
    public void setCsrq(Timestamp  csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 设置 [SRUVIVORS]
     */
    public void setSruvivors(Integer  sruvivors){
        this.sruvivors = sruvivors ;
        this.modify("sruvivors",sruvivors);
    }

    /**
     * 设置 [YBRGX]
     */
    public void setYbrgx(String  ybrgx){
        this.ybrgx = ybrgx ;
        this.modify("ybrgx",ybrgx);
    }

    /**
     * 设置 [GZDW]
     */
    public void setGzdw(String  gzdw){
        this.gzdw = gzdw ;
        this.modify("gzdw",gzdw);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [TELPHONE]
     */
    public void setTelphone(String  telphone){
        this.telphone = telphone ;
        this.modify("telphone",telphone);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

