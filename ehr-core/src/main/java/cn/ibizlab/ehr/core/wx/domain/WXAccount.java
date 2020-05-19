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
 * 实体[微信公众号]
 */
@Data
@TableName(value = "T_SRFWXACCOUNT",resultMap = "WXAccountResultMap")
public class WXAccount extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否启用
     */
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
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
     * 微信公众号名称
     */
    @TableField(value = "wxaccountname")
    @JSONField(name = "wxaccountname")
    @JsonProperty("wxaccountname")
    private String wxaccountname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * AppId
     */
    @TableField(value = "apiappid")
    @JSONField(name = "apiappid")
    @JsonProperty("apiappid")
    private String apiappid;
    /**
     * 微信公众号标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wxaccountid",type=IdType.UUID)
    @JSONField(name = "wxaccountid")
    @JsonProperty("wxaccountid")
    private String wxaccountid;
    /**
     * AppSecret
     */
    @TableField(value = "apiappsecret")
    @JSONField(name = "apiappsecret")
    @JsonProperty("apiappsecret")
    private String apiappsecret;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
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
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * Token
     */
    @TableField(value = "apitoken")
    @JSONField(name = "apitoken")
    @JsonProperty("apitoken")
    private String apitoken;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * API地址
     */
    @TableField(value = "apiurl")
    @JSONField(name = "apiurl")
    @JsonProperty("apiurl")
    private String apiurl;
    /**
     * 机构
     */
    @TableField(exist = false)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 机构
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.Org org;



    /**
     * 设置 [是否启用]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [微信公众号名称]
     */
    public void setWxaccountname(String wxaccountname){
        this.wxaccountname = wxaccountname ;
        this.modify("wxaccountname",wxaccountname);
    }
    /**
     * 设置 [AppId]
     */
    public void setApiappid(String apiappid){
        this.apiappid = apiappid ;
        this.modify("apiappid",apiappid);
    }
    /**
     * 设置 [AppSecret]
     */
    public void setApiappsecret(String apiappsecret){
        this.apiappsecret = apiappsecret ;
        this.modify("apiappsecret",apiappsecret);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [Token]
     */
    public void setApitoken(String apitoken){
        this.apitoken = apitoken ;
        this.modify("apitoken",apitoken);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [API地址]
     */
    public void setApiurl(String apiurl){
        this.apiurl = apiurl ;
        this.modify("apiurl",apiurl);
    }

}


