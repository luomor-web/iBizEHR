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
 * 服务DTO对象[PimRewardPunishmentDTO]
 */
@Data
public class PimRewardPunishmentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

    /**
     * 属性 [JLSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jlsj" , format="yyyy-MM-dd")
    @JsonProperty("jlsj")
    private Timestamp jlsj;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMREWARDPUNISHMENTNAME]
     *
     */
    @JSONField(name = "pimrewardpunishmentname")
    @JsonProperty("pimrewardpunishmentname")
    private String pimrewardpunishmentname;

    /**
     * 属性 [DEPARTMENT]
     *
     */
    @JSONField(name = "department")
    @JsonProperty("department")
    private String department;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [YXQJSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yxqjsrq" , format="yyyy-MM-dd")
    @JsonProperty("yxqjsrq")
    private Timestamp yxqjsrq;

    /**
     * 属性 [JCJB]
     *
     */
    @JSONField(name = "jcjb")
    @JsonProperty("jcjb")
    private String jcjb;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CFSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cfsj" , format="yyyy-MM-dd")
    @JsonProperty("cfsj")
    private Timestamp cfsj;

    /**
     * 属性 [JCJE]
     *
     */
    @JSONField(name = "jcje")
    @JsonProperty("jcje")
    private Double jcje;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [JCSJ]
     *
     */
    @JSONField(name = "jcsj")
    @JsonProperty("jcsj")
    private String jcsj;

    /**
     * 属性 [CSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [PIMREWARDPUNISHMENTID]
     *
     */
    @JSONField(name = "pimrewardpunishmentid")
    @JsonProperty("pimrewardpunishmentid")
    private String pimrewardpunishmentid;

    /**
     * 属性 [CFLX]
     *
     */
    @JSONField(name = "cflx")
    @JsonProperty("cflx")
    private String cflx;

    /**
     * 属性 [JCLX]
     *
     */
    @JSONField(name = "jclx")
    @JsonProperty("jclx")
    private String jclx;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

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
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [JLSJ]
     */
    public void setJlsj(Timestamp  jlsj){
        this.jlsj = jlsj ;
        this.modify("jlsj",jlsj);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [PIMREWARDPUNISHMENTNAME]
     */
    public void setPimrewardpunishmentname(String  pimrewardpunishmentname){
        this.pimrewardpunishmentname = pimrewardpunishmentname ;
        this.modify("pimrewardpunishmentname",pimrewardpunishmentname);
    }

    /**
     * 设置 [DEPARTMENT]
     */
    public void setDepartment(String  department){
        this.department = department ;
        this.modify("department",department);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [YXQJSRQ]
     */
    public void setYxqjsrq(Timestamp  yxqjsrq){
        this.yxqjsrq = yxqjsrq ;
        this.modify("yxqjsrq",yxqjsrq);
    }

    /**
     * 设置 [JCJB]
     */
    public void setJcjb(String  jcjb){
        this.jcjb = jcjb ;
        this.modify("jcjb",jcjb);
    }

    /**
     * 设置 [CFSJ]
     */
    public void setCfsj(Timestamp  cfsj){
        this.cfsj = cfsj ;
        this.modify("cfsj",cfsj);
    }

    /**
     * 设置 [JCJE]
     */
    public void setJcje(Double  jcje){
        this.jcje = jcje ;
        this.modify("jcje",jcje);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [JCSJ]
     */
    public void setJcsj(String  jcsj){
        this.jcsj = jcsj ;
        this.modify("jcsj",jcsj);
    }

    /**
     * 设置 [CSRQ]
     */
    public void setCsrq(Timestamp  csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 设置 [CFLX]
     */
    public void setCflx(String  cflx){
        this.cflx = cflx ;
        this.modify("cflx",cflx);
    }

    /**
     * 设置 [JCLX]
     */
    public void setJclx(String  jclx){
        this.jclx = jclx ;
        this.modify("jclx",jclx);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

