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
 * 实体[年度量化目标（职能部门级）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARZNBMNDLHMB",resultMap = "ParZnbmndlhmbResultMap")
public class ParZnbmndlhmb extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属通知
     */
    @TableField(value = "sstz")
    @JSONField(name = "sstz")
    @JsonProperty("sstz")
    private String sstz;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 年度量化目标（职能部门级）名称
     */
    @TableField(value = "parznbmndlhmbname")
    @JSONField(name = "parznbmndlhmbname")
    @JsonProperty("parznbmndlhmbname")
    private String parznbmndlhmbname;
    /**
     * 部门负责人ID
     */
    @TableField(value = "bmfzr")
    @JSONField(name = "bmfzr")
    @JsonProperty("bmfzr")
    private String bmfzr;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 年度量化目标（职能部门级）标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parznbmndlhmbid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parznbmndlhmbid")
    @JsonProperty("parznbmndlhmbid")
    private String parznbmndlhmbid;
    /**
     * 当前阶段
     */
    @TableField(value = "jxjd")
    @JSONField(name = "jxjd")
    @JsonProperty("jxjd")
    private String jxjd;
    /**
     * 部门负责人
     */
    @TableField(value = "mc")
    @JSONField(name = "mc")
    @JsonProperty("mc")
    private String mc;
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
    @JSONField(name = "ssorg")
    @JsonProperty("ssorg")
    private String ssorg;
    /**
     * 职能部门ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;



    /**
     * 设置 [所属通知]
     */
    public void setSstz(String sstz){
        this.sstz = sstz ;
        this.modify("sstz",sstz);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [年度量化目标（职能部门级）名称]
     */
    public void setParznbmndlhmbname(String parznbmndlhmbname){
        this.parznbmndlhmbname = parznbmndlhmbname ;
        this.modify("parznbmndlhmbname",parznbmndlhmbname);
    }

    /**
     * 设置 [部门负责人ID]
     */
    public void setBmfzr(String bmfzr){
        this.bmfzr = bmfzr ;
        this.modify("bmfzr",bmfzr);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [当前阶段]
     */
    public void setJxjd(String jxjd){
        this.jxjd = jxjd ;
        this.modify("jxjd",jxjd);
    }

    /**
     * 设置 [部门负责人]
     */
    public void setMc(String mc){
        this.mc = mc ;
        this.modify("mc",mc);
    }

    /**
     * 设置 [职能部门ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


