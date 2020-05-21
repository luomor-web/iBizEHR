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
 * 实体[工作流候选用户策略]
 */
@Data
@TableName(value = "T_WFUCPOLICY",resultMap = "WFUCPolicyResultMap")
public class WFUCPolicy extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作流候选用户策略标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfucpolicyid",type=IdType.UUID)
    @JSONField(name = "wfucpolicyid")
    @JsonProperty("wfucpolicyid")
    private String wfucpolicyid;
    /**
     * 开始时间
     */
    @TableField(value = "begintime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "begintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("begintime")
    private Timestamp begintime;
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
     * 策略状态
     */
    @TableField(value = "policystate")
    @JSONField(name = "policystate")
    @JsonProperty("policystate")
    private Integer policystate;
    /**
     * 结束时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;
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
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 是否启用
     */
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流候选用户策略名称
     */
    @TableField(value = "wfucpolicyname")
    @JSONField(name = "wfucpolicyname")
    @JsonProperty("wfucpolicyname")
    private String wfucpolicyname;
    /**
     * 候选用户
     */
    @TableField(exist = false)
    @JSONField(name = "minorwfusername")
    @JsonProperty("minorwfusername")
    private String minorwfusername;
    /**
     * 工作流用户
     */
    @TableField(exist = false)
    @JSONField(name = "majorwfusername")
    @JsonProperty("majorwfusername")
    private String majorwfusername;
    /**
     * 候选用户
     */
    @TableField(value = "minorwfuserid")
    @JSONField(name = "minorwfuserid")
    @JsonProperty("minorwfuserid")
    private String minorwfuserid;
    /**
     * 工作流用户
     */
    @TableField(value = "majorwfuserid")
    @JSONField(name = "majorwfuserid")
    @JsonProperty("majorwfuserid")
    private String majorwfuserid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser majorwfuser;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser minorwfuser;



    /**
     * 设置 [开始时间]
     */
    public void setBegintime(Timestamp begintime){
        this.begintime = begintime ;
        this.modify("begintime",begintime);
    }
    /**
     * 设置 [策略状态]
     */
    public void setPolicystate(Integer policystate){
        this.policystate = policystate ;
        this.modify("policystate",policystate);
    }
    /**
     * 设置 [结束时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [是否启用]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [工作流候选用户策略名称]
     */
    public void setWfucpolicyname(String wfucpolicyname){
        this.wfucpolicyname = wfucpolicyname ;
        this.modify("wfucpolicyname",wfucpolicyname);
    }
    /**
     * 设置 [候选用户]
     */
    public void setMinorwfuserid(String minorwfuserid){
        this.minorwfuserid = minorwfuserid ;
        this.modify("minorwfuserid",minorwfuserid);
    }
    /**
     * 设置 [工作流用户]
     */
    public void setMajorwfuserid(String majorwfuserid){
        this.majorwfuserid = majorwfuserid ;
        this.modify("majorwfuserid",majorwfuserid);
    }

}


