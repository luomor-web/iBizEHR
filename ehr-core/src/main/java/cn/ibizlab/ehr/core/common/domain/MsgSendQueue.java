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
 * 实体[消息发送队列]
 */
@Data
@TableName(value = "T_MSGSENDQUEUE",resultMap = "MsgSendQueueResultMap")
public class MsgSendQueue extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息标题
     */
    @TableField(value = "subject")
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 发送者标识
     */
    @TableField(value = "sendtag")
    @JSONField(name = "sendtag")
    @JsonProperty("sendtag")
    private String sendtag;
    /**
     * 用户数据3
     */
    @TableField(value = "userdata3")
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;
    /**
     * 处理错误
     */
    @TableField(value = "iserror")
    @JSONField(name = "iserror")
    @JsonProperty("iserror")
    private Integer iserror;
    /**
     * 文件附件
     */
    @TableField(value = "fileat")
    @JSONField(name = "fileat")
    @JsonProperty("fileat")
    private String fileat;
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
     * 消息类型
     */
    @TableField(value = "msgtype")
    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private Integer msgtype;
    /**
     * 文件附件3
     */
    @TableField(value = "fileat3")
    @JSONField(name = "fileat3")
    @JsonProperty("fileat3")
    private String fileat3;
    /**
     * 内容类型
     */
    @TableField(value = "contenttype")
    @JSONField(name = "contenttype")
    @JsonProperty("contenttype")
    private String contenttype;
    /**
     * 文件附件2
     */
    @TableField(value = "fileat2")
    @JSONField(name = "fileat2")
    @JsonProperty("fileat2")
    private String fileat2;
    /**
     * 重要程度
     */
    @TableField(value = "importanceflag")
    @JSONField(name = "importanceflag")
    @JsonProperty("importanceflag")
    private Integer importanceflag;
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
     * 文件附件4
     */
    @TableField(value = "fileat4")
    @JSONField(name = "fileat4")
    @JsonProperty("fileat4")
    private String fileat4;
    /**
     * 目标地址
     */
    @TableField(value = "dstaddresses")
    @JSONField(name = "dstaddresses")
    @JsonProperty("dstaddresses")
    private String dstaddresses;
    /**
     * 目标用户
     */
    @TableField(value = "dstusers")
    @JSONField(name = "dstusers")
    @JsonProperty("dstusers")
    private String dstusers;
    /**
     * 计划发送时间
     */
    @TableField(value = "plansendtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "plansendtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plansendtime")
    private Timestamp plansendtime;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 错误信息
     */
    @TableField(value = "errorinfo")
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;
    /**
     * 全部地址
     */
    @TableField(value = "totaldstaddresses")
    @JSONField(name = "totaldstaddresses")
    @JsonProperty("totaldstaddresses")
    private String totaldstaddresses;
    /**
     * 是否发送
     */
    @TableField(value = "issend")
    @JSONField(name = "issend")
    @JsonProperty("issend")
    private Integer issend;
    /**
     * 消息内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
    /**
     * 消息发送队列名称
     */
    @DEField(defaultValue = "消息发送队列")
    @TableField(value = "msgsendqueuename")
    @JSONField(name = "msgsendqueuename")
    @JsonProperty("msgsendqueuename")
    private String msgsendqueuename;
    /**
     * 消息发送队列标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "msgsendqueueid",type=IdType.UUID)
    @JSONField(name = "msgsendqueueid")
    @JsonProperty("msgsendqueueid")
    private String msgsendqueueid;
    /**
     * 处理时间
     */
    @TableField(value = "processtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "processtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("processtime")
    private Timestamp processtime;
    /**
     * 用户数据4
     */
    @TableField(value = "userdata4")
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;



    /**
     * 设置 [消息标题]
     */
    public void setSubject(String subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [发送者标识]
     */
    public void setSendtag(String sendtag){
        this.sendtag = sendtag ;
        this.modify("sendtag",sendtag);
    }
    /**
     * 设置 [用户数据3]
     */
    public void setUserdata3(String userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }
    /**
     * 设置 [处理错误]
     */
    public void setIserror(Integer iserror){
        this.iserror = iserror ;
        this.modify("iserror",iserror);
    }
    /**
     * 设置 [文件附件]
     */
    public void setFileat(String fileat){
        this.fileat = fileat ;
        this.modify("fileat",fileat);
    }
    /**
     * 设置 [消息类型]
     */
    public void setMsgtype(Integer msgtype){
        this.msgtype = msgtype ;
        this.modify("msgtype",msgtype);
    }
    /**
     * 设置 [文件附件3]
     */
    public void setFileat3(String fileat3){
        this.fileat3 = fileat3 ;
        this.modify("fileat3",fileat3);
    }
    /**
     * 设置 [内容类型]
     */
    public void setContenttype(String contenttype){
        this.contenttype = contenttype ;
        this.modify("contenttype",contenttype);
    }
    /**
     * 设置 [文件附件2]
     */
    public void setFileat2(String fileat2){
        this.fileat2 = fileat2 ;
        this.modify("fileat2",fileat2);
    }
    /**
     * 设置 [重要程度]
     */
    public void setImportanceflag(Integer importanceflag){
        this.importanceflag = importanceflag ;
        this.modify("importanceflag",importanceflag);
    }
    /**
     * 设置 [文件附件4]
     */
    public void setFileat4(String fileat4){
        this.fileat4 = fileat4 ;
        this.modify("fileat4",fileat4);
    }
    /**
     * 设置 [目标地址]
     */
    public void setDstaddresses(String dstaddresses){
        this.dstaddresses = dstaddresses ;
        this.modify("dstaddresses",dstaddresses);
    }
    /**
     * 设置 [目标用户]
     */
    public void setDstusers(String dstusers){
        this.dstusers = dstusers ;
        this.modify("dstusers",dstusers);
    }
    /**
     * 设置 [计划发送时间]
     */
    public void setPlansendtime(Timestamp plansendtime){
        this.plansendtime = plansendtime ;
        this.modify("plansendtime",plansendtime);
    }
    /**
     * 设置 [错误信息]
     */
    public void setErrorinfo(String errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }
    /**
     * 设置 [全部地址]
     */
    public void setTotaldstaddresses(String totaldstaddresses){
        this.totaldstaddresses = totaldstaddresses ;
        this.modify("totaldstaddresses",totaldstaddresses);
    }
    /**
     * 设置 [是否发送]
     */
    public void setIssend(Integer issend){
        this.issend = issend ;
        this.modify("issend",issend);
    }
    /**
     * 设置 [消息内容]
     */
    public void setContent(String content){
        this.content = content ;
        this.modify("content",content);
    }
    /**
     * 设置 [消息发送队列名称]
     */
    public void setMsgsendqueuename(String msgsendqueuename){
        this.msgsendqueuename = msgsendqueuename ;
        this.modify("msgsendqueuename",msgsendqueuename);
    }
    /**
     * 设置 [处理时间]
     */
    public void setProcesstime(Timestamp processtime){
        this.processtime = processtime ;
        this.modify("processtime",processtime);
    }
    /**
     * 设置 [用户数据4]
     */
    public void setUserdata4(String userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

}


