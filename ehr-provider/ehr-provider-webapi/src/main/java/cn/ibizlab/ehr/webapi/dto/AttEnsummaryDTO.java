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
 * 服务DTO对象[AttEnsummaryDTO]
 */
@Data
public class AttEnsummaryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GS]
     *
     */
    @JSONField(name = "gs")
    @JsonProperty("gs")
    private Double gs;

    /**
     * 属性 [ZTF]
     *
     */
    @JSONField(name = "ztf")
    @JsonProperty("ztf")
    private Double ztf;

    /**
     * 属性 [BJ]
     *
     */
    @JSONField(name = "bj")
    @JsonProperty("bj")
    private Double bj;

    /**
     * 属性 [CC]
     *
     */
    @JSONField(name = "cc")
    @JsonProperty("cc")
    private Double cc;

    /**
     * 属性 [BEGINDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "begindate" , format="yyyy-MM-dd")
    @JsonProperty("begindate")
    private Timestamp begindate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [NX]
     *
     */
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Double nx;

    /**
     * 属性 [KG]
     *
     */
    @JSONField(name = "kg")
    @JsonProperty("kg")
    private Double kg;

    /**
     * 属性 [YF]
     *
     */
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;

    /**
     * 属性 [GZRJB]
     *
     */
    @JSONField(name = "gzrjb")
    @JsonProperty("gzrjb")
    private Double gzrjb;

    /**
     * 属性 [JS]
     *
     */
    @JSONField(name = "js")
    @JsonProperty("js")
    private Double js;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [FDJRJB]
     *
     */
    @JSONField(name = "fdjrjb")
    @JsonProperty("fdjrjb")
    private Double fdjrjb;

    /**
     * 属性 [CDF]
     *
     */
    @JSONField(name = "cdf")
    @JsonProperty("cdf")
    private Double cdf;

    /**
     * 属性 [ZTC]
     *
     */
    @JSONField(name = "ztc")
    @JsonProperty("ztc")
    private Integer ztc;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private Double zt;

    /**
     * 属性 [TCXX]
     *
     */
    @JSONField(name = "tcxx")
    @JsonProperty("tcxx")
    private Double tcxx;

    /**
     * 属性 [REMARKREASON]
     *
     */
    @JSONField(name = "remarkreason")
    @JsonProperty("remarkreason")
    private String remarkreason;

    /**
     * 属性 [ZHTS]
     *
     */
    @JSONField(name = "zhts")
    @JsonProperty("zhts")
    private Double zhts;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TX]
     *
     */
    @JSONField(name = "tx")
    @JsonProperty("tx")
    private Double tx;

    /**
     * 属性 [WQDTS]
     *
     */
    @JSONField(name = "wqdts")
    @JsonProperty("wqdts")
    private Double wqdts;

    /**
     * 属性 [BR]
     *
     */
    @JSONField(name = "br")
    @JsonProperty("br")
    private Double br;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TQ]
     *
     */
    @JSONField(name = "tq")
    @JsonProperty("tq")
    private Double tq;

    /**
     * 属性 [SJ]
     *
     */
    @JSONField(name = "sj")
    @JsonProperty("sj")
    private Double sj;

    /**
     * 属性 [QQ]
     *
     */
    @JSONField(name = "qq")
    @JsonProperty("qq")
    private Double qq;

    /**
     * 属性 [PC]
     *
     */
    @JSONField(name = "pc")
    @JsonProperty("pc")
    private Double pc;

    /**
     * 属性 [SZ]
     *
     */
    @JSONField(name = "sz")
    @JsonProperty("sz")
    private Double sz;

    /**
     * 属性 [CD]
     *
     */
    @JSONField(name = "cd")
    @JsonProperty("cd")
    private Double cd;

    /**
     * 属性 [BQ]
     *
     */
    @JSONField(name = "bq")
    @JsonProperty("bq")
    private Double bq;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [JH]
     *
     */
    @JSONField(name = "jh")
    @JsonProperty("jh")
    private Double jh;

    /**
     * 属性 [XXRJB]
     *
     */
    @JSONField(name = "xxrjb")
    @JsonProperty("xxrjb")
    private Double xxrjb;

    /**
     * 属性 [SJCQTS]
     *
     */
    @JSONField(name = "sjcqts")
    @JsonProperty("sjcqts")
    private Double sjcqts;

    /**
     * 属性 [ATTENSUMMARYNAME]
     *
     */
    @JSONField(name = "attensummaryname")
    @JsonProperty("attensummaryname")
    private String attensummaryname;

    /**
     * 属性 [DESCRIPTION]
     *
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    private String description;

    /**
     * 属性 [CJ]
     *
     */
    @JSONField(name = "cj")
    @JsonProperty("cj")
    private Double cj;

    /**
     * 属性 [QT]
     *
     */
    @JSONField(name = "qt")
    @JsonProperty("qt")
    private Double qt;

    /**
     * 属性 [CDC]
     *
     */
    @JSONField(name = "cdc")
    @JsonProperty("cdc")
    private Integer cdc;

    /**
     * 属性 [ATTENSUMMARYID]
     *
     */
    @JSONField(name = "attensummaryid")
    @JsonProperty("attensummaryid")
    private String attensummaryid;

    /**
     * 属性 [ENDDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "enddate" , format="yyyy-MM-dd")
    @JsonProperty("enddate")
    private Timestamp enddate;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [YQ]
     *
     */
    @JSONField(name = "yq")
    @JsonProperty("yq")
    private Double yq;

    /**
     * 属性 [QTDXJ]
     *
     */
    @JSONField(name = "qtdxj")
    @JsonProperty("qtdxj")
    private Double qtdxj;

    /**
     * 属性 [SDT]
     *
     */
    @JSONField(name = "sdt")
    @JsonProperty("sdt")
    private Double sdt;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [GS]
     */
    public void setGs(Double  gs){
        this.gs = gs ;
        this.modify("gs",gs);
    }

    /**
     * 设置 [ZTF]
     */
    public void setZtf(Double  ztf){
        this.ztf = ztf ;
        this.modify("ztf",ztf);
    }

    /**
     * 设置 [BJ]
     */
    public void setBj(Double  bj){
        this.bj = bj ;
        this.modify("bj",bj);
    }

    /**
     * 设置 [CC]
     */
    public void setCc(Double  cc){
        this.cc = cc ;
        this.modify("cc",cc);
    }

    /**
     * 设置 [BEGINDATE]
     */
    public void setBegindate(Timestamp  begindate){
        this.begindate = begindate ;
        this.modify("begindate",begindate);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [NX]
     */
    public void setNx(Double  nx){
        this.nx = nx ;
        this.modify("nx",nx);
    }

    /**
     * 设置 [KG]
     */
    public void setKg(Double  kg){
        this.kg = kg ;
        this.modify("kg",kg);
    }

    /**
     * 设置 [YF]
     */
    public void setYf(String  yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [GZRJB]
     */
    public void setGzrjb(Double  gzrjb){
        this.gzrjb = gzrjb ;
        this.modify("gzrjb",gzrjb);
    }

    /**
     * 设置 [JS]
     */
    public void setJs(Double  js){
        this.js = js ;
        this.modify("js",js);
    }

    /**
     * 设置 [FDJRJB]
     */
    public void setFdjrjb(Double  fdjrjb){
        this.fdjrjb = fdjrjb ;
        this.modify("fdjrjb",fdjrjb);
    }

    /**
     * 设置 [CDF]
     */
    public void setCdf(Double  cdf){
        this.cdf = cdf ;
        this.modify("cdf",cdf);
    }

    /**
     * 设置 [ZTC]
     */
    public void setZtc(Integer  ztc){
        this.ztc = ztc ;
        this.modify("ztc",ztc);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(Double  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [TCXX]
     */
    public void setTcxx(Double  tcxx){
        this.tcxx = tcxx ;
        this.modify("tcxx",tcxx);
    }

    /**
     * 设置 [REMARKREASON]
     */
    public void setRemarkreason(String  remarkreason){
        this.remarkreason = remarkreason ;
        this.modify("remarkreason",remarkreason);
    }

    /**
     * 设置 [ZHTS]
     */
    public void setZhts(Double  zhts){
        this.zhts = zhts ;
        this.modify("zhts",zhts);
    }

    /**
     * 设置 [TX]
     */
    public void setTx(Double  tx){
        this.tx = tx ;
        this.modify("tx",tx);
    }

    /**
     * 设置 [WQDTS]
     */
    public void setWqdts(Double  wqdts){
        this.wqdts = wqdts ;
        this.modify("wqdts",wqdts);
    }

    /**
     * 设置 [BR]
     */
    public void setBr(Double  br){
        this.br = br ;
        this.modify("br",br);
    }

    /**
     * 设置 [TQ]
     */
    public void setTq(Double  tq){
        this.tq = tq ;
        this.modify("tq",tq);
    }

    /**
     * 设置 [SJ]
     */
    public void setSj(Double  sj){
        this.sj = sj ;
        this.modify("sj",sj);
    }

    /**
     * 设置 [QQ]
     */
    public void setQq(Double  qq){
        this.qq = qq ;
        this.modify("qq",qq);
    }

    /**
     * 设置 [PC]
     */
    public void setPc(Double  pc){
        this.pc = pc ;
        this.modify("pc",pc);
    }

    /**
     * 设置 [SZ]
     */
    public void setSz(Double  sz){
        this.sz = sz ;
        this.modify("sz",sz);
    }

    /**
     * 设置 [CD]
     */
    public void setCd(Double  cd){
        this.cd = cd ;
        this.modify("cd",cd);
    }

    /**
     * 设置 [BQ]
     */
    public void setBq(Double  bq){
        this.bq = bq ;
        this.modify("bq",bq);
    }

    /**
     * 设置 [JH]
     */
    public void setJh(Double  jh){
        this.jh = jh ;
        this.modify("jh",jh);
    }

    /**
     * 设置 [XXRJB]
     */
    public void setXxrjb(Double  xxrjb){
        this.xxrjb = xxrjb ;
        this.modify("xxrjb",xxrjb);
    }

    /**
     * 设置 [SJCQTS]
     */
    public void setSjcqts(Double  sjcqts){
        this.sjcqts = sjcqts ;
        this.modify("sjcqts",sjcqts);
    }

    /**
     * 设置 [ATTENSUMMARYNAME]
     */
    public void setAttensummaryname(String  attensummaryname){
        this.attensummaryname = attensummaryname ;
        this.modify("attensummaryname",attensummaryname);
    }

    /**
     * 设置 [DESCRIPTION]
     */
    public void setDescription(String  description){
        this.description = description ;
        this.modify("description",description);
    }

    /**
     * 设置 [CJ]
     */
    public void setCj(Double  cj){
        this.cj = cj ;
        this.modify("cj",cj);
    }

    /**
     * 设置 [QT]
     */
    public void setQt(Double  qt){
        this.qt = qt ;
        this.modify("qt",qt);
    }

    /**
     * 设置 [CDC]
     */
    public void setCdc(Integer  cdc){
        this.cdc = cdc ;
        this.modify("cdc",cdc);
    }

    /**
     * 设置 [ENDDATE]
     */
    public void setEnddate(Timestamp  enddate){
        this.enddate = enddate ;
        this.modify("enddate",enddate);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [YQ]
     */
    public void setYq(Double  yq){
        this.yq = yq ;
        this.modify("yq",yq);
    }

    /**
     * 设置 [QTDXJ]
     */
    public void setQtdxj(Double  qtdxj){
        this.qtdxj = qtdxj ;
        this.modify("qtdxj",qtdxj);
    }

    /**
     * 设置 [SDT]
     */
    public void setSdt(Double  sdt){
        this.sdt = sdt ;
        this.modify("sdt",sdt);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

