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
 * 服务DTO对象[PimEducationDTO]
 */
@Data
public class PimEducationDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [BDWGZNX]
     *
     */
    @JSONField(name = "bdwgznx")
    @JsonProperty("bdwgznx")
    private Double bdwgznx;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [SFDYXL]
     *
     */
    @JSONField(name = "sfdyxl")
    @JsonProperty("sfdyxl")
    private Integer sfdyxl;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PIMEDUCATIONID]
     *
     */
    @JSONField(name = "pimeducationid")
    @JsonProperty("pimeducationid")
    private String pimeducationid;

    /**
     * 属性 [JYMC]
     *
     */
    @JSONField(name = "jymc")
    @JsonProperty("jymc")
    private String jymc;

    /**
     * 属性 [XKML]
     *
     */
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;

    /**
     * 属性 [CJGZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SXZY]
     *
     */
    @JSONField(name = "sxzy")
    @JsonProperty("sxzy")
    private String sxzy;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [DZJBJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DEGREE]
     *
     */
    @JSONField(name = "degree")
    @JsonProperty("degree")
    private String degree;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [XWZ]
     *
     */
    @JSONField(name = "xwz")
    @JsonProperty("xwz")
    private String xwz;

    /**
     * 属性 [XLLX]
     *
     */
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;

    /**
     * 属性 [XXXZ]
     *
     */
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;

    /**
     * 属性 [TOZJDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [BTZ]
     *
     */
    @JSONField(name = "btz")
    @JsonProperty("btz")
    private String btz;

    /**
     * 属性 [XLCX]
     *
     */
    @JSONField(name = "xlcx")
    @JsonProperty("xlcx")
    private String xlcx;

    /**
     * 属性 [PIMEDUCATIONNAME]
     *
     */
    @JSONField(name = "pimeducationname")
    @JsonProperty("pimeducationname")
    private String pimeducationname;

    /**
     * 属性 [BYYX]
     *
     */
    @JSONField(name = "byyx")
    @JsonProperty("byyx")
    private String byyx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [QSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [GZNX]
     *
     */
    @JSONField(name = "gznx")
    @JsonProperty("gznx")
    private Double gznx;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [SFZGXL]
     *
     */
    @JSONField(name = "sfzgxl")
    @JsonProperty("sfzgxl")
    private Integer sfzgxl;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XL]
     *
     */
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;

    /**
     * 属性 [DBDWSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;

    /**
     * 属性 [ZJXTGZNX]
     *
     */
    @JSONField(name = "zjxtgznx")
    @JsonProperty("zjxtgznx")
    private Double zjxtgznx;

    /**
     * 属性 [BJGZNX]
     *
     */
    @JSONField(name = "bjgznx")
    @JsonProperty("bjgznx")
    private Double bjgznx;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [BDWGZNX]
     */
    public void setBdwgznx(Double  bdwgznx){
        this.bdwgznx = bdwgznx ;
        this.modify("bdwgznx",bdwgznx);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [SFDYXL]
     */
    public void setSfdyxl(Integer  sfdyxl){
        this.sfdyxl = sfdyxl ;
        this.modify("sfdyxl",sfdyxl);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JYMC]
     */
    public void setJymc(String  jymc){
        this.jymc = jymc ;
        this.modify("jymc",jymc);
    }

    /**
     * 设置 [XKML]
     */
    public void setXkml(String  xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [CJGZSJ]
     */
    public void setCjgzsj(Timestamp  cjgzsj){
        this.cjgzsj = cjgzsj ;
        this.modify("cjgzsj",cjgzsj);
    }

    /**
     * 设置 [SXZY]
     */
    public void setSxzy(String  sxzy){
        this.sxzy = sxzy ;
        this.modify("sxzy",sxzy);
    }

    /**
     * 设置 [JSSJ]
     */
    public void setJssj(Timestamp  jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 设置 [DZJBJSJ]
     */
    public void setDzjbjsj(Timestamp  dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 设置 [DEGREE]
     */
    public void setDegree(String  degree){
        this.degree = degree ;
        this.modify("degree",degree);
    }

    /**
     * 设置 [XWZ]
     */
    public void setXwz(String  xwz){
        this.xwz = xwz ;
        this.modify("xwz",xwz);
    }

    /**
     * 设置 [XLLX]
     */
    public void setXllx(String  xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [XXXZ]
     */
    public void setXxxz(String  xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [TOZJDATE]
     */
    public void setTozjdate(Timestamp  tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [BTZ]
     */
    public void setBtz(String  btz){
        this.btz = btz ;
        this.modify("btz",btz);
    }

    /**
     * 设置 [XLCX]
     */
    public void setXlcx(String  xlcx){
        this.xlcx = xlcx ;
        this.modify("xlcx",xlcx);
    }

    /**
     * 设置 [PIMEDUCATIONNAME]
     */
    public void setPimeducationname(String  pimeducationname){
        this.pimeducationname = pimeducationname ;
        this.modify("pimeducationname",pimeducationname);
    }

    /**
     * 设置 [BYYX]
     */
    public void setByyx(String  byyx){
        this.byyx = byyx ;
        this.modify("byyx",byyx);
    }

    /**
     * 设置 [QSSJ]
     */
    public void setQssj(Timestamp  qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }

    /**
     * 设置 [GZNX]
     */
    public void setGznx(Double  gznx){
        this.gznx = gznx ;
        this.modify("gznx",gznx);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [SFZGXL]
     */
    public void setSfzgxl(Integer  sfzgxl){
        this.sfzgxl = sfzgxl ;
        this.modify("sfzgxl",sfzgxl);
    }

    /**
     * 设置 [XL]
     */
    public void setXl(String  xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [DBDWSJ]
     */
    public void setDbdwsj(Timestamp  dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 设置 [ZJXTGZNX]
     */
    public void setZjxtgznx(Double  zjxtgznx){
        this.zjxtgznx = zjxtgznx ;
        this.modify("zjxtgznx",zjxtgznx);
    }

    /**
     * 设置 [BJGZNX]
     */
    public void setBjgznx(Double  bjgznx){
        this.bjgznx = bjgznx ;
        this.modify("bjgznx",bjgznx);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

