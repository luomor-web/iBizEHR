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
 * 服务DTO对象[PcmJxsygzzsqDTO]
 */
@Data
public class PcmJxsygzzsqDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "czrq" , format="yyyy-MM-dd")
    @JsonProperty("czrq")
    private Timestamp czrq;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [CZR]
     *
     */
    @JSONField(name = "czr")
    @JsonProperty("czr")
    private String czr;

    /**
     * 属性 [ISTEMP]
     *
     */
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CZRID]
     *
     */
    @JSONField(name = "czrid")
    @JsonProperty("czrid")
    private String czrid;

    /**
     * 属性 [PCMJXSYGZZSQNAME]
     *
     */
    @JSONField(name = "pcmjxsygzzsqname")
    @JsonProperty("pcmjxsygzzsqname")
    private String pcmjxsygzzsqname;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZZLX]
     *
     */
    @JSONField(name = "zzlx")
    @JsonProperty("zzlx")
    private String zzlx;

    /**
     * 属性 [PCMJXSYGZZSQID]
     *
     */
    @JSONField(name = "pcmjxsygzzsqid")
    @JsonProperty("pcmjxsygzzsqid")
    private String pcmjxsygzzsqid;


    /**
     * 设置 [CZRQ]
     */
    public void setCzrq(Timestamp  czrq){
        this.czrq = czrq ;
        this.modify("czrq",czrq);
    }

    /**
     * 设置 [CZR]
     */
    public void setCzr(String  czr){
        this.czr = czr ;
        this.modify("czr",czr);
    }

    /**
     * 设置 [ISTEMP]
     */
    public void setIstemp(Integer  istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [CZRID]
     */
    public void setCzrid(String  czrid){
        this.czrid = czrid ;
        this.modify("czrid",czrid);
    }

    /**
     * 设置 [PCMJXSYGZZSQNAME]
     */
    public void setPcmjxsygzzsqname(String  pcmjxsygzzsqname){
        this.pcmjxsygzzsqname = pcmjxsygzzsqname ;
        this.modify("pcmjxsygzzsqname",pcmjxsygzzsqname);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [ZZLX]
     */
    public void setZzlx(String  zzlx){
        this.zzlx = zzlx ;
        this.modify("zzlx",zzlx);
    }


}

