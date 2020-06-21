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
 * 实体[评分权重分配]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARLDKHQZ",resultMap = "ParLdkhqzResultMap")
public class ParLdkhqz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权重占比（%）
     */
    @TableField(value = "qzzb")
    @JSONField(name = "qzzb")
    @JsonProperty("qzzb")
    private Double qzzb;
    /**
     * 评分主体
     */
    @TableField(value = "pfzt")
    @JSONField(name = "pfzt")
    @JsonProperty("pfzt")
    private String pfzt;
    /**
     * 评分规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parldkhqzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parldkhqzid")
    @JsonProperty("parldkhqzid")
    private String parldkhqzid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 评分规则
     */
    @TableField(value = "parldkhqzname")
    @JSONField(name = "parldkhqzname")
    @JsonProperty("parldkhqzname")
    private String parldkhqzname;
    /**
     * 考核内容
     */
    @TableField(exist = false)
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;
    /**
     * 所属考核对象
     */
    @TableField(exist = false)
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
    /**
     * 考核内容ID
     */
    @TableField(value = "parkhzcmxid")
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;
    /**
     * 考核对象
     */
    @TableField(value = "khobject")
    @JSONField(name = "khobject")
    @JsonProperty("khobject")
    private String khobject;

    /**
     * 评分权重分配
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParKhzcmx parkhzcmx;



    /**
     * 设置 [权重占比（%）]
     */
    public void setQzzb(Double qzzb){
        this.qzzb = qzzb ;
        this.modify("qzzb",qzzb);
    }

    /**
     * 设置 [评分主体]
     */
    public void setPfzt(String pfzt){
        this.pfzt = pfzt ;
        this.modify("pfzt",pfzt);
    }

    /**
     * 设置 [评分规则]
     */
    public void setParldkhqzname(String parldkhqzname){
        this.parldkhqzname = parldkhqzname ;
        this.modify("parldkhqzname",parldkhqzname);
    }

    /**
     * 设置 [考核内容ID]
     */
    public void setParkhzcmxid(String parkhzcmxid){
        this.parkhzcmxid = parkhzcmxid ;
        this.modify("parkhzcmxid",parkhzcmxid);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhobject(String khobject){
        this.khobject = khobject ;
        this.modify("khobject",khobject);
    }


}


