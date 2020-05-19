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
 * 服务DTO对象[MsgTemplateDTO]
 */
@Data
public class MsgTemplateDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MAILGROUPSEND]
     *
     */
    @JSONField(name = "mailgroupsend")
    @JsonProperty("mailgroupsend")
    private Integer mailgroupsend;

    /**
     * 属性 [SRFUSERPUB]
     *
     */
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [MSGTEMPLATEID]
     *
     */
    @JSONField(name = "msgtemplateid")
    @JsonProperty("msgtemplateid")
    private String msgtemplateid;

    /**
     * 属性 [WCCONTENT]
     *
     */
    @JSONField(name = "wccontent")
    @JsonProperty("wccontent")
    private String wccontent;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [MSGTEMPLATENAME]
     *
     */
    @JSONField(name = "msgtemplatename")
    @JsonProperty("msgtemplatename")
    private String msgtemplatename;

    /**
     * 属性 [IMCONTENT]
     *
     */
    @JSONField(name = "imcontent")
    @JsonProperty("imcontent")
    private String imcontent;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [SMSCONTENT]
     *
     */
    @JSONField(name = "smscontent")
    @JsonProperty("smscontent")
    private String smscontent;

    /**
     * 属性 [CONTENTTYPE]
     *
     */
    @JSONField(name = "contenttype")
    @JsonProperty("contenttype")
    private String contenttype;

    /**
     * 属性 [SRFSYSPUB]
     *
     */
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SUBJECT]
     *
     */
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    /**
     * 属性 [DENAME]
     *
     */
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;

    /**
     * 属性 [DEID]
     *
     */
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;


    /**
     * 设置 [MAILGROUPSEND]
     */
    public void setMailgroupsend(Integer  mailgroupsend){
        this.mailgroupsend = mailgroupsend ;
        this.modify("mailgroupsend",mailgroupsend);
    }

    /**
     * 设置 [SRFUSERPUB]
     */
    public void setSrfuserpub(Integer  srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }

    /**
     * 设置 [WCCONTENT]
     */
    public void setWccontent(String  wccontent){
        this.wccontent = wccontent ;
        this.modify("wccontent",wccontent);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [MSGTEMPLATENAME]
     */
    public void setMsgtemplatename(String  msgtemplatename){
        this.msgtemplatename = msgtemplatename ;
        this.modify("msgtemplatename",msgtemplatename);
    }

    /**
     * 设置 [IMCONTENT]
     */
    public void setImcontent(String  imcontent){
        this.imcontent = imcontent ;
        this.modify("imcontent",imcontent);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [SMSCONTENT]
     */
    public void setSmscontent(String  smscontent){
        this.smscontent = smscontent ;
        this.modify("smscontent",smscontent);
    }

    /**
     * 设置 [CONTENTTYPE]
     */
    public void setContenttype(String  contenttype){
        this.contenttype = contenttype ;
        this.modify("contenttype",contenttype);
    }

    /**
     * 设置 [SRFSYSPUB]
     */
    public void setSrfsyspub(Integer  srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [SUBJECT]
     */
    public void setSubject(String  subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [DEID]
     */
    public void setDeid(String  deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }


}

