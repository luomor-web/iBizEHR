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
 * 实体[职级到期规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMZWDQGZ",resultMap = "OrmZwdqgzResultMap")
public class OrmZwdqgz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职务到期规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormzwdqgzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormzwdqgzid")
    @JsonProperty("ormzwdqgzid")
    private String ormzwdqgzid;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
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
     * 职务名称
     */
    @TableField(value = "zwlx")
    @JSONField(name = "zwlx")
    @JsonProperty("zwlx")
    private String zwlx;
    /**
     * 职级到期规则名称
     */
    @TableField(value = "ormzwdqgzname")
    @JSONField(name = "ormzwdqgzname")
    @JsonProperty("ormzwdqgzname")
    private String ormzwdqgzname;
    /**
     * 是否默认到期年龄
     */
    @TableField(value = "sfmrdqnl")
    @JSONField(name = "sfmrdqnl")
    @JsonProperty("sfmrdqnl")
    private Integer sfmrdqnl;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 到期年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 职务编码
     */
    @TableField(value = "zwbm")
    @JSONField(name = "zwbm")
    @JsonProperty("zwbm")
    private String zwbm;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 职级标识
     */
    @TableField(value = "ormrankid")
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 职务标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmRank ormrank;



    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [职务名称]
     */
    public void setZwlx(String zwlx){
        this.zwlx = zwlx ;
        this.modify("zwlx",zwlx);
    }

    /**
     * 设置 [职级到期规则名称]
     */
    public void setOrmzwdqgzname(String ormzwdqgzname){
        this.ormzwdqgzname = ormzwdqgzname ;
        this.modify("ormzwdqgzname",ormzwdqgzname);
    }

    /**
     * 设置 [是否默认到期年龄]
     */
    public void setSfmrdqnl(Integer sfmrdqnl){
        this.sfmrdqnl = sfmrdqnl ;
        this.modify("sfmrdqnl",sfmrdqnl);
    }

    /**
     * 设置 [到期年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [职务编码]
     */
    public void setZwbm(String zwbm){
        this.zwbm = zwbm ;
        this.modify("zwbm",zwbm);
    }

    /**
     * 设置 [职级标识]
     */
    public void setOrmrankid(String ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [职务标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}


