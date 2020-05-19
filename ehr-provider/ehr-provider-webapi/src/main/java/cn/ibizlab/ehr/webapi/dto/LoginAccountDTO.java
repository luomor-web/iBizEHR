package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[LoginAccountDTO]
 */
@Data
public class LoginAccountDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGADMIN]
     *
     */
    @JSONField(name = "orgadmin")
    @JsonProperty("orgadmin")
    private Integer orgadmin;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERDATA3]
     *
     */
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;

    /**
     * 属性 [LASTCHGPWDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lastchgpwdtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("lastchgpwdtime")
    private Timestamp lastchgpwdtime;

    /**
     * 属性 [LOGINACCOUNTID]
     *
     */
    @JSONField(name = "loginaccountid")
    @JsonProperty("loginaccountid")
    private String loginaccountid;

    /**
     * 属性 [APPUITHEME]
     *
     */
    @JSONField(name = "appuitheme")
    @JsonProperty("appuitheme")
    private String appuitheme;

    /**
     * 属性 [PWD]
     *
     */
    @JSONField(name = "pwd")
    @JsonProperty("pwd")
    private String pwd;

    /**
     * 属性 [SUPERUSER]
     *
     */
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LASTLOGINTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lastlogintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("lastlogintime")
    private Timestamp lastlogintime;

    /**
     * 属性 [LOGINACCOUNTNAME]
     *
     */
    @JSONField(name = "loginaccountname")
    @JsonProperty("loginaccountname")
    private String loginaccountname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISENABLE]
     *
     */
    @JSONField(name = "isenable")
    @JsonProperty("isenable")
    private Integer isenable;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [LANGUAGE]
     *
     */
    @JSONField(name = "language")
    @JsonProperty("language")
    private String language;

    /**
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;


    /**
     * 设置 [ORGADMIN]
     */
    public void setOrgadmin(Integer  orgadmin){
        this.orgadmin = orgadmin ;
        this.modify("orgadmin",orgadmin);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String  userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }

    /**
     * 设置 [LASTCHGPWDTIME]
     */
    public void setLastchgpwdtime(Timestamp  lastchgpwdtime){
        this.lastchgpwdtime = lastchgpwdtime ;
        this.modify("lastchgpwdtime",lastchgpwdtime);
    }

    /**
     * 设置 [APPUITHEME]
     */
    public void setAppuitheme(String  appuitheme){
        this.appuitheme = appuitheme ;
        this.modify("appuitheme",appuitheme);
    }

    /**
     * 设置 [PWD]
     */
    public void setPwd(String  pwd){
        this.pwd = pwd ;
        this.modify("pwd",pwd);
    }

    /**
     * 设置 [SUPERUSER]
     */
    public void setSuperuser(Integer  superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [LASTLOGINTIME]
     */
    public void setLastlogintime(Timestamp  lastlogintime){
        this.lastlogintime = lastlogintime ;
        this.modify("lastlogintime",lastlogintime);
    }

    /**
     * 设置 [LOGINACCOUNTNAME]
     */
    public void setLoginaccountname(String  loginaccountname){
        this.loginaccountname = loginaccountname ;
        this.modify("loginaccountname",loginaccountname);
    }

    /**
     * 设置 [ISENABLE]
     */
    public void setIsenable(Integer  isenable){
        this.isenable = isenable ;
        this.modify("isenable",isenable);
    }

    /**
     * 设置 [LANGUAGE]
     */
    public void setLanguage(String  language){
        this.language = language ;
        this.modify("language",language);
    }

    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String  userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }

    /**
     * 设置 [USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }


}

