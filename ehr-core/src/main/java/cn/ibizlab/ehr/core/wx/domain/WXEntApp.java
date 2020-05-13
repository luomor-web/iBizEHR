package cn.ibizlab.ehr.core.wx.domain;

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
 * 实体[微信企业应用]
 */
@Data
@TableName(value = "T_SRFWXENTAPP",resultMap = "WXEntAppResultMap")
public class WXEntApp extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应用标识
     */
    @TableField(value = "agentid")
    @JSONField(name = "agentid")
    @JsonProperty("agentid")
    private Integer agentid;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
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
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 微信企业应用名称
     */
    @TableField(value = "wxentappname")
    @JSONField(name = "wxentappname")
    @JsonProperty("wxentappname")
    private String wxentappname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 应用路径
     */
    @TableField(value = "appurl")
    @JSONField(name = "appurl")
    @JsonProperty("appurl")
    private String appurl;
    /**
     * 应用类型
     */
    @TableField(value = "apptype")
    @JSONField(name = "apptype")
    @JsonProperty("apptype")
    private String apptype;
    /**
     * APIENCODINGAESKEY
     */
    @TableField(value = "apiencodingaeskey")
    @JSONField(name = "apiencodingaeskey")
    @JsonProperty("apiencodingaeskey")
    private String apiencodingaeskey;
    /**
     * 是否启用
     */
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
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
     * 是否进入应用
     */
    @TableField(value = "repenterflag")
    @JSONField(name = "repenterflag")
    @JsonProperty("repenterflag")
    private Integer repenterflag;
    /**
     * API地址
     */
    @TableField(value = "apiurl")
    @JSONField(name = "apiurl")
    @JsonProperty("apiurl")
    private String apiurl;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * AppSecret
     */
    @TableField(value = "apiappsecret")
    @JSONField(name = "apiappsecret")
    @JsonProperty("apiappsecret")
    private String apiappsecret;
    /**
     * 微信企业应用标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wxentappid",type=IdType.UUID)
    @JSONField(name = "wxentappid")
    @JsonProperty("wxentappid")
    private String wxentappid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * Token
     */
    @TableField(value = "apitoken")
    @JSONField(name = "apitoken")
    @JsonProperty("apitoken")
    private String apitoken;
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
     * 是否上报位置
     */
    @TableField(value = "replocationflag")
    @JSONField(name = "replocationflag")
    @JsonProperty("replocationflag")
    private Integer replocationflag;
    /**
     * 微信公众号
     */
    @TableField(exist = false)
    @JSONField(name = "wxaccountname")
    @JsonProperty("wxaccountname")
    private String wxaccountname;
    /**
     * 微信公众号
     */
    @TableField(value = "wxaccountid")
    @JSONField(name = "wxaccountid")
    @JsonProperty("wxaccountid")
    private String wxaccountid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wx.domain.WXAccount wxaccount;



    /**
     * 设置 [应用标识]
     */
    public void setAgentid(Integer agentid){
        this.agentid = agentid ;
        this.modify("agentid",agentid);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [微信企业应用名称]
     */
    public void setWxentappname(String wxentappname){
        this.wxentappname = wxentappname ;
        this.modify("wxentappname",wxentappname);
    }
    /**
     * 设置 [应用路径]
     */
    public void setAppurl(String appurl){
        this.appurl = appurl ;
        this.modify("appurl",appurl);
    }
    /**
     * 设置 [应用类型]
     */
    public void setApptype(String apptype){
        this.apptype = apptype ;
        this.modify("apptype",apptype);
    }
    /**
     * 设置 [APIENCODINGAESKEY]
     */
    public void setApiencodingaeskey(String apiencodingaeskey){
        this.apiencodingaeskey = apiencodingaeskey ;
        this.modify("apiencodingaeskey",apiencodingaeskey);
    }
    /**
     * 设置 [是否启用]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [是否进入应用]
     */
    public void setRepenterflag(Integer repenterflag){
        this.repenterflag = repenterflag ;
        this.modify("repenterflag",repenterflag);
    }
    /**
     * 设置 [API地址]
     */
    public void setApiurl(String apiurl){
        this.apiurl = apiurl ;
        this.modify("apiurl",apiurl);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [AppSecret]
     */
    public void setApiappsecret(String apiappsecret){
        this.apiappsecret = apiappsecret ;
        this.modify("apiappsecret",apiappsecret);
    }
    /**
     * 设置 [Token]
     */
    public void setApitoken(String apitoken){
        this.apitoken = apitoken ;
        this.modify("apitoken",apitoken);
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
     * 设置 [是否上报位置]
     */
    public void setReplocationflag(Integer replocationflag){
        this.replocationflag = replocationflag ;
        this.modify("replocationflag",replocationflag);
    }
    /**
     * 设置 [微信公众号]
     */
    public void setWxaccountid(String wxaccountid){
        this.wxaccountid = wxaccountid ;
        this.modify("wxaccountid",wxaccountid);
    }
}






