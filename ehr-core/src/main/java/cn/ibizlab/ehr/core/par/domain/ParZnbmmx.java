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
 * 实体[通知选择职能部门明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARZNBMMX",resultMap = "ParZnbmmxResultMap")
public class ParZnbmmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 通知选择职能部门明细名称
     */
    @TableField(value = "parznbmmxname")
    @JSONField(name = "parznbmmxname")
    @JsonProperty("parznbmmxname")
    private String parznbmmxname;
    /**
     * 通知选择职能部门明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parznbmmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parznbmmxid")
    @JsonProperty("parznbmmxid")
    private String parznbmmxid;
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
     * 职能部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;
    /**
     * 职能部门排序
     */
    @TableField(exist = false)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "partzggname")
    @JsonProperty("partzggname")
    private String partzggname;
    /**
     * 通知ID
     */
    @TableField(value = "partzggid")
    @JSONField(name = "partzggid")
    @JsonProperty("partzggid")
    private String partzggid;
    /**
     * 职能部门ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 职能部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 通知
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParTzgg partzgg;



    /**
     * 设置 [通知选择职能部门明细名称]
     */
    public void setParznbmmxname(String parznbmmxname){
        this.parznbmmxname = parznbmmxname ;
        this.modify("parznbmmxname",parznbmmxname);
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
     * 设置 [职能部门ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


