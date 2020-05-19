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
 * 服务DTO对象[WXMessageDTO]
 */
@Data
public class WXMessageDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PICURL]
     *
     */
    @JSONField(name = "picurl")
    @JsonProperty("picurl")
    private String picurl;

    /**
     * 属性 [WXMESSAGENAME]
     *
     */
    @JSONField(name = "wxmessagename")
    @JsonProperty("wxmessagename")
    private String wxmessagename;

    /**
     * 属性 [CNT]
     *
     */
    @JSONField(name = "cnt")
    @JsonProperty("cnt")
    private Integer cnt;

    /**
     * 属性 [MSGTYPE]
     *
     */
    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private String msgtype;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [SCANTYPE]
     *
     */
    @JSONField(name = "scantype")
    @JsonProperty("scantype")
    private String scantype;

    /**
     * 属性 [RESPTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "resptime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("resptime")
    private Timestamp resptime;

    /**
     * 属性 [RESPMEDIAID]
     *
     */
    @JSONField(name = "respmediaid")
    @JsonProperty("respmediaid")
    private String respmediaid;

    /**
     * 属性 [LOCATION_PREC]
     *
     */
    @JSONField(name = "location_prec")
    @JsonProperty("location_prec")
    private Double locationPrec;

    /**
     * 属性 [RESULT]
     *
     */
    @JSONField(name = "result")
    @JsonProperty("result")
    private String result;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SCALE]
     *
     */
    @JSONField(name = "scale")
    @JsonProperty("scale")
    private Integer scale;

    /**
     * 属性 [FROMUSERNAME]
     *
     */
    @JSONField(name = "fromusername")
    @JsonProperty("fromusername")
    private String fromusername;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [FORMAT]
     *
     */
    @JSONField(name = "format")
    @JsonProperty("format")
    private String format;

    /**
     * 属性 [TOUSERNAME]
     *
     */
    @JSONField(name = "tousername")
    @JsonProperty("tousername")
    private String tousername;

    /**
     * 属性 [EVENT]
     *
     */
    @JSONField(name = "event")
    @JsonProperty("event")
    private String event;

    /**
     * 属性 [RESPARTICLES]
     *
     */
    @JSONField(name = "resparticles")
    @JsonProperty("resparticles")
    private String resparticles;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [MEDIAID]
     *
     */
    @JSONField(name = "mediaid")
    @JsonProperty("mediaid")
    private String mediaid;

    /**
     * 属性 [INCOMETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "incometime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("incometime")
    private Timestamp incometime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [RESPMSGTYPE]
     *
     */
    @JSONField(name = "respmsgtype")
    @JsonProperty("respmsgtype")
    private String respmsgtype;

    /**
     * 属性 [RESPDESC]
     *
     */
    @JSONField(name = "respdesc")
    @JsonProperty("respdesc")
    private String respdesc;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WXMESSAGEID]
     *
     */
    @JSONField(name = "wxmessageid")
    @JsonProperty("wxmessageid")
    private String wxmessageid;

    /**
     * 属性 [SCANCODEINFO]
     *
     */
    @JSONField(name = "scancodeinfo")
    @JsonProperty("scancodeinfo")
    private String scancodeinfo;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [RESPTITLE]
     *
     */
    @JSONField(name = "resptitle")
    @JsonProperty("resptitle")
    private String resptitle;

    /**
     * 属性 [LOCATION_Y]
     *
     */
    @JSONField(name = "location_y")
    @JsonProperty("location_y")
    private String locationY;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    /**
     * 属性 [LOCATION_X]
     *
     */
    @JSONField(name = "location_x")
    @JsonProperty("location_x")
    private String locationX;

    /**
     * 属性 [THUMBMEDIAID]
     *
     */
    @JSONField(name = "thumbmediaid")
    @JsonProperty("thumbmediaid")
    private String thumbmediaid;

    /**
     * 属性 [RESPARTICLECOUNT]
     *
     */
    @JSONField(name = "resparticlecount")
    @JsonProperty("resparticlecount")
    private Integer resparticlecount;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [EVENTKEY]
     *
     */
    @JSONField(name = "eventkey")
    @JsonProperty("eventkey")
    private String eventkey;

    /**
     * 属性 [WXENTAPPNAME]
     *
     */
    @JSONField(name = "wxentappname")
    @JsonProperty("wxentappname")
    private String wxentappname;

    /**
     * 属性 [WXACCOUNTNAME]
     *
     */
    @JSONField(name = "wxaccountname")
    @JsonProperty("wxaccountname")
    private String wxaccountname;

    /**
     * 属性 [WXENTAPPID]
     *
     */
    @JSONField(name = "wxentappid")
    @JsonProperty("wxentappid")
    private String wxentappid;

    /**
     * 属性 [WXACCOUNTID]
     *
     */
    @JSONField(name = "wxaccountid")
    @JsonProperty("wxaccountid")
    private String wxaccountid;


    /**
     * 设置 [PICURL]
     */
    public void setPicurl(String  picurl){
        this.picurl = picurl ;
        this.modify("picurl",picurl);
    }

    /**
     * 设置 [WXMESSAGENAME]
     */
    public void setWxmessagename(String  wxmessagename){
        this.wxmessagename = wxmessagename ;
        this.modify("wxmessagename",wxmessagename);
    }

    /**
     * 设置 [CNT]
     */
    public void setCnt(Integer  cnt){
        this.cnt = cnt ;
        this.modify("cnt",cnt);
    }

    /**
     * 设置 [MSGTYPE]
     */
    public void setMsgtype(String  msgtype){
        this.msgtype = msgtype ;
        this.modify("msgtype",msgtype);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [SCANTYPE]
     */
    public void setScantype(String  scantype){
        this.scantype = scantype ;
        this.modify("scantype",scantype);
    }

    /**
     * 设置 [RESPTIME]
     */
    public void setResptime(Timestamp  resptime){
        this.resptime = resptime ;
        this.modify("resptime",resptime);
    }

    /**
     * 设置 [RESPMEDIAID]
     */
    public void setRespmediaid(String  respmediaid){
        this.respmediaid = respmediaid ;
        this.modify("respmediaid",respmediaid);
    }

    /**
     * 设置 [LOCATION_PREC]
     */
    public void setLocationPrec(Double  locationPrec){
        this.locationPrec = locationPrec ;
        this.modify("location_prec",locationPrec);
    }

    /**
     * 设置 [RESULT]
     */
    public void setResult(String  result){
        this.result = result ;
        this.modify("result",result);
    }

    /**
     * 设置 [SCALE]
     */
    public void setScale(Integer  scale){
        this.scale = scale ;
        this.modify("scale",scale);
    }

    /**
     * 设置 [FROMUSERNAME]
     */
    public void setFromusername(String  fromusername){
        this.fromusername = fromusername ;
        this.modify("fromusername",fromusername);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [FORMAT]
     */
    public void setFormat(String  format){
        this.format = format ;
        this.modify("format",format);
    }

    /**
     * 设置 [TOUSERNAME]
     */
    public void setTousername(String  tousername){
        this.tousername = tousername ;
        this.modify("tousername",tousername);
    }

    /**
     * 设置 [EVENT]
     */
    public void setEvent(String  event){
        this.event = event ;
        this.modify("event",event);
    }

    /**
     * 设置 [RESPARTICLES]
     */
    public void setResparticles(String  resparticles){
        this.resparticles = resparticles ;
        this.modify("resparticles",resparticles);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [MEDIAID]
     */
    public void setMediaid(String  mediaid){
        this.mediaid = mediaid ;
        this.modify("mediaid",mediaid);
    }

    /**
     * 设置 [INCOMETIME]
     */
    public void setIncometime(Timestamp  incometime){
        this.incometime = incometime ;
        this.modify("incometime",incometime);
    }

    /**
     * 设置 [RESPMSGTYPE]
     */
    public void setRespmsgtype(String  respmsgtype){
        this.respmsgtype = respmsgtype ;
        this.modify("respmsgtype",respmsgtype);
    }

    /**
     * 设置 [RESPDESC]
     */
    public void setRespdesc(String  respdesc){
        this.respdesc = respdesc ;
        this.modify("respdesc",respdesc);
    }

    /**
     * 设置 [SCANCODEINFO]
     */
    public void setScancodeinfo(String  scancodeinfo){
        this.scancodeinfo = scancodeinfo ;
        this.modify("scancodeinfo",scancodeinfo);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [RESPTITLE]
     */
    public void setResptitle(String  resptitle){
        this.resptitle = resptitle ;
        this.modify("resptitle",resptitle);
    }

    /**
     * 设置 [LOCATION_Y]
     */
    public void setLocationY(String  locationY){
        this.locationY = locationY ;
        this.modify("location_y",locationY);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [LOCATION_X]
     */
    public void setLocationX(String  locationX){
        this.locationX = locationX ;
        this.modify("location_x",locationX);
    }

    /**
     * 设置 [THUMBMEDIAID]
     */
    public void setThumbmediaid(String  thumbmediaid){
        this.thumbmediaid = thumbmediaid ;
        this.modify("thumbmediaid",thumbmediaid);
    }

    /**
     * 设置 [RESPARTICLECOUNT]
     */
    public void setResparticlecount(Integer  resparticlecount){
        this.resparticlecount = resparticlecount ;
        this.modify("resparticlecount",resparticlecount);
    }

    /**
     * 设置 [EVENTKEY]
     */
    public void setEventkey(String  eventkey){
        this.eventkey = eventkey ;
        this.modify("eventkey",eventkey);
    }

    /**
     * 设置 [WXENTAPPNAME]
     */
    public void setWxentappname(String  wxentappname){
        this.wxentappname = wxentappname ;
        this.modify("wxentappname",wxentappname);
    }

    /**
     * 设置 [WXACCOUNTNAME]
     */
    public void setWxaccountname(String  wxaccountname){
        this.wxaccountname = wxaccountname ;
        this.modify("wxaccountname",wxaccountname);
    }

    /**
     * 设置 [WXENTAPPID]
     */
    public void setWxentappid(String  wxentappid){
        this.wxentappid = wxentappid ;
        this.modify("wxentappid",wxentappid);
    }

    /**
     * 设置 [WXACCOUNTID]
     */
    public void setWxaccountid(String  wxaccountid){
        this.wxaccountid = wxaccountid ;
        this.modify("wxaccountid",wxaccountid);
    }


}

