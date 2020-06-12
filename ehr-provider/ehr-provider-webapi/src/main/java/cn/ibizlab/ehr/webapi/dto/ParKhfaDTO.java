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
 * 服务DTO对象[ParKhfaDTO]
 */
@Data
public class ParKhfaDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "szsj" , format="yyyy-MM-dd")
    @JsonProperty("szsj")
    private Timestamp szsj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARKHFANAME]
     *
     */
    @JSONField(name = "parkhfaname")
    @JsonProperty("parkhfaname")
    private String parkhfaname;

    /**
     * 属性 [PARKHFAID]
     *
     */
    @JSONField(name = "parkhfaid")
    @JsonProperty("parkhfaid")
    private String parkhfaid;

    /**
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [AVAILABLEFLAG]
     *
     */
    @JSONField(name = "availableflag")
    @JsonProperty("availableflag")
    private String availableflag;


    /**
     * 设置 [SZSJ]
     */
    public void setSzsj(Timestamp  szsj){
        this.szsj = szsj ;
        this.modify("szsj",szsj);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [PARKHFANAME]
     */
    public void setParkhfaname(String  parkhfaname){
        this.parkhfaname = parkhfaname ;
        this.modify("parkhfaname",parkhfaname);
    }

    /**
     * 设置 [KHDX]
     */
    public void setKhdx(String  khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [AVAILABLEFLAG]
     */
    public void setAvailableflag(String  availableflag){
        this.availableflag = availableflag ;
        this.modify("availableflag",availableflag);
    }


}

