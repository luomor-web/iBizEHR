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
 * 服务DTO对象[PimMajorSetypeDTO]
 */
@Data
public class PimMajorSetypeDTO extends DTOBase implements Serializable {

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
     * 属性 [PIMMAJORSETYPEID]
     *
     */
    @JSONField(name = "pimmajorsetypeid")
    @JsonProperty("pimmajorsetypeid")
    private String pimmajorsetypeid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SERIALNO]
     *
     */
    @JSONField(name = "serialno")
    @JsonProperty("serialno")
    private Integer serialno;

    /**
     * 属性 [PIMMAJORSETYPENAME]
     *
     */
    @JSONField(name = "pimmajorsetypename")
    @JsonProperty("pimmajorsetypename")
    private String pimmajorsetypename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;


    /**
     * 设置 [SERIALNO]
     */
    public void setSerialno(Integer  serialno){
        this.serialno = serialno ;
        this.modify("serialno",serialno);
    }

    /**
     * 设置 [PIMMAJORSETYPENAME]
     */
    public void setPimmajorsetypename(String  pimmajorsetypename){
        this.pimmajorsetypename = pimmajorsetypename ;
        this.modify("pimmajorsetypename",pimmajorsetypename);
    }


}

