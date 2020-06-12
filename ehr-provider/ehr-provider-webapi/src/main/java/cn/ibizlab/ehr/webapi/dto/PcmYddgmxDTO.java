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
 * 服务DTO对象[PcmYddgmxDTO]
 */
@Data
public class PcmYddgmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SXRQ]
     *
     */
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [DGDQ]
     *
     */
    @JSONField(name = "dgdq")
    @JsonProperty("dgdq")
    private String dgdq;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [YRANK]
     *
     */
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

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
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CSRQ]
     *
     */
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMYDDGMXNAME]
     *
     */
    @JSONField(name = "pcmyddgmxname")
    @JsonProperty("pcmyddgmxname")
    private String pcmyddgmxname;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;

    /**
     * 属性 [DGLX]
     *
     */
    @JSONField(name = "dglx")
    @JsonProperty("dglx")
    private String dglx;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [PCMYDDGMXID]
     *
     */
    @JSONField(name = "pcmyddgmxid")
    @JsonProperty("pcmyddgmxid")
    private String pcmyddgmxid;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [DISTIRBUTIONID]
     *
     */
    @JSONField(name = "distirbutionid")
    @JsonProperty("distirbutionid")
    private String distirbutionid;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [PCMYDMXTYPE]
     *
     */
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

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
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [DGSHORTNAME]
     *
     */
    @JSONField(name = "dgshortname")
    @JsonProperty("dgshortname")
    private String dgshortname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ISFINISHED]
     *
     */
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;


    /**
     * 设置 [DGDQ]
     */
    public void setDgdq(String  dgdq){
        this.dgdq = dgdq ;
        this.modify("dgdq",dgdq);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PCMYDDGMXNAME]
     */
    public void setPcmyddgmxname(String  pcmyddgmxname){
        this.pcmyddgmxname = pcmyddgmxname ;
        this.modify("pcmyddgmxname",pcmyddgmxname);
    }

    /**
     * 设置 [DGLX]
     */
    public void setDglx(String  dglx){
        this.dglx = dglx ;
        this.modify("dglx",dglx);
    }

    /**
     * 设置 [DISTIRBUTIONID]
     */
    public void setDistirbutionid(String  distirbutionid){
        this.distirbutionid = distirbutionid ;
        this.modify("distirbutionid",distirbutionid);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ISFINISHED]
     */
    public void setIsfinished(String  isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}

