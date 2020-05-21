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
 * 实体[用户角色相关实体属性访问控制]
 */
@Data
@TableName(value = "T_USERROLEDEFIELDS",resultMap = "UserRoleDEFieldesResultMap")
public class UserRoleDEFieldes extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色相关实体属性访问控制标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userroledefieldsid",type=IdType.UUID)
    @JSONField(name = "userroledefieldsid")
    @JsonProperty("userroledefieldsid")
    private String userroledefieldsid;
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
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 用户角色相关实体属性访问控制
     */
    @TableField(value = "userroledefieldsname")
    @JSONField(name = "userroledefieldsname")
    @JsonProperty("userroledefieldsname")
    private String userroledefieldsname;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 用户角色
     */
    @TableField(exist = false)
    @JSONField(name = "userrolename")
    @JsonProperty("userrolename")
    private String userrolename;
    /**
     * 实体属性控制
     */
    @TableField(exist = false)
    @JSONField(name = "userroledefieldname")
    @JsonProperty("userroledefieldname")
    private String userroledefieldname;
    /**
     * 用户角色
     */
    @TableField(value = "userroleid")
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;
    /**
     * 实体属性访问能力
     */
    @TableField(value = "userroledefieldid")
    @JSONField(name = "userroledefieldid")
    @JsonProperty("userroledefieldid")
    private String userroledefieldid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserRoleDEField userroledefield;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserRole userrole;



    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [用户角色相关实体属性访问控制]
     */
    public void setUserroledefieldsname(String userroledefieldsname){
        this.userroledefieldsname = userroledefieldsname ;
        this.modify("userroledefieldsname",userroledefieldsname);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [用户角色]
     */
    public void setUserroleid(String userroleid){
        this.userroleid = userroleid ;
        this.modify("userroleid",userroleid);
    }
    /**
     * 设置 [实体属性访问能力]
     */
    public void setUserroledefieldid(String userroledefieldid){
        this.userroledefieldid = userroledefieldid ;
        this.modify("userroledefieldid",userroledefieldid);
    }

    /**
     * 获取 [用户角色相关实体属性访问控制标识]
     */
    public String getUserroledefieldsid(){
        if(ObjectUtils.isEmpty(userroledefieldsid)){
            userroledefieldsid=(String)getDefaultKey(true);
        }
        return userroledefieldsid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getUserroleid()))&&(!ObjectUtils.isEmpty(this.getUserroledefieldid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getUserroleid(),this.getUserroledefieldid()).getBytes());
        return null;
    }
}


