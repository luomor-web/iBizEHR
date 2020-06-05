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
 * 服务DTO对象[VacLeaveDetailDTO]
 */
@Data
public class VacLeaveDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VACLEAVEDETAILID]
     *
     */
    @JSONField(name = "vacleavedetailid")
    @JsonProperty("vacleavedetailid")
    private String vacleavedetailid;

    /**
     * 属性 [HYZK]
     *
     */
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;

    /**
     * 属性 [VACLEAVEDETAILNAME]
     *
     */
    @JSONField(name = "vacleavedetailname")
    @JsonProperty("vacleavedetailname")
    private String vacleavedetailname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [QJZL]
     *
     */
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;

    /**
     * 属性 [SJQJJS]
     *
     */
    @JSONField(name = "sjqjjs")
    @JsonProperty("sjqjjs")
    private String sjqjjs;

    /**
     * 属性 [JHJSSXW]
     *
     */
    @JSONField(name = "jhjssxw")
    @JsonProperty("jhjssxw")
    private String jhjssxw;

    /**
     * 属性 [JHKSSXW]
     *
     */
    @JSONField(name = "jhkssxw")
    @JsonProperty("jhkssxw")
    private String jhkssxw;

    /**
     * 属性 [NJSY]
     *
     */
    @JSONField(name = "njsy")
    @JsonProperty("njsy")
    private String njsy;

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
     * 属性 [SJTS]
     *
     */
    @JSONField(name = "sjts")
    @JsonProperty("sjts")
    private Double sjts;

    /**
     * 属性 [TQLX]
     *
     */
    @JSONField(name = "tqlx")
    @JsonProperty("tqlx")
    private String tqlx;

    /**
     * 属性 [SJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjkssj" , format="yyyy-MM-dd")
    @JsonProperty("sjkssj")
    private Timestamp sjkssj;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SJJSSXW]
     *
     */
    @JSONField(name = "sjjssxw")
    @JsonProperty("sjjssxw")
    private String sjjssxw;

    /**
     * 属性 [JHKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;

    /**
     * 属性 [SJKSSXW]
     *
     */
    @JSONField(name = "sjkssxw")
    @JsonProperty("sjkssxw")
    private String sjkssxw;

    /**
     * 属性 [JHQJKS]
     *
     */
    @JSONField(name = "jhqjks")
    @JsonProperty("jhqjks")
    private String jhqjks;

    /**
     * 属性 [JHTS]
     *
     */
    @JSONField(name = "jhts")
    @JsonProperty("jhts")
    private Double jhts;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [SJQJKS]
     *
     */
    @JSONField(name = "sjqjks")
    @JsonProperty("sjqjks")
    private String sjqjks;

    /**
     * 属性 [JHQJJS]
     *
     */
    @JSONField(name = "jhqjjs")
    @JsonProperty("jhqjjs")
    private String jhqjjs;

    /**
     * 属性 [TIPS]
     *
     */
    @JSONField(name = "tips")
    @JsonProperty("tips")
    private String tips;

    /**
     * 属性 [JHJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [STATE]
     *
     */
    @JSONField(name = "state")
    @JsonProperty("state")
    private String state;


    /**
     * 设置 [HYZK]
     */
    public void setHyzk(String  hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }

    /**
     * 设置 [VACLEAVEDETAILNAME]
     */
    public void setVacleavedetailname(String  vacleavedetailname){
        this.vacleavedetailname = vacleavedetailname ;
        this.modify("vacleavedetailname",vacleavedetailname);
    }

    /**
     * 设置 [QJZL]
     */
    public void setQjzl(String  qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [JHJSSXW]
     */
    public void setJhjssxw(String  jhjssxw){
        this.jhjssxw = jhjssxw ;
        this.modify("jhjssxw",jhjssxw);
    }

    /**
     * 设置 [JHKSSXW]
     */
    public void setJhkssxw(String  jhkssxw){
        this.jhkssxw = jhkssxw ;
        this.modify("jhkssxw",jhkssxw);
    }

    /**
     * 设置 [NJSY]
     */
    public void setNjsy(String  njsy){
        this.njsy = njsy ;
        this.modify("njsy",njsy);
    }

    /**
     * 设置 [SJJSSJ]
     */
    public void setSjjssj(Timestamp  sjjssj){
        this.sjjssj = sjjssj ;
        this.modify("sjjssj",sjjssj);
    }

    /**
     * 设置 [SJTS]
     */
    public void setSjts(Double  sjts){
        this.sjts = sjts ;
        this.modify("sjts",sjts);
    }

    /**
     * 设置 [TQLX]
     */
    public void setTqlx(String  tqlx){
        this.tqlx = tqlx ;
        this.modify("tqlx",tqlx);
    }

    /**
     * 设置 [SJKSSJ]
     */
    public void setSjkssj(Timestamp  sjkssj){
        this.sjkssj = sjkssj ;
        this.modify("sjkssj",sjkssj);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [SJJSSXW]
     */
    public void setSjjssxw(String  sjjssxw){
        this.sjjssxw = sjjssxw ;
        this.modify("sjjssxw",sjjssxw);
    }

    /**
     * 设置 [JHKSSJ]
     */
    public void setJhkssj(Timestamp  jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }

    /**
     * 设置 [SJKSSXW]
     */
    public void setSjkssxw(String  sjkssxw){
        this.sjkssxw = sjkssxw ;
        this.modify("sjkssxw",sjkssxw);
    }

    /**
     * 设置 [JHTS]
     */
    public void setJhts(Double  jhts){
        this.jhts = jhts ;
        this.modify("jhts",jhts);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [TIPS]
     */
    public void setTips(String  tips){
        this.tips = tips ;
        this.modify("tips",tips);
    }

    /**
     * 设置 [JHJSSJ]
     */
    public void setJhjssj(Timestamp  jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [STATE]
     */
    public void setState(String  state){
        this.state = state ;
        this.modify("state",state);
    }


}

