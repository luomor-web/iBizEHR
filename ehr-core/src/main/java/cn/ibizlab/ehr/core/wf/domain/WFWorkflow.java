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
 * 实体[工作流配置]
 */
@Data
@TableName(value = "T_SRFWFWORKFLOW",resultMap = "WFWorkflowResultMap")
public class WFWorkflow extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 流程语言资源
     */
    @TableField(value = "wflanrestag")
    @JSONField(name = "wflanrestag")
    @JsonProperty("wflanrestag")
    private String wflanrestag;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 流程类型
     */
    @TableField(value = "wftype")
    @JSONField(name = "wftype")
    @JsonProperty("wftype")
    private String wftype;
    /**
     * 配置
     */
    @TableField(value = "wfmodel")
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;
    /**
     * 逻辑名称
     */
    @TableField(value = "wflogicname")
    @JSONField(name = "wflogicname")
    @JsonProperty("wflogicname")
    private String wflogicname;
    /**
     * 工作流配置名称
     */
    @TableField(value = "wfworkflowname")
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;
    /**
     * USERDATACMD4
     */
    @TableField(value = "userdatacmd4")
    @JSONField(name = "userdatacmd4")
    @JsonProperty("userdatacmd4")
    private String userdatacmd4;
    /**
     * USERDATACMD8
     */
    @TableField(value = "userdatacmd8")
    @JSONField(name = "userdatacmd8")
    @JsonProperty("userdatacmd8")
    private String userdatacmd8;
    /**
     * 流程辅助对象
     */
    @TableField(value = "wfhelper")
    @JSONField(name = "wfhelper")
    @JsonProperty("wfhelper")
    private String wfhelper;
    /**
     * 工作流状态
     */
    @TableField(value = "wfstate")
    @JSONField(name = "wfstate")
    @JsonProperty("wfstate")
    private Integer wfstate;
    /**
     * 版本
     */
    @TableField(value = "wfversion")
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;
    /**
     * USERDATACMD
     */
    @TableField(value = "userdatacmd")
    @JSONField(name = "userdatacmd")
    @JsonProperty("userdatacmd")
    private String userdatacmd;
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
     * USERDATACMD2
     */
    @TableField(value = "userdatacmd2")
    @JSONField(name = "userdatacmd2")
    @JsonProperty("userdatacmd2")
    private String userdatacmd2;
    /**
     * USERDATANAME
     */
    @TableField(value = "userdataname")
    @JSONField(name = "userdataname")
    @JsonProperty("userdataname")
    private String userdataname;
    /**
     * USERDATACMD3
     */
    @TableField(value = "userdatacmd3")
    @JSONField(name = "userdatacmd3")
    @JsonProperty("userdatacmd3")
    private String userdatacmd3;
    /**
     * USERDATACMD9
     */
    @TableField(value = "userdatacmd9")
    @JSONField(name = "userdatacmd9")
    @JsonProperty("userdatacmd9")
    private String userdatacmd9;
    /**
     * USERDATACMD10
     */
    @TableField(value = "userdatacmd10")
    @JSONField(name = "userdatacmd10")
    @JsonProperty("userdatacmd10")
    private String userdatacmd10;
    /**
     * USERDATACMD7
     */
    @TableField(value = "userdatacmd7")
    @JSONField(name = "userdatacmd7")
    @JsonProperty("userdatacmd7")
    private String userdatacmd7;
    /**
     * 工作流配置标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfworkflowid",type=IdType.UUID)
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;
    /**
     * 辅助对象参数
     */
    @TableField(value = "wfhelperparam")
    @JSONField(name = "wfhelperparam")
    @JsonProperty("wfhelperparam")
    private String wfhelperparam;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * USERDATACMD6
     */
    @TableField(value = "userdatacmd6")
    @JSONField(name = "userdatacmd6")
    @JsonProperty("userdatacmd6")
    private String userdatacmd6;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流说明
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * USERDATACMD5
     */
    @TableField(value = "userdatacmd5")
    @JSONField(name = "userdatacmd5")
    @JsonProperty("userdatacmd5")
    private String userdatacmd5;
    /**
     * 催办消息模板
     */
    @TableField(exist = false)
    @JSONField(name = "remindmsgtemplname")
    @JsonProperty("remindmsgtemplname")
    private String remindmsgtemplname;
    /**
     * 催办消息模板
     */
    @TableField(value = "remindmsgtemplid")
    @JSONField(name = "remindmsgtemplid")
    @JsonProperty("remindmsgtemplid")
    private String remindmsgtemplid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.MsgTemplate remindmsgtempl;



    /**
     * 设置 [流程语言资源]
     */
    public void setWflanrestag(String wflanrestag){
        this.wflanrestag = wflanrestag ;
        this.modify("wflanrestag",wflanrestag);
    }
    /**
     * 设置 [流程类型]
     */
    public void setWftype(String wftype){
        this.wftype = wftype ;
        this.modify("wftype",wftype);
    }
    /**
     * 设置 [配置]
     */
    public void setWfmodel(String wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }
    /**
     * 设置 [逻辑名称]
     */
    public void setWflogicname(String wflogicname){
        this.wflogicname = wflogicname ;
        this.modify("wflogicname",wflogicname);
    }
    /**
     * 设置 [工作流配置名称]
     */
    public void setWfworkflowname(String wfworkflowname){
        this.wfworkflowname = wfworkflowname ;
        this.modify("wfworkflowname",wfworkflowname);
    }
    /**
     * 设置 [USERDATACMD4]
     */
    public void setUserdatacmd4(String userdatacmd4){
        this.userdatacmd4 = userdatacmd4 ;
        this.modify("userdatacmd4",userdatacmd4);
    }
    /**
     * 设置 [USERDATACMD8]
     */
    public void setUserdatacmd8(String userdatacmd8){
        this.userdatacmd8 = userdatacmd8 ;
        this.modify("userdatacmd8",userdatacmd8);
    }
    /**
     * 设置 [流程辅助对象]
     */
    public void setWfhelper(String wfhelper){
        this.wfhelper = wfhelper ;
        this.modify("wfhelper",wfhelper);
    }
    /**
     * 设置 [工作流状态]
     */
    public void setWfstate(Integer wfstate){
        this.wfstate = wfstate ;
        this.modify("wfstate",wfstate);
    }
    /**
     * 设置 [版本]
     */
    public void setWfversion(Integer wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }
    /**
     * 设置 [USERDATACMD]
     */
    public void setUserdatacmd(String userdatacmd){
        this.userdatacmd = userdatacmd ;
        this.modify("userdatacmd",userdatacmd);
    }
    /**
     * 设置 [USERDATACMD2]
     */
    public void setUserdatacmd2(String userdatacmd2){
        this.userdatacmd2 = userdatacmd2 ;
        this.modify("userdatacmd2",userdatacmd2);
    }
    /**
     * 设置 [USERDATANAME]
     */
    public void setUserdataname(String userdataname){
        this.userdataname = userdataname ;
        this.modify("userdataname",userdataname);
    }
    /**
     * 设置 [USERDATACMD3]
     */
    public void setUserdatacmd3(String userdatacmd3){
        this.userdatacmd3 = userdatacmd3 ;
        this.modify("userdatacmd3",userdatacmd3);
    }
    /**
     * 设置 [USERDATACMD9]
     */
    public void setUserdatacmd9(String userdatacmd9){
        this.userdatacmd9 = userdatacmd9 ;
        this.modify("userdatacmd9",userdatacmd9);
    }
    /**
     * 设置 [USERDATACMD10]
     */
    public void setUserdatacmd10(String userdatacmd10){
        this.userdatacmd10 = userdatacmd10 ;
        this.modify("userdatacmd10",userdatacmd10);
    }
    /**
     * 设置 [USERDATACMD7]
     */
    public void setUserdatacmd7(String userdatacmd7){
        this.userdatacmd7 = userdatacmd7 ;
        this.modify("userdatacmd7",userdatacmd7);
    }
    /**
     * 设置 [辅助对象参数]
     */
    public void setWfhelperparam(String wfhelperparam){
        this.wfhelperparam = wfhelperparam ;
        this.modify("wfhelperparam",wfhelperparam);
    }
    /**
     * 设置 [USERDATACMD6]
     */
    public void setUserdatacmd6(String userdatacmd6){
        this.userdatacmd6 = userdatacmd6 ;
        this.modify("userdatacmd6",userdatacmd6);
    }
    /**
     * 设置 [工作流说明]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [USERDATACMD5]
     */
    public void setUserdatacmd5(String userdatacmd5){
        this.userdatacmd5 = userdatacmd5 ;
        this.modify("userdatacmd5",userdatacmd5);
    }
    /**
     * 设置 [催办消息模板]
     */
    public void setRemindmsgtemplid(String remindmsgtemplid){
        this.remindmsgtemplid = remindmsgtemplid ;
        this.modify("remindmsgtemplid",remindmsgtemplid);
    }

}


