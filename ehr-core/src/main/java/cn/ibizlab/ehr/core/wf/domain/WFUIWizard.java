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
 * 实体[工作流操作界面]
 */
@Data
@TableName(value = "t_WFUIWIZARD",resultMap = "WFUIWizardResultMap")
public class WFUIWizard extends EntityMP implements Serializable {

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
     * 操作参数
     */
    @TableField(value = "actionparam")
    @JSONField(name = "actionparam")
    @JsonProperty("actionparam")
    private String actionparam;
    /**
     * 操作数据信息
     */
    @TableField(value = "datainfo")
    @JSONField(name = "datainfo")
    @JsonProperty("datainfo")
    private String datainfo;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 操作模式
     */
    @TableField(value = "actionmode")
    @JSONField(name = "actionmode")
    @JsonProperty("actionmode")
    private String actionmode;
    /**
     * 工作流操作界面名称
     */
    @DEField(defaultValue = "名称")
    @TableField(value = "wfuiwizardname")
    @JSONField(name = "wfuiwizardname")
    @JsonProperty("wfuiwizardname")
    private String wfuiwizardname;
    /**
     * 调整步骤值
     */
    @TableField(value = "wfstepvalue")
    @JSONField(name = "wfstepvalue")
    @JsonProperty("wfstepvalue")
    private String wfstepvalue;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流操作界面标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfuiwizardid",type=IdType.UUID)
    @JSONField(name = "wfuiwizardid")
    @JsonProperty("wfuiwizardid")
    private String wfuiwizardid;
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
     * 设置 [操作参数]
     */
    public void setActionparam(String actionparam){
        this.actionparam = actionparam ;
        this.modify("actionparam",actionparam);
    }
    /**
     * 设置 [操作数据信息]
     */
    public void setDatainfo(String datainfo){
        this.datainfo = datainfo ;
        this.modify("datainfo",datainfo);
    }
    /**
     * 设置 [操作模式]
     */
    public void setActionmode(String actionmode){
        this.actionmode = actionmode ;
        this.modify("actionmode",actionmode);
    }
    /**
     * 设置 [工作流操作界面名称]
     */
    public void setWfuiwizardname(String wfuiwizardname){
        this.wfuiwizardname = wfuiwizardname ;
        this.modify("wfuiwizardname",wfuiwizardname);
    }
    /**
     * 设置 [调整步骤值]
     */
    public void setWfstepvalue(String wfstepvalue){
        this.wfstepvalue = wfstepvalue ;
        this.modify("wfstepvalue",wfstepvalue);
    }

}


