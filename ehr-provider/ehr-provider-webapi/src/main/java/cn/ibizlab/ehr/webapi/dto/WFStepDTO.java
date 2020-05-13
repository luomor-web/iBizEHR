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
 * 服务DTO对象[WFStepDTO]
 */
@Data
public class WFStepDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ISFINISH]
     *
     */
    @JSONField(name = "isfinish")
    @JsonProperty("isfinish")
    private Integer isfinish;

    /**
     * 属性 [FROMWFSTEPID]
     *
     */
    @JSONField(name = "fromwfstepid")
    @JsonProperty("fromwfstepid")
    private String fromwfstepid;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;

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
     * 属性 [WFSTEPLANRESTAG]
     *
     */
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;

    /**
     * 属性 [ISINTERACTIVE]
     *
     */
    @JSONField(name = "isinteractive")
    @JsonProperty("isinteractive")
    private Integer isinteractive;

    /**
     * 属性 [WFVERSION]
     *
     */
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [WFPLOGICNAME]
     *
     */
    @JSONField(name = "wfplogicname")
    @JsonProperty("wfplogicname")
    private String wfplogicname;

    /**
     * 属性 [DEADLINE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "deadline" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("deadline")
    private Timestamp deadline;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFPNAME]
     *
     */
    @JSONField(name = "wfpname")
    @JsonProperty("wfpname")
    private String wfpname;

    /**
     * 属性 [LASTACTORID]
     *
     */
    @JSONField(name = "lastactorid")
    @JsonProperty("lastactorid")
    private String lastactorid;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [WFPMODEL]
     *
     */
    @JSONField(name = "wfpmodel")
    @JsonProperty("wfpmodel")
    private String wfpmodel;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;

    /**
     * 属性 [TRACESTEP]
     *
     */
    @JSONField(name = "tracestep")
    @JsonProperty("tracestep")
    private Integer tracestep;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;


    /**
     * 设置 [ISFINISH]
     */
    public void setIsfinish(Integer  isfinish){
        this.isfinish = isfinish ;
        this.modify("isfinish",isfinish);
    }

    /**
     * 设置 [FROMWFSTEPID]
     */
    public void setFromwfstepid(String  fromwfstepid){
        this.fromwfstepid = fromwfstepid ;
        this.modify("fromwfstepid",fromwfstepid);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [WFSTEPLANRESTAG]
     */
    public void setWfsteplanrestag(String  wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }

    /**
     * 设置 [ISINTERACTIVE]
     */
    public void setIsinteractive(Integer  isinteractive){
        this.isinteractive = isinteractive ;
        this.modify("isinteractive",isinteractive);
    }

    /**
     * 设置 [WFVERSION]
     */
    public void setWfversion(Integer  wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [WFPLOGICNAME]
     */
    public void setWfplogicname(String  wfplogicname){
        this.wfplogicname = wfplogicname ;
        this.modify("wfplogicname",wfplogicname);
    }

    /**
     * 设置 [DEADLINE]
     */
    public void setDeadline(Timestamp  deadline){
        this.deadline = deadline ;
        this.modify("deadline",deadline);
    }

    /**
     * 设置 [WFPNAME]
     */
    public void setWfpname(String  wfpname){
        this.wfpname = wfpname ;
        this.modify("wfpname",wfpname);
    }

    /**
     * 设置 [LASTACTORID]
     */
    public void setLastactorid(String  lastactorid){
        this.lastactorid = lastactorid ;
        this.modify("lastactorid",lastactorid);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [WFPMODEL]
     */
    public void setWfpmodel(String  wfpmodel){
        this.wfpmodel = wfpmodel ;
        this.modify("wfpmodel",wfpmodel);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [TRACESTEP]
     */
    public void setTracestep(Integer  tracestep){
        this.tracestep = tracestep ;
        this.modify("tracestep",tracestep);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }


}

