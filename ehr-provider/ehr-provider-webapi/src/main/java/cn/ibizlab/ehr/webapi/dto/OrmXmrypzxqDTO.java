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
 * 服务DTO对象[OrmXmrypzxqDTO]
 */
@Data
public class OrmXmrypzxqDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORMXMRYPZXQID]
     *
     */
    @JSONField(name = "ormxmrypzxqid")
    @JsonProperty("ormxmrypzxqid")
    private String ormxmrypzxqid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [APPROVALSTATUS]
     *
     */
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [PLANSTATE]
     *
     */
    @JSONField(name = "planstate")
    @JsonProperty("planstate")
    private String planstate;

    /**
     * 属性 [MODSPZT]
     *
     */
    @JSONField(name = "modspzt")
    @JsonProperty("modspzt")
    private String modspzt;

    /**
     * 属性 [MAJORRESP]
     *
     */
    @JSONField(name = "majorresp")
    @JsonProperty("majorresp")
    private String majorresp;

    /**
     * 属性 [TPJJYY]
     *
     */
    @JSONField(name = "tpjjyy")
    @JsonProperty("tpjjyy")
    private String tpjjyy;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CONTRESULTONE]
     *
     */
    @JSONField(name = "contresultone")
    @JsonProperty("contresultone")
    private String contresultone;

    /**
     * 属性 [SPZT]
     *
     */
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;

    /**
     * 属性 [SFJJYY]
     *
     */
    @JSONField(name = "sfjjyy")
    @JsonProperty("sfjjyy")
    private String sfjjyy;

    /**
     * 属性 [ORMXMRYPZXQNAME]
     *
     */
    @JSONField(name = "ormxmrypzxqname")
    @JsonProperty("ormxmrypzxqname")
    private String ormxmrypzxqname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KQJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqjssj" , format="yyyy-MM-dd")
    @JsonProperty("kqjssj")
    private Timestamp kqjssj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [KQKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqkssj" , format="yyyy-MM-dd")
    @JsonProperty("kqkssj")
    private Timestamp kqkssj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [REALARRIVALTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "realarrivaltime" , format="yyyy-MM-dd")
    @JsonProperty("realarrivaltime")
    private Timestamp realarrivaltime;

    /**
     * 属性 [ISTEMP]
     *
     */
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private String istemp;

    /**
     * 属性 [REALLEAVETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "realleavetime" , format="yyyy-MM-dd")
    @JsonProperty("realleavetime")
    private Timestamp realleavetime;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [TPSPZT]
     *
     */
    @JSONField(name = "tpspzt")
    @JsonProperty("tpspzt")
    private String tpspzt;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [CONTRESULTTWO]
     *
     */
    @JSONField(name = "contresulttwo")
    @JsonProperty("contresulttwo")
    private String contresulttwo;

    /**
     * 属性 [MODPERSONNAME]
     *
     */
    @JSONField(name = "modpersonname")
    @JsonProperty("modpersonname")
    private String modpersonname;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ISKEYPOSTION]
     *
     */
    @JSONField(name = "iskeypostion")
    @JsonProperty("iskeypostion")
    private String iskeypostion;

    /**
     * 属性 [ORGSHORTNAME]
     *
     */
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;

    /**
     * 属性 [CERTIFICATEABILITY]
     *
     */
    @JSONField(name = "certificateability")
    @JsonProperty("certificateability")
    private String certificateability;

    /**
     * 属性 [AGE]
     *
     */
    @JSONField(name = "age")
    @JsonProperty("age")
    private Integer age;

    /**
     * 属性 [SEX]
     *
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 属性 [CURPOST]
     *
     */
    @JSONField(name = "curpost")
    @JsonProperty("curpost")
    private String curpost;

    /**
     * 属性 [REALPERSONNAME]
     *
     */
    @JSONField(name = "realpersonname")
    @JsonProperty("realpersonname")
    private String realpersonname;

    /**
     * 属性 [GCMCJBM]
     *
     */
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;

    /**
     * 属性 [ORGINFOID]
     *
     */
    @JSONField(name = "orginfoid")
    @JsonProperty("orginfoid")
    private String orginfoid;

    /**
     * 属性 [PERSONNUM]
     *
     */
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private String personnum;

    /**
     * 属性 [XMMC]
     *
     */
    @JSONField(name = "xmmc")
    @JsonProperty("xmmc")
    private String xmmc;

    /**
     * 属性 [XMBMC]
     *
     */
    @JSONField(name = "xmbmc")
    @JsonProperty("xmbmc")
    private String xmbmc;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORGSECINFOID]
     *
     */
    @JSONField(name = "orgsecinfoid")
    @JsonProperty("orgsecinfoid")
    private String orgsecinfoid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMXMXQJHID]
     *
     */
    @JSONField(name = "ormxmxqjhid")
    @JsonProperty("ormxmxqjhid")
    private String ormxmxqjhid;

    /**
     * 属性 [REALPEROSNID]
     *
     */
    @JSONField(name = "realpersonid")
    @JsonProperty("realpersonid")
    private String realpersonid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [MODPIMPERSONID]
     *
     */
    @JSONField(name = "modpimpersonid")
    @JsonProperty("modpimpersonid")
    private String modpimpersonid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;


    /**
     * 设置 [APPROVALSTATUS]
     */
    public void setApprovalstatus(String  approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [PLANSTATE]
     */
    public void setPlanstate(String  planstate){
        this.planstate = planstate ;
        this.modify("planstate",planstate);
    }

    /**
     * 设置 [MODSPZT]
     */
    public void setModspzt(String  modspzt){
        this.modspzt = modspzt ;
        this.modify("modspzt",modspzt);
    }

    /**
     * 设置 [MAJORRESP]
     */
    public void setMajorresp(String  majorresp){
        this.majorresp = majorresp ;
        this.modify("majorresp",majorresp);
    }

    /**
     * 设置 [TPJJYY]
     */
    public void setTpjjyy(String  tpjjyy){
        this.tpjjyy = tpjjyy ;
        this.modify("tpjjyy",tpjjyy);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [CONTRESULTONE]
     */
    public void setContresultone(String  contresultone){
        this.contresultone = contresultone ;
        this.modify("contresultone",contresultone);
    }

    /**
     * 设置 [SPZT]
     */
    public void setSpzt(String  spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [SFJJYY]
     */
    public void setSfjjyy(String  sfjjyy){
        this.sfjjyy = sfjjyy ;
        this.modify("sfjjyy",sfjjyy);
    }

    /**
     * 设置 [ORMXMRYPZXQNAME]
     */
    public void setOrmxmrypzxqname(String  ormxmrypzxqname){
        this.ormxmrypzxqname = ormxmrypzxqname ;
        this.modify("ormxmrypzxqname",ormxmrypzxqname);
    }

    /**
     * 设置 [KQJSSJ]
     */
    public void setKqjssj(Timestamp  kqjssj){
        this.kqjssj = kqjssj ;
        this.modify("kqjssj",kqjssj);
    }

    /**
     * 设置 [KQKSSJ]
     */
    public void setKqkssj(Timestamp  kqkssj){
        this.kqkssj = kqkssj ;
        this.modify("kqkssj",kqkssj);
    }

    /**
     * 设置 [REALARRIVALTIME]
     */
    public void setRealarrivaltime(Timestamp  realarrivaltime){
        this.realarrivaltime = realarrivaltime ;
        this.modify("realarrivaltime",realarrivaltime);
    }

    /**
     * 设置 [ISTEMP]
     */
    public void setIstemp(String  istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [REALLEAVETIME]
     */
    public void setRealleavetime(Timestamp  realleavetime){
        this.realleavetime = realleavetime ;
        this.modify("realleavetime",realleavetime);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [TPSPZT]
     */
    public void setTpspzt(String  tpspzt){
        this.tpspzt = tpspzt ;
        this.modify("tpspzt",tpspzt);
    }

    /**
     * 设置 [CONTRESULTTWO]
     */
    public void setContresulttwo(String  contresulttwo){
        this.contresulttwo = contresulttwo ;
        this.modify("contresulttwo",contresulttwo);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMXMXQJHID]
     */
    public void setOrmxmxqjhid(String  ormxmxqjhid){
        this.ormxmxqjhid = ormxmxqjhid ;
        this.modify("ormxmxqjhid",ormxmxqjhid);
    }

    /**
     * 设置 [REALPEROSNID]
     */
    public void setRealpersonid(String  realpersonid){
        this.realpersonid = realpersonid ;
        this.modify("realperosnid",realpersonid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [MODPIMPERSONID]
     */
    public void setModpimpersonid(String  modpimpersonid){
        this.modpimpersonid = modpimpersonid ;
        this.modify("modpimpersonid",modpimpersonid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }


}

