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
 * 服务DTO对象[UserDTO]
 */
@Data
public class UserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERMODE]
     *
     */
    @JSONField(name = "usermode")
    @JsonProperty("usermode")
    private String usermode;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [LOGINNAME]
     *
     */
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;

    /**
     * 属性 [SUBTYPE]
     *
     */
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ISSYSTEM]
     *
     */
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [USEROBJECTLEVEL]
     *
     */
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;

    /**
     * 属性 [USEROBJECTTYPE]
     *
     */
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [LOGINPWD]
     *
     */
    @JSONField(name = "loginpwd")
    @JsonProperty("loginpwd")
    private String loginpwd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TIMEZONE]
     *
     */
    @JSONField(name = "timezone")
    @JsonProperty("timezone")
    private String timezone;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;


    /**
     * 设置 [USERMODE]
     */
    public void setUsermode(String  usermode){
        this.usermode = usermode ;
        this.modify("usermode",usermode);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [USERNAME]
     */
    public void setUsername(String  username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [LOGINNAME]
     */
    public void setLoginname(String  loginname){
        this.loginname = loginname ;
        this.modify("loginname",loginname);
    }

    /**
     * 设置 [ISSYSTEM]
     */
    public void setIssystem(Integer  issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [LOGINPWD]
     */
    public void setLoginpwd(String  loginpwd){
        this.loginpwd = loginpwd ;
        this.modify("loginpwd",loginpwd);
    }

    /**
     * 设置 [TIMEZONE]
     */
    public void setTimezone(String  timezone){
        this.timezone = timezone ;
        this.modify("timezone",timezone);
    }


}

