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
 * 实体[员工薪酬明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALSALARYDETAIL",resultMap = "SalSalaryDetailResultMap")
public class SalSalaryDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工薪酬明细名称
     */
    @TableField(value = "salsalarydetailname")
    @JSONField(name = "salsalarydetailname")
    @JsonProperty("salsalarydetailname")
    private String salsalarydetailname;
    /**
     * 员工薪酬明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salsalarydetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salsalarydetailid")
    @JsonProperty("salsalarydetailid")
    private String salsalarydetailid;
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
     * 实际业务值
     */
    @TableField(value = "ywz")
    @JSONField(name = "ywz")
    @JsonProperty("ywz")
    private String ywz;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 实际情况描述
     */
    @TableField(value = "ywms")
    @JSONField(name = "ywms")
    @JsonProperty("ywms")
    private String ywms;
    /**
     * 薪酬
     */
    @TableField(value = "xc")
    @JSONField(name = "xc")
    @JsonProperty("xc")
    private Double xc;
    /**
     * 员工薪酬名称
     */
    @TableField(exist = false)
    @JSONField(name = "salsalaryname")
    @JsonProperty("salsalaryname")
    private String salsalaryname;
    /**
     * 要素项
     */
    @TableField(exist = false)
    @JSONField(name = "salschemeitemname")
    @JsonProperty("salschemeitemname")
    private String salschemeitemname;
    /**
     * 方案要素项标识
     */
    @TableField(value = "salschemeitemid")
    @JSONField(name = "salschemeitemid")
    @JsonProperty("salschemeitemid")
    private String salschemeitemid;
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
    private cn.ibizlab.ehr.core.sal.domain.SalSalary salsalary;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSchemeItem salschemeitem;



    /**
     * 设置 [员工薪酬明细名称]
     */
    public void setSalsalarydetailname(String salsalarydetailname){
        this.salsalarydetailname = salsalarydetailname ;
        this.modify("salsalarydetailname",salsalarydetailname);
    }

    /**
     * 设置 [实际业务值]
     */
    public void setYwz(String ywz){
        this.ywz = ywz ;
        this.modify("ywz",ywz);
    }

    /**
     * 设置 [实际情况描述]
     */
    public void setYwms(String ywms){
        this.ywms = ywms ;
        this.modify("ywms",ywms);
    }

    /**
     * 设置 [薪酬]
     */
    public void setXc(Double xc){
        this.xc = xc ;
        this.modify("xc",xc);
    }

    /**
     * 设置 [方案要素项标识]
     */
    public void setSalschemeitemid(String salschemeitemid){
        this.salschemeitemid = salschemeitemid ;
        this.modify("salschemeitemid",salschemeitemid);
    }

    /**
     * 设置 [员工薪酬标识]
     */
    public void setSalsalaryid(String salsalaryid){
        this.salsalaryid = salsalaryid ;
        this.modify("salsalaryid",salsalaryid);
    }


}


