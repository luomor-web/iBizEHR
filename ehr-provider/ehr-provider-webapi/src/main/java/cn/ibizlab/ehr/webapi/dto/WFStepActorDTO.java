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
 * 服务DTO对象[WFStepActorDTO]
 */
@Data
public class WFStepActorDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ACTORTYPE]
     *
     */
    @JSONField(name = "actortype")
    @JsonProperty("actortype")
    private Integer actortype;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFSTEPACTORID]
     *
     */
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;

    /**
     * 属性 [FIRSTREADTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "firstreadtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("firstreadtime")
    private Timestamp firstreadtime;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [READFLAG]
     *
     */
    @JSONField(name = "readflag")
    @JsonProperty("readflag")
    private Integer readflag;

    /**
     * 属性 [WFSTEPACTORNAME]
     *
     */
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISFINISH]
     *
     */
    @JSONField(name = "isfinish")
    @JsonProperty("isfinish")
    private Integer isfinish;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [IAACTIONS]
     *
     */
    @JSONField(name = "iaactions")
    @JsonProperty("iaactions")
    private String iaactions;

    /**
     * 属性 [ISREADONLY]
     *
     */
    @JSONField(name = "isreadonly")
    @JsonProperty("isreadonly")
    private Integer isreadonly;

    /**
     * 属性 [ACTORID]
     *
     */
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;

    /**
     * 属性 [ROLEID]
     *
     */
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    private String roleid;

    /**
     * 属性 [REMINDERCOUNT]
     *
     */
    @JSONField(name = "remindercount")
    @JsonProperty("remindercount")
    private Integer remindercount;

    /**
     * 属性 [FINISHDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "finishdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("finishdate")
    private Timestamp finishdate;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [ORIGINALWFUSERNAME]
     *
     */
    @JSONField(name = "originalwfusername")
    @JsonProperty("originalwfusername")
    private String originalwfusername;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;

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
     * 设置 [ACTORTYPE]
     */
    public void setActortype(Integer  actortype){
        this.actortype = actortype ;
        this.modify("actortype",actortype);
    }

    /**
     * 设置 [FIRSTREADTIME]
     */
    public void setFirstreadtime(Timestamp  firstreadtime){
        this.firstreadtime = firstreadtime ;
        this.modify("firstreadtime",firstreadtime);
    }

    /**
     * 设置 [READFLAG]
     */
    public void setReadflag(Integer  readflag){
        this.readflag = readflag ;
        this.modify("readflag",readflag);
    }

    /**
     * 设置 [WFSTEPACTORNAME]
     */
    public void setWfstepactorname(String  wfstepactorname){
        this.wfstepactorname = wfstepactorname ;
        this.modify("wfstepactorname",wfstepactorname);
    }

    /**
     * 设置 [ISFINISH]
     */
    public void setIsfinish(Integer  isfinish){
        this.isfinish = isfinish ;
        this.modify("isfinish",isfinish);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [IAACTIONS]
     */
    public void setIaactions(String  iaactions){
        this.iaactions = iaactions ;
        this.modify("iaactions",iaactions);
    }

    /**
     * 设置 [ISREADONLY]
     */
    public void setIsreadonly(Integer  isreadonly){
        this.isreadonly = isreadonly ;
        this.modify("isreadonly",isreadonly);
    }

    /**
     * 设置 [ACTORID]
     */
    public void setActorid(String  actorid){
        this.actorid = actorid ;
        this.modify("actorid",actorid);
    }

    /**
     * 设置 [ROLEID]
     */
    public void setRoleid(String  roleid){
        this.roleid = roleid ;
        this.modify("roleid",roleid);
    }

    /**
     * 设置 [REMINDERCOUNT]
     */
    public void setRemindercount(Integer  remindercount){
        this.remindercount = remindercount ;
        this.modify("remindercount",remindercount);
    }

    /**
     * 设置 [FINISHDATE]
     */
    public void setFinishdate(Timestamp  finishdate){
        this.finishdate = finishdate ;
        this.modify("finishdate",finishdate);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [ORIGINALWFUSERNAME]
     */
    public void setOriginalwfusername(String  originalwfusername){
        this.originalwfusername = originalwfusername ;
        this.modify("originalwfusername",originalwfusername);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
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


}

