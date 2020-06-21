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
 * 实体[培训活动申请]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINACTAPPLY",resultMap = "TrmTrainActapplyResultMap")
public class TrmTrainActapply extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计划培训人数
     */
    @TableField(value = "jhpxrs")
    @JSONField(name = "jhpxrs")
    @JsonProperty("jhpxrs")
    private Integer jhpxrs;
    /**
     * 培训目标
     */
    @TableField(value = "pxmb")
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;
    /**
     * 培训内容
     */
    @TableField(value = "pxnr")
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;
    /**
     * 培训活动申请标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainactapplyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;
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
     * 培训方式
     */
    @TableField(value = "pxfs")
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;
    /**
     * 培训级别
     */
    @TableField(value = "pxjb")
    @JSONField(name = "pxjb")
    @JsonProperty("pxjb")
    private String pxjb;
    /**
     * 实际培训人数
     */
    @TableField(value = "sjpxrs")
    @JSONField(name = "sjpxrs")
    @JsonProperty("sjpxrs")
    private Integer sjpxrs;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训活动编码
     */
    @TableField(value = "pxhdbm")
    @JSONField(name = "pxhdbm")
    @JsonProperty("pxhdbm")
    private String pxhdbm;
    /**
     * 培训年度
     */
    @TableField(value = "pxnd")
    @JSONField(name = "pxnd")
    @JsonProperty("pxnd")
    private String pxnd;
    /**
     * 是否签订协议
     */
    @TableField(value = "sfqdxy")
    @JSONField(name = "sfqdxy")
    @JsonProperty("sfqdxy")
    private Integer sfqdxy;
    /**
     * 培训月份
     */
    @TableField(value = "pxyf")
    @JSONField(name = "pxyf")
    @JsonProperty("pxyf")
    private String pxyf;
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
     * 培训类别
     */
    @TableField(value = "pxlb")
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;
    /**
     * 培训活动申请名称
     */
    @TableField(value = "trmtrainactapplyname")
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;
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
     * 培训对象类别
     */
    @TableField(value = "pxdxlb")
    @JSONField(name = "pxdxlb")
    @JsonProperty("pxdxlb")
    private String pxdxlb;
    /**
     * 承办单位
     */
    @TableField(value = "cbdw")
    @JSONField(name = "cbdw")
    @JsonProperty("cbdw")
    private String cbdw;
    /**
     * 主办单位
     */
    @TableField(value = "zbdw")
    @JSONField(name = "zbdw")
    @JsonProperty("zbdw")
    private String zbdw;
    /**
     * 培训季度
     */
    @TableField(value = "pxjd")
    @JSONField(name = "pxjd")
    @JsonProperty("pxjd")
    private String pxjd;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 协办单位
     */
    @TableField(value = "xbdw")
    @JSONField(name = "xbdw")
    @JsonProperty("xbdw")
    private String xbdw;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 培训部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;



    /**
     * 设置 [计划培训人数]
     */
    public void setJhpxrs(Integer jhpxrs){
        this.jhpxrs = jhpxrs ;
        this.modify("jhpxrs",jhpxrs);
    }

    /**
     * 设置 [培训目标]
     */
    public void setPxmb(String pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [培训内容]
     */
    public void setPxnr(String pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [培训方式]
     */
    public void setPxfs(String pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [培训级别]
     */
    public void setPxjb(String pxjb){
        this.pxjb = pxjb ;
        this.modify("pxjb",pxjb);
    }

    /**
     * 设置 [实际培训人数]
     */
    public void setSjpxrs(Integer sjpxrs){
        this.sjpxrs = sjpxrs ;
        this.modify("sjpxrs",sjpxrs);
    }

    /**
     * 设置 [培训活动编码]
     */
    public void setPxhdbm(String pxhdbm){
        this.pxhdbm = pxhdbm ;
        this.modify("pxhdbm",pxhdbm);
    }

    /**
     * 设置 [培训年度]
     */
    public void setPxnd(String pxnd){
        this.pxnd = pxnd ;
        this.modify("pxnd",pxnd);
    }

    /**
     * 设置 [是否签订协议]
     */
    public void setSfqdxy(Integer sfqdxy){
        this.sfqdxy = sfqdxy ;
        this.modify("sfqdxy",sfqdxy);
    }

    /**
     * 设置 [培训月份]
     */
    public void setPxyf(String pxyf){
        this.pxyf = pxyf ;
        this.modify("pxyf",pxyf);
    }

    /**
     * 设置 [培训类别]
     */
    public void setPxlb(String pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [培训活动申请名称]
     */
    public void setTrmtrainactapplyname(String trmtrainactapplyname){
        this.trmtrainactapplyname = trmtrainactapplyname ;
        this.modify("trmtrainactapplyname",trmtrainactapplyname);
    }

    /**
     * 设置 [培训对象类别]
     */
    public void setPxdxlb(String pxdxlb){
        this.pxdxlb = pxdxlb ;
        this.modify("pxdxlb",pxdxlb);
    }

    /**
     * 设置 [承办单位]
     */
    public void setCbdw(String cbdw){
        this.cbdw = cbdw ;
        this.modify("cbdw",cbdw);
    }

    /**
     * 设置 [主办单位]
     */
    public void setZbdw(String zbdw){
        this.zbdw = zbdw ;
        this.modify("zbdw",zbdw);
    }

    /**
     * 设置 [培训季度]
     */
    public void setPxjd(String pxjd){
        this.pxjd = pxjd ;
        this.modify("pxjd",pxjd);
    }

    /**
     * 设置 [协办单位]
     */
    public void setXbdw(String xbdw){
        this.xbdw = xbdw ;
        this.modify("xbdw",xbdw);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


