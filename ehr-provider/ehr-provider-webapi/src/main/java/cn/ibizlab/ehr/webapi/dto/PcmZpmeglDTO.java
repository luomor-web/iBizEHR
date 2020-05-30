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
 * 服务DTO对象[PcmZpmeglDTO]
 */
@Data
public class PcmZpmeglDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [SFCE_SZY]
     *
     */
    @JSONField(name = "sfce_szy")
    @JsonProperty("sfce_szy")
    private String sfceSzy;

    /**
     * 属性 [PCMZPMEGLNAME]
     *
     */
    @JSONField(name = "pcmzpmeglname")
    @JsonProperty("pcmzpmeglname")
    private String pcmzpmeglname;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XYZPBME]
     *
     */
    @JSONField(name = "xyzpbme")
    @JsonProperty("xyzpbme")
    private Integer xyzpbme;

    /**
     * 属性 [YBDRS_SZJHW]
     *
     */
    @JSONField(name = "ybdrs_szjhw")
    @JsonProperty("ybdrs_szjhw")
    private Integer ybdrsSzjhw;

    /**
     * 属性 [SFCE_XZA]
     *
     */
    @JSONField(name = "sfce_xza")
    @JsonProperty("sfce_xza")
    private String sfceXza;

    /**
     * 属性 [SFCE_SZB]
     *
     */
    @JSONField(name = "sfce_szb")
    @JsonProperty("sfce_szb")
    private String sfceSzb;

    /**
     * 属性 [YBDRS_XZXZY]
     *
     */
    @JSONField(name = "ybdrs_xzxzy")
    @JsonProperty("ybdrs_xzxzy")
    private Integer ybdrsXzxzy;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SFCE_SZJHW]
     *
     */
    @JSONField(name = "sfce_szjhw")
    @JsonProperty("sfce_szjhw")
    private String sfceSzjhw;

    /**
     * 属性 [FPME_SZB]
     *
     */
    @JSONField(name = "fpme_szb")
    @JsonProperty("fpme_szb")
    private String fpmeSzb;

    /**
     * 属性 [PCMZPMEGLID]
     *
     */
    @JSONField(name = "pcmzpmeglid")
    @JsonProperty("pcmzpmeglid")
    private String pcmzpmeglid;

    /**
     * 属性 [SHZPYME]
     *
     */
    @JSONField(name = "shzpyme")
    @JsonProperty("shzpyme")
    private Integer shzpyme;

    /**
     * 属性 [YBDRS_XZA]
     *
     */
    @JSONField(name = "ybdrs_xza")
    @JsonProperty("ybdrs_xza")
    private Integer ybdrsXza;

    /**
     * 属性 [FPME_SZJHW]
     *
     */
    @JSONField(name = "fpme_szjhw")
    @JsonProperty("fpme_szjhw")
    private String fpmeSzjhw;

    /**
     * 属性 [YBDRS_SZB]
     *
     */
    @JSONField(name = "ybdrs_szb")
    @JsonProperty("ybdrs_szb")
    private Integer ybdrsSzb;

    /**
     * 属性 [SHZPBME]
     *
     */
    @JSONField(name = "shzpbme")
    @JsonProperty("shzpbme")
    private Integer shzpbme;

    /**
     * 属性 [FPME_XZXZY]
     *
     */
    @JSONField(name = "fpme_xzxzy")
    @JsonProperty("fpme_xzxzy")
    private String fpmeXzxzy;

    /**
     * 属性 [SHZPJHWME]
     *
     */
    @JSONField(name = "shzpjhwme")
    @JsonProperty("shzpjhwme")
    private Integer shzpjhwme;

    /**
     * 属性 [PFCS]
     *
     */
    @JSONField(name = "pfcs")
    @JsonProperty("pfcs")
    private Integer pfcs;

    /**
     * 属性 [FPME_SZY]
     *
     */
    @JSONField(name = "fpme_szy")
    @JsonProperty("fpme_szy")
    private String fpmeSzy;

    /**
     * 属性 [XYZPAME]
     *
     */
    @JSONField(name = "xyzpame")
    @JsonProperty("xyzpame")
    private Integer xyzpame;

    /**
     * 属性 [XYZPXZYME]
     *
     */
    @JSONField(name = "xyzpxzyme")
    @JsonProperty("xyzpxzyme")
    private Integer xyzpxzyme;

    /**
     * 属性 [SFCE_SZA]
     *
     */
    @JSONField(name = "sfce_sza")
    @JsonProperty("sfce_sza")
    private String sfceSza;

    /**
     * 属性 [FPME_XZB]
     *
     */
    @JSONField(name = "fpme_xzb")
    @JsonProperty("fpme_xzb")
    private String fpmeXzb;

    /**
     * 属性 [YBDRS_SZA]
     *
     */
    @JSONField(name = "ybdrs_sza")
    @JsonProperty("ybdrs_sza")
    private Integer ybdrsSza;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SFCE_XZB]
     *
     */
    @JSONField(name = "sfce_xzb")
    @JsonProperty("sfce_xzb")
    private String sfceXzb;

    /**
     * 属性 [FPME_XZA]
     *
     */
    @JSONField(name = "fpme_xza")
    @JsonProperty("fpme_xza")
    private String fpmeXza;

    /**
     * 属性 [YBDRS_XZB]
     *
     */
    @JSONField(name = "ybdrs_xzb")
    @JsonProperty("ybdrs_xzb")
    private Integer ybdrsXzb;

    /**
     * 属性 [FPME_SZA]
     *
     */
    @JSONField(name = "fpme_sza")
    @JsonProperty("fpme_sza")
    private String fpmeSza;

    /**
     * 属性 [SFCE_XZXZY]
     *
     */
    @JSONField(name = "sfce_xzxzy")
    @JsonProperty("sfce_xzxzy")
    private String sfceXzxzy;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [YBDRS_SZY]
     *
     */
    @JSONField(name = "ybdrs_szy")
    @JsonProperty("ybdrs_szy")
    private Integer ybdrsSzy;

    /**
     * 属性 [SHZPAME]
     *
     */
    @JSONField(name = "shzpame")
    @JsonProperty("shzpame")
    private Integer shzpame;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PCMZPMEGLNAME]
     */
    public void setPcmzpmeglname(String  pcmzpmeglname){
        this.pcmzpmeglname = pcmzpmeglname ;
        this.modify("pcmzpmeglname",pcmzpmeglname);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [XYZPBME]
     */
    public void setXyzpbme(Integer  xyzpbme){
        this.xyzpbme = xyzpbme ;
        this.modify("xyzpbme",xyzpbme);
    }

    /**
     * 设置 [YBDRS_SZJHW]
     */
    public void setYbdrsSzjhw(Integer  ybdrsSzjhw){
        this.ybdrsSzjhw = ybdrsSzjhw ;
        this.modify("ybdrs_szjhw",ybdrsSzjhw);
    }

    /**
     * 设置 [YBDRS_XZXZY]
     */
    public void setYbdrsXzxzy(Integer  ybdrsXzxzy){
        this.ybdrsXzxzy = ybdrsXzxzy ;
        this.modify("ybdrs_xzxzy",ybdrsXzxzy);
    }

    /**
     * 设置 [FPME_SZB]
     */
    public void setFpmeSzb(String  fpmeSzb){
        this.fpmeSzb = fpmeSzb ;
        this.modify("fpme_szb",fpmeSzb);
    }

    /**
     * 设置 [SHZPYME]
     */
    public void setShzpyme(Integer  shzpyme){
        this.shzpyme = shzpyme ;
        this.modify("shzpyme",shzpyme);
    }

    /**
     * 设置 [YBDRS_XZA]
     */
    public void setYbdrsXza(Integer  ybdrsXza){
        this.ybdrsXza = ybdrsXza ;
        this.modify("ybdrs_xza",ybdrsXza);
    }

    /**
     * 设置 [FPME_SZJHW]
     */
    public void setFpmeSzjhw(String  fpmeSzjhw){
        this.fpmeSzjhw = fpmeSzjhw ;
        this.modify("fpme_szjhw",fpmeSzjhw);
    }

    /**
     * 设置 [YBDRS_SZB]
     */
    public void setYbdrsSzb(Integer  ybdrsSzb){
        this.ybdrsSzb = ybdrsSzb ;
        this.modify("ybdrs_szb",ybdrsSzb);
    }

    /**
     * 设置 [SHZPBME]
     */
    public void setShzpbme(Integer  shzpbme){
        this.shzpbme = shzpbme ;
        this.modify("shzpbme",shzpbme);
    }

    /**
     * 设置 [FPME_XZXZY]
     */
    public void setFpmeXzxzy(String  fpmeXzxzy){
        this.fpmeXzxzy = fpmeXzxzy ;
        this.modify("fpme_xzxzy",fpmeXzxzy);
    }

    /**
     * 设置 [SHZPJHWME]
     */
    public void setShzpjhwme(Integer  shzpjhwme){
        this.shzpjhwme = shzpjhwme ;
        this.modify("shzpjhwme",shzpjhwme);
    }

    /**
     * 设置 [PFCS]
     */
    public void setPfcs(Integer  pfcs){
        this.pfcs = pfcs ;
        this.modify("pfcs",pfcs);
    }

    /**
     * 设置 [FPME_SZY]
     */
    public void setFpmeSzy(String  fpmeSzy){
        this.fpmeSzy = fpmeSzy ;
        this.modify("fpme_szy",fpmeSzy);
    }

    /**
     * 设置 [XYZPAME]
     */
    public void setXyzpame(Integer  xyzpame){
        this.xyzpame = xyzpame ;
        this.modify("xyzpame",xyzpame);
    }

    /**
     * 设置 [XYZPXZYME]
     */
    public void setXyzpxzyme(Integer  xyzpxzyme){
        this.xyzpxzyme = xyzpxzyme ;
        this.modify("xyzpxzyme",xyzpxzyme);
    }

    /**
     * 设置 [FPME_XZB]
     */
    public void setFpmeXzb(String  fpmeXzb){
        this.fpmeXzb = fpmeXzb ;
        this.modify("fpme_xzb",fpmeXzb);
    }

    /**
     * 设置 [YBDRS_SZA]
     */
    public void setYbdrsSza(Integer  ybdrsSza){
        this.ybdrsSza = ybdrsSza ;
        this.modify("ybdrs_sza",ybdrsSza);
    }

    /**
     * 设置 [FPME_XZA]
     */
    public void setFpmeXza(String  fpmeXza){
        this.fpmeXza = fpmeXza ;
        this.modify("fpme_xza",fpmeXza);
    }

    /**
     * 设置 [YBDRS_XZB]
     */
    public void setYbdrsXzb(Integer  ybdrsXzb){
        this.ybdrsXzb = ybdrsXzb ;
        this.modify("ybdrs_xzb",ybdrsXzb);
    }

    /**
     * 设置 [FPME_SZA]
     */
    public void setFpmeSza(String  fpmeSza){
        this.fpmeSza = fpmeSza ;
        this.modify("fpme_sza",fpmeSza);
    }

    /**
     * 设置 [YBDRS_SZY]
     */
    public void setYbdrsSzy(Integer  ybdrsSzy){
        this.ybdrsSzy = ybdrsSzy ;
        this.modify("ybdrs_szy",ybdrsSzy);
    }

    /**
     * 设置 [SHZPAME]
     */
    public void setShzpame(Integer  shzpame){
        this.shzpame = shzpame ;
        this.modify("shzpame",shzpame);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

