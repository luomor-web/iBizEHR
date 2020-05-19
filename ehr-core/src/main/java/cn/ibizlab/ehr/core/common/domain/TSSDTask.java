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
 * 实体[任务调度任务项]
 */
@Data
@TableName(value = "T_SRFTSSDTASK",resultMap = "TSSDTaskResultMap")
public class TSSDTask extends EntityMP implements Serializable {

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
     * 用户数据3
     */
    @TableField(value = "userdata3")
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;
    /**
     * 任务参数
     */
    @TableField(value = "taskparam")
    @JSONField(name = "taskparam")
    @JsonProperty("taskparam")
    private String taskparam;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 用户数据4
     */
    @TableField(value = "userdata4")
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * 启用标志
     */
    @TableField(value = "enableflag")
    @JSONField(name = "enableflag")
    @JsonProperty("enableflag")
    private Integer enableflag;
    /**
     * 任务调度任务项标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tssdtaskid",type=IdType.UUID)
    @JSONField(name = "tssdtaskid")
    @JsonProperty("tssdtaskid")
    private String tssdtaskid;
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
     * 版本
     */
    @TableField(value = "version")
    @JSONField(name = "version")
    @JsonProperty("version")
    private Integer version;
    /**
     * 调度任务项名称
     */
    @TableField(value = "tssdtaskname")
    @JSONField(name = "tssdtaskname")
    @JsonProperty("tssdtaskname")
    private String tssdtaskname;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 任务调度引擎
     */
    @TableField(exist = false)
    @JSONField(name = "tssdenginename")
    @JsonProperty("tssdenginename")
    private String tssdenginename;
    /**
     * 任务调度引擎
     */
    @TableField(value = "tssdengineid")
    @JSONField(name = "tssdengineid")
    @JsonProperty("tssdengineid")
    private String tssdengineid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDEngine tssdengine;



    /**
     * 设置 [用户数据3]
     */
    public void setUserdata3(String userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }
    /**
     * 设置 [任务参数]
     */
    public void setTaskparam(String taskparam){
        this.taskparam = taskparam ;
        this.modify("taskparam",taskparam);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [用户数据4]
     */
    public void setUserdata4(String userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }
    /**
     * 设置 [启用标志]
     */
    public void setEnableflag(Integer enableflag){
        this.enableflag = enableflag ;
        this.modify("enableflag",enableflag);
    }
    /**
     * 设置 [版本]
     */
    public void setVersion(Integer version){
        this.version = version ;
        this.modify("version",version);
    }
    /**
     * 设置 [调度任务项名称]
     */
    public void setTssdtaskname(String tssdtaskname){
        this.tssdtaskname = tssdtaskname ;
        this.modify("tssdtaskname",tssdtaskname);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [任务调度引擎]
     */
    public void setTssdengineid(String tssdengineid){
        this.tssdengineid = tssdengineid ;
        this.modify("tssdengineid",tssdengineid);
    }

}


