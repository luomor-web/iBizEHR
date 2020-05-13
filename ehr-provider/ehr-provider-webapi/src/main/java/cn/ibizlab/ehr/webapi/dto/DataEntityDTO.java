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
 * 服务DTO对象[DataEntityDTO]
 */
@Data
public class DataEntityDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SMALLICON]
     *
     */
    @JSONField(name = "smallicon")
    @JsonProperty("smallicon")
    private String smallicon;

    /**
     * 属性 [DEGROUP]
     *
     */
    @JSONField(name = "degroup")
    @JsonProperty("degroup")
    private String degroup;

    /**
     * 属性 [DENAME]
     *
     */
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;

    /**
     * 属性 [MULTIMAJOR]
     *
     */
    @JSONField(name = "mutlimajor")
    @JsonProperty("mutlimajor")
    private Integer mutlimajor;

    /**
     * 属性 [ACINFOFORMAT]
     *
     */
    @JSONField(name = "acinfoformat")
    @JsonProperty("acinfoformat")
    private String acinfoformat;

    /**
     * 属性 [ACMAXCNT]
     *
     */
    @JSONField(name = "acmaxcnt")
    @JsonProperty("acmaxcnt")
    private Integer acmaxcnt;

    /**
     * 属性 [ISINDEXDE]
     *
     */
    @JSONField(name = "isindexde")
    @JsonProperty("isindexde")
    private Integer isindexde;

    /**
     * 属性 [EXITINGMODEL]
     *
     */
    @JSONField(name = "exitingmodel")
    @JsonProperty("exitingmodel")
    private Integer exitingmodel;

    /**
     * 属性 [VCFLAG]
     *
     */
    @JSONField(name = "vcflag")
    @JsonProperty("vcflag")
    private Integer vcflag;

    /**
     * 属性 [DEOBJECT]
     *
     */
    @JSONField(name = "deobject")
    @JsonProperty("deobject")
    private String deobject;

    /**
     * 属性 [ROWAMOUNT]
     *
     */
    @JSONField(name = "rowamout")
    @JsonProperty("rowamout")
    private Integer rowamout;

    /**
     * 属性 [ACENABLEDP]
     *
     */
    @JSONField(name = "acenabledp")
    @JsonProperty("acenabledp")
    private Integer acenabledp;

    /**
     * 属性 [LOGAUDITDETAIL]
     *
     */
    @JSONField(name = "logauditdetail")
    @JsonProperty("logauditdetail")
    private Integer logauditdetail;

    /**
     * 属性 [MINORFIELDVALUE]
     *
     */
    @JSONField(name = "minorfieldvalue")
    @JsonProperty("minorfieldvalue")
    private String minorfieldvalue;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

    /**
     * 属性 [DATANOTIFYHELPER]
     *
     */
    @JSONField(name = "datanotifyhelper")
    @JsonProperty("datanotifyhelper")
    private String datanotifyhelper;

    /**
     * 属性 [DBVERSION]
     *
     */
    @JSONField(name = "dbversion")
    @JsonProperty("dbversion")
    private Integer dbversion;

    /**
     * 属性 [ISSYSTEM]
     *
     */
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;

    /**
     * 属性 [ACINFOPARAM]
     *
     */
    @JSONField(name = "acinfoparam")
    @JsonProperty("acinfoparam")
    private String acinfoparam;

    /**
     * 属性 [DEHELPER]
     *
     */
    @JSONField(name = "dehelper")
    @JsonProperty("dehelper")
    private String dehelper;

    /**
     * 属性 [TABLENAME]
     *
     */
    @JSONField(name = "tablename")
    @JsonProperty("tablename")
    private String tablename;

    /**
     * 属性 [DEID]
     *
     */
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;

    /**
     * 属性 [DETYPE]
     *
     */
    @JSONField(name = "detype")
    @JsonProperty("detype")
    private Integer detype;

    /**
     * 属性 [DELOGICNAME]
     *
     */
    @JSONField(name = "delogicname")
    @JsonProperty("delogicname")
    private String delogicname;

    /**
     * 属性 [ISENABLEDP]
     *
     */
    @JSONField(name = "isenabledp")
    @JsonProperty("isenabledp")
    private Integer isenabledp;

    /**
     * 属性 [ENABLEGLOBALMODEL]
     *
     */
    @JSONField(name = "enableglobalmodel")
    @JsonProperty("enableglobalmodel")
    private Integer enableglobalmodel;

    /**
     * 属性 [EXPORTINCEMPTY]
     *
     */
    @JSONField(name = "exportincempty")
    @JsonProperty("exportincempty")
    private Integer exportincempty;

    /**
     * 属性 [ISLOGICVALID]
     *
     */
    @JSONField(name = "islogicvalid")
    @JsonProperty("islogicvalid")
    private Integer islogicvalid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [VIEWNAME]
     *
     */
    @JSONField(name = "viewname")
    @JsonProperty("viewname")
    private String viewname;

    /**
     * 属性 [PRINTFUNC]
     *
     */
    @JSONField(name = "printfunc")
    @JsonProperty("printfunc")
    private String printfunc;

    /**
     * 属性 [DYNAMICINTERVAL]
     *
     */
    @JSONField(name = "dynamicinterval")
    @JsonProperty("dynamicinterval")
    private Integer dynamicinterval;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [VERFIELD]
     *
     */
    @JSONField(name = "verfield")
    @JsonProperty("verfield")
    private String verfield;

    /**
     * 属性 [ACEXTINFO]
     *
     */
    @JSONField(name = "acextinfo")
    @JsonProperty("acextinfo")
    private String acextinfo;

    /**
     * 属性 [DGSUMMARYHEIGHT]
     *
     */
    @JSONField(name = "dgsummaryheight")
    @JsonProperty("dgsummaryheight")
    private Integer dgsummaryheight;

    /**
     * 属性 [ACOBJECT]
     *
     */
    @JSONField(name = "acobject")
    @JsonProperty("acobject")
    private String acobject;

    /**
     * 属性 [RTINFO]
     *
     */
    @JSONField(name = "rtinfo")
    @JsonProperty("rtinfo")
    private String rtinfo;

    /**
     * 属性 [ISMULTIPRINT]
     *
     */
    @JSONField(name = "ismultiprint")
    @JsonProperty("ismultiprint")
    private Integer ismultiprint;

    /**
     * 属性 [MINORTABLENAME]
     *
     */
    @JSONField(name = "minortablename")
    @JsonProperty("minortablename")
    private String minortablename;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [DGROWCLASSHELPER]
     *
     */
    @JSONField(name = "dgrowclasshelper")
    @JsonProperty("dgrowclasshelper")
    private String dgrowclasshelper;

    /**
     * 属性 [EXTABLENAME]
     *
     */
    @JSONField(name = "extablename")
    @JsonProperty("extablename")
    private String extablename;

    /**
     * 属性 [DEPARAM]
     *
     */
    @JSONField(name = "deparam")
    @JsonProperty("deparam")
    private String deparam;

    /**
     * 属性 [GLOBALMODELOBJ]
     *
     */
    @JSONField(name = "globalmodelobj")
    @JsonProperty("globalmodelobj")
    private String globalmodelobj;

    /**
     * 属性 [INDEXMODE]
     *
     */
    @JSONField(name = "indexmode")
    @JsonProperty("indexmode")
    private Integer indexmode;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [NODATAINFO]
     *
     */
    @JSONField(name = "nodatainfo")
    @JsonProperty("nodatainfo")
    private Integer nodatainfo;

    /**
     * 属性 [INHERITMODE]
     *
     */
    @JSONField(name = "inheritmode")
    @JsonProperty("inheritmode")
    private Integer inheritmode;

    /**
     * 属性 [INFOFIELD]
     *
     */
    @JSONField(name = "infofield")
    @JsonProperty("infofield")
    private String infofield;

    /**
     * 属性 [DEORDER]
     *
     */
    @JSONField(name = "deorder")
    @JsonProperty("deorder")
    private Integer deorder;

    /**
     * 属性 [BIGICON]
     *
     */
    @JSONField(name = "bigicon")
    @JsonProperty("bigicon")
    private String bigicon;

    /**
     * 属性 [CONFIGHELPER]
     *
     */
    @JSONField(name = "confighelper")
    @JsonProperty("confighelper")
    private String confighelper;

    /**
     * 属性 [STORAGETYPE]
     *
     */
    @JSONField(name = "storagetype")
    @JsonProperty("storagetype")
    private String storagetype;

    /**
     * 属性 [VERCHECKTIMER]
     *
     */
    @JSONField(name = "verchecktimer")
    @JsonProperty("verchecktimer")
    private Integer verchecktimer;

    /**
     * 属性 [ISENABLEAUDIT]
     *
     */
    @JSONField(name = "isenableaudit")
    @JsonProperty("isenableaudit")
    private Integer isenableaudit;

    /**
     * 属性 [LICENSECODE]
     *
     */
    @JSONField(name = "licensecode")
    @JsonProperty("licensecode")
    private String licensecode;

    /**
     * 属性 [ENABLECOLPRIV]
     *
     */
    @JSONField(name = "enablecolpriv")
    @JsonProperty("enablecolpriv")
    private Integer enablecolpriv;

    /**
     * 属性 [DATACTRLINT]
     *
     */
    @JSONField(name = "datactrlint")
    @JsonProperty("datactrlint")
    private String datactrlint;

    /**
     * 属性 [ISSUPPORTFA]
     *
     */
    @JSONField(name = "issupportfa")
    @JsonProperty("issupportfa")
    private Integer issupportfa;

    /**
     * 属性 [DEUSERPARAM]
     *
     */
    @JSONField(name = "deuserparam")
    @JsonProperty("deuserparam")
    private String deuserparam;

    /**
     * 属性 [DATACHGLOGMODE]
     *
     */
    @JSONField(name = "datachglogmode")
    @JsonProperty("datachglogmode")
    private Integer datachglogmode;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [VERHELPER]
     *
     */
    @JSONField(name = "verhelper")
    @JsonProperty("verhelper")
    private String verhelper;

    /**
     * 属性 [DATAACCOBJECT]
     *
     */
    @JSONField(name = "dataaccobject")
    @JsonProperty("dataaccobject")
    private String dataaccobject;

    /**
     * 属性 [VERSIONCHECK]
     *
     */
    @JSONField(name = "versioncheck")
    @JsonProperty("versioncheck")
    private Integer versioncheck;

    /**
     * 属性 [DEVERSION]
     *
     */
    @JSONField(name = "deversion")
    @JsonProperty("deversion")
    private Integer deversion;

    /**
     * 属性 [TIPSINFO]
     *
     */
    @JSONField(name = "tipsinfo")
    @JsonProperty("tipsinfo")
    private String tipsinfo;

    /**
     * 属性 [ISDGROWEDIT]
     *
     */
    @JSONField(name = "isdgrowedit")
    @JsonProperty("isdgrowedit")
    private Integer isdgrowedit;

    /**
     * 属性 [TABLESPACE]
     *
     */
    @JSONField(name = "tablespace")
    @JsonProperty("tablespace")
    private String tablespace;

    /**
     * 属性 [DLKHELPER]
     *
     */
    @JSONField(name = "dlkhelper")
    @JsonProperty("dlkhelper")
    private String dlkhelper;

    /**
     * 属性 [USERACTION]
     *
     */
    @JSONField(name = "useraction")
    @JsonProperty("useraction")
    private Integer useraction;

    /**
     * 属性 [ACSORTFIELD]
     *
     */
    @JSONField(name = "acsortfield")
    @JsonProperty("acsortfield")
    private String acsortfield;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [MINORFIELDNAME]
     *
     */
    @JSONField(name = "minorfieldname")
    @JsonProperty("minorfieldname")
    private String minorfieldname;

    /**
     * 属性 [DBSTORAGE]
     *
     */
    @JSONField(name = "dbstorage")
    @JsonProperty("dbstorage")
    private String dbstorage;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [INFOFORMAT]
     *
     */
    @JSONField(name = "infoformat")
    @JsonProperty("infoformat")
    private String infoformat;

    /**
     * 属性 [DATACTRLOBJECT]
     *
     */
    @JSONField(name = "datactrlobject")
    @JsonProperty("datactrlobject")
    private String datactrlobject;

    /**
     * 属性 [KEYPARAMS]
     *
     */
    @JSONField(name = "keyparams")
    @JsonProperty("keyparams")
    private String keyparams;

    /**
     * 属性 [ACSORTDIR]
     *
     */
    @JSONField(name = "acsortdir")
    @JsonProperty("acsortdir")
    private String acsortdir;

    /**
     * 属性 [DER11DENAME]
     *
     */
    @JSONField(name = "der11dename")
    @JsonProperty("der11dename")
    private String der11dename;

    /**
     * 属性 [ACQUERYMODELNAME]
     *
     */
    @JSONField(name = "acquerymodelname")
    @JsonProperty("acquerymodelname")
    private String acquerymodelname;

    /**
     * 属性 [ACQUERYMODELID]
     *
     */
    @JSONField(name = "acquerymodelid")
    @JsonProperty("acquerymodelid")
    private String acquerymodelid;

    /**
     * 属性 [DER11DEID]
     *
     */
    @JSONField(name = "der11deid")
    @JsonProperty("der11deid")
    private String der11deid;


    /**
     * 设置 [SMALLICON]
     */
    public void setSmallicon(String  smallicon){
        this.smallicon = smallicon ;
        this.modify("smallicon",smallicon);
    }

    /**
     * 设置 [DEGROUP]
     */
    public void setDegroup(String  degroup){
        this.degroup = degroup ;
        this.modify("degroup",degroup);
    }

    /**
     * 设置 [DENAME]
     */
    public void setDename(String  dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }

    /**
     * 设置 [MULTIMAJOR]
     */
    public void setMutlimajor(Integer  mutlimajor){
        this.mutlimajor = mutlimajor ;
        this.modify("multimajor",mutlimajor);
    }

    /**
     * 设置 [ACINFOFORMAT]
     */
    public void setAcinfoformat(String  acinfoformat){
        this.acinfoformat = acinfoformat ;
        this.modify("acinfoformat",acinfoformat);
    }

    /**
     * 设置 [ACMAXCNT]
     */
    public void setAcmaxcnt(Integer  acmaxcnt){
        this.acmaxcnt = acmaxcnt ;
        this.modify("acmaxcnt",acmaxcnt);
    }

    /**
     * 设置 [ISINDEXDE]
     */
    public void setIsindexde(Integer  isindexde){
        this.isindexde = isindexde ;
        this.modify("isindexde",isindexde);
    }

    /**
     * 设置 [EXITINGMODEL]
     */
    public void setExitingmodel(Integer  exitingmodel){
        this.exitingmodel = exitingmodel ;
        this.modify("exitingmodel",exitingmodel);
    }

    /**
     * 设置 [VCFLAG]
     */
    public void setVcflag(Integer  vcflag){
        this.vcflag = vcflag ;
        this.modify("vcflag",vcflag);
    }

    /**
     * 设置 [DEOBJECT]
     */
    public void setDeobject(String  deobject){
        this.deobject = deobject ;
        this.modify("deobject",deobject);
    }

    /**
     * 设置 [ROWAMOUNT]
     */
    public void setRowamout(Integer  rowamout){
        this.rowamout = rowamout ;
        this.modify("rowamount",rowamout);
    }

    /**
     * 设置 [ACENABLEDP]
     */
    public void setAcenabledp(Integer  acenabledp){
        this.acenabledp = acenabledp ;
        this.modify("acenabledp",acenabledp);
    }

    /**
     * 设置 [LOGAUDITDETAIL]
     */
    public void setLogauditdetail(Integer  logauditdetail){
        this.logauditdetail = logauditdetail ;
        this.modify("logauditdetail",logauditdetail);
    }

    /**
     * 设置 [MINORFIELDVALUE]
     */
    public void setMinorfieldvalue(String  minorfieldvalue){
        this.minorfieldvalue = minorfieldvalue ;
        this.modify("minorfieldvalue",minorfieldvalue);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [DATANOTIFYHELPER]
     */
    public void setDatanotifyhelper(String  datanotifyhelper){
        this.datanotifyhelper = datanotifyhelper ;
        this.modify("datanotifyhelper",datanotifyhelper);
    }

    /**
     * 设置 [DBVERSION]
     */
    public void setDbversion(Integer  dbversion){
        this.dbversion = dbversion ;
        this.modify("dbversion",dbversion);
    }

    /**
     * 设置 [ISSYSTEM]
     */
    public void setIssystem(Integer  issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }

    /**
     * 设置 [ACINFOPARAM]
     */
    public void setAcinfoparam(String  acinfoparam){
        this.acinfoparam = acinfoparam ;
        this.modify("acinfoparam",acinfoparam);
    }

    /**
     * 设置 [DEHELPER]
     */
    public void setDehelper(String  dehelper){
        this.dehelper = dehelper ;
        this.modify("dehelper",dehelper);
    }

    /**
     * 设置 [TABLENAME]
     */
    public void setTablename(String  tablename){
        this.tablename = tablename ;
        this.modify("tablename",tablename);
    }

    /**
     * 设置 [DETYPE]
     */
    public void setDetype(Integer  detype){
        this.detype = detype ;
        this.modify("detype",detype);
    }

    /**
     * 设置 [DELOGICNAME]
     */
    public void setDelogicname(String  delogicname){
        this.delogicname = delogicname ;
        this.modify("delogicname",delogicname);
    }

    /**
     * 设置 [ISENABLEDP]
     */
    public void setIsenabledp(Integer  isenabledp){
        this.isenabledp = isenabledp ;
        this.modify("isenabledp",isenabledp);
    }

    /**
     * 设置 [ENABLEGLOBALMODEL]
     */
    public void setEnableglobalmodel(Integer  enableglobalmodel){
        this.enableglobalmodel = enableglobalmodel ;
        this.modify("enableglobalmodel",enableglobalmodel);
    }

    /**
     * 设置 [EXPORTINCEMPTY]
     */
    public void setExportincempty(Integer  exportincempty){
        this.exportincempty = exportincempty ;
        this.modify("exportincempty",exportincempty);
    }

    /**
     * 设置 [ISLOGICVALID]
     */
    public void setIslogicvalid(Integer  islogicvalid){
        this.islogicvalid = islogicvalid ;
        this.modify("islogicvalid",islogicvalid);
    }

    /**
     * 设置 [VIEWNAME]
     */
    public void setViewname(String  viewname){
        this.viewname = viewname ;
        this.modify("viewname",viewname);
    }

    /**
     * 设置 [PRINTFUNC]
     */
    public void setPrintfunc(String  printfunc){
        this.printfunc = printfunc ;
        this.modify("printfunc",printfunc);
    }

    /**
     * 设置 [DYNAMICINTERVAL]
     */
    public void setDynamicinterval(Integer  dynamicinterval){
        this.dynamicinterval = dynamicinterval ;
        this.modify("dynamicinterval",dynamicinterval);
    }

    /**
     * 设置 [VERFIELD]
     */
    public void setVerfield(String  verfield){
        this.verfield = verfield ;
        this.modify("verfield",verfield);
    }

    /**
     * 设置 [ACEXTINFO]
     */
    public void setAcextinfo(String  acextinfo){
        this.acextinfo = acextinfo ;
        this.modify("acextinfo",acextinfo);
    }

    /**
     * 设置 [DGSUMMARYHEIGHT]
     */
    public void setDgsummaryheight(Integer  dgsummaryheight){
        this.dgsummaryheight = dgsummaryheight ;
        this.modify("dgsummaryheight",dgsummaryheight);
    }

    /**
     * 设置 [ACOBJECT]
     */
    public void setAcobject(String  acobject){
        this.acobject = acobject ;
        this.modify("acobject",acobject);
    }

    /**
     * 设置 [ISMULTIPRINT]
     */
    public void setIsmultiprint(Integer  ismultiprint){
        this.ismultiprint = ismultiprint ;
        this.modify("ismultiprint",ismultiprint);
    }

    /**
     * 设置 [MINORTABLENAME]
     */
    public void setMinortablename(String  minortablename){
        this.minortablename = minortablename ;
        this.modify("minortablename",minortablename);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [DGROWCLASSHELPER]
     */
    public void setDgrowclasshelper(String  dgrowclasshelper){
        this.dgrowclasshelper = dgrowclasshelper ;
        this.modify("dgrowclasshelper",dgrowclasshelper);
    }

    /**
     * 设置 [EXTABLENAME]
     */
    public void setExtablename(String  extablename){
        this.extablename = extablename ;
        this.modify("extablename",extablename);
    }

    /**
     * 设置 [DEPARAM]
     */
    public void setDeparam(String  deparam){
        this.deparam = deparam ;
        this.modify("deparam",deparam);
    }

    /**
     * 设置 [GLOBALMODELOBJ]
     */
    public void setGlobalmodelobj(String  globalmodelobj){
        this.globalmodelobj = globalmodelobj ;
        this.modify("globalmodelobj",globalmodelobj);
    }

    /**
     * 设置 [INDEXMODE]
     */
    public void setIndexmode(Integer  indexmode){
        this.indexmode = indexmode ;
        this.modify("indexmode",indexmode);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [NODATAINFO]
     */
    public void setNodatainfo(Integer  nodatainfo){
        this.nodatainfo = nodatainfo ;
        this.modify("nodatainfo",nodatainfo);
    }

    /**
     * 设置 [INHERITMODE]
     */
    public void setInheritmode(Integer  inheritmode){
        this.inheritmode = inheritmode ;
        this.modify("inheritmode",inheritmode);
    }

    /**
     * 设置 [INFOFIELD]
     */
    public void setInfofield(String  infofield){
        this.infofield = infofield ;
        this.modify("infofield",infofield);
    }

    /**
     * 设置 [DEORDER]
     */
    public void setDeorder(Integer  deorder){
        this.deorder = deorder ;
        this.modify("deorder",deorder);
    }

    /**
     * 设置 [BIGICON]
     */
    public void setBigicon(String  bigicon){
        this.bigicon = bigicon ;
        this.modify("bigicon",bigicon);
    }

    /**
     * 设置 [CONFIGHELPER]
     */
    public void setConfighelper(String  confighelper){
        this.confighelper = confighelper ;
        this.modify("confighelper",confighelper);
    }

    /**
     * 设置 [STORAGETYPE]
     */
    public void setStoragetype(String  storagetype){
        this.storagetype = storagetype ;
        this.modify("storagetype",storagetype);
    }

    /**
     * 设置 [VERCHECKTIMER]
     */
    public void setVerchecktimer(Integer  verchecktimer){
        this.verchecktimer = verchecktimer ;
        this.modify("verchecktimer",verchecktimer);
    }

    /**
     * 设置 [ISENABLEAUDIT]
     */
    public void setIsenableaudit(Integer  isenableaudit){
        this.isenableaudit = isenableaudit ;
        this.modify("isenableaudit",isenableaudit);
    }

    /**
     * 设置 [LICENSECODE]
     */
    public void setLicensecode(String  licensecode){
        this.licensecode = licensecode ;
        this.modify("licensecode",licensecode);
    }

    /**
     * 设置 [ENABLECOLPRIV]
     */
    public void setEnablecolpriv(Integer  enablecolpriv){
        this.enablecolpriv = enablecolpriv ;
        this.modify("enablecolpriv",enablecolpriv);
    }

    /**
     * 设置 [DATACTRLINT]
     */
    public void setDatactrlint(String  datactrlint){
        this.datactrlint = datactrlint ;
        this.modify("datactrlint",datactrlint);
    }

    /**
     * 设置 [ISSUPPORTFA]
     */
    public void setIssupportfa(Integer  issupportfa){
        this.issupportfa = issupportfa ;
        this.modify("issupportfa",issupportfa);
    }

    /**
     * 设置 [DEUSERPARAM]
     */
    public void setDeuserparam(String  deuserparam){
        this.deuserparam = deuserparam ;
        this.modify("deuserparam",deuserparam);
    }

    /**
     * 设置 [DATACHGLOGMODE]
     */
    public void setDatachglogmode(Integer  datachglogmode){
        this.datachglogmode = datachglogmode ;
        this.modify("datachglogmode",datachglogmode);
    }

    /**
     * 设置 [VERHELPER]
     */
    public void setVerhelper(String  verhelper){
        this.verhelper = verhelper ;
        this.modify("verhelper",verhelper);
    }

    /**
     * 设置 [DATAACCOBJECT]
     */
    public void setDataaccobject(String  dataaccobject){
        this.dataaccobject = dataaccobject ;
        this.modify("dataaccobject",dataaccobject);
    }

    /**
     * 设置 [VERSIONCHECK]
     */
    public void setVersioncheck(Integer  versioncheck){
        this.versioncheck = versioncheck ;
        this.modify("versioncheck",versioncheck);
    }

    /**
     * 设置 [DEVERSION]
     */
    public void setDeversion(Integer  deversion){
        this.deversion = deversion ;
        this.modify("deversion",deversion);
    }

    /**
     * 设置 [TIPSINFO]
     */
    public void setTipsinfo(String  tipsinfo){
        this.tipsinfo = tipsinfo ;
        this.modify("tipsinfo",tipsinfo);
    }

    /**
     * 设置 [ISDGROWEDIT]
     */
    public void setIsdgrowedit(Integer  isdgrowedit){
        this.isdgrowedit = isdgrowedit ;
        this.modify("isdgrowedit",isdgrowedit);
    }

    /**
     * 设置 [TABLESPACE]
     */
    public void setTablespace(String  tablespace){
        this.tablespace = tablespace ;
        this.modify("tablespace",tablespace);
    }

    /**
     * 设置 [DLKHELPER]
     */
    public void setDlkhelper(String  dlkhelper){
        this.dlkhelper = dlkhelper ;
        this.modify("dlkhelper",dlkhelper);
    }

    /**
     * 设置 [USERACTION]
     */
    public void setUseraction(Integer  useraction){
        this.useraction = useraction ;
        this.modify("useraction",useraction);
    }

    /**
     * 设置 [ACSORTFIELD]
     */
    public void setAcsortfield(String  acsortfield){
        this.acsortfield = acsortfield ;
        this.modify("acsortfield",acsortfield);
    }

    /**
     * 设置 [MINORFIELDNAME]
     */
    public void setMinorfieldname(String  minorfieldname){
        this.minorfieldname = minorfieldname ;
        this.modify("minorfieldname",minorfieldname);
    }

    /**
     * 设置 [DBSTORAGE]
     */
    public void setDbstorage(String  dbstorage){
        this.dbstorage = dbstorage ;
        this.modify("dbstorage",dbstorage);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [INFOFORMAT]
     */
    public void setInfoformat(String  infoformat){
        this.infoformat = infoformat ;
        this.modify("infoformat",infoformat);
    }

    /**
     * 设置 [DATACTRLOBJECT]
     */
    public void setDatactrlobject(String  datactrlobject){
        this.datactrlobject = datactrlobject ;
        this.modify("datactrlobject",datactrlobject);
    }

    /**
     * 设置 [KEYPARAMS]
     */
    public void setKeyparams(String  keyparams){
        this.keyparams = keyparams ;
        this.modify("keyparams",keyparams);
    }

    /**
     * 设置 [ACSORTDIR]
     */
    public void setAcsortdir(String  acsortdir){
        this.acsortdir = acsortdir ;
        this.modify("acsortdir",acsortdir);
    }

    /**
     * 设置 [ACQUERYMODELID]
     */
    public void setAcquerymodelid(String  acquerymodelid){
        this.acquerymodelid = acquerymodelid ;
        this.modify("acquerymodelid",acquerymodelid);
    }

    /**
     * 设置 [DER11DEID]
     */
    public void setDer11deid(String  der11deid){
        this.der11deid = der11deid ;
        this.modify("der11deid",der11deid);
    }


}

