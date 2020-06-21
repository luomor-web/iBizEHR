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
 * 实体[考勤记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDANCERECORD",resultMap = "AttEndanceRecordResultMap")
public class AttEndanceRecord extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 考勤日期
     */
    @TableField(value = "attenddate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "attenddate" , format="yyyy-MM-dd")
    @JsonProperty("attenddate")
    private Timestamp attenddate;
    /**
     * 下班打卡时间
     */
    @TableField(value = "dksjqt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqt" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqt")
    private Timestamp dksjqt;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 上班卡是否外勤
     */
    @TableField(value = "isoutoffice")
    @JSONField(name = "isoutoffice")
    @JsonProperty("isoutoffice")
    private Integer isoutoffice;
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
     * 考勤方式
     */
    @TableField(value = "dkfs")
    @JSONField(name = "dkfs")
    @JsonProperty("dkfs")
    private String dkfs;
    /**
     * 下班卡是否外勤
     */
    @TableField(value = "isoutleave")
    @JSONField(name = "isoutleave")
    @JsonProperty("isoutleave")
    private Integer isoutleave;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 考勤记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendancerecordid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendancerecordid")
    @JsonProperty("attendancerecordid")
    private String attendancerecordid;
    /**
     * 上班打卡时间
     */
    @TableField(value = "dksjqd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqd" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqd")
    private Timestamp dksjqd;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 考勤记录名称
     */
    @TableField(value = "attendancerecordname")
    @JSONField(name = "attendancerecordname")
    @JsonProperty("attendancerecordname")
    private String attendancerecordname;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 部门/项目部
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 培训计划项名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 部门地址
     */
    @TableField(exist = false)
    @JSONField(name = "ormbmkqdzname")
    @JsonProperty("ormbmkqdzname")
    private String ormbmkqdzname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 考勤月报明细名称
     */
    @TableField(exist = false)
    @JSONField(name = "attendancemreportmxname")
    @JsonProperty("attendancemreportmxname")
    private String attendancemreportmxname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 部门地址维护标识
     */
    @TableField(value = "ormbmkqdzid")
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;
    /**
     * 考勤月报明细标识
     */
    @DEField(name = "attendancemreportmxid")
    @TableField(value = "attendancemreportmxid")
    @JSONField(name = "attendancemreportid")
    @JsonProperty("attendancemreportid")
    private String attendancemreportid;
    /**
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 考勤月报明细-考勤记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx attendancemreportmx;

    /**
     * 部门考勤地址
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz ormbmkqdz;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 班级考勤记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;



    /**
     * 设置 [考勤日期]
     */
    public void setAttenddate(Timestamp attenddate){
        this.attenddate = attenddate ;
        this.modify("attenddate",attenddate);
    }

    /**
     * 格式化日期 [考勤日期]
     */
    public String formatAttenddate(){
        if (this.attenddate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(attenddate);
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
     * 设置 [上班卡是否外勤]
     */
    public void setIsoutoffice(Integer isoutoffice){
        this.isoutoffice = isoutoffice ;
        this.modify("isoutoffice",isoutoffice);
    }

    /**
     * 设置 [考勤方式]
     */
    public void setDkfs(String dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
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
     * 设置 [考勤记录名称]
     */
    public void setAttendancerecordname(String attendancerecordname){
        this.attendancerecordname = attendancerecordname ;
        this.modify("attendancerecordname",attendancerecordname);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [部门地址维护标识]
     */
    public void setOrmbmkqdzid(String ormbmkqdzid){
        this.ormbmkqdzid = ormbmkqdzid ;
        this.modify("ormbmkqdzid",ormbmkqdzid);
    }

    /**
     * 设置 [考勤月报明细标识]
     */
    public void setAttendancemreportid(String attendancemreportid){
        this.attendancemreportid = attendancemreportid ;
        this.modify("attendancemreportmxid",attendancemreportid);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}


