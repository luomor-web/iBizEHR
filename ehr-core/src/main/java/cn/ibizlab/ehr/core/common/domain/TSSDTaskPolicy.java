package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[调度任务项策略]
 */
@Data
@TableName(value = "T_SRFTSSDTASKPOLICY",resultMap = "TSSDTaskPolicyResultMap")
public class TSSDTaskPolicy extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 调度任务项策略标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tssdtaskpolicyid",type=IdType.UUID)
    @JSONField(name = "tssdtaskpolicyid")
    @JsonProperty("tssdtaskpolicyid")
    private String tssdtaskpolicyid;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
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
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 调度任务项策略名称
     */
    @TableField(value = "tssdtaskpolicyname")
    @JSONField(name = "tssdtaskpolicyname")
    @JsonProperty("tssdtaskpolicyname")
    private String tssdtaskpolicyname;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 任务运行策略
     */
    @TableField(exist = false)
    @JSONField(name = "tssdpolicyname")
    @JsonProperty("tssdpolicyname")
    private String tssdpolicyname;
    /**
     * 调度任务
     */
    @TableField(exist = false)
    @JSONField(name = "tssdtaskname")
    @JsonProperty("tssdtaskname")
    private String tssdtaskname;
    /**
     * 调度任务
     */
    @TableField(value = "tssdtaskid")
    @JSONField(name = "tssdtaskid")
    @JsonProperty("tssdtaskid")
    private String tssdtaskid;
    /**
     * 任务运行策略
     */
    @TableField(value = "tssdpolicyid")
    @JSONField(name = "tssdpolicyid")
    @JsonProperty("tssdpolicyid")
    private String tssdpolicyid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDPolicy tssdpolicy;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDTask tssdtask;



    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [调度任务项策略名称]
     */
    public void setTssdtaskpolicyname(String tssdtaskpolicyname){
        this.tssdtaskpolicyname = tssdtaskpolicyname ;
        this.modify("tssdtaskpolicyname",tssdtaskpolicyname);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [调度任务]
     */
    public void setTssdtaskid(String tssdtaskid){
        this.tssdtaskid = tssdtaskid ;
        this.modify("tssdtaskid",tssdtaskid);
    }
    /**
     * 设置 [任务运行策略]
     */
    public void setTssdpolicyid(String tssdpolicyid){
        this.tssdpolicyid = tssdpolicyid ;
        this.modify("tssdpolicyid",tssdpolicyid);
    }

}


