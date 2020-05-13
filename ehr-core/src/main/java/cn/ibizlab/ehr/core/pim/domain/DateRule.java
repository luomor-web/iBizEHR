package cn.ibizlab.ehr.core.pim.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[生效日期规则]
 */
@Data
@TableName(value = "T_DATERULE",resultMap = "DateRuleResultMap")
public class DateRule extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开始日期
     */
    @TableField(value = "startdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "startdate" , format="yyyy-MM-dd")
    @JsonProperty("startdate")
    private Timestamp startdate;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 生效日期规则名称
     */
    @TableField(value = "daterulename")
    @JSONField(name = "daterulename")
    @JsonProperty("daterulename")
    private String daterulename;
    /**
     * 生效日期规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "dateruleid",type=IdType.UUID)
    @JSONField(name = "dateruleid")
    @JsonProperty("dateruleid")
    private String dateruleid;
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
     * 截止日期
     */
    @TableField(value = "enddate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "enddate" , format="yyyy-MM-dd")
    @JsonProperty("enddate")
    private Timestamp enddate;
    /**
     * 组织名称
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
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg;



    /**
     * 设置 [开始日期]
     */
    public void setStartdate(Timestamp startdate){
        this.startdate = startdate ;
        this.modify("startdate",startdate);
    }
    /**
     * 设置 [生效日期规则名称]
     */
    public void setDaterulename(String daterulename){
        this.daterulename = daterulename ;
        this.modify("daterulename",daterulename);
    }
    /**
     * 设置 [截止日期]
     */
    public void setEnddate(Timestamp enddate){
        this.enddate = enddate ;
        this.modify("enddate",enddate);
    }
    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }
}






