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
 * 服务DTO对象[ParJxkhxhzDTO]
 */
@Data
public class ParJxkhxhzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [JSWMJC]
     *
     */
    @JSONField(name = "jswmjc")
    @JsonProperty("jswmjc")
    private Double jswmjc;

    /**
     * 属性 [SZMZPY]
     *
     */
    @JSONField(name = "szmzpy")
    @JsonProperty("szmzpy")
    private Double szmzpy;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;

    /**
     * 属性 [YWNLKS]
     *
     */
    @JSONField(name = "ywnlks")
    @JsonProperty("ywnlks")
    private Double ywnlks;

    /**
     * 属性 [PARJXKHXHZNAME]
     *
     */
    @JSONField(name = "parjxkhxhzname")
    @JsonProperty("parjxkhxhzname")
    private String parjxkhxhzname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [YGID]
     *
     */
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;

    /**
     * 属性 [GZNLJTD]
     *
     */
    @JSONField(name = "gznljtd")
    @JsonProperty("gznljtd")
    private Double gznljtd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [GZNLJTD_XBN]
     *
     */
    @JSONField(name = "gznljtd_xbn")
    @JsonProperty("gznljtd_xbn")
    private Double gznljtdXbn;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARJXKHXHZID]
     *
     */
    @JSONField(name = "parjxkhxhzid")
    @JsonProperty("parjxkhxhzid")
    private String parjxkhxhzid;

    /**
     * 属性 [GZJX]
     *
     */
    @JSONField(name = "gzjx")
    @JsonProperty("gzjx")
    private Double gzjx;

    /**
     * 属性 [YG]
     *
     */
    @JSONField(name = "yg")
    @JsonProperty("yg")
    private String yg;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [PARASSESSTEMPLATEID]
     *
     */
    @JSONField(name = "parassesstemplateid")
    @JsonProperty("parassesstemplateid")
    private String parassesstemplateid;

    /**
     * 属性 [PARASSESSTEMPLATENAME]
     *
     */
    @JSONField(name = "parassesstemplatename")
    @JsonProperty("parassesstemplatename")
    private String parassesstemplatename;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;


    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [JSWMJC]
     */
    public void setJswmjc(Double  jswmjc){
        this.jswmjc = jswmjc ;
        this.modify("jswmjc",jswmjc);
    }

    /**
     * 设置 [SZMZPY]
     */
    public void setSzmzpy(Double  szmzpy){
        this.szmzpy = szmzpy ;
        this.modify("szmzpy",szmzpy);
    }

    /**
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [YWNLKS]
     */
    public void setYwnlks(Double  ywnlks){
        this.ywnlks = ywnlks ;
        this.modify("ywnlks",ywnlks);
    }

    /**
     * 设置 [PARJXKHXHZNAME]
     */
    public void setParjxkhxhzname(String  parjxkhxhzname){
        this.parjxkhxhzname = parjxkhxhzname ;
        this.modify("parjxkhxhzname",parjxkhxhzname);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [YGID]
     */
    public void setYgid(String  ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [GZNLJTD]
     */
    public void setGznljtd(Double  gznljtd){
        this.gznljtd = gznljtd ;
        this.modify("gznljtd",gznljtd);
    }

    /**
     * 设置 [GZNLJTD_XBN]
     */
    public void setGznljtdXbn(Double  gznljtdXbn){
        this.gznljtdXbn = gznljtdXbn ;
        this.modify("gznljtd_xbn",gznljtdXbn);
    }

    /**
     * 设置 [GZJX]
     */
    public void setGzjx(Double  gzjx){
        this.gzjx = gzjx ;
        this.modify("gzjx",gzjx);
    }

    /**
     * 设置 [YG]
     */
    public void setYg(String  yg){
        this.yg = yg ;
        this.modify("yg",yg);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [PARASSESSTEMPLATEID]
     */
    public void setParassesstemplateid(String  parassesstemplateid){
        this.parassesstemplateid = parassesstemplateid ;
        this.modify("parassesstemplateid",parassesstemplateid);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }


}

