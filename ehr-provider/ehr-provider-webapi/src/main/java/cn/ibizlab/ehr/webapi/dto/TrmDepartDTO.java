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
 * 服务DTO对象[TrmDepartDTO]
 */
@Data
public class TrmDepartDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TRMDEPARTNAME]
     *
     */
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [LCLX]
     *
     */
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;

    /**
     * 属性 [XQLYLX]
     *
     */
    @JSONField(name = "xqlylx")
    @JsonProperty("xqlylx")
    private String xqlylx;

    /**
     * 属性 [XQDBM]
     *
     */
    @JSONField(name = "xqdbm")
    @JsonProperty("xqdbm")
    private String xqdbm;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SPFS]
     *
     */
    @JSONField(name = "spfs")
    @JsonProperty("spfs")
    private String spfs;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TZLX]
     *
     */
    @JSONField(name = "tzlx")
    @JsonProperty("tzlx")
    private String tzlx;

    /**
     * 属性 [TRMDEPARTID]
     *
     */
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JD]
     *
     */
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;

    /**
     * 属性 [TDRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tdrq" , format="yyyy-MM-dd")
    @JsonProperty("tdrq")
    private Timestamp tdrq;

    /**
     * 属性 [JZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzrq" , format="yyyy-MM-dd")
    @JsonProperty("jzrq")
    private Timestamp jzrq;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

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
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [TRMDEPARTNAME]
     */
    public void setTrmdepartname(String  trmdepartname){
        this.trmdepartname = trmdepartname ;
        this.modify("trmdepartname",trmdepartname);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [LCLX]
     */
    public void setLclx(String  lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [XQLYLX]
     */
    public void setXqlylx(String  xqlylx){
        this.xqlylx = xqlylx ;
        this.modify("xqlylx",xqlylx);
    }

    /**
     * 设置 [XQDBM]
     */
    public void setXqdbm(String  xqdbm){
        this.xqdbm = xqdbm ;
        this.modify("xqdbm",xqdbm);
    }

    /**
     * 设置 [SPFS]
     */
    public void setSpfs(String  spfs){
        this.spfs = spfs ;
        this.modify("spfs",spfs);
    }

    /**
     * 设置 [TZLX]
     */
    public void setTzlx(String  tzlx){
        this.tzlx = tzlx ;
        this.modify("tzlx",tzlx);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [JD]
     */
    public void setJd(String  jd){
        this.jd = jd ;
        this.modify("jd",jd);
    }

    /**
     * 设置 [TDRQ]
     */
    public void setTdrq(Timestamp  tdrq){
        this.tdrq = tdrq ;
        this.modify("tdrq",tdrq);
    }

    /**
     * 设置 [JZRQ]
     */
    public void setJzrq(Timestamp  jzrq){
        this.jzrq = jzrq ;
        this.modify("jzrq",jzrq);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

