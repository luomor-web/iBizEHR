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
 * 服务DTO对象[OrmOrgDTO]
 */
@Data
public class OrmOrgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [BTQY]
     *
     */
    @JSONField(name = "btqy")
    @JsonProperty("btqy")
    private String btqy;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [STARTSTOPSIGN]
     *
     */
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;

    /**
     * 属性 [COMPANYFLAG]
     *
     */
    @JSONField(name = "companyflag")
    @JsonProperty("companyflag")
    private String companyflag;

    /**
     * 属性 [LEGALENTITY]
     *
     */
    @JSONField(name = "legalentity")
    @JsonProperty("legalentity")
    private String legalentity;

    /**
     * 属性 [SSOU]
     *
     */
    @JSONField(name = "ssou")
    @JsonProperty("ssou")
    private String ssou;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZZDZBM]
     *
     */
    @JSONField(name = "zzdzbm")
    @JsonProperty("zzdzbm")
    private String zzdzbm;

    /**
     * 属性 [GSSS]
     *
     */
    @JSONField(name = "gsss")
    @JsonProperty("gsss")
    private String gsss;

    /**
     * 属性 [LEVELCODE]
     *
     */
    @JSONField(name = "levelcode")
    @JsonProperty("levelcode")
    private String levelcode;

    /**
     * 属性 [PX]
     *
     */
    @JSONField(name = "px")
    @JsonProperty("px")
    private Integer px;

    /**
     * 属性 [ZZCJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zzcjsj" , format="yyyy-MM-dd")
    @JsonProperty("zzcjsj")
    private Timestamp zzcjsj;

    /**
     * 属性 [ZZDZY]
     *
     */
    @JSONField(name = "zzdzy")
    @JsonProperty("zzdzy")
    private String zzdzy;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CORRESPONDINGORG]
     *
     */
    @JSONField(name = "correspondingorg")
    @JsonProperty("correspondingorg")
    private String correspondingorg;

    /**
     * 属性 [XN]
     *
     */
    @JSONField(name = "xn")
    @JsonProperty("xn")
    private Integer xn;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZZDZE]
     *
     */
    @JSONField(name = "zzdze")
    @JsonProperty("zzdze")
    private String zzdze;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [ERPORGID]
     *
     */
    @JSONField(name = "erporgid")
    @JsonProperty("erporgid")
    private String erporgid;

    /**
     * 属性 [ZZLX]
     *
     */
    @JSONField(name = "zzlx")
    @JsonProperty("zzlx")
    private String zzlx;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [PORGNAME]
     *
     */
    @JSONField(name = "porgname")
    @JsonProperty("porgname")
    private String porgname;

    /**
     * 属性 [PORGID]
     *
     */
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;


    /**
     * 设置 [BTQY]
     */
    public void setBtqy(String  btqy){
        this.btqy = btqy ;
        this.modify("btqy",btqy);
    }

    /**
     * 设置 [STARTSTOPSIGN]
     */
    public void setStartstopsign(String  startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [COMPANYFLAG]
     */
    public void setCompanyflag(String  companyflag){
        this.companyflag = companyflag ;
        this.modify("companyflag",companyflag);
    }

    /**
     * 设置 [LEGALENTITY]
     */
    public void setLegalentity(String  legalentity){
        this.legalentity = legalentity ;
        this.modify("legalentity",legalentity);
    }

    /**
     * 设置 [SSOU]
     */
    public void setSsou(String  ssou){
        this.ssou = ssou ;
        this.modify("ssou",ssou);
    }

    /**
     * 设置 [ZZDZBM]
     */
    public void setZzdzbm(String  zzdzbm){
        this.zzdzbm = zzdzbm ;
        this.modify("zzdzbm",zzdzbm);
    }

    /**
     * 设置 [GSSS]
     */
    public void setGsss(String  gsss){
        this.gsss = gsss ;
        this.modify("gsss",gsss);
    }

    /**
     * 设置 [LEVELCODE]
     */
    public void setLevelcode(String  levelcode){
        this.levelcode = levelcode ;
        this.modify("levelcode",levelcode);
    }

    /**
     * 设置 [PX]
     */
    public void setPx(Integer  px){
        this.px = px ;
        this.modify("px",px);
    }

    /**
     * 设置 [ZZCJSJ]
     */
    public void setZzcjsj(Timestamp  zzcjsj){
        this.zzcjsj = zzcjsj ;
        this.modify("zzcjsj",zzcjsj);
    }

    /**
     * 设置 [ZZDZY]
     */
    public void setZzdzy(String  zzdzy){
        this.zzdzy = zzdzy ;
        this.modify("zzdzy",zzdzy);
    }

    /**
     * 设置 [CORRESPONDINGORG]
     */
    public void setCorrespondingorg(String  correspondingorg){
        this.correspondingorg = correspondingorg ;
        this.modify("correspondingorg",correspondingorg);
    }

    /**
     * 设置 [XN]
     */
    public void setXn(Integer  xn){
        this.xn = xn ;
        this.modify("xn",xn);
    }

    /**
     * 设置 [ZZDZE]
     */
    public void setZzdze(String  zzdze){
        this.zzdze = zzdze ;
        this.modify("zzdze",zzdze);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [ZZDZS]
     */
    public void setZzdzs(String  zzdzs){
        this.zzdzs = zzdzs ;
        this.modify("zzdzs",zzdzs);
    }

    /**
     * 设置 [SHORTNAME]
     */
    public void setShortname(String  shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [ERPORGID]
     */
    public void setErporgid(String  erporgid){
        this.erporgid = erporgid ;
        this.modify("erporgid",erporgid);
    }

    /**
     * 设置 [ZZLX]
     */
    public void setZzlx(String  zzlx){
        this.zzlx = zzlx ;
        this.modify("zzlx",zzlx);
    }

    /**
     * 设置 [PORGID]
     */
    public void setPorgid(String  porgid){
        this.porgid = porgid ;
        this.modify("porgid",porgid);
    }


}

