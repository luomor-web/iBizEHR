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
 * 实体[消息模板]
 */
@Data
@TableName(value = "T_MSGTEMPLATE",resultMap = "MsgTemplateResultMap")
public class MsgTemplate extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮件群组发送
     */
    @TableField(value = "mailgroupsend")
    @JSONField(name = "mailgroupsend")
    @JsonProperty("mailgroupsend")
    private Integer mailgroupsend;
    /**
     * 应用发布
     */
    @TableField(value = "srfuserpub")
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 消息模板标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "msgtemplateid",type=IdType.UUID)
    @JSONField(name = "msgtemplateid")
    @JsonProperty("msgtemplateid")
    private String msgtemplateid;
    /**
     * 微信内容
     */
    @TableField(value = "wccontent")
    @JSONField(name = "wccontent")
    @JsonProperty("wccontent")
    private String wccontent;
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
     * 消息模板名称
     */
    @TableField(value = "msgtemplatename")
    @JSONField(name = "msgtemplatename")
    @JsonProperty("msgtemplatename")
    private String msgtemplatename;
    /**
     * IM消息内容
     */
    @TableField(value = "imcontent")
    @JSONField(name = "imcontent")
    @JsonProperty("imcontent")
    private String imcontent;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 手机消息内容
     */
    @TableField(value = "smscontent")
    @JSONField(name = "smscontent")
    @JsonProperty("smscontent")
    private String smscontent;
    /**
     * 内容类型
     */
    @TableField(value = "contenttype")
    @JSONField(name = "contenttype")
    @JsonProperty("contenttype")
    private String contenttype;
    /**
     * 框架发布
     */
    @TableField(value = "srfsyspub")
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 标题
     */
    @TableField(value = "subject")
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;
    /**
     * 内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
    /**
     * 数据实体
     */
    @TableField(exist = false)
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 数据实体
     */
    @TableField(value = "deid")
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.DataEntity de;



    /**
     * 设置 [邮件群组发送]
     */
    public void setMailgroupsend(Integer mailgroupsend){
        this.mailgroupsend = mailgroupsend ;
        this.modify("mailgroupsend",mailgroupsend);
    }
    /**
     * 设置 [应用发布]
     */
    public void setSrfuserpub(Integer srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }
    /**
     * 设置 [微信内容]
     */
    public void setWccontent(String wccontent){
        this.wccontent = wccontent ;
        this.modify("wccontent",wccontent);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [消息模板名称]
     */
    public void setMsgtemplatename(String msgtemplatename){
        this.msgtemplatename = msgtemplatename ;
        this.modify("msgtemplatename",msgtemplatename);
    }
    /**
     * 设置 [IM消息内容]
     */
    public void setImcontent(String imcontent){
        this.imcontent = imcontent ;
        this.modify("imcontent",imcontent);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [手机消息内容]
     */
    public void setSmscontent(String smscontent){
        this.smscontent = smscontent ;
        this.modify("smscontent",smscontent);
    }
    /**
     * 设置 [内容类型]
     */
    public void setContenttype(String contenttype){
        this.contenttype = contenttype ;
        this.modify("contenttype",contenttype);
    }
    /**
     * 设置 [框架发布]
     */
    public void setSrfsyspub(Integer srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
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
     * 设置 [标题]
     */
    public void setSubject(String subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }
    /**
     * 设置 [内容]
     */
    public void setContent(String content){
        this.content = content ;
        this.modify("content",content);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDeid(String deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }

}


