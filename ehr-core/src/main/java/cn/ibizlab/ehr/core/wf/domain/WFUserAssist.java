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
 * 实体[工作流用户代办]
 */
@Data
@TableName(value = "T_WFUSERASSIST",resultMap = "WFUserAssistResultMap")
public class WFUserAssist extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 工作流用户代办名称
     */
    @TableField(value = "wfuserassistname")
    @JSONField(name = "wfuserassistname")
    @JsonProperty("wfuserassistname")
    private String wfuserassistname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 代办步骤
     */
    @TableField(value = "wfstep")
    @JSONField(name = "wfstep")
    @JsonProperty("wfstep")
    private String wfstep;
    /**
     * 工作流用户代办标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfuserassistid",type=IdType.UUID)
    @JSONField(name = "wfuserassistid")
    @JsonProperty("wfuserassistid")
    private String wfuserassistid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流用户
     */
    @TableField(exist = false)
    @JSONField(name = "wfmajorusername")
    @JsonProperty("wfmajorusername")
    private String wfmajorusername;
    /**
     * 工作流代办用户
     */
    @TableField(exist = false)
    @JSONField(name = "wfminorusername")
    @JsonProperty("wfminorusername")
    private String wfminorusername;
    /**
     * 工作流
     */
    @TableField(exist = false)
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;
    /**
     * 工作流代办用户
     */
    @TableField(value = "wfminoruserid")
    @JSONField(name = "wfminoruserid")
    @JsonProperty("wfminoruserid")
    private String wfminoruserid;
    /**
     * 工作流
     */
    @TableField(value = "wfworkflowid")
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;
    /**
     * 工作流用户
     */
    @TableField(value = "wfmajoruserid")
    @JSONField(name = "wfmajoruserid")
    @JsonProperty("wfmajoruserid")
    private String wfmajoruserid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfmajoruser;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfminoruser;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow;



    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [工作流用户代办名称]
     */
    public void setWfuserassistname(String wfuserassistname){
        this.wfuserassistname = wfuserassistname ;
        this.modify("wfuserassistname",wfuserassistname);
    }
    /**
     * 设置 [代办步骤]
     */
    public void setWfstep(String wfstep){
        this.wfstep = wfstep ;
        this.modify("wfstep",wfstep);
    }
    /**
     * 设置 [工作流代办用户]
     */
    public void setWfminoruserid(String wfminoruserid){
        this.wfminoruserid = wfminoruserid ;
        this.modify("wfminoruserid",wfminoruserid);
    }
    /**
     * 设置 [工作流]
     */
    public void setWfworkflowid(String wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }
    /**
     * 设置 [工作流用户]
     */
    public void setWfmajoruserid(String wfmajoruserid){
        this.wfmajoruserid = wfmajoruserid ;
        this.modify("wfmajoruserid",wfmajoruserid);
    }

}


