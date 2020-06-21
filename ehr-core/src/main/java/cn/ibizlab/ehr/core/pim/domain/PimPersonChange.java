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
 * 实体[人员信息变更审核]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPERSONCHANGE",resultMap = "PimPersonChangeResultMap")
public class PimPersonChange extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 操作对象的名称
     */
    @TableField(value = "czdxmc")
    @JSONField(name = "czdxmc")
    @JsonProperty("czdxmc")
    private String czdxmc;
    /**
     * 记录编号
     */
    @TableField(value = "jlbh")
    @JSONField(name = "jlbh")
    @JsonProperty("jlbh")
    private String jlbh;
    /**
     * 操作对象的
     */
    @TableField(value = "czdxbh")
    @JSONField(name = "czdxbh")
    @JsonProperty("czdxbh")
    private String czdxbh;
    /**
     * 生效时间
     */
    @TableField(value = "sxsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj" , format="yyyy-MM-dd")
    @JsonProperty("sxsj")
    private Timestamp sxsj;
    /**
     * 审批状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 附件信息
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 变更类型
     */
    @TableField(value = "bglx")
    @JSONField(name = "bglx")
    @JsonProperty("bglx")
    private String bglx;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 人员信息变更审核标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpersonchangeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpersonchangeid")
    @JsonProperty("pimpersonchangeid")
    private String pimpersonchangeid;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 变更内容
     */
    @TableField(value = "bgnr")
    @JSONField(name = "bgnr")
    @JsonProperty("bgnr")
    private String bgnr;
    /**
     * 变更时间
     */
    @TableField(value = "bgsj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bgsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("bgsj")
    private Timestamp bgsj;
    /**
     * 人员信息变更审核名称
     */
    @TableField(value = "pimpersonchangename")
    @JSONField(name = "pimpersonchangename")
    @JsonProperty("pimpersonchangename")
    private String pimpersonchangename;
    /**
     * 申请时间
     */
    @TableField(value = "sqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqsj" , format="yyyy-MM-dd")
    @JsonProperty("sqsj")
    private Timestamp sqsj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
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
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [操作对象的名称]
     */
    public void setCzdxmc(String czdxmc){
        this.czdxmc = czdxmc ;
        this.modify("czdxmc",czdxmc);
    }

    /**
     * 设置 [记录编号]
     */
    public void setJlbh(String jlbh){
        this.jlbh = jlbh ;
        this.modify("jlbh",jlbh);
    }

    /**
     * 设置 [操作对象的]
     */
    public void setCzdxbh(String czdxbh){
        this.czdxbh = czdxbh ;
        this.modify("czdxbh",czdxbh);
    }

    /**
     * 设置 [生效时间]
     */
    public void setSxsj(Timestamp sxsj){
        this.sxsj = sxsj ;
        this.modify("sxsj",sxsj);
    }

    /**
     * 格式化日期 [生效时间]
     */
    public String formatSxsj(){
        if (this.sxsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxsj);
    }
    /**
     * 设置 [审批状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [附件信息]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [变更类型]
     */
    public void setBglx(String bglx){
        this.bglx = bglx ;
        this.modify("bglx",bglx);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [变更内容]
     */
    public void setBgnr(String bgnr){
        this.bgnr = bgnr ;
        this.modify("bgnr",bgnr);
    }

    /**
     * 设置 [变更时间]
     */
    public void setBgsj(Timestamp bgsj){
        this.bgsj = bgsj ;
        this.modify("bgsj",bgsj);
    }

    /**
     * 格式化日期 [变更时间]
     */
    public String formatBgsj(){
        if (this.bgsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(bgsj);
    }
    /**
     * 设置 [人员信息变更审核名称]
     */
    public void setPimpersonchangename(String pimpersonchangename){
        this.pimpersonchangename = pimpersonchangename ;
        this.modify("pimpersonchangename",pimpersonchangename);
    }

    /**
     * 设置 [申请时间]
     */
    public void setSqsj(Timestamp sqsj){
        this.sqsj = sqsj ;
        this.modify("sqsj",sqsj);
    }

    /**
     * 格式化日期 [申请时间]
     */
    public String formatSqsj(){
        if (this.sqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sqsj);
    }
    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


