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
 * 服务DTO对象[PimAchievementsDTO]
 */
@Data
public class PimAchievementsDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [EVALUATIONUNIT]
     *
     */
    @JSONField(name = "evaluationunit")
    @JsonProperty("evaluationunit")
    private String evaluationunit;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [KHDF]
     *
     */
    @JSONField(name = "khdf")
    @JsonProperty("khdf")
    private Double khdf;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [QSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;

    /**
     * 属性 [KHJL]
     *
     */
    @JSONField(name = "khjl")
    @JsonProperty("khjl")
    private String khjl;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XMJB]
     *
     */
    @JSONField(name = "xmjb")
    @JsonProperty("xmjb")
    private String xmjb;

    /**
     * 属性 [JD]
     *
     */
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PIMACHIEVEMENTSNAME]
     *
     */
    @JSONField(name = "pimachievementsname")
    @JsonProperty("pimachievementsname")
    private String pimachievementsname;

    /**
     * 属性 [PIMACHIEVEMENTSID]
     *
     */
    @JSONField(name = "pimachievementsid")
    @JsonProperty("pimachievementsid")
    private String pimachievementsid;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;

    /**
     * 属性 [YD]
     *
     */
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

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
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [EVALUATIONUNIT]
     */
    public void setEvaluationunit(String  evaluationunit){
        this.evaluationunit = evaluationunit ;
        this.modify("evaluationunit",evaluationunit);
    }

    /**
     * 设置 [KHDF]
     */
    public void setKhdf(Double  khdf){
        this.khdf = khdf ;
        this.modify("khdf",khdf);
    }

    /**
     * 设置 [QSRQ]
     */
    public void setQsrq(Timestamp  qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 设置 [KHJL]
     */
    public void setKhjl(String  khjl){
        this.khjl = khjl ;
        this.modify("khjl",khjl);
    }

    /**
     * 设置 [XMJB]
     */
    public void setXmjb(String  xmjb){
        this.xmjb = xmjb ;
        this.modify("xmjb",xmjb);
    }

    /**
     * 设置 [JD]
     */
    public void setJd(String  jd){
        this.jd = jd ;
        this.modify("jd",jd);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [PIMACHIEVEMENTSNAME]
     */
    public void setPimachievementsname(String  pimachievementsname){
        this.pimachievementsname = pimachievementsname ;
        this.modify("pimachievementsname",pimachievementsname);
    }

    /**
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [YD]
     */
    public void setYd(String  yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

