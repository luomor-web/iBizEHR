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
 * 服务DTO对象[ParIntegralRuleDTO]
 */
@Data
public class ParIntegralRuleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARINTEGRALRULEID]
     *
     */
    @JSONField(name = "parintegralruleid")
    @JsonProperty("parintegralruleid")
    private String parintegralruleid;

    /**
     * 属性 [PARINTEGRALRULENAME]
     *
     */
    @JSONField(name = "parintegralrulename")
    @JsonProperty("parintegralrulename")
    private String parintegralrulename;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [INTEGRALS]
     *
     */
    @JSONField(name = "integrals")
    @JsonProperty("integrals")
    private Integer integrals;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;


    /**
     * 设置 [PARINTEGRALRULENAME]
     */
    public void setParintegralrulename(String  parintegralrulename){
        this.parintegralrulename = parintegralrulename ;
        this.modify("parintegralrulename",parintegralrulename);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [INTEGRALS]
     */
    public void setIntegrals(Integer  integrals){
        this.integrals = integrals ;
        this.modify("integrals",integrals);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }


}

