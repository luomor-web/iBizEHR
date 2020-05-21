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
 * 实体[微信访问票据]
 */
@Data
@TableName(value = "T_WXACCESSTOKEN",resultMap = "WXAccessTokenResultMap")
public class WXAccessToken extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信访问票据名称
     */
    @TableField(value = "wxaccesstokenname")
    @JSONField(name = "wxaccesstokenname")
    @JsonProperty("wxaccesstokenname")
    private String wxaccesstokenname;
    /**
     * 票据
     */
    @TableField(value = "accesstoken")
    @JSONField(name = "accesstoken")
    @JsonProperty("accesstoken")
    private String accesstoken;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 微信访问票据标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wxaccesstokenid",type=IdType.UUID)
    @JSONField(name = "wxaccesstokenid")
    @JsonProperty("wxaccesstokenid")
    private String wxaccesstokenid;
    /**
     * 过期时间
     */
    @TableField(value = "expiredtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "expiredtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expiredtime")
    private Timestamp expiredtime;
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
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
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
     * 微信公众号
     */
    @TableField(value = "wxaccountname")
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
     * 设置 [微信访问票据名称]
     */
    public void setWxaccesstokenname(String wxaccesstokenname){
        this.wxaccesstokenname = wxaccesstokenname ;
        this.modify("wxaccesstokenname",wxaccesstokenname);
    }
    /**
     * 设置 [票据]
     */
    public void setAccesstoken(String accesstoken){
        this.accesstoken = accesstoken ;
        this.modify("accesstoken",accesstoken);
    }
    /**
     * 设置 [过期时间]
     */
    public void setExpiredtime(Timestamp expiredtime){
        this.expiredtime = expiredtime ;
        this.modify("expiredtime",expiredtime);
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
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [微信公众号]
     */
    public void setWxaccountname(String wxaccountname){
        this.wxaccountname = wxaccountname ;
        this.modify("wxaccountname",wxaccountname);
    }
    /**
     * 设置 [微信公众号]
     */
    public void setWxaccountid(String wxaccountid){
        this.wxaccountid = wxaccountid ;
        this.modify("wxaccountid",wxaccountid);
    }

}


