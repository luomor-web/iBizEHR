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
 * 实体[帐户使用记录]
 */
@Data
@TableName(value = "T_SRFLOGINLOG",resultMap = "LoginLogResultMap")
public class LoginLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 注销时间
     */
    @TableField(value = "logouttime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "logouttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("logouttime")
    private Timestamp logouttime;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 登录时间
     */
    @TableField(value = "logintime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "logintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("logintime")
    private Timestamp logintime;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 客户端标识
     */
    @TableField(value = "useragent")
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    private String useragent;
    /**
     * 帐户使用记录名称
     */
    @TableField(value = "loginlogname")
    @JSONField(name = "loginlogname")
    @JsonProperty("loginlogname")
    private String loginlogname;
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
     * 帐户使用记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "loginlogid",type=IdType.UUID)
    @JSONField(name = "loginlogid")
    @JsonProperty("loginlogid")
    private String loginlogid;
    /**
     * IP地址
     */
    @TableField(value = "ipaddress")
    @JSONField(name = "ipaddress")
    @JsonProperty("ipaddress")
    private String ipaddress;
    /**
     * 服务器地址
     */
    @TableField(value = "serveraddr")
    @JSONField(name = "serveraddr")
    @JsonProperty("serveraddr")
    private String serveraddr;
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
     * 登录帐户
     */
    @TableField(value = "loginaccountname")
    @JSONField(name = "loginaccountname")
    @JsonProperty("loginaccountname")
    private String loginaccountname;
    /**
     * 登录帐户
     */
    @TableField(value = "loginaccountid")
    @JSONField(name = "loginaccountid")
    @JsonProperty("loginaccountid")
    private String loginaccountid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.LoginAccount loginaccount;



    /**
     * 设置 [注销时间]
     */
    public void setLogouttime(Timestamp logouttime){
        this.logouttime = logouttime ;
        this.modify("logouttime",logouttime);
    }
    /**
     * 设置 [登录时间]
     */
    public void setLogintime(Timestamp logintime){
        this.logintime = logintime ;
        this.modify("logintime",logintime);
    }
    /**
     * 设置 [客户端标识]
     */
    public void setUseragent(String useragent){
        this.useragent = useragent ;
        this.modify("useragent",useragent);
    }
    /**
     * 设置 [帐户使用记录名称]
     */
    public void setLoginlogname(String loginlogname){
        this.loginlogname = loginlogname ;
        this.modify("loginlogname",loginlogname);
    }
    /**
     * 设置 [IP地址]
     */
    public void setIpaddress(String ipaddress){
        this.ipaddress = ipaddress ;
        this.modify("ipaddress",ipaddress);
    }
    /**
     * 设置 [服务器地址]
     */
    public void setServeraddr(String serveraddr){
        this.serveraddr = serveraddr ;
        this.modify("serveraddr",serveraddr);
    }
    /**
     * 设置 [登录帐户]
     */
    public void setLoginaccountname(String loginaccountname){
        this.loginaccountname = loginaccountname ;
        this.modify("loginaccountname",loginaccountname);
    }
    /**
     * 设置 [登录帐户]
     */
    public void setLoginaccountid(String loginaccountid){
        this.loginaccountid = loginaccountid ;
        this.modify("loginaccountid",loginaccountid);
    }

}


