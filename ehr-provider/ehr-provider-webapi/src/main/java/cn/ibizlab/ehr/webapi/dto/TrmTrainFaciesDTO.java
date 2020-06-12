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
 * 服务DTO对象[TrmTrainFaciesDTO]
 */
@Data
public class TrmTrainFaciesDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DD]
     *
     */
    @JSONField(name = "dd")
    @JsonProperty("dd")
    private String dd;

    /**
     * 属性 [TRMTRAINFACIESID]
     *
     */
    @JSONField(name = "trmtrainfaciesid")
    @JsonProperty("trmtrainfaciesid")
    private String trmtrainfaciesid;

    /**
     * 属性 [SB]
     *
     */
    @JSONField(name = "sb")
    @JsonProperty("sb")
    private String sb;

    /**
     * 属性 [SFFC]
     *
     */
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [YYSB]
     *
     */
    @JSONField(name = "yysb")
    @JsonProperty("yysb")
    private String yysb;

    /**
     * 属性 [SSLB]
     *
     */
    @JSONField(name = "sslb")
    @JsonProperty("sslb")
    private String sslb;

    /**
     * 属性 [BGSB]
     *
     */
    @JSONField(name = "bgsb")
    @JsonProperty("bgsb")
    private String bgsb;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [DGSB]
     *
     */
    @JSONField(name = "dgsb")
    @JsonProperty("dgsb")
    private String dgsb;

    /**
     * 属性 [TRMTRAINFACIESNAME]
     *
     */
    @JSONField(name = "trmtrainfaciesname")
    @JsonProperty("trmtrainfaciesname")
    private String trmtrainfaciesname;

    /**
     * 属性 [SSBM]
     *
     */
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;

    /**
     * 属性 [SFGX]
     *
     */
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SSSL]
     *
     */
    @JSONField(name = "sssl")
    @JsonProperty("sssl")
    private Integer sssl;

    /**
     * 属性 [SSZP]
     *
     */
    @JSONField(name = "sszp")
    @JsonProperty("sszp")
    private String sszp;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;


    /**
     * 设置 [DD]
     */
    public void setDd(String  dd){
        this.dd = dd ;
        this.modify("dd",dd);
    }

    /**
     * 设置 [SB]
     */
    public void setSb(String  sb){
        this.sb = sb ;
        this.modify("sb",sb);
    }

    /**
     * 设置 [SFFC]
     */
    public void setSffc(Integer  sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [YYSB]
     */
    public void setYysb(String  yysb){
        this.yysb = yysb ;
        this.modify("yysb",yysb);
    }

    /**
     * 设置 [SSLB]
     */
    public void setSslb(String  sslb){
        this.sslb = sslb ;
        this.modify("sslb",sslb);
    }

    /**
     * 设置 [BGSB]
     */
    public void setBgsb(String  bgsb){
        this.bgsb = bgsb ;
        this.modify("bgsb",bgsb);
    }

    /**
     * 设置 [DGSB]
     */
    public void setDgsb(String  dgsb){
        this.dgsb = dgsb ;
        this.modify("dgsb",dgsb);
    }

    /**
     * 设置 [TRMTRAINFACIESNAME]
     */
    public void setTrmtrainfaciesname(String  trmtrainfaciesname){
        this.trmtrainfaciesname = trmtrainfaciesname ;
        this.modify("trmtrainfaciesname",trmtrainfaciesname);
    }

    /**
     * 设置 [SSBM]
     */
    public void setSsbm(String  ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [SFGX]
     */
    public void setSfgx(Integer  sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [SSSL]
     */
    public void setSssl(Integer  sssl){
        this.sssl = sssl ;
        this.modify("sssl",sssl);
    }

    /**
     * 设置 [SSZP]
     */
    public void setSszp(String  sszp){
        this.sszp = sszp ;
        this.modify("sszp",sszp);
    }

    /**
     * 设置 [TRMTRAINADDRESSID]
     */
    public void setTrmtrainaddressid(String  trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}

