package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[年度量化目标（部门副职及以下人员）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARPTRYNDLHMB",resultMap = "ParPtryndlhmbResultMap")
public class ParPtryndlhmb extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 当前阶段
     */
    @TableField(value = "jxjd")
    @JSONField(name = "jxjd")
    @JsonProperty("jxjd")
    private String jxjd;
    /**
     * 所属部门
     */
    @TableField(value = "ssbm")
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;
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
     * 所属通知
     */
    @TableField(value = "sstz")
    @JSONField(name = "sstz")
    @JsonProperty("sstz")
    private String sstz;
    /**
     * 所属组织
     */
    @TableField(value = "sszz")
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;
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
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 年度量化目标（部门副职及以下人员）标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parptryndlhmbid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parptryndlhmbid")
    @JsonProperty("parptryndlhmbid")
    private String parptryndlhmbid;
    /**
     * 年度量化目标（部门副职及以下人员）名称
     */
    @TableField(value = "parptryndlhmbname")
    @JSONField(name = "parptryndlhmbname")
    @JsonProperty("parptryndlhmbname")
    private String parptryndlhmbname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [当前阶段]
     */
    public void setJxjd(String jxjd){
        this.jxjd = jxjd ;
        this.modify("jxjd",jxjd);
    }

    /**
     * 设置 [所属部门]
     */
    public void setSsbm(String ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [所属通知]
     */
    public void setSstz(String sstz){
        this.sstz = sstz ;
        this.modify("sstz",sstz);
    }

    /**
     * 设置 [所属组织]
     */
    public void setSszz(String sszz){
        this.sszz = sszz ;
        this.modify("sszz",sszz);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [年度量化目标（部门副职及以下人员）名称]
     */
    public void setParptryndlhmbname(String parptryndlhmbname){
        this.parptryndlhmbname = parptryndlhmbname ;
        this.modify("parptryndlhmbname",parptryndlhmbname);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


