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
 * 服务DTO对象[WFAssistWorkDTO]
 */
@Data
public class WFAssistWorkDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFASSISTWORKID]
     *
     */
    @JSONField(name = "wfassistworkid")
    @JsonProperty("wfassistworkid")
    private String wfassistworkid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFPLOGICNAME]
     *
     */
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;

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
     * 属性 [WFASSISTWORKNAME]
     *
     */
    @JSONField(name = "wfassistworkname")
    @JsonProperty("wfassistworkname")
    private String wfassistworkname;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [WFSTEPACTORNAME]
     *
     */
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [ACTIVESTEPID]
     *
     */
    @JSONField(name = "activestepid")
    @JsonProperty("activestepid")
    private String activestepid;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;

    /**
     * 属性 [WFSTEPACTORID]
     *
     */
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;


    /**
     * 设置 [WFPLOGICNAME]
     */
    public void setWfplogicname(String  wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }

    /**
     * 设置 [WFASSISTWORKNAME]
     */
    public void setWfassistworkname(String  wfassistworkname){
        this.wfassistworkname = wfassistworkname ;
        this.modify("wfassistworkname",wfassistworkname);
    }

    /**
     * 设置 [WFSTEPID]
     */
    public void setWfstepid(String  wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }

    /**
     * 设置 [WFSTEPACTORID]
     */
    public void setWfstepactorid(String  wfstepactorid){
        this.wfstepactorid = wfstepactorid ;
        this.modify("wfstepactorid",wfstepactorid);
    }

    /**
     * 设置 [WFWORKFLOWID]
     */
    public void setWfworkflowid(String  wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }


}

