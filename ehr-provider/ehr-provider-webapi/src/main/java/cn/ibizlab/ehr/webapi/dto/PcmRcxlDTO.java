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
 * 服务DTO对象[PcmRcxlDTO]
 */
@Data
public class PcmRcxlDTO extends DTOBase implements Serializable {

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CODE]
     *
     */
    @JSONField(name = "code")
    @JsonProperty("code")
    private String code;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [RCXLMC]
     *
     */
    @JSONField(name = "rcxlmc")
    @JsonProperty("rcxlmc")
    private String rcxlmc;

    /**
     * 属性 [PCMRCXLID]
     *
     */
    @JSONField(name = "pcmrcxlid")
    @JsonProperty("pcmrcxlid")
    private String pcmrcxlid;

    /**
     * 属性 [SNUMBER]
     *
     */
    @JSONField(name = "snumber")
    @JsonProperty("snumber")
    private Integer snumber;

    /**
     * 属性 [RCXLLX]
     *
     */
    @JSONField(name = "rcxllx")
    @JsonProperty("rcxllx")
    private String rcxllx;

    /**
     * 属性 [PCMRCXLNAME]
     *
     */
    @JSONField(name = "pcmrcxlname")
    @JsonProperty("pcmrcxlname")
    private String pcmrcxlname;

    /**
     * 属性 [XLDJ]
     *
     */
    @JSONField(name = "xldj")
    @JsonProperty("xldj")
    private String xldj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMRCXLNAME2]
     *
     */
    @JSONField(name = "pcmrcxlname2")
    @JsonProperty("pcmrcxlname2")
    private String pcmrcxlname2;

    /**
     * 属性 [PCMRCXLID2]
     *
     */
    @JSONField(name = "pcmrcxlid2")
    @JsonProperty("pcmrcxlid2")
    private String pcmrcxlid2;


    /**
     * 设置 [CODE]
     */
    public void setCode(String  code){
        this.code = code ;
        this.modify("code",code);
    }

    /**
     * 设置 [SNUMBER]
     */
    public void setSnumber(Integer  snumber){
        this.snumber = snumber ;
        this.modify("snumber",snumber);
    }

    /**
     * 设置 [RCXLLX]
     */
    public void setRcxllx(String  rcxllx){
        this.rcxllx = rcxllx ;
        this.modify("rcxllx",rcxllx);
    }

    /**
     * 设置 [PCMRCXLNAME]
     */
    public void setPcmrcxlname(String  pcmrcxlname){
        this.pcmrcxlname = pcmrcxlname ;
        this.modify("pcmrcxlname",pcmrcxlname);
    }

    /**
     * 设置 [XLDJ]
     */
    public void setXldj(String  xldj){
        this.xldj = xldj ;
        this.modify("xldj",xldj);
    }

    /**
     * 设置 [PCMRCXLID2]
     */
    public void setPcmrcxlid2(String  pcmrcxlid2){
        this.pcmrcxlid2 = pcmrcxlid2 ;
        this.modify("pcmrcxlid2",pcmrcxlid2);
    }


}

