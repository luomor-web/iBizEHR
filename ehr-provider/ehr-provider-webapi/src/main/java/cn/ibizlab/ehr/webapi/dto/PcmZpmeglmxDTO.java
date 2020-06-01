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
 * 服务DTO对象[PcmZpmeglmxDTO]
 */
@Data
public class PcmZpmeglmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMZPMEGLMXID]
     *
     */
    @JSONField(name = "pcmzpmeglmxid")
    @JsonProperty("pcmzpmeglmxid")
    private String pcmzpmeglmxid;

    /**
     * 属性 [PFRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pfrq" , format="yyyy-MM-dd")
    @JsonProperty("pfrq")
    private Timestamp pfrq;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMZPMEGLMXNAME]
     *
     */
    @JSONField(name = "pcmzpmeglmxname")
    @JsonProperty("pcmzpmeglmxname")
    private String pcmzpmeglmxname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMZPMEGLNAME]
     *
     */
    @JSONField(name = "pcmzpmeglname")
    @JsonProperty("pcmzpmeglname")
    private String pcmzpmeglname;

    /**
     * 属性 [PCMZPMEGLID]
     *
     */
    @JSONField(name = "pcmzpmeglid")
    @JsonProperty("pcmzpmeglid")
    private String pcmzpmeglid;


    /**
     * 设置 [PFRQ]
     */
    public void setPfrq(Timestamp  pfrq){
        this.pfrq = pfrq ;
        this.modify("pfrq",pfrq);
    }

    /**
     * 设置 [PCMZPMEGLMXNAME]
     */
    public void setPcmzpmeglmxname(String  pcmzpmeglmxname){
        this.pcmzpmeglmxname = pcmzpmeglmxname ;
        this.modify("pcmzpmeglmxname",pcmzpmeglmxname);
    }

    /**
     * 设置 [PCMZPMEGLID]
     */
    public void setPcmzpmeglid(String  pcmzpmeglid){
        this.pcmzpmeglid = pcmzpmeglid ;
        this.modify("pcmzpmeglid",pcmzpmeglid);
    }


}

