package cn.ibizlab.ehr.core.wf.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[工作流代办工作]
 */
@Data
@TableName(value = "T_SRFWFASSISTWORK",resultMap = "WFAssistWorkResultMap")
public class WFAssistWork extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作流代办工作标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfassistworkid",type=IdType.UUID)
    @JSONField(name = "wfassistworkid")
    @JsonProperty("wfassistworkid")
    private String wfassistworkid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 流程步骤名称
     */
    @TableField(value = "wfplogicname")
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 工作流代办工作名称
     */
    @TableField(value = "wfassistworkname")
    @JSONField(name = "wfassistworkname")
    @JsonProperty("wfassistworkname")
    private String wfassistworkname;
    /**
     * 流程步骤标识
     */
    @TableField(value = "wfstepid")
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;
    /**
     * 流程实例
     */
    @TableField(exist = false)
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 步骤操作者
     */
    @TableField(exist = false)
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;
    /**
     * 工作流
     */
    @TableField(exist = false)
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;
    /**
     * USERDATA4
     */
    @TableField(exist = false)
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * USERDATA
     */
    @TableField(exist = false)
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * ACTIVESTEPID
     */
    @TableField(exist = false)
    @JSONField(name = "activestepid")
    @JsonProperty("activestepid")
    private String activestepid;
    /**
     * 流程实例
     */
    @TableField(value = "wfinstanceid")
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;
    /**
     * 步骤操作者
     */
    @TableField(value = "wfstepactorid")
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;
    /**
     * 工作流
     */
    @TableField(value = "wfworkflowid")
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFStepActor wfstepactor;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow;



    /**
     * 设置 [流程步骤名称]
     */
    public void setWfplogicname(String wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }
    /**
     * 设置 [工作流代办工作名称]
     */
    public void setWfassistworkname(String wfassistworkname){
        this.wfassistworkname = wfassistworkname ;
        this.modify("wfassistworkname",wfassistworkname);
    }
    /**
     * 设置 [流程步骤标识]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }
    /**
     * 设置 [流程实例]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }
    /**
     * 设置 [步骤操作者]
     */
    public void setWfstepactorid(String wfstepactorid){
        this.wfstepactorid = wfstepactorid ;
        this.modify("wfstepactorid",wfstepactorid);
    }
    /**
     * 设置 [工作流]
     */
    public void setWfworkflowid(String wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }

}


