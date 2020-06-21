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
 * 实体[考勤规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACHOLIDAYRULES",resultMap = "VacHolidayRulesResultMap")
public class VacHolidayRules extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 考勤规则名称
     */
    @TableField(value = "vacholidayrulesname")
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;
    /**
     * 是否启用
     */
    @TableField(value = "sfqy")
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private String sfqy;
    /**
     * 考勤规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacholidayrulesid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 推送至下级组织
     */
    @TableField(value = "tszxjzz")
    @JSONField(name = "tszxjzz")
    @JsonProperty("tszxjzz")
    private String tszxjzz;
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
     * 默认规则
     */
    @TableField(value = "defaultrule")
    @JSONField(name = "defaultrule")
    @JsonProperty("defaultrule")
    private String defaultrule;
    /**
     * 组织编码
     */
    @TableField(exist = false)
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
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
     * 组织-考勤规则
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



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
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [考勤规则名称]
     */
    public void setVacholidayrulesname(String vacholidayrulesname){
        this.vacholidayrulesname = vacholidayrulesname ;
        this.modify("vacholidayrulesname",vacholidayrulesname);
    }

    /**
     * 设置 [是否启用]
     */
    public void setSfqy(String sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [推送至下级组织]
     */
    public void setTszxjzz(String tszxjzz){
        this.tszxjzz = tszxjzz ;
        this.modify("tszxjzz",tszxjzz);
    }

    /**
     * 设置 [默认规则]
     */
    public void setDefaultrule(String defaultrule){
        this.defaultrule = defaultrule ;
        this.modify("defaultrule",defaultrule);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


