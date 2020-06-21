package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[请假提示]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACLEAVETIPS",resultMap = "VacLeaveTipsResultMap")
public class VacLeaveTips extends EntityMP implements Serializable {

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
     * 温馨提示
     */
    @TableField(value = "tips")
    @JSONField(name = "tips")
    @JsonProperty("tips")
    private String tips;
    /**
     * 请假提示标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacleavetipsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacleavetipsid")
    @JsonProperty("vacleavetipsid")
    private String vacleavetipsid;
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
     * 请假种类
     */
    @TableField(value = "qjzl")
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;
    /**
     * 请假提示名称
     */
    @TableField(value = "vacleavetipsname")
    @JSONField(name = "vacleavetipsname")
    @JsonProperty("vacleavetipsname")
    private String vacleavetipsname;
    /**
     * 考勤规则名称
     */
    @TableField(exist = false)
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;
    /**
     * 考勤规则标识
     */
    @TableField(value = "vacholidayrulesid")
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;

    /**
     * 考勤规则-请假提示
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacHolidayRules vacholidayrules;



    /**
     * 设置 [温馨提示]
     */
    public void setTips(String tips){
        this.tips = tips ;
        this.modify("tips",tips);
    }

    /**
     * 设置 [请假种类]
     */
    public void setQjzl(String qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [请假提示名称]
     */
    public void setVacleavetipsname(String vacleavetipsname){
        this.vacleavetipsname = vacleavetipsname ;
        this.modify("vacleavetipsname",vacleavetipsname);
    }

    /**
     * 设置 [考勤规则标识]
     */
    public void setVacholidayrulesid(String vacholidayrulesid){
        this.vacholidayrulesid = vacholidayrulesid ;
        this.modify("vacholidayrulesid",vacholidayrulesid);
    }


}


