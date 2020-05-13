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
 * 实体[工作流配置版本]
 */
@Data
@TableName(value = "T_SRFWFWFVERSION",resultMap = "WFVersionResultMap")
public class WFVersion extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 版本
     */
    @TableField(value = "wfversion")
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;
    /**
     * 工作流配置版本名称
     */
    @DEField(name = "wfwfversionname")
    @TableField(value = "wfwfversionname")
    @JSONField(name = "wfversionname")
    @JsonProperty("wfversionname")
    private String wfversionname;
    /**
     * 流程版本语言资源
     */
    @TableField(value = "wfverlanrestag")
    @JSONField(name = "wfverlanrestag")
    @JsonProperty("wfverlanrestag")
    private String wfverlanrestag;
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
     * 工作流配置版本标识
     */
    @DEField(name = "wfwfversionid" , isKeyField=true)
    @TableId(value= "wfwfversionid",type=IdType.UUID)
    @JSONField(name = "wfversionid")
    @JsonProperty("wfversionid")
    private String wfversionid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 配置
     */
    @TableField(value = "wfmodel")
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;
    /**
     * 工作流配置
     */
    @TableField(exist = false)
    @JSONField(name = "wfwfname")
    @JsonProperty("wfwfname")
    private String wfwfname;
    /**
     * 工作流配置
     */
    @TableField(value = "wfwfid")
    @JSONField(name = "wfwfid")
    @JsonProperty("wfwfid")
    private String wfwfid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow;



    /**
     * 设置 [版本]
     */
    public void setWfversion(Integer wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }
    /**
     * 设置 [工作流配置版本名称]
     */
    public void setWfversionname(String wfversionname){
        this.wfversionname = wfversionname ;
        this.modify("wfwfversionname",wfversionname);
    }
    /**
     * 设置 [流程版本语言资源]
     */
    public void setWfverlanrestag(String wfverlanrestag){
        this.wfverlanrestag = wfverlanrestag ;
        this.modify("wfverlanrestag",wfverlanrestag);
    }
    /**
     * 设置 [配置]
     */
    public void setWfmodel(String wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }
    /**
     * 设置 [工作流配置]
     */
    public void setWfwfid(String wfwfid){
        this.wfwfid = wfwfid ;
        this.modify("wfwfid",wfwfid);
    }
}






