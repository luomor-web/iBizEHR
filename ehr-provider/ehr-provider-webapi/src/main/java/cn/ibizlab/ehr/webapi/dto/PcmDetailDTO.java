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
 * 服务DTO对象[PcmDetailDTO]
 */
@Data
public class PcmDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [CJGZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZGXLSXZY]
     *
     */
    @JSONField(name = "zgxlsxzy")
    @JsonProperty("zgxlsxzy")
    private String zgxlsxzy;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [SFZCKJS]
     *
     */
    @JSONField(name = "sfzckjs")
    @JsonProperty("sfzckjs")
    private Integer sfzckjs;

    /**
     * 属性 [HYZK]
     *
     */
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;

    /**
     * 属性 [ZGXLBYYX]
     *
     */
    @JSONField(name = "zgxlbyyx")
    @JsonProperty("zgxlbyyx")
    private String zgxlbyyx;

    /**
     * 属性 [FIRSTEDUCATION]
     *
     */
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private Integer firsteducation;

    /**
     * 属性 [QSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;

    /**
     * 属性 [ZGXXLB]
     *
     */
    @JSONField(name = "zgxxlb")
    @JsonProperty("zgxxlb")
    private String zgxxlb;

    /**
     * 属性 [HTSYQ]
     *
     */
    @JSONField(name = "htsyq")
    @JsonProperty("htsyq")
    private String htsyq;

    /**
     * 属性 [DYXLBYYX]
     *
     */
    @JSONField(name = "dyxlbyyx")
    @JsonProperty("dyxlbyyx")
    private String dyxlbyyx;

    /**
     * 属性 [PCMDETAILID]
     *
     */
    @JSONField(name = "pcmdetailid")
    @JsonProperty("pcmdetailid")
    private String pcmdetailid;

    /**
     * 属性 [CSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [SBCJD]
     *
     */
    @JSONField(name = "sbcjd")
    @JsonProperty("sbcjd")
    private String sbcjd;

    /**
     * 属性 [DYXL]
     *
     */
    @JSONField(name = "dyxl")
    @JsonProperty("dyxl")
    private String dyxl;

    /**
     * 属性 [DYXLSXZY]
     *
     */
    @JSONField(name = "dyxlsxzy")
    @JsonProperty("dyxlsxzy")
    private String dyxlsxzy;

    /**
     * 属性 [ZGXLJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zgxljssj" , format="yyyy-MM-dd")
    @JsonProperty("zgxljssj")
    private Timestamp zgxljssj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DBDWSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [GWTYPE]
     *
     */
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;

    /**
     * 属性 [RDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;

    /**
     * 属性 [XXLB]
     *
     */
    @JSONField(name = "xxlb")
    @JsonProperty("xxlb")
    private String xxlb;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PX]
     *
     */
    @JSONField(name = "px")
    @JsonProperty("px")
    private String px;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [CONTRACTTYPE]
     *
     */
    @JSONField(name = "contracttype")
    @JsonProperty("contracttype")
    private String contracttype;

    /**
     * 属性 [PIMQUALTYPENAME]
     *
     */
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;

    /**
     * 属性 [XLLX]
     *
     */
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;

    /**
     * 属性 [CAREERNAME]
     *
     */
    @JSONField(name = "careername")
    @JsonProperty("careername")
    private String careername;

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
     * 属性 [ZGXLLX]
     *
     */
    @JSONField(name = "zgxllx")
    @JsonProperty("zgxllx")
    private String zgxllx;

    /**
     * 属性 [TOZJDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;

    /**
     * 属性 [JXKHCJ]
     *
     */
    @JSONField(name = "jxkhcj")
    @JsonProperty("jxkhcj")
    private String jxkhcj;

    /**
     * 属性 [DYXLJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dyxljssj" , format="yyyy-MM-dd")
    @JsonProperty("dyxljssj")
    private Timestamp dyxljssj;

    /**
     * 属性 [YGLX]
     *
     */
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;

    /**
     * 属性 [PCMDETAILNAME]
     *
     */
    @JSONField(name = "pcmdetailname")
    @JsonProperty("pcmdetailname")
    private String pcmdetailname;

    /**
     * 属性 [DZJBJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [KSTGKMS]
     *
     */
    @JSONField(name = "kstgkms")
    @JsonProperty("kstgkms")
    private String kstgkms;

    /**
     * 属性 [ZGZSBH]
     *
     */
    @JSONField(name = "zgzsbh")
    @JsonProperty("zgzsbh")
    private String zgzsbh;

    /**
     * 属性 [RZQD]
     *
     */
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;

    /**
     * 属性 [PIMVOCATIONALCATALOGNAME]
     *
     */
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [ZCBH]
     *
     */
    @JSONField(name = "zcbh")
    @JsonProperty("zcbh")
    private String zcbh;

    /**
     * 属性 [PIMMAJORSETYPENAME]
     *
     */
    @JSONField(name = "pimmajorsetypename")
    @JsonProperty("pimmajorsetypename")
    private String pimmajorsetypename;

    /**
     * 属性 [ZJXTGZNX]
     *
     */
    @JSONField(name = "zjxtgznx")
    @JsonProperty("zjxtgznx")
    private Double zjxtgznx;

    /**
     * 属性 [GZNX]
     *
     */
    @JSONField(name = "gznx")
    @JsonProperty("gznx")
    private Double gznx;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [HTLB]
     *
     */
    @JSONField(name = "htlb")
    @JsonProperty("htlb")
    private String htlb;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ZGXL]
     *
     */
    @JSONField(name = "zgxl")
    @JsonProperty("zgxl")
    private String zgxl;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [BJGZNX]
     *
     */
    @JSONField(name = "bjgznx")
    @JsonProperty("bjgznx")
    private Double bjgznx;

    /**
     * 属性 [JG]
     *
     */
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;

    /**
     * 属性 [HJDZ]
     *
     */
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;

    /**
     * 属性 [BDWGZNX]
     *
     */
    @JSONField(name = "bdwgznx")
    @JsonProperty("bdwgznx")
    private Double bdwgznx;

    /**
     * 属性 [HTQX]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "htqx" , format="yyyy-MM-dd")
    @JsonProperty("htqx")
    private Timestamp htqx;

    /**
     * 属性 [NJ]
     *
     */
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;

    /**
     * 属性 [HKXZ]
     *
     */
    @JSONField(name = "hkxz")
    @JsonProperty("hkxz")
    private String hkxz;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [SFZGXL]
     *
     */
    @JSONField(name = "sfzgxl")
    @JsonProperty("sfzgxl")
    private Integer sfzgxl;

    /**
     * 属性 [MZ]
     *
     */
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

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
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [CJGZSJ]
     */
    public void setCjgzsj(Timestamp  cjgzsj){
        this.cjgzsj = cjgzsj ;
        this.modify("cjgzsj",cjgzsj);
    }

    /**
     * 设置 [ZGXLSXZY]
     */
    public void setZgxlsxzy(String  zgxlsxzy){
        this.zgxlsxzy = zgxlsxzy ;
        this.modify("zgxlsxzy",zgxlsxzy);
    }

    /**
     * 设置 [ZJHM]
     */
    public void setZjhm(String  zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [SFZCKJS]
     */
    public void setSfzckjs(Integer  sfzckjs){
        this.sfzckjs = sfzckjs ;
        this.modify("sfzckjs",sfzckjs);
    }

    /**
     * 设置 [HYZK]
     */
    public void setHyzk(String  hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }

    /**
     * 设置 [ZGXLBYYX]
     */
    public void setZgxlbyyx(String  zgxlbyyx){
        this.zgxlbyyx = zgxlbyyx ;
        this.modify("zgxlbyyx",zgxlbyyx);
    }

    /**
     * 设置 [FIRSTEDUCATION]
     */
    public void setFirsteducation(Integer  firsteducation){
        this.firsteducation = firsteducation ;
        this.modify("firsteducation",firsteducation);
    }

    /**
     * 设置 [QSRQ]
     */
    public void setQsrq(Timestamp  qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 设置 [ZGXXLB]
     */
    public void setZgxxlb(String  zgxxlb){
        this.zgxxlb = zgxxlb ;
        this.modify("zgxxlb",zgxxlb);
    }

    /**
     * 设置 [HTSYQ]
     */
    public void setHtsyq(String  htsyq){
        this.htsyq = htsyq ;
        this.modify("htsyq",htsyq);
    }

    /**
     * 设置 [DYXLBYYX]
     */
    public void setDyxlbyyx(String  dyxlbyyx){
        this.dyxlbyyx = dyxlbyyx ;
        this.modify("dyxlbyyx",dyxlbyyx);
    }

    /**
     * 设置 [CSRQ]
     */
    public void setCsrq(Timestamp  csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 设置 [SBCJD]
     */
    public void setSbcjd(String  sbcjd){
        this.sbcjd = sbcjd ;
        this.modify("sbcjd",sbcjd);
    }

    /**
     * 设置 [DYXL]
     */
    public void setDyxl(String  dyxl){
        this.dyxl = dyxl ;
        this.modify("dyxl",dyxl);
    }

    /**
     * 设置 [DYXLSXZY]
     */
    public void setDyxlsxzy(String  dyxlsxzy){
        this.dyxlsxzy = dyxlsxzy ;
        this.modify("dyxlsxzy",dyxlsxzy);
    }

    /**
     * 设置 [ZGXLJSSJ]
     */
    public void setZgxljssj(Timestamp  zgxljssj){
        this.zgxljssj = zgxljssj ;
        this.modify("zgxljssj",zgxljssj);
    }

    /**
     * 设置 [DBDWSJ]
     */
    public void setDbdwsj(Timestamp  dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [GWTYPE]
     */
    public void setGwtype(String  gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [RDSJ]
     */
    public void setRdsj(Timestamp  rdsj){
        this.rdsj = rdsj ;
        this.modify("rdsj",rdsj);
    }

    /**
     * 设置 [XXLB]
     */
    public void setXxlb(String  xxlb){
        this.xxlb = xxlb ;
        this.modify("xxlb",xxlb);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PX]
     */
    public void setPx(String  px){
        this.px = px ;
        this.modify("px",px);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [CONTRACTTYPE]
     */
    public void setContracttype(String  contracttype){
        this.contracttype = contracttype ;
        this.modify("contracttype",contracttype);
    }

    /**
     * 设置 [PIMQUALTYPENAME]
     */
    public void setPimqualtypename(String  pimqualtypename){
        this.pimqualtypename = pimqualtypename ;
        this.modify("pimqualtypename",pimqualtypename);
    }

    /**
     * 设置 [XLLX]
     */
    public void setXllx(String  xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [CAREERNAME]
     */
    public void setCareername(String  careername){
        this.careername = careername ;
        this.modify("careername",careername);
    }

    /**
     * 设置 [ZGXLLX]
     */
    public void setZgxllx(String  zgxllx){
        this.zgxllx = zgxllx ;
        this.modify("zgxllx",zgxllx);
    }

    /**
     * 设置 [TOZJDATE]
     */
    public void setTozjdate(Timestamp  tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 设置 [JXKHCJ]
     */
    public void setJxkhcj(String  jxkhcj){
        this.jxkhcj = jxkhcj ;
        this.modify("jxkhcj",jxkhcj);
    }

    /**
     * 设置 [DYXLJSSJ]
     */
    public void setDyxljssj(Timestamp  dyxljssj){
        this.dyxljssj = dyxljssj ;
        this.modify("dyxljssj",dyxljssj);
    }

    /**
     * 设置 [YGLX]
     */
    public void setYglx(String  yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [PCMDETAILNAME]
     */
    public void setPcmdetailname(String  pcmdetailname){
        this.pcmdetailname = pcmdetailname ;
        this.modify("pcmdetailname",pcmdetailname);
    }

    /**
     * 设置 [DZJBJSJ]
     */
    public void setDzjbjsj(Timestamp  dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 设置 [ZZMM]
     */
    public void setZzmm(String  zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [KSTGKMS]
     */
    public void setKstgkms(String  kstgkms){
        this.kstgkms = kstgkms ;
        this.modify("kstgkms",kstgkms);
    }

    /**
     * 设置 [ZGZSBH]
     */
    public void setZgzsbh(String  zgzsbh){
        this.zgzsbh = zgzsbh ;
        this.modify("zgzsbh",zgzsbh);
    }

    /**
     * 设置 [RZQD]
     */
    public void setRzqd(String  rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [PIMVOCATIONALCATALOGNAME]
     */
    public void setPimvocationalcatalogname(String  pimvocationalcatalogname){
        this.pimvocationalcatalogname = pimvocationalcatalogname ;
        this.modify("pimvocationalcatalogname",pimvocationalcatalogname);
    }

    /**
     * 设置 [RANK]
     */
    public void setRank(String  rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [ZCBH]
     */
    public void setZcbh(String  zcbh){
        this.zcbh = zcbh ;
        this.modify("zcbh",zcbh);
    }

    /**
     * 设置 [PIMMAJORSETYPENAME]
     */
    public void setPimmajorsetypename(String  pimmajorsetypename){
        this.pimmajorsetypename = pimmajorsetypename ;
        this.modify("pimmajorsetypename",pimmajorsetypename);
    }

    /**
     * 设置 [ZJXTGZNX]
     */
    public void setZjxtgznx(Double  zjxtgznx){
        this.zjxtgznx = zjxtgznx ;
        this.modify("zjxtgznx",zjxtgznx);
    }

    /**
     * 设置 [GZNX]
     */
    public void setGznx(Double  gznx){
        this.gznx = gznx ;
        this.modify("gznx",gznx);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [HTLB]
     */
    public void setHtlb(String  htlb){
        this.htlb = htlb ;
        this.modify("htlb",htlb);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [ZGXL]
     */
    public void setZgxl(String  zgxl){
        this.zgxl = zgxl ;
        this.modify("zgxl",zgxl);
    }

    /**
     * 设置 [BJGZNX]
     */
    public void setBjgznx(Double  bjgznx){
        this.bjgznx = bjgznx ;
        this.modify("bjgznx",bjgznx);
    }

    /**
     * 设置 [JG]
     */
    public void setJg(String  jg){
        this.jg = jg ;
        this.modify("jg",jg);
    }

    /**
     * 设置 [HJDZ]
     */
    public void setHjdz(String  hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [BDWGZNX]
     */
    public void setBdwgznx(Double  bdwgznx){
        this.bdwgznx = bdwgznx ;
        this.modify("bdwgznx",bdwgznx);
    }

    /**
     * 设置 [HTQX]
     */
    public void setHtqx(Timestamp  htqx){
        this.htqx = htqx ;
        this.modify("htqx",htqx);
    }

    /**
     * 设置 [NJ]
     */
    public void setNj(Integer  nj){
        this.nj = nj ;
        this.modify("nj",nj);
    }

    /**
     * 设置 [HKXZ]
     */
    public void setHkxz(String  hkxz){
        this.hkxz = hkxz ;
        this.modify("hkxz",hkxz);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [SFZGXL]
     */
    public void setSfzgxl(Integer  sfzgxl){
        this.sfzgxl = sfzgxl ;
        this.modify("sfzgxl",sfzgxl);
    }

    /**
     * 设置 [MZ]
     */
    public void setMz(String  mz){
        this.mz = mz ;
        this.modify("mz",mz);
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

