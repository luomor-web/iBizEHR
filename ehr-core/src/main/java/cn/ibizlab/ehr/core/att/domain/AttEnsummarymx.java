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
 * 实体[考勤汇总明细（停用）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENSUMMARYMX",resultMap = "AttEnsummarymxResultMap")
public class AttEnsummarymx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计划天数（考勤）
     */
    @TableField(value = "ts")
    @JSONField(name = "ts")
    @JsonProperty("ts")
    private Double ts;
    /**
     * 实际天数（考勤）
     */
    @TableField(value = "sjts")
    @JSONField(name = "sjts")
    @JsonProperty("sjts")
    private Double sjts;
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
     * 考勤汇总明细名称
     */
    @DEField(name = "attensummarymxname")
    @TableField(value = "attensummarymxname")
    @JSONField(name = "attendancesummarymxname")
    @JsonProperty("attendancesummarymxname")
    private String attendancesummarymxname;
    /**
     * 考勤汇总明细标识
     */
    @DEField(name = "attensummarymxid" , isKeyField=true)
    @TableId(value= "attensummarymxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendancesummarymxid")
    @JsonProperty("attendancesummarymxid")
    private String attendancesummarymxid;
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
     * 考勤类型
     */
    @TableField(value = "kqlx")
    @JSONField(name = "kqlx")
    @JsonProperty("kqlx")
    private String kqlx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 设置 [计划天数（考勤）]
     */
    public void setTs(Double ts){
        this.ts = ts ;
        this.modify("ts",ts);
    }

    /**
     * 设置 [实际天数（考勤）]
     */
    public void setSjts(Double sjts){
        this.sjts = sjts ;
        this.modify("sjts",sjts);
    }

    /**
     * 设置 [考勤汇总明细名称]
     */
    public void setAttendancesummarymxname(String attendancesummarymxname){
        this.attendancesummarymxname = attendancesummarymxname ;
        this.modify("attensummarymxname",attendancesummarymxname);
    }

    /**
     * 设置 [考勤类型]
     */
    public void setKqlx(String kqlx){
        this.kqlx = kqlx ;
        this.modify("kqlx",kqlx);
    }


}


