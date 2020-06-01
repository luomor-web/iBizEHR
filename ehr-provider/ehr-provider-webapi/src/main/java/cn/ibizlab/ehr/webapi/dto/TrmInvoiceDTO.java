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
 * 服务DTO对象[TrmInvoiceDTO]
 */
@Data
public class TrmInvoiceDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DZ]
     *
     */
    @JSONField(name = "dz")
    @JsonProperty("dz")
    private String dz;

    /**
     * 属性 [KPR]
     *
     */
    @JSONField(name = "kpr")
    @JsonProperty("kpr")
    private String kpr;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [KPLX]
     *
     */
    @JSONField(name = "kplx")
    @JsonProperty("kplx")
    private String kplx;

    /**
     * 属性 [KHHZH]
     *
     */
    @JSONField(name = "khhzh")
    @JsonProperty("khhzh")
    private String khhzh;

    /**
     * 属性 [KHH]
     *
     */
    @JSONField(name = "khh")
    @JsonProperty("khh")
    private String khh;

    /**
     * 属性 [TRMINVOICEID]
     *
     */
    @JSONField(name = "trminvoiceid")
    @JsonProperty("trminvoiceid")
    private String trminvoiceid;

    /**
     * 属性 [TRMINVOICENAME]
     *
     */
    @JSONField(name = "trminvoicename")
    @JsonProperty("trminvoicename")
    private String trminvoicename;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [NSRSBH]
     *
     */
    @JSONField(name = "nsrsbh")
    @JsonProperty("nsrsbh")
    private String nsrsbh;

    /**
     * 属性 [DH]
     *
     */
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;

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
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [DZ]
     */
    public void setDz(String  dz){
        this.dz = dz ;
        this.modify("dz",dz);
    }

    /**
     * 设置 [KPR]
     */
    public void setKpr(String  kpr){
        this.kpr = kpr ;
        this.modify("kpr",kpr);
    }

    /**
     * 设置 [KPLX]
     */
    public void setKplx(String  kplx){
        this.kplx = kplx ;
        this.modify("kplx",kplx);
    }

    /**
     * 设置 [KHHZH]
     */
    public void setKhhzh(String  khhzh){
        this.khhzh = khhzh ;
        this.modify("khhzh",khhzh);
    }

    /**
     * 设置 [KHH]
     */
    public void setKhh(String  khh){
        this.khh = khh ;
        this.modify("khh",khh);
    }

    /**
     * 设置 [TRMINVOICENAME]
     */
    public void setTrminvoicename(String  trminvoicename){
        this.trminvoicename = trminvoicename ;
        this.modify("trminvoicename",trminvoicename);
    }

    /**
     * 设置 [NSRSBH]
     */
    public void setNsrsbh(String  nsrsbh){
        this.nsrsbh = nsrsbh ;
        this.modify("nsrsbh",nsrsbh);
    }

    /**
     * 设置 [DH]
     */
    public void setDh(String  dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

