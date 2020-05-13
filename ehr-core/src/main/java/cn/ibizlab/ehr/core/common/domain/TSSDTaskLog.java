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
 * 实体[任务调度日志]
 */
@Data
@TableName(value = "T_SRFTSSDTASKLOG",resultMap = "TSSDTaskLogResultMap")
public class TSSDTaskLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    @TableField(value = "retinfo")
    @JSONField(name = "retinfo")
    @JsonProperty("retinfo")
    private String retinfo;
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
     * 开始时间
     */
    @TableField(value = "starttime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;
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
     * 任务调度日志名称
     */
    @TableField(value = "tssdtasklogname")
    @JSONField(name = "tssdtasklogname")
    @JsonProperty("tssdtasklogname")
    private String tssdtasklogname;
    /**
     * 返回代码
     */
    @TableField(value = "retcode")
    @JSONField(name = "retcode")
    @JsonProperty("retcode")
    private Integer retcode;
    /**
     * 结束时间
     */
    @TableField(value = "endtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;
    /**
     * 持续时间
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;
    /**
     * 任务调度日志标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tssdtasklogid",type=IdType.UUID)
    @JSONField(name = "tssdtasklogid")
    @JsonProperty("tssdtasklogid")
    private String tssdtasklogid;
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
     * 调度任务
     */
    @TableField(value = "tssdtaskname")
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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDTask tssdtask;



    /**
     * 设置 [返回信息]
     */
    public void setRetinfo(String retinfo){
        this.retinfo = retinfo ;
        this.modify("retinfo",retinfo);
    }
    /**
     * 设置 [开始时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }
    /**
     * 设置 [任务调度日志名称]
     */
    public void setTssdtasklogname(String tssdtasklogname){
        this.tssdtasklogname = tssdtasklogname ;
        this.modify("tssdtasklogname",tssdtasklogname);
    }
    /**
     * 设置 [返回代码]
     */
    public void setRetcode(Integer retcode){
        this.retcode = retcode ;
        this.modify("retcode",retcode);
    }
    /**
     * 设置 [结束时间]
     */
    public void setEndtime(Timestamp endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }
    /**
     * 设置 [持续时间]
     */
    public void setDuration(Integer duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }
    /**
     * 设置 [调度任务]
     */
    public void setTssdtaskname(String tssdtaskname){
        this.tssdtaskname = tssdtaskname ;
        this.modify("tssdtaskname",tssdtaskname);
    }
    /**
     * 设置 [调度任务]
     */
    public void setTssdtaskid(String tssdtaskid){
        this.tssdtaskid = tssdtaskid ;
        this.modify("tssdtaskid",tssdtaskid);
    }
}






