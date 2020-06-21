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
 * 实体[考勤设置]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDENCESETUP",resultMap = "AttEndenceSetupResultMap")
public class AttEndenceSetup extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 下班时间
     */
    @TableField(value = "xbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 考勤表名称
     */
    @TableField(value = "attendencesetupname")
    @JSONField(name = "attendencesetupname")
    @JsonProperty("attendencesetupname")
    private String attendencesetupname;
    /**
     * 允许外勤
     */
    @TableField(value = "allowoutwork")
    @JSONField(name = "allowoutwork")
    @JsonProperty("allowoutwork")
    private String allowoutwork;
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
     * 打卡方式
     */
    @TableField(value = "dkfs")
    @JSONField(name = "dkfs")
    @JsonProperty("dkfs")
    private String dkfs;
    /**
     * 考勤设置标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendencesetupid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendencesetupid")
    @JsonProperty("attendencesetupid")
    private String attendencesetupid;
    /**
     * 上班时间
     */
    @TableField(value = "sbsj")
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;
    /**
     * 考勤员
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 考勤规则
     */
    @TableField(exist = false)
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;
    /**
     * 上级机构ID
     */
    @TableField(exist = false)
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
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
     * 考勤规则标识
     */
    @TableField(value = "vacholidayrulesid")
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;

    /**
     * 组织-考勤设置
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 人员信息-考勤设置
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 考勤规则-考勤设置
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacHolidayRules vacholidayrules;



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
     * 设置 [考勤表名称]
     */
    public void setAttendencesetupname(String attendencesetupname){
        this.attendencesetupname = attendencesetupname ;
        this.modify("attendencesetupname",attendencesetupname);
    }

    /**
     * 设置 [允许外勤]
     */
    public void setAllowoutwork(String allowoutwork){
        this.allowoutwork = allowoutwork ;
        this.modify("allowoutwork",allowoutwork);
    }

    /**
     * 设置 [打卡方式]
     */
    public void setDkfs(String dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
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
     * 设置 [考勤规则标识]
     */
    public void setVacholidayrulesid(String vacholidayrulesid){
        this.vacholidayrulesid = vacholidayrulesid ;
        this.modify("vacholidayrulesid",vacholidayrulesid);
    }


}


