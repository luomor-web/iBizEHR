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
 * 实体[微信消息]
 */
@Data
@TableName(value = "T_SRFWXMESSAGE",resultMap = "WXMessageResultMap")
public class WXMessage extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片路径
     */
    @TableField(value = "picurl")
    @JSONField(name = "picurl")
    @JsonProperty("picurl")
    private String picurl;
    /**
     * 微信消息名称
     */
    @TableField(value = "wxmessagename")
    @JSONField(name = "wxmessagename")
    @JsonProperty("wxmessagename")
    private String wxmessagename;
    /**
     * 输入内容数量
     */
    @TableField(value = "cnt")
    @JSONField(name = "cnt")
    @JsonProperty("cnt")
    private Integer cnt;
    /**
     * 消息类型
     */
    @TableField(value = "msgtype")
    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private String msgtype;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * ScanType
     */
    @TableField(value = "scantype")
    @JSONField(name = "scantype")
    @JsonProperty("scantype")
    private String scantype;
    /**
     * 反馈时间
     */
    @TableField(value = "resptime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "resptime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("resptime")
    private Timestamp resptime;
    /**
     * 返回图片消息媒体编号
     */
    @TableField(value = "respmediaid")
    @JSONField(name = "respmediaid")
    @JsonProperty("respmediaid")
    private String respmediaid;
    /**
     * 位置精度
     */
    @DEField(name = "location_prec")
    @TableField(value = "location_prec")
    @JSONField(name = "location_prec")
    @JsonProperty("location_prec")
    private Double locationPrec;
    /**
     * 结果内容
     */
    @TableField(value = "result")
    @JSONField(name = "result")
    @JsonProperty("result")
    private String result;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 地图缩放大小
     */
    @TableField(value = "scale")
    @JSONField(name = "scale")
    @JsonProperty("scale")
    private Integer scale;
    /**
     * 发送方帐号
     */
    @TableField(value = "fromusername")
    @JSONField(name = "fromusername")
    @JsonProperty("fromusername")
    private String fromusername;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 语音格式
     */
    @TableField(value = "format")
    @JSONField(name = "format")
    @JsonProperty("format")
    private String format;
    /**
     * 开发者微信号
     */
    @TableField(value = "tousername")
    @JSONField(name = "tousername")
    @JsonProperty("tousername")
    private String tousername;
    /**
     * 事件
     */
    @TableField(value = "event")
    @JSONField(name = "event")
    @JsonProperty("event")
    private String event;
    /**
     * 反馈的文章内容
     */
    @TableField(value = "resparticles")
    @JSONField(name = "resparticles")
    @JsonProperty("resparticles")
    private String resparticles;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 图片消息媒体编号
     */
    @TableField(value = "mediaid")
    @JSONField(name = "mediaid")
    @JsonProperty("mediaid")
    private String mediaid;
    /**
     * 进入时间
     */
    @TableField(value = "incometime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "incometime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("incometime")
    private Timestamp incometime;
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
     * 反馈消息类型
     */
    @TableField(value = "respmsgtype")
    @JSONField(name = "respmsgtype")
    @JsonProperty("respmsgtype")
    private String respmsgtype;
    /**
     * 返回描述
     */
    @TableField(value = "respdesc")
    @JSONField(name = "respdesc")
    @JsonProperty("respdesc")
    private String respdesc;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 微信消息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wxmessageid",type=IdType.UUID)
    @JSONField(name = "wxmessageid")
    @JsonProperty("wxmessageid")
    private String wxmessageid;
    /**
     * ScanCodeInfo
     */
    @TableField(value = "scancodeinfo")
    @JSONField(name = "scancodeinfo")
    @JsonProperty("scancodeinfo")
    private String scancodeinfo;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 返回标题
     */
    @TableField(value = "resptitle")
    @JSONField(name = "resptitle")
    @JsonProperty("resptitle")
    private String resptitle;
    /**
     * 地理位置经度
     */
    @DEField(name = "location_y")
    @TableField(value = "location_y")
    @JSONField(name = "location_y")
    @JsonProperty("location_y")
    private String locationY;
    /**
     * 文本消息内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
    /**
     * 地理位置维度
     */
    @DEField(name = "location_x")
    @TableField(value = "location_x")
    @JSONField(name = "location_x")
    @JsonProperty("location_x")
    private String locationX;
    /**
     * 视频消息缩略图的媒体编号
     */
    @TableField(value = "thumbmediaid")
    @JSONField(name = "thumbmediaid")
    @JsonProperty("thumbmediaid")
    private String thumbmediaid;
    /**
     * 反馈图文消息的数量
     */
    @TableField(value = "resparticlecount")
    @JSONField(name = "resparticlecount")
    @JsonProperty("resparticlecount")
    private Integer resparticlecount;
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
     * EventKey
     */
    @TableField(value = "eventkey")
    @JSONField(name = "eventkey")
    @JsonProperty("eventkey")
    private String eventkey;
    /**
     * 微信企业应用
     */
    @TableField(value = "wxentappname")
    @JSONField(name = "wxentappname")
    @JsonProperty("wxentappname")
    private String wxentappname;
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
     * 设置 [图片路径]
     */
    public void setPicurl(String picurl){
        this.picurl = picurl ;
        this.modify("picurl",picurl);
    }
    /**
     * 设置 [微信消息名称]
     */
    public void setWxmessagename(String wxmessagename){
        this.wxmessagename = wxmessagename ;
        this.modify("wxmessagename",wxmessagename);
    }
    /**
     * 设置 [输入内容数量]
     */
    public void setCnt(Integer cnt){
        this.cnt = cnt ;
        this.modify("cnt",cnt);
    }
    /**
     * 设置 [消息类型]
     */
    public void setMsgtype(String msgtype){
        this.msgtype = msgtype ;
        this.modify("msgtype",msgtype);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [ScanType]
     */
    public void setScantype(String scantype){
        this.scantype = scantype ;
        this.modify("scantype",scantype);
    }
    /**
     * 设置 [反馈时间]
     */
    public void setResptime(Timestamp resptime){
        this.resptime = resptime ;
        this.modify("resptime",resptime);
    }
    /**
     * 设置 [返回图片消息媒体编号]
     */
    public void setRespmediaid(String respmediaid){
        this.respmediaid = respmediaid ;
        this.modify("respmediaid",respmediaid);
    }
    /**
     * 设置 [位置精度]
     */
    public void setLocationPrec(Double locationPrec){
        this.locationPrec = locationPrec ;
        this.modify("location_prec",locationPrec);
    }
    /**
     * 设置 [结果内容]
     */
    public void setResult(String result){
        this.result = result ;
        this.modify("result",result);
    }
    /**
     * 设置 [地图缩放大小]
     */
    public void setScale(Integer scale){
        this.scale = scale ;
        this.modify("scale",scale);
    }
    /**
     * 设置 [发送方帐号]
     */
    public void setFromusername(String fromusername){
        this.fromusername = fromusername ;
        this.modify("fromusername",fromusername);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [语音格式]
     */
    public void setFormat(String format){
        this.format = format ;
        this.modify("format",format);
    }
    /**
     * 设置 [开发者微信号]
     */
    public void setTousername(String tousername){
        this.tousername = tousername ;
        this.modify("tousername",tousername);
    }
    /**
     * 设置 [事件]
     */
    public void setEvent(String event){
        this.event = event ;
        this.modify("event",event);
    }
    /**
     * 设置 [反馈的文章内容]
     */
    public void setResparticles(String resparticles){
        this.resparticles = resparticles ;
        this.modify("resparticles",resparticles);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [图片消息媒体编号]
     */
    public void setMediaid(String mediaid){
        this.mediaid = mediaid ;
        this.modify("mediaid",mediaid);
    }
    /**
     * 设置 [进入时间]
     */
    public void setIncometime(Timestamp incometime){
        this.incometime = incometime ;
        this.modify("incometime",incometime);
    }
    /**
     * 设置 [反馈消息类型]
     */
    public void setRespmsgtype(String respmsgtype){
        this.respmsgtype = respmsgtype ;
        this.modify("respmsgtype",respmsgtype);
    }
    /**
     * 设置 [返回描述]
     */
    public void setRespdesc(String respdesc){
        this.respdesc = respdesc ;
        this.modify("respdesc",respdesc);
    }
    /**
     * 设置 [ScanCodeInfo]
     */
    public void setScancodeinfo(String scancodeinfo){
        this.scancodeinfo = scancodeinfo ;
        this.modify("scancodeinfo",scancodeinfo);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [返回标题]
     */
    public void setResptitle(String resptitle){
        this.resptitle = resptitle ;
        this.modify("resptitle",resptitle);
    }
    /**
     * 设置 [地理位置经度]
     */
    public void setLocationY(String locationY){
        this.locationY = locationY ;
        this.modify("location_y",locationY);
    }
    /**
     * 设置 [文本消息内容]
     */
    public void setContent(String content){
        this.content = content ;
        this.modify("content",content);
    }
    /**
     * 设置 [地理位置维度]
     */
    public void setLocationX(String locationX){
        this.locationX = locationX ;
        this.modify("location_x",locationX);
    }
    /**
     * 设置 [视频消息缩略图的媒体编号]
     */
    public void setThumbmediaid(String thumbmediaid){
        this.thumbmediaid = thumbmediaid ;
        this.modify("thumbmediaid",thumbmediaid);
    }
    /**
     * 设置 [反馈图文消息的数量]
     */
    public void setResparticlecount(Integer resparticlecount){
        this.resparticlecount = resparticlecount ;
        this.modify("resparticlecount",resparticlecount);
    }
    /**
     * 设置 [EventKey]
     */
    public void setEventkey(String eventkey){
        this.eventkey = eventkey ;
        this.modify("eventkey",eventkey);
    }
    /**
     * 设置 [微信企业应用]
     */
    public void setWxentappname(String wxentappname){
        this.wxentappname = wxentappname ;
        this.modify("wxentappname",wxentappname);
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


