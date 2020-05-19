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
 * 服务DTO对象[WFStepDataDTO]
 */
@Data
public class WFStepDataDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFSTEPDATAID]
     *
     */
    @JSONField(name = "wfstepdataid")
    @JsonProperty("wfstepdataid")
    private String wfstepdataid;

    /**
     * 属性 [SDPARAM2]
     *
     */
    @JSONField(name = "sdparam2")
    @JsonProperty("sdparam2")
    private String sdparam2;

    /**
     * 属性 [ACTORNAME2]
     *
     */
    @JSONField(name = "actorname2")
    @JsonProperty("actorname2")
    private String actorname2;

    /**
     * 属性 [SDPARAM]
     *
     */
    @JSONField(name = "sdparam")
    @JsonProperty("sdparam")
    private String sdparam;

    /**
     * 属性 [WFSTEPLANRESTAG]
     *
     */
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;

    /**
     * 属性 [ACTORNAME]
     *
     */
    @JSONField(name = "actorname")
    @JsonProperty("actorname")
    private String actorname;

    /**
     * 属性 [ACTIONTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "actiontime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("actiontime")
    private Timestamp actiontime;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [NEXTTO]
     *
     */
    @JSONField(name = "nextto")
    @JsonProperty("nextto")
    private String nextto;

    /**
     * 属性 [ACTORID]
     *
     */
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFACTIONLANRESTAG]
     *
     */
    @JSONField(name = "wfactionlanrestag")
    @JsonProperty("wfactionlanrestag")
    private String wfactionlanrestag;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFSTEPDATANAME]
     *
     */
    @JSONField(name = "wfstepdataname")
    @JsonProperty("wfstepdataname")
    private String wfstepdataname;

    /**
     * 属性 [CONNECTIONNAME]
     *
     */
    @JSONField(name = "connectionname")
    @JsonProperty("connectionname")
    private String connectionname;

    /**
     * 属性 [ORIGINALWFUSERNAME]
     *
     */
    @JSONField(name = "originalwfusername")
    @JsonProperty("originalwfusername")
    private String originalwfusername;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [WFPLOGICNAME]
     *
     */
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [USERDATADESC]
     *
     */
    @JSONField(name = "userdatadesc")
    @JsonProperty("userdatadesc")
    private String userdatadesc;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [ORIGINALWFUSERID]
     *
     */
    @JSONField(name = "originalwfuserid")
    @JsonProperty("originalwfuserid")
    private String originalwfuserid;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;


    /**
     * 设置 [SDPARAM2]
     */
    public void setSdparam2(String  sdparam2){
        this.sdparam2 = sdparam2 ;
        this.modify("sdparam2",sdparam2);
    }

    /**
     * 设置 [ACTORNAME2]
     */
    public void setActorname2(String  actorname2){
        this.actorname2 = actorname2 ;
        this.modify("actorname2",actorname2);
    }

    /**
     * 设置 [SDPARAM]
     */
    public void setSdparam(String  sdparam){
        this.sdparam = sdparam ;
        this.modify("sdparam",sdparam);
    }

    /**
     * 设置 [WFSTEPLANRESTAG]
     */
    public void setWfsteplanrestag(String  wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }

    /**
     * 设置 [ACTORNAME]
     */
    public void setActorname(String  actorname){
        this.actorname = actorname ;
        this.modify("actorname",actorname);
    }

    /**
     * 设置 [NEXTTO]
     */
    public void setNextto(String  nextto){
        this.nextto = nextto ;
        this.modify("nextto",nextto);
    }

    /**
     * 设置 [ACTORID]
     */
    public void setActorid(String  actorid){
        this.actorid = actorid ;
        this.modify("actorid",actorid);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [WFACTIONLANRESTAG]
     */
    public void setWfactionlanrestag(String  wfactionlanrestag){
        this.wfactionlanrestag = wfactionlanrestag ;
        this.modify("wfactionlanrestag",wfactionlanrestag);
    }

    /**
     * 设置 [WFSTEPDATANAME]
     */
    public void setWfstepdataname(String  wfstepdataname){
        this.wfstepdataname = wfstepdataname ;
        this.modify("wfstepdataname",wfstepdataname);
    }

    /**
     * 设置 [CONNECTIONNAME]
     */
    public void setConnectionname(String  connectionname){
        this.connectionname = connectionname ;
        this.modify("connectionname",connectionname);
    }

    /**
     * 设置 [ORIGINALWFUSERNAME]
     */
    public void setOriginalwfusername(String  originalwfusername){
        this.originalwfusername = originalwfusername ;
        this.modify("originalwfusername",originalwfusername);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [WFPLOGICNAME]
     */
    public void setWfplogicname(String  wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }

    /**
     * 设置 [WFINSTANCENAME]
     */
    public void setWfinstancename(String  wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }

    /**
     * 设置 [USERDATADESC]
     */
    public void setUserdatadesc(String  userdatadesc){
        this.userdatadesc = userdatadesc ;
        this.modify("userdatadesc",userdatadesc);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [ORIGINALWFUSERID]
     */
    public void setOriginalwfuserid(String  originalwfuserid){
        this.originalwfuserid = originalwfuserid ;
        this.modify("originalwfuserid",originalwfuserid);
    }

    /**
     * 设置 [WFSTEPID]
     */
    public void setWfstepid(String  wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }


}

