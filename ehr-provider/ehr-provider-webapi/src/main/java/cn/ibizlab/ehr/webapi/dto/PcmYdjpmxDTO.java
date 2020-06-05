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
 * 服务DTO对象[PcmYdjpmxDTO]
 */
@Data
public class PcmYdjpmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMYDMXTYPE]
     *
     */
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;

    /**
     * 属性 [JSRQ]
     *
     */
    @JSONField(name = "jsrq")
    @JsonProperty("jsrq")
    private String jsrq;

    /**
     * 属性 [SFHMD]
     *
     */
    @JSONField(name = "sfhmd")
    @JsonProperty("sfhmd")
    private Integer sfhmd;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [SFLDZY]
     *
     */
    @JSONField(name = "sfldzy")
    @JsonProperty("sfldzy")
    private Integer sfldzy;

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
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [REMARKS]
     *
     */
    @JSONField(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

    /**
     * 属性 [BCJSE]
     *
     */
    @JSONField(name = "bcjse")
    @JsonProperty("bcjse")
    private Double bcjse;

    /**
     * 属性 [LDZYTYPE]
     *
     */
    @JSONField(name = "ldzytype")
    @JsonProperty("ldzytype")
    private String ldzytype;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMYDJPMXID]
     *
     */
    @JSONField(name = "pcmydjpmxid")
    @JsonProperty("pcmydjpmxid")
    private String pcmydjpmxid;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [PCJSE]
     *
     */
    @JSONField(name = "pcjse")
    @JsonProperty("pcjse")
    private Double pcjse;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PCMYDJPMXNAME]
     *
     */
    @JSONField(name = "pcmydjpmxname")
    @JsonProperty("pcmydjpmxname")
    private String pcmydjpmxname;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [SXRQ]
     *
     */
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [JPFJ]
     *
     */
    @JSONField(name = "jpfj")
    @JsonProperty("jpfj")
    private String jpfj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [YRANK]
     *
     */
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [CSRQ]
     *
     */
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;

    /**
     * 属性 [SFZFBCJ]
     *
     */
    @JSONField(name = "sfzfbcj")
    @JsonProperty("sfzfbcj")
    private Integer sfzfbcj;

    /**
     * 属性 [ISFINISHED]
     *
     */
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;


    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(String  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [SFHMD]
     */
    public void setSfhmd(Integer  sfhmd){
        this.sfhmd = sfhmd ;
        this.modify("sfhmd",sfhmd);
    }

    /**
     * 设置 [SFLDZY]
     */
    public void setSfldzy(Integer  sfldzy){
        this.sfldzy = sfldzy ;
        this.modify("sfldzy",sfldzy);
    }

    /**
     * 设置 [REMARKS]
     */
    public void setRemarks(String  remarks){
        this.remarks = remarks ;
        this.modify("remarks",remarks);
    }

    /**
     * 设置 [BCJSE]
     */
    public void setBcjse(Double  bcjse){
        this.bcjse = bcjse ;
        this.modify("bcjse",bcjse);
    }

    /**
     * 设置 [LDZYTYPE]
     */
    public void setLdzytype(String  ldzytype){
        this.ldzytype = ldzytype ;
        this.modify("ldzytype",ldzytype);
    }

    /**
     * 设置 [PCJSE]
     */
    public void setPcjse(Double  pcjse){
        this.pcjse = pcjse ;
        this.modify("pcjse",pcjse);
    }

    /**
     * 设置 [PCMYDJPMXNAME]
     */
    public void setPcmydjpmxname(String  pcmydjpmxname){
        this.pcmydjpmxname = pcmydjpmxname ;
        this.modify("pcmydjpmxname",pcmydjpmxname);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [JPFJ]
     */
    public void setJpfj(String  jpfj){
        this.jpfj = jpfj ;
        this.modify("jpfj",jpfj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [SFZFBCJ]
     */
    public void setSfzfbcj(Integer  sfzfbcj){
        this.sfzfbcj = sfzfbcj ;
        this.modify("sfzfbcj",sfzfbcj);
    }

    /**
     * 设置 [ISFINISHED]
     */
    public void setIsfinished(String  isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}

