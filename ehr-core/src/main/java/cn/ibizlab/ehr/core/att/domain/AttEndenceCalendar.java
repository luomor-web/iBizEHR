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
 * 实体[考勤日历]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDENCECALENDAR",resultMap = "AttEndenceCalendarResultMap")
public class AttEndenceCalendar extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤日历标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendencecalendarid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendencecalendarid")
    @JsonProperty("attendencecalendarid")
    private String attendencecalendarid;
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
     * 考勤日历名称
     */
    @TableField(value = "attendencecalendarname")
    @JSONField(name = "attendencecalendarname")
    @JsonProperty("attendencecalendarname")
    private String attendencecalendarname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 上班/休假
     */
    @TableField(value = "lx1")
    @JSONField(name = "lx1")
    @JsonProperty("lx1")
    private String lx1;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 日期
     */
    @TableField(value = "rq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rq" , format="yyyy-MM-dd")
    @JsonProperty("rq")
    private Timestamp rq;
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
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 节假日/调休上班类型
     */
    @TableField(exist = false)
    @JSONField(name = "jjrlx")
    @JsonProperty("jjrlx")
    private String jjrlx;
    /**
     * 节假日/调休上班名称
     */
    @TableField(exist = false)
    @JSONField(name = "vacholidayname")
    @JsonProperty("vacholidayname")
    private String vacholidayname;
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
     * 节假日管理标识
     */
    @TableField(value = "vacholidayid")
    @JSONField(name = "vacholidayid")
    @JsonProperty("vacholidayid")
    private String vacholidayid;

    /**
     * 组织管理-考勤日历
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 节假日管理-考勤日历
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacHoliday vacholiday;



    /**
     * 设置 [考勤日历名称]
     */
    public void setAttendencecalendarname(String attendencecalendarname){
        this.attendencecalendarname = attendencecalendarname ;
        this.modify("attendencecalendarname",attendencecalendarname);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [上班/休假]
     */
    public void setLx1(String lx1){
        this.lx1 = lx1 ;
        this.modify("lx1",lx1);
    }

    /**
     * 设置 [日期]
     */
    public void setRq(Timestamp rq){
        this.rq = rq ;
        this.modify("rq",rq);
    }

    /**
     * 格式化日期 [日期]
     */
    public String formatRq(){
        if (this.rq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rq);
    }
    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [节假日管理标识]
     */
    public void setVacholidayid(String vacholidayid){
        this.vacholidayid = vacholidayid ;
        this.modify("vacholidayid",vacholidayid);
    }


}


