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
 * 实体[用户角色资源能力]
 */
@Data
@TableName(value = "T_SRFUSERROLERES",resultMap = "UserRoleResResultMap")
public class UserRoleRes extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
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
     * 允许模式
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isallow")
    @JSONField(name = "isallow")
    @JsonProperty("isallow")
    private Integer isallow;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
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
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
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
     * 用户角色资源能力标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userroleresid",type=IdType.UUID)
    @JSONField(name = "userroleresid")
    @JsonProperty("userroleresid")
    private String userroleresid;
    /**
     * 用户角色资源能力名称
     */
    @DEField(defaultValue = "角色资源能力")
    @TableField(value = "userroleresname")
    @JSONField(name = "userroleresname")
    @JsonProperty("userroleresname")
    private String userroleresname;
    /**
     * 用户角色
     */
    @TableField(exist = false)
    @JSONField(name = "userrolename")
    @JsonProperty("userrolename")
    private String userrolename;
    /**
     * 资源
     */
    @TableField(exist = false)
    @JSONField(name = "uniresname")
    @JsonProperty("uniresname")
    private String uniresname;
    /**
     * 资源类型
     */
    @TableField(exist = false)
    @JSONField(name = "unirestype")
    @JsonProperty("unirestype")
    private String unirestype;
    /**
     * 用户角色
     */
    @TableField(value = "userroleid")
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;
    /**
     * 统一资源
     */
    @TableField(value = "uniresid")
    @JSONField(name = "uniresid")
    @JsonProperty("uniresid")
    private String uniresid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UniRes unires;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserRole userrole;



    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [允许模式]
     */
    public void setIsallow(Integer isallow){
        this.isallow = isallow ;
        this.modify("isallow",isallow);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [用户角色资源能力名称]
     */
    public void setUserroleresname(String userroleresname){
        this.userroleresname = userroleresname ;
        this.modify("userroleresname",userroleresname);
    }
    /**
     * 设置 [用户角色]
     */
    public void setUserroleid(String userroleid){
        this.userroleid = userroleid ;
        this.modify("userroleid",userroleid);
    }
    /**
     * 设置 [统一资源]
     */
    public void setUniresid(String uniresid){
        this.uniresid = uniresid ;
        this.modify("uniresid",uniresid);
    }

    /**
     * 获取 [用户角色资源能力标识]
     */
    public String getUserroleresid(){
        if(ObjectUtils.isEmpty(userroleresid)){
            userroleresid=(String)getDefaultKey(true);
        }
        return userroleresid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getUserroleid()))&&(!ObjectUtils.isEmpty(this.getUniresid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getUserroleid(),this.getUniresid()).getBytes());
        return null;
    }
}


