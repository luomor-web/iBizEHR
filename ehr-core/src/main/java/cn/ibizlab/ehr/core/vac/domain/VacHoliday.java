package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[节假日管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACHOLIDAY",resultMap = "VacHolidayResultMap")
public class VacHoliday extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 逻辑有效标志
     */
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
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
     * 名称
     */
    @TableField(value = "vacholidayname")
    @JSONField(name = "vacholidayname")
    @JsonProperty("vacholidayname")
    private String vacholidayname;
    /**
     * 节假日管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacholidayid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacholidayid")
    @JsonProperty("vacholidayid")
    private String vacholidayid;
    /**
     * 年龄（及以下）
     */
    @TableField(value = "age")
    @JSONField(name = "age")
    @JsonProperty("age")
    private Integer age;
    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 类型
     */
    @TableField(value = "jjrlx")
    @JSONField(name = "jjrlx")
    @JsonProperty("jjrlx")
    private String jjrlx;
    /**
     * 开始时间
     */
    @TableField(value = "kssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 考勤规则名称
     */
    @TableField(exist = false)
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;
    /**
     * 组织机构
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 考勤规则标识
     */
    @TableField(value = "vacholidayrulesid")
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;

    /**
     * 考勤规则-节假日管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacHolidayRules vacholidayrules;



    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [逻辑有效标志]
     */
    public void setEnable(Integer enable){
        this.enable = enable ;
        this.modify("enable",enable);
    }

    /**
     * 设置 [名称]
     */
    public void setVacholidayname(String vacholidayname){
        this.vacholidayname = vacholidayname ;
        this.modify("vacholidayname",vacholidayname);
    }

    /**
     * 设置 [年龄（及以下）]
     */
    public void setAge(Integer age){
        this.age = age ;
        this.modify("age",age);
    }

    /**
     * 设置 [结束时间]
     */
    public void setJssj(Timestamp jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 格式化日期 [结束时间]
     */
    public String formatJssj(){
        if (this.jssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jssj);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [类型]
     */
    public void setJjrlx(String jjrlx){
        this.jjrlx = jjrlx ;
        this.modify("jjrlx",jjrlx);
    }

    /**
     * 设置 [开始时间]
     */
    public void setKssj(Timestamp kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }

    /**
     * 格式化日期 [开始时间]
     */
    public String formatKssj(){
        if (this.kssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kssj);
    }
    /**
     * 设置 [性别]
     */
    public void setSex(String sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [考勤规则标识]
     */
    public void setVacholidayrulesid(String vacholidayrulesid){
        this.vacholidayrulesid = vacholidayrulesid ;
        this.modify("vacholidayrulesid",vacholidayrulesid);
    }


}


