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
 * 实体[通知选择部门副职及以下]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARBMFZJYX",resultMap = "ParBmfzjyxResultMap")
public class ParBmfzjyx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 通知选择部门副职及以下名称
     */
    @TableField(value = "parbmfzjyxname")
    @JSONField(name = "parbmfzjyxname")
    @JsonProperty("parbmfzjyxname")
    private String parbmfzjyxname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 员工排序
     */
    @TableField(value = "ygpx")
    @JSONField(name = "ygpx")
    @JsonProperty("ygpx")
    private Integer ygpx;
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
     * 备注说明
     */
    @TableField(value = "bzsm")
    @JSONField(name = "bzsm")
    @JsonProperty("bzsm")
    private String bzsm;
    /**
     * 通知选择部门副职及以下标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parbmfzjyxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parbmfzjyxid")
    @JsonProperty("parbmfzjyxid")
    private String parbmfzjyxid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "partzggname")
    @JsonProperty("partzggname")
    private String partzggname;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;
    /**
     * 通知ID
     */
    @TableField(value = "partzggid")
    @JSONField(name = "partzggid")
    @JsonProperty("partzggid")
    private String partzggid;
    /**
     * 姓名ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 通知
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParTzgg partzgg;

    /**
     * 姓名
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [通知选择部门副职及以下名称]
     */
    public void setParbmfzjyxname(String parbmfzjyxname){
        this.parbmfzjyxname = parbmfzjyxname ;
        this.modify("parbmfzjyxname",parbmfzjyxname);
    }

    /**
     * 设置 [员工排序]
     */
    public void setYgpx(Integer ygpx){
        this.ygpx = ygpx ;
        this.modify("ygpx",ygpx);
    }

    /**
     * 设置 [备注说明]
     */
    public void setBzsm(String bzsm){
        this.bzsm = bzsm ;
        this.modify("bzsm",bzsm);
    }

    /**
     * 设置 [通知ID]
     */
    public void setPartzggid(String partzggid){
        this.partzggid = partzggid ;
        this.modify("partzggid",partzggid);
    }

    /**
     * 设置 [姓名ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


