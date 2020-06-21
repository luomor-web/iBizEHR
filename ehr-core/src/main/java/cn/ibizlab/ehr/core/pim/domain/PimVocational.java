package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[证书信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMVOCATIONAL",resultMap = "PimVocationalResultMap")
public class PimVocational extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 续注册时间
     */
    @TableField(value = "xzcsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xzcsj" , format="yyyy-MM-dd")
    @JsonProperty("xzcsj")
    private Timestamp xzcsj;
    /**
     * 注册编号
     */
    @TableField(value = "regisnumber")
    @JSONField(name = "regisnumber")
    @JsonProperty("regisnumber")
    private String regisnumber;
    /**
     * 使用情况
     */
    @TableField(value = "syqk")
    @JSONField(name = "syqk")
    @JsonProperty("syqk")
    private String syqk;
    /**
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
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
     * 证书名称
     */
    @TableField(value = "pimvocationalname")
    @JSONField(name = "pimvocationalname")
    @JsonProperty("pimvocationalname")
    private String pimvocationalname;
    /**
     * 签发日期
     */
    @TableField(value = "zghqrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zghqrq" , format="yyyy-MM-dd")
    @JsonProperty("zghqrq")
    private Timestamp zghqrq;
    /**
     * 执业资格证书编号
     */
    @TableField(value = "practqualcertno")
    @JSONField(name = "practqualcertno")
    @JsonProperty("practqualcertno")
    private String practqualcertno;
    /**
     * 证书剩余天数
     */
    @TableField(exist = false)
    @JSONField(name = "zssyts")
    @JsonProperty("zssyts")
    private Integer zssyts;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 发证有效期
     */
    @TableField(value = "fzyxq")
    @JSONField(name = "fzyxq")
    @JsonProperty("fzyxq")
    private String fzyxq;
    /**
     * 社保缴纳单位
     */
    @TableField(value = "socsecpayunit")
    @JSONField(name = "socsecpayunit")
    @JsonProperty("socsecpayunit")
    private String socsecpayunit;
    /**
     * 一建配套B证编号
     */
    @TableField(value = "bcardnumber")
    @JSONField(name = "bcardnumber")
    @JsonProperty("bcardnumber")
    private String bcardnumber;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 证书剩余天数颜色
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq_color")
    @JsonProperty("sxrq_color")
    private Integer sxrqColor;
    /**
     * 年检时间
     */
    @TableField(value = "njsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "njsj" , format="yyyy-MM-dd")
    @JsonProperty("njsj")
    private Timestamp njsj;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 注册单位
     */
    @TableField(value = "zcdw")
    @JSONField(name = "zcdw")
    @JsonProperty("zcdw")
    private String zcdw;
    /**
     * 专业分类
     */
    @TableField(value = "zyfl")
    @JSONField(name = "zyfl")
    @JsonProperty("zyfl")
    private String zyfl;
    /**
     * 签发机构
     */
    @TableField(value = "zgsydw")
    @JSONField(name = "zgsydw")
    @JsonProperty("zgsydw")
    private String zgsydw;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 失效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 年审情况
     */
    @TableField(value = "nsqk")
    @JSONField(name = "nsqk")
    @JsonProperty("nsqk")
    private String nsqk;
    /**
     * 执（职）业资格信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimvocationalid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimvocationalid")
    @JsonProperty("pimvocationalid")
    private String pimvocationalid;
    /**
     * 证书名称
     */
    @TableField(exist = false)
    @JSONField(name = "zsmc")
    @JsonProperty("zsmc")
    private String zsmc;
    /**
     * 证书类型
     */
    @TableField(value = "zslx")
    @JSONField(name = "zslx")
    @JsonProperty("zslx")
    private String zslx;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
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
     * 初始注册时间
     */
    @TableField(value = "cszcsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cszcsj" , format="yyyy-MM-dd")
    @JsonProperty("cszcsj")
    private Timestamp cszcsj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 级别分类
     */
    @TableField(value = "jbfl")
    @JSONField(name = "jbfl")
    @JsonProperty("jbfl")
    private String jbfl;
    /**
     * 证书编号
     */
    @TableField(value = "zgzsbh")
    @JSONField(name = "zgzsbh")
    @JsonProperty("zgzsbh")
    private String zgzsbh;
    /**
     * 变更情况
     */
    @TableField(value = "alteration")
    @JSONField(name = "alteration")
    @JsonProperty("alteration")
    private String alteration;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;
    /**
     * 注册单位
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 职业资格专业
     */
    @TableField(value = "pimqualmajorname")
    @JSONField(name = "pimqualmajorname")
    @JsonProperty("pimqualmajorname")
    private String pimqualmajorname;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;
    /**
     * 职（执）业资格证书
     */
    @TableField(exist = false)
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 注册单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 岗位（技能）证书
     */
    @TableField(exist = false)
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 职（执）业资格管理标识
     */
    @TableField(value = "pimvocationalcatalogid")
    @JSONField(name = "pimvocationalcatalogid")
    @JsonProperty("pimvocationalcatalogid")
    private String pimvocationalcatalogid;
    /**
     * 法人主体标识
     */
    @TableField(value = "ormsignorgid")
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 执业资格专业编码
     */
    @TableField(value = "pimqualmajorid")
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;
    /**
     * 岗位（技能）证书ID
     */
    @TableField(value = "pimqualtypeid")
    @JSONField(name = "pimqualtypeid")
    @JsonProperty("pimqualtypeid")
    private String pimqualtypeid;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 法人主体
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 执业资格专业
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimQualMajor pimqualmajor;

    /**
     * PIMQUALTYPE
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimQualType pimqualtype;

    /**
     * 执业资格目录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog pimvocationalcatalog;



    /**
     * 设置 [续注册时间]
     */
    public void setXzcsj(Timestamp xzcsj){
        this.xzcsj = xzcsj ;
        this.modify("xzcsj",xzcsj);
    }

    /**
     * 格式化日期 [续注册时间]
     */
    public String formatXzcsj(){
        if (this.xzcsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(xzcsj);
    }
    /**
     * 设置 [注册编号]
     */
    public void setRegisnumber(String regisnumber){
        this.regisnumber = regisnumber ;
        this.modify("regisnumber",regisnumber);
    }

    /**
     * 设置 [使用情况]
     */
    public void setSyqk(String syqk){
        this.syqk = syqk ;
        this.modify("syqk",syqk);
    }

    /**
     * 设置 [证书名称]
     */
    public void setPimvocationalname(String pimvocationalname){
        this.pimvocationalname = pimvocationalname ;
        this.modify("pimvocationalname",pimvocationalname);
    }

    /**
     * 设置 [签发日期]
     */
    public void setZghqrq(Timestamp zghqrq){
        this.zghqrq = zghqrq ;
        this.modify("zghqrq",zghqrq);
    }

    /**
     * 格式化日期 [签发日期]
     */
    public String formatZghqrq(){
        if (this.zghqrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zghqrq);
    }
    /**
     * 设置 [执业资格证书编号]
     */
    public void setPractqualcertno(String practqualcertno){
        this.practqualcertno = practqualcertno ;
        this.modify("practqualcertno",practqualcertno);
    }

    /**
     * 设置 [发证有效期]
     */
    public void setFzyxq(String fzyxq){
        this.fzyxq = fzyxq ;
        this.modify("fzyxq",fzyxq);
    }

    /**
     * 设置 [社保缴纳单位]
     */
    public void setSocsecpayunit(String socsecpayunit){
        this.socsecpayunit = socsecpayunit ;
        this.modify("socsecpayunit",socsecpayunit);
    }

    /**
     * 设置 [一建配套B证编号]
     */
    public void setBcardnumber(String bcardnumber){
        this.bcardnumber = bcardnumber ;
        this.modify("bcardnumber",bcardnumber);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [年检时间]
     */
    public void setNjsj(Timestamp njsj){
        this.njsj = njsj ;
        this.modify("njsj",njsj);
    }

    /**
     * 格式化日期 [年检时间]
     */
    public String formatNjsj(){
        if (this.njsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(njsj);
    }
    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [注册单位]
     */
    public void setZcdw(String zcdw){
        this.zcdw = zcdw ;
        this.modify("zcdw",zcdw);
    }

    /**
     * 设置 [专业分类]
     */
    public void setZyfl(String zyfl){
        this.zyfl = zyfl ;
        this.modify("zyfl",zyfl);
    }

    /**
     * 设置 [签发机构]
     */
    public void setZgsydw(String zgsydw){
        this.zgsydw = zgsydw ;
        this.modify("zgsydw",zgsydw);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [失效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [失效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [年审情况]
     */
    public void setNsqk(String nsqk){
        this.nsqk = nsqk ;
        this.modify("nsqk",nsqk);
    }

    /**
     * 设置 [证书类型]
     */
    public void setZslx(String zslx){
        this.zslx = zslx ;
        this.modify("zslx",zslx);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [初始注册时间]
     */
    public void setCszcsj(Timestamp cszcsj){
        this.cszcsj = cszcsj ;
        this.modify("cszcsj",cszcsj);
    }

    /**
     * 格式化日期 [初始注册时间]
     */
    public String formatCszcsj(){
        if (this.cszcsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cszcsj);
    }
    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [级别分类]
     */
    public void setJbfl(String jbfl){
        this.jbfl = jbfl ;
        this.modify("jbfl",jbfl);
    }

    /**
     * 设置 [证书编号]
     */
    public void setZgzsbh(String zgzsbh){
        this.zgzsbh = zgzsbh ;
        this.modify("zgzsbh",zgzsbh);
    }

    /**
     * 设置 [变更情况]
     */
    public void setAlteration(String alteration){
        this.alteration = alteration ;
        this.modify("alteration",alteration);
    }

    /**
     * 设置 [注册单位]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [职业资格专业]
     */
    public void setPimqualmajorname(String pimqualmajorname){
        this.pimqualmajorname = pimqualmajorname ;
        this.modify("pimqualmajorname",pimqualmajorname);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [职（执）业资格管理标识]
     */
    public void setPimvocationalcatalogid(String pimvocationalcatalogid){
        this.pimvocationalcatalogid = pimvocationalcatalogid ;
        this.modify("pimvocationalcatalogid",pimvocationalcatalogid);
    }

    /**
     * 设置 [法人主体标识]
     */
    public void setOrmsignorgid(String ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [执业资格专业编码]
     */
    public void setPimqualmajorid(String pimqualmajorid){
        this.pimqualmajorid = pimqualmajorid ;
        this.modify("pimqualmajorid",pimqualmajorid);
    }

    /**
     * 设置 [岗位（技能）证书ID]
     */
    public void setPimqualtypeid(String pimqualtypeid){
        this.pimqualtypeid = pimqualtypeid ;
        this.modify("pimqualtypeid",pimqualtypeid);
    }


}


