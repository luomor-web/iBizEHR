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
 * 服务DTO对象[PcmXygzzjlmxDTO]
 */
@Data
public class PcmXygzzjlmxDTO extends DTOBase implements Serializable {

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
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMXYGZZJLMXNAME]
     *
     */
    @JSONField(name = "pcmxygzzjlmxname")
    @JsonProperty("pcmxygzzjlmxname")
    private String pcmxygzzjlmxname;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zzsj" , format="yyyy-MM-dd")
    @JsonProperty("zzsj")
    private Timestamp zzsj;

    /**
     * 属性 [FINISHED]
     *
     */
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;

    /**
     * 属性 [PCMXYGZZJLMXID]
     *
     */
    @JSONField(name = "pcmxygzzjlmxid")
    @JsonProperty("pcmxygzzjlmxid")
    private String pcmxygzzjlmxid;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISTEMP]
     *
     */
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;

    /**
     * 属性 [RZQD]
     *
     */
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [PCMXYGZZKHJGJLNAME]
     *
     */
    @JSONField(name = "pcmxygzzkhjgjlname")
    @JsonProperty("pcmxygzzkhjgjlname")
    private String pcmxygzzkhjgjlname;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;

    /**
     * 属性 [PCMXYGZZSQNAME]
     *
     */
    @JSONField(name = "pcmxygzzsqname")
    @JsonProperty("pcmxygzzsqname")
    private String pcmxygzzsqname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [FS]
     *
     */
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [QSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZZGW]
     *
     */
    @JSONField(name = "zzgw")
    @JsonProperty("zzgw")
    private String zzgw;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PCMXYGZZSQID]
     *
     */
    @JSONField(name = "pcmxygzzsqid")
    @JsonProperty("pcmxygzzsqid")
    private String pcmxygzzsqid;

    /**
     * 属性 [PCMXYGZZKHJGJLID]
     *
     */
    @JSONField(name = "pcmxygzzkhjgjlid")
    @JsonProperty("pcmxygzzkhjgjlid")
    private String pcmxygzzkhjgjlid;


    /**
     * 设置 [PCMXYGZZJLMXNAME]
     */
    public void setPcmxygzzjlmxname(String  pcmxygzzjlmxname){
        this.pcmxygzzjlmxname = pcmxygzzjlmxname ;
        this.modify("pcmxygzzjlmxname",pcmxygzzjlmxname);
    }

    /**
     * 设置 [CHECKSTATUS]
     */
    public void setCheckstatus(String  checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [ZZSJ]
     */
    public void setZzsj(Timestamp  zzsj){
        this.zzsj = zzsj ;
        this.modify("zzsj",zzsj);
    }

    /**
     * 设置 [FINISHED]
     */
    public void setFinished(Integer  finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [ISTEMP]
     */
    public void setIstemp(Integer  istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [RZQD]
     */
    public void setRzqd(String  rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(String  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [FS]
     */
    public void setFs(Double  fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [ZZGW]
     */
    public void setZzgw(String  zzgw){
        this.zzgw = zzgw ;
        this.modify("zzgw",zzgw);
    }

    /**
     * 设置 [ZZID]
     */
    public void setZzid(String  zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [BMID]
     */
    public void setBmid(String  bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PCMXYGZZSQID]
     */
    public void setPcmxygzzsqid(String  pcmxygzzsqid){
        this.pcmxygzzsqid = pcmxygzzsqid ;
        this.modify("pcmxygzzsqid",pcmxygzzsqid);
    }

    /**
     * 设置 [PCMXYGZZKHJGJLID]
     */
    public void setPcmxygzzkhjgjlid(String  pcmxygzzkhjgjlid){
        this.pcmxygzzkhjgjlid = pcmxygzzkhjgjlid ;
        this.modify("pcmxygzzkhjgjlid",pcmxygzzkhjgjlid);
    }


}

