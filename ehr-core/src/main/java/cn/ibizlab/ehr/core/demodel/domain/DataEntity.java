package cn.ibizlab.ehr.core.demodel.domain;

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
 * 实体[实体]
 */
@Data
@TableName(value = "t_srfdataentity",resultMap = "DataEntityResultMap")
public class DataEntity extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小图标
     */
    @TableField(value = "smallicon")
    @JSONField(name = "smallicon")
    @JsonProperty("smallicon")
    private String smallicon;
    /**
     * 实体归属
     */
    @TableField(value = "degroup")
    @JSONField(name = "degroup")
    @JsonProperty("degroup")
    private String degroup;
    /**
     * 实体名称
     */
    @TableField(value = "dename")
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 多主实体模式
     */
    @DEField(name = "multimajor")
    @TableField(value = "multimajor")
    @JSONField(name = "mutlimajor")
    @JsonProperty("mutlimajor")
    private Integer mutlimajor;
    /**
     * 自动填充信息格式
     */
    @TableField(value = "acinfoformat")
    @JSONField(name = "acinfoformat")
    @JsonProperty("acinfoformat")
    private String acinfoformat;
    /**
     * 自填最大数量
     */
    @TableField(value = "acmaxcnt")
    @JSONField(name = "acmaxcnt")
    @JsonProperty("acmaxcnt")
    private Integer acmaxcnt;
    /**
     * 索引实体
     */
    @TableField(value = "isindexde")
    @JSONField(name = "isindexde")
    @JsonProperty("isindexde")
    private Integer isindexde;
    /**
     * 现存模型
     */
    @TableField(value = "exitingmodel")
    @JSONField(name = "exitingmodel")
    @JsonProperty("exitingmodel")
    private Integer exitingmodel;
    /**
     * 启用数据版本控制
     */
    @TableField(value = "vcflag")
    @JSONField(name = "vcflag")
    @JsonProperty("vcflag")
    private Integer vcflag;
    /**
     * 数据对象类
     */
    @TableField(value = "deobject")
    @JSONField(name = "deobject")
    @JsonProperty("deobject")
    private String deobject;
    /**
     * 记录数量
     */
    @DEField(name = "rowamount")
    @TableField(value = "rowamount")
    @JSONField(name = "rowamout")
    @JsonProperty("rowamout")
    private Integer rowamout;
    /**
     * 启动自填数据权限
     */
    @TableField(value = "acenabledp")
    @JSONField(name = "acenabledp")
    @JsonProperty("acenabledp")
    private Integer acenabledp;
    /**
     * 记录审计明细
     */
    @TableField(value = "logauditdetail")
    @JSONField(name = "logauditdetail")
    @JsonProperty("logauditdetail")
    private Integer logauditdetail;
    /**
     * 附表标识值
     */
    @TableField(value = "minorfieldvalue")
    @JSONField(name = "minorfieldvalue")
    @JsonProperty("minorfieldvalue")
    private String minorfieldvalue;
    /**
     * 是否启用
     */
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 数据通知辅助对象
     */
    @TableField(value = "datanotifyhelper")
    @JSONField(name = "datanotifyhelper")
    @JsonProperty("datanotifyhelper")
    private String datanotifyhelper;
    /**
     * 数据结构版本
     */
    @TableField(value = "dbversion")
    @JSONField(name = "dbversion")
    @JsonProperty("dbversion")
    private Integer dbversion;
    /**
     * 系统实体
     */
    @DEField(defaultValue = "0")
    @TableField(value = "issystem")
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;
    /**
     * 自动填充信息参数
     */
    @TableField(value = "acinfoparam")
    @JSONField(name = "acinfoparam")
    @JsonProperty("acinfoparam")
    private String acinfoparam;
    /**
     * 实体辅助对象
     */
    @TableField(value = "dehelper")
    @JSONField(name = "dehelper")
    @JsonProperty("dehelper")
    private String dehelper;
    /**
     * 表名称
     */
    @TableField(value = "tablename")
    @JSONField(name = "tablename")
    @JsonProperty("tablename")
    private String tablename;
    /**
     * 实体标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "deid",type=IdType.UUID)
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;
    /**
     * 实体类型
     */
    @TableField(value = "detype")
    @JSONField(name = "detype")
    @JsonProperty("detype")
    private Integer detype;
    /**
     * 逻辑名称
     */
    @TableField(value = "delogicname")
    @JSONField(name = "delogicname")
    @JsonProperty("delogicname")
    private String delogicname;
    /**
     * 启用数据权限
     */
    @TableField(value = "isenabledp")
    @JSONField(name = "isenabledp")
    @JsonProperty("isenabledp")
    private Integer isenabledp;
    /**
     * 启用全局模型缓存
     */
    @TableField(value = "enableglobalmodel")
    @JSONField(name = "enableglobalmodel")
    @JsonProperty("enableglobalmodel")
    private Integer enableglobalmodel;
    /**
     * 导出模型包含空值
     */
    @TableField(value = "exportincempty")
    @JSONField(name = "exportincempty")
    @JsonProperty("exportincempty")
    private Integer exportincempty;
    /**
     * 启用逻辑有效
     */
    @TableField(value = "islogicvalid")
    @JSONField(name = "islogicvalid")
    @JsonProperty("islogicvalid")
    private Integer islogicvalid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 视图名称
     */
    @TableField(value = "viewname")
    @JSONField(name = "viewname")
    @JsonProperty("viewname")
    private String viewname;
    /**
     * 打印功能
     */
    @TableField(value = "printfunc")
    @JSONField(name = "printfunc")
    @JsonProperty("printfunc")
    private String printfunc;
    /**
     * 动态表间隔时间
     */
    @TableField(value = "dynamicinterval")
    @JSONField(name = "dynamicinterval")
    @JsonProperty("dynamicinterval")
    private Integer dynamicinterval;
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
     * 版本属性
     */
    @TableField(value = "verfield")
    @JSONField(name = "verfield")
    @JsonProperty("verfield")
    private String verfield;
    /**
     * 自动填充附加信息
     */
    @TableField(value = "acextinfo")
    @JSONField(name = "acextinfo")
    @JsonProperty("acextinfo")
    private String acextinfo;
    /**
     * 表格信息区高度
     */
    @TableField(value = "dgsummaryheight")
    @JSONField(name = "dgsummaryheight")
    @JsonProperty("dgsummaryheight")
    private Integer dgsummaryheight;
    /**
     * 自动填充处理对象
     */
    @TableField(value = "acobject")
    @JSONField(name = "acobject")
    @JsonProperty("acobject")
    private String acobject;
    /**
     * 运行信息
     */
    @TableField(exist = false)
    @JSONField(name = "rtinfo")
    @JsonProperty("rtinfo")
    private String rtinfo;
    /**
     * 多选打印
     */
    @TableField(value = "ismultiprint")
    @JSONField(name = "ismultiprint")
    @JsonProperty("ismultiprint")
    private Integer ismultiprint;
    /**
     * 附表名称
     */
    @TableField(value = "minortablename")
    @JSONField(name = "minortablename")
    @JsonProperty("minortablename")
    private String minortablename;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 表格行样式辅助对象
     */
    @TableField(value = "dgrowclasshelper")
    @JSONField(name = "dgrowclasshelper")
    @JsonProperty("dgrowclasshelper")
    private String dgrowclasshelper;
    /**
     * 用户表
     */
    @TableField(value = "extablename")
    @JSONField(name = "extablename")
    @JsonProperty("extablename")
    private String extablename;
    /**
     * 实体参数
     */
    @TableField(value = "deparam")
    @JSONField(name = "deparam")
    @JsonProperty("deparam")
    private String deparam;
    /**
     * 全局模型对象
     */
    @TableField(value = "globalmodelobj")
    @JSONField(name = "globalmodelobj")
    @JsonProperty("globalmodelobj")
    private String globalmodelobj;
    /**
     * 索引模式
     */
    @TableField(value = "indexmode")
    @JSONField(name = "indexmode")
    @JsonProperty("indexmode")
    private Integer indexmode;
    /**
     * 保留1
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 无数据信息
     */
    @TableField(value = "nodatainfo")
    @JSONField(name = "nodatainfo")
    @JsonProperty("nodatainfo")
    private Integer nodatainfo;
    /**
     * 继承模式
     */
    @TableField(value = "inheritmode")
    @JSONField(name = "inheritmode")
    @JsonProperty("inheritmode")
    private Integer inheritmode;
    /**
     * 信息属性参数
     */
    @TableField(value = "infofield")
    @JSONField(name = "infofield")
    @JsonProperty("infofield")
    private String infofield;
    /**
     * 实体次序
     */
    @TableField(value = "deorder")
    @JSONField(name = "deorder")
    @JsonProperty("deorder")
    private Integer deorder;
    /**
     * 大图标
     */
    @TableField(value = "bigicon")
    @JSONField(name = "bigicon")
    @JsonProperty("bigicon")
    private String bigicon;
    /**
     * 配置辅助对象
     */
    @TableField(value = "confighelper")
    @JSONField(name = "confighelper")
    @JsonProperty("confighelper")
    private String confighelper;
    /**
     * 实体存储类型
     */
    @TableField(value = "storagetype")
    @JSONField(name = "storagetype")
    @JsonProperty("storagetype")
    private String storagetype;
    /**
     * 版本检查间隔
     */
    @TableField(value = "verchecktimer")
    @JSONField(name = "verchecktimer")
    @JsonProperty("verchecktimer")
    private Integer verchecktimer;
    /**
     * 启用审计
     */
    @TableField(value = "isenableaudit")
    @JSONField(name = "isenableaudit")
    @JsonProperty("isenableaudit")
    private Integer isenableaudit;
    /**
     * 授权代码
     */
    @TableField(value = "licensecode")
    @JSONField(name = "licensecode")
    @JsonProperty("licensecode")
    private String licensecode;
    /**
     * 启用列权限控制
     */
    @TableField(value = "enablecolpriv")
    @JSONField(name = "enablecolpriv")
    @JsonProperty("enablecolpriv")
    private Integer enablecolpriv;
    /**
     * 数据访问对象接口
     */
    @TableField(value = "datactrlint")
    @JSONField(name = "datactrlint")
    @JsonProperty("datactrlint")
    private String datactrlint;
    /**
     * 数据附件
     */
    @TableField(value = "issupportfa")
    @JSONField(name = "issupportfa")
    @JsonProperty("issupportfa")
    private Integer issupportfa;
    /**
     * 实体用户参数
     */
    @TableField(value = "deuserparam")
    @JSONField(name = "deuserparam")
    @JsonProperty("deuserparam")
    private String deuserparam;
    /**
     * 数据变更日志类型
     */
    @TableField(value = "datachglogmode")
    @JSONField(name = "datachglogmode")
    @JsonProperty("datachglogmode")
    private Integer datachglogmode;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 版本辅助对象
     */
    @TableField(value = "verhelper")
    @JSONField(name = "verhelper")
    @JsonProperty("verhelper")
    private String verhelper;
    /**
     * 数据访问控制对象
     */
    @TableField(value = "dataaccobject")
    @JSONField(name = "dataaccobject")
    @JsonProperty("dataaccobject")
    private String dataaccobject;
    /**
     * 版本检查
     */
    @TableField(value = "versioncheck")
    @JSONField(name = "versioncheck")
    @JsonProperty("versioncheck")
    private Integer versioncheck;
    /**
     * 版本
     */
    @TableField(value = "deversion")
    @JSONField(name = "deversion")
    @JsonProperty("deversion")
    private Integer deversion;
    /**
     * 提示信息
     */
    @TableField(value = "tipsinfo")
    @JSONField(name = "tipsinfo")
    @JsonProperty("tipsinfo")
    private String tipsinfo;
    /**
     * 启用表格行编辑
     */
    @TableField(value = "isdgrowedit")
    @JSONField(name = "isdgrowedit")
    @JsonProperty("isdgrowedit")
    private Integer isdgrowedit;
    /**
     * 实体表空间
     */
    @TableField(value = "tablespace")
    @JSONField(name = "tablespace")
    @JsonProperty("tablespace")
    private String tablespace;
    /**
     * 数据锁辅助对象
     */
    @TableField(value = "dlkhelper")
    @JSONField(name = "dlkhelper")
    @JsonProperty("dlkhelper")
    private String dlkhelper;
    /**
     * 用户数据行为
     */
    @TableField(value = "useraction")
    @JSONField(name = "useraction")
    @JsonProperty("useraction")
    private Integer useraction;
    /**
     * 自填排序字段
     */
    @TableField(value = "acsortfield")
    @JSONField(name = "acsortfield")
    @JsonProperty("acsortfield")
    private String acsortfield;
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
     * 附表标识字段
     */
    @TableField(value = "minorfieldname")
    @JSONField(name = "minorfieldname")
    @JsonProperty("minorfieldname")
    private String minorfieldname;
    /**
     * 数据库存储
     */
    @TableField(value = "dbstorage")
    @JSONField(name = "dbstorage")
    @JsonProperty("dbstorage")
    private String dbstorage;
    /**
     * 保留2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 信息格式化
     */
    @TableField(value = "infoformat")
    @JSONField(name = "infoformat")
    @JsonProperty("infoformat")
    private String infoformat;
    /**
     * 数据访问对象
     */
    @TableField(value = "datactrlobject")
    @JSONField(name = "datactrlobject")
    @JsonProperty("datactrlobject")
    private String datactrlobject;
    /**
     * 主键参数
     */
    @TableField(value = "keyparams")
    @JSONField(name = "keyparams")
    @JsonProperty("keyparams")
    private String keyparams;
    /**
     * 自动排序方向
     */
    @TableField(value = "acsortdir")
    @JSONField(name = "acsortdir")
    @JsonProperty("acsortdir")
    private String acsortdir;
    /**
     * DER11DENAME
     */
    @TableField(exist = false)
    @JSONField(name = "der11dename")
    @JsonProperty("der11dename")
    private String der11dename;
    /**
     * 自填查询模型
     */
    @TableField(exist = false)
    @JSONField(name = "acquerymodelname")
    @JsonProperty("acquerymodelname")
    private String acquerymodelname;
    /**
     * 数据实体_自填查询模型
     */
    @TableField(value = "acquerymodelid")
    @JSONField(name = "acquerymodelid")
    @JsonProperty("acquerymodelid")
    private String acquerymodelid;
    /**
     * 1:1关系实体
     */
    @TableField(value = "der11deid")
    @JSONField(name = "der11deid")
    @JsonProperty("der11deid")
    private String der11deid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.DataEntity der11de;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.QueryModel acquerymodel;



    /**
     * 设置 [小图标]
     */
    public void setSmallicon(String smallicon){
        this.smallicon = smallicon ;
        this.modify("smallicon",smallicon);
    }
    /**
     * 设置 [实体归属]
     */
    public void setDegroup(String degroup){
        this.degroup = degroup ;
        this.modify("degroup",degroup);
    }
    /**
     * 设置 [实体名称]
     */
    public void setDename(String dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }
    /**
     * 设置 [多主实体模式]
     */
    public void setMutlimajor(Integer mutlimajor){
        this.mutlimajor = mutlimajor ;
        this.modify("multimajor",mutlimajor);
    }
    /**
     * 设置 [自动填充信息格式]
     */
    public void setAcinfoformat(String acinfoformat){
        this.acinfoformat = acinfoformat ;
        this.modify("acinfoformat",acinfoformat);
    }
    /**
     * 设置 [自填最大数量]
     */
    public void setAcmaxcnt(Integer acmaxcnt){
        this.acmaxcnt = acmaxcnt ;
        this.modify("acmaxcnt",acmaxcnt);
    }
    /**
     * 设置 [索引实体]
     */
    public void setIsindexde(Integer isindexde){
        this.isindexde = isindexde ;
        this.modify("isindexde",isindexde);
    }
    /**
     * 设置 [现存模型]
     */
    public void setExitingmodel(Integer exitingmodel){
        this.exitingmodel = exitingmodel ;
        this.modify("exitingmodel",exitingmodel);
    }
    /**
     * 设置 [启用数据版本控制]
     */
    public void setVcflag(Integer vcflag){
        this.vcflag = vcflag ;
        this.modify("vcflag",vcflag);
    }
    /**
     * 设置 [数据对象类]
     */
    public void setDeobject(String deobject){
        this.deobject = deobject ;
        this.modify("deobject",deobject);
    }
    /**
     * 设置 [记录数量]
     */
    public void setRowamout(Integer rowamout){
        this.rowamout = rowamout ;
        this.modify("rowamount",rowamout);
    }
    /**
     * 设置 [启动自填数据权限]
     */
    public void setAcenabledp(Integer acenabledp){
        this.acenabledp = acenabledp ;
        this.modify("acenabledp",acenabledp);
    }
    /**
     * 设置 [记录审计明细]
     */
    public void setLogauditdetail(Integer logauditdetail){
        this.logauditdetail = logauditdetail ;
        this.modify("logauditdetail",logauditdetail);
    }
    /**
     * 设置 [附表标识值]
     */
    public void setMinorfieldvalue(String minorfieldvalue){
        this.minorfieldvalue = minorfieldvalue ;
        this.modify("minorfieldvalue",minorfieldvalue);
    }
    /**
     * 设置 [是否启用]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [数据通知辅助对象]
     */
    public void setDatanotifyhelper(String datanotifyhelper){
        this.datanotifyhelper = datanotifyhelper ;
        this.modify("datanotifyhelper",datanotifyhelper);
    }
    /**
     * 设置 [数据结构版本]
     */
    public void setDbversion(Integer dbversion){
        this.dbversion = dbversion ;
        this.modify("dbversion",dbversion);
    }
    /**
     * 设置 [系统实体]
     */
    public void setIssystem(Integer issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }
    /**
     * 设置 [自动填充信息参数]
     */
    public void setAcinfoparam(String acinfoparam){
        this.acinfoparam = acinfoparam ;
        this.modify("acinfoparam",acinfoparam);
    }
    /**
     * 设置 [实体辅助对象]
     */
    public void setDehelper(String dehelper){
        this.dehelper = dehelper ;
        this.modify("dehelper",dehelper);
    }
    /**
     * 设置 [表名称]
     */
    public void setTablename(String tablename){
        this.tablename = tablename ;
        this.modify("tablename",tablename);
    }
    /**
     * 设置 [实体类型]
     */
    public void setDetype(Integer detype){
        this.detype = detype ;
        this.modify("detype",detype);
    }
    /**
     * 设置 [逻辑名称]
     */
    public void setDelogicname(String delogicname){
        this.delogicname = delogicname ;
        this.modify("delogicname",delogicname);
    }
    /**
     * 设置 [启用数据权限]
     */
    public void setIsenabledp(Integer isenabledp){
        this.isenabledp = isenabledp ;
        this.modify("isenabledp",isenabledp);
    }
    /**
     * 设置 [启用全局模型缓存]
     */
    public void setEnableglobalmodel(Integer enableglobalmodel){
        this.enableglobalmodel = enableglobalmodel ;
        this.modify("enableglobalmodel",enableglobalmodel);
    }
    /**
     * 设置 [导出模型包含空值]
     */
    public void setExportincempty(Integer exportincempty){
        this.exportincempty = exportincempty ;
        this.modify("exportincempty",exportincempty);
    }
    /**
     * 设置 [启用逻辑有效]
     */
    public void setIslogicvalid(Integer islogicvalid){
        this.islogicvalid = islogicvalid ;
        this.modify("islogicvalid",islogicvalid);
    }
    /**
     * 设置 [视图名称]
     */
    public void setViewname(String viewname){
        this.viewname = viewname ;
        this.modify("viewname",viewname);
    }
    /**
     * 设置 [打印功能]
     */
    public void setPrintfunc(String printfunc){
        this.printfunc = printfunc ;
        this.modify("printfunc",printfunc);
    }
    /**
     * 设置 [动态表间隔时间]
     */
    public void setDynamicinterval(Integer dynamicinterval){
        this.dynamicinterval = dynamicinterval ;
        this.modify("dynamicinterval",dynamicinterval);
    }
    /**
     * 设置 [版本属性]
     */
    public void setVerfield(String verfield){
        this.verfield = verfield ;
        this.modify("verfield",verfield);
    }
    /**
     * 设置 [自动填充附加信息]
     */
    public void setAcextinfo(String acextinfo){
        this.acextinfo = acextinfo ;
        this.modify("acextinfo",acextinfo);
    }
    /**
     * 设置 [表格信息区高度]
     */
    public void setDgsummaryheight(Integer dgsummaryheight){
        this.dgsummaryheight = dgsummaryheight ;
        this.modify("dgsummaryheight",dgsummaryheight);
    }
    /**
     * 设置 [自动填充处理对象]
     */
    public void setAcobject(String acobject){
        this.acobject = acobject ;
        this.modify("acobject",acobject);
    }
    /**
     * 设置 [多选打印]
     */
    public void setIsmultiprint(Integer ismultiprint){
        this.ismultiprint = ismultiprint ;
        this.modify("ismultiprint",ismultiprint);
    }
    /**
     * 设置 [附表名称]
     */
    public void setMinortablename(String minortablename){
        this.minortablename = minortablename ;
        this.modify("minortablename",minortablename);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [表格行样式辅助对象]
     */
    public void setDgrowclasshelper(String dgrowclasshelper){
        this.dgrowclasshelper = dgrowclasshelper ;
        this.modify("dgrowclasshelper",dgrowclasshelper);
    }
    /**
     * 设置 [用户表]
     */
    public void setExtablename(String extablename){
        this.extablename = extablename ;
        this.modify("extablename",extablename);
    }
    /**
     * 设置 [实体参数]
     */
    public void setDeparam(String deparam){
        this.deparam = deparam ;
        this.modify("deparam",deparam);
    }
    /**
     * 设置 [全局模型对象]
     */
    public void setGlobalmodelobj(String globalmodelobj){
        this.globalmodelobj = globalmodelobj ;
        this.modify("globalmodelobj",globalmodelobj);
    }
    /**
     * 设置 [索引模式]
     */
    public void setIndexmode(Integer indexmode){
        this.indexmode = indexmode ;
        this.modify("indexmode",indexmode);
    }
    /**
     * 设置 [保留1]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [无数据信息]
     */
    public void setNodatainfo(Integer nodatainfo){
        this.nodatainfo = nodatainfo ;
        this.modify("nodatainfo",nodatainfo);
    }
    /**
     * 设置 [继承模式]
     */
    public void setInheritmode(Integer inheritmode){
        this.inheritmode = inheritmode ;
        this.modify("inheritmode",inheritmode);
    }
    /**
     * 设置 [信息属性参数]
     */
    public void setInfofield(String infofield){
        this.infofield = infofield ;
        this.modify("infofield",infofield);
    }
    /**
     * 设置 [实体次序]
     */
    public void setDeorder(Integer deorder){
        this.deorder = deorder ;
        this.modify("deorder",deorder);
    }
    /**
     * 设置 [大图标]
     */
    public void setBigicon(String bigicon){
        this.bigicon = bigicon ;
        this.modify("bigicon",bigicon);
    }
    /**
     * 设置 [配置辅助对象]
     */
    public void setConfighelper(String confighelper){
        this.confighelper = confighelper ;
        this.modify("confighelper",confighelper);
    }
    /**
     * 设置 [实体存储类型]
     */
    public void setStoragetype(String storagetype){
        this.storagetype = storagetype ;
        this.modify("storagetype",storagetype);
    }
    /**
     * 设置 [版本检查间隔]
     */
    public void setVerchecktimer(Integer verchecktimer){
        this.verchecktimer = verchecktimer ;
        this.modify("verchecktimer",verchecktimer);
    }
    /**
     * 设置 [启用审计]
     */
    public void setIsenableaudit(Integer isenableaudit){
        this.isenableaudit = isenableaudit ;
        this.modify("isenableaudit",isenableaudit);
    }
    /**
     * 设置 [授权代码]
     */
    public void setLicensecode(String licensecode){
        this.licensecode = licensecode ;
        this.modify("licensecode",licensecode);
    }
    /**
     * 设置 [启用列权限控制]
     */
    public void setEnablecolpriv(Integer enablecolpriv){
        this.enablecolpriv = enablecolpriv ;
        this.modify("enablecolpriv",enablecolpriv);
    }
    /**
     * 设置 [数据访问对象接口]
     */
    public void setDatactrlint(String datactrlint){
        this.datactrlint = datactrlint ;
        this.modify("datactrlint",datactrlint);
    }
    /**
     * 设置 [数据附件]
     */
    public void setIssupportfa(Integer issupportfa){
        this.issupportfa = issupportfa ;
        this.modify("issupportfa",issupportfa);
    }
    /**
     * 设置 [实体用户参数]
     */
    public void setDeuserparam(String deuserparam){
        this.deuserparam = deuserparam ;
        this.modify("deuserparam",deuserparam);
    }
    /**
     * 设置 [数据变更日志类型]
     */
    public void setDatachglogmode(Integer datachglogmode){
        this.datachglogmode = datachglogmode ;
        this.modify("datachglogmode",datachglogmode);
    }
    /**
     * 设置 [版本辅助对象]
     */
    public void setVerhelper(String verhelper){
        this.verhelper = verhelper ;
        this.modify("verhelper",verhelper);
    }
    /**
     * 设置 [数据访问控制对象]
     */
    public void setDataaccobject(String dataaccobject){
        this.dataaccobject = dataaccobject ;
        this.modify("dataaccobject",dataaccobject);
    }
    /**
     * 设置 [版本检查]
     */
    public void setVersioncheck(Integer versioncheck){
        this.versioncheck = versioncheck ;
        this.modify("versioncheck",versioncheck);
    }
    /**
     * 设置 [版本]
     */
    public void setDeversion(Integer deversion){
        this.deversion = deversion ;
        this.modify("deversion",deversion);
    }
    /**
     * 设置 [提示信息]
     */
    public void setTipsinfo(String tipsinfo){
        this.tipsinfo = tipsinfo ;
        this.modify("tipsinfo",tipsinfo);
    }
    /**
     * 设置 [启用表格行编辑]
     */
    public void setIsdgrowedit(Integer isdgrowedit){
        this.isdgrowedit = isdgrowedit ;
        this.modify("isdgrowedit",isdgrowedit);
    }
    /**
     * 设置 [实体表空间]
     */
    public void setTablespace(String tablespace){
        this.tablespace = tablespace ;
        this.modify("tablespace",tablespace);
    }
    /**
     * 设置 [数据锁辅助对象]
     */
    public void setDlkhelper(String dlkhelper){
        this.dlkhelper = dlkhelper ;
        this.modify("dlkhelper",dlkhelper);
    }
    /**
     * 设置 [用户数据行为]
     */
    public void setUseraction(Integer useraction){
        this.useraction = useraction ;
        this.modify("useraction",useraction);
    }
    /**
     * 设置 [自填排序字段]
     */
    public void setAcsortfield(String acsortfield){
        this.acsortfield = acsortfield ;
        this.modify("acsortfield",acsortfield);
    }
    /**
     * 设置 [附表标识字段]
     */
    public void setMinorfieldname(String minorfieldname){
        this.minorfieldname = minorfieldname ;
        this.modify("minorfieldname",minorfieldname);
    }
    /**
     * 设置 [数据库存储]
     */
    public void setDbstorage(String dbstorage){
        this.dbstorage = dbstorage ;
        this.modify("dbstorage",dbstorage);
    }
    /**
     * 设置 [保留2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [信息格式化]
     */
    public void setInfoformat(String infoformat){
        this.infoformat = infoformat ;
        this.modify("infoformat",infoformat);
    }
    /**
     * 设置 [数据访问对象]
     */
    public void setDatactrlobject(String datactrlobject){
        this.datactrlobject = datactrlobject ;
        this.modify("datactrlobject",datactrlobject);
    }
    /**
     * 设置 [主键参数]
     */
    public void setKeyparams(String keyparams){
        this.keyparams = keyparams ;
        this.modify("keyparams",keyparams);
    }
    /**
     * 设置 [自动排序方向]
     */
    public void setAcsortdir(String acsortdir){
        this.acsortdir = acsortdir ;
        this.modify("acsortdir",acsortdir);
    }
    /**
     * 设置 [数据实体_自填查询模型]
     */
    public void setAcquerymodelid(String acquerymodelid){
        this.acquerymodelid = acquerymodelid ;
        this.modify("acquerymodelid",acquerymodelid);
    }
    /**
     * 设置 [1:1关系实体]
     */
    public void setDer11deid(String der11deid){
        this.der11deid = der11deid ;
        this.modify("der11deid",der11deid);
    }
}






