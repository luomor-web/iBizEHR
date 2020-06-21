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
 * 实体[招聘名额管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMZPMEGL",resultMap = "PcmZpmeglResultMap")
public class PcmZpmegl extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 是否超额（社招Y）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_szy")
    @JsonProperty("sfce_szy")
    private String sfceSzy;
    /**
     * 招聘名额管理名称
     */
    @TableField(value = "pcmzpmeglname")
    @JSONField(name = "pcmzpmeglname")
    @JsonProperty("pcmzpmeglname")
    private String pcmzpmeglname;
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
     * 校招B名额
     */
    @TableField(value = "xyzpbme")
    @JSONField(name = "xyzpbme")
    @JsonProperty("xyzpbme")
    private Integer xyzpbme;
    /**
     * 已使用名额（社招计划外）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_szjhw")
    @JSONField(name = "ybdrs_szjhw")
    @JsonProperty("ybdrs_szjhw")
    private Integer ybdrsSzjhw;
    /**
     * 是否超额（校招A）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_xza")
    @JsonProperty("sfce_xza")
    private String sfceXza;
    /**
     * 是否超额（社招B）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_szb")
    @JsonProperty("sfce_szb")
    private String sfceSzb;
    /**
     * 已使用名额（校招小专业）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_xzxzy")
    @JSONField(name = "ybdrs_xzxzy")
    @JsonProperty("ybdrs_xzxzy")
    private Integer ybdrsXzxzy;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否超额（社招计划外）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_szjhw")
    @JsonProperty("sfce_szjhw")
    private String sfceSzjhw;
    /**
     * 分配名额（社招B）
     */
    @DEField(name = "fpme_szb")
    @TableField(value = "fpme_szb")
    @JSONField(name = "fpme_szb")
    @JsonProperty("fpme_szb")
    private String fpmeSzb;
    /**
     * 招聘名额管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmzpmeglid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmzpmeglid")
    @JsonProperty("pcmzpmeglid")
    private String pcmzpmeglid;
    /**
     * 社招Y名额
     */
    @TableField(value = "shzpyme")
    @JSONField(name = "shzpyme")
    @JsonProperty("shzpyme")
    private Integer shzpyme;
    /**
     * 已使用名额（校招A）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_xza")
    @JSONField(name = "ybdrs_xza")
    @JsonProperty("ybdrs_xza")
    private Integer ybdrsXza;
    /**
     * 分配名额（社招计划外）
     */
    @DEField(name = "fpme_szjhw")
    @TableField(value = "fpme_szjhw")
    @JSONField(name = "fpme_szjhw")
    @JsonProperty("fpme_szjhw")
    private String fpmeSzjhw;
    /**
     * 已使用名额（社招B）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_szb")
    @JSONField(name = "ybdrs_szb")
    @JsonProperty("ybdrs_szb")
    private Integer ybdrsSzb;
    /**
     * 社招B名额
     */
    @TableField(value = "shzpbme")
    @JSONField(name = "shzpbme")
    @JsonProperty("shzpbme")
    private Integer shzpbme;
    /**
     * 分配名额（校招小专业）
     */
    @DEField(name = "fpme_xzxzy")
    @TableField(value = "fpme_xzxzy")
    @JSONField(name = "fpme_xzxzy")
    @JsonProperty("fpme_xzxzy")
    private String fpmeXzxzy;
    /**
     * 社招计划外名额
     */
    @TableField(value = "shzpjhwme")
    @JSONField(name = "shzpjhwme")
    @JsonProperty("shzpjhwme")
    private Integer shzpjhwme;
    /**
     * 批复次数
     */
    @TableField(value = "pfcs")
    @JSONField(name = "pfcs")
    @JsonProperty("pfcs")
    private Integer pfcs;
    /**
     * 分配名额（社招Y）
     */
    @DEField(name = "fpme_szy")
    @TableField(value = "fpme_szy")
    @JSONField(name = "fpme_szy")
    @JsonProperty("fpme_szy")
    private String fpmeSzy;
    /**
     * 校招A名额
     */
    @TableField(value = "xyzpame")
    @JSONField(name = "xyzpame")
    @JsonProperty("xyzpame")
    private Integer xyzpame;
    /**
     * 校招小专业名额
     */
    @TableField(value = "xyzpxzyme")
    @JSONField(name = "xyzpxzyme")
    @JsonProperty("xyzpxzyme")
    private Integer xyzpxzyme;
    /**
     * 是否超额（社招A）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_sza")
    @JsonProperty("sfce_sza")
    private String sfceSza;
    /**
     * 分配名额（校招B）
     */
    @DEField(name = "fpme_xzb")
    @TableField(value = "fpme_xzb")
    @JSONField(name = "fpme_xzb")
    @JsonProperty("fpme_xzb")
    private String fpmeXzb;
    /**
     * 已使用名额（社招A）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_sza")
    @JSONField(name = "ybdrs_sza")
    @JsonProperty("ybdrs_sza")
    private Integer ybdrsSza;
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
     * 是否超额（校招B）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_xzb")
    @JsonProperty("sfce_xzb")
    private String sfceXzb;
    /**
     * 分配名额（校招A）
     */
    @DEField(name = "fpme_xza")
    @TableField(value = "fpme_xza")
    @JSONField(name = "fpme_xza")
    @JsonProperty("fpme_xza")
    private String fpmeXza;
    /**
     * 已使用名额（校招B）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_xzb")
    @JSONField(name = "ybdrs_xzb")
    @JsonProperty("ybdrs_xzb")
    private Integer ybdrsXzb;
    /**
     * 分配名额（社招A）
     */
    @DEField(name = "fpme_sza")
    @TableField(value = "fpme_sza")
    @JSONField(name = "fpme_sza")
    @JsonProperty("fpme_sza")
    private String fpmeSza;
    /**
     * 是否超额（校招小专业）
     */
    @TableField(exist = false)
    @JSONField(name = "sfce_xzxzy")
    @JsonProperty("sfce_xzxzy")
    private String sfceXzxzy;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 已使用名额（社招Y）
     */
    @DEField(defaultValue = "0")
    @TableField(value = "ybdrs_szy")
    @JSONField(name = "ybdrs_szy")
    @JsonProperty("ybdrs_szy")
    private Integer ybdrsSzy;
    /**
     * 社招A名额
     */
    @TableField(value = "shzpame")
    @JSONField(name = "shzpame")
    @JsonProperty("shzpame")
    private Integer shzpame;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 组织
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
     * 组织管理-招聘名额管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [招聘名额管理名称]
     */
    public void setPcmzpmeglname(String pcmzpmeglname){
        this.pcmzpmeglname = pcmzpmeglname ;
        this.modify("pcmzpmeglname",pcmzpmeglname);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [校招B名额]
     */
    public void setXyzpbme(Integer xyzpbme){
        this.xyzpbme = xyzpbme ;
        this.modify("xyzpbme",xyzpbme);
    }

    /**
     * 设置 [已使用名额（社招计划外）]
     */
    public void setYbdrsSzjhw(Integer ybdrsSzjhw){
        this.ybdrsSzjhw = ybdrsSzjhw ;
        this.modify("ybdrs_szjhw",ybdrsSzjhw);
    }

    /**
     * 设置 [已使用名额（校招小专业）]
     */
    public void setYbdrsXzxzy(Integer ybdrsXzxzy){
        this.ybdrsXzxzy = ybdrsXzxzy ;
        this.modify("ybdrs_xzxzy",ybdrsXzxzy);
    }

    /**
     * 设置 [分配名额（社招B）]
     */
    public void setFpmeSzb(String fpmeSzb){
        this.fpmeSzb = fpmeSzb ;
        this.modify("fpme_szb",fpmeSzb);
    }

    /**
     * 设置 [社招Y名额]
     */
    public void setShzpyme(Integer shzpyme){
        this.shzpyme = shzpyme ;
        this.modify("shzpyme",shzpyme);
    }

    /**
     * 设置 [已使用名额（校招A）]
     */
    public void setYbdrsXza(Integer ybdrsXza){
        this.ybdrsXza = ybdrsXza ;
        this.modify("ybdrs_xza",ybdrsXza);
    }

    /**
     * 设置 [分配名额（社招计划外）]
     */
    public void setFpmeSzjhw(String fpmeSzjhw){
        this.fpmeSzjhw = fpmeSzjhw ;
        this.modify("fpme_szjhw",fpmeSzjhw);
    }

    /**
     * 设置 [已使用名额（社招B）]
     */
    public void setYbdrsSzb(Integer ybdrsSzb){
        this.ybdrsSzb = ybdrsSzb ;
        this.modify("ybdrs_szb",ybdrsSzb);
    }

    /**
     * 设置 [社招B名额]
     */
    public void setShzpbme(Integer shzpbme){
        this.shzpbme = shzpbme ;
        this.modify("shzpbme",shzpbme);
    }

    /**
     * 设置 [分配名额（校招小专业）]
     */
    public void setFpmeXzxzy(String fpmeXzxzy){
        this.fpmeXzxzy = fpmeXzxzy ;
        this.modify("fpme_xzxzy",fpmeXzxzy);
    }

    /**
     * 设置 [社招计划外名额]
     */
    public void setShzpjhwme(Integer shzpjhwme){
        this.shzpjhwme = shzpjhwme ;
        this.modify("shzpjhwme",shzpjhwme);
    }

    /**
     * 设置 [批复次数]
     */
    public void setPfcs(Integer pfcs){
        this.pfcs = pfcs ;
        this.modify("pfcs",pfcs);
    }

    /**
     * 设置 [分配名额（社招Y）]
     */
    public void setFpmeSzy(String fpmeSzy){
        this.fpmeSzy = fpmeSzy ;
        this.modify("fpme_szy",fpmeSzy);
    }

    /**
     * 设置 [校招A名额]
     */
    public void setXyzpame(Integer xyzpame){
        this.xyzpame = xyzpame ;
        this.modify("xyzpame",xyzpame);
    }

    /**
     * 设置 [校招小专业名额]
     */
    public void setXyzpxzyme(Integer xyzpxzyme){
        this.xyzpxzyme = xyzpxzyme ;
        this.modify("xyzpxzyme",xyzpxzyme);
    }

    /**
     * 设置 [分配名额（校招B）]
     */
    public void setFpmeXzb(String fpmeXzb){
        this.fpmeXzb = fpmeXzb ;
        this.modify("fpme_xzb",fpmeXzb);
    }

    /**
     * 设置 [已使用名额（社招A）]
     */
    public void setYbdrsSza(Integer ybdrsSza){
        this.ybdrsSza = ybdrsSza ;
        this.modify("ybdrs_sza",ybdrsSza);
    }

    /**
     * 设置 [分配名额（校招A）]
     */
    public void setFpmeXza(String fpmeXza){
        this.fpmeXza = fpmeXza ;
        this.modify("fpme_xza",fpmeXza);
    }

    /**
     * 设置 [已使用名额（校招B）]
     */
    public void setYbdrsXzb(Integer ybdrsXzb){
        this.ybdrsXzb = ybdrsXzb ;
        this.modify("ybdrs_xzb",ybdrsXzb);
    }

    /**
     * 设置 [分配名额（社招A）]
     */
    public void setFpmeSza(String fpmeSza){
        this.fpmeSza = fpmeSza ;
        this.modify("fpme_sza",fpmeSza);
    }

    /**
     * 设置 [已使用名额（社招Y）]
     */
    public void setYbdrsSzy(Integer ybdrsSzy){
        this.ybdrsSzy = ybdrsSzy ;
        this.modify("ybdrs_szy",ybdrsSzy);
    }

    /**
     * 设置 [社招A名额]
     */
    public void setShzpame(Integer shzpame){
        this.shzpame = shzpame ;
        this.modify("shzpame",shzpame);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


