package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[积分规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARINTEGRALRULE",resultMap = "ParIntegralRuleResultMap")
public class ParIntegralRule extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 积分规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parintegralruleid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parintegralruleid")
    @JsonProperty("parintegralruleid")
    private String parintegralruleid;
    /**
     * 积分规则名称
     */
    @TableField(value = "parintegralrulename")
    @JSONField(name = "parintegralrulename")
    @JsonProperty("parintegralrulename")
    private String parintegralrulename;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 积分
     */
    @TableField(value = "integrals")
    @JSONField(name = "integrals")
    @JsonProperty("integrals")
    private Integer integrals;
    /**
     * 定级
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;



    /**
     * 设置 [积分规则名称]
     */
    public void setParintegralrulename(String parintegralrulename){
        this.parintegralrulename = parintegralrulename ;
        this.modify("parintegralrulename",parintegralrulename);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [积分]
     */
    public void setIntegrals(Integer integrals){
        this.integrals = integrals ;
        this.modify("integrals",integrals);
    }

    /**
     * 设置 [定级]
     */
    public void setDj(String dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }


}


