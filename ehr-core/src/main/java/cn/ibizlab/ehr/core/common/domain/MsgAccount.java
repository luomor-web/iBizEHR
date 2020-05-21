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
 * 实体[消息账户]
 */
@Data
@TableName(value = "T_MSGACCOUNT",resultMap = "MsgAccountResultMap")
public class MsgAccount extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息账户组
     */
    @TableField(value = "islist")
    @JSONField(name = "islist")
    @JsonProperty("islist")
    private Integer islist;
    /**
     * 消息账户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "msgaccountid",type=IdType.UUID)
    @JSONField(name = "msgaccountid")
    @JsonProperty("msgaccountid")
    private String msgaccountid;
    /**
     * 地址
     */
    @TableField(value = "msgaddress")
    @JSONField(name = "msgaddress")
    @JsonProperty("msgaddress")
    private String msgaddress;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 目录模型
     */
    @TableField(value = "foldermodel")
    @JSONField(name = "foldermodel")
    @JsonProperty("foldermodel")
    private String foldermodel;
    /**
     * 消息账户名称
     */
    @TableField(value = "msgaccountname")
    @JSONField(name = "msgaccountname")
    @JsonProperty("msgaccountname")
    private String msgaccountname;
    /**
     * 微信地址
     */
    @TableField(value = "wecharaddr")
    @JSONField(name = "wecharaddr")
    @JsonProperty("wecharaddr")
    private String wecharaddr;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
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
     * MSN邮件地址
     */
    @TableField(value = "msnemail")
    @JSONField(name = "msnemail")
    @JsonProperty("msnemail")
    private String msnemail;
    /**
     * 微信地址
     */
    @TableField(value = "wxaddr")
    @JSONField(name = "wxaddr")
    @JsonProperty("wxaddr")
    private String wxaddr;
    /**
     * 移动电话
     */
    @TableField(value = "mobile")
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 邮件地址
     */
    @TableField(value = "mailaddress")
    @JSONField(name = "mailaddress")
    @JsonProperty("mailaddress")
    private String mailaddress;



    /**
     * 设置 [消息账户组]
     */
    public void setIslist(Integer islist){
        this.islist = islist ;
        this.modify("islist",islist);
    }
    /**
     * 设置 [地址]
     */
    public void setMsgaddress(String msgaddress){
        this.msgaddress = msgaddress ;
        this.modify("msgaddress",msgaddress);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [目录模型]
     */
    public void setFoldermodel(String foldermodel){
        this.foldermodel = foldermodel ;
        this.modify("foldermodel",foldermodel);
    }
    /**
     * 设置 [消息账户名称]
     */
    public void setMsgaccountname(String msgaccountname){
        this.msgaccountname = msgaccountname ;
        this.modify("msgaccountname",msgaccountname);
    }
    /**
     * 设置 [微信地址]
     */
    public void setWecharaddr(String wecharaddr){
        this.wecharaddr = wecharaddr ;
        this.modify("wecharaddr",wecharaddr);
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
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [MSN邮件地址]
     */
    public void setMsnemail(String msnemail){
        this.msnemail = msnemail ;
        this.modify("msnemail",msnemail);
    }
    /**
     * 设置 [微信地址]
     */
    public void setWxaddr(String wxaddr){
        this.wxaddr = wxaddr ;
        this.modify("wxaddr",wxaddr);
    }
    /**
     * 设置 [移动电话]
     */
    public void setMobile(String mobile){
        this.mobile = mobile ;
        this.modify("mobile",mobile);
    }
    /**
     * 设置 [邮件地址]
     */
    public void setMailaddress(String mailaddress){
        this.mailaddress = mailaddress ;
        this.modify("mailaddress",mailaddress);
    }

}


