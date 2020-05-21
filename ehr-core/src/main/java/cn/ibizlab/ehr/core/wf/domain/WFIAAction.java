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
 * 实体[工作流交互操作]
 */
@Data
@TableName(value = "T_WFIAACTION",resultMap = "WFIAActionResultMap")
public class WFIAAction extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ACTIONCOUNT
     */
    @TableField(value = "actioncount")
    @JSONField(name = "actioncount")
    @JsonProperty("actioncount")
    private Integer actioncount;
    /**
     * ORDERFLAG
     */
    @TableField(value = "orderflag")
    @JSONField(name = "orderflag")
    @JsonProperty("orderflag")
    private Integer orderflag;
    /**
     * FAHELPER
     */
    @TableField(value = "fahelper")
    @JSONField(name = "fahelper")
    @JsonProperty("fahelper")
    private String fahelper;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * NEXTTO
     */
    @TableField(value = "nextto")
    @JSONField(name = "nextto")
    @JsonProperty("nextto")
    private String nextto;
    /**
     * PAGEPATH
     */
    @TableField(value = "pagepath")
    @JSONField(name = "pagepath")
    @JsonProperty("pagepath")
    private String pagepath;
    /**
     * ACTIONNAME
     */
    @TableField(value = "actionname")
    @JSONField(name = "actionname")
    @JsonProperty("actionname")
    private String actionname;
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
     * 工作流交互操作标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfiaactionid",type=IdType.UUID)
    @JSONField(name = "wfiaactionid")
    @JsonProperty("wfiaactionid")
    private String wfiaactionid;
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
     * ACTIONLOGICNAME
     */
    @TableField(value = "actionlogicname")
    @JSONField(name = "actionlogicname")
    @JsonProperty("actionlogicname")
    private String actionlogicname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * NEXTCONDITION
     */
    @TableField(value = "nextcondition")
    @JSONField(name = "nextcondition")
    @JsonProperty("nextcondition")
    private String nextcondition;
    /**
     * 工作流交互操作名称
     */
    @DEField(defaultValue = "交互操作")
    @TableField(value = "wfiaactionname")
    @JSONField(name = "wfiaactionname")
    @JsonProperty("wfiaactionname")
    private String wfiaactionname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * PANELID
     */
    @TableField(value = "panelid")
    @JSONField(name = "panelid")
    @JsonProperty("panelid")
    private String panelid;
    /**
     * WFSTEPNAME
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * 互动操作_相关步骤
     */
    @TableField(value = "wfstepid")
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFStep wfstep;



    /**
     * 设置 [ACTIONCOUNT]
     */
    public void setActioncount(Integer actioncount){
        this.actioncount = actioncount ;
        this.modify("actioncount",actioncount);
    }
    /**
     * 设置 [ORDERFLAG]
     */
    public void setOrderflag(Integer orderflag){
        this.orderflag = orderflag ;
        this.modify("orderflag",orderflag);
    }
    /**
     * 设置 [FAHELPER]
     */
    public void setFahelper(String fahelper){
        this.fahelper = fahelper ;
        this.modify("fahelper",fahelper);
    }
    /**
     * 设置 [NEXTTO]
     */
    public void setNextto(String nextto){
        this.nextto = nextto ;
        this.modify("nextto",nextto);
    }
    /**
     * 设置 [PAGEPATH]
     */
    public void setPagepath(String pagepath){
        this.pagepath = pagepath ;
        this.modify("pagepath",pagepath);
    }
    /**
     * 设置 [ACTIONNAME]
     */
    public void setActionname(String actionname){
        this.actionname = actionname ;
        this.modify("actionname",actionname);
    }
    /**
     * 设置 [ACTIONLOGICNAME]
     */
    public void setActionlogicname(String actionlogicname){
        this.actionlogicname = actionlogicname ;
        this.modify("actionlogicname",actionlogicname);
    }
    /**
     * 设置 [NEXTCONDITION]
     */
    public void setNextcondition(String nextcondition){
        this.nextcondition = nextcondition ;
        this.modify("nextcondition",nextcondition);
    }
    /**
     * 设置 [工作流交互操作名称]
     */
    public void setWfiaactionname(String wfiaactionname){
        this.wfiaactionname = wfiaactionname ;
        this.modify("wfiaactionname",wfiaactionname);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [PANELID]
     */
    public void setPanelid(String panelid){
        this.panelid = panelid ;
        this.modify("panelid",panelid);
    }
    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [互动操作_相关步骤]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }

}


