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
 * 服务DTO对象[TrmAgencyRecordDTO]
 */
@Data
public class TrmAgencyRecordDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TRMAGENCYRECORDID]
     *
     */
    @JSONField(name = "trmagencyrecordid")
    @JsonProperty("trmagencyrecordid")
    private String trmagencyrecordid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PXCS]
     *
     */
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;

    /**
     * 属性 [PXZSC]
     *
     */
    @JSONField(name = "pxzsc")
    @JsonProperty("pxzsc")
    private Double pxzsc;

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
     * 属性 [TRMAGENCYRECORDNAME]
     *
     */
    @JSONField(name = "trmagencyrecordname")
    @JsonProperty("trmagencyrecordname")
    private String trmagencyrecordname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 设置 [PXCS]
     */
    public void setPxcs(Integer  pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [PXZSC]
     */
    public void setPxzsc(Double  pxzsc){
        this.pxzsc = pxzsc ;
        this.modify("pxzsc",pxzsc);
    }

    /**
     * 设置 [TRMAGENCYRECORDNAME]
     */
    public void setTrmagencyrecordname(String  trmagencyrecordname){
        this.trmagencyrecordname = trmagencyrecordname ;
        this.modify("trmagencyrecordname",trmagencyrecordname);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

