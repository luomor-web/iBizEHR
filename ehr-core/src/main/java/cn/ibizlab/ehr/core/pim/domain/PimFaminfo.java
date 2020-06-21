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
 * 实体[家庭情况]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMFAMINFO",resultMap = "PimFaminfoResultMap")
public class PimFaminfo extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 证件号
     */
    @TableField(value = "zjh")
    @JSONField(name = "zjh")
    @JsonProperty("zjh")
    private String zjh;
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
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 是否紧急联络人
     */
    @TableField(value = "sfjjllr")
    @JSONField(name = "sfjjllr")
    @JsonProperty("sfjjllr")
    private String sfjjllr;
    /**
     * 政治面貌
     */
    @TableField(value = "zzmm")
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 姓名
     */
    @TableField(value = "pimfaminfoname")
    @JSONField(name = "pimfaminfoname")
    @JsonProperty("pimfaminfoname")
    private String pimfaminfoname;
    /**
     * 证件类型
     */
    @TableField(value = "zjlx")
    @JSONField(name = "zjlx")
    @JsonProperty("zjlx")
    private String zjlx;
    /**
     * 出生日期
     */
    @TableField(value = "csrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 是否遗属
     */
    @TableField(value = "sruvivors")
    @JSONField(name = "sruvivors")
    @JsonProperty("sruvivors")
    private Integer sruvivors;
    /**
     * 与本人关系
     */
    @TableField(value = "ybrgx")
    @JSONField(name = "ybrgx")
    @JsonProperty("ybrgx")
    private String ybrgx;
    /**
     * 工作单位
     */
    @TableField(value = "gzdw")
    @JSONField(name = "gzdw")
    @JsonProperty("gzdw")
    private String gzdw;
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
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 家庭情况标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimfaminfoid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimfaminfoid")
    @JsonProperty("pimfaminfoid")
    private String pimfaminfoid;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
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
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 联系电话
     */
    @TableField(value = "telphone")
    @JSONField(name = "telphone")
    @JsonProperty("telphone")
    private String telphone;
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
     * 员工姓名
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
     * 家庭情况
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [证件号]
     */
    public void setZjh(String zjh){
        this.zjh = zjh ;
        this.modify("zjh",zjh);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [是否紧急联络人]
     */
    public void setSfjjllr(String sfjjllr){
        this.sfjjllr = sfjjllr ;
        this.modify("sfjjllr",sfjjllr);
    }

    /**
     * 设置 [政治面貌]
     */
    public void setZzmm(String zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [姓名]
     */
    public void setPimfaminfoname(String pimfaminfoname){
        this.pimfaminfoname = pimfaminfoname ;
        this.modify("pimfaminfoname",pimfaminfoname);
    }

    /**
     * 设置 [证件类型]
     */
    public void setZjlx(String zjlx){
        this.zjlx = zjlx ;
        this.modify("zjlx",zjlx);
    }

    /**
     * 设置 [出生日期]
     */
    public void setCsrq(Timestamp csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 格式化日期 [出生日期]
     */
    public String formatCsrq(){
        if (this.csrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(csrq);
    }
    /**
     * 设置 [是否遗属]
     */
    public void setSruvivors(Integer sruvivors){
        this.sruvivors = sruvivors ;
        this.modify("sruvivors",sruvivors);
    }

    /**
     * 设置 [与本人关系]
     */
    public void setYbrgx(String ybrgx){
        this.ybrgx = ybrgx ;
        this.modify("ybrgx",ybrgx);
    }

    /**
     * 设置 [工作单位]
     */
    public void setGzdw(String gzdw){
        this.gzdw = gzdw ;
        this.modify("gzdw",gzdw);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [联系电话]
     */
    public void setTelphone(String telphone){
        this.telphone = telphone ;
        this.modify("telphone",telphone);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


