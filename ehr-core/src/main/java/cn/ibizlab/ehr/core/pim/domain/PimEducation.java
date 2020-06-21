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
 * 实体[教育信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMEDUCATION",resultMap = "PimEducationResultMap")
public class PimEducation extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 本单位工作年限
     */
    @TableField(value = "bdwgznx")
    @JSONField(name = "bdwgznx")
    @JsonProperty("bdwgznx")
    private Double bdwgznx;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 是否第一学历
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sfdyxl")
    @JSONField(name = "sfdyxl")
    @JsonProperty("sfdyxl")
    private Integer sfdyxl;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 教育信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimeducationid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimeducationid")
    @JsonProperty("pimeducationid")
    private String pimeducationid;
    /**
     * 教育名称
     */
    @TableField(value = "jymc")
    @JSONField(name = "jymc")
    @JsonProperty("jymc")
    private String jymc;
    /**
     * 一级学科
     */
    @TableField(value = "xkml")
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;
    /**
     * 参加工作时间
     */
    @TableField(value = "cjgzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;
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
     * 所学专业
     */
    @TableField(value = "sxzy")
    @JSONField(name = "sxzy")
    @JsonProperty("sxzy")
    private String sxzy;
    /**
     * 毕业时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 局工作时间
     */
    @TableField(value = "dzjbjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 学位
     */
    @TableField(value = "degree")
    @JSONField(name = "degree")
    @JsonProperty("degree")
    private String degree;
    /**
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
    /**
     * 学位证
     */
    @TableField(value = "xwz")
    @JSONField(name = "xwz")
    @JsonProperty("xwz")
    private String xwz;
    /**
     * 学习形式
     */
    @TableField(value = "xllx")
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;
    /**
     * 学校性质
     */
    @TableField(value = "xxxz")
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;
    /**
     * 建筑系统工作时间
     */
    @TableField(value = "tozjdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 毕业证
     */
    @TableField(value = "btz")
    @JSONField(name = "btz")
    @JsonProperty("btz")
    private String btz;
    /**
     * 学历验证
     */
    @TableField(value = "xlcx")
    @JSONField(name = "xlcx")
    @JsonProperty("xlcx")
    private String xlcx;
    /**
     * 教育信息名称
     */
    @TableField(value = "pimeducationname")
    @JSONField(name = "pimeducationname")
    @JsonProperty("pimeducationname")
    private String pimeducationname;
    /**
     * 毕业院校
     */
    @TableField(value = "byyx")
    @JSONField(name = "byyx")
    @JsonProperty("byyx")
    private String byyx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 入学时间
     */
    @TableField(value = "qssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;
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
     * 工作年限
     */
    @TableField(value = "gznx")
    @JSONField(name = "gznx")
    @JsonProperty("gznx")
    private Double gznx;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 其他附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 是否最高学历
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sfzgxl")
    @JSONField(name = "sfzgxl")
    @JsonProperty("sfzgxl")
    private Integer sfzgxl;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 学历
     */
    @TableField(value = "xl")
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;
    /**
     * 本单位工作时间
     */
    @TableField(value = "dbdwsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;
    /**
     * 建筑系统工作年限
     */
    @TableField(value = "zjxtgznx")
    @JSONField(name = "zjxtgznx")
    @JsonProperty("zjxtgznx")
    private Double zjxtgznx;
    /**
     * 局工作年限
     */
    @TableField(value = "bjgznx")
    @JSONField(name = "bjgznx")
    @JsonProperty("bjgznx")
    private Double bjgznx;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 员工名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 教育信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [本单位工作年限]
     */
    public void setBdwgznx(Double bdwgznx){
        this.bdwgznx = bdwgznx ;
        this.modify("bdwgznx",bdwgznx);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [是否第一学历]
     */
    public void setSfdyxl(Integer sfdyxl){
        this.sfdyxl = sfdyxl ;
        this.modify("sfdyxl",sfdyxl);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [教育名称]
     */
    public void setJymc(String jymc){
        this.jymc = jymc ;
        this.modify("jymc",jymc);
    }

    /**
     * 设置 [一级学科]
     */
    public void setXkml(String xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [参加工作时间]
     */
    public void setCjgzsj(Timestamp cjgzsj){
        this.cjgzsj = cjgzsj ;
        this.modify("cjgzsj",cjgzsj);
    }

    /**
     * 格式化日期 [参加工作时间]
     */
    public String formatCjgzsj(){
        if (this.cjgzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cjgzsj);
    }
    /**
     * 设置 [所学专业]
     */
    public void setSxzy(String sxzy){
        this.sxzy = sxzy ;
        this.modify("sxzy",sxzy);
    }

    /**
     * 设置 [毕业时间]
     */
    public void setJssj(Timestamp jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 格式化日期 [毕业时间]
     */
    public String formatJssj(){
        if (this.jssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jssj);
    }
    /**
     * 设置 [局工作时间]
     */
    public void setDzjbjsj(Timestamp dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 格式化日期 [局工作时间]
     */
    public String formatDzjbjsj(){
        if (this.dzjbjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dzjbjsj);
    }
    /**
     * 设置 [学位]
     */
    public void setDegree(String degree){
        this.degree = degree ;
        this.modify("degree",degree);
    }

    /**
     * 设置 [学位证]
     */
    public void setXwz(String xwz){
        this.xwz = xwz ;
        this.modify("xwz",xwz);
    }

    /**
     * 设置 [学习形式]
     */
    public void setXllx(String xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [学校性质]
     */
    public void setXxxz(String xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [建筑系统工作时间]
     */
    public void setTozjdate(Timestamp tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 格式化日期 [建筑系统工作时间]
     */
    public String formatTozjdate(){
        if (this.tozjdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tozjdate);
    }
    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [毕业证]
     */
    public void setBtz(String btz){
        this.btz = btz ;
        this.modify("btz",btz);
    }

    /**
     * 设置 [学历验证]
     */
    public void setXlcx(String xlcx){
        this.xlcx = xlcx ;
        this.modify("xlcx",xlcx);
    }

    /**
     * 设置 [教育信息名称]
     */
    public void setPimeducationname(String pimeducationname){
        this.pimeducationname = pimeducationname ;
        this.modify("pimeducationname",pimeducationname);
    }

    /**
     * 设置 [毕业院校]
     */
    public void setByyx(String byyx){
        this.byyx = byyx ;
        this.modify("byyx",byyx);
    }

    /**
     * 设置 [入学时间]
     */
    public void setQssj(Timestamp qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }

    /**
     * 格式化日期 [入学时间]
     */
    public String formatQssj(){
        if (this.qssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qssj);
    }
    /**
     * 设置 [工作年限]
     */
    public void setGznx(Double gznx){
        this.gznx = gznx ;
        this.modify("gznx",gznx);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [其他附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [是否最高学历]
     */
    public void setSfzgxl(Integer sfzgxl){
        this.sfzgxl = sfzgxl ;
        this.modify("sfzgxl",sfzgxl);
    }

    /**
     * 设置 [学历]
     */
    public void setXl(String xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [本单位工作时间]
     */
    public void setDbdwsj(Timestamp dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 格式化日期 [本单位工作时间]
     */
    public String formatDbdwsj(){
        if (this.dbdwsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dbdwsj);
    }
    /**
     * 设置 [建筑系统工作年限]
     */
    public void setZjxtgznx(Double zjxtgznx){
        this.zjxtgznx = zjxtgznx ;
        this.modify("zjxtgznx",zjxtgznx);
    }

    /**
     * 设置 [局工作年限]
     */
    public void setBjgznx(Double bjgznx){
        this.bjgznx = bjgznx ;
        this.modify("bjgznx",bjgznx);
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
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


