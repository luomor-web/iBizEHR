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
 * 实体[项目需求计划]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMXQJH",resultMap = "OrmXmxqjhResultMap")
public class OrmXmxqjh extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 源记录ID
     */
    @TableField(value = "oldid")
    @JSONField(name = "oldid")
    @JsonProperty("oldid")
    private String oldid;
    /**
     * 建筑面积（㎡）
     */
    @TableField(value = "jzmj")
    @JSONField(name = "jzmj")
    @JsonProperty("jzmj")
    private Double jzmj;
    /**
     * 组织简称
     */
    @TableField(value = "orgshortname")
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;
    /**
     * ①施工前期准备阶段：
     */
    @TableField(value = "gqap")
    @JSONField(name = "gqap")
    @JsonProperty("gqap")
    private String gqap;
    /**
     * 项目规模描述
     */
    @TableField(value = "xmgmms")
    @JSONField(name = "xmgmms")
    @JsonProperty("xmgmms")
    private String xmgmms;
    /**
     * 审批状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "approvalstatus")
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;
    /**
     * 项目部ID
     */
    @TableField(value = "orgsecinfoid")
    @JSONField(name = "orgsecinfoid")
    @JsonProperty("orgsecinfoid")
    private String orgsecinfoid;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 组织ID
     */
    @TableField(value = "orginfoid")
    @JSONField(name = "orginfoid")
    @JsonProperty("orginfoid")
    private String orginfoid;
    /**
     * 项目部编号
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 工程名称及编码
     */
    @TableField(value = "gcmcjbm")
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;
    /**
     * ③主体施工阶段：
     */
    @TableField(value = "ztsg")
    @JSONField(name = "ztsg")
    @JsonProperty("ztsg")
    private String ztsg;
    /**
     * 版本号
     */
    @DEField(defaultValue = "第一版")
    @TableField(value = "bbh")
    @JSONField(name = "bbh")
    @JsonProperty("bbh")
    private String bbh;
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
     * 对项目总工的要求
     */
    @TableField(value = "dxmzgyq")
    @JSONField(name = "dxmzgyq")
    @JsonProperty("dxmzgyq")
    private String dxmzgyq;
    /**
     * 版本
     */
    @DEField(defaultValue = "1.0")
    @TableField(value = "edition")
    @JSONField(name = "edition")
    @JsonProperty("edition")
    private Double edition;
    /**
     * 计划成本（万）
     */
    @TableField(value = "jhcb")
    @JSONField(name = "jhcb")
    @JsonProperty("jhcb")
    private Double jhcb;
    /**
     * 所属组织
     */
    @TableField(value = "orginfoname")
    @JSONField(name = "orginfoname")
    @JsonProperty("orginfoname")
    private String orginfoname;
    /**
     * 工程造价（万元）
     */
    @TableField(value = "gczj")
    @JSONField(name = "gczj")
    @JsonProperty("gczj")
    private Double gczj;
    /**
     * 项目类型
     */
    @TableField(value = "xmlx")
    @JSONField(name = "xmlx")
    @JsonProperty("xmlx")
    private String xmlx;
    /**
     * ④装饰装修阶段：
     */
    @TableField(value = "zszx")
    @JSONField(name = "zszx")
    @JsonProperty("zszx")
    private String zszx;
    /**
     * 项目需求计划名称
     */
    @TableField(value = "ormxmxqjhname")
    @JSONField(name = "ormxmxqjhname")
    @JsonProperty("ormxmxqjhname")
    private String ormxmxqjhname;
    /**
     * 版本状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "editionstate")
    @JSONField(name = "editionstate")
    @JsonProperty("editionstate")
    private String editionstate;
    /**
     * ⑥工程结算阶段：
     */
    @TableField(value = "gcjs")
    @JSONField(name = "gcjs")
    @JsonProperty("gcjs")
    private String gcjs;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * ⑤工程扫尾阶段：
     */
    @TableField(value = "gcsw")
    @JSONField(name = "gcsw")
    @JsonProperty("gcsw")
    private String gcsw;
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
     * ⑦其他阶段：
     */
    @TableField(value = "qtjd")
    @JSONField(name = "qtjd")
    @JsonProperty("qtjd")
    private String qtjd;
    /**
     * 项目部类型
     */
    @TableField(value = "xmblx")
    @JSONField(name = "xmblx")
    @JsonProperty("xmblx")
    private String xmblx;
    /**
     * 对项目经理的要求
     */
    @TableField(value = "dxmjlyq")
    @JSONField(name = "dxmjlyq")
    @JsonProperty("dxmjlyq")
    private String dxmjlyq;
    /**
     * 项目类型（其他）
     */
    @TableField(value = "xmlxqt")
    @JSONField(name = "xmlxqt")
    @JsonProperty("xmlxqt")
    private String xmlxqt;
    /**
     * 项目部名称
     */
    @TableField(value = "xmbmc")
    @JSONField(name = "xmbmc")
    @JsonProperty("xmbmc")
    private String xmbmc;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * ②基础施工阶段：
     */
    @TableField(value = "sgjd")
    @JSONField(name = "sgjd")
    @JsonProperty("sgjd")
    private String sgjd;
    /**
     * 项目基本情况
     */
    @TableField(value = "xmjbqk")
    @JSONField(name = "xmjbqk")
    @JsonProperty("xmjbqk")
    private String xmjbqk;
    /**
     * 项目需求计划标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmxqjhid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmxqjhid")
    @JsonProperty("ormxmxqjhid")
    private String ormxmxqjhid;
    /**
     * 排序
     */
    @DEField(preType = DEPredefinedFieldType.ORDERVALUE)
    @TableField(value = "ordervalue")
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 项目部简称
     */
    @TableField(value = "xmbjc")
    @JSONField(name = "xmbjc")
    @JsonProperty("xmbjc")
    private String xmbjc;
    /**
     * 项目名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;
    /**
     * 项目编号
     */
    @TableField(exist = false)
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;
    /**
     * 项目负责人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 项目负责人ID
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
     * 项目
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmXmgl ormxmgl;

    /**
     * 项目负责人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [源记录ID]
     */
    public void setOldid(String oldid){
        this.oldid = oldid ;
        this.modify("oldid",oldid);
    }

    /**
     * 设置 [建筑面积（㎡）]
     */
    public void setJzmj(Double jzmj){
        this.jzmj = jzmj ;
        this.modify("jzmj",jzmj);
    }

    /**
     * 设置 [组织简称]
     */
    public void setOrgshortname(String orgshortname){
        this.orgshortname = orgshortname ;
        this.modify("orgshortname",orgshortname);
    }

    /**
     * 设置 [①施工前期准备阶段：]
     */
    public void setGqap(String gqap){
        this.gqap = gqap ;
        this.modify("gqap",gqap);
    }

    /**
     * 设置 [项目规模描述]
     */
    public void setXmgmms(String xmgmms){
        this.xmgmms = xmgmms ;
        this.modify("xmgmms",xmgmms);
    }

    /**
     * 设置 [审批状态]
     */
    public void setApprovalstatus(String approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [项目部ID]
     */
    public void setOrgsecinfoid(String orgsecinfoid){
        this.orgsecinfoid = orgsecinfoid ;
        this.modify("orgsecinfoid",orgsecinfoid);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrginfoid(String orginfoid){
        this.orginfoid = orginfoid ;
        this.modify("orginfoid",orginfoid);
    }

    /**
     * 设置 [项目部编号]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [工程名称及编码]
     */
    public void setGcmcjbm(String gcmcjbm){
        this.gcmcjbm = gcmcjbm ;
        this.modify("gcmcjbm",gcmcjbm);
    }

    /**
     * 设置 [③主体施工阶段：]
     */
    public void setZtsg(String ztsg){
        this.ztsg = ztsg ;
        this.modify("ztsg",ztsg);
    }

    /**
     * 设置 [版本号]
     */
    public void setBbh(String bbh){
        this.bbh = bbh ;
        this.modify("bbh",bbh);
    }

    /**
     * 设置 [对项目总工的要求]
     */
    public void setDxmzgyq(String dxmzgyq){
        this.dxmzgyq = dxmzgyq ;
        this.modify("dxmzgyq",dxmzgyq);
    }

    /**
     * 设置 [版本]
     */
    public void setEdition(Double edition){
        this.edition = edition ;
        this.modify("edition",edition);
    }

    /**
     * 设置 [计划成本（万）]
     */
    public void setJhcb(Double jhcb){
        this.jhcb = jhcb ;
        this.modify("jhcb",jhcb);
    }

    /**
     * 设置 [所属组织]
     */
    public void setOrginfoname(String orginfoname){
        this.orginfoname = orginfoname ;
        this.modify("orginfoname",orginfoname);
    }

    /**
     * 设置 [工程造价（万元）]
     */
    public void setGczj(Double gczj){
        this.gczj = gczj ;
        this.modify("gczj",gczj);
    }

    /**
     * 设置 [项目类型]
     */
    public void setXmlx(String xmlx){
        this.xmlx = xmlx ;
        this.modify("xmlx",xmlx);
    }

    /**
     * 设置 [④装饰装修阶段：]
     */
    public void setZszx(String zszx){
        this.zszx = zszx ;
        this.modify("zszx",zszx);
    }

    /**
     * 设置 [项目需求计划名称]
     */
    public void setOrmxmxqjhname(String ormxmxqjhname){
        this.ormxmxqjhname = ormxmxqjhname ;
        this.modify("ormxmxqjhname",ormxmxqjhname);
    }

    /**
     * 设置 [版本状态]
     */
    public void setEditionstate(String editionstate){
        this.editionstate = editionstate ;
        this.modify("editionstate",editionstate);
    }

    /**
     * 设置 [⑥工程结算阶段：]
     */
    public void setGcjs(String gcjs){
        this.gcjs = gcjs ;
        this.modify("gcjs",gcjs);
    }

    /**
     * 设置 [⑤工程扫尾阶段：]
     */
    public void setGcsw(String gcsw){
        this.gcsw = gcsw ;
        this.modify("gcsw",gcsw);
    }

    /**
     * 设置 [⑦其他阶段：]
     */
    public void setQtjd(String qtjd){
        this.qtjd = qtjd ;
        this.modify("qtjd",qtjd);
    }

    /**
     * 设置 [项目部类型]
     */
    public void setXmblx(String xmblx){
        this.xmblx = xmblx ;
        this.modify("xmblx",xmblx);
    }

    /**
     * 设置 [对项目经理的要求]
     */
    public void setDxmjlyq(String dxmjlyq){
        this.dxmjlyq = dxmjlyq ;
        this.modify("dxmjlyq",dxmjlyq);
    }

    /**
     * 设置 [项目类型（其他）]
     */
    public void setXmlxqt(String xmlxqt){
        this.xmlxqt = xmlxqt ;
        this.modify("xmlxqt",xmlxqt);
    }

    /**
     * 设置 [项目部名称]
     */
    public void setXmbmc(String xmbmc){
        this.xmbmc = xmbmc ;
        this.modify("xmbmc",xmbmc);
    }

    /**
     * 设置 [②基础施工阶段：]
     */
    public void setSgjd(String sgjd){
        this.sgjd = sgjd ;
        this.modify("sgjd",sgjd);
    }

    /**
     * 设置 [项目基本情况]
     */
    public void setXmjbqk(String xmjbqk){
        this.xmjbqk = xmjbqk ;
        this.modify("xmjbqk",xmjbqk);
    }

    /**
     * 设置 [项目部简称]
     */
    public void setXmbjc(String xmbjc){
        this.xmbjc = xmbjc ;
        this.modify("xmbjc",xmbjc);
    }

    /**
     * 设置 [项目负责人ID]
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


}


