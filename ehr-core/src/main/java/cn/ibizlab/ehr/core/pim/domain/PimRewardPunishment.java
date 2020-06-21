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
 * 实体[奖惩信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMREWARDPUNISHMENT",resultMap = "PimRewardPunishmentResultMap")
public class PimRewardPunishment extends EntityMP implements Serializable {

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
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 奖惩时间
     */
    @TableField(value = "jlsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jlsj" , format="yyyy-MM-dd")
    @JsonProperty("jlsj")
    private Timestamp jlsj;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 奖惩名称
     */
    @TableField(value = "pimrewardpunishmentname")
    @JSONField(name = "pimrewardpunishmentname")
    @JsonProperty("pimrewardpunishmentname")
    private String pimrewardpunishmentname;
    /**
     * 授予单位
     */
    @TableField(value = "department")
    @JSONField(name = "department")
    @JsonProperty("department")
    private String department;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 影响期结束日期
     */
    @TableField(value = "yxqjsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yxqjsrq" , format="yyyy-MM-dd")
    @JsonProperty("yxqjsrq")
    private Timestamp yxqjsrq;
    /**
     * 奖惩级别
     */
    @TableField(value = "jcjb")
    @JSONField(name = "jcjb")
    @JsonProperty("jcjb")
    private String jcjb;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 惩罚时间
     */
    @TableField(value = "cfsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cfsj" , format="yyyy-MM-dd")
    @JsonProperty("cfsj")
    private Timestamp cfsj;
    /**
     * 奖惩金额
     */
    @TableField(value = "jcje")
    @JSONField(name = "jcje")
    @JsonProperty("jcje")
    private Double jcje;
    /**
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
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
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 奖惩分类
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 奖惩事件
     */
    @TableField(value = "jcsj")
    @JSONField(name = "jcsj")
    @JsonProperty("jcsj")
    private String jcsj;
    /**
     * 产生日期
     */
    @TableField(value = "csrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 奖励惩罚标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimrewardpunishmentid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimrewardpunishmentid")
    @JsonProperty("pimrewardpunishmentid")
    private String pimrewardpunishmentid;
    /**
     * 惩罚类型
     */
    @TableField(value = "cflx")
    @JSONField(name = "cflx")
    @JsonProperty("cflx")
    private String cflx;
    /**
     * 奖励级别
     */
    @TableField(value = "jclx")
    @JSONField(name = "jclx")
    @JsonProperty("jclx")
    private String jclx;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
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
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [奖惩时间]
     */
    public void setJlsj(Timestamp jlsj){
        this.jlsj = jlsj ;
        this.modify("jlsj",jlsj);
    }

    /**
     * 格式化日期 [奖惩时间]
     */
    public String formatJlsj(){
        if (this.jlsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jlsj);
    }
    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [奖惩名称]
     */
    public void setPimrewardpunishmentname(String pimrewardpunishmentname){
        this.pimrewardpunishmentname = pimrewardpunishmentname ;
        this.modify("pimrewardpunishmentname",pimrewardpunishmentname);
    }

    /**
     * 设置 [授予单位]
     */
    public void setDepartment(String department){
        this.department = department ;
        this.modify("department",department);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [影响期结束日期]
     */
    public void setYxqjsrq(Timestamp yxqjsrq){
        this.yxqjsrq = yxqjsrq ;
        this.modify("yxqjsrq",yxqjsrq);
    }

    /**
     * 格式化日期 [影响期结束日期]
     */
    public String formatYxqjsrq(){
        if (this.yxqjsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(yxqjsrq);
    }
    /**
     * 设置 [奖惩级别]
     */
    public void setJcjb(String jcjb){
        this.jcjb = jcjb ;
        this.modify("jcjb",jcjb);
    }

    /**
     * 设置 [惩罚时间]
     */
    public void setCfsj(Timestamp cfsj){
        this.cfsj = cfsj ;
        this.modify("cfsj",cfsj);
    }

    /**
     * 格式化日期 [惩罚时间]
     */
    public String formatCfsj(){
        if (this.cfsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cfsj);
    }
    /**
     * 设置 [奖惩金额]
     */
    public void setJcje(Double jcje){
        this.jcje = jcje ;
        this.modify("jcje",jcje);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [奖惩分类]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [奖惩事件]
     */
    public void setJcsj(String jcsj){
        this.jcsj = jcsj ;
        this.modify("jcsj",jcsj);
    }

    /**
     * 设置 [产生日期]
     */
    public void setCsrq(Timestamp csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 格式化日期 [产生日期]
     */
    public String formatCsrq(){
        if (this.csrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(csrq);
    }
    /**
     * 设置 [惩罚类型]
     */
    public void setCflx(String cflx){
        this.cflx = cflx ;
        this.modify("cflx",cflx);
    }

    /**
     * 设置 [奖励级别]
     */
    public void setJclx(String jclx){
        this.jclx = jclx ;
        this.modify("jclx",jclx);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


