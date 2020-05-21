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
 * 实体[登录帐户]
 */
@Data
@TableName(value = "T_SRFLOGINACCOUNT",resultMap = "LoginAccountResultMap")
public class LoginAccount extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构管理员
     */
    @TableField(value = "orgadmin")
    @JSONField(name = "orgadmin")
    @JsonProperty("orgadmin")
    private Integer orgadmin;
    /**
     * USERDATA2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
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
     * USERDATA3
     */
    @TableField(value = "userdata3")
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;
    /**
     * 最后修改密码时间
     */
    @TableField(value = "lastchgpwdtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lastchgpwdtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("lastchgpwdtime")
    private Timestamp lastchgpwdtime;
    /**
     * 登录帐户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "loginaccountid",type=IdType.UUID)
    @JSONField(name = "loginaccountid")
    @JsonProperty("loginaccountid")
    private String loginaccountid;
    /**
     * 应用界面主题
     */
    @TableField(value = "appuitheme")
    @JSONField(name = "appuitheme")
    @JsonProperty("appuitheme")
    private String appuitheme;
    /**
     * 登录密码
     */
    @TableField(value = "pwd")
    @JSONField(name = "pwd")
    @JsonProperty("pwd")
    private String pwd;
    /**
     * 超级用户
     */
    @TableField(value = "superuser")
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;
    /**
     * USERDATA
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
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
     * 最后登录时间
     */
    @TableField(value = "lastlogintime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lastlogintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("lastlogintime")
    private Timestamp lastlogintime;
    /**
     * 登录帐户
     */
    @TableField(value = "loginaccountname")
    @JSONField(name = "loginaccountname")
    @JsonProperty("loginaccountname")
    private String loginaccountname;
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
    @TableField(value = "isenable")
    @JSONField(name = "isenable")
    @JsonProperty("isenable")
    private Integer isenable;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 默认语言
     */
    @TableField(value = "language")
    @JSONField(name = "language")
    @JsonProperty("language")
    private String language;
    /**
     * USERDATA4
     */
    @TableField(value = "userdata4")
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * 用户
     */
    @TableField(exist = false)
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 用户
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.User user;



    /**
     * 设置 [机构管理员]
     */
    public void setOrgadmin(Integer orgadmin){
        this.orgadmin = orgadmin ;
        this.modify("orgadmin",orgadmin);
    }
    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }
    /**
     * 设置 [最后修改密码时间]
     */
    public void setLastchgpwdtime(Timestamp lastchgpwdtime){
        this.lastchgpwdtime = lastchgpwdtime ;
        this.modify("lastchgpwdtime",lastchgpwdtime);
    }
    /**
     * 设置 [应用界面主题]
     */
    public void setAppuitheme(String appuitheme){
        this.appuitheme = appuitheme ;
        this.modify("appuitheme",appuitheme);
    }
    /**
     * 设置 [登录密码]
     */
    public void setPwd(String pwd){
        this.pwd = pwd ;
        this.modify("pwd",pwd);
    }
    /**
     * 设置 [超级用户]
     */
    public void setSuperuser(Integer superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
    }
    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [最后登录时间]
     */
    public void setLastlogintime(Timestamp lastlogintime){
        this.lastlogintime = lastlogintime ;
        this.modify("lastlogintime",lastlogintime);
    }
    /**
     * 设置 [登录帐户]
     */
    public void setLoginaccountname(String loginaccountname){
        this.loginaccountname = loginaccountname ;
        this.modify("loginaccountname",loginaccountname);
    }
    /**
     * 设置 [是否启用]
     */
    public void setIsenable(Integer isenable){
        this.isenable = isenable ;
        this.modify("isenable",isenable);
    }
    /**
     * 设置 [默认语言]
     */
    public void setLanguage(String language){
        this.language = language ;
        this.modify("language",language);
    }
    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }
    /**
     * 设置 [用户]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

}


