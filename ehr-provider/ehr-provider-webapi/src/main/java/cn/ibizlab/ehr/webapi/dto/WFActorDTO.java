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
 * 服务DTO对象[WFActorDTO]
 */
@Data
public class WFActorDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFACTORTYPE]
     *
     */
    @JSONField(name = "wfactortype")
    @JsonProperty("wfactortype")
    private String wfactortype;

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
     * 属性 [WFACTORPARAM2]
     *
     */
    @JSONField(name = "wfactorparam2")
    @JsonProperty("wfactorparam2")
    private String wfactorparam2;

    /**
     * 属性 [WFACTORPARAM]
     *
     */
    @JSONField(name = "wfactorparam")
    @JsonProperty("wfactorparam")
    private String wfactorparam;

    /**
     * 属性 [WFACTORNAME]
     *
     */
    @JSONField(name = "wfactorname")
    @JsonProperty("wfactorname")
    private String wfactorname;

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
     * 属性 [WFACTORID]
     *
     */
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;

    /**
     * 属性 [PARAMS]
     *
     */
    @JSONField(name = "params")
    @JsonProperty("params")
    private String params;


    /**
     * 设置 [WFACTORTYPE]
     */
    public void setWfactortype(String  wfactortype){
        this.wfactortype = wfactortype ;
        this.modify("wfactortype",wfactortype);
    }

    /**
     * 设置 [WFACTORPARAM2]
     */
    public void setWfactorparam2(String  wfactorparam2){
        this.wfactorparam2 = wfactorparam2 ;
        this.modify("wfactorparam2",wfactorparam2);
    }

    /**
     * 设置 [WFACTORPARAM]
     */
    public void setWfactorparam(String  wfactorparam){
        this.wfactorparam = wfactorparam ;
        this.modify("wfactorparam",wfactorparam);
    }

    /**
     * 设置 [WFACTORNAME]
     */
    public void setWfactorname(String  wfactorname){
        this.wfactorname = wfactorname ;
        this.modify("wfactorname",wfactorname);
    }

    /**
     * 设置 [PARAMS]
     */
    public void setParams(String  params){
        this.params = params ;
        this.modify("params",params);
    }


}

