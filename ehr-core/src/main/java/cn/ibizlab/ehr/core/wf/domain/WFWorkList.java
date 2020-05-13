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
 * 实体[工作流工作列表]
 */
@Data
@TableName(value = "T_SRFWFWORKLIST",resultMap = "WFWorkListResultMap")
public class WFWorkList extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户数据
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
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
     * 流程步骤标识
     */
    @TableField(value = "wfstepid")
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;
    /**
     * 流程工作列表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfworklistid",type=IdType.UUID)
    @JSONField(name = "wfworklistid")
    @JsonProperty("wfworklistid")
    private String wfworklistid;
    /**
     * 用户数据信息
     */
    @TableField(value = "userdatainfo")
    @JSONField(name = "userdatainfo")
    @JsonProperty("userdatainfo")
    private String userdatainfo;
    /**
     * 用户数据
     */
    @TableField(value = "userdata3")
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;
    /**
     * 工作流名称
     */
    @TableField(value = "wfworkflowname")
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;
    /**
     * 步骤语言资源
     */
    @TableField(value = "wfsteplanrestag")
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 工作通知
     */
    @DEField(defaultValue = "0")
    @TableField(value = "workinform")
    @JSONField(name = "workinform")
    @JsonProperty("workinform")
    private Integer workinform;
    /**
     * 流程工作列表名称
     */
    @TableField(value = "wfworklistname")
    @JSONField(name = "wfworklistname")
    @JsonProperty("wfworklistname")
    private String wfworklistname;
    /**
     * 流程步骤名称
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * 取消通知
     */
    @DEField(defaultValue = "0")
    @TableField(value = "cancelinform")
    @JSONField(name = "cancelinform")
    @JsonProperty("cancelinform")
    private Integer cancelinform;
    /**
     * 用户标识
     */
    @TableField(value = "wfactorid")
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;
    /**
     * 工作取消标志
     */
    @DEField(defaultValue = "0")
    @TableField(value = "cancelflag")
    @JSONField(name = "cancelflag")
    @JsonProperty("cancelflag")
    private Integer cancelflag;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 用户数据
     */
    @TableField(value = "userdata4")
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 工作流标识
     */
    @TableField(value = "wfworkflowid")
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;
    /**
     * 流程语言资源
     */
    @TableField(value = "wflanrestag")
    @JSONField(name = "wflanrestag")
    @JsonProperty("wflanrestag")
    private String wflanrestag;
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
    @TableField(value = "wfinstancename")
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 源流程用户
     */
    @TableField(value = "originalwfuserid")
    @JSONField(name = "originalwfuserid")
    @JsonProperty("originalwfuserid")
    private String originalwfuserid;
    /**
     * 流程实例
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
     * 源流程用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser originalwfuser;



    /**
     * 设置 [用户数据]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [流程步骤标识]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }
    /**
     * 设置 [用户数据信息]
     */
    public void setUserdatainfo(String userdatainfo){
        this.userdatainfo = userdatainfo ;
        this.modify("userdatainfo",userdatainfo);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata3(String userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }
    /**
     * 设置 [工作流名称]
     */
    public void setWfworkflowname(String wfworkflowname){
        this.wfworkflowname = wfworkflowname ;
        this.modify("wfworkflowname",wfworkflowname);
    }
    /**
     * 设置 [步骤语言资源]
     */
    public void setWfsteplanrestag(String wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [工作通知]
     */
    public void setWorkinform(Integer workinform){
        this.workinform = workinform ;
        this.modify("workinform",workinform);
    }
    /**
     * 设置 [流程工作列表名称]
     */
    public void setWfworklistname(String wfworklistname){
        this.wfworklistname = wfworklistname ;
        this.modify("wfworklistname",wfworklistname);
    }
    /**
     * 设置 [流程步骤名称]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [取消通知]
     */
    public void setCancelinform(Integer cancelinform){
        this.cancelinform = cancelinform ;
        this.modify("cancelinform",cancelinform);
    }
    /**
     * 设置 [用户标识]
     */
    public void setWfactorid(String wfactorid){
        this.wfactorid = wfactorid ;
        this.modify("wfactorid",wfactorid);
    }
    /**
     * 设置 [工作取消标志]
     */
    public void setCancelflag(Integer cancelflag){
        this.cancelflag = cancelflag ;
        this.modify("cancelflag",cancelflag);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata4(String userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }
    /**
     * 设置 [工作流标识]
     */
    public void setWfworkflowid(String wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }
    /**
     * 设置 [流程语言资源]
     */
    public void setWflanrestag(String wflanrestag){
        this.wflanrestag = wflanrestag ;
        this.modify("wflanrestag",wflanrestag);
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
    public void setWfinstancename(String wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }
    /**
     * 设置 [源流程用户]
     */
    public void setOriginalwfuserid(String originalwfuserid){
        this.originalwfuserid = originalwfuserid ;
        this.modify("originalwfuserid",originalwfuserid);
    }
    /**
     * 设置 [流程实例]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }
}






