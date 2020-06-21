package cn.ibizlab.ehr.core.sal.domain;

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
 * 实体[工资单要素项]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALSCHEMEITEM",resultMap = "SalSchemeItemResultMap")
public class SalSchemeItem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标准额
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 要素项类型
     */
    @TableField(value = "sitemtype")
    @JSONField(name = "sitemtype")
    @JsonProperty("sitemtype")
    private String sitemtype;
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
     * 工资单要素项名称
     */
    @TableField(value = "salschemeitemname")
    @JSONField(name = "salschemeitemname")
    @JsonProperty("salschemeitemname")
    private String salschemeitemname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID)
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 公式
     */
    @TableField(value = "gs")
    @JSONField(name = "gs")
    @JsonProperty("gs")
    private String gs;
    /**
     * 工资单要素项标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salschemeitemid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salschemeitemid")
    @JsonProperty("salschemeitemid")
    private String salschemeitemid;
    /**
     * 增/减
     */
    @TableField(value = "sitemadd")
    @JSONField(name = "sitemadd")
    @JsonProperty("sitemadd")
    private String sitemadd;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 工资单名称
     */
    @TableField(exist = false)
    @JSONField(name = "salschemename")
    @JsonProperty("salschemename")
    private String salschemename;
    /**
     * 薪酬规则
     */
    @TableField(exist = false)
    @JSONField(name = "salrulename")
    @JsonProperty("salrulename")
    private String salrulename;
    /**
     * 要素项
     */
    @TableField(exist = false)
    @JSONField(name = "salitemname")
    @JsonProperty("salitemname")
    private String salitemname;
    /**
     * 工资单标识
     */
    @TableField(value = "salschemeid")
    @JSONField(name = "salschemeid")
    @JsonProperty("salschemeid")
    private String salschemeid;
    /**
     * 薪酬规则标识
     */
    @TableField(value = "salruleid")
    @JSONField(name = "salruleid")
    @JsonProperty("salruleid")
    private String salruleid;
    /**
     * 薪酬要素项标识
     */
    @TableField(value = "salitemid")
    @JSONField(name = "salitemid")
    @JsonProperty("salitemid")
    private String salitemid;
    /**
     * 排序号
     */
    @TableField(exist = false)
    @JSONField(name = "xh2")
    @JsonProperty("xh2")
    private Integer xh2;

    /**
     * 方案要素项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalItem salitem;

    /**
     * 方案要素项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalRule salrule;

    /**
     * 方案要素项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalScheme salscheme;



    /**
     * 设置 [标准额]
     */
    public void setBz(Double bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [要素项类型]
     */
    public void setSitemtype(String sitemtype){
        this.sitemtype = sitemtype ;
        this.modify("sitemtype",sitemtype);
    }

    /**
     * 设置 [工资单要素项名称]
     */
    public void setSalschemeitemname(String salschemeitemname){
        this.salschemeitemname = salschemeitemname ;
        this.modify("salschemeitemname",salschemeitemname);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [公式]
     */
    public void setGs(String gs){
        this.gs = gs ;
        this.modify("gs",gs);
    }

    /**
     * 设置 [增/减]
     */
    public void setSitemadd(String sitemadd){
        this.sitemadd = sitemadd ;
        this.modify("sitemadd",sitemadd);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [工资单标识]
     */
    public void setSalschemeid(String salschemeid){
        this.salschemeid = salschemeid ;
        this.modify("salschemeid",salschemeid);
    }

    /**
     * 设置 [薪酬规则标识]
     */
    public void setSalruleid(String salruleid){
        this.salruleid = salruleid ;
        this.modify("salruleid",salruleid);
    }

    /**
     * 设置 [薪酬要素项标识]
     */
    public void setSalitemid(String salitemid){
        this.salitemid = salitemid ;
        this.modify("salitemid",salitemid);
    }


}


