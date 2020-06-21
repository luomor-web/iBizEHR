package cn.ibizlab.ehr.core.att.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[考勤日期]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDANCEDATE",resultMap = "AttEndanceDateResultMap")
public class AttEndanceDate extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤日期名称
     */
    @TableField(value = "attendancedatename")
    @JSONField(name = "attendancedatename")
    @JsonProperty("attendancedatename")
    private String attendancedatename;
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
     * 月
     */
    @TableField(value = "month")
    @JSONField(name = "month")
    @JsonProperty("month")
    private String month;
    /**
     * 考勤日期标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendancedateid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendancedateid")
    @JsonProperty("attendancedateid")
    private String attendancedateid;
    /**
     * 年
     */
    @TableField(value = "year")
    @JSONField(name = "year")
    @JsonProperty("year")
    private String year;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 日
     */
    @TableField(value = "day")
    @JSONField(name = "day")
    @JsonProperty("day")
    private String day;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;



    /**
     * 设置 [考勤日期名称]
     */
    public void setAttendancedatename(String attendancedatename){
        this.attendancedatename = attendancedatename ;
        this.modify("attendancedatename",attendancedatename);
    }

    /**
     * 设置 [月]
     */
    public void setMonth(String month){
        this.month = month ;
        this.modify("month",month);
    }

    /**
     * 设置 [年]
     */
    public void setYear(String year){
        this.year = year ;
        this.modify("year",year);
    }

    /**
     * 设置 [日]
     */
    public void setDay(String day){
        this.day = day ;
        this.modify("day",day);
    }


}


