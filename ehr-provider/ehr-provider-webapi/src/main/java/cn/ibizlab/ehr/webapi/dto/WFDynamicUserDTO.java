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
 * 服务DTO对象[WFDynamicUserDTO]
 */
@Data
public class WFDynamicUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARAMS]
     *
     */
    @JSONField(name = "params")
    @JsonProperty("params")
    private String params;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFDYNAMICUSERID]
     *
     */
    @JSONField(name = "wfdynamicuserid")
    @JsonProperty("wfdynamicuserid")
    private String wfdynamicuserid;

    /**
     * 属性 [USERTYPE]
     *
     */
    @JSONField(name = "usertype")
    @JsonProperty("usertype")
    private String usertype;

    /**
     * 属性 [USEROBJECT]
     *
     */
    @JSONField(name = "userobject")
    @JsonProperty("userobject")
    private String userobject;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFDYNAMICUSERNAME]
     *
     */
    @JSONField(name = "wfdynamicusername")
    @JsonProperty("wfdynamicusername")
    private String wfdynamicusername;


    /**
     * 设置 [PARAMS]
     */
    public void setParams(String  params){
        this.params = params ;
        this.modify("params",params);
    }

    /**
     * 设置 [USERTYPE]
     */
    public void setUsertype(String  usertype){
        this.usertype = usertype ;
        this.modify("usertype",usertype);
    }

    /**
     * 设置 [USEROBJECT]
     */
    public void setUserobject(String  userobject){
        this.userobject = userobject ;
        this.modify("userobject",userobject);
    }

    /**
     * 设置 [WFDYNAMICUSERNAME]
     */
    public void setWfdynamicusername(String  wfdynamicusername){
        this.wfdynamicusername = wfdynamicusername ;
        this.modify("wfdynamicusername",wfdynamicusername);
    }


}

