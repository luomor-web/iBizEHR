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
 * 实体[用户]
 */
@Data
@TableName(value = "T_USER",resultMap = "UserResultMap")
public class User extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户模式
     */
    @TableField(value = "usermode")
    @JSONField(name = "usermode")
    @JsonProperty("usermode")
    private String usermode;
    /**
     * 自定义数据
     */
    @TableField(exist = false)
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否启用
     */
    @DEField(defaultValue = "1")
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
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
     * 用户名称
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 登录名称
     */
    @TableField(value = "loginname")
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;
    /**
     * 子类型
     */
    @TableField(exist = false)
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;
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
     * 系统数据
     */
    @DEField(defaultValue = "0")
    @TableField(value = "issystem")
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;
    /**
     * 自定义数据2
     */
    @TableField(exist = false)
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 用户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userid",type=IdType.UUID)
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 用户对象级别
     */
    @TableField(exist = false)
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;
    /**
     * 用户对象类型
     */
    @TableField(exist = false)
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 登录密码
     */
    @TableField(value = "loginpwd")
    @JSONField(name = "loginpwd")
    @JsonProperty("loginpwd")
    private String loginpwd;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 所在时区
     */
    @TableField(value = "timezone")
    @JSONField(name = "timezone")
    @JsonProperty("timezone")
    private String timezone;
    /**
     * 所有者标识
     */
    @TableField(exist = false)
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;
    /**
     * 备注
     */
    @TableField(exist = false)
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 所有者类型
     */
    @TableField(exist = false)
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;



    /**
     * 设置 [用户模式]
     */
    public void setUsermode(String usermode){
        this.usermode = usermode ;
        this.modify("usermode",usermode);
    }
    /**
     * 设置 [是否启用]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [用户名称]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [登录名称]
     */
    public void setLoginname(String loginname){
        this.loginname = loginname ;
        this.modify("loginname",loginname);
    }
    /**
     * 设置 [系统数据]
     */
    public void setIssystem(Integer issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [登录密码]
     */
    public void setLoginpwd(String loginpwd){
        this.loginpwd = loginpwd ;
        this.modify("loginpwd",loginpwd);
    }
    /**
     * 设置 [所在时区]
     */
    public void setTimezone(String timezone){
        this.timezone = timezone ;
        this.modify("timezone",timezone);
    }

}


