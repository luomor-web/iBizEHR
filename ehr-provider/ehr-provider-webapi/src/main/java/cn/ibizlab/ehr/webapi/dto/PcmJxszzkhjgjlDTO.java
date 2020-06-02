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
 * 服务DTO对象[PcmJxszzkhjgjlDTO]
 */
@Data
public class PcmJxszzkhjgjlDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [PCMJXSZZKHJGJLNAME]
     *
     */
    @JSONField(name = "pcmjxszzkhjgjlname")
    @JsonProperty("pcmjxszzkhjgjlname")
    private String pcmjxszzkhjgjlname;

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
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FS]
     *
     */
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;

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
     * 属性 [PCMJXSZZKHJGJLID]
     *
     */
    @JSONField(name = "pcmjxszzkhjgjlid")
    @JsonProperty("pcmjxszzkhjgjlid")
    private String pcmjxszzkhjgjlid;

    /**
     * 属性 [QSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("qssj")
    private Timestamp qssj;


    /**
     * 设置 [ENABLE]
     */
    public void setEnable(Integer  enable){
        this.enable = enable ;
        this.modify("enable",enable);
    }

    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [PCMJXSZZKHJGJLNAME]
     */
    public void setPcmjxszzkhjgjlname(String  pcmjxszzkhjgjlname){
        this.pcmjxszzkhjgjlname = pcmjxszzkhjgjlname ;
        this.modify("pcmjxszzkhjgjlname",pcmjxszzkhjgjlname);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [JSSJ]
     */
    public void setJssj(Timestamp  jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 设置 [FS]
     */
    public void setFs(Double  fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [QSSJ]
     */
    public void setQssj(Timestamp  qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }


}

