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
 * 服务DTO对象[PimTitleDTO]
 */
@Data
public class PimTitleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [SFZGZC]
     *
     */
    @JSONField(name = "sfzgzc")
    @JsonProperty("sfzgzc")
    private Integer sfzgzc;

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
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [REVIEWBODY]
     *
     */
    @JSONField(name = "reviewbody")
    @JsonProperty("reviewbody")
    private String reviewbody;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 属性 [ZCDJ]
     *
     */
    @JSONField(name = "zcdj")
    @JsonProperty("zcdj")
    private String zcdj;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [CAREERNAME]
     *
     */
    @JSONField(name = "careername")
    @JsonProperty("careername")
    private String careername;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [PIMTITLEID]
     *
     */
    @JSONField(name = "pimtitleid")
    @JsonProperty("pimtitleid")
    private String pimtitleid;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [PDJG]
     *
     */
    @JSONField(name = "pdjg")
    @JsonProperty("pdjg")
    private String pdjg;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [EMPLOYTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "employtime" , format="yyyy-MM-dd")
    @JsonProperty("employtime")
    private Timestamp employtime;

    /**
     * 属性 [ENCLOSURE]
     *
     */
    @JSONField(name = "enclosure")
    @JsonProperty("enclosure")
    private String enclosure;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ZCBH]
     *
     */
    @JSONField(name = "zcbh")
    @JsonProperty("zcbh")
    private String zcbh;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZCHQRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zchqrq" , format="yyyy-MM-dd")
    @JsonProperty("zchqrq")
    private Timestamp zchqrq;

    /**
     * 属性 [MAJORENGAGED]
     *
     */
    @JSONField(name = "majorengaged")
    @JsonProperty("majorengaged")
    private String majorengaged;

    /**
     * 属性 [LSSUINGAGENCY]
     *
     */
    @JSONField(name = "lssuingagency")
    @JsonProperty("lssuingagency")
    private String lssuingagency;

    /**
     * 属性 [PIMTITLENAME]
     *
     */
    @JSONField(name = "pimtitlename")
    @JsonProperty("pimtitlename")
    private String pimtitlename;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMTITLECATALOGUENAME]
     *
     */
    @JSONField(name = "pimtitlecataloguename")
    @JsonProperty("pimtitlecataloguename")
    private String pimtitlecataloguename;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMTITLECATALOGUEID]
     *
     */
    @JSONField(name = "pimtitlecatalogueid")
    @JsonProperty("pimtitlecatalogueid")
    private String pimtitlecatalogueid;


    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [SFZGZC]
     */
    public void setSfzgzc(Integer  sfzgzc){
        this.sfzgzc = sfzgzc ;
        this.modify("sfzgzc",sfzgzc);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [REVIEWBODY]
     */
    public void setReviewbody(String  reviewbody){
        this.reviewbody = reviewbody ;
        this.modify("reviewbody",reviewbody);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(Integer  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [ZCDJ]
     */
    public void setZcdj(String  zcdj){
        this.zcdj = zcdj ;
        this.modify("zcdj",zcdj);
    }

    /**
     * 设置 [CAREERNAME]
     */
    public void setCareername(String  careername){
        this.careername = careername ;
        this.modify("careername",careername);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [PDJG]
     */
    public void setPdjg(String  pdjg){
        this.pdjg = pdjg ;
        this.modify("pdjg",pdjg);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [EMPLOYTIME]
     */
    public void setEmploytime(Timestamp  employtime){
        this.employtime = employtime ;
        this.modify("employtime",employtime);
    }

    /**
     * 设置 [ENCLOSURE]
     */
    public void setEnclosure(String  enclosure){
        this.enclosure = enclosure ;
        this.modify("enclosure",enclosure);
    }

    /**
     * 设置 [ZCBH]
     */
    public void setZcbh(String  zcbh){
        this.zcbh = zcbh ;
        this.modify("zcbh",zcbh);
    }

    /**
     * 设置 [ZCHQRQ]
     */
    public void setZchqrq(Timestamp  zchqrq){
        this.zchqrq = zchqrq ;
        this.modify("zchqrq",zchqrq);
    }

    /**
     * 设置 [MAJORENGAGED]
     */
    public void setMajorengaged(String  majorengaged){
        this.majorengaged = majorengaged ;
        this.modify("majorengaged",majorengaged);
    }

    /**
     * 设置 [LSSUINGAGENCY]
     */
    public void setLssuingagency(String  lssuingagency){
        this.lssuingagency = lssuingagency ;
        this.modify("lssuingagency",lssuingagency);
    }

    /**
     * 设置 [PIMTITLENAME]
     */
    public void setPimtitlename(String  pimtitlename){
        this.pimtitlename = pimtitlename ;
        this.modify("pimtitlename",pimtitlename);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PIMTITLECATALOGUEID]
     */
    public void setPimtitlecatalogueid(String  pimtitlecatalogueid){
        this.pimtitlecatalogueid = pimtitlecatalogueid ;
        this.modify("pimtitlecatalogueid",pimtitlecatalogueid);
    }


}

