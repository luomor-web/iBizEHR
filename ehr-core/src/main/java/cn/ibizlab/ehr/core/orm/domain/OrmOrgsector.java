package cn.ibizlab.ehr.core.orm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[部门管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SRFORGSECTOR",resultMap = "OrmOrgsectorResultMap")
public class OrmOrgsector extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目基本情况
     */
    @TableField(value = "xmjbqk")
    @JSONField(name = "xmjbqk")
    @JsonProperty("xmjbqk")
    private String xmjbqk;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 排序号
     */
    @DEField(preType = DEPredefinedFieldType.ORDERVALUE)
    @TableField(value = "ordervalue")
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 补贴标准
     */
    @TableField(value = "qy")
    @JSONField(name = "qy")
    @JsonProperty("qy")
    private String qy;
    /**
     * 版本
     */
    @DEField(defaultValue = "1.0")
    @TableField(value = "edition")
    @JSONField(name = "edition")
    @JsonProperty("edition")
    private Double edition;
    /**
     * 上班时间
     */
    @TableField(value = "sbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;
    /**
     * 下班时间
     */
    @TableField(value = "xbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;
    /**
     * 启停标识
     */
    @DEField(defaultValue = "1")
    @TableField(value = "startstopsign")
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;
    /**
     * 部门计划编制人数
     */
    @TableField(value = "bmbzrs")
    @JSONField(name = "bmbzrs")
    @JsonProperty("bmbzrs")
    private Integer bmbzrs;
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
     * 部门实际编制人数
     */
    @TableField(value = "bmsjbzrs")
    @JSONField(name = "bmsjbzrs")
    @JsonProperty("bmsjbzrs")
    private Integer bmsjbzrs;
    /**
     * 工程名称及编码
     */
    @TableField(value = "gcmcjbm")
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;
    /**
     * 项目标签
     */
    @TableField(value = "xmbq")
    @JSONField(name = "xmbq")
    @JsonProperty("xmbq")
    private String xmbq;
    /**
     * 原纪录ID
     */
    @TableField(value = "oldid")
    @JSONField(name = "oldid")
    @JsonProperty("oldid")
    private String oldid;
    /**
     * 上班考勤时间
     */
    @TableField(value = "kqkssj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqkssj" , format="HH:mm")
    @JsonProperty("kqkssj")
    private Timestamp kqkssj;
    /**
     * 部门编号
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 岗位编制数量
     */
    @TableField(exist = false)
    @JSONField(name = "gwbzsl")
    @JsonProperty("gwbzsl")
    private String gwbzsl;
    /**
     * 超编人数的颜色
     */
    @TableField(exist = false)
    @JSONField(name = "sjbzrs_color")
    @JsonProperty("sjbzrs_color")
    private String sjbzrsColor;
    /**
     * 计划人月
     */
    @TableField(value = "jhry")
    @JSONField(name = "jhry")
    @JsonProperty("jhry")
    private Double jhry;
    /**
     * 审批状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "approvalstatus")
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;
    /**
     * 相差成本(万)
     */
    @TableField(exist = false)
    @JSONField(name = "xccb")
    @JsonProperty("xccb")
    private Double xccb;
    /**
     * 下班考勤时间
     */
    @TableField(value = "kqjssj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqjssj" , format="HH:mm")
    @JsonProperty("kqjssj")
    private Timestamp kqjssj;
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
     * 项目类型
     */
    @TableField(value = "xmlx")
    @JSONField(name = "xmlx")
    @JsonProperty("xmlx")
    private String xmlx;
    /**
     * 组织类型
     */
    @TableField(value = "orgtype")
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;
    /**
     * 职务编制数量
     */
    @TableField(exist = false)
    @JSONField(name = "zwbzsl")
    @JsonProperty("zwbzsl")
    private String zwbzsl;
    /**
     * ERP部门ID
     */
    @TableField(value = "erporgid")
    @JSONField(name = "erporgid")
    @JsonProperty("erporgid")
    private String erporgid;
    /**
     * 打卡方式
     */
    @DEField(defaultValue = "30")
    @TableField(value = "dkfs")
    @JSONField(name = "dkfs")
    @JsonProperty("dkfs")
    private String dkfs;
    /**
     * 项目类型（其他）
     */
    @TableField(value = "xmlxqt")
    @JSONField(name = "xmlxqt")
    @JsonProperty("xmlxqt")
    private String xmlxqt;
    /**
     * 实际人数（部门）
     */
    @TableField(value = "sjrs")
    @JSONField(name = "sjrs")
    @JsonProperty("sjrs")
    private Integer sjrs;
    /**
     * 部门名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGSECTORNAME)
    @TableField(value = "orgsectorname")
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;
    /**
     * 职务数量
     */
    @TableField(value = "zwsl")
    @JSONField(name = "zwsl")
    @JsonProperty("zwsl")
    private Integer zwsl;
    /**
     * 所含岗位数量
     */
    @TableField(value = "shgwsl")
    @JSONField(name = "shgwsl")
    @JsonProperty("shgwsl")
    private Integer shgwsl;
    /**
     * 项目规模
     */
    @TableField(value = "xmgm")
    @JSONField(name = "xmgm")
    @JsonProperty("xmgm")
    private String xmgm;
    /**
     * 相差人月
     */
    @TableField(exist = false)
    @JSONField(name = "xcry")
    @JsonProperty("xcry")
    private Double xcry;
    /**
     * 岗位数量
     */
    @TableField(value = "gwsl")
    @JSONField(name = "gwsl")
    @JsonProperty("gwsl")
    private Integer gwsl;
    /**
     * 对项目经理的要求
     */
    @TableField(value = "dxmjlyq")
    @JSONField(name = "dxmjlyq")
    @JsonProperty("dxmjlyq")
    private String dxmjlyq;
    /**
     * 对项目总工的要求
     */
    @TableField(value = "dxmzgyq")
    @JSONField(name = "dxmzgyq")
    @JsonProperty("dxmzgyq")
    private String dxmzgyq;
    /**
     * 头衔
     */
    @TableField(value = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    private String title;
    /**
     * 启用标志
     */
    @DEField(defaultValue = "1")
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 实际编制人数
     */
    @TableField(exist = false)
    @JSONField(name = "sjbzrs")
    @JsonProperty("sjbzrs")
    private String sjbzrs;
    /**
     * 参照职务层级
     */
    @TableField(value = "referjoblevel")
    @JSONField(name = "referjoblevel")
    @JsonProperty("referjoblevel")
    private String referjoblevel;
    /**
     * 所属OU
     */
    @TableField(value = "belongou")
    @JSONField(name = "belongou")
    @JsonProperty("belongou")
    private String belongou;
    /**
     * 所含职务数量
     */
    @TableField(value = "shzwsl")
    @JSONField(name = "shzwsl")
    @JsonProperty("shzwsl")
    private Integer shzwsl;
    /**
     * 简称
     */
    @TableField(value = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 工期安排
     */
    @TableField(value = "gqap")
    @JSONField(name = "gqap")
    @JsonProperty("gqap")
    private String gqap;
    /**
     * 计划成本（万）
     */
    @TableField(value = "jhcb")
    @JSONField(name = "jhcb")
    @JsonProperty("jhcb")
    private Double jhcb;
    /**
     * 部门类型
     */
    @TableField(value = "bmlx")
    @JSONField(name = "bmlx")
    @JsonProperty("bmlx")
    private String bmlx;
    /**
     * 项目部类型
     */
    @TableField(value = "xmblx")
    @JSONField(name = "xmblx")
    @JsonProperty("xmblx")
    private String xmblx;
    /**
     * 部门标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "orgsectorid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 管控机制
     */
    @TableField(value = "gkjz")
    @JSONField(name = "gkjz")
    @JsonProperty("gkjz")
    private String gkjz;
    /**
     * 版本状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "editionstate")
    @JSONField(name = "editionstate")
    @JsonProperty("editionstate")
    private String editionstate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 实际成本（万）
     */
    @TableField(value = "sjcb")
    @JSONField(name = "sjcb")
    @JsonProperty("sjcb")
    private Double sjcb;
    /**
     * 实际人月
     */
    @TableField(value = "sjry")
    @JSONField(name = "sjry")
    @JsonProperty("sjry")
    private Double sjry;
    /**
     * 所属区域
     */
    @TableField(value = "belongregion")
    @JSONField(name = "belongregion")
    @JsonProperty("belongregion")
    private String belongregion;
    /**
     * 项目规模
     */
    @TableField(exist = false)
    @JSONField(name = "engineeringscale")
    @JsonProperty("engineeringscale")
    private String engineeringscale;
    /**
     * 项目负责人
     */
    @TableField(exist = false)
    @JSONField(name = "proleadername")
    @JsonProperty("proleadername")
    private String proleadername;
    /**
     * 项目部名称
     */
    @TableField(exist = false)
    @JSONField(name = "prodepname")
    @JsonProperty("prodepname")
    private String prodepname;
    /**
     * 项目名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;
    /**
     * 部门负责人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织机构
     */
    @TableField(exist = false)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 项目编号
     */
    @TableField(exist = false)
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;
    /**
     * 上级部门
     */
    @TableField(exist = false)
    @JSONField(name = "porgsectorname")
    @JsonProperty("porgsectorname")
    private String porgsectorname;
    /**
     * 部门负责人ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 项目ID
     */
    @TableField(value = "ormxmglid")
    @JSONField(name = "ormxmglid")
    @JsonProperty("ormxmglid")
    private String ormxmglid;
    /**
     * 项目部ID
     */
    @TableField(value = "prodepid")
    @JSONField(name = "prodepid")
    @JsonProperty("prodepid")
    private String prodepid;
    /**
     * 项目负责人ID
     */
    @TableField(value = "proleaderid")
    @JSONField(name = "proleaderid")
    @JsonProperty("proleaderid")
    private String proleaderid;
    /**
     * 上级部门ID
     */
    @TableField(value = "porgsectorid")
    @JSONField(name = "porgsectorid")
    @JsonProperty("porgsectorid")
    private String porgsectorid;
    /**
     * 组织机构标识
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 上级部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector porgsector;

    /**
     * 项目部
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector prodep;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg org;

    /**
     * 项目
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmXmgl ormxmgl;

    /**
     * 部门负责人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 项目负责人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson proleader;



    /**
     * 设置 [项目基本情况]
     */
    public void setXmjbqk(String xmjbqk){
        this.xmjbqk = xmjbqk ;
        this.modify("xmjbqk",xmjbqk);
    }

    /**
     * 设置 [补贴标准]
     */
    public void setQy(String qy){
        this.qy = qy ;
        this.modify("qy",qy);
    }

    /**
     * 设置 [版本]
     */
    public void setEdition(Double edition){
        this.edition = edition ;
        this.modify("edition",edition);
    }

    /**
     * 设置 [上班时间]
     */
    public void setSbsj(Timestamp sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 格式化日期 [上班时间]
     */
    public String formatSbsj(){
        if (this.sbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(sbsj);
    }
    /**
     * 设置 [下班时间]
     */
    public void setXbsj(Timestamp xbsj){
        this.xbsj = xbsj ;
        this.modify("xbsj",xbsj);
    }

    /**
     * 格式化日期 [下班时间]
     */
    public String formatXbsj(){
        if (this.xbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(xbsj);
    }
    /**
     * 设置 [启停标识]
     */
    public void setStartstopsign(String startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [部门计划编制人数]
     */
    public void setBmbzrs(Integer bmbzrs){
        this.bmbzrs = bmbzrs ;
        this.modify("bmbzrs",bmbzrs);
    }

    /**
     * 设置 [部门实际编制人数]
     */
    public void setBmsjbzrs(Integer bmsjbzrs){
        this.bmsjbzrs = bmsjbzrs ;
        this.modify("bmsjbzrs",bmsjbzrs);
    }

    /**
     * 设置 [工程名称及编码]
     */
    public void setGcmcjbm(String gcmcjbm){
        this.gcmcjbm = gcmcjbm ;
        this.modify("gcmcjbm",gcmcjbm);
    }

    /**
     * 设置 [项目标签]
     */
    public void setXmbq(String xmbq){
        this.xmbq = xmbq ;
        this.modify("xmbq",xmbq);
    }

    /**
     * 设置 [原纪录ID]
     */
    public void setOldid(String oldid){
        this.oldid = oldid ;
        this.modify("oldid",oldid);
    }

    /**
     * 设置 [上班考勤时间]
     */
    public void setKqkssj(Timestamp kqkssj){
        this.kqkssj = kqkssj ;
        this.modify("kqkssj",kqkssj);
    }

    /**
     * 格式化日期 [上班考勤时间]
     */
    public String formatKqkssj(){
        if (this.kqkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(kqkssj);
    }
    /**
     * 设置 [部门编号]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [计划人月]
     */
    public void setJhry(Double jhry){
        this.jhry = jhry ;
        this.modify("jhry",jhry);
    }

    /**
     * 设置 [审批状态]
     */
    public void setApprovalstatus(String approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [下班考勤时间]
     */
    public void setKqjssj(Timestamp kqjssj){
        this.kqjssj = kqjssj ;
        this.modify("kqjssj",kqjssj);
    }

    /**
     * 格式化日期 [下班考勤时间]
     */
    public String formatKqjssj(){
        if (this.kqjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(kqjssj);
    }
    /**
     * 设置 [项目类型]
     */
    public void setXmlx(String xmlx){
        this.xmlx = xmlx ;
        this.modify("xmlx",xmlx);
    }

    /**
     * 设置 [组织类型]
     */
    public void setOrgtype(String orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [ERP部门ID]
     */
    public void setErporgid(String erporgid){
        this.erporgid = erporgid ;
        this.modify("erporgid",erporgid);
    }

    /**
     * 设置 [打卡方式]
     */
    public void setDkfs(String dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
    }

    /**
     * 设置 [项目类型（其他）]
     */
    public void setXmlxqt(String xmlxqt){
        this.xmlxqt = xmlxqt ;
        this.modify("xmlxqt",xmlxqt);
    }

    /**
     * 设置 [实际人数（部门）]
     */
    public void setSjrs(Integer sjrs){
        this.sjrs = sjrs ;
        this.modify("sjrs",sjrs);
    }

    /**
     * 设置 [职务数量]
     */
    public void setZwsl(Integer zwsl){
        this.zwsl = zwsl ;
        this.modify("zwsl",zwsl);
    }

    /**
     * 设置 [所含岗位数量]
     */
    public void setShgwsl(Integer shgwsl){
        this.shgwsl = shgwsl ;
        this.modify("shgwsl",shgwsl);
    }

    /**
     * 设置 [项目规模]
     */
    public void setXmgm(String xmgm){
        this.xmgm = xmgm ;
        this.modify("xmgm",xmgm);
    }

    /**
     * 设置 [岗位数量]
     */
    public void setGwsl(Integer gwsl){
        this.gwsl = gwsl ;
        this.modify("gwsl",gwsl);
    }

    /**
     * 设置 [对项目经理的要求]
     */
    public void setDxmjlyq(String dxmjlyq){
        this.dxmjlyq = dxmjlyq ;
        this.modify("dxmjlyq",dxmjlyq);
    }

    /**
     * 设置 [对项目总工的要求]
     */
    public void setDxmzgyq(String dxmzgyq){
        this.dxmzgyq = dxmzgyq ;
        this.modify("dxmzgyq",dxmzgyq);
    }

    /**
     * 设置 [头衔]
     */
    public void setTitle(String title){
        this.title = title ;
        this.modify("title",title);
    }

    /**
     * 设置 [启用标志]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [参照职务层级]
     */
    public void setReferjoblevel(String referjoblevel){
        this.referjoblevel = referjoblevel ;
        this.modify("referjoblevel",referjoblevel);
    }

    /**
     * 设置 [所属OU]
     */
    public void setBelongou(String belongou){
        this.belongou = belongou ;
        this.modify("belongou",belongou);
    }

    /**
     * 设置 [所含职务数量]
     */
    public void setShzwsl(Integer shzwsl){
        this.shzwsl = shzwsl ;
        this.modify("shzwsl",shzwsl);
    }

    /**
     * 设置 [简称]
     */
    public void setShortname(String shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [工期安排]
     */
    public void setGqap(String gqap){
        this.gqap = gqap ;
        this.modify("gqap",gqap);
    }

    /**
     * 设置 [计划成本（万）]
     */
    public void setJhcb(Double jhcb){
        this.jhcb = jhcb ;
        this.modify("jhcb",jhcb);
    }

    /**
     * 设置 [部门类型]
     */
    public void setBmlx(String bmlx){
        this.bmlx = bmlx ;
        this.modify("bmlx",bmlx);
    }

    /**
     * 设置 [项目部类型]
     */
    public void setXmblx(String xmblx){
        this.xmblx = xmblx ;
        this.modify("xmblx",xmblx);
    }

    /**
     * 设置 [管控机制]
     */
    public void setGkjz(String gkjz){
        this.gkjz = gkjz ;
        this.modify("gkjz",gkjz);
    }

    /**
     * 设置 [版本状态]
     */
    public void setEditionstate(String editionstate){
        this.editionstate = editionstate ;
        this.modify("editionstate",editionstate);
    }

    /**
     * 设置 [实际成本（万）]
     */
    public void setSjcb(Double sjcb){
        this.sjcb = sjcb ;
        this.modify("sjcb",sjcb);
    }

    /**
     * 设置 [实际人月]
     */
    public void setSjry(Double sjry){
        this.sjry = sjry ;
        this.modify("sjry",sjry);
    }

    /**
     * 设置 [所属区域]
     */
    public void setBelongregion(String belongregion){
        this.belongregion = belongregion ;
        this.modify("belongregion",belongregion);
    }

    /**
     * 设置 [部门负责人ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [项目ID]
     */
    public void setOrmxmglid(String ormxmglid){
        this.ormxmglid = ormxmglid ;
        this.modify("ormxmglid",ormxmglid);
    }

    /**
     * 设置 [项目部ID]
     */
    public void setProdepid(String prodepid){
        this.prodepid = prodepid ;
        this.modify("prodepid",prodepid);
    }

    /**
     * 设置 [项目负责人ID]
     */
    public void setProleaderid(String proleaderid){
        this.proleaderid = proleaderid ;
        this.modify("proleaderid",proleaderid);
    }

    /**
     * 设置 [上级部门ID]
     */
    public void setPorgsectorid(String porgsectorid){
        this.porgsectorid = porgsectorid ;
        this.modify("porgsectorid",porgsectorid);
    }


}


