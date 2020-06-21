package cn.ibizlab.ehr.core.att.domain;

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
 * 实体[考勤记录(中间表)]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDANCERECORDTEMP",resultMap = "AttEndanceRecordTempResultMap")
public class AttEndanceRecordTemp extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤类型
     */
    @TableField(value = "kqlx")
    @JSONField(name = "kqlx")
    @JsonProperty("kqlx")
    private String kqlx;
    /**
     * 下班打卡时间
     */
    @TableField(value = "dksjqt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqt" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqt")
    private Timestamp dksjqt;
    /**
     * 早退（分）
     */
    @TableField(value = "ztf")
    @JSONField(name = "ztf")
    @JsonProperty("ztf")
    private Double ztf;
    /**
     * 考勤记录(中间表)标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendancerecordtempid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendancerecordtempid")
    @JsonProperty("attendancerecordtempid")
    private String attendancerecordtempid;
    /**
     * 迟到（分）
     */
    @TableField(value = "cdf")
    @JSONField(name = "cdf")
    @JsonProperty("cdf")
    private Double cdf;
    /**
     * 上班时间
     */
    @TableField(value = "sbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;
    /**
     * 部门地址维护标识
     */
    @TableField(value = "ormbmkqdzid")
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;
    /**
     * 月份
     */
    @TableField(value = "yf")
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;
    /**
     * 下班时间
     */
    @TableField(value = "xbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;
    /**
     * 日
     */
    @TableField(value = "day")
    @JSONField(name = "day")
    @JsonProperty("day")
    private String day;
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
     * 考勤记录(中间表)名称
     */
    @TableField(value = "attendancerecordtempname")
    @JSONField(name = "attendancerecordtempname")
    @JsonProperty("attendancerecordtempname")
    private String attendancerecordtempname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 是否周末
     */
    @TableField(value = "isweekend")
    @JSONField(name = "isweekend")
    @JsonProperty("isweekend")
    private String isweekend;
    /**
     * 下班卡是否外勤
     */
    @TableField(value = "isoutleave")
    @JSONField(name = "isoutleave")
    @JsonProperty("isoutleave")
    private Integer isoutleave;
    /**
     * 上班打卡时间
     */
    @TableField(value = "dksjqd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqd" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqd")
    private Timestamp dksjqd;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 上班卡是否外勤
     */
    @TableField(value = "isoutoffice")
    @JSONField(name = "isoutoffice")
    @JsonProperty("isoutoffice")
    private Integer isoutoffice;
    /**
     * 人事核对
     */
    @TableField(value = "rshd")
    @JSONField(name = "rshd")
    @JsonProperty("rshd")
    private String rshd;
    /**
     * 考勤日期
     */
    @TableField(value = "kqrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqrq" , format="yyyy-MM-dd")
    @JsonProperty("kqrq")
    private Timestamp kqrq;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工姓名
     */
    @TableField(value = "pimpersonname")
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
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

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
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [考勤类型]
     */
    public void setKqlx(String kqlx){
        this.kqlx = kqlx ;
        this.modify("kqlx",kqlx);
    }

    /**
     * 设置 [下班打卡时间]
     */
    public void setDksjqt(Timestamp dksjqt){
        this.dksjqt = dksjqt ;
        this.modify("dksjqt",dksjqt);
    }

    /**
     * 格式化日期 [下班打卡时间]
     */
    public String formatDksjqt(){
        if (this.dksjqt == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dksjqt);
    }
    /**
     * 设置 [早退（分）]
     */
    public void setZtf(Double ztf){
        this.ztf = ztf ;
        this.modify("ztf",ztf);
    }

    /**
     * 设置 [迟到（分）]
     */
    public void setCdf(Double cdf){
        this.cdf = cdf ;
        this.modify("cdf",cdf);
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
     * 设置 [部门地址维护标识]
     */
    public void setOrmbmkqdzid(String ormbmkqdzid){
        this.ormbmkqdzid = ormbmkqdzid ;
        this.modify("ormbmkqdzid",ormbmkqdzid);
    }

    /**
     * 设置 [月份]
     */
    public void setYf(String yf){
        this.yf = yf ;
        this.modify("yf",yf);
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
     * 设置 [日]
     */
    public void setDay(String day){
        this.day = day ;
        this.modify("day",day);
    }

    /**
     * 设置 [考勤记录(中间表)名称]
     */
    public void setAttendancerecordtempname(String attendancerecordtempname){
        this.attendancerecordtempname = attendancerecordtempname ;
        this.modify("attendancerecordtempname",attendancerecordtempname);
    }

    /**
     * 设置 [是否周末]
     */
    public void setIsweekend(String isweekend){
        this.isweekend = isweekend ;
        this.modify("isweekend",isweekend);
    }

    /**
     * 设置 [下班卡是否外勤]
     */
    public void setIsoutleave(Integer isoutleave){
        this.isoutleave = isoutleave ;
        this.modify("isoutleave",isoutleave);
    }

    /**
     * 设置 [上班打卡时间]
     */
    public void setDksjqd(Timestamp dksjqd){
        this.dksjqd = dksjqd ;
        this.modify("dksjqd",dksjqd);
    }

    /**
     * 格式化日期 [上班打卡时间]
     */
    public String formatDksjqd(){
        if (this.dksjqd == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dksjqd);
    }
    /**
     * 设置 [上班卡是否外勤]
     */
    public void setIsoutoffice(Integer isoutoffice){
        this.isoutoffice = isoutoffice ;
        this.modify("isoutoffice",isoutoffice);
    }

    /**
     * 设置 [人事核对]
     */
    public void setRshd(String rshd){
        this.rshd = rshd ;
        this.modify("rshd",rshd);
    }

    /**
     * 设置 [考勤日期]
     */
    public void setKqrq(Timestamp kqrq){
        this.kqrq = kqrq ;
        this.modify("kqrq",kqrq);
    }

    /**
     * 格式化日期 [考勤日期]
     */
    public String formatKqrq(){
        if (this.kqrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kqrq);
    }
    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [员工姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


