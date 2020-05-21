package cn.ibizlab.ehr.core.common.domain;

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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[系统管理功能]
 */
@Data
@TableName(value = "T_SYSADMINFUNC",resultMap = "SysAdminFuncResultMap")
public class SysAdminFunc extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 参数
     */
    @TableField(value = "param")
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;
    /**
     * 功能编号
     */
    @TableField(value = "funcid")
    @JSONField(name = "funcid")
    @JsonProperty("funcid")
    private String funcid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 系统管理功能标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "sysadminfuncid",type=IdType.UUID)
    @JSONField(name = "sysadminfuncid")
    @JsonProperty("sysadminfuncid")
    private String sysadminfuncid;
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
     * 系统管理功能名称
     */
    @TableField(value = "sysadminfuncname")
    @JSONField(name = "sysadminfuncname")
    @JsonProperty("sysadminfuncname")
    private String sysadminfuncname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 管理模块
     */
    @TableField(exist = false)
    @JSONField(name = "sysadminname")
    @JsonProperty("sysadminname")
    private String sysadminname;
    /**
     * 管理对象
     */
    @TableField(exist = false)
    @JSONField(name = "adminobject")
    @JsonProperty("adminobject")
    private String adminobject;
    /**
     * 系统管理功能_管理模块
     */
    @TableField(value = "sysadminid")
    @JSONField(name = "sysadminid")
    @JsonProperty("sysadminid")
    private String sysadminid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.SysAdmin sysadmin;



    /**
     * 设置 [参数]
     */
    public void setParam(String param){
        this.param = param ;
        this.modify("param",param);
    }
    /**
     * 设置 [功能编号]
     */
    public void setFuncid(String funcid){
        this.funcid = funcid ;
        this.modify("funcid",funcid);
    }
    /**
     * 设置 [系统管理功能名称]
     */
    public void setSysadminfuncname(String sysadminfuncname){
        this.sysadminfuncname = sysadminfuncname ;
        this.modify("sysadminfuncname",sysadminfuncname);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [系统管理功能_管理模块]
     */
    public void setSysadminid(String sysadminid){
        this.sysadminid = sysadminid ;
        this.modify("sysadminid",sysadminid);
    }

}


