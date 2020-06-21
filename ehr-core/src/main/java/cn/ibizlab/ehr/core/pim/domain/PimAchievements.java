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
 * 实体[绩效信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMACHIEVEMENTS",resultMap = "PimAchievementsResultMap")
public class PimAchievements extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考评单位
     */
    @TableField(value = "evaluationunit")
    @JSONField(name = "evaluationunit")
    @JsonProperty("evaluationunit")
    private String evaluationunit;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 考核得分
     */
    @TableField(value = "khdf")
    @JSONField(name = "khdf")
    @JsonProperty("khdf")
    private Double khdf;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 起始日期
     */
    @TableField(value = "qsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;
    /**
     * 考核结论
     */
    @TableField(value = "khjl")
    @JSONField(name = "khjl")
    @JsonProperty("khjl")
    private String khjl;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
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
     * 项目级别
     */
    @TableField(value = "xmjb")
    @JSONField(name = "xmjb")
    @JsonProperty("xmjb")
    private String xmjb;
    /**
     * 季度
     */
    @TableField(value = "jd")
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;
    /**
     * 结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 档级
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 年度
     */
    @TableField(value = "pimachievementsname")
    @JSONField(name = "pimachievementsname")
    @JsonProperty("pimachievementsname")
    private String pimachievementsname;
    /**
     * 绩效信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimachievementsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimachievementsid")
    @JsonProperty("pimachievementsid")
    private String pimachievementsid;
    /**
     * 绩效考核类型
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
    /**
     * 月度
     */
    @TableField(value = "yd")
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;
    /**
     * 员工姓名
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
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 绩效信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [考评单位]
     */
    public void setEvaluationunit(String evaluationunit){
        this.evaluationunit = evaluationunit ;
        this.modify("evaluationunit",evaluationunit);
    }

    /**
     * 设置 [考核得分]
     */
    public void setKhdf(Double khdf){
        this.khdf = khdf ;
        this.modify("khdf",khdf);
    }

    /**
     * 设置 [起始日期]
     */
    public void setQsrq(Timestamp qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 格式化日期 [起始日期]
     */
    public String formatQsrq(){
        if (this.qsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qsrq);
    }
    /**
     * 设置 [考核结论]
     */
    public void setKhjl(String khjl){
        this.khjl = khjl ;
        this.modify("khjl",khjl);
    }

    /**
     * 设置 [项目级别]
     */
    public void setXmjb(String xmjb){
        this.xmjb = xmjb ;
        this.modify("xmjb",xmjb);
    }

    /**
     * 设置 [季度]
     */
    public void setJd(String jd){
        this.jd = jd ;
        this.modify("jd",jd);
    }

    /**
     * 设置 [结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [档级]
     */
    public void setDj(String dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [年度]
     */
    public void setPimachievementsname(String pimachievementsname){
        this.pimachievementsname = pimachievementsname ;
        this.modify("pimachievementsname",pimachievementsname);
    }

    /**
     * 设置 [绩效考核类型]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [月度]
     */
    public void setYd(String yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


