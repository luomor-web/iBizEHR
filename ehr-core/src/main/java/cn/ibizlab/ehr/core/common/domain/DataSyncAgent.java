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
 * 实体[数据同步代理]
 */
@Data
@TableName(value = "T_DATASYNCAGENT",resultMap = "DataSyncAgentResultMap")
public class DataSyncAgent extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据同步代理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "datasyncagentid",type=IdType.UUID)
    @JSONField(name = "datasyncagentid")
    @JsonProperty("datasyncagentid")
    private String datasyncagentid;
    /**
     * 访问密码
     */
    @TableField(value = "pwd")
    @JSONField(name = "pwd")
    @JsonProperty("pwd")
    private String pwd;
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
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 数据同步代理名称
     */
    @TableField(value = "datasyncagentname")
    @JSONField(name = "datasyncagentname")
    @JsonProperty("datasyncagentname")
    private String datasyncagentname;
    /**
     * 代理参数
     */
    @TableField(value = "agentparam")
    @JSONField(name = "agentparam")
    @JsonProperty("agentparam")
    private String agentparam;
    /**
     * 代理类型
     */
    @TableField(value = "agenttype")
    @JSONField(name = "agenttype")
    @JsonProperty("agenttype")
    private String agenttype;
    /**
     * 访问用户
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
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
     * 数据同步方向
     */
    @TableField(value = "syncdir")
    @JSONField(name = "syncdir")
    @JsonProperty("syncdir")
    private String syncdir;
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
     * 远端地址
     */
    @TableField(value = "serverpath")
    @JSONField(name = "serverpath")
    @JsonProperty("serverpath")
    private String serverpath;
    /**
     * 服务名称
     */
    @TableField(value = "servicename")
    @JSONField(name = "servicename")
    @JsonProperty("servicename")
    private String servicename;
    /**
     * 客户端标识
     */
    @TableField(value = "clientid")
    @JSONField(name = "clientid")
    @JsonProperty("clientid")
    private String clientid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;



    /**
     * 设置 [访问密码]
     */
    public void setPwd(String pwd){
        this.pwd = pwd ;
        this.modify("pwd",pwd);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [数据同步代理名称]
     */
    public void setDatasyncagentname(String datasyncagentname){
        this.datasyncagentname = datasyncagentname ;
        this.modify("datasyncagentname",datasyncagentname);
    }
    /**
     * 设置 [代理参数]
     */
    public void setAgentparam(String agentparam){
        this.agentparam = agentparam ;
        this.modify("agentparam",agentparam);
    }
    /**
     * 设置 [代理类型]
     */
    public void setAgenttype(String agenttype){
        this.agenttype = agenttype ;
        this.modify("agenttype",agenttype);
    }
    /**
     * 设置 [访问用户]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }
    /**
     * 设置 [数据同步方向]
     */
    public void setSyncdir(String syncdir){
        this.syncdir = syncdir ;
        this.modify("syncdir",syncdir);
    }
    /**
     * 设置 [远端地址]
     */
    public void setServerpath(String serverpath){
        this.serverpath = serverpath ;
        this.modify("serverpath",serverpath);
    }
    /**
     * 设置 [服务名称]
     */
    public void setServicename(String servicename){
        this.servicename = servicename ;
        this.modify("servicename",servicename);
    }
    /**
     * 设置 [客户端标识]
     */
    public void setClientid(String clientid){
        this.clientid = clientid ;
        this.modify("clientid",clientid);
    }

}


