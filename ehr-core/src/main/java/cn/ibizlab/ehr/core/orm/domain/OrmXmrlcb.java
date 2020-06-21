package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[项目人力成本]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMRLCB",resultMap = "OrmXmrlcbResultMap")
public class OrmXmrlcb extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织名称
     */
    @TableField(value = "zzmc")
    @JSONField(name = "zzmc")
    @JsonProperty("zzmc")
    private String zzmc;
    /**
     * 项目
     */
    @TableField(value = "xm")
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 超人月的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "xcry_color")
    @JsonProperty("xcry_color")
    private String xcryColor;
    /**
     * 超人月的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "xmsjry_color")
    @JsonProperty("xmsjry_color")
    private String xmsjryColor;
    /**
     * 项目人力成本名称
     */
    @TableField(value = "ormxmrlcbname")
    @JSONField(name = "ormxmrlcbname")
    @JsonProperty("ormxmrlcbname")
    private String ormxmrlcbname;
    /**
     * 组织ID
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 项目计划支出成本（万）
     */
    @TableField(value = "xmjhzccb")
    @JSONField(name = "xmjhzccb")
    @JsonProperty("xmjhzccb")
    private Double xmjhzccb;
    /**
     * 相差额度（万）
     */
    @TableField(value = "xced")
    @JSONField(name = "xced")
    @JsonProperty("xced")
    private Double xced;
    /**
     * 项目实际人月
     */
    @TableField(value = "xmsjry")
    @JSONField(name = "xmsjry")
    @JsonProperty("xmsjry")
    private Integer xmsjry;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 项目人力成本标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmrlcbid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmrlcbid")
    @JsonProperty("ormxmrlcbid")
    private String ormxmrlcbid;
    /**
     * 项目实际支出成本（万）
     */
    @TableField(value = "xmsjzccb")
    @JSONField(name = "xmsjzccb")
    @JsonProperty("xmsjzccb")
    private Double xmsjzccb;
    /**
     * 相差人月
     */
    @TableField(value = "xcry")
    @JSONField(name = "xcry")
    @JsonProperty("xcry")
    private Integer xcry;
    /**
     * 项目计划人月
     */
    @TableField(value = "xmjhry")
    @JSONField(name = "xmjhry")
    @JsonProperty("xmjhry")
    private Integer xmjhry;
    /**
     * 项目部
     */
    @TableField(value = "xmb")
    @JSONField(name = "xmb")
    @JsonProperty("xmb")
    private String xmb;



    /**
     * 设置 [组织名称]
     */
    public void setZzmc(String zzmc){
        this.zzmc = zzmc ;
        this.modify("zzmc",zzmc);
    }

    /**
     * 设置 [项目]
     */
    public void setXm(String xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [项目人力成本名称]
     */
    public void setOrmxmrlcbname(String ormxmrlcbname){
        this.ormxmrlcbname = ormxmrlcbname ;
        this.modify("ormxmrlcbname",ormxmrlcbname);
    }

    /**
     * 设置 [项目计划支出成本（万）]
     */
    public void setXmjhzccb(Double xmjhzccb){
        this.xmjhzccb = xmjhzccb ;
        this.modify("xmjhzccb",xmjhzccb);
    }

    /**
     * 设置 [相差额度（万）]
     */
    public void setXced(Double xced){
        this.xced = xced ;
        this.modify("xced",xced);
    }

    /**
     * 设置 [项目实际人月]
     */
    public void setXmsjry(Integer xmsjry){
        this.xmsjry = xmsjry ;
        this.modify("xmsjry",xmsjry);
    }

    /**
     * 设置 [项目实际支出成本（万）]
     */
    public void setXmsjzccb(Double xmsjzccb){
        this.xmsjzccb = xmsjzccb ;
        this.modify("xmsjzccb",xmsjzccb);
    }

    /**
     * 设置 [相差人月]
     */
    public void setXcry(Integer xcry){
        this.xcry = xcry ;
        this.modify("xcry",xcry);
    }

    /**
     * 设置 [项目计划人月]
     */
    public void setXmjhry(Integer xmjhry){
        this.xmjhry = xmjhry ;
        this.modify("xmjhry",xmjhry);
    }

    /**
     * 设置 [项目部]
     */
    public void setXmb(String xmb){
        this.xmb = xmb ;
        this.modify("xmb",xmb);
    }


}


