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
 * 实体[工作履历]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMWORKHISTORY",resultMap = "PimWorkHistoryResultMap")
public class PimWorkHistory extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 岗位(*)
     */
    @TableField(value = "ormpostname")
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
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
     * 职务(*)
     */
    @TableField(value = "ormdutyname")
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 是否主要经历
     */
    @TableField(value = "experience")
    @JSONField(name = "experience")
    @JsonProperty("experience")
    private Integer experience;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 工作履历名称
     */
    @TableField(value = "pimworkhistoryname")
    @JSONField(name = "pimworkhistoryname")
    @JsonProperty("pimworkhistoryname")
    private String pimworkhistoryname;
    /**
     * 任职开始时间(*)
     */
    @TableField(value = "rzkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzkssj" , format="yyyy-MM-dd")
    @JsonProperty("rzkssj")
    private Timestamp rzkssj;
    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 任职结束时间
     */
    @TableField(value = "rzjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzjssj" , format="yyyy-MM-dd")
    @JsonProperty("rzjssj")
    private Timestamp rzjssj;
    /**
     * 起始时间
     */
    @TableField(value = "qssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;
    /**
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
    /**
     * 兼职借调类型
     */
    @TableField(value = "cfplx")
    @JSONField(name = "cfplx")
    @JsonProperty("cfplx")
    private String cfplx;
    /**
     * 部门(*)
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 外单位履历
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isoutrecord")
    @JSONField(name = "isoutrecord")
    @JsonProperty("isoutrecord")
    private Integer isoutrecord;
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
     * 工作履历标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimworkhistoryid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimworkhistoryid")
    @JsonProperty("pimworkhistoryid")
    private String pimworkhistoryid;
    /**
     * 工作单位(*)
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 履历说明
     */
    @TableField(value = "record")
    @JSONField(name = "record")
    @JsonProperty("record")
    private String record;
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
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;
    /**
     * 职级标识
     */
    @TableField(value = "ormrankid")
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 职级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmRank ormrank;

    /**
     * 工作履历
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [岗位(*)]
     */
    public void setOrmpostname(String ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [职务(*)]
     */
    public void setOrmdutyname(String ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }

    /**
     * 设置 [是否主要经历]
     */
    public void setExperience(Integer experience){
        this.experience = experience ;
        this.modify("experience",experience);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [工作履历名称]
     */
    public void setPimworkhistoryname(String pimworkhistoryname){
        this.pimworkhistoryname = pimworkhistoryname ;
        this.modify("pimworkhistoryname",pimworkhistoryname);
    }

    /**
     * 设置 [任职开始时间(*)]
     */
    public void setRzkssj(Timestamp rzkssj){
        this.rzkssj = rzkssj ;
        this.modify("rzkssj",rzkssj);
    }

    /**
     * 格式化日期 [任职开始时间(*)]
     */
    public String formatRzkssj(){
        if (this.rzkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzkssj);
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
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [任职结束时间]
     */
    public void setRzjssj(Timestamp rzjssj){
        this.rzjssj = rzjssj ;
        this.modify("rzjssj",rzjssj);
    }

    /**
     * 格式化日期 [任职结束时间]
     */
    public String formatRzjssj(){
        if (this.rzjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzjssj);
    }
    /**
     * 设置 [起始时间]
     */
    public void setQssj(Timestamp qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }

    /**
     * 格式化日期 [起始时间]
     */
    public String formatQssj(){
        if (this.qssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qssj);
    }
    /**
     * 设置 [兼职借调类型]
     */
    public void setCfplx(String cfplx){
        this.cfplx = cfplx ;
        this.modify("cfplx",cfplx);
    }

    /**
     * 设置 [部门(*)]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [外单位履历]
     */
    public void setIsoutrecord(Integer isoutrecord){
        this.isoutrecord = isoutrecord ;
        this.modify("isoutrecord",isoutrecord);
    }

    /**
     * 设置 [工作单位(*)]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [履历说明]
     */
    public void setRecord(String record){
        this.record = record ;
        this.modify("record",record);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [职级标识]
     */
    public void setOrmrankid(String ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


