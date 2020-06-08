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
 * 服务DTO对象[OrmXmxqjhDTO]
 */
@Data
public class OrmXmxqjhDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [OLDID]
     *
     */
    @JSONField(name = "oldid")
    @JsonProperty("oldid")
    private String oldid;

    /**
     * 属性 [JZMJ]
     *
     */
    @JSONField(name = "jzmj")
    @JsonProperty("jzmj")
    private Double jzmj;

    /**
     * 属性 [ORGSHORTNAME]
     *
     */
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;

    /**
     * 属性 [GQAP]
     *
     */
    @JSONField(name = "gqap")
    @JsonProperty("gqap")
    private String gqap;

    /**
     * 属性 [XMGMMS]
     *
     */
    @JSONField(name = "xmgmms")
    @JsonProperty("xmgmms")
    private String xmgmms;

    /**
     * 属性 [APPROVALSTATUS]
     *
     */
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;

    /**
     * 属性 [ORGSECINFOID]
     *
     */
    @JSONField(name = "orgsecinfoid")
    @JsonProperty("orgsecinfoid")
    private String orgsecinfoid;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [ORGINFOID]
     *
     */
    @JSONField(name = "orginfoid")
    @JsonProperty("orginfoid")
    private String orginfoid;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [GCMCJBM]
     *
     */
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;

    /**
     * 属性 [ZTSG]
     *
     */
    @JSONField(name = "ztsg")
    @JsonProperty("ztsg")
    private String ztsg;

    /**
     * 属性 [BBH]
     *
     */
    @JSONField(name = "bbh")
    @JsonProperty("bbh")
    private String bbh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DXMZGYQ]
     *
     */
    @JSONField(name = "dxmzgyq")
    @JsonProperty("dxmzgyq")
    private String dxmzgyq;

    /**
     * 属性 [EDITION]
     *
     */
    @JSONField(name = "edition")
    @JsonProperty("edition")
    private Double edition;

    /**
     * 属性 [JHCB]
     *
     */
    @JSONField(name = "jhcb")
    @JsonProperty("jhcb")
    private Double jhcb;

    /**
     * 属性 [ORGINFONAME]
     *
     */
    @JSONField(name = "orginfoname")
    @JsonProperty("orginfoname")
    private String orginfoname;

    /**
     * 属性 [GCZJ]
     *
     */
    @JSONField(name = "gczj")
    @JsonProperty("gczj")
    private Double gczj;

    /**
     * 属性 [XMLX]
     *
     */
    @JSONField(name = "xmlx")
    @JsonProperty("xmlx")
    private String xmlx;

    /**
     * 属性 [ZSZX]
     *
     */
    @JSONField(name = "zszx")
    @JsonProperty("zszx")
    private String zszx;

    /**
     * 属性 [ORMXMXQJHNAME]
     *
     */
    @JSONField(name = "ormxmxqjhname")
    @JsonProperty("ormxmxqjhname")
    private String ormxmxqjhname;

    /**
     * 属性 [EDITIONSTATE]
     *
     */
    @JSONField(name = "editionstate")
    @JsonProperty("editionstate")
    private String editionstate;

    /**
     * 属性 [GCJS]
     *
     */
    @JSONField(name = "gcjs")
    @JsonProperty("gcjs")
    private String gcjs;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [GCSW]
     *
     */
    @JSONField(name = "gcsw")
    @JsonProperty("gcsw")
    private String gcsw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [QTJD]
     *
     */
    @JSONField(name = "qtjd")
    @JsonProperty("qtjd")
    private String qtjd;

    /**
     * 属性 [XMBLX]
     *
     */
    @JSONField(name = "xmblx")
    @JsonProperty("xmblx")
    private String xmblx;

    /**
     * 属性 [DXMJLYQ]
     *
     */
    @JSONField(name = "dxmjlyq")
    @JsonProperty("dxmjlyq")
    private String dxmjlyq;

    /**
     * 属性 [XMLXQT]
     *
     */
    @JSONField(name = "xmlxqt")
    @JsonProperty("xmlxqt")
    private String xmlxqt;

    /**
     * 属性 [XMBMC]
     *
     */
    @JSONField(name = "xmbmc")
    @JsonProperty("xmbmc")
    private String xmbmc;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SGJD]
     *
     */
    @JSONField(name = "sgjd")
    @JsonProperty("sgjd")
    private String sgjd;

    /**
     * 属性 [XMJBQK]
     *
     */
    @JSONField(name = "xmjbqk")
    @JsonProperty("xmjbqk")
    private String xmjbqk;

    /**
     * 属性 [ORMXMXQJHID]
     *
     */
    @JSONField(name = "ormxmxqjhid")
    @JsonProperty("ormxmxqjhid")
    private String ormxmxqjhid;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [XMBJC]
     *
     */
    @JSONField(name = "xmbjc")
    @JsonProperty("xmbjc")
    private String xmbjc;

    /**
     * 属性 [ORMXMGLNAME]
     *
     */
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;

    /**
     * 属性 [XMBH]
     *
     */
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

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
     * 设置 [OLDID]
     */
    public void setOldid(String  oldid){
        this.oldid = oldid ;
        this.modify("oldid",oldid);
    }

    /**
     * 设置 [JZMJ]
     */
    public void setJzmj(Double  jzmj){
        this.jzmj = jzmj ;
        this.modify("jzmj",jzmj);
    }

    /**
     * 设置 [ORGSHORTNAME]
     */
    public void setOrgshortname(String  orgshortname){
        this.orgshortname = orgshortname ;
        this.modify("orgshortname",orgshortname);
    }

    /**
     * 设置 [GQAP]
     */
    public void setGqap(String  gqap){
        this.gqap = gqap ;
        this.modify("gqap",gqap);
    }

    /**
     * 设置 [XMGMMS]
     */
    public void setXmgmms(String  xmgmms){
        this.xmgmms = xmgmms ;
        this.modify("xmgmms",xmgmms);
    }

    /**
     * 设置 [APPROVALSTATUS]
     */
    public void setApprovalstatus(String  approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [ORGSECINFOID]
     */
    public void setOrgsecinfoid(String  orgsecinfoid){
        this.orgsecinfoid = orgsecinfoid ;
        this.modify("orgsecinfoid",orgsecinfoid);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [ORGINFOID]
     */
    public void setOrginfoid(String  orginfoid){
        this.orginfoid = orginfoid ;
        this.modify("orginfoid",orginfoid);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [GCMCJBM]
     */
    public void setGcmcjbm(String  gcmcjbm){
        this.gcmcjbm = gcmcjbm ;
        this.modify("gcmcjbm",gcmcjbm);
    }

    /**
     * 设置 [ZTSG]
     */
    public void setZtsg(String  ztsg){
        this.ztsg = ztsg ;
        this.modify("ztsg",ztsg);
    }

    /**
     * 设置 [BBH]
     */
    public void setBbh(String  bbh){
        this.bbh = bbh ;
        this.modify("bbh",bbh);
    }

    /**
     * 设置 [DXMZGYQ]
     */
    public void setDxmzgyq(String  dxmzgyq){
        this.dxmzgyq = dxmzgyq ;
        this.modify("dxmzgyq",dxmzgyq);
    }

    /**
     * 设置 [EDITION]
     */
    public void setEdition(Double  edition){
        this.edition = edition ;
        this.modify("edition",edition);
    }

    /**
     * 设置 [JHCB]
     */
    public void setJhcb(Double  jhcb){
        this.jhcb = jhcb ;
        this.modify("jhcb",jhcb);
    }

    /**
     * 设置 [ORGINFONAME]
     */
    public void setOrginfoname(String  orginfoname){
        this.orginfoname = orginfoname ;
        this.modify("orginfoname",orginfoname);
    }

    /**
     * 设置 [GCZJ]
     */
    public void setGczj(Double  gczj){
        this.gczj = gczj ;
        this.modify("gczj",gczj);
    }

    /**
     * 设置 [XMLX]
     */
    public void setXmlx(String  xmlx){
        this.xmlx = xmlx ;
        this.modify("xmlx",xmlx);
    }

    /**
     * 设置 [ZSZX]
     */
    public void setZszx(String  zszx){
        this.zszx = zszx ;
        this.modify("zszx",zszx);
    }

    /**
     * 设置 [ORMXMXQJHNAME]
     */
    public void setOrmxmxqjhname(String  ormxmxqjhname){
        this.ormxmxqjhname = ormxmxqjhname ;
        this.modify("ormxmxqjhname",ormxmxqjhname);
    }

    /**
     * 设置 [EDITIONSTATE]
     */
    public void setEditionstate(String  editionstate){
        this.editionstate = editionstate ;
        this.modify("editionstate",editionstate);
    }

    /**
     * 设置 [GCJS]
     */
    public void setGcjs(String  gcjs){
        this.gcjs = gcjs ;
        this.modify("gcjs",gcjs);
    }

    /**
     * 设置 [GCSW]
     */
    public void setGcsw(String  gcsw){
        this.gcsw = gcsw ;
        this.modify("gcsw",gcsw);
    }

    /**
     * 设置 [QTJD]
     */
    public void setQtjd(String  qtjd){
        this.qtjd = qtjd ;
        this.modify("qtjd",qtjd);
    }

    /**
     * 设置 [XMBLX]
     */
    public void setXmblx(String  xmblx){
        this.xmblx = xmblx ;
        this.modify("xmblx",xmblx);
    }

    /**
     * 设置 [DXMJLYQ]
     */
    public void setDxmjlyq(String  dxmjlyq){
        this.dxmjlyq = dxmjlyq ;
        this.modify("dxmjlyq",dxmjlyq);
    }

    /**
     * 设置 [XMLXQT]
     */
    public void setXmlxqt(String  xmlxqt){
        this.xmlxqt = xmlxqt ;
        this.modify("xmlxqt",xmlxqt);
    }

    /**
     * 设置 [XMBMC]
     */
    public void setXmbmc(String  xmbmc){
        this.xmbmc = xmbmc ;
        this.modify("xmbmc",xmbmc);
    }

    /**
     * 设置 [SGJD]
     */
    public void setSgjd(String  sgjd){
        this.sgjd = sgjd ;
        this.modify("sgjd",sgjd);
    }

    /**
     * 设置 [XMJBQK]
     */
    public void setXmjbqk(String  xmjbqk){
        this.xmjbqk = xmjbqk ;
        this.modify("xmjbqk",xmjbqk);
    }

    /**
     * 设置 [XMBJC]
     */
    public void setXmbjc(String  xmbjc){
        this.xmbjc = xmbjc ;
        this.modify("xmbjc",xmbjc);
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


}

