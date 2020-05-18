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
 * 实体[工作流步骤数据]
 */
@Data
@TableName(value = "T_SRFWFSTEPDATA",resultMap = "WFStepDataResultMap")
public class WFStepData extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作流步骤数据标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfstepdataid",type=IdType.UUID)
    @JSONField(name = "wfstepdataid")
    @JsonProperty("wfstepdataid")
    private String wfstepdataid;
    /**
     * 代办人
     */
    @TableField(value = "sdparam2")
    @JSONField(name = "sdparam2")
    @JsonProperty("sdparam2")
    private String sdparam2;
    /**
     * 代办人名称
     */
    @TableField(value = "actorname2")
    @JSONField(name = "actorname2")
    @JsonProperty("actorname2")
    private String actorname2;
    /**
     * SDPARAM
     */
    @TableField(value = "sdparam")
    @JSONField(name = "sdparam")
    @JsonProperty("sdparam")
    private String sdparam;
    /**
     * 步骤语言资源
     */
    @TableField(value = "wfsteplanrestag")
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;
    /**
     * 操作人名称
     */
    @TableField(value = "actorname")
    @JSONField(name = "actorname")
    @JsonProperty("actorname")
    private String actorname;
    /**
     * 操作时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "actiontime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("actiontime")
    private Timestamp actiontime;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 下一步
     */
    @TableField(value = "nextto")
    @JSONField(name = "nextto")
    @JsonProperty("nextto")
    private String nextto;
    /**
     * 操作人
     */
    @TableField(value = "actorid")
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;
    /**
     * 内容
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 操作类型语言资源
     */
    @TableField(value = "wfactionlanrestag")
    @JSONField(name = "wfactionlanrestag")
    @JsonProperty("wfactionlanrestag")
    private String wfactionlanrestag;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 流程操作
     */
    @TableField(value = "wfstepdataname")
    @JSONField(name = "wfstepdataname")
    @JsonProperty("wfstepdataname")
    private String wfstepdataname;
    /**
     * 连接名称
     */
    @TableField(value = "connectionname")
    @JSONField(name = "connectionname")
    @JsonProperty("connectionname")
    private String connectionname;
    /**
     * 源流程用户
     */
    @TableField(value = "originalwfusername")
    @JSONField(name = "originalwfusername")
    @JsonProperty("originalwfusername")
    private String originalwfusername;
    /**
     * 步骤名称
     */
    @TableField(value = "wfstepname")
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;
    /**
     * 执行步骤
     */
    @TableField(value = "wfplogicname")
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;
    /**
     * 流程实例
     */
    @TableField(value = "wfinstancename")
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 用户数据
     */
    @TableField(value = "userdatadesc")
    @JSONField(name = "userdatadesc")
    @JsonProperty("userdatadesc")
    private String userdatadesc;
    /**
     * 用户数据标识
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 源流程用户
     */
    @TableField(value = "originalwfuserid")
    @JSONField(name = "originalwfuserid")
    @JsonProperty("originalwfuserid")
    private String originalwfuserid;
    /**
     * 步骤数据_相关步骤
     */
    @TableField(value = "wfstepid")
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;
    /**
     * WFInstanceId
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
     * 设置 [代办人]
     */
    public void setSdparam2(String sdparam2){
        this.sdparam2 = sdparam2 ;
        this.modify("sdparam2",sdparam2);
    }
    /**
     * 设置 [代办人名称]
     */
    public void setActorname2(String actorname2){
        this.actorname2 = actorname2 ;
        this.modify("actorname2",actorname2);
    }
    /**
     * 设置 [SDPARAM]
     */
    public void setSdparam(String sdparam){
        this.sdparam = sdparam ;
        this.modify("sdparam",sdparam);
    }
    /**
     * 设置 [步骤语言资源]
     */
    public void setWfsteplanrestag(String wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }
    /**
     * 设置 [操作人名称]
     */
    public void setActorname(String actorname){
        this.actorname = actorname ;
        this.modify("actorname",actorname);
    }
    /**
     * 设置 [下一步]
     */
    public void setNextto(String nextto){
        this.nextto = nextto ;
        this.modify("nextto",nextto);
    }
    /**
     * 设置 [操作人]
     */
    public void setActorid(String actorid){
        this.actorid = actorid ;
        this.modify("actorid",actorid);
    }
    /**
     * 设置 [内容]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [操作类型语言资源]
     */
    public void setWfactionlanrestag(String wfactionlanrestag){
        this.wfactionlanrestag = wfactionlanrestag ;
        this.modify("wfactionlanrestag",wfactionlanrestag);
    }
    /**
     * 设置 [流程操作]
     */
    public void setWfstepdataname(String wfstepdataname){
        this.wfstepdataname = wfstepdataname ;
        this.modify("wfstepdataname",wfstepdataname);
    }
    /**
     * 设置 [连接名称]
     */
    public void setConnectionname(String connectionname){
        this.connectionname = connectionname ;
        this.modify("connectionname",connectionname);
    }
    /**
     * 设置 [源流程用户]
     */
    public void setOriginalwfusername(String originalwfusername){
        this.originalwfusername = originalwfusername ;
        this.modify("originalwfusername",originalwfusername);
    }
    /**
     * 设置 [步骤名称]
     */
    public void setWfstepname(String wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }
    /**
     * 设置 [执行步骤]
     */
    public void setWfplogicname(String wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }
    /**
     * 设置 [流程实例]
     */
    public void setWfinstancename(String wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdatadesc(String userdatadesc){
        this.userdatadesc = userdatadesc ;
        this.modify("userdatadesc",userdatadesc);
    }
    /**
     * 设置 [用户数据标识]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [源流程用户]
     */
    public void setOriginalwfuserid(String originalwfuserid){
        this.originalwfuserid = originalwfuserid ;
        this.modify("originalwfuserid",originalwfuserid);
    }
    /**
     * 设置 [步骤数据_相关步骤]
     */
    public void setWfstepid(String wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }
    /**
     * 设置 [WFInstanceId]
     */
    public void setWfinstanceid(String wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }

}


