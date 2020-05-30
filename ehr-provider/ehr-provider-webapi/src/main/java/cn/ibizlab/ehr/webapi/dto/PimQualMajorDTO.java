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
 * 服务DTO对象[PimQualMajorDTO]
 */
@Data
public class PimQualMajorDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [GWZS]
     *
     */
    @JSONField(name = "gwzs")
    @JsonProperty("gwzs")
    private String gwzs;

    /**
     * 属性 [GWTYPE]
     *
     */
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;

    /**
     * 属性 [ZYJSZW]
     *
     */
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [QUAMAJOR]
     *
     */
    @JSONField(name = "quamajor")
    @JsonProperty("quamajor")
    private String quamajor;

    /**
     * 属性 [GWLX]
     *
     */
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [QUALEVEL]
     *
     */
    @JSONField(name = "qualevel")
    @JsonProperty("qualevel")
    private String qualevel;

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
     * 属性 [PIMQUALMAJORID]
     *
     */
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;

    /**
     * 属性 [ZYZGZY]
     *
     */
    @JSONField(name = "zyzgzy")
    @JsonProperty("zyzgzy")
    private String zyzgzy;

    /**
     * 属性 [PIMQUALMAJORNAME]
     *
     */
    @JSONField(name = "pimqualmajorname")
    @JsonProperty("pimqualmajorname")
    private String pimqualmajorname;

    /**
     * 属性 [PROFESSIONALTYPE]
     *
     */
    @JSONField(name = "professionaltype")
    @JsonProperty("professionaltype")
    private String professionaltype;

    /**
     * 属性 [PIMQUALTYPENAME]
     *
     */
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMQUALTYPEID]
     *
     */
    @JSONField(name = "pimqualtypeid")
    @JsonProperty("pimqualtypeid")
    private String pimqualtypeid;


    /**
     * 设置 [GWZS]
     */
    public void setGwzs(String  gwzs){
        this.gwzs = gwzs ;
        this.modify("gwzs",gwzs);
    }

    /**
     * 设置 [GWTYPE]
     */
    public void setGwtype(String  gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [ZYJSZW]
     */
    public void setZyjszw(String  zyjszw){
        this.zyjszw = zyjszw ;
        this.modify("zyjszw",zyjszw);
    }

    /**
     * 设置 [QUAMAJOR]
     */
    public void setQuamajor(String  quamajor){
        this.quamajor = quamajor ;
        this.modify("quamajor",quamajor);
    }

    /**
     * 设置 [GWLX]
     */
    public void setGwlx(String  gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }

    /**
     * 设置 [QUALEVEL]
     */
    public void setQualevel(String  qualevel){
        this.qualevel = qualevel ;
        this.modify("qualevel",qualevel);
    }

    /**
     * 设置 [PIMQUALMAJORNAME]
     */
    public void setPimqualmajorname(String  pimqualmajorname){
        this.pimqualmajorname = pimqualmajorname ;
        this.modify("pimqualmajorname",pimqualmajorname);
    }

    /**
     * 设置 [PROFESSIONALTYPE]
     */
    public void setProfessionaltype(String  professionaltype){
        this.professionaltype = professionaltype ;
        this.modify("professionaltype",professionaltype);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMQUALTYPEID]
     */
    public void setPimqualtypeid(String  pimqualtypeid){
        this.pimqualtypeid = pimqualtypeid ;
        this.modify("pimqualtypeid",pimqualtypeid);
    }


}

