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
 * 服务DTO对象[ParLdkhqzDTO]
 */
@Data
public class ParLdkhqzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [QZZB]
     *
     */
    @JSONField(name = "qzzb")
    @JsonProperty("qzzb")
    private Double qzzb;

    /**
     * 属性 [PFZT]
     *
     */
    @JSONField(name = "pfzt")
    @JsonProperty("pfzt")
    private String pfzt;

    /**
     * 属性 [PARLDKHQZID]
     *
     */
    @JSONField(name = "parldkhqzid")
    @JsonProperty("parldkhqzid")
    private String parldkhqzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARLDKHQZNAME]
     *
     */
    @JSONField(name = "parldkhqzname")
    @JsonProperty("parldkhqzname")
    private String parldkhqzname;

    /**
     * 属性 [PARKHZCMXNAME]
     *
     */
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;

    /**
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

    /**
     * 属性 [PARKHZCMXID]
     *
     */
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;

    /**
     * 属性 [KHOBJECT]
     *
     */
    @JSONField(name = "khobject")
    @JsonProperty("khobject")
    private String khobject;


    /**
     * 设置 [QZZB]
     */
    public void setQzzb(Double  qzzb){
        this.qzzb = qzzb ;
        this.modify("qzzb",qzzb);
    }

    /**
     * 设置 [PFZT]
     */
    public void setPfzt(String  pfzt){
        this.pfzt = pfzt ;
        this.modify("pfzt",pfzt);
    }

    /**
     * 设置 [PARLDKHQZNAME]
     */
    public void setParldkhqzname(String  parldkhqzname){
        this.parldkhqzname = parldkhqzname ;
        this.modify("parldkhqzname",parldkhqzname);
    }

    /**
     * 设置 [PARKHZCMXID]
     */
    public void setParkhzcmxid(String  parkhzcmxid){
        this.parkhzcmxid = parkhzcmxid ;
        this.modify("parkhzcmxid",parkhzcmxid);
    }

    /**
     * 设置 [KHOBJECT]
     */
    public void setKhobject(String  khobject){
        this.khobject = khobject ;
        this.modify("khobject",khobject);
    }


}

