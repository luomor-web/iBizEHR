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
 * 实体[用户管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SRFORGUSER",resultMap = "OrmUserResultMap")
public class OrmUser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名ID
     */
    @TableField(value = "unuserid")
    @JSONField(name = "unuserid")
    @JsonProperty("unuserid")
    private String unuserid;
    /**
     * 用户编号
     */
    @TableField(value = "usercode")
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;
    /**
     * 用户ID
     */
    @TableField(value = "empid")
    @JSONField(name = "empid")
    @JsonProperty("empid")
    private String empid;
    /**
     * 用户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "orguserid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "orguserid")
    @JsonProperty("orguserid")
    private String orguserid;
    /**
     * 用户名称
     */
    @TableField(value = "orgusername")
    @JSONField(name = "orgusername")
    @JsonProperty("orgusername")
    private String orgusername;
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
     * 启用标志
     */
    @DEField(defaultValue = "1")
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 所属组织
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 所属部门
     */
    @DEField(preType = DEPredefinedFieldType.ORGSECTORNAME)
    @TableField(value = "orgsectorname")
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;
    /**
     * 组织ID
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 部门ID
     */
    @DEField(preType = DEPredefinedFieldType.ORGSECTORID)
    @TableField(value = "orgsectorid")
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg org;



    /**
     * 设置 [登录名ID]
     */
    public void setUnuserid(String unuserid){
        this.unuserid = unuserid ;
        this.modify("unuserid",unuserid);
    }

    /**
     * 设置 [用户编号]
     */
    public void setUsercode(String usercode){
        this.usercode = usercode ;
        this.modify("usercode",usercode);
    }

    /**
     * 设置 [用户ID]
     */
    public void setEmpid(String empid){
        this.empid = empid ;
        this.modify("empid",empid);
    }

    /**
     * 设置 [用户名称]
     */
    public void setOrgusername(String orgusername){
        this.orgusername = orgusername ;
        this.modify("orgusername",orgusername);
    }

    /**
     * 设置 [启用标志]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}


