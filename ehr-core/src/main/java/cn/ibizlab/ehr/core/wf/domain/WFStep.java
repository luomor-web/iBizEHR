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
 * 实体[工作流步骤]
 */
@Data
@TableName(value = "T_SRFWFSTEP",resultMap = "WFStepResultMap")
public class WFStep extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否完成
     */
    @TableField(value = "isfinish")
    @JSONField(name = "isfinish")
    @JsonProperty("isfinish")
    private Integer isfinish;
    /**
     * FROMWFSTEPID
     */
    @TableField(value = "fromwfstepid")
    @JSONField(name = "fromwfstepid")
    @JsonProperty("fromwfstepid")
    private String fromwfstepid;
    /**
     * 开始时间
     */
    @TableField(value = "starttime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 步骤语言资源
     */
    @TableField(value = "wfsteplanrestag")
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;
    /**
     * ISINTERACTIVE
     */
    @TableField(value = "isinteractive")
    @JSONField(name = "isinteractive")
    @JsonProperty("isinteractive")
    private Integer isinteractive;
    /**
     * 工作流版本
     */
    @TableField(value = "wfversion")
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;
    /**
     * 结束时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;
    /**
     * 步骤名称
     */
    @TableField(value = "wfplogicname")
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;
    /**
     * 步骤限时
     */
    @TableField(value = "deadline")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "deadline" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("deadline")
    private Timestamp deadline;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * WFPNAME
     */
    @TableField(value = "wfpname")
    @JSONField(name = "wfpname")
    @JsonProperty("wfpname")
    private String wfpname;
    /**
     * LASTACTORID
     */
    @TableField(value = "lastactorid")
    @JSONField(name = "lastactorid")
    @JsonProperty("lastactorid")
    private String lastactorid;
    /**
     * 工作流步骤名称
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * WFPMODEL
     */
    @TableField(value = "wfpmodel")
    @JSONField(name = "wfpmodel")
    @JsonProperty("wfpmodel")
    private String wfpmodel;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 工作流步骤标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfstepid",type=IdType.UUID)
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;
    /**
     * 步骤次序
     */
    @TableField(value = "tracestep")
    @JSONField(name = "tracestep")
    @JsonProperty("tracestep")
    private Integer tracestep;
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
     * 流程实例
     */
    @TableField(exist = false)
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 处理步骤相关实例
     */
    @TableField(value = "wfinstanceid")
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance;



    /**
     * 设置 [是否完成]
     */
    public void setIsfinish(Integer isfinish){
        this.isfinish = isfinish ;
        this.modify("isfinish",isfinish);
    }
    /**
     * 设置 [FROMWFSTEPID]
     */
    public void setFromwfstepid(String fromwfstepid){
        this.fromwfstepid = fromwfstepid ;
        this.modify("fromwfstepid",fromwfstepid);
    }
    /**
     * 设置 [开始时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }
    /**
     * 设置 [步骤语言资源]
     */
    public void setWfsteplanrestag(String wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }
    /**
     * 设置 [ISINTERACTIVE]
     */
    public void setIsinteractive(Integer isinteractive){
        this.isinteractive = isinteractive ;
        this.modify("isinteractive",isinteractive);
    }
    /**
     * 设置 [工作流版本]
     */
    public void setWfversion(Integer wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }
    /**
     * 设置 [结束时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }
    /**
     * 设置 [步骤名称]
     */
    public void setWfplogicname(String wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }
    /**
     * 设置 [步骤限时]
     */
    public void setDeadline(Timestamp deadline){
        this.deadline = deadline ;
        this.modify("deadline",deadline);
    }
    /**
     * 设置 [WFPNAME]
     */
    public void setWfpname(String wfpname){
        this.wfpname = wfpname ;
        this.modify("wfpname",wfpname);
    }
    /**
     * 设置 [LASTACTORID]
     */
    public void setLastactorid(String lastactorid){
        this.lastactorid = lastactorid ;
        this.modify("lastactorid",lastactorid);
    }
    /**
     * 设置 [工作流步骤名称]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [WFPMODEL]
     */
    public void setWfpmodel(String wfpmodel){
        this.wfpmodel = wfpmodel ;
        this.modify("wfpmodel",wfpmodel);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [步骤次序]
     */
    public void setTracestep(Integer tracestep){
        this.tracestep = tracestep ;
        this.modify("tracestep",tracestep);
    }
    /**
     * 设置 [处理步骤相关实例]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }

}


