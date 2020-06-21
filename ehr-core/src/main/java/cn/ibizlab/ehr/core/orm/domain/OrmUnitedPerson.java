package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[统一身份库]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_UNITEDPERSON",resultMap = "OrmUnitedPersonResultMap")
public class OrmUnitedPerson extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 身份名称
     */
    @TableField(value = "unitedpersonname")
    @JSONField(name = "unitedpersonname")
    @JsonProperty("unitedpersonname")
    private String unitedpersonname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否局员工
     */
    @TableField(value = "isemployee")
    @JSONField(name = "isemployee")
    @JsonProperty("isemployee")
    private String isemployee;
    /**
     * 引用标志
     */
    @DEField(defaultValue = "0")
    @TableField(value = "refermark")
    @JSONField(name = "refermark")
    @JsonProperty("refermark")
    private String refermark;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;
    /**
     * 姓名
     */
    @TableField(value = "employeename")
    @JSONField(name = "employeename")
    @JsonProperty("employeename")
    private String employeename;
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
     * 统一身份库标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "unitedpersonid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "unitedpersonid")
    @JsonProperty("unitedpersonid")
    private String unitedpersonid;
    /**
     * 全名
     */
    @TableField(value = "fullname")
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    private String fullname;
    /**
     * 用户ID
     */
    @TableField(value = "empid")
    @JSONField(name = "empid")
    @JsonProperty("empid")
    private String empid;
    /**
     * EHR人员id
     */
    @TableField(value = "ehrempid")
    @JSONField(name = "ehrempid")
    @JsonProperty("ehrempid")
    private String ehrempid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 证件号码
     */
    @TableField(value = "idnumber")
    @JSONField(name = "idnumber")
    @JsonProperty("idnumber")
    private String idnumber;
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
     * 用户编码
     */
    @TableField(value = "employeenumber")
    @JSONField(name = "employeenumber")
    @JsonProperty("employeenumber")
    private String employeenumber;



    /**
     * 设置 [登录名]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [身份名称]
     */
    public void setUnitedpersonname(String unitedpersonname){
        this.unitedpersonname = unitedpersonname ;
        this.modify("unitedpersonname",unitedpersonname);
    }

    /**
     * 设置 [是否局员工]
     */
    public void setIsemployee(String isemployee){
        this.isemployee = isemployee ;
        this.modify("isemployee",isemployee);
    }

    /**
     * 设置 [引用标志]
     */
    public void setRefermark(String refermark){
        this.refermark = refermark ;
        this.modify("refermark",refermark);
    }

    /**
     * 设置 [性别]
     */
    public void setSex(String sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [姓名]
     */
    public void setEmployeename(String employeename){
        this.employeename = employeename ;
        this.modify("employeename",employeename);
    }

    /**
     * 设置 [全名]
     */
    public void setFullname(String fullname){
        this.fullname = fullname ;
        this.modify("fullname",fullname);
    }

    /**
     * 设置 [用户ID]
     */
    public void setEmpid(String empid){
        this.empid = empid ;
        this.modify("empid",empid);
    }

    /**
     * 设置 [EHR人员id]
     */
    public void setEhrempid(String ehrempid){
        this.ehrempid = ehrempid ;
        this.modify("ehrempid",ehrempid);
    }

    /**
     * 设置 [证件号码]
     */
    public void setIdnumber(String idnumber){
        this.idnumber = idnumber ;
        this.modify("idnumber",idnumber);
    }

    /**
     * 设置 [用户编码]
     */
    public void setEmployeenumber(String employeenumber){
        this.employeenumber = employeenumber ;
        this.modify("employeenumber",employeenumber);
    }


}


