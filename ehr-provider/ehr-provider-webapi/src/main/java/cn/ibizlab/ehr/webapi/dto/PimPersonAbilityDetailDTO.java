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
 * 服务DTO对象[PimPersonAbilityDetailDTO]
 */
@Data
public class PimPersonAbilityDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMPERSONABILITYDETAILNAME]
     *
     */
    @JSONField(name = "pimpersonabilitydetailname")
    @JsonProperty("pimpersonabilitydetailname")
    private String pimpersonabilitydetailname;

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
     * 属性 [PIMPERSONABILITYDETAILID]
     *
     */
    @JSONField(name = "pimpersonabilitydetailid")
    @JsonProperty("pimpersonabilitydetailid")
    private String pimpersonabilitydetailid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMPERSONABILITYID]
     *
     */
    @JSONField(name = "pimpersonabilityid")
    @JsonProperty("pimpersonabilityid")
    private String pimpersonabilityid;


    /**
     * 设置 [PIMPERSONABILITYDETAILNAME]
     */
    public void setPimpersonabilitydetailname(String  pimpersonabilitydetailname){
        this.pimpersonabilitydetailname = pimpersonabilitydetailname ;
        this.modify("pimpersonabilitydetailname",pimpersonabilitydetailname);
    }

    /**
     * 设置 [PIMPERSONABILITYID]
     */
    public void setPimpersonabilityid(String  pimpersonabilityid){
        this.pimpersonabilityid = pimpersonabilityid ;
        this.modify("pimpersonabilityid",pimpersonabilityid);
    }


}

