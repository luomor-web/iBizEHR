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
 * 服务DTO对象[OrmOrgsectorDTO]
 */
@Data
public class OrmOrgsectorDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [XMJBQK]
     *
     */
    @JSONField(name = "xmjbqk")
    @JsonProperty("xmjbqk")
    private String xmjbqk;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [QY]
     *
     */
    @JSONField(name = "qy")
    @JsonProperty("qy")
    private String qy;

    /**
     * 属性 [EDITION]
     *
     */
    @JSONField(name = "edition")
    @JsonProperty("edition")
    private Double edition;

    /**
     * 属性 [SBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;

    /**
     * 属性 [XBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;

    /**
     * 属性 [STARTSTOPSIGN]
     *
     */
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;

    /**
     * 属性 [BMBZRS]
     *
     */
    @JSONField(name = "bmbzrs")
    @JsonProperty("bmbzrs")
    private Integer bmbzrs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [BMSJBZRS]
     *
     */
    @JSONField(name = "bmsjbzrs")
    @JsonProperty("bmsjbzrs")
    private Integer bmsjbzrs;

    /**
     * 属性 [GCMCJBM]
     *
     */
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;

    /**
     * 属性 [XMBQ]
     *
     */
    @JSONField(name = "xmbq")
    @JsonProperty("xmbq")
    private String xmbq;

    /**
     * 属性 [OLDID]
     *
     */
    @JSONField(name = "oldid")
    @JsonProperty("oldid")
    private String oldid;

    /**
     * 属性 [KQKSSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqkssj" , format="HH:mm")
    @JsonProperty("kqkssj")
    private Timestamp kqkssj;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [GWBZSL]
     *
     */
    @JSONField(name = "gwbzsl")
    @JsonProperty("gwbzsl")
    private String gwbzsl;

    /**
     * 属性 [SJBZRS_COLOR]
     *
     */
    @JSONField(name = "sjbzrs_color")
    @JsonProperty("sjbzrs_color")
    private String sjbzrsColor;

    /**
     * 属性 [JHRY]
     *
     */
    @JSONField(name = "jhry")
    @JsonProperty("jhry")
    private Double jhry;

    /**
     * 属性 [APPROVALSTATUS]
     *
     */
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;

    /**
     * 属性 [XCCB]
     *
     */
    @JSONField(name = "xccb")
    @JsonProperty("xccb")
    private Double xccb;

    /**
     * 属性 [KQJSSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqjssj" , format="HH:mm")
    @JsonProperty("kqjssj")
    private Timestamp kqjssj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [XMLX]
     *
     */
    @JSONField(name = "xmlx")
    @JsonProperty("xmlx")
    private String xmlx;

    /**
     * 属性 [ORGTYPE]
     *
     */
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;

    /**
     * 属性 [ZWBZSL]
     *
     */
    @JSONField(name = "zwbzsl")
    @JsonProperty("zwbzsl")
    private String zwbzsl;

    /**
     * 属性 [ERPORGID]
     *
     */
    @JSONField(name = "erporgid")
    @JsonProperty("erporgid")
    private String erporgid;

    /**
     * 属性 [DKFS]
     *
     */
    @JSONField(name = "dkfs")
    @JsonProperty("dkfs")
    private String dkfs;

    /**
     * 属性 [XMLXQT]
     *
     */
    @JSONField(name = "xmlxqt")
    @JsonProperty("xmlxqt")
    private String xmlxqt;

    /**
     * 属性 [SJRS]
     *
     */
    @JSONField(name = "sjrs")
    @JsonProperty("sjrs")
    private Integer sjrs;

    /**
     * 属性 [ORGSECTORNAME]
     *
     */
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;

    /**
     * 属性 [ZWSL]
     *
     */
    @JSONField(name = "zwsl")
    @JsonProperty("zwsl")
    private Integer zwsl;

    /**
     * 属性 [SHGWSL]
     *
     */
    @JSONField(name = "shgwsl")
    @JsonProperty("shgwsl")
    private Integer shgwsl;

    /**
     * 属性 [XMGM]
     *
     */
    @JSONField(name = "xmgm")
    @JsonProperty("xmgm")
    private String xmgm;

    /**
     * 属性 [XCRY]
     *
     */
    @JSONField(name = "xcry")
    @JsonProperty("xcry")
    private Double xcry;

    /**
     * 属性 [GWSL]
     *
     */
    @JSONField(name = "gwsl")
    @JsonProperty("gwsl")
    private Integer gwsl;

    /**
     * 属性 [DXMJLYQ]
     *
     */
    @JSONField(name = "dxmjlyq")
    @JsonProperty("dxmjlyq")
    private String dxmjlyq;

    /**
     * 属性 [DXMZGYQ]
     *
     */
    @JSONField(name = "dxmzgyq")
    @JsonProperty("dxmzgyq")
    private String dxmzgyq;

    /**
     * 属性 [TITLE]
     *
     */
    @JSONField(name = "title")
    @JsonProperty("title")
    private String title;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

    /**
     * 属性 [SJBZRS]
     *
     */
    @JSONField(name = "sjbzrs")
    @JsonProperty("sjbzrs")
    private String sjbzrs;

    /**
     * 属性 [REFERJOBLEVEL]
     *
     */
    @JSONField(name = "referjoblevel")
    @JsonProperty("referjoblevel")
    private String referjoblevel;

    /**
     * 属性 [BELONGOU]
     *
     */
    @JSONField(name = "belongou")
    @JsonProperty("belongou")
    private String belongou;

    /**
     * 属性 [SHZWSL]
     *
     */
    @JSONField(name = "shzwsl")
    @JsonProperty("shzwsl")
    private Integer shzwsl;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [GQAP]
     *
     */
    @JSONField(name = "gqap")
    @JsonProperty("gqap")
    private String gqap;

    /**
     * 属性 [JHCB]
     *
     */
    @JSONField(name = "jhcb")
    @JsonProperty("jhcb")
    private Double jhcb;

    /**
     * 属性 [BMLX]
     *
     */
    @JSONField(name = "bmlx")
    @JsonProperty("bmlx")
    private String bmlx;

    /**
     * 属性 [XMBLX]
     *
     */
    @JSONField(name = "xmblx")
    @JsonProperty("xmblx")
    private String xmblx;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [GKJZ]
     *
     */
    @JSONField(name = "gkjz")
    @JsonProperty("gkjz")
    private String gkjz;

    /**
     * 属性 [EDITIONSTATE]
     *
     */
    @JSONField(name = "editionstate")
    @JsonProperty("editionstate")
    private String editionstate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SJCB]
     *
     */
    @JSONField(name = "sjcb")
    @JsonProperty("sjcb")
    private Double sjcb;

    /**
     * 属性 [SJRY]
     *
     */
    @JSONField(name = "sjry")
    @JsonProperty("sjry")
    private Double sjry;

    /**
     * 属性 [BELONGREGION]
     *
     */
    @JSONField(name = "belongregion")
    @JsonProperty("belongregion")
    private String belongregion;

    /**
     * 属性 [ENGINEERINGSCALE]
     *
     */
    @JSONField(name = "engineeringscale")
    @JsonProperty("engineeringscale")
    private String engineeringscale;

    /**
     * 属性 [PROLEADERNAME]
     *
     */
    @JSONField(name = "proleadername")
    @JsonProperty("proleadername")
    private String proleadername;

    /**
     * 属性 [PRODEPNAME]
     *
     */
    @JSONField(name = "prodepname")
    @JsonProperty("prodepname")
    private String prodepname;

    /**
     * 属性 [ORMXMGLNAME]
     *
     */
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [XMBH]
     *
     */
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;

    /**
     * 属性 [PORGSECTORNAME]
     *
     */
    @JSONField(name = "porgsectorname")
    @JsonProperty("porgsectorname")
    private String porgsectorname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMXMGLID]
     *
     */
    @JSONField(name = "ormxmglid")
    @JsonProperty("ormxmglid")
    private String ormxmglid;

    /**
     * 属性 [PRODEPID]
     *
     */
    @JSONField(name = "prodepid")
    @JsonProperty("prodepid")
    private String prodepid;

    /**
     * 属性 [PROLEADERID]
     *
     */
    @JSONField(name = "proleaderid")
    @JsonProperty("proleaderid")
    private String proleaderid;

    /**
     * 属性 [PORGSECTORID]
     *
     */
    @JSONField(name = "porgsectorid")
    @JsonProperty("porgsectorid")
    private String porgsectorid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;


    /**
     * 设置 [XMJBQK]
     */
    public void setXmjbqk(String  xmjbqk){
        this.xmjbqk = xmjbqk ;
        this.modify("xmjbqk",xmjbqk);
    }

    /**
     * 设置 [QY]
     */
    public void setQy(String  qy){
        this.qy = qy ;
        this.modify("qy",qy);
    }

    /**
     * 设置 [EDITION]
     */
    public void setEdition(Double  edition){
        this.edition = edition ;
        this.modify("edition",edition);
    }

    /**
     * 设置 [SBSJ]
     */
    public void setSbsj(Timestamp  sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 设置 [XBSJ]
     */
    public void setXbsj(Timestamp  xbsj){
        this.xbsj = xbsj ;
        this.modify("xbsj",xbsj);
    }

    /**
     * 设置 [STARTSTOPSIGN]
     */
    public void setStartstopsign(String  startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [BMBZRS]
     */
    public void setBmbzrs(Integer  bmbzrs){
        this.bmbzrs = bmbzrs ;
        this.modify("bmbzrs",bmbzrs);
    }

    /**
     * 设置 [BMSJBZRS]
     */
    public void setBmsjbzrs(Integer  bmsjbzrs){
        this.bmsjbzrs = bmsjbzrs ;
        this.modify("bmsjbzrs",bmsjbzrs);
    }

    /**
     * 设置 [GCMCJBM]
     */
    public void setGcmcjbm(String  gcmcjbm){
        this.gcmcjbm = gcmcjbm ;
        this.modify("gcmcjbm",gcmcjbm);
    }

    /**
     * 设置 [XMBQ]
     */
    public void setXmbq(String  xmbq){
        this.xmbq = xmbq ;
        this.modify("xmbq",xmbq);
    }

    /**
     * 设置 [OLDID]
     */
    public void setOldid(String  oldid){
        this.oldid = oldid ;
        this.modify("oldid",oldid);
    }

    /**
     * 设置 [KQKSSJ]
     */
    public void setKqkssj(Timestamp  kqkssj){
        this.kqkssj = kqkssj ;
        this.modify("kqkssj",kqkssj);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [JHRY]
     */
    public void setJhry(Double  jhry){
        this.jhry = jhry ;
        this.modify("jhry",jhry);
    }

    /**
     * 设置 [APPROVALSTATUS]
     */
    public void setApprovalstatus(String  approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [KQJSSJ]
     */
    public void setKqjssj(Timestamp  kqjssj){
        this.kqjssj = kqjssj ;
        this.modify("kqjssj",kqjssj);
    }

    /**
     * 设置 [XMLX]
     */
    public void setXmlx(String  xmlx){
        this.xmlx = xmlx ;
        this.modify("xmlx",xmlx);
    }

    /**
     * 设置 [ORGTYPE]
     */
    public void setOrgtype(String  orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [ERPORGID]
     */
    public void setErporgid(String  erporgid){
        this.erporgid = erporgid ;
        this.modify("erporgid",erporgid);
    }

    /**
     * 设置 [DKFS]
     */
    public void setDkfs(String  dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
    }

    /**
     * 设置 [XMLXQT]
     */
    public void setXmlxqt(String  xmlxqt){
        this.xmlxqt = xmlxqt ;
        this.modify("xmlxqt",xmlxqt);
    }

    /**
     * 设置 [SJRS]
     */
    public void setSjrs(Integer  sjrs){
        this.sjrs = sjrs ;
        this.modify("sjrs",sjrs);
    }

    /**
     * 设置 [ZWSL]
     */
    public void setZwsl(Integer  zwsl){
        this.zwsl = zwsl ;
        this.modify("zwsl",zwsl);
    }

    /**
     * 设置 [SHGWSL]
     */
    public void setShgwsl(Integer  shgwsl){
        this.shgwsl = shgwsl ;
        this.modify("shgwsl",shgwsl);
    }

    /**
     * 设置 [XMGM]
     */
    public void setXmgm(String  xmgm){
        this.xmgm = xmgm ;
        this.modify("xmgm",xmgm);
    }

    /**
     * 设置 [GWSL]
     */
    public void setGwsl(Integer  gwsl){
        this.gwsl = gwsl ;
        this.modify("gwsl",gwsl);
    }

    /**
     * 设置 [DXMJLYQ]
     */
    public void setDxmjlyq(String  dxmjlyq){
        this.dxmjlyq = dxmjlyq ;
        this.modify("dxmjlyq",dxmjlyq);
    }

    /**
     * 设置 [DXMZGYQ]
     */
    public void setDxmzgyq(String  dxmzgyq){
        this.dxmzgyq = dxmzgyq ;
        this.modify("dxmzgyq",dxmzgyq);
    }

    /**
     * 设置 [TITLE]
     */
    public void setTitle(String  title){
        this.title = title ;
        this.modify("title",title);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [REFERJOBLEVEL]
     */
    public void setReferjoblevel(String  referjoblevel){
        this.referjoblevel = referjoblevel ;
        this.modify("referjoblevel",referjoblevel);
    }

    /**
     * 设置 [BELONGOU]
     */
    public void setBelongou(String  belongou){
        this.belongou = belongou ;
        this.modify("belongou",belongou);
    }

    /**
     * 设置 [SHZWSL]
     */
    public void setShzwsl(Integer  shzwsl){
        this.shzwsl = shzwsl ;
        this.modify("shzwsl",shzwsl);
    }

    /**
     * 设置 [SHORTNAME]
     */
    public void setShortname(String  shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [GQAP]
     */
    public void setGqap(String  gqap){
        this.gqap = gqap ;
        this.modify("gqap",gqap);
    }

    /**
     * 设置 [JHCB]
     */
    public void setJhcb(Double  jhcb){
        this.jhcb = jhcb ;
        this.modify("jhcb",jhcb);
    }

    /**
     * 设置 [BMLX]
     */
    public void setBmlx(String  bmlx){
        this.bmlx = bmlx ;
        this.modify("bmlx",bmlx);
    }

    /**
     * 设置 [XMBLX]
     */
    public void setXmblx(String  xmblx){
        this.xmblx = xmblx ;
        this.modify("xmblx",xmblx);
    }

    /**
     * 设置 [GKJZ]
     */
    public void setGkjz(String  gkjz){
        this.gkjz = gkjz ;
        this.modify("gkjz",gkjz);
    }

    /**
     * 设置 [EDITIONSTATE]
     */
    public void setEditionstate(String  editionstate){
        this.editionstate = editionstate ;
        this.modify("editionstate",editionstate);
    }

    /**
     * 设置 [SJCB]
     */
    public void setSjcb(Double  sjcb){
        this.sjcb = sjcb ;
        this.modify("sjcb",sjcb);
    }

    /**
     * 设置 [SJRY]
     */
    public void setSjry(Double  sjry){
        this.sjry = sjry ;
        this.modify("sjry",sjry);
    }

    /**
     * 设置 [BELONGREGION]
     */
    public void setBelongregion(String  belongregion){
        this.belongregion = belongregion ;
        this.modify("belongregion",belongregion);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMXMGLID]
     */
    public void setOrmxmglid(String  ormxmglid){
        this.ormxmglid = ormxmglid ;
        this.modify("ormxmglid",ormxmglid);
    }

    /**
     * 设置 [PRODEPID]
     */
    public void setProdepid(String  prodepid){
        this.prodepid = prodepid ;
        this.modify("prodepid",prodepid);
    }

    /**
     * 设置 [PROLEADERID]
     */
    public void setProleaderid(String  proleaderid){
        this.proleaderid = proleaderid ;
        this.modify("proleaderid",proleaderid);
    }

    /**
     * 设置 [PORGSECTORID]
     */
    public void setPorgsectorid(String  porgsectorid){
        this.porgsectorid = porgsectorid ;
        this.modify("porgsectorid",porgsectorid);
    }


}

