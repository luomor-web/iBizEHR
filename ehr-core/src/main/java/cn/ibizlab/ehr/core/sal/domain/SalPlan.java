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
 * 实体[薪酬计算计划]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALPLAN",resultMap = "SalPlanResultMap")
public class SalPlan extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年
     */
    @TableField(value = "nyear")
    @JSONField(name = "nyear")
    @JsonProperty("nyear")
    private Integer nyear;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 薪酬计算计划标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salplanid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salplanid")
    @JsonProperty("salplanid")
    private String salplanid;
    /**
     * 薪酬计算计划名称
     */
    @TableField(value = "salplanname")
    @JSONField(name = "salplanname")
    @JsonProperty("salplanname")
    private String salplanname;
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
     * 月
     */
    @TableField(value = "nmonth")
    @JSONField(name = "nmonth")
    @JsonProperty("nmonth")
    private Integer nmonth;
    /**
     * 计划状态
     */
    @TableField(value = "state")
    @JSONField(name = "state")
    @JsonProperty("state")
    private String state;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 薪酬方案
     */
    @TableField(exist = false)
    @JSONField(name = "salschemename")
    @JsonProperty("salschemename")
    private String salschemename;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 薪酬方案标识
     */
    @TableField(value = "salschemeid")
    @JSONField(name = "salschemeid")
    @JsonProperty("salschemeid")
    private String salschemeid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalScheme salscheme;



    /**
     * 设置 [年]
     */
    public void setNyear(Integer nyear){
        this.nyear = nyear ;
        this.modify("nyear",nyear);
    }

    /**
     * 设置 [薪酬计算计划名称]
     */
    public void setSalplanname(String salplanname){
        this.salplanname = salplanname ;
        this.modify("salplanname",salplanname);
    }

    /**
     * 设置 [月]
     */
    public void setNmonth(Integer nmonth){
        this.nmonth = nmonth ;
        this.modify("nmonth",nmonth);
    }

    /**
     * 设置 [计划状态]
     */
    public void setState(String state){
        this.state = state ;
        this.modify("state",state);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [薪酬方案标识]
     */
    public void setSalschemeid(String salschemeid){
        this.salschemeid = salschemeid ;
        this.modify("salschemeid",salschemeid);
    }


}


