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
 * 服务DTO对象[PimByzzjlmxDTO]
 */
@Data
public class PimByzzjlmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [NZZYGLX]
     *
     */
    @JSONField(name = "nzzyglx")
    @JsonProperty("nzzyglx")
    private String nzzyglx;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [SSLWGS]
     *
     */
    @JSONField(name = "sslwgs")
    @JsonProperty("sslwgs")
    private String sslwgs;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [ISTEMP]
     *
     */
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [FINISHED]
     *
     */
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;

    /**
     * 属性 [YZBM]
     *
     */
    @JSONField(name = "yzbm")
    @JsonProperty("yzbm")
    private String yzbm;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DQZT]
     *
     */
    @JSONField(name = "dqzt")
    @JsonProperty("dqzt")
    private String dqzt;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [XYGBH]
     *
     */
    @JSONField(name = "xygbh")
    @JsonProperty("xygbh")
    private String xygbh;

    /**
     * 属性 [OLDYGLX]
     *
     */
    @JSONField(name = "oldyglx")
    @JsonProperty("oldyglx")
    private String oldyglx;

    /**
     * 属性 [JZBSHYJ]
     *
     */
    @JSONField(name = "jzbshyj")
    @JsonProperty("jzbshyj")
    private String jzbshyj;

    /**
     * 属性 [SSLWGSDZ]
     *
     */
    @JSONField(name = "sslwgsdz")
    @JsonProperty("sslwgsdz")
    private String sslwgsdz;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [YJ]
     *
     */
    @JSONField(name = "yj")
    @JsonProperty("yj")
    private String yj;

    /**
     * 属性 [JZPSPYJ]
     *
     */
    @JSONField(name = "jzpspyj")
    @JsonProperty("jzpspyj")
    private String jzpspyj;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [PROFILELIST]
     *
     */
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TJQK]
     *
     */
    @JSONField(name = "tjqk")
    @JsonProperty("tjqk")
    private String tjqk;

    /**
     * 属性 [YWZDJBS]
     *
     */
    @JSONField(name = "ywzdjbs")
    @JsonProperty("ywzdjbs")
    private String ywzdjbs;

    /**
     * 属性 [SBCL]
     *
     */
    @JSONField(name = "sbcl")
    @JsonProperty("sbcl")
    private String sbcl;

    /**
     * 属性 [JZBSPYJ]
     *
     */
    @JSONField(name = "jzbspyj")
    @JsonProperty("jzbspyj")
    private String jzbspyj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [QSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [OLDYGBH]
     *
     */
    @JSONField(name = "oldygbh")
    @JsonProperty("oldygbh")
    private String oldygbh;

    /**
     * 属性 [DATZQK]
     *
     */
    @JSONField(name = "datzqk")
    @JsonProperty("datzqk")
    private String datzqk;

    /**
     * 属性 [ZTYY]
     *
     */
    @JSONField(name = "ztyy")
    @JsonProperty("ztyy")
    private String ztyy;

    /**
     * 属性 [STANDARDCAUSE]
     *
     */
    @JSONField(name = "standardcause")
    @JsonProperty("standardcause")
    private String standardcause;

    /**
     * 属性 [PIMBYZZJLMXNAME]
     *
     */
    @JSONField(name = "pimbyzzjlmxname")
    @JsonProperty("pimbyzzjlmxname")
    private String pimbyzzjlmxname;

    /**
     * 属性 [PIMBYZZJLMXID]
     *
     */
    @JSONField(name = "pimbyzzjlmxid")
    @JsonProperty("pimbyzzjlmxid")
    private String pimbyzzjlmxid;

    /**
     * 属性 [PEOPLENUM]
     *
     */
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;

    /**
     * 属性 [CJGZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [HKLX]
     *
     */
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [FS]
     *
     */
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;

    /**
     * 属性 [YYGLX]
     *
     */
    @JSONField(name = "yyglx")
    @JsonProperty("yyglx")
    private String yyglx;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [PIMEXAMINATIONRESULTSNAME]
     *
     */
    @JSONField(name = "pimexaminationresultsname")
    @JsonProperty("pimexaminationresultsname")
    private String pimexaminationresultsname;

    /**
     * 属性 [YBHQYSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ybhqysj" , format="yyyy-MM-dd")
    @JsonProperty("ybhqysj")
    private Timestamp ybhqysj;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [HIGHTITLE]
     *
     */
    @JSONField(name = "hightitle")
    @JsonProperty("hightitle")
    private String hightitle;

    /**
     * 属性 [POSTALADDRESS]
     *
     */
    @JSONField(name = "postaladdress")
    @JsonProperty("postaladdress")
    private String postaladdress;

    /**
     * 属性 [HJDZ]
     *
     */
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [DZJBJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [JG]
     *
     */
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [QSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;

    /**
     * 属性 [PIMBYYGZZSQNAME]
     *
     */
    @JSONField(name = "pimbyygzzsqname")
    @JsonProperty("pimbyygzzsqname")
    private String pimbyygzzsqname;

    /**
     * 属性 [CSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [JKZK]
     *
     */
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;

    /**
     * 属性 [MZ]
     *
     */
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMEXAMINATIONRESULTSID]
     *
     */
    @JSONField(name = "pimexaminationresultsid")
    @JsonProperty("pimexaminationresultsid")
    private String pimexaminationresultsid;

    /**
     * 属性 [PIMBYYGZZSQID]
     *
     */
    @JSONField(name = "pimbyygzzsqid")
    @JsonProperty("pimbyygzzsqid")
    private String pimbyygzzsqid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;


    /**
     * 设置 [NZZYGLX]
     */
    public void setNzzyglx(String  nzzyglx){
        this.nzzyglx = nzzyglx ;
        this.modify("nzzyglx",nzzyglx);
    }

    /**
     * 设置 [SSLWGS]
     */
    public void setSslwgs(String  sslwgs){
        this.sslwgs = sslwgs ;
        this.modify("sslwgs",sslwgs);
    }

    /**
     * 设置 [ISTEMP]
     */
    public void setIstemp(Integer  istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [FINISHED]
     */
    public void setFinished(Integer  finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [YZBM]
     */
    public void setYzbm(String  yzbm){
        this.yzbm = yzbm ;
        this.modify("yzbm",yzbm);
    }

    /**
     * 设置 [CHECKSTATUS]
     */
    public void setCheckstatus(String  checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [XYGBH]
     */
    public void setXygbh(String  xygbh){
        this.xygbh = xygbh ;
        this.modify("xygbh",xygbh);
    }

    /**
     * 设置 [OLDYGLX]
     */
    public void setOldyglx(String  oldyglx){
        this.oldyglx = oldyglx ;
        this.modify("oldyglx",oldyglx);
    }

    /**
     * 设置 [JZBSHYJ]
     */
    public void setJzbshyj(String  jzbshyj){
        this.jzbshyj = jzbshyj ;
        this.modify("jzbshyj",jzbshyj);
    }

    /**
     * 设置 [SSLWGSDZ]
     */
    public void setSslwgsdz(String  sslwgsdz){
        this.sslwgsdz = sslwgsdz ;
        this.modify("sslwgsdz",sslwgsdz);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [JZPSPYJ]
     */
    public void setJzpspyj(String  jzpspyj){
        this.jzpspyj = jzpspyj ;
        this.modify("jzpspyj",jzpspyj);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [PROFILELIST]
     */
    public void setProfilelist(String  profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [TJQK]
     */
    public void setTjqk(String  tjqk){
        this.tjqk = tjqk ;
        this.modify("tjqk",tjqk);
    }

    /**
     * 设置 [YWZDJBS]
     */
    public void setYwzdjbs(String  ywzdjbs){
        this.ywzdjbs = ywzdjbs ;
        this.modify("ywzdjbs",ywzdjbs);
    }

    /**
     * 设置 [SBCL]
     */
    public void setSbcl(String  sbcl){
        this.sbcl = sbcl ;
        this.modify("sbcl",sbcl);
    }

    /**
     * 设置 [JZBSPYJ]
     */
    public void setJzbspyj(String  jzbspyj){
        this.jzbspyj = jzbspyj ;
        this.modify("jzbspyj",jzbspyj);
    }

    /**
     * 设置 [QSRQ]
     */
    public void setQsrq(Timestamp  qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 设置 [OLDYGBH]
     */
    public void setOldygbh(String  oldygbh){
        this.oldygbh = oldygbh ;
        this.modify("oldygbh",oldygbh);
    }

    /**
     * 设置 [DATZQK]
     */
    public void setDatzqk(String  datzqk){
        this.datzqk = datzqk ;
        this.modify("datzqk",datzqk);
    }

    /**
     * 设置 [ZTYY]
     */
    public void setZtyy(String  ztyy){
        this.ztyy = ztyy ;
        this.modify("ztyy",ztyy);
    }

    /**
     * 设置 [STANDARDCAUSE]
     */
    public void setStandardcause(String  standardcause){
        this.standardcause = standardcause ;
        this.modify("standardcause",standardcause);
    }

    /**
     * 设置 [PIMBYZZJLMXNAME]
     */
    public void setPimbyzzjlmxname(String  pimbyzzjlmxname){
        this.pimbyzzjlmxname = pimbyzzjlmxname ;
        this.modify("pimbyzzjlmxname",pimbyzzjlmxname);
    }

    /**
     * 设置 [PEOPLENUM]
     */
    public void setPeoplenum(Integer  peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [BMID]
     */
    public void setBmid(String  bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [FS]
     */
    public void setFs(Double  fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [YYGLX]
     */
    public void setYyglx(String  yyglx){
        this.yyglx = yyglx ;
        this.modify("yyglx",yyglx);
    }

    /**
     * 设置 [YBHQYSJ]
     */
    public void setYbhqysj(Timestamp  ybhqysj){
        this.ybhqysj = ybhqysj ;
        this.modify("ybhqysj",ybhqysj);
    }

    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [ZZID]
     */
    public void setZzid(String  zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PIMEXAMINATIONRESULTSID]
     */
    public void setPimexaminationresultsid(String  pimexaminationresultsid){
        this.pimexaminationresultsid = pimexaminationresultsid ;
        this.modify("pimexaminationresultsid",pimexaminationresultsid);
    }

    /**
     * 设置 [PIMBYYGZZSQID]
     */
    public void setPimbyygzzsqid(String  pimbyygzzsqid){
        this.pimbyygzzsqid = pimbyygzzsqid ;
        this.modify("pimbyygzzsqid",pimbyygzzsqid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }


}

