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
 * 服务DTO对象[LoginLogDTO]
 */
@Data
public class LoginLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LOGOUTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "logouttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("logouttime")
    private Timestamp logouttime;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [LOGINTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "logintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("logintime")
    private Timestamp logintime;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USERAGENT]
     *
     */
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    private String useragent;

    /**
     * 属性 [LOGINLOGNAME]
     *
     */
    @JSONField(name = "loginlogname")
    @JsonProperty("loginlogname")
    private String loginlogname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LOGINLOGID]
     *
     */
    @JSONField(name = "loginlogid")
    @JsonProperty("loginlogid")
    private String loginlogid;

    /**
     * 属性 [IPADDRESS]
     *
     */
    @JSONField(name = "ipaddress")
    @JsonProperty("ipaddress")
    private String ipaddress;

    /**
     * 属性 [SERVERADDR]
     *
     */
    @JSONField(name = "serveraddr")
    @JsonProperty("serveraddr")
    private String serveraddr;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [LOGINACCOUNTNAME]
     *
     */
    @JSONField(name = "loginaccountname")
    @JsonProperty("loginaccountname")
    private String loginaccountname;

    /**
     * 属性 [LOGINACCOUNTID]
     *
     */
    @JSONField(name = "loginaccountid")
    @JsonProperty("loginaccountid")
    private String loginaccountid;


    /**
     * 设置 [LOGOUTTIME]
     */
    public void setLogouttime(Timestamp  logouttime){
        this.logouttime = logouttime ;
        this.modify("logouttime",logouttime);
    }

    /**
     * 设置 [LOGINTIME]
     */
    public void setLogintime(Timestamp  logintime){
        this.logintime = logintime ;
        this.modify("logintime",logintime);
    }

    /**
     * 设置 [USERAGENT]
     */
    public void setUseragent(String  useragent){
        this.useragent = useragent ;
        this.modify("useragent",useragent);
    }

    /**
     * 设置 [LOGINLOGNAME]
     */
    public void setLoginlogname(String  loginlogname){
        this.loginlogname = loginlogname ;
        this.modify("loginlogname",loginlogname);
    }

    /**
     * 设置 [IPADDRESS]
     */
    public void setIpaddress(String  ipaddress){
        this.ipaddress = ipaddress ;
        this.modify("ipaddress",ipaddress);
    }

    /**
     * 设置 [SERVERADDR]
     */
    public void setServeraddr(String  serveraddr){
        this.serveraddr = serveraddr ;
        this.modify("serveraddr",serveraddr);
    }

    /**
     * 设置 [LOGINACCOUNTNAME]
     */
    public void setLoginaccountname(String  loginaccountname){
        this.loginaccountname = loginaccountname ;
        this.modify("loginaccountname",loginaccountname);
    }

    /**
     * 设置 [LOGINACCOUNTID]
     */
    public void setLoginaccountid(String  loginaccountid){
        this.loginaccountid = loginaccountid ;
        this.modify("loginaccountid",loginaccountid);
    }


}

