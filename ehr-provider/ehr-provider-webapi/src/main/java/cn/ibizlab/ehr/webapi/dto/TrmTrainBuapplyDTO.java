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
 * 服务DTO对象[TrmTrainBuapplyDTO]
 */
@Data
public class TrmTrainBuapplyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TRMTRAINBUAPPLYID]
     *
     */
    @JSONField(name = "trmtrainbuapplyid")
    @JsonProperty("trmtrainbuapplyid")
    private String trmtrainbuapplyid;

    /**
     * 属性 [JGFY]
     *
     */
    @JSONField(name = "jgfy")
    @JsonProperty("jgfy")
    private Double jgfy;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [TZJE]
     *
     */
    @JSONField(name = "tzje")
    @JsonProperty("tzje")
    private Double tzje;

    /**
     * 属性 [TRMTRAINBUAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainbuapplyname")
    @JsonProperty("trmtrainbuapplyname")
    private String trmtrainbuapplyname;

    /**
     * 属性 [SZF]
     *
     */
    @JSONField(name = "szf")
    @JsonProperty("szf")
    private Double szf;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [CLF]
     *
     */
    @JSONField(name = "clf")
    @JsonProperty("clf")
    private Double clf;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [QTFY]
     *
     */
    @JSONField(name = "qtfy")
    @JsonProperty("qtfy")
    private Double qtfy;

    /**
     * 属性 [CDZJ]
     *
     */
    @JSONField(name = "cdzj")
    @JsonProperty("cdzj")
    private Double cdzj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [YSZJE]
     *
     */
    @JSONField(name = "yszje")
    @JsonProperty("yszje")
    private Double yszje;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TZYSXM]
     *
     */
    @JSONField(name = "tzysxm")
    @JsonProperty("tzysxm")
    private String tzysxm;

    /**
     * 属性 [JFLX]
     *
     */
    @JSONField(name = "jflx")
    @JsonProperty("jflx")
    private String jflx;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

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
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;


    /**
     * 设置 [JGFY]
     */
    public void setJgfy(Double  jgfy){
        this.jgfy = jgfy ;
        this.modify("jgfy",jgfy);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [TZJE]
     */
    public void setTzje(Double  tzje){
        this.tzje = tzje ;
        this.modify("tzje",tzje);
    }

    /**
     * 设置 [TRMTRAINBUAPPLYNAME]
     */
    public void setTrmtrainbuapplyname(String  trmtrainbuapplyname){
        this.trmtrainbuapplyname = trmtrainbuapplyname ;
        this.modify("trmtrainbuapplyname",trmtrainbuapplyname);
    }

    /**
     * 设置 [SZF]
     */
    public void setSzf(Double  szf){
        this.szf = szf ;
        this.modify("szf",szf);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [CLF]
     */
    public void setClf(Double  clf){
        this.clf = clf ;
        this.modify("clf",clf);
    }

    /**
     * 设置 [QTFY]
     */
    public void setQtfy(Double  qtfy){
        this.qtfy = qtfy ;
        this.modify("qtfy",qtfy);
    }

    /**
     * 设置 [CDZJ]
     */
    public void setCdzj(Double  cdzj){
        this.cdzj = cdzj ;
        this.modify("cdzj",cdzj);
    }

    /**
     * 设置 [YSZJE]
     */
    public void setYszje(Double  yszje){
        this.yszje = yszje ;
        this.modify("yszje",yszje);
    }

    /**
     * 设置 [TZYSXM]
     */
    public void setTzysxm(String  tzysxm){
        this.tzysxm = tzysxm ;
        this.modify("tzysxm",tzysxm);
    }

    /**
     * 设置 [JFLX]
     */
    public void setJflx(String  jflx){
        this.jflx = jflx ;
        this.modify("jflx",jflx);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}

