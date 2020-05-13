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
 * 服务DTO对象[DataSyncAgentDTO]
 */
@Data
public class DataSyncAgentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DATASYNCAGENTID]
     *
     */
    @JSONField(name = "datasyncagentid")
    @JsonProperty("datasyncagentid")
    private String datasyncagentid;

    /**
     * 属性 [PWD]
     *
     */
    @JSONField(name = "pwd")
    @JsonProperty("pwd")
    private String pwd;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DATASYNCAGENTNAME]
     *
     */
    @JSONField(name = "datasyncagentname")
    @JsonProperty("datasyncagentname")
    private String datasyncagentname;

    /**
     * 属性 [AGENTPARAM]
     *
     */
    @JSONField(name = "agentparam")
    @JsonProperty("agentparam")
    private String agentparam;

    /**
     * 属性 [AGENTTYPE]
     *
     */
    @JSONField(name = "agenttype")
    @JsonProperty("agenttype")
    private String agenttype;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SYNCDIR]
     *
     */
    @JSONField(name = "syncdir")
    @JsonProperty("syncdir")
    private String syncdir;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SERVERPATH]
     *
     */
    @JSONField(name = "serverpath")
    @JsonProperty("serverpath")
    private String serverpath;

    /**
     * 属性 [SERVICENAME]
     *
     */
    @JSONField(name = "servicename")
    @JsonProperty("servicename")
    private String servicename;

    /**
     * 属性 [CLIENTID]
     *
     */
    @JSONField(name = "clientid")
    @JsonProperty("clientid")
    private String clientid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;


    /**
     * 设置 [PWD]
     */
    public void setPwd(String  pwd){
        this.pwd = pwd ;
        this.modify("pwd",pwd);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [DATASYNCAGENTNAME]
     */
    public void setDatasyncagentname(String  datasyncagentname){
        this.datasyncagentname = datasyncagentname ;
        this.modify("datasyncagentname",datasyncagentname);
    }

    /**
     * 设置 [AGENTPARAM]
     */
    public void setAgentparam(String  agentparam){
        this.agentparam = agentparam ;
        this.modify("agentparam",agentparam);
    }

    /**
     * 设置 [AGENTTYPE]
     */
    public void setAgenttype(String  agenttype){
        this.agenttype = agenttype ;
        this.modify("agenttype",agenttype);
    }

    /**
     * 设置 [USERNAME]
     */
    public void setUsername(String  username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [SYNCDIR]
     */
    public void setSyncdir(String  syncdir){
        this.syncdir = syncdir ;
        this.modify("syncdir",syncdir);
    }

    /**
     * 设置 [SERVERPATH]
     */
    public void setServerpath(String  serverpath){
        this.serverpath = serverpath ;
        this.modify("serverpath",serverpath);
    }

    /**
     * 设置 [SERVICENAME]
     */
    public void setServicename(String  servicename){
        this.servicename = servicename ;
        this.modify("servicename",servicename);
    }

    /**
     * 设置 [CLIENTID]
     */
    public void setClientid(String  clientid){
        this.clientid = clientid ;
        this.modify("clientid",clientid);
    }


}

