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
 * 服务DTO对象[PimVocationalDTO]
 */
@Data
public class PimVocationalDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [XZCSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xzcsj" , format="yyyy-MM-dd")
    @JsonProperty("xzcsj")
    private Timestamp xzcsj;

    /**
     * 属性 [REGISNUMBER]
     *
     */
    @JSONField(name = "regisnumber")
    @JsonProperty("regisnumber")
    private String regisnumber;

    /**
     * 属性 [SYQK]
     *
     */
    @JSONField(name = "syqk")
    @JsonProperty("syqk")
    private String syqk;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMVOCATIONALNAME]
     *
     */
    @JSONField(name = "pimvocationalname")
    @JsonProperty("pimvocationalname")
    private String pimvocationalname;

    /**
     * 属性 [ZGHQRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zghqrq" , format="yyyy-MM-dd")
    @JsonProperty("zghqrq")
    private Timestamp zghqrq;

    /**
     * 属性 [PRACTQUALCERTNO]
     *
     */
    @JSONField(name = "practqualcertno")
    @JsonProperty("practqualcertno")
    private String practqualcertno;

    /**
     * 属性 [ZSSYTS]
     *
     */
    @JSONField(name = "zssyts")
    @JsonProperty("zssyts")
    private Integer zssyts;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [FZYXQ]
     *
     */
    @JSONField(name = "fzyxq")
    @JsonProperty("fzyxq")
    private String fzyxq;

    /**
     * 属性 [SOCSECPAYUNIT]
     *
     */
    @JSONField(name = "socsecpayunit")
    @JsonProperty("socsecpayunit")
    private String socsecpayunit;

    /**
     * 属性 [BCARDNUMBER]
     *
     */
    @JSONField(name = "bcardnumber")
    @JsonProperty("bcardnumber")
    private String bcardnumber;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [SXRQ_COLOR]
     *
     */
    @JSONField(name = "sxrq_color")
    @JsonProperty("sxrq_color")
    private Integer sxrqColor;

    /**
     * 属性 [NJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "njsj" , format="yyyy-MM-dd")
    @JsonProperty("njsj")
    private Timestamp njsj;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [ZCDW]
     *
     */
    @JSONField(name = "zcdw")
    @JsonProperty("zcdw")
    private String zcdw;

    /**
     * 属性 [ZYFL]
     *
     */
    @JSONField(name = "zyfl")
    @JsonProperty("zyfl")
    private String zyfl;

    /**
     * 属性 [ZGSYDW]
     *
     */
    @JSONField(name = "zgsydw")
    @JsonProperty("zgsydw")
    private String zgsydw;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [NSQK]
     *
     */
    @JSONField(name = "nsqk")
    @JsonProperty("nsqk")
    private String nsqk;

    /**
     * 属性 [PIMVOCATIONALID]
     *
     */
    @JSONField(name = "pimvocationalid")
    @JsonProperty("pimvocationalid")
    private String pimvocationalid;

    /**
     * 属性 [ZSMC]
     *
     */
    @JSONField(name = "zsmc")
    @JsonProperty("zsmc")
    private String zsmc;

    /**
     * 属性 [ZSLX]
     *
     */
    @JSONField(name = "zslx")
    @JsonProperty("zslx")
    private String zslx;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CSZCSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cszcsj" , format="yyyy-MM-dd")
    @JsonProperty("cszcsj")
    private Timestamp cszcsj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [JBFL]
     *
     */
    @JSONField(name = "jbfl")
    @JsonProperty("jbfl")
    private String jbfl;

    /**
     * 属性 [ZGZSBH]
     *
     */
    @JSONField(name = "zgzsbh")
    @JsonProperty("zgzsbh")
    private String zgzsbh;

    /**
     * 属性 [ALTERATION]
     *
     */
    @JSONField(name = "alteration")
    @JsonProperty("alteration")
    private String alteration;

    /**
     * 属性 [ORMORGID2]
     *
     */
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMQUALMAJORNAME]
     *
     */
    @JSONField(name = "pimqualmajorname")
    @JsonProperty("pimqualmajorname")
    private String pimqualmajorname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGNAME2]
     *
     */
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;

    /**
     * 属性 [PIMVOCATIONALCATALOGNAME]
     *
     */
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;

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
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMSIGNORGNAME]
     *
     */
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [PIMQUALTYPENAME]
     *
     */
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;

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
     * 属性 [PIMVOCATIONALCATALOGID]
     *
     */
    @JSONField(name = "pimvocationalcatalogid")
    @JsonProperty("pimvocationalcatalogid")
    private String pimvocationalcatalogid;

    /**
     * 属性 [ORMSIGNORGID]
     *
     */
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMQUALMAJORID]
     *
     */
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;

    /**
     * 属性 [PIMQUALTYPEID]
     *
     */
    @JSONField(name = "pimqualtypeid")
    @JsonProperty("pimqualtypeid")
    private String pimqualtypeid;


    /**
     * 设置 [XZCSJ]
     */
    public void setXzcsj(Timestamp  xzcsj){
        this.xzcsj = xzcsj ;
        this.modify("xzcsj",xzcsj);
    }

    /**
     * 设置 [REGISNUMBER]
     */
    public void setRegisnumber(String  regisnumber){
        this.regisnumber = regisnumber ;
        this.modify("regisnumber",regisnumber);
    }

    /**
     * 设置 [SYQK]
     */
    public void setSyqk(String  syqk){
        this.syqk = syqk ;
        this.modify("syqk",syqk);
    }

    /**
     * 设置 [PIMVOCATIONALNAME]
     */
    public void setPimvocationalname(String  pimvocationalname){
        this.pimvocationalname = pimvocationalname ;
        this.modify("pimvocationalname",pimvocationalname);
    }

    /**
     * 设置 [ZGHQRQ]
     */
    public void setZghqrq(Timestamp  zghqrq){
        this.zghqrq = zghqrq ;
        this.modify("zghqrq",zghqrq);
    }

    /**
     * 设置 [PRACTQUALCERTNO]
     */
    public void setPractqualcertno(String  practqualcertno){
        this.practqualcertno = practqualcertno ;
        this.modify("practqualcertno",practqualcertno);
    }

    /**
     * 设置 [FZYXQ]
     */
    public void setFzyxq(String  fzyxq){
        this.fzyxq = fzyxq ;
        this.modify("fzyxq",fzyxq);
    }

    /**
     * 设置 [SOCSECPAYUNIT]
     */
    public void setSocsecpayunit(String  socsecpayunit){
        this.socsecpayunit = socsecpayunit ;
        this.modify("socsecpayunit",socsecpayunit);
    }

    /**
     * 设置 [BCARDNUMBER]
     */
    public void setBcardnumber(String  bcardnumber){
        this.bcardnumber = bcardnumber ;
        this.modify("bcardnumber",bcardnumber);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [NJSJ]
     */
    public void setNjsj(Timestamp  njsj){
        this.njsj = njsj ;
        this.modify("njsj",njsj);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [ZCDW]
     */
    public void setZcdw(String  zcdw){
        this.zcdw = zcdw ;
        this.modify("zcdw",zcdw);
    }

    /**
     * 设置 [ZYFL]
     */
    public void setZyfl(String  zyfl){
        this.zyfl = zyfl ;
        this.modify("zyfl",zyfl);
    }

    /**
     * 设置 [ZGSYDW]
     */
    public void setZgsydw(String  zgsydw){
        this.zgsydw = zgsydw ;
        this.modify("zgsydw",zgsydw);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [NSQK]
     */
    public void setNsqk(String  nsqk){
        this.nsqk = nsqk ;
        this.modify("nsqk",nsqk);
    }

    /**
     * 设置 [ZSLX]
     */
    public void setZslx(String  zslx){
        this.zslx = zslx ;
        this.modify("zslx",zslx);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [CSZCSJ]
     */
    public void setCszcsj(Timestamp  cszcsj){
        this.cszcsj = cszcsj ;
        this.modify("cszcsj",cszcsj);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [JBFL]
     */
    public void setJbfl(String  jbfl){
        this.jbfl = jbfl ;
        this.modify("jbfl",jbfl);
    }

    /**
     * 设置 [ZGZSBH]
     */
    public void setZgzsbh(String  zgzsbh){
        this.zgzsbh = zgzsbh ;
        this.modify("zgzsbh",zgzsbh);
    }

    /**
     * 设置 [ALTERATION]
     */
    public void setAlteration(String  alteration){
        this.alteration = alteration ;
        this.modify("alteration",alteration);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [PIMQUALMAJORNAME]
     */
    public void setPimqualmajorname(String  pimqualmajorname){
        this.pimqualmajorname = pimqualmajorname ;
        this.modify("pimqualmajorname",pimqualmajorname);
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
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMVOCATIONALCATALOGID]
     */
    public void setPimvocationalcatalogid(String  pimvocationalcatalogid){
        this.pimvocationalcatalogid = pimvocationalcatalogid ;
        this.modify("pimvocationalcatalogid",pimvocationalcatalogid);
    }

    /**
     * 设置 [ORMSIGNORGID]
     */
    public void setOrmsignorgid(String  ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PIMQUALMAJORID]
     */
    public void setPimqualmajorid(String  pimqualmajorid){
        this.pimqualmajorid = pimqualmajorid ;
        this.modify("pimqualmajorid",pimqualmajorid);
    }

    /**
     * 设置 [PIMQUALTYPEID]
     */
    public void setPimqualtypeid(String  pimqualtypeid){
        this.pimqualtypeid = pimqualtypeid ;
        this.modify("pimqualtypeid",pimqualtypeid);
    }


}

