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
 * 实体[工作流实例]
 */
@Data
@TableName(value = "T_SRFWFINSTANCE",resultMap = "WFInstanceResultMap")
public class WFInstance extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户数据信息
     */
    @TableField(value = "userdatainfo")
    @JSONField(name = "userdatainfo")
    @JsonProperty("userdatainfo")
    private String userdatainfo;
    /**
     * 是否关闭
     */
    @TableField(value = "isclose")
    @JSONField(name = "isclose")
    @JsonProperty("isclose")
    private Integer isclose;
    /**
     * 取消原因
     */
    @TableField(value = "cancelreason")
    @JSONField(name = "cancelreason")
    @JsonProperty("cancelreason")
    private String cancelreason;
    /**
     * 是否取消
     */
    @TableField(value = "iscancel")
    @JSONField(name = "iscancel")
    @JsonProperty("iscancel")
    private Integer iscancel;
    /**
     * 开始时间
     */
    @TableField(value = "starttime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 用户数据4
     */
    @TableField(value = "userdata4")
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * 工作流版本
     */
    @TableField(value = "wfversion")
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;
    /**
     * 用户数据3
     */
    @TableField(value = "userdata3")
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;
    /**
     * ACTIVESTEPID
     */
    @TableField(value = "activestepid")
    @JSONField(name = "activestepid")
    @JsonProperty("activestepid")
    private String activestepid;
    /**
     * 自定义数据
     */
    @TableField(value = "usertag2")
    @JSONField(name = "usertag2")
    @JsonProperty("usertag2")
    private String usertag2;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * OWNER
     */
    @TableField(value = "owner")
    @JSONField(name = "owner")
    @JsonProperty("owner")
    private String owner;
    /**
     * 工作流实例标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfinstanceid",type=IdType.UUID)
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;
    /**
     * 自定义数据
     */
    @TableField(value = "usertag")
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    private String usertag;
    /**
     * 工作流实例名称
     */
    @TableField(value = "wfinstancename")
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;
    /**
     * 错误信息
     */
    @TableField(value = "errorinfo")
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;
    /**
     * 跟踪步骤
     */
    @DEField(defaultValue = "0")
    @TableField(value = "tracestep")
    @JSONField(name = "tracestep")
    @JsonProperty("tracestep")
    private Integer tracestep;
    /**
     * 流程挂起
     */
    @DEField(defaultValue = "0")
    @TableField(value = "suspendflag")
    @JSONField(name = "suspendflag")
    @JsonProperty("suspendflag")
    private Integer suspendflag;
    /**
     * 并行实例
     */
    @TableField(value = "parallelinst")
    @JSONField(name = "parallelinst")
    @JsonProperty("parallelinst")
    private Integer parallelinst;
    /**
     * 重要程度
     */
    @TableField(value = "importanceflag")
    @JSONField(name = "importanceflag")
    @JsonProperty("importanceflag")
    private Integer importanceflag;
    /**
     * 上一个操作步骤
     */
    @TableField(value = "lastwfstepid")
    @JSONField(name = "lastwfstepid")
    @JsonProperty("lastwfstepid")
    private String lastwfstepid;
    /**
     * 结果信息
     */
    @TableField(value = "result")
    @JSONField(name = "result")
    @JsonProperty("result")
    private String result;
    /**
     * 结束时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;
    /**
     * 是否完成
     */
    @TableField(value = "isfinish")
    @JSONField(name = "isfinish")
    @JsonProperty("isfinish")
    private Integer isfinish;
    /**
     * 工作流说明
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 上一个操作
     */
    @TableField(value = "lastaction")
    @JSONField(name = "lastaction")
    @JsonProperty("lastaction")
    private String lastaction;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 流程配置
     */
    @TableField(value = "wfmodel")
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;
    /**
     * 当前步骤名称
     */
    @TableField(value = "activestepname")
    @JSONField(name = "activestepname")
    @JsonProperty("activestepname")
    private String activestepname;
    /**
     * 上一个操作者
     */
    @TableField(value = "lastactorid")
    @JSONField(name = "lastactorid")
    @JsonProperty("lastactorid")
    private String lastactorid;
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
     * 是否错误
     */
    @TableField(value = "iserror")
    @JSONField(name = "iserror")
    @JsonProperty("iserror")
    private Integer iserror;
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
     * 父步骤编号
     */
    @TableField(value = "pstepid")
    @JSONField(name = "pstepid")
    @JsonProperty("pstepid")
    private String pstepid;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 父实例
     */
    @TableField(exist = false)
    @JSONField(name = "pwfinstancename")
    @JsonProperty("pwfinstancename")
    private String pwfinstancename;
    /**
     * 组织名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 工作流名称
     */
    @TableField(exist = false)
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;
    /**
     * 工作流名称
     */
    @TableField(value = "wfworkflowid")
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;
    /**
     * 组织标识
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 父实例
     */
    @TableField(value = "pwfinstanceid")
    @JSONField(name = "pwfinstanceid")
    @JsonProperty("pwfinstanceid")
    private String pwfinstanceid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.Org org;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFInstance pwfinstance;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow;



    /**
     * 设置 [用户数据信息]
     */
    public void setUserdatainfo(String userdatainfo){
        this.userdatainfo = userdatainfo ;
        this.modify("userdatainfo",userdatainfo);
    }
    /**
     * 设置 [是否关闭]
     */
    public void setIsclose(Integer isclose){
        this.isclose = isclose ;
        this.modify("isclose",isclose);
    }
    /**
     * 设置 [取消原因]
     */
    public void setCancelreason(String cancelreason){
        this.cancelreason = cancelreason ;
        this.modify("cancelreason",cancelreason);
    }
    /**
     * 设置 [是否取消]
     */
    public void setIscancel(Integer iscancel){
        this.iscancel = iscancel ;
        this.modify("iscancel",iscancel);
    }
    /**
     * 设置 [开始时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [用户数据4]
     */
    public void setUserdata4(String userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }
    /**
     * 设置 [工作流版本]
     */
    public void setWfversion(Integer wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }
    /**
     * 设置 [用户数据3]
     */
    public void setUserdata3(String userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }
    /**
     * 设置 [ACTIVESTEPID]
     */
    public void setActivestepid(String activestepid){
        this.activestepid = activestepid ;
        this.modify("activestepid",activestepid);
    }
    /**
     * 设置 [自定义数据]
     */
    public void setUsertag2(String usertag2){
        this.usertag2 = usertag2 ;
        this.modify("usertag2",usertag2);
    }
    /**
     * 设置 [OWNER]
     */
    public void setOwner(String owner){
        this.owner = owner ;
        this.modify("owner",owner);
    }
    /**
     * 设置 [自定义数据]
     */
    public void setUsertag(String usertag){
        this.usertag = usertag ;
        this.modify("usertag",usertag);
    }
    /**
     * 设置 [工作流实例名称]
     */
    public void setWfinstancename(String wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }
    /**
     * 设置 [错误信息]
     */
    public void setErrorinfo(String errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }
    /**
     * 设置 [跟踪步骤]
     */
    public void setTracestep(Integer tracestep){
        this.tracestep = tracestep ;
        this.modify("tracestep",tracestep);
    }
    /**
     * 设置 [流程挂起]
     */
    public void setSuspendflag(Integer suspendflag){
        this.suspendflag = suspendflag ;
        this.modify("suspendflag",suspendflag);
    }
    /**
     * 设置 [并行实例]
     */
    public void setParallelinst(Integer parallelinst){
        this.parallelinst = parallelinst ;
        this.modify("parallelinst",parallelinst);
    }
    /**
     * 设置 [重要程度]
     */
    public void setImportanceflag(Integer importanceflag){
        this.importanceflag = importanceflag ;
        this.modify("importanceflag",importanceflag);
    }
    /**
     * 设置 [上一个操作步骤]
     */
    public void setLastwfstepid(String lastwfstepid){
        this.lastwfstepid = lastwfstepid ;
        this.modify("lastwfstepid",lastwfstepid);
    }
    /**
     * 设置 [结果信息]
     */
    public void setResult(String result){
        this.result = result ;
        this.modify("result",result);
    }
    /**
     * 设置 [结束时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }
    /**
     * 设置 [是否完成]
     */
    public void setIsfinish(Integer isfinish){
        this.isfinish = isfinish ;
        this.modify("isfinish",isfinish);
    }
    /**
     * 设置 [工作流说明]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [上一个操作]
     */
    public void setLastaction(String lastaction){
        this.lastaction = lastaction ;
        this.modify("lastaction",lastaction);
    }
    /**
     * 设置 [流程配置]
     */
    public void setWfmodel(String wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }
    /**
     * 设置 [当前步骤名称]
     */
    public void setActivestepname(String activestepname){
        this.activestepname = activestepname ;
        this.modify("activestepname",activestepname);
    }
    /**
     * 设置 [上一个操作者]
     */
    public void setLastactorid(String lastactorid){
        this.lastactorid = lastactorid ;
        this.modify("lastactorid",lastactorid);
    }
    /**
     * 设置 [是否错误]
     */
    public void setIserror(Integer iserror){
        this.iserror = iserror ;
        this.modify("iserror",iserror);
    }
    /**
     * 设置 [父步骤编号]
     */
    public void setPstepid(String pstepid){
        this.pstepid = pstepid ;
        this.modify("pstepid",pstepid);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [工作流名称]
     */
    public void setWfworkflowid(String wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }
    /**
     * 设置 [父实例]
     */
    public void setPwfinstanceid(String pwfinstanceid){
        this.pwfinstanceid = pwfinstanceid ;
        this.modify("pwfinstanceid",pwfinstanceid);
    }

}


