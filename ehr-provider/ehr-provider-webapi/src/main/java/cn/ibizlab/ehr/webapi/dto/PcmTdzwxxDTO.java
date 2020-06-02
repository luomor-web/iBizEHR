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
 * 服务DTO对象[PcmTdzwxxDTO]
 */
@Data
public class PcmTdzwxxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DEPARTMENT]
     *
     */
    @JSONField(name = "department")
    @JsonProperty("department")
    private String department;

    /**
     * 属性 [PHASEINFO]
     *
     */
    @JSONField(name = "phaseinfo")
    @JsonProperty("phaseinfo")
    private String phaseinfo;

    /**
     * 属性 [ORGANIZATION]
     *
     */
    @JSONField(name = "organization")
    @JsonProperty("organization")
    private String organization;

    /**
     * 属性 [STATUSINFO]
     *
     */
    @JSONField(name = "statusinfo")
    @JsonProperty("statusinfo")
    private String statusinfo;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JOBCODE]
     *
     */
    @JSONField(name = "jobcode")
    @JsonProperty("jobcode")
    private String jobcode;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [JOBID]
     *
     */
    @JSONField(name = "jobid")
    @JsonProperty("jobid")
    private String jobid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TDZWXXID]
     *
     */
    @JSONField(name = "tdzwxxid")
    @JsonProperty("tdzwxxid")
    private String tdzwxxid;

    /**
     * 属性 [INITAPPLYDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "initapplydate" , format="yyyy-MM-dd")
    @JsonProperty("initapplydate")
    private Timestamp initapplydate;

    /**
     * 属性 [TDZWXXNAME]
     *
     */
    @JSONField(name = "tdzwxxname")
    @JsonProperty("tdzwxxname")
    private String tdzwxxname;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [DEPARTMENT]
     */
    public void setDepartment(String  department){
        this.department = department ;
        this.modify("department",department);
    }

    /**
     * 设置 [PHASEINFO]
     */
    public void setPhaseinfo(String  phaseinfo){
        this.phaseinfo = phaseinfo ;
        this.modify("phaseinfo",phaseinfo);
    }

    /**
     * 设置 [ORGANIZATION]
     */
    public void setOrganization(String  organization){
        this.organization = organization ;
        this.modify("organization",organization);
    }

    /**
     * 设置 [STATUSINFO]
     */
    public void setStatusinfo(String  statusinfo){
        this.statusinfo = statusinfo ;
        this.modify("statusinfo",statusinfo);
    }

    /**
     * 设置 [JOBCODE]
     */
    public void setJobcode(String  jobcode){
        this.jobcode = jobcode ;
        this.modify("jobcode",jobcode);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [JOBID]
     */
    public void setJobid(String  jobid){
        this.jobid = jobid ;
        this.modify("jobid",jobid);
    }

    /**
     * 设置 [INITAPPLYDATE]
     */
    public void setInitapplydate(Timestamp  initapplydate){
        this.initapplydate = initapplydate ;
        this.modify("initapplydate",initapplydate);
    }

    /**
     * 设置 [TDZWXXNAME]
     */
    public void setTdzwxxname(String  tdzwxxname){
        this.tdzwxxname = tdzwxxname ;
        this.modify("tdzwxxname",tdzwxxname);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

