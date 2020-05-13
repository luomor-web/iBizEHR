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
 * 实体[工作流步骤子实例]
 */
@Data
@TableName(value = "T_SRFWFSTEPINST",resultMap = "WFStepInstResultMap")
public class WFStepInst extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 流程返回值
     */
    @TableField(value = "returndata")
    @JSONField(name = "returndata")
    @JsonProperty("returndata")
    private String returndata;
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
     * 工作流步骤子实例名称
     */
    @DEField(defaultValue = "工作流步骤子实例")
    @TableField(value = "wfstepinstname")
    @JSONField(name = "wfstepinstname")
    @JsonProperty("wfstepinstname")
    private String wfstepinstname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流步骤子实例标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfstepinstid",type=IdType.UUID)
    @JSONField(name = "wfstepinstid")
    @JsonProperty("wfstepinstid")
    private String wfstepinstid;
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
     * 步骤语言资源
     */
    @TableField(value = "wfsteplanrestag")
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;
    /**
     * 实例关闭标志
     */
    @TableField(value = "closeflag")
    @JSONField(name = "closeflag")
    @JsonProperty("closeflag")
    private Integer closeflag;
    /**
     * 工作流步骤
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * 子流程实例
     */
    @TableField(value = "wfinstancename")
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 子流程实例
     */
    @TableField(value = "wfinstanceid")
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;
    /**
     * 工作流步骤
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
    private cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFStep wfstep;



    /**
     * 设置 [流程返回值]
     */
    public void setReturndata(String returndata){
        this.returndata = returndata ;
        this.modify("returndata",returndata);
    }
    /**
     * 设置 [工作流步骤子实例名称]
     */
    public void setWfstepinstname(String wfstepinstname){
        this.wfstepinstname = wfstepinstname ;
        this.modify("wfstepinstname",wfstepinstname);
    }
    /**
     * 设置 [步骤语言资源]
     */
    public void setWfsteplanrestag(String wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }
    /**
     * 设置 [实例关闭标志]
     */
    public void setCloseflag(Integer closeflag){
        this.closeflag = closeflag ;
        this.modify("closeflag",closeflag);
    }
    /**
     * 设置 [工作流步骤]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [子流程实例]
     */
    public void setWfinstancename(String wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }
    /**
     * 设置 [子流程实例]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }
    /**
     * 设置 [工作流步骤]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }
}






