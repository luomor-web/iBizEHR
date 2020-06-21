package cn.ibizlab.ehr.core.sal.domain;

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
 * 实体[薪酬规则明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALRULEDETAIL",resultMap = "SalRuleDetailResultMap")
public class SalRuleDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 薪酬规则明细名称
     */
    @TableField(value = "salruledetailname")
    @JSONField(name = "salruledetailname")
    @JsonProperty("salruledetailname")
    private String salruledetailname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 比较规则
     */
    @TableField(value = "checkrule")
    @JSONField(name = "checkrule")
    @JsonProperty("checkrule")
    private String checkrule;
    /**
     * 薪酬规则明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salruledetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salruledetailid")
    @JsonProperty("salruledetailid")
    private String salruledetailid;
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
     * 薪酬规则名称
     */
    @TableField(exist = false)
    @JSONField(name = "salrulename")
    @JsonProperty("salrulename")
    private String salrulename;
    /**
     * 薪酬计算指标(原值)
     */
    @TableField(exist = false)
    @JSONField(name = "salparamname")
    @JsonProperty("salparamname")
    private String salparamname;
    /**
     * 薪酬计算指标(对应值)
     */
    @TableField(exist = false)
    @JSONField(name = "salparamname2")
    @JsonProperty("salparamname2")
    private String salparamname2;
    /**
     * 薪酬计算指标标识
     */
    @TableField(value = "salparamid")
    @JSONField(name = "salparamid")
    @JsonProperty("salparamid")
    private String salparamid;
    /**
     * 薪酬规则标识
     */
    @TableField(value = "salruleid")
    @JSONField(name = "salruleid")
    @JsonProperty("salruleid")
    private String salruleid;
    /**
     * 薪酬计算指标标识
     */
    @TableField(value = "salparamid2")
    @JSONField(name = "salparamid2")
    @JsonProperty("salparamid2")
    private String salparamid2;

    /**
     * 薪酬计算指标ID（源值）
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalParam salparam;

    /**
     * 薪酬计算指标ID（对应值）
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalParam salparam2;

    /**
     * 规则明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalRule salrule;



    /**
     * 设置 [薪酬规则明细名称]
     */
    public void setSalruledetailname(String salruledetailname){
        this.salruledetailname = salruledetailname ;
        this.modify("salruledetailname",salruledetailname);
    }

    /**
     * 设置 [比较规则]
     */
    public void setCheckrule(String checkrule){
        this.checkrule = checkrule ;
        this.modify("checkrule",checkrule);
    }

    /**
     * 设置 [薪酬计算指标标识]
     */
    public void setSalparamid(String salparamid){
        this.salparamid = salparamid ;
        this.modify("salparamid",salparamid);
    }

    /**
     * 设置 [薪酬规则标识]
     */
    public void setSalruleid(String salruleid){
        this.salruleid = salruleid ;
        this.modify("salruleid",salruleid);
    }

    /**
     * 设置 [薪酬计算指标标识]
     */
    public void setSalparamid2(String salparamid2){
        this.salparamid2 = salparamid2 ;
        this.modify("salparamid2",salparamid2);
    }


}


