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
 * 实体[工作流步骤操作者]
 */
@Data
@TableName(value = "T_WFSTEPACTOR",resultMap = "WFStepActorResultMap")
public class WFStepActor extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户类型
     */
    @TableField(value = "actortype")
    @JSONField(name = "actortype")
    @JsonProperty("actortype")
    private Integer actortype;
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
     * 工作流步骤操作者标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfstepactorid",type=IdType.UUID)
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;
    /**
     * 查看时间
     */
    @TableField(value = "firstreadtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "firstreadtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("firstreadtime")
    private Timestamp firstreadtime;
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
     * 是否已读
     */
    @TableField(value = "readflag")
    @JSONField(name = "readflag")
    @JsonProperty("readflag")
    private Integer readflag;
    /**
     * 工作流步骤操作者名称
     */
    @TableField(value = "wfstepactorname")
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否完成
     */
    @TableField(value = "isfinish")
    @JSONField(name = "isfinish")
    @JsonProperty("isfinish")
    private Integer isfinish;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 允许交互操作
     */
    @TableField(value = "iaactions")
    @JSONField(name = "iaactions")
    @JsonProperty("iaactions")
    private String iaactions;
    /**
     * 是否只读
     */
    @TableField(value = "isreadonly")
    @JSONField(name = "isreadonly")
    @JsonProperty("isreadonly")
    private Integer isreadonly;
    /**
     * 工作流用户
     */
    @TableField(value = "actorid")
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;
    /**
     * 角色用户
     */
    @TableField(value = "roleid")
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    private String roleid;
    /**
     * 督促次数
     */
    @TableField(value = "remindercount")
    @JSONField(name = "remindercount")
    @JsonProperty("remindercount")
    private Integer remindercount;
    /**
     * 完成时间
     */
    @TableField(value = "finishdate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "finishdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("finishdate")
    private Timestamp finishdate;
    /**
     * 流程步骤
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * 源流程用户
     */
    @TableField(value = "originalwfusername")
    @JSONField(name = "originalwfusername")
    @JsonProperty("originalwfusername")
    private String originalwfusername;
    /**
     * 流程实例
     */
    @TableField(value = "wfinstanceid")
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;
    /**
     * 源流程用户
     */
    @TableField(value = "originalwfuserid")
    @JSONField(name = "originalwfuserid")
    @JsonProperty("originalwfuserid")
    private String originalwfuserid;
    /**
     * 步骤角色_步骤
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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser originalwfuser;



    /**
     * 设置 [用户类型]
     */
    public void setActortype(Integer actortype){
        this.actortype = actortype ;
        this.modify("actortype",actortype);
    }
    /**
     * 设置 [查看时间]
     */
    public void setFirstreadtime(Timestamp firstreadtime){
        this.firstreadtime = firstreadtime ;
        this.modify("firstreadtime",firstreadtime);
    }
    /**
     * 设置 [是否已读]
     */
    public void setReadflag(Integer readflag){
        this.readflag = readflag ;
        this.modify("readflag",readflag);
    }
    /**
     * 设置 [工作流步骤操作者名称]
     */
    public void setWfstepactorname(String wfstepactorname){
        this.wfstepactorname = wfstepactorname ;
        this.modify("wfstepactorname",wfstepactorname);
    }
    /**
     * 设置 [是否完成]
     */
    public void setIsfinish(Integer isfinish){
        this.isfinish = isfinish ;
        this.modify("isfinish",isfinish);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [允许交互操作]
     */
    public void setIaactions(String iaactions){
        this.iaactions = iaactions ;
        this.modify("iaactions",iaactions);
    }
    /**
     * 设置 [是否只读]
     */
    public void setIsreadonly(Integer isreadonly){
        this.isreadonly = isreadonly ;
        this.modify("isreadonly",isreadonly);
    }
    /**
     * 设置 [工作流用户]
     */
    public void setActorid(String actorid){
        this.actorid = actorid ;
        this.modify("actorid",actorid);
    }
    /**
     * 设置 [角色用户]
     */
    public void setRoleid(String roleid){
        this.roleid = roleid ;
        this.modify("roleid",roleid);
    }
    /**
     * 设置 [督促次数]
     */
    public void setRemindercount(Integer remindercount){
        this.remindercount = remindercount ;
        this.modify("remindercount",remindercount);
    }
    /**
     * 设置 [完成时间]
     */
    public void setFinishdate(Timestamp finishdate){
        this.finishdate = finishdate ;
        this.modify("finishdate",finishdate);
    }
    /**
     * 设置 [流程步骤]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [源流程用户]
     */
    public void setOriginalwfusername(String originalwfusername){
        this.originalwfusername = originalwfusername ;
        this.modify("originalwfusername",originalwfusername);
    }
    /**
     * 设置 [流程实例]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }
    /**
     * 设置 [源流程用户]
     */
    public void setOriginalwfuserid(String originalwfuserid){
        this.originalwfuserid = originalwfuserid ;
        this.modify("originalwfuserid",originalwfuserid);
    }
    /**
     * 设置 [步骤角色_步骤]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }

    /**
     * 获取 [工作流步骤操作者标识]
     */
    public String getWfstepactorid(){
        if(ObjectUtils.isEmpty(wfstepactorid)){
            wfstepactorid=(String)getDefaultKey(true);
        }
        return wfstepactorid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getWfstepid()))&&(!ObjectUtils.isEmpty(this.getActorid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getWfstepid(),this.getActorid()).getBytes());
        return null;
    }
}


