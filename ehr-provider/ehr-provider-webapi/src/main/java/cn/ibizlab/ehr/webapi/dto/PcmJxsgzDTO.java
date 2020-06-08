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
 * 服务DTO对象[PcmJxsgzDTO]
 */
@Data
public class PcmJxsgzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JXQJS]
     *
     */
    @JSONField(name = "jxqjs")
    @JsonProperty("jxqjs")
    private Double jxqjs;

    /**
     * 属性 [KSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksrq" , format="yyyy-MM-dd")
    @JsonProperty("ksrq")
    private Timestamp ksrq;

    /**
     * 属性 [XLLX]
     *
     */
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [APPLYEDU]
     *
     */
    @JSONField(name = "applyedu")
    @JsonProperty("applyedu")
    private String applyedu;

    /**
     * 属性 [PCMJXSGZID]
     *
     */
    @JSONField(name = "pcmjxsgzid")
    @JsonProperty("pcmjxsgzid")
    private String pcmjxsgzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PCMJXSGZNAME]
     *
     */
    @JSONField(name = "pcmjxsgzname")
    @JsonProperty("pcmjxsgzname")
    private String pcmjxsgzname;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

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
     * 设置 [JXQJS]
     */
    public void setJxqjs(Double  jxqjs){
        this.jxqjs = jxqjs ;
        this.modify("jxqjs",jxqjs);
    }

    /**
     * 设置 [KSRQ]
     */
    public void setKsrq(Timestamp  ksrq){
        this.ksrq = ksrq ;
        this.modify("ksrq",ksrq);
    }

    /**
     * 设置 [XLLX]
     */
    public void setXllx(String  xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [APPLYEDU]
     */
    public void setApplyedu(String  applyedu){
        this.applyedu = applyedu ;
        this.modify("applyedu",applyedu);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(String  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [PCMJXSGZNAME]
     */
    public void setPcmjxsgzname(String  pcmjxsgzname){
        this.pcmjxsgzname = pcmjxsgzname ;
        this.modify("pcmjxsgzname",pcmjxsgzname);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }


}

