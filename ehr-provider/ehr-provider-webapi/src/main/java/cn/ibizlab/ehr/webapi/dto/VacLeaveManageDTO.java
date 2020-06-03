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
 * 服务DTO对象[VacLeaveManageDTO]
 */
@Data
public class VacLeaveManageDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [VACLEAVEMANAGENAME]
     *
     */
    @JSONField(name = "vacleavemanagename")
    @JsonProperty("vacleavemanagename")
    private String vacleavemanagename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [QJMX]
     *
     */
    @JSONField(name = "qjmx")
    @JsonProperty("qjmx")
    private String qjmx;

    /**
     * 属性 [JHKSSXW]
     *
     */
    @JSONField(name = "jhkssxw")
    @JsonProperty("jhkssxw")
    private String jhkssxw;

    /**
     * 属性 [QJZL]
     *
     */
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;

    /**
     * 属性 [WFQQJSTATE]
     *
     */
    @JSONField(name = "wfqqjstate")
    @JsonProperty("wfqqjstate")
    private String wfqqjstate;

    /**
     * 属性 [QJSY]
     *
     */
    @JSONField(name = "qjsy")
    @JsonProperty("qjsy")
    private String qjsy;

    /**
     * 属性 [SJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjkssj" , format="yyyy-MM-dd")
    @JsonProperty("sjkssj")
    private Timestamp sjkssj;

    /**
     * 属性 [VACLEAVEMANAGEID]
     *
     */
    @JSONField(name = "vacleavemanageid")
    @JsonProperty("vacleavemanageid")
    private String vacleavemanageid;

    /**
     * 属性 [WFRESULT]
     *
     */
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SJJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjjssj" , format="yyyy-MM-dd")
    @JsonProperty("sjjssj")
    private Timestamp sjjssj;

    /**
     * 属性 [TEMPID]
     *
     */
    @JSONField(name = "tempid")
    @JsonProperty("tempid")
    private String tempid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [NJSY]
     *
     */
    @JSONField(name = "njsy")
    @JsonProperty("njsy")
    private String njsy;

    /**
     * 属性 [SJKSSXW]
     *
     */
    @JSONField(name = "sjkssxw")
    @JsonProperty("sjkssxw")
    private String sjkssxw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [QJTS]
     *
     */
    @JSONField(name = "qjts")
    @JsonProperty("qjts")
    private Double qjts;

    /**
     * 属性 [QJJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qjjssj" , format="yyyy-MM-dd")
    @JsonProperty("qjjssj")
    private Timestamp qjjssj;

    /**
     * 属性 [QJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qjkssj" , format="yyyy-MM-dd")
    @JsonProperty("qjkssj")
    private Timestamp qjkssj;

    /**
     * 属性 [SJQJTS]
     *
     */
    @JSONField(name = "sjqjts")
    @JsonProperty("sjqjts")
    private Double sjqjts;

    /**
     * 属性 [BGSY]
     *
     */
    @JSONField(name = "bgsy")
    @JsonProperty("bgsy")
    private String bgsy;

    /**
     * 属性 [JHJSSXW]
     *
     */
    @JSONField(name = "jhjssxw")
    @JsonProperty("jhjssxw")
    private String jhjssxw;

    /**
     * 属性 [SJJSSXW]
     *
     */
    @JSONField(name = "sjjssxw")
    @JsonProperty("sjjssxw")
    private String sjjssxw;

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
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

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
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [VACLEAVEMANAGENAME]
     */
    public void setVacleavemanagename(String  vacleavemanagename){
        this.vacleavemanagename = vacleavemanagename ;
        this.modify("vacleavemanagename",vacleavemanagename);
    }

    /**
     * 设置 [QJMX]
     */
    public void setQjmx(String  qjmx){
        this.qjmx = qjmx ;
        this.modify("qjmx",qjmx);
    }

    /**
     * 设置 [JHKSSXW]
     */
    public void setJhkssxw(String  jhkssxw){
        this.jhkssxw = jhkssxw ;
        this.modify("jhkssxw",jhkssxw);
    }

    /**
     * 设置 [QJZL]
     */
    public void setQjzl(String  qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [WFQQJSTATE]
     */
    public void setWfqqjstate(String  wfqqjstate){
        this.wfqqjstate = wfqqjstate ;
        this.modify("wfqqjstate",wfqqjstate);
    }

    /**
     * 设置 [QJSY]
     */
    public void setQjsy(String  qjsy){
        this.qjsy = qjsy ;
        this.modify("qjsy",qjsy);
    }

    /**
     * 设置 [SJKSSJ]
     */
    public void setSjkssj(Timestamp  sjkssj){
        this.sjkssj = sjkssj ;
        this.modify("sjkssj",sjkssj);
    }

    /**
     * 设置 [WFRESULT]
     */
    public void setWfresult(String  wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [SJJSSJ]
     */
    public void setSjjssj(Timestamp  sjjssj){
        this.sjjssj = sjjssj ;
        this.modify("sjjssj",sjjssj);
    }

    /**
     * 设置 [TEMPID]
     */
    public void setTempid(String  tempid){
        this.tempid = tempid ;
        this.modify("tempid",tempid);
    }

    /**
     * 设置 [NJSY]
     */
    public void setNjsy(String  njsy){
        this.njsy = njsy ;
        this.modify("njsy",njsy);
    }

    /**
     * 设置 [SJKSSXW]
     */
    public void setSjkssxw(String  sjkssxw){
        this.sjkssxw = sjkssxw ;
        this.modify("sjkssxw",sjkssxw);
    }

    /**
     * 设置 [QJTS]
     */
    public void setQjts(Double  qjts){
        this.qjts = qjts ;
        this.modify("qjts",qjts);
    }

    /**
     * 设置 [QJJSSJ]
     */
    public void setQjjssj(Timestamp  qjjssj){
        this.qjjssj = qjjssj ;
        this.modify("qjjssj",qjjssj);
    }

    /**
     * 设置 [QJKSSJ]
     */
    public void setQjkssj(Timestamp  qjkssj){
        this.qjkssj = qjkssj ;
        this.modify("qjkssj",qjkssj);
    }

    /**
     * 设置 [SJQJTS]
     */
    public void setSjqjts(Double  sjqjts){
        this.sjqjts = sjqjts ;
        this.modify("sjqjts",sjqjts);
    }

    /**
     * 设置 [BGSY]
     */
    public void setBgsy(String  bgsy){
        this.bgsy = bgsy ;
        this.modify("bgsy",bgsy);
    }

    /**
     * 设置 [JHJSSXW]
     */
    public void setJhjssxw(String  jhjssxw){
        this.jhjssxw = jhjssxw ;
        this.modify("jhjssxw",jhjssxw);
    }

    /**
     * 设置 [SJJSSXW]
     */
    public void setSjjssxw(String  sjjssxw){
        this.sjjssxw = sjjssxw ;
        this.modify("sjjssxw",sjjssxw);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

