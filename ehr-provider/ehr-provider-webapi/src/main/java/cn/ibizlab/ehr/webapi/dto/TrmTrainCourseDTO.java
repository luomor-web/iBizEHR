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
 * 服务DTO对象[TrmTrainCourseDTO]
 */
@Data
public class TrmTrainCourseDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JB]
     *
     */
    @JSONField(name = "jb")
    @JsonProperty("jb")
    private String jb;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [KCBM]
     *
     */
    @JSONField(name = "kcbm")
    @JsonProperty("kcbm")
    private String kcbm;

    /**
     * 属性 [KCLB]
     *
     */
    @JSONField(name = "kclb")
    @JsonProperty("kclb")
    private String kclb;

    /**
     * 属性 [BBH]
     *
     */
    @JSONField(name = "bbh")
    @JsonProperty("bbh")
    private String bbh;

    /**
     * 属性 [PXMB]
     *
     */
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;

    /**
     * 属性 [KCJS]
     *
     */
    @JSONField(name = "kcjs")
    @JsonProperty("kcjs")
    private String kcjs;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [SKFS]
     *
     */
    @JSONField(name = "skfs")
    @JsonProperty("skfs")
    private String skfs;

    /**
     * 属性 [BB]
     *
     */
    @JSONField(name = "bb")
    @JsonProperty("bb")
    private String bb;

    /**
     * 属性 [KCXS]
     *
     */
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SFFC]
     *
     */
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SFGX]
     *
     */
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [NR]
     *
     */
    @JSONField(name = "nr")
    @JsonProperty("nr")
    private String nr;

    /**
     * 属性 [TRMCOURSESYSTEMNAME]
     *
     */
    @JSONField(name = "trmcoursesystemname")
    @JsonProperty("trmcoursesystemname")
    private String trmcoursesystemname;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMCOURSESYSTEMID]
     *
     */
    @JSONField(name = "trmcoursesystemid")
    @JsonProperty("trmcoursesystemid")
    private String trmcoursesystemid;


    /**
     * 设置 [JB]
     */
    public void setJb(String  jb){
        this.jb = jb ;
        this.modify("jb",jb);
    }

    /**
     * 设置 [KCBM]
     */
    public void setKcbm(String  kcbm){
        this.kcbm = kcbm ;
        this.modify("kcbm",kcbm);
    }

    /**
     * 设置 [KCLB]
     */
    public void setKclb(String  kclb){
        this.kclb = kclb ;
        this.modify("kclb",kclb);
    }

    /**
     * 设置 [BBH]
     */
    public void setBbh(String  bbh){
        this.bbh = bbh ;
        this.modify("bbh",bbh);
    }

    /**
     * 设置 [PXMB]
     */
    public void setPxmb(String  pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [KCJS]
     */
    public void setKcjs(String  kcjs){
        this.kcjs = kcjs ;
        this.modify("kcjs",kcjs);
    }

    /**
     * 设置 [TRMTRAINCOURSENAME]
     */
    public void setTrmtraincoursename(String  trmtraincoursename){
        this.trmtraincoursename = trmtraincoursename ;
        this.modify("trmtraincoursename",trmtraincoursename);
    }

    /**
     * 设置 [SKFS]
     */
    public void setSkfs(String  skfs){
        this.skfs = skfs ;
        this.modify("skfs",skfs);
    }

    /**
     * 设置 [BB]
     */
    public void setBb(String  bb){
        this.bb = bb ;
        this.modify("bb",bb);
    }

    /**
     * 设置 [KCXS]
     */
    public void setKcxs(Double  kcxs){
        this.kcxs = kcxs ;
        this.modify("kcxs",kcxs);
    }

    /**
     * 设置 [SFFC]
     */
    public void setSffc(Integer  sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [SFGX]
     */
    public void setSfgx(Integer  sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMCOURSESYSTEMID]
     */
    public void setTrmcoursesystemid(String  trmcoursesystemid){
        this.trmcoursesystemid = trmcoursesystemid ;
        this.modify("trmcoursesystemid",trmcoursesystemid);
    }


}

