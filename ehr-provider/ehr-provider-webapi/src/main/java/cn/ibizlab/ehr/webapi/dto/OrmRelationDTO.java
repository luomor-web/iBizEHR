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
 * 服务DTO对象[OrmRelationDTO]
 */
@Data
public class OrmRelationDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORMRELATIONNAME]
     *
     */
    @JSONField(name = "ormorgrelationname")
    @JsonProperty("ormorgrelationname")
    private String ormorgrelationname;

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
     * 属性 [ORMRELATIONID]
     *
     */
    @JSONField(name = "ormorgrelationid")
    @JsonProperty("ormorgrelationid")
    private String ormorgrelationid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [MAGUNITID]
     *
     */
    @JSONField(name = "magunitid")
    @JsonProperty("magunitid")
    private String magunitid;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [MANAGEMENTUNITS]
     *
     */
    @JSONField(name = "managementunits")
    @JsonProperty("managementunits")
    private String managementunits;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;


    /**
     * 设置 [ORMRELATIONNAME]
     */
    public void setOrmorgrelationname(String  ormorgrelationname){
        this.ormorgrelationname = ormorgrelationname ;
        this.modify("ormrelationname",ormorgrelationname);
    }

    /**
     * 设置 [MAGUNITID]
     */
    public void setMagunitid(String  magunitid){
        this.magunitid = magunitid ;
        this.modify("magunitid",magunitid);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [MANAGEMENTUNITS]
     */
    public void setManagementunits(String  managementunits){
        this.managementunits = managementunits ;
        this.modify("managementunits",managementunits);
    }


}

