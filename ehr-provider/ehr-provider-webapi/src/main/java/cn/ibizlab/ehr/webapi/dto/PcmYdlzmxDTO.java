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
 * 服务DTO对象[PcmYdlzmxDTO]
 */
@Data
public class PcmYdlzmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [SFHMD]
     *
     */
    @JSONField(name = "sfhmd")
    @JsonProperty("sfhmd")
    private Integer sfhmd;

    /**
     * 属性 [YYTYPE]
     *
     */
    @JSONField(name = "yytype")
    @JsonProperty("yytype")
    private String yytype;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [YRANK]
     *
     */
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PCMYDLZMXNAME]
     *
     */
    @JSONField(name = "pcmydlzmxname")
    @JsonProperty("pcmydlzmxname")
    private String pcmydlzmxname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [SXRQ]
     *
     */
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMYDMXTYPE]
     *
     */
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;

    /**
     * 属性 [REMARKS]
     *
     */
    @JSONField(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

    /**
     * 属性 [LZQX]
     *
     */
    @JSONField(name = "lzqx")
    @JsonProperty("lzqx")
    private String lzqx;

    /**
     * 属性 [CSRQ]
     *
     */
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PCMYDLZMXID]
     *
     */
    @JSONField(name = "pcmydlzmxid")
    @JsonProperty("pcmydlzmxid")
    private String pcmydlzmxid;

    /**
     * 属性 [LZMTRNAME]
     *
     */
    @JSONField(name = "lzmtrname")
    @JsonProperty("lzmtrname")
    private String lzmtrname;

    /**
     * 属性 [LZMTRID]
     *
     */
    @JSONField(name = "lzmtrid")
    @JsonProperty("lzmtrid")
    private String lzmtrid;

    /**
     * 属性 [ISFINISHED]
     *
     */
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;


    /**
     * 设置 [SFHMD]
     */
    public void setSfhmd(Integer  sfhmd){
        this.sfhmd = sfhmd ;
        this.modify("sfhmd",sfhmd);
    }

    /**
     * 设置 [YYTYPE]
     */
    public void setYytype(String  yytype){
        this.yytype = yytype ;
        this.modify("yytype",yytype);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PCMYDLZMXNAME]
     */
    public void setPcmydlzmxname(String  pcmydlzmxname){
        this.pcmydlzmxname = pcmydlzmxname ;
        this.modify("pcmydlzmxname",pcmydlzmxname);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [REMARKS]
     */
    public void setRemarks(String  remarks){
        this.remarks = remarks ;
        this.modify("remarks",remarks);
    }

    /**
     * 设置 [LZQX]
     */
    public void setLzqx(String  lzqx){
        this.lzqx = lzqx ;
        this.modify("lzqx",lzqx);
    }

    /**
     * 设置 [LZMTRNAME]
     */
    public void setLzmtrname(String  lzmtrname){
        this.lzmtrname = lzmtrname ;
        this.modify("lzmtrname",lzmtrname);
    }

    /**
     * 设置 [LZMTRID]
     */
    public void setLzmtrid(String  lzmtrid){
        this.lzmtrid = lzmtrid ;
        this.modify("lzmtrid",lzmtrid);
    }

    /**
     * 设置 [ISFINISHED]
     */
    public void setIsfinished(String  isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}

