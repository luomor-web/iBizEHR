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
 * 服务DTO对象[TrmTrainDataDTO]
 */
@Data
public class TrmTrainDataDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [YYSL]
     *
     */
    @JSONField(name = "yysl")
    @JsonProperty("yysl")
    private Integer yysl;

    /**
     * 属性 [TRMTRAINDATAID]
     *
     */
    @JSONField(name = "trmtraindataid")
    @JsonProperty("trmtraindataid")
    private String trmtraindataid;

    /**
     * 属性 [ZLBM]
     *
     */
    @JSONField(name = "zlbm")
    @JsonProperty("zlbm")
    private String zlbm;

    /**
     * 属性 [SFGX]
     *
     */
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;

    /**
     * 属性 [CBS]
     *
     */
    @JSONField(name = "cbs")
    @JsonProperty("cbs")
    private String cbs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [XYSL]
     *
     */
    @JSONField(name = "xysl")
    @JsonProperty("xysl")
    private Integer xysl;

    /**
     * 属性 [CJGS]
     *
     */
    @JSONField(name = "cjgs")
    @JsonProperty("cjgs")
    private String cjgs;

    /**
     * 属性 [TRMTRAINDATANAME]
     *
     */
    @JSONField(name = "trmtraindataname")
    @JsonProperty("trmtraindataname")
    private String trmtraindataname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SFGC]
     *
     */
    @JSONField(name = "sfgc")
    @JsonProperty("sfgc")
    private Integer sfgc;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZLLB]
     *
     */
    @JSONField(name = "zllb")
    @JsonProperty("zllb")
    private String zllb;

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
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [YYSL]
     */
    public void setYysl(Integer  yysl){
        this.yysl = yysl ;
        this.modify("yysl",yysl);
    }

    /**
     * 设置 [ZLBM]
     */
    public void setZlbm(String  zlbm){
        this.zlbm = zlbm ;
        this.modify("zlbm",zlbm);
    }

    /**
     * 设置 [SFGX]
     */
    public void setSfgx(Integer  sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [CBS]
     */
    public void setCbs(String  cbs){
        this.cbs = cbs ;
        this.modify("cbs",cbs);
    }

    /**
     * 设置 [XYSL]
     */
    public void setXysl(Integer  xysl){
        this.xysl = xysl ;
        this.modify("xysl",xysl);
    }

    /**
     * 设置 [CJGS]
     */
    public void setCjgs(String  cjgs){
        this.cjgs = cjgs ;
        this.modify("cjgs",cjgs);
    }

    /**
     * 设置 [TRMTRAINDATANAME]
     */
    public void setTrmtraindataname(String  trmtraindataname){
        this.trmtraindataname = trmtraindataname ;
        this.modify("trmtraindataname",trmtraindataname);
    }

    /**
     * 设置 [SFGC]
     */
    public void setSfgc(Integer  sfgc){
        this.sfgc = sfgc ;
        this.modify("sfgc",sfgc);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [ZLLB]
     */
    public void setZllb(String  zllb){
        this.zllb = zllb ;
        this.modify("zllb",zllb);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

