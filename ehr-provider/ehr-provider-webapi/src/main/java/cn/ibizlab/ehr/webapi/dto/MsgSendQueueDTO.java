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
 * 服务DTO对象[MsgSendQueueDTO]
 */
@Data
public class MsgSendQueueDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SUBJECT]
     *
     */
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [SENDTAG]
     *
     */
    @JSONField(name = "sendtag")
    @JsonProperty("sendtag")
    private String sendtag;

    /**
     * 属性 [USERDATA3]
     *
     */
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;

    /**
     * 属性 [ISERROR]
     *
     */
    @JSONField(name = "iserror")
    @JsonProperty("iserror")
    private Integer iserror;

    /**
     * 属性 [FILEAT]
     *
     */
    @JSONField(name = "fileat")
    @JsonProperty("fileat")
    private String fileat;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [MSGTYPE]
     *
     */
    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private Integer msgtype;

    /**
     * 属性 [FILEAT3]
     *
     */
    @JSONField(name = "fileat3")
    @JsonProperty("fileat3")
    private String fileat3;

    /**
     * 属性 [CONTENTTYPE]
     *
     */
    @JSONField(name = "contenttype")
    @JsonProperty("contenttype")
    private String contenttype;

    /**
     * 属性 [FILEAT2]
     *
     */
    @JSONField(name = "fileat2")
    @JsonProperty("fileat2")
    private String fileat2;

    /**
     * 属性 [IMPORTANCEFLAG]
     *
     */
    @JSONField(name = "importanceflag")
    @JsonProperty("importanceflag")
    private Integer importanceflag;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FILEAT4]
     *
     */
    @JSONField(name = "fileat4")
    @JsonProperty("fileat4")
    private String fileat4;

    /**
     * 属性 [DSTADDRESSES]
     *
     */
    @JSONField(name = "dstaddresses")
    @JsonProperty("dstaddresses")
    private String dstaddresses;

    /**
     * 属性 [DSTUSERS]
     *
     */
    @JSONField(name = "dstusers")
    @JsonProperty("dstusers")
    private String dstusers;

    /**
     * 属性 [PLANSENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "plansendtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plansendtime")
    private Timestamp plansendtime;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ERRORINFO]
     *
     */
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;

    /**
     * 属性 [TOTALDSTADDRESSES]
     *
     */
    @JSONField(name = "totaldstaddresses")
    @JsonProperty("totaldstaddresses")
    private String totaldstaddresses;

    /**
     * 属性 [ISSEND]
     *
     */
    @JSONField(name = "issend")
    @JsonProperty("issend")
    private Integer issend;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    /**
     * 属性 [MSGSENDQUEUENAME]
     *
     */
    @JSONField(name = "msgsendqueuename")
    @JsonProperty("msgsendqueuename")
    private String msgsendqueuename;

    /**
     * 属性 [MSGSENDQUEUEID]
     *
     */
    @JSONField(name = "msgsendqueueid")
    @JsonProperty("msgsendqueueid")
    private String msgsendqueueid;

    /**
     * 属性 [PROCESSTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "processtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("processtime")
    private Timestamp processtime;

    /**
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;


    /**
     * 设置 [SUBJECT]
     */
    public void setSubject(String  subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [SENDTAG]
     */
    public void setSendtag(String  sendtag){
        this.sendtag = sendtag ;
        this.modify("sendtag",sendtag);
    }

    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String  userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }

    /**
     * 设置 [ISERROR]
     */
    public void setIserror(Integer  iserror){
        this.iserror = iserror ;
        this.modify("iserror",iserror);
    }

    /**
     * 设置 [FILEAT]
     */
    public void setFileat(String  fileat){
        this.fileat = fileat ;
        this.modify("fileat",fileat);
    }

    /**
     * 设置 [MSGTYPE]
     */
    public void setMsgtype(Integer  msgtype){
        this.msgtype = msgtype ;
        this.modify("msgtype",msgtype);
    }

    /**
     * 设置 [FILEAT3]
     */
    public void setFileat3(String  fileat3){
        this.fileat3 = fileat3 ;
        this.modify("fileat3",fileat3);
    }

    /**
     * 设置 [CONTENTTYPE]
     */
    public void setContenttype(String  contenttype){
        this.contenttype = contenttype ;
        this.modify("contenttype",contenttype);
    }

    /**
     * 设置 [FILEAT2]
     */
    public void setFileat2(String  fileat2){
        this.fileat2 = fileat2 ;
        this.modify("fileat2",fileat2);
    }

    /**
     * 设置 [IMPORTANCEFLAG]
     */
    public void setImportanceflag(Integer  importanceflag){
        this.importanceflag = importanceflag ;
        this.modify("importanceflag",importanceflag);
    }

    /**
     * 设置 [FILEAT4]
     */
    public void setFileat4(String  fileat4){
        this.fileat4 = fileat4 ;
        this.modify("fileat4",fileat4);
    }

    /**
     * 设置 [DSTADDRESSES]
     */
    public void setDstaddresses(String  dstaddresses){
        this.dstaddresses = dstaddresses ;
        this.modify("dstaddresses",dstaddresses);
    }

    /**
     * 设置 [DSTUSERS]
     */
    public void setDstusers(String  dstusers){
        this.dstusers = dstusers ;
        this.modify("dstusers",dstusers);
    }

    /**
     * 设置 [PLANSENDTIME]
     */
    public void setPlansendtime(Timestamp  plansendtime){
        this.plansendtime = plansendtime ;
        this.modify("plansendtime",plansendtime);
    }

    /**
     * 设置 [ERRORINFO]
     */
    public void setErrorinfo(String  errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }

    /**
     * 设置 [TOTALDSTADDRESSES]
     */
    public void setTotaldstaddresses(String  totaldstaddresses){
        this.totaldstaddresses = totaldstaddresses ;
        this.modify("totaldstaddresses",totaldstaddresses);
    }

    /**
     * 设置 [ISSEND]
     */
    public void setIssend(Integer  issend){
        this.issend = issend ;
        this.modify("issend",issend);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [MSGSENDQUEUENAME]
     */
    public void setMsgsendqueuename(String  msgsendqueuename){
        this.msgsendqueuename = msgsendqueuename ;
        this.modify("msgsendqueuename",msgsendqueuename);
    }

    /**
     * 设置 [PROCESSTIME]
     */
    public void setProcesstime(Timestamp  processtime){
        this.processtime = processtime ;
        this.modify("processtime",processtime);
    }

    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String  userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }


}

