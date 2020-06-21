package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[员工能力]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPERSONABILITY",resultMap = "PimPersonAbilityResultMap")
public class PimPersonAbility extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工能力标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpersonabilityid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpersonabilityid")
    @JsonProperty("pimpersonabilityid")
    private String pimpersonabilityid;
    /**
     * 绩效得分
     */
    @TableField(value = "performscore")
    @JSONField(name = "performscore")
    @JsonProperty("performscore")
    private Double performscore;
    /**
     * 职称得分
     */
    @TableField(value = "techscore")
    @JSONField(name = "techscore")
    @JsonProperty("techscore")
    private String techscore;
    /**
     * 年
     */
    @TableField(value = "year")
    @JSONField(name = "year")
    @JsonProperty("year")
    private Integer year;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 执业资格得分
     */
    @TableField(value = "pracscore")
    @JSONField(name = "pracscore")
    @JsonProperty("pracscore")
    private Double pracscore;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 记录月份
     */
    @TableField(value = "recorddate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "recorddate" , format="yyyy-MM-dd")
    @JsonProperty("recorddate")
    private Timestamp recorddate;
    /**
     * 月
     */
    @TableField(value = "month")
    @JSONField(name = "month")
    @JsonProperty("month")
    private Integer month;
    /**
     * 培训结果得分
     */
    @TableField(value = "trainresultscore")
    @JSONField(name = "trainresultscore")
    @JsonProperty("trainresultscore")
    private Double trainresultscore;
    /**
     * 学历得分
     */
    @TableField(value = "eduscore")
    @JSONField(name = "eduscore")
    @JsonProperty("eduscore")
    private Double eduscore;
    /**
     * 员工能力名称
     */
    @TableField(value = "pimpersonabilityname")
    @JSONField(name = "pimpersonabilityname")
    @JsonProperty("pimpersonabilityname")
    private String pimpersonabilityname;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [绩效得分]
     */
    public void setPerformscore(Double performscore){
        this.performscore = performscore ;
        this.modify("performscore",performscore);
    }

    /**
     * 设置 [职称得分]
     */
    public void setTechscore(String techscore){
        this.techscore = techscore ;
        this.modify("techscore",techscore);
    }

    /**
     * 设置 [年]
     */
    public void setYear(Integer year){
        this.year = year ;
        this.modify("year",year);
    }

    /**
     * 设置 [执业资格得分]
     */
    public void setPracscore(Double pracscore){
        this.pracscore = pracscore ;
        this.modify("pracscore",pracscore);
    }

    /**
     * 设置 [记录月份]
     */
    public void setRecorddate(Timestamp recorddate){
        this.recorddate = recorddate ;
        this.modify("recorddate",recorddate);
    }

    /**
     * 格式化日期 [记录月份]
     */
    public String formatRecorddate(){
        if (this.recorddate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(recorddate);
    }
    /**
     * 设置 [月]
     */
    public void setMonth(Integer month){
        this.month = month ;
        this.modify("month",month);
    }

    /**
     * 设置 [培训结果得分]
     */
    public void setTrainresultscore(Double trainresultscore){
        this.trainresultscore = trainresultscore ;
        this.modify("trainresultscore",trainresultscore);
    }

    /**
     * 设置 [学历得分]
     */
    public void setEduscore(Double eduscore){
        this.eduscore = eduscore ;
        this.modify("eduscore",eduscore);
    }

    /**
     * 设置 [员工能力名称]
     */
    public void setPimpersonabilityname(String pimpersonabilityname){
        this.pimpersonabilityname = pimpersonabilityname ;
        this.modify("pimpersonabilityname",pimpersonabilityname);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


