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
 * 服务DTO对象[WFInstanceDTO]
 */
@Data
public class WFInstanceDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERDATAINFO]
     *
     */
    @JSONField(name = "userdatainfo")
    @JsonProperty("userdatainfo")
    private String userdatainfo;

    /**
     * 属性 [ISCLOSE]
     *
     */
    @JSONField(name = "isclose")
    @JsonProperty("isclose")
    private Integer isclose;

    /**
     * 属性 [CANCELREASON]
     *
     */
    @JSONField(name = "cancelreason")
    @JsonProperty("cancelreason")
    private String cancelreason;

    /**
     * 属性 [ISCANCEL]
     *
     */
    @JSONField(name = "iscancel")
    @JsonProperty("iscancel")
    private Integer iscancel;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [WFVERSION]
     *
     */
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;

    /**
     * 属性 [USERDATA3]
     *
     */
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;

    /**
     * 属性 [ACTIVESTEPID]
     *
     */
    @JSONField(name = "activestepid")
    @JsonProperty("activestepid")
    private String activestepid;

    /**
     * 属性 [USERTAG2]
     *
     */
    @JSONField(name = "usertag2")
    @JsonProperty("usertag2")
    private String usertag2;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [OWNER]
     *
     */
    @JSONField(name = "owner")
    @JsonProperty("owner")
    private String owner;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;

    /**
     * 属性 [USERTAG]
     *
     */
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    private String usertag;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [ERRORINFO]
     *
     */
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;

    /**
     * 属性 [TRACESTEP]
     *
     */
    @JSONField(name = "tracestep")
    @JsonProperty("tracestep")
    private Integer tracestep;

    /**
     * 属性 [SUSPENDFLAG]
     *
     */
    @JSONField(name = "suspendflag")
    @JsonProperty("suspendflag")
    private Integer suspendflag;

    /**
     * 属性 [PARALLELINST]
     *
     */
    @JSONField(name = "parallelinst")
    @JsonProperty("parallelinst")
    private Integer parallelinst;

    /**
     * 属性 [IMPORTANCEFLAG]
     *
     */
    @JSONField(name = "importanceflag")
    @JsonProperty("importanceflag")
    private Integer importanceflag;

    /**
     * 属性 [LASTWFSTEPID]
     *
     */
    @JSONField(name = "lastwfstepid")
    @JsonProperty("lastwfstepid")
    private String lastwfstepid;

    /**
     * 属性 [RESULT]
     *
     */
    @JSONField(name = "result")
    @JsonProperty("result")
    private String result;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;

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
     * 属性 [LASTACTION]
     *
     */
    @JSONField(name = "lastaction")
    @JsonProperty("lastaction")
    private String lastaction;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFMODEL]
     *
     */
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;

    /**
     * 属性 [ACTIVESTEPNAME]
     *
     */
    @JSONField(name = "activestepname")
    @JsonProperty("activestepname")
    private String activestepname;

    /**
     * 属性 [LASTACTORID]
     *
     */
    @JSONField(name = "lastactorid")
    @JsonProperty("lastactorid")
    private String lastactorid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ISERROR]
     *
     */
    @JSONField(name = "iserror")
    @JsonProperty("iserror")
    private Integer iserror;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PSTEPID]
     *
     */
    @JSONField(name = "pstepid")
    @JsonProperty("pstepid")
    private String pstepid;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [PWFINSTANCENAME]
     *
     */
    @JSONField(name = "pwfinstancename")
    @JsonProperty("pwfinstancename")
    private String pwfinstancename;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PWFINSTANCEID]
     *
     */
    @JSONField(name = "pwfinstanceid")
    @JsonProperty("pwfinstanceid")
    private String pwfinstanceid;


    /**
     * 设置 [USERDATAINFO]
     */
    public void setUserdatainfo(String  userdatainfo){
        this.userdatainfo = userdatainfo ;
        this.modify("userdatainfo",userdatainfo);
    }

    /**
     * 设置 [ISCLOSE]
     */
    public void setIsclose(Integer  isclose){
        this.isclose = isclose ;
        this.modify("isclose",isclose);
    }

    /**
     * 设置 [CANCELREASON]
     */
    public void setCancelreason(String  cancelreason){
        this.cancelreason = cancelreason ;
        this.modify("cancelreason",cancelreason);
    }

    /**
     * 设置 [ISCANCEL]
     */
    public void setIscancel(Integer  iscancel){
        this.iscancel = iscancel ;
        this.modify("iscancel",iscancel);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String  userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }

    /**
     * 设置 [WFVERSION]
     */
    public void setWfversion(Integer  wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }

    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String  userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }

    /**
     * 设置 [ACTIVESTEPID]
     */
    public void setActivestepid(String  activestepid){
        this.activestepid = activestepid ;
        this.modify("activestepid",activestepid);
    }

    /**
     * 设置 [USERTAG2]
     */
    public void setUsertag2(String  usertag2){
        this.usertag2 = usertag2 ;
        this.modify("usertag2",usertag2);
    }

    /**
     * 设置 [OWNER]
     */
    public void setOwner(String  owner){
        this.owner = owner ;
        this.modify("owner",owner);
    }

    /**
     * 设置 [USERTAG]
     */
    public void setUsertag(String  usertag){
        this.usertag = usertag ;
        this.modify("usertag",usertag);
    }

    /**
     * 设置 [WFINSTANCENAME]
     */
    public void setWfinstancename(String  wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }

    /**
     * 设置 [ERRORINFO]
     */
    public void setErrorinfo(String  errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }

    /**
     * 设置 [TRACESTEP]
     */
    public void setTracestep(Integer  tracestep){
        this.tracestep = tracestep ;
        this.modify("tracestep",tracestep);
    }

    /**
     * 设置 [SUSPENDFLAG]
     */
    public void setSuspendflag(Integer  suspendflag){
        this.suspendflag = suspendflag ;
        this.modify("suspendflag",suspendflag);
    }

    /**
     * 设置 [PARALLELINST]
     */
    public void setParallelinst(Integer  parallelinst){
        this.parallelinst = parallelinst ;
        this.modify("parallelinst",parallelinst);
    }

    /**
     * 设置 [IMPORTANCEFLAG]
     */
    public void setImportanceflag(Integer  importanceflag){
        this.importanceflag = importanceflag ;
        this.modify("importanceflag",importanceflag);
    }

    /**
     * 设置 [LASTWFSTEPID]
     */
    public void setLastwfstepid(String  lastwfstepid){
        this.lastwfstepid = lastwfstepid ;
        this.modify("lastwfstepid",lastwfstepid);
    }

    /**
     * 设置 [RESULT]
     */
    public void setResult(String  result){
        this.result = result ;
        this.modify("result",result);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
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
     * 设置 [LASTACTION]
     */
    public void setLastaction(String  lastaction){
        this.lastaction = lastaction ;
        this.modify("lastaction",lastaction);
    }

    /**
     * 设置 [WFMODEL]
     */
    public void setWfmodel(String  wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }

    /**
     * 设置 [ACTIVESTEPNAME]
     */
    public void setActivestepname(String  activestepname){
        this.activestepname = activestepname ;
        this.modify("activestepname",activestepname);
    }

    /**
     * 设置 [LASTACTORID]
     */
    public void setLastactorid(String  lastactorid){
        this.lastactorid = lastactorid ;
        this.modify("lastactorid",lastactorid);
    }

    /**
     * 设置 [ISERROR]
     */
    public void setIserror(Integer  iserror){
        this.iserror = iserror ;
        this.modify("iserror",iserror);
    }

    /**
     * 设置 [PSTEPID]
     */
    public void setPstepid(String  pstepid){
        this.pstepid = pstepid ;
        this.modify("pstepid",pstepid);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [WFWORKFLOWID]
     */
    public void setWfworkflowid(String  wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }

    /**
     * 设置 [PWFINSTANCEID]
     */
    public void setPwfinstanceid(String  pwfinstanceid){
        this.pwfinstanceid = pwfinstanceid ;
        this.modify("pwfinstanceid",pwfinstanceid);
    }


}

