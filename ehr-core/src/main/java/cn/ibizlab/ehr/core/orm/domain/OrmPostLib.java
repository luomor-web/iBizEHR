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
 * 实体[岗位库]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMPOSTLIB",resultMap = "OrmPostLibResultMap")
public class OrmPostLib extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 必须交流年限
     */
    @TableField(value = "mustexcyear")
    @JSONField(name = "mustexcyear")
    @JsonProperty("mustexcyear")
    private Integer mustexcyear;
    /**
     * 岗位性质
     */
    @DEField(defaultValue = "10")
    @TableField(value = "postnature")
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;
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
     * 岗位职责说明
     */
    @TableField(value = "jobdesc")
    @JSONField(name = "jobdesc")
    @JsonProperty("jobdesc")
    private String jobdesc;
    /**
     * 岗位标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormpostlibid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormpostlibid")
    @JsonProperty("ormpostlibid")
    private String ormpostlibid;
    /**
     * 岗位标签
     */
    @TableField(value = "gwflag")
    @JSONField(name = "gwflag")
    @JsonProperty("gwflag")
    private String gwflag;
    /**
     * 建议交流年限
     */
    @TableField(value = "sugexcyear")
    @JSONField(name = "sugexcyear")
    @JsonProperty("sugexcyear")
    private Integer sugexcyear;
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
     * 岗位类型
     */
    @TableField(value = "gwtype")
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;
    /**
     * 是否保密岗
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isconfidential")
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 岗位名称
     */
    @TableField(value = "ormpostlibname")
    @JSONField(name = "ormpostlibname")
    @JsonProperty("ormpostlibname")
    private String ormpostlibname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;



    /**
     * 设置 [必须交流年限]
     */
    public void setMustexcyear(Integer mustexcyear){
        this.mustexcyear = mustexcyear ;
        this.modify("mustexcyear",mustexcyear);
    }

    /**
     * 设置 [岗位性质]
     */
    public void setPostnature(String postnature){
        this.postnature = postnature ;
        this.modify("postnature",postnature);
    }

    /**
     * 设置 [岗位职责说明]
     */
    public void setJobdesc(String jobdesc){
        this.jobdesc = jobdesc ;
        this.modify("jobdesc",jobdesc);
    }

    /**
     * 设置 [岗位标签]
     */
    public void setGwflag(String gwflag){
        this.gwflag = gwflag ;
        this.modify("gwflag",gwflag);
    }

    /**
     * 设置 [建议交流年限]
     */
    public void setSugexcyear(Integer sugexcyear){
        this.sugexcyear = sugexcyear ;
        this.modify("sugexcyear",sugexcyear);
    }

    /**
     * 设置 [岗位类型]
     */
    public void setGwtype(String gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [是否保密岗]
     */
    public void setIsconfidential(String isconfidential){
        this.isconfidential = isconfidential ;
        this.modify("isconfidential",isconfidential);
    }

    /**
     * 设置 [岗位名称]
     */
    public void setOrmpostlibname(String ormpostlibname){
        this.ormpostlibname = ormpostlibname ;
        this.modify("ormpostlibname",ormpostlibname);
    }


}


