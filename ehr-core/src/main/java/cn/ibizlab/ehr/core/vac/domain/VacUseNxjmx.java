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
 * 实体[假期使用明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACUSENXJMX",resultMap = "VacUseNxjmxResultMap")
public class VacUseNxjmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年休假查询id
     */
    @TableField(value = "vacsynjcxid")
    @JSONField(name = "vacsynjcxid")
    @JsonProperty("vacsynjcxid")
    private String vacsynjcxid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 假期使用明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacusenxjmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacusenxjmxid")
    @JsonProperty("vacusenxjmxid")
    private String vacusenxjmxid;
    /**
     * 假期使用明细名称
     */
    @TableField(value = "vacusenxjmxname")
    @JSONField(name = "vacusenxjmxname")
    @JsonProperty("vacusenxjmxname")
    private String vacusenxjmxname;
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
     * 本次使用假期天数
     */
    @TableField(value = "bcnxjts")
    @JSONField(name = "bcnxjts")
    @JsonProperty("bcnxjts")
    private Double bcnxjts;
    /**
     * 请假种类
     */
    @TableField(value = "qjzl")
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;
    /**
     * 请销假明细标识
     */
    @TableField(value = "vacleavedetailid")
    @JSONField(name = "vacleavedetailid")
    @JsonProperty("vacleavedetailid")
    private String vacleavedetailid;

    /**
     * 请假明细-假期使用明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail vacleavedetail;



    /**
     * 设置 [年休假查询id]
     */
    public void setVacsynjcxid(String vacsynjcxid){
        this.vacsynjcxid = vacsynjcxid ;
        this.modify("vacsynjcxid",vacsynjcxid);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [假期使用明细名称]
     */
    public void setVacusenxjmxname(String vacusenxjmxname){
        this.vacusenxjmxname = vacusenxjmxname ;
        this.modify("vacusenxjmxname",vacusenxjmxname);
    }

    /**
     * 设置 [本次使用假期天数]
     */
    public void setBcnxjts(Double bcnxjts){
        this.bcnxjts = bcnxjts ;
        this.modify("bcnxjts",bcnxjts);
    }

    /**
     * 设置 [请假种类]
     */
    public void setQjzl(String qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [请销假明细标识]
     */
    public void setVacleavedetailid(String vacleavedetailid){
        this.vacleavedetailid = vacleavedetailid ;
        this.modify("vacleavedetailid",vacleavedetailid);
    }


}


