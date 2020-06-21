package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[试用期规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMSYQGZ",resultMap = "PcmSyqgzResultMap")
public class PcmSyqgz extends EntityMP implements Serializable {

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
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 最小合同期限（月）
     */
    @TableField(value = "minperiod")
    @JSONField(name = "minperiod")
    @JsonProperty("minperiod")
    private Double minperiod;
    /**
     * 劳动合同期限（计算）
     */
    @TableField(value = "ldhtqxjs")
    @JSONField(name = "ldhtqxjs")
    @JsonProperty("ldhtqxjs")
    private Double ldhtqxjs;
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
     * 劳动合同期限
     */
    @TableField(value = "ldhtqx")
    @JSONField(name = "ldhtqx")
    @JsonProperty("ldhtqx")
    private String ldhtqx;
    /**
     * 试用期规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmsyqgzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmsyqgzid")
    @JsonProperty("pcmsyqgzid")
    private String pcmsyqgzid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 试用期限
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;
    /**
     * 试用期（计算）
     */
    @TableField(value = "syqjs")
    @JSONField(name = "syqjs")
    @JsonProperty("syqjs")
    private Double syqjs;
    /**
     * 试用期规则名称
     */
    @TableField(value = "pcmsyqgzname")
    @JSONField(name = "pcmsyqgzname")
    @JsonProperty("pcmsyqgzname")
    private String pcmsyqgzname;
    /**
     * 最大合同期限（月）
     */
    @TableField(value = "maxperiod")
    @JSONField(name = "maxperiod")
    @JsonProperty("maxperiod")
    private Double maxperiod;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [排序号]
     */
    public void setXh(String xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [最小合同期限（月）]
     */
    public void setMinperiod(Double minperiod){
        this.minperiod = minperiod ;
        this.modify("minperiod",minperiod);
    }

    /**
     * 设置 [劳动合同期限（计算）]
     */
    public void setLdhtqxjs(Double ldhtqxjs){
        this.ldhtqxjs = ldhtqxjs ;
        this.modify("ldhtqxjs",ldhtqxjs);
    }

    /**
     * 设置 [劳动合同期限]
     */
    public void setLdhtqx(String ldhtqx){
        this.ldhtqx = ldhtqx ;
        this.modify("ldhtqx",ldhtqx);
    }

    /**
     * 设置 [试用期限]
     */
    public void setDuration(String duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [试用期（计算）]
     */
    public void setSyqjs(Double syqjs){
        this.syqjs = syqjs ;
        this.modify("syqjs",syqjs);
    }

    /**
     * 设置 [试用期规则名称]
     */
    public void setPcmsyqgzname(String pcmsyqgzname){
        this.pcmsyqgzname = pcmsyqgzname ;
        this.modify("pcmsyqgzname",pcmsyqgzname);
    }

    /**
     * 设置 [最大合同期限（月）]
     */
    public void setMaxperiod(Double maxperiod){
        this.maxperiod = maxperiod ;
        this.modify("maxperiod",maxperiod);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


