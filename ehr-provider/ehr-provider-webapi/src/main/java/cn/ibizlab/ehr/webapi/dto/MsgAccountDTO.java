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
 * 服务DTO对象[MsgAccountDTO]
 */
@Data
public class MsgAccountDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ISLIST]
     *
     */
    @JSONField(name = "islist")
    @JsonProperty("islist")
    private Integer islist;

    /**
     * 属性 [MSGACCOUNTID]
     *
     */
    @JSONField(name = "msgaccountid")
    @JsonProperty("msgaccountid")
    private String msgaccountid;

    /**
     * 属性 [MSGADDRESS]
     *
     */
    @JSONField(name = "msgaddress")
    @JsonProperty("msgaddress")
    private String msgaddress;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [FOLDERMODEL]
     *
     */
    @JSONField(name = "foldermodel")
    @JsonProperty("foldermodel")
    private String foldermodel;

    /**
     * 属性 [MSGACCOUNTNAME]
     *
     */
    @JSONField(name = "msgaccountname")
    @JsonProperty("msgaccountname")
    private String msgaccountname;

    /**
     * 属性 [WECHARADDR]
     *
     */
    @JSONField(name = "wecharaddr")
    @JsonProperty("wecharaddr")
    private String wecharaddr;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

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
     * 属性 [MSNEMAIL]
     *
     */
    @JSONField(name = "msnemail")
    @JsonProperty("msnemail")
    private String msnemail;

    /**
     * 属性 [WXADDR]
     *
     */
    @JSONField(name = "wxaddr")
    @JsonProperty("wxaddr")
    private String wxaddr;

    /**
     * 属性 [MOBILE]
     *
     */
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MAILADDRESS]
     *
     */
    @JSONField(name = "mailaddress")
    @JsonProperty("mailaddress")
    private String mailaddress;


    /**
     * 设置 [ISLIST]
     */
    public void setIslist(Integer  islist){
        this.islist = islist ;
        this.modify("islist",islist);
    }

    /**
     * 设置 [MSGADDRESS]
     */
    public void setMsgaddress(String  msgaddress){
        this.msgaddress = msgaddress ;
        this.modify("msgaddress",msgaddress);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [FOLDERMODEL]
     */
    public void setFoldermodel(String  foldermodel){
        this.foldermodel = foldermodel ;
        this.modify("foldermodel",foldermodel);
    }

    /**
     * 设置 [MSGACCOUNTNAME]
     */
    public void setMsgaccountname(String  msgaccountname){
        this.msgaccountname = msgaccountname ;
        this.modify("msgaccountname",msgaccountname);
    }

    /**
     * 设置 [WECHARADDR]
     */
    public void setWecharaddr(String  wecharaddr){
        this.wecharaddr = wecharaddr ;
        this.modify("wecharaddr",wecharaddr);
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
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [MSNEMAIL]
     */
    public void setMsnemail(String  msnemail){
        this.msnemail = msnemail ;
        this.modify("msnemail",msnemail);
    }

    /**
     * 设置 [WXADDR]
     */
    public void setWxaddr(String  wxaddr){
        this.wxaddr = wxaddr ;
        this.modify("wxaddr",wxaddr);
    }

    /**
     * 设置 [MOBILE]
     */
    public void setMobile(String  mobile){
        this.mobile = mobile ;
        this.modify("mobile",mobile);
    }

    /**
     * 设置 [MAILADDRESS]
     */
    public void setMailaddress(String  mailaddress){
        this.mailaddress = mailaddress ;
        this.modify("mailaddress",mailaddress);
    }


}

