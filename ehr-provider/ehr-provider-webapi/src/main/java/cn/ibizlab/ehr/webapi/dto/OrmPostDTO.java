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
 * 服务DTO对象[OrmPostDTO]
 */
@Data
public class OrmPostDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [LGNX]
     *
     */
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private Integer lgnx;

    /**
     * 属性 [BXJLNX]
     *
     */
    @JSONField(name = "bxjlnx")
    @JsonProperty("bxjlnx")
    private Integer bxjlnx;

    /**
     * 属性 [ISTEMP]
     *
     */
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private String istemp;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [GWTYPE]
     *
     */
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;

    /**
     * 属性 [QZLGNX]
     *
     */
    @JSONField(name = "qzlgnx")
    @JsonProperty("qzlgnx")
    private Integer qzlgnx;

    /**
     * 属性 [POSTNATURE]
     *
     */
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;

    /**
     * 属性 [ISKEYPOSTION]
     *
     */
    @JSONField(name = "iskeypostion")
    @JsonProperty("iskeypostion")
    private String iskeypostion;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [NX]
     *
     */
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Integer nx;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ISCONFIDENTIAL]
     *
     */
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [GWFL]
     *
     */
    @JSONField(name = "gwfl")
    @JsonProperty("gwfl")
    private String gwfl;

    /**
     * 属性 [STARTSTOPSIGN]
     *
     */
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

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
     * 设置 [LGNX]
     */
    public void setLgnx(Integer  lgnx){
        this.lgnx = lgnx ;
        this.modify("lgnx",lgnx);
    }

    /**
     * 设置 [BXJLNX]
     */
    public void setBxjlnx(Integer  bxjlnx){
        this.bxjlnx = bxjlnx ;
        this.modify("bxjlnx",bxjlnx);
    }

    /**
     * 设置 [ISTEMP]
     */
    public void setIstemp(String  istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [GWTYPE]
     */
    public void setGwtype(String  gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [QZLGNX]
     */
    public void setQzlgnx(Integer  qzlgnx){
        this.qzlgnx = qzlgnx ;
        this.modify("qzlgnx",qzlgnx);
    }

    /**
     * 设置 [POSTNATURE]
     */
    public void setPostnature(String  postnature){
        this.postnature = postnature ;
        this.modify("postnature",postnature);
    }

    /**
     * 设置 [ISKEYPOSTION]
     */
    public void setIskeypostion(String  iskeypostion){
        this.iskeypostion = iskeypostion ;
        this.modify("iskeypostion",iskeypostion);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [NX]
     */
    public void setNx(Integer  nx){
        this.nx = nx ;
        this.modify("nx",nx);
    }

    /**
     * 设置 [ISCONFIDENTIAL]
     */
    public void setIsconfidential(String  isconfidential){
        this.isconfidential = isconfidential ;
        this.modify("isconfidential",isconfidential);
    }

    /**
     * 设置 [ORMPOSTNAME]
     */
    public void setOrmpostname(String  ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [GWFL]
     */
    public void setGwfl(String  gwfl){
        this.gwfl = gwfl ;
        this.modify("gwfl",gwfl);
    }

    /**
     * 设置 [STARTSTOPSIGN]
     */
    public void setStartstopsign(String  startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

