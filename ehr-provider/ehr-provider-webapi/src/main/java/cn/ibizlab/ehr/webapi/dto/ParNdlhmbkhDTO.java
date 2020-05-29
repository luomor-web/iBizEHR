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
 * 服务DTO对象[ParNdlhmbkhDTO]
 */
@Data
public class ParNdlhmbkhDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [YGNAME]
     *
     */
    @JSONField(name = "ygname")
    @JsonProperty("ygname")
    private String ygname;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [JZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzsj" , format="yyyy-MM-dd")
    @JsonProperty("jzsj")
    private Timestamp jzsj;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZDF]
     *
     */
    @JSONField(name = "zdf")
    @JsonProperty("zdf")
    private Double zdf;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARNDLHMBKHID]
     *
     */
    @JSONField(name = "parndlhmbkhid")
    @JsonProperty("parndlhmbkhid")
    private String parndlhmbkhid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARNDLHMBKHNAME]
     *
     */
    @JSONField(name = "parndlhmbkhname")
    @JsonProperty("parndlhmbkhname")
    private String parndlhmbkhname;

    /**
     * 属性 [YGID]
     *
     */
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;


    /**
     * 设置 [YGNAME]
     */
    public void setYgname(String  ygname){
        this.ygname = ygname ;
        this.modify("ygname",ygname);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [JZSJ]
     */
    public void setJzsj(Timestamp  jzsj){
        this.jzsj = jzsj ;
        this.modify("jzsj",jzsj);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [ZDF]
     */
    public void setZdf(Double  zdf){
        this.zdf = zdf ;
        this.modify("zdf",zdf);
    }

    /**
     * 设置 [PARNDLHMBKHNAME]
     */
    public void setParndlhmbkhname(String  parndlhmbkhname){
        this.parndlhmbkhname = parndlhmbkhname ;
        this.modify("parndlhmbkhname",parndlhmbkhname);
    }

    /**
     * 设置 [YGID]
     */
    public void setYgid(String  ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }


}

