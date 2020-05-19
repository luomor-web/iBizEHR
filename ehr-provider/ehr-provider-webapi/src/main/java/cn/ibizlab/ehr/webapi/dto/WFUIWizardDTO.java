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
 * 服务DTO对象[WFUIWizardDTO]
 */
@Data
public class WFUIWizardDTO extends DTOBase implements Serializable {

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
     * 属性 [ACTIONPARAM]
     *
     */
    @JSONField(name = "actionparam")
    @JsonProperty("actionparam")
    private String actionparam;

    /**
     * 属性 [DATAINFO]
     *
     */
    @JSONField(name = "datainfo")
    @JsonProperty("datainfo")
    private String datainfo;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ACTIONMODE]
     *
     */
    @JSONField(name = "actionmode")
    @JsonProperty("actionmode")
    private String actionmode;

    /**
     * 属性 [WFUIWIZARDNAME]
     *
     */
    @JSONField(name = "wfuiwizardname")
    @JsonProperty("wfuiwizardname")
    private String wfuiwizardname;

    /**
     * 属性 [WFSTEPVALUE]
     *
     */
    @JSONField(name = "wfstepvalue")
    @JsonProperty("wfstepvalue")
    private String wfstepvalue;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFUIWIZARDID]
     *
     */
    @JSONField(name = "wfuiwizardid")
    @JsonProperty("wfuiwizardid")
    private String wfuiwizardid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [ACTIONPARAM]
     */
    public void setActionparam(String  actionparam){
        this.actionparam = actionparam ;
        this.modify("actionparam",actionparam);
    }

    /**
     * 设置 [DATAINFO]
     */
    public void setDatainfo(String  datainfo){
        this.datainfo = datainfo ;
        this.modify("datainfo",datainfo);
    }

    /**
     * 设置 [ACTIONMODE]
     */
    public void setActionmode(String  actionmode){
        this.actionmode = actionmode ;
        this.modify("actionmode",actionmode);
    }

    /**
     * 设置 [WFUIWIZARDNAME]
     */
    public void setWfuiwizardname(String  wfuiwizardname){
        this.wfuiwizardname = wfuiwizardname ;
        this.modify("wfuiwizardname",wfuiwizardname);
    }

    /**
     * 设置 [WFSTEPVALUE]
     */
    public void setWfstepvalue(String  wfstepvalue){
        this.wfstepvalue = wfstepvalue ;
        this.modify("wfstepvalue",wfstepvalue);
    }


}

