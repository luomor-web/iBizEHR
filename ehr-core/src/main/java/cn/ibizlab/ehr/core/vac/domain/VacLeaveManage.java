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
 * 实体[请假管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACLEAVEMANAGE",resultMap = "VacLeaveManageResultMap")
public class VacLeaveManage extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 请假管理名称
     */
    @TableField(value = "vacleavemanagename")
    @JSONField(name = "vacleavemanagename")
    @JsonProperty("vacleavemanagename")
    private String vacleavemanagename;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 请假明细
     */
    @TableField(value = "qjmx")
    @JSONField(name = "qjmx")
    @JsonProperty("qjmx")
    private String qjmx;
    /**
     * 计划开始上下午
     */
    @TableField(value = "jhkssxw")
    @JSONField(name = "jhkssxw")
    @JsonProperty("jhkssxw")
    private String jhkssxw;
    /**
     * 请假种类
     */
    @TableField(value = "qjzl")
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;
    /**
     * 请销假状态
     */
    @TableField(value = "wfqqjstate")
    @JSONField(name = "wfqqjstate")
    @JsonProperty("wfqqjstate")
    private String wfqqjstate;
    /**
     * 请假事由
     */
    @TableField(value = "qjsy")
    @JSONField(name = "qjsy")
    @JsonProperty("qjsy")
    private String qjsy;
    /**
     * 实际开始时间
     */
    @TableField(value = "sjkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjkssj" , format="yyyy-MM-dd")
    @JsonProperty("sjkssj")
    private Timestamp sjkssj;
    /**
     * 请假管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacleavemanageid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacleavemanageid")
    @JsonProperty("vacleavemanageid")
    private String vacleavemanageid;
    /**
     * 回填结果
     */
    @TableField(value = "wfresult")
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID)
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 实际结束时间
     */
    @TableField(value = "sjjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjjssj" , format="yyyy-MM-dd")
    @JsonProperty("sjjssj")
    private Timestamp sjjssj;
    /**
     * 是否临时创建
     */
    @TableField(value = "tempid")
    @JSONField(name = "tempid")
    @JsonProperty("tempid")
    private String tempid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 年假使用情况
     */
    @TableField(value = "njsy")
    @JSONField(name = "njsy")
    @JsonProperty("njsy")
    private String njsy;
    /**
     * 实际开始上下午
     */
    @TableField(value = "sjkssxw")
    @JSONField(name = "sjkssxw")
    @JsonProperty("sjkssxw")
    private String sjkssxw;
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
     * 计划天数
     */
    @TableField(value = "qjts")
    @JSONField(name = "qjts")
    @JsonProperty("qjts")
    private Double qjts;
    /**
     * 计划结束时间
     */
    @TableField(value = "qjjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qjjssj" , format="yyyy-MM-dd")
    @JsonProperty("qjjssj")
    private Timestamp qjjssj;
    /**
     * 计划开始时间
     */
    @TableField(value = "qjkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qjkssj" , format="yyyy-MM-dd")
    @JsonProperty("qjkssj")
    private Timestamp qjkssj;
    /**
     * 实际天数
     */
    @TableField(value = "sjqjts")
    @JSONField(name = "sjqjts")
    @JsonProperty("sjqjts")
    private Double sjqjts;
    /**
     * 变更事由
     */
    @TableField(value = "bgsy")
    @JSONField(name = "bgsy")
    @JsonProperty("bgsy")
    private String bgsy;
    /**
     * 计划结束上下午
     */
    @TableField(value = "jhjssxw")
    @JSONField(name = "jhjssxw")
    @JsonProperty("jhjssxw")
    private String jhjssxw;
    /**
     * 实际结束上下午
     */
    @TableField(value = "sjjssxw")
    @JSONField(name = "sjjssxw")
    @JsonProperty("sjjssxw")
    private String sjjssxw;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 部门/项目部
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 请假人员
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 记录所属
     */
    @TableField(exist = false)
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [请假管理名称]
     */
    public void setVacleavemanagename(String vacleavemanagename){
        this.vacleavemanagename = vacleavemanagename ;
        this.modify("vacleavemanagename",vacleavemanagename);
    }

    /**
     * 设置 [请假明细]
     */
    public void setQjmx(String qjmx){
        this.qjmx = qjmx ;
        this.modify("qjmx",qjmx);
    }

    /**
     * 设置 [计划开始上下午]
     */
    public void setJhkssxw(String jhkssxw){
        this.jhkssxw = jhkssxw ;
        this.modify("jhkssxw",jhkssxw);
    }

    /**
     * 设置 [请假种类]
     */
    public void setQjzl(String qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [请销假状态]
     */
    public void setWfqqjstate(String wfqqjstate){
        this.wfqqjstate = wfqqjstate ;
        this.modify("wfqqjstate",wfqqjstate);
    }

    /**
     * 设置 [请假事由]
     */
    public void setQjsy(String qjsy){
        this.qjsy = qjsy ;
        this.modify("qjsy",qjsy);
    }

    /**
     * 设置 [实际开始时间]
     */
    public void setSjkssj(Timestamp sjkssj){
        this.sjkssj = sjkssj ;
        this.modify("sjkssj",sjkssj);
    }

    /**
     * 格式化日期 [实际开始时间]
     */
    public String formatSjkssj(){
        if (this.sjkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sjkssj);
    }
    /**
     * 设置 [回填结果]
     */
    public void setWfresult(String wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [实际结束时间]
     */
    public void setSjjssj(Timestamp sjjssj){
        this.sjjssj = sjjssj ;
        this.modify("sjjssj",sjjssj);
    }

    /**
     * 格式化日期 [实际结束时间]
     */
    public String formatSjjssj(){
        if (this.sjjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sjjssj);
    }
    /**
     * 设置 [是否临时创建]
     */
    public void setTempid(String tempid){
        this.tempid = tempid ;
        this.modify("tempid",tempid);
    }

    /**
     * 设置 [年假使用情况]
     */
    public void setNjsy(String njsy){
        this.njsy = njsy ;
        this.modify("njsy",njsy);
    }

    /**
     * 设置 [实际开始上下午]
     */
    public void setSjkssxw(String sjkssxw){
        this.sjkssxw = sjkssxw ;
        this.modify("sjkssxw",sjkssxw);
    }

    /**
     * 设置 [计划天数]
     */
    public void setQjts(Double qjts){
        this.qjts = qjts ;
        this.modify("qjts",qjts);
    }

    /**
     * 设置 [计划结束时间]
     */
    public void setQjjssj(Timestamp qjjssj){
        this.qjjssj = qjjssj ;
        this.modify("qjjssj",qjjssj);
    }

    /**
     * 格式化日期 [计划结束时间]
     */
    public String formatQjjssj(){
        if (this.qjjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qjjssj);
    }
    /**
     * 设置 [计划开始时间]
     */
    public void setQjkssj(Timestamp qjkssj){
        this.qjkssj = qjkssj ;
        this.modify("qjkssj",qjkssj);
    }

    /**
     * 格式化日期 [计划开始时间]
     */
    public String formatQjkssj(){
        if (this.qjkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qjkssj);
    }
    /**
     * 设置 [实际天数]
     */
    public void setSjqjts(Double sjqjts){
        this.sjqjts = sjqjts ;
        this.modify("sjqjts",sjqjts);
    }

    /**
     * 设置 [变更事由]
     */
    public void setBgsy(String bgsy){
        this.bgsy = bgsy ;
        this.modify("bgsy",bgsy);
    }

    /**
     * 设置 [计划结束上下午]
     */
    public void setJhjssxw(String jhjssxw){
        this.jhjssxw = jhjssxw ;
        this.modify("jhjssxw",jhjssxw);
    }

    /**
     * 设置 [实际结束上下午]
     */
    public void setSjjssxw(String sjjssxw){
        this.sjjssxw = sjjssxw ;
        this.modify("sjjssxw",sjjssxw);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


