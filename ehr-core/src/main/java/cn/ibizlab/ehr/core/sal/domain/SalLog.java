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
 * 实体[薪酬调整日志]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALLOG",resultMap = "SalLogResultMap")
public class SalLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新值
     */
    @TableField(value = "val2")
    @JSONField(name = "val2")
    @JsonProperty("val2")
    private String val2;
    /**
     * 操作人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 操作类型
     */
    @TableField(value = "sallogname")
    @JSONField(name = "sallogname")
    @JsonProperty("sallogname")
    private String sallogname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 薪酬调整日志标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "sallogid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "sallogid")
    @JsonProperty("sallogid")
    private String sallogid;
    /**
     * 原值
     */
    @TableField(value = "val1")
    @JSONField(name = "val1")
    @JsonProperty("val1")
    private String val1;
    /**
     * 操作时间
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
     * 员工薪酬
     */
    @TableField(exist = false)
    @JSONField(name = "salsalaryname")
    @JsonProperty("salsalaryname")
    private String salsalaryname;
    /**
     * 要素项
     */
    @TableField(exist = false)
    @JSONField(name = "salsalarydetailname")
    @JsonProperty("salsalarydetailname")
    private String salsalarydetailname;
    /**
     * 员工薪酬明细标识
     */
    @TableField(value = "salsalarydetailid")
    @JSONField(name = "salsalarydetailid")
    @JsonProperty("salsalarydetailid")
    private String salsalarydetailid;
    /**
     * 员工薪酬标识
     */
    @TableField(value = "salsalaryid")
    @JSONField(name = "salsalaryid")
    @JsonProperty("salsalaryid")
    private String salsalaryid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail salsalarydetail;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSalary salsalary;



    /**
     * 设置 [新值]
     */
    public void setVal2(String val2){
        this.val2 = val2 ;
        this.modify("val2",val2);
    }

    /**
     * 设置 [操作类型]
     */
    public void setSallogname(String sallogname){
        this.sallogname = sallogname ;
        this.modify("sallogname",sallogname);
    }

    /**
     * 设置 [原值]
     */
    public void setVal1(String val1){
        this.val1 = val1 ;
        this.modify("val1",val1);
    }

    /**
     * 设置 [员工薪酬明细标识]
     */
    public void setSalsalarydetailid(String salsalarydetailid){
        this.salsalarydetailid = salsalarydetailid ;
        this.modify("salsalarydetailid",salsalarydetailid);
    }

    /**
     * 设置 [员工薪酬标识]
     */
    public void setSalsalaryid(String salsalaryid){
        this.salsalaryid = salsalaryid ;
        this.modify("salsalaryid",salsalaryid);
    }


}


