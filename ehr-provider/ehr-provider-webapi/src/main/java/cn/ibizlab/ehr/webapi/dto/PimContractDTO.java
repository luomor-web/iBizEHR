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
 * 服务DTO对象[PimContractDTO]
 */
@Data
public class PimContractDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SSLWPQGS]
     *
     */
    @JSONField(name = "sslwpqgs")
    @JsonProperty("sslwpqgs")
    private String sslwpqgs;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 属性 [SYDQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sydqsj" , format="yyyy-MM-dd")
    @JsonProperty("sydqsj")
    private Timestamp sydqsj;

    /**
     * 属性 [PIMCONTRACTID]
     *
     */
    @JSONField(name = "pimcontractid")
    @JsonProperty("pimcontractid")
    private String pimcontractid;

    /**
     * 属性 [HTSYTS]
     *
     */
    @JSONField(name = "htsyts")
    @JsonProperty("htsyts")
    private Integer htsyts;

    /**
     * 属性 [HTBH]
     *
     */
    @JSONField(name = "htbh")
    @JsonProperty("htbh")
    private String htbh;

    /**
     * 属性 [SIGNINGUNIT]
     *
     */
    @JSONField(name = "signingunit")
    @JsonProperty("signingunit")
    private String signingunit;

    /**
     * 属性 [HTLX]
     *
     */
    @JSONField(name = "htlx")
    @JsonProperty("htlx")
    private String htlx;

    /**
     * 属性 [DEMO]
     *
     */
    @JSONField(name = "demo")
    @JsonProperty("demo")
    private String demo;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JOBCONTENT]
     *
     */
    @JSONField(name = "jobcontent")
    @JsonProperty("jobcontent")
    private String jobcontent;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LEGALORG]
     *
     */
    @JSONField(name = "legalorg")
    @JsonProperty("legalorg")
    private String legalorg;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMCONTRACTNAME]
     *
     */
    @JSONField(name = "pimcontractname")
    @JsonProperty("pimcontractname")
    private String pimcontractname;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [CONTRACTTYPE]
     *
     */
    @JSONField(name = "contracttype")
    @JsonProperty("contracttype")
    private String contracttype;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [EMPLOYEEANDNO]
     *
     */
    @JSONField(name = "employeeandno")
    @JsonProperty("employeeandno")
    private String employeeandno;

    /**
     * 属性 [HTZT]
     *
     */
    @JSONField(name = "htzt")
    @JsonProperty("htzt")
    private String htzt;

    /**
     * 属性 [ACTION]
     *
     */
    @JSONField(name = "action")
    @JsonProperty("action")
    private String action;

    /**
     * 属性 [HTSYTS_COLOR]
     *
     */
    @JSONField(name = "htsyts_color")
    @JsonProperty("htsyts_color")
    private Integer htsytsColor;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [QSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ISFIRSTSIGN]
     *
     */
    @JSONField(name = "isfirstsign")
    @JsonProperty("isfirstsign")
    private Integer isfirstsign;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CONTRACTNUM]
     *
     */
    @JSONField(name = "contractnum")
    @JsonProperty("contractnum")
    private Integer contractnum;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [ISYEMP]
     *
     */
    @JSONField(name = "isyemp")
    @JsonProperty("isyemp")
    private String isyemp;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ZGCODE]
     *
     */
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMSIGNORGNAME]
     *
     */
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;

    /**
     * 属性 [CONTRACTSIGNORGNAME]
     *
     */
    @JSONField(name = "contractsignorgname")
    @JsonProperty("contractsignorgname")
    private String contractsignorgname;

    /**
     * 属性 [LEVELCODE]
     *
     */
    @JSONField(name = "levelcode")
    @JsonProperty("levelcode")
    private String levelcode;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PERSONORGID]
     *
     */
    @JSONField(name = "personorgid")
    @JsonProperty("personorgid")
    private String personorgid;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [PIMLABOURCAMPANYNAME]
     *
     */
    @JSONField(name = "pimlabourcampanyname")
    @JsonProperty("pimlabourcampanyname")
    private String pimlabourcampanyname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [HTZZDZS]
     *
     */
    @JSONField(name = "htzzdzs")
    @JsonProperty("htzzdzs")
    private String htzzdzs;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [DBDWSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;

    /**
     * 属性 [PERSONORGNAME]
     *
     */
    @JSONField(name = "personorgname")
    @JsonProperty("personorgname")
    private String personorgname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMLABOURCAMPANYID]
     *
     */
    @JSONField(name = "pimlabourcampanyid")
    @JsonProperty("pimlabourcampanyid")
    private String pimlabourcampanyid;

    /**
     * 属性 [CONTRACTSIGNORGID]
     *
     */
    @JSONField(name = "contractsignorgid")
    @JsonProperty("contractsignorgid")
    private String contractsignorgid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMSIGNORGID]
     *
     */
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;


    /**
     * 设置 [SSLWPQGS]
     */
    public void setSslwpqgs(String  sslwpqgs){
        this.sslwpqgs = sslwpqgs ;
        this.modify("sslwpqgs",sslwpqgs);
    }

    /**
     * 设置 [SYDQSJ]
     */
    public void setSydqsj(Timestamp  sydqsj){
        this.sydqsj = sydqsj ;
        this.modify("sydqsj",sydqsj);
    }

    /**
     * 设置 [HTBH]
     */
    public void setHtbh(String  htbh){
        this.htbh = htbh ;
        this.modify("htbh",htbh);
    }

    /**
     * 设置 [HTLX]
     */
    public void setHtlx(String  htlx){
        this.htlx = htlx ;
        this.modify("htlx",htlx);
    }

    /**
     * 设置 [DEMO]
     */
    public void setDemo(String  demo){
        this.demo = demo ;
        this.modify("demo",demo);
    }

    /**
     * 设置 [JOBCONTENT]
     */
    public void setJobcontent(String  jobcontent){
        this.jobcontent = jobcontent ;
        this.modify("jobcontent",jobcontent);
    }

    /**
     * 设置 [LEGALORG]
     */
    public void setLegalorg(String  legalorg){
        this.legalorg = legalorg ;
        this.modify("legalorg",legalorg);
    }

    /**
     * 设置 [PIMCONTRACTNAME]
     */
    public void setPimcontractname(String  pimcontractname){
        this.pimcontractname = pimcontractname ;
        this.modify("pimcontractname",pimcontractname);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [CONTRACTTYPE]
     */
    public void setContracttype(String  contracttype){
        this.contracttype = contracttype ;
        this.modify("contracttype",contracttype);
    }

    /**
     * 设置 [HTZT]
     */
    public void setHtzt(String  htzt){
        this.htzt = htzt ;
        this.modify("htzt",htzt);
    }

    /**
     * 设置 [ACTION]
     */
    public void setAction(String  action){
        this.action = action ;
        this.modify("action",action);
    }

    /**
     * 设置 [QSRQ]
     */
    public void setQsrq(Timestamp  qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 设置 [ISFIRSTSIGN]
     */
    public void setIsfirstsign(Integer  isfirstsign){
        this.isfirstsign = isfirstsign ;
        this.modify("isfirstsign",isfirstsign);
    }

    /**
     * 设置 [CONTRACTNUM]
     */
    public void setContractnum(Integer  contractnum){
        this.contractnum = contractnum ;
        this.modify("contractnum",contractnum);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [ISYEMP]
     */
    public void setIsyemp(String  isyemp){
        this.isyemp = isyemp ;
        this.modify("isyemp",isyemp);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PIMLABOURCAMPANYID]
     */
    public void setPimlabourcampanyid(String  pimlabourcampanyid){
        this.pimlabourcampanyid = pimlabourcampanyid ;
        this.modify("pimlabourcampanyid",pimlabourcampanyid);
    }

    /**
     * 设置 [CONTRACTSIGNORGID]
     */
    public void setContractsignorgid(String  contractsignorgid){
        this.contractsignorgid = contractsignorgid ;
        this.modify("contractsignorgid",contractsignorgid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMSIGNORGID]
     */
    public void setOrmsignorgid(String  ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }


}

