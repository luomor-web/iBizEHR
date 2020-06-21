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
 * 实体[社保档案明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCARCHIVESDETAIL",resultMap = "SocArchivesDetailResultMap")
public class SocArchivesDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社保档案明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socarchivesdetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "socarchivesdetailid")
    @JsonProperty("socarchivesdetailid")
    private String socarchivesdetailid;
    /**
     * 社保档案明细名称
     */
    @TableField(value = "socarchivesdetailname")
    @JSONField(name = "socarchivesdetailname")
    @JsonProperty("socarchivesdetailname")
    private String socarchivesdetailname;
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
     * 社保档案标识
     */
    @TableField(value = "socarchivesid")
    @JSONField(name = "socarchivesid")
    @JsonProperty("socarchivesid")
    private String socarchivesid;
    /**
     * 社保档案名称
     */
    @TableField(exist = false)
    @JSONField(name = "socarchivesname")
    @JsonProperty("socarchivesname")
    private String socarchivesname;
    /**
     * 社保规则明细标识
     */
    @TableField(value = "socruledetailid")
    @JSONField(name = "socruledetailid")
    @JsonProperty("socruledetailid")
    private String socruledetailid;
    /**
     * 个人基数
     */
    @TableField(value = "personnum")
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private Double personnum;
    /**
     * 企业基数
     */
    @TableField(value = "companynum")
    @JSONField(name = "companynum")
    @JsonProperty("companynum")
    private Double companynum;
    /**
     * 最高基数
     */
    @TableField(exist = false)
    @JSONField(name = "highnum")
    @JsonProperty("highnum")
    private Double highnum;
    /**
     * 最低基数
     */
    @TableField(exist = false)
    @JSONField(name = "lownum")
    @JsonProperty("lownum")
    private Double lownum;
    /**
     * 排序号
     */
    @TableField(exist = false)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 保险类型标识
     */
    @TableField(exist = false)
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
     * 个人比例
     */
    @TableField(exist = false)
    @JSONField(name = "personrate")
    @JsonProperty("personrate")
    private Double personrate;
    /**
     * 企业比例
     */
    @TableField(exist = false)
    @JSONField(name = "companyrate")
    @JsonProperty("companyrate")
    private Double companyrate;
    /**
     * 个人固定额
     */
    @TableField(exist = false)
    @JSONField(name = "personamount")
    @JsonProperty("personamount")
    private Double personamount;
    /**
     * 企业固定额
     */
    @TableField(exist = false)
    @JSONField(name = "companyamount")
    @JsonProperty("companyamount")
    private Double companyamount;
    /**
     * 社保规则明细名称
     */
    @TableField(exist = false)
    @JSONField(name = "socruledetailname")
    @JsonProperty("socruledetailname")
    private String socruledetailname;

    /**
     * 社保档案
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocArchives socarchives;

    /**
     * 社保规则明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocRuleDetail socruledetail;



    /**
     * 设置 [社保档案明细名称]
     */
    public void setSocarchivesdetailname(String socarchivesdetailname){
        this.socarchivesdetailname = socarchivesdetailname ;
        this.modify("socarchivesdetailname",socarchivesdetailname);
    }

    /**
     * 设置 [社保档案标识]
     */
    public void setSocarchivesid(String socarchivesid){
        this.socarchivesid = socarchivesid ;
        this.modify("socarchivesid",socarchivesid);
    }

    /**
     * 设置 [社保规则明细标识]
     */
    public void setSocruledetailid(String socruledetailid){
        this.socruledetailid = socruledetailid ;
        this.modify("socruledetailid",socruledetailid);
    }

    /**
     * 设置 [个人基数]
     */
    public void setPersonnum(Double personnum){
        this.personnum = personnum ;
        this.modify("personnum",personnum);
    }

    /**
     * 设置 [企业基数]
     */
    public void setCompanynum(Double companynum){
        this.companynum = companynum ;
        this.modify("companynum",companynum);
    }


}


