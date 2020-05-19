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
 * 实体[微信多媒体内容]
 */
@Data
@TableName(value = "T_SRFWXMEDIA",resultMap = "WXMediaResultMap")
public class WXMedia extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 微信多媒体内容名称
     */
    @TableField(value = "wxmedianame")
    @JSONField(name = "wxmedianame")
    @JsonProperty("wxmedianame")
    private String wxmedianame;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 微信多媒体内容标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wxmediaid",type=IdType.UUID)
    @JSONField(name = "wxmediaid")
    @JsonProperty("wxmediaid")
    private String wxmediaid;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 微信公众号
     */
    @TableField(value = "wxaccountname")
    @JSONField(name = "wxaccountname")
    @JsonProperty("wxaccountname")
    private String wxaccountname;
    /**
     * 微信企业应用
     */
    @TableField(value = "wxentappname")
    @JSONField(name = "wxentappname")
    @JsonProperty("wxentappname")
    private String wxentappname;
    /**
     * 微信企业应用
     */
    @TableField(value = "wxentappid")
    @JSONField(name = "wxentappid")
    @JsonProperty("wxentappid")
    private String wxentappid;
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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wx.domain.WXEntApp wxentapp;



    /**
     * 设置 [微信多媒体内容名称]
     */
    public void setWxmedianame(String wxmedianame){
        this.wxmedianame = wxmedianame ;
        this.modify("wxmedianame",wxmedianame);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
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
     * 设置 [微信企业应用]
     */
    public void setWxentappname(String wxentappname){
        this.wxentappname = wxentappname ;
        this.modify("wxentappname",wxentappname);
    }
    /**
     * 设置 [微信企业应用]
     */
    public void setWxentappid(String wxentappid){
        this.wxentappid = wxentappid ;
        this.modify("wxentappid",wxentappid);
    }
    /**
     * 设置 [微信公众号]
     */
    public void setWxaccountid(String wxaccountid){
        this.wxaccountid = wxaccountid ;
        this.modify("wxaccountid",wxaccountid);
    }

}


