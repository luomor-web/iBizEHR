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
 * 服务DTO对象[WFActionDTO]
 */
@Data
public class WFActionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [WFACTIONNAME]
     *
     */
    @JSONField(name = "wfactionname")
    @JsonProperty("wfactionname")
    private String wfactionname;

    /**
     * 属性 [WFACTIONID]
     *
     */
    @JSONField(name = "wfactionid")
    @JsonProperty("wfactionid")
    private String wfactionid;

    /**
     * 属性 [ACTIONCODE]
     *
     */
    @JSONField(name = "actioncode")
    @JsonProperty("actioncode")
    private String actioncode;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;


    /**
     * 设置 [WFACTIONNAME]
     */
    public void setWfactionname(String  wfactionname){
        this.wfactionname = wfactionname ;
        this.modify("wfactionname",wfactionname);
    }

    /**
     * 设置 [ACTIONCODE]
     */
    public void setActioncode(String  actioncode){
        this.actioncode = actioncode ;
        this.modify("actioncode",actioncode);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [WFWORKFLOWID]
     */
    public void setWfworkflowid(String  wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }


}

