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
 * 实体[任务时刻策略项]
 */
@Data
@TableName(value = "T_TSSDITEM",resultMap = "TSSDItemResultMap")
public class TSSDItem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小时
     */
    @TableField(value = "hourtype")
    @JSONField(name = "hourtype")
    @JsonProperty("hourtype")
    private String hourtype;
    /**
     * 月周
     */
    @TableField(value = "monthweektype")
    @JSONField(name = "monthweektype")
    @JsonProperty("monthweektype")
    private String monthweektype;
    /**
     * 指定秒钟
     */
    @TableField(value = "secondvalue")
    @JSONField(name = "secondvalue")
    @JsonProperty("secondvalue")
    private String secondvalue;
    /**
     * 分钟
     */
    @TableField(value = "minutetype")
    @JSONField(name = "minutetype")
    @JsonProperty("minutetype")
    private String minutetype;
    /**
     * 秒钟
     */
    @TableField(value = "secondtype")
    @JSONField(name = "secondtype")
    @JsonProperty("secondtype")
    private String secondtype;
    /**
     * 任务时刻策略项
     */
    @TableField(value = "tssditemname")
    @JSONField(name = "tssditemname")
    @JsonProperty("tssditemname")
    private String tssditemname;
    /**
     * 指定月天
     */
    @TableField(value = "monthdayvalue")
    @JSONField(name = "monthdayvalue")
    @JsonProperty("monthdayvalue")
    private String monthdayvalue;
    /**
     * 指定月份
     */
    @TableField(value = "monthvalue")
    @JSONField(name = "monthvalue")
    @JsonProperty("monthvalue")
    private String monthvalue;
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
     * 月天
     */
    @TableField(value = "monthdaytype")
    @JSONField(name = "monthdaytype")
    @JsonProperty("monthdaytype")
    private String monthdaytype;
    /**
     * 指定周天
     */
    @TableField(value = "monthweekvalue")
    @JSONField(name = "monthweekvalue")
    @JsonProperty("monthweekvalue")
    private String monthweekvalue;
    /**
     * 指定小时
     */
    @TableField(value = "hourvalue")
    @JSONField(name = "hourvalue")
    @JsonProperty("hourvalue")
    private String hourvalue;
    /**
     * 指定分钟
     */
    @TableField(value = "minutevalue")
    @JSONField(name = "minutevalue")
    @JsonProperty("minutevalue")
    private String minutevalue;
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
     * 月份
     */
    @TableField(value = "monthtype")
    @JSONField(name = "monthtype")
    @JsonProperty("monthtype")
    private String monthtype;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 任务时刻策略项标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tssditemid",type=IdType.UUID)
    @JSONField(name = "tssditemid")
    @JsonProperty("tssditemid")
    private String tssditemid;



    /**
     * 设置 [小时]
     */
    public void setHourtype(String hourtype){
        this.hourtype = hourtype ;
        this.modify("hourtype",hourtype);
    }
    /**
     * 设置 [月周]
     */
    public void setMonthweektype(String monthweektype){
        this.monthweektype = monthweektype ;
        this.modify("monthweektype",monthweektype);
    }
    /**
     * 设置 [指定秒钟]
     */
    public void setSecondvalue(String secondvalue){
        this.secondvalue = secondvalue ;
        this.modify("secondvalue",secondvalue);
    }
    /**
     * 设置 [分钟]
     */
    public void setMinutetype(String minutetype){
        this.minutetype = minutetype ;
        this.modify("minutetype",minutetype);
    }
    /**
     * 设置 [秒钟]
     */
    public void setSecondtype(String secondtype){
        this.secondtype = secondtype ;
        this.modify("secondtype",secondtype);
    }
    /**
     * 设置 [任务时刻策略项]
     */
    public void setTssditemname(String tssditemname){
        this.tssditemname = tssditemname ;
        this.modify("tssditemname",tssditemname);
    }
    /**
     * 设置 [指定月天]
     */
    public void setMonthdayvalue(String monthdayvalue){
        this.monthdayvalue = monthdayvalue ;
        this.modify("monthdayvalue",monthdayvalue);
    }
    /**
     * 设置 [指定月份]
     */
    public void setMonthvalue(String monthvalue){
        this.monthvalue = monthvalue ;
        this.modify("monthvalue",monthvalue);
    }
    /**
     * 设置 [月天]
     */
    public void setMonthdaytype(String monthdaytype){
        this.monthdaytype = monthdaytype ;
        this.modify("monthdaytype",monthdaytype);
    }
    /**
     * 设置 [指定周天]
     */
    public void setMonthweekvalue(String monthweekvalue){
        this.monthweekvalue = monthweekvalue ;
        this.modify("monthweekvalue",monthweekvalue);
    }
    /**
     * 设置 [指定小时]
     */
    public void setHourvalue(String hourvalue){
        this.hourvalue = hourvalue ;
        this.modify("hourvalue",hourvalue);
    }
    /**
     * 设置 [指定分钟]
     */
    public void setMinutevalue(String minutevalue){
        this.minutevalue = minutevalue ;
        this.modify("minutevalue",minutevalue);
    }
    /**
     * 设置 [版本]
     */
    public void setVersion(Integer version){
        this.version = version ;
        this.modify("version",version);
    }
    /**
     * 设置 [月份]
     */
    public void setMonthtype(String monthtype){
        this.monthtype = monthtype ;
        this.modify("monthtype",monthtype);
    }

}


