package cn.ibizlab.ehr.core.soc.domain;

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
 * 实体[社保规则明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCRULEDETAIL",resultMap = "SocRuleDetailResultMap")
public class SocRuleDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社保规则明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socruledetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "socruledetailid")
    @JsonProperty("socruledetailid")
    private String socruledetailid;
    /**
     * 社保规则明细名称
     */
    @TableField(value = "socruledetailname")
    @JSONField(name = "socruledetailname")
    @JsonProperty("socruledetailname")
    private String socruledetailname;
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
     * 保险类型标识
     */
    @TableField(value = "soctypeid")
    @JSONField(name = "soctypeid")
    @JsonProperty("soctypeid")
    private String soctypeid;
    /**
     * 保险类型
     */
    @TableField(exist = false)
    @JSONField(name = "soctypename")
    @JsonProperty("soctypename")
    private String soctypename;
    /**
     * 社保规则标识
     */
    @TableField(value = "socruleid")
    @JSONField(name = "socruleid")
    @JsonProperty("socruleid")
    private String socruleid;
    /**
     * 社保规则名称
     */
    @TableField(exist = false)
    @JSONField(name = "socrulename")
    @JsonProperty("socrulename")
    private String socrulename;
    /**
     * 最高基数
     */
    @TableField(value = "highnum")
    @JSONField(name = "highnum")
    @JsonProperty("highnum")
    private Double highnum;
    /**
     * 最低基数
     */
    @TableField(value = "lownum")
    @JSONField(name = "lownum")
    @JsonProperty("lownum")
    private Double lownum;
    /**
     * 企业基数
     */
    @TableField(value = "companynum")
    @JSONField(name = "companynum")
    @JsonProperty("companynum")
    private Double companynum;
    /**
     * 个人基数
     */
    @TableField(value = "personnum")
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private Double personnum;
    /**
     * 企业比例
     */
    @TableField(value = "companyrate")
    @JSONField(name = "companyrate")
    @JsonProperty("companyrate")
    private Double companyrate;
    /**
     * 个人比例
     */
    @TableField(value = "personrate")
    @JSONField(name = "personrate")
    @JsonProperty("personrate")
    private Double personrate;
    /**
     * 个人固定额
     */
    @TableField(value = "personamount")
    @JSONField(name = "personamount")
    @JsonProperty("personamount")
    private Double personamount;
    /**
     * 企业固定额
     */
    @TableField(value = "companyamount")
    @JSONField(name = "companyamount")
    @JsonProperty("companyamount")
    private Double companyamount;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 排序号
     */
    @TableField(exist = false)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocRule socrule;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocType soctype;



    /**
     * 设置 [社保规则明细名称]
     */
    public void setSocruledetailname(String socruledetailname){
        this.socruledetailname = socruledetailname ;
        this.modify("socruledetailname",socruledetailname);
    }

    /**
     * 设置 [保险类型标识]
     */
    public void setSoctypeid(String soctypeid){
        this.soctypeid = soctypeid ;
        this.modify("soctypeid",soctypeid);
    }

    /**
     * 设置 [社保规则标识]
     */
    public void setSocruleid(String socruleid){
        this.socruleid = socruleid ;
        this.modify("socruleid",socruleid);
    }

    /**
     * 设置 [最高基数]
     */
    public void setHighnum(Double highnum){
        this.highnum = highnum ;
        this.modify("highnum",highnum);
    }

    /**
     * 设置 [最低基数]
     */
    public void setLownum(Double lownum){
        this.lownum = lownum ;
        this.modify("lownum",lownum);
    }

    /**
     * 设置 [企业基数]
     */
    public void setCompanynum(Double companynum){
        this.companynum = companynum ;
        this.modify("companynum",companynum);
    }

    /**
     * 设置 [个人基数]
     */
    public void setPersonnum(Double personnum){
        this.personnum = personnum ;
        this.modify("personnum",personnum);
    }

    /**
     * 设置 [企业比例]
     */
    public void setCompanyrate(Double companyrate){
        this.companyrate = companyrate ;
        this.modify("companyrate",companyrate);
    }

    /**
     * 设置 [个人比例]
     */
    public void setPersonrate(Double personrate){
        this.personrate = personrate ;
        this.modify("personrate",personrate);
    }

    /**
     * 设置 [个人固定额]
     */
    public void setPersonamount(Double personamount){
        this.personamount = personamount ;
        this.modify("personamount",personamount);
    }

    /**
     * 设置 [企业固定额]
     */
    public void setCompanyamount(Double companyamount){
        this.companyamount = companyamount ;
        this.modify("companyamount",companyamount);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}


