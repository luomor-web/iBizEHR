package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[外部培训申请]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINOUTAPPLY",resultMap = "TrmTrainOutApplyResultMap")
public class TrmTrainOutApply extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外部培训机构
     */
    @TableField(value = "wbpxjg")
    @JSONField(name = "wbpxjg")
    @JsonProperty("wbpxjg")
    private String wbpxjg;
    /**
     * 单据编号
     */
    @TableField(value = "djbh")
    @JSONField(name = "djbh")
    @JsonProperty("djbh")
    private String djbh;
    /**
     * 申请日期
     */
    @TableField(value = "sqrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqrq" , format="yyyy-MM-dd")
    @JsonProperty("sqrq")
    private Timestamp sqrq;
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
     * 培训方式
     */
    @TableField(value = "pxfs")
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;
    /**
     * 培训类别
     */
    @TableField(value = "pxlb")
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;
    /**
     * 培训内容
     */
    @TableField(value = "pxnr")
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;
    /**
     * 业务类型
     */
    @TableField(value = "ywlx")
    @JSONField(name = "ywlx")
    @JsonProperty("ywlx")
    private String ywlx;
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
     * 培训结束日期
     */
    @TableField(value = "pxjsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjsrq" , format="yyyy-MM-dd")
    @JsonProperty("pxjsrq")
    private Timestamp pxjsrq;
    /**
     * 培训目标
     */
    @TableField(value = "pxmb")
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训开始日期
     */
    @TableField(value = "pxksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxksrq" , format="yyyy-MM-dd")
    @JsonProperty("pxksrq")
    private Timestamp pxksrq;
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
     * 培训地点
     */
    @TableField(value = "pxdd")
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
    /**
     * 外部培训申请名称
     */
    @TableField(value = "trmtrainoutapplyname")
    @JSONField(name = "trmtrainoutapplyname")
    @JsonProperty("trmtrainoutapplyname")
    private String trmtrainoutapplyname;
    /**
     * 外部培训申请标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainoutapplyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainoutapplyid")
    @JsonProperty("trmtrainoutapplyid")
    private String trmtrainoutapplyid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所在部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 公司
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 申请人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [外部培训机构]
     */
    public void setWbpxjg(String wbpxjg){
        this.wbpxjg = wbpxjg ;
        this.modify("wbpxjg",wbpxjg);
    }

    /**
     * 设置 [单据编号]
     */
    public void setDjbh(String djbh){
        this.djbh = djbh ;
        this.modify("djbh",djbh);
    }

    /**
     * 设置 [申请日期]
     */
    public void setSqrq(Timestamp sqrq){
        this.sqrq = sqrq ;
        this.modify("sqrq",sqrq);
    }

    /**
     * 格式化日期 [申请日期]
     */
    public String formatSqrq(){
        if (this.sqrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sqrq);
    }
    /**
     * 设置 [培训方式]
     */
    public void setPxfs(String pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [培训类别]
     */
    public void setPxlb(String pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [培训内容]
     */
    public void setPxnr(String pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [业务类型]
     */
    public void setYwlx(String ywlx){
        this.ywlx = ywlx ;
        this.modify("ywlx",ywlx);
    }

    /**
     * 设置 [培训结束日期]
     */
    public void setPxjsrq(Timestamp pxjsrq){
        this.pxjsrq = pxjsrq ;
        this.modify("pxjsrq",pxjsrq);
    }

    /**
     * 格式化日期 [培训结束日期]
     */
    public String formatPxjsrq(){
        if (this.pxjsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxjsrq);
    }
    /**
     * 设置 [培训目标]
     */
    public void setPxmb(String pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [培训开始日期]
     */
    public void setPxksrq(Timestamp pxksrq){
        this.pxksrq = pxksrq ;
        this.modify("pxksrq",pxksrq);
    }

    /**
     * 格式化日期 [培训开始日期]
     */
    public String formatPxksrq(){
        if (this.pxksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxksrq);
    }
    /**
     * 设置 [培训地点]
     */
    public void setPxdd(String pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [外部培训申请名称]
     */
    public void setTrmtrainoutapplyname(String trmtrainoutapplyname){
        this.trmtrainoutapplyname = trmtrainoutapplyname ;
        this.modify("trmtrainoutapplyname",trmtrainoutapplyname);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


