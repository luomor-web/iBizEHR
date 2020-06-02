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
 * 服务DTO对象[ParJxzgpcDTO]
 */
@Data
public class ParJxzgpcDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARJXZGPCID]
     *
     */
    @JSONField(name = "parjxzgpcid")
    @JsonProperty("parjxzgpcid")
    private String parjxzgpcid;

    /**
     * 属性 [YGNAME]
     *
     */
    @JSONField(name = "ygname")
    @JsonProperty("ygname")
    private String ygname;

    /**
     * 属性 [PFLD]
     *
     */
    @JSONField(name = "pfld")
    @JsonProperty("pfld")
    private String pfld;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [KHX]
     *
     */
    @JSONField(name = "khx")
    @JsonProperty("khx")
    private String khx;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;

    /**
     * 属性 [SSZZID]
     *
     */
    @JSONField(name = "sszzid")
    @JsonProperty("sszzid")
    private String sszzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SSBMID]
     *
     */
    @JSONField(name = "ssbmid")
    @JsonProperty("ssbmid")
    private String ssbmid;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [PARJXZGPCNAME]
     *
     */
    @JSONField(name = "parjxzgpcname")
    @JsonProperty("parjxzgpcname")
    private String parjxzgpcname;

    /**
     * 属性 [PFLDID]
     *
     */
    @JSONField(name = "pfldid")
    @JsonProperty("pfldid")
    private String pfldid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZDF]
     *
     */
    @JSONField(name = "zdf")
    @JsonProperty("zdf")
    private Double zdf;

    /**
     * 属性 [SSBM]
     *
     */
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;

    /**
     * 属性 [YGID]
     *
     */
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SSZZ]
     *
     */
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;


    /**
     * 设置 [YGNAME]
     */
    public void setYgname(String  ygname){
        this.ygname = ygname ;
        this.modify("ygname",ygname);
    }

    /**
     * 设置 [PFLD]
     */
    public void setPfld(String  pfld){
        this.pfld = pfld ;
        this.modify("pfld",pfld);
    }

    /**
     * 设置 [KHX]
     */
    public void setKhx(String  khx){
        this.khx = khx ;
        this.modify("khx",khx);
    }

    /**
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [SSZZID]
     */
    public void setSszzid(String  sszzid){
        this.sszzid = sszzid ;
        this.modify("sszzid",sszzid);
    }

    /**
     * 设置 [SSBMID]
     */
    public void setSsbmid(String  ssbmid){
        this.ssbmid = ssbmid ;
        this.modify("ssbmid",ssbmid);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PARJXZGPCNAME]
     */
    public void setParjxzgpcname(String  parjxzgpcname){
        this.parjxzgpcname = parjxzgpcname ;
        this.modify("parjxzgpcname",parjxzgpcname);
    }

    /**
     * 设置 [PFLDID]
     */
    public void setPfldid(String  pfldid){
        this.pfldid = pfldid ;
        this.modify("pfldid",pfldid);
    }

    /**
     * 设置 [ZDF]
     */
    public void setZdf(Double  zdf){
        this.zdf = zdf ;
        this.modify("zdf",zdf);
    }

    /**
     * 设置 [SSBM]
     */
    public void setSsbm(String  ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [YGID]
     */
    public void setYgid(String  ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [SSZZ]
     */
    public void setSszz(String  sszz){
        this.sszz = sszz ;
        this.modify("sszz",sszz);
    }


}

