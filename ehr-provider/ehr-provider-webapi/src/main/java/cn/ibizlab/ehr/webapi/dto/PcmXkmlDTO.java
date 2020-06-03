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
 * 服务DTO对象[PcmXkmlDTO]
 */
@Data
public class PcmXkmlDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMXKMLNAME]
     *
     */
    @JSONField(name = "pcmxkmlname")
    @JsonProperty("pcmxkmlname")
    private String pcmxkmlname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMXKMLID]
     *
     */
    @JSONField(name = "pcmxkmlid")
    @JsonProperty("pcmxkmlid")
    private String pcmxkmlid;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;

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
     * 属性 [XKML]
     *
     */
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;


    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PCMXKMLNAME]
     */
    public void setPcmxkmlname(String  pcmxkmlname){
        this.pcmxkmlname = pcmxkmlname ;
        this.modify("pcmxkmlname",pcmxkmlname);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(String  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [XKML]
     */
    public void setXkml(String  xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }


}

