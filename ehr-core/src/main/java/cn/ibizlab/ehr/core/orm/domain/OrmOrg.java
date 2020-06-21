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
 * 实体[组织管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SRFORG",resultMap = "OrmOrgResultMap")
public class OrmOrg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域补贴
     */
    @TableField(value = "btqy")
    @JSONField(name = "btqy")
    @JsonProperty("btqy")
    private String btqy;
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
     * 启停标识
     */
    @DEField(defaultValue = "1")
    @TableField(value = "startstopsign")
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;
    /**
     * 公司根组织ID
     */
    @TableField(value = "companyflag")
    @JSONField(name = "companyflag")
    @JsonProperty("companyflag")
    private String companyflag;
    /**
     * 组织性质
     */
    @TableField(value = "legalentity")
    @JSONField(name = "legalentity")
    @JsonProperty("legalentity")
    private String legalentity;
    /**
     * 所属OU
     */
    @TableField(value = "ssou")
    @JSONField(name = "ssou")
    @JsonProperty("ssou")
    private String ssou;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织地址编码
     */
    @TableField(value = "zzdzbm")
    @JSONField(name = "zzdzbm")
    @JsonProperty("zzdzbm")
    private String zzdzbm;
    /**
     * 所属区域
     */
    @TableField(value = "gsss")
    @JSONField(name = "gsss")
    @JsonProperty("gsss")
    private String gsss;
    /**
     * 级别编码
     */
    @TableField(value = "levelcode")
    @JSONField(name = "levelcode")
    @JsonProperty("levelcode")
    private String levelcode;
    /**
     * 排序号
     */
    @TableField(value = "px")
    @JSONField(name = "px")
    @JsonProperty("px")
    private Integer px;
    /**
     * 组织创建时间
     */
    @TableField(value = "zzcjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zzcjsj" , format="yyyy-MM-dd")
    @JsonProperty("zzcjsj")
    private Timestamp zzcjsj;
    /**
     * 组织地址一
     */
    @TableField(value = "zzdzy")
    @JSONField(name = "zzdzy")
    @JsonProperty("zzdzy")
    private String zzdzy;
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
     * 对应OU
     */
    @TableField(value = "correspondingorg")
    @JSONField(name = "correspondingorg")
    @JsonProperty("correspondingorg")
    private String correspondingorg;
    /**
     * 虚拟组织
     */
    @TableField(value = "xn")
    @JSONField(name = "xn")
    @JsonProperty("xn")
    private Integer xn;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 组织地址二
     */
    @TableField(value = "zzdze")
    @JSONField(name = "zzdze")
    @JsonProperty("zzdze")
    private String zzdze;
    /**
     * 组织编号
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 组织标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "orgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 组织显示名称
     */
    @TableField(value = "zzdzs")
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 简称
     */
    @TableField(value = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * ERP组织ID
     */
    @TableField(value = "erporgid")
    @JSONField(name = "erporgid")
    @JsonProperty("erporgid")
    private String erporgid;
    /**
     * 组织类型
     */
    @TableField(value = "zzlx")
    @JSONField(name = "zzlx")
    @JsonProperty("zzlx")
    private String zzlx;
    /**
     * 组织名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 上级组织
     */
    @TableField(exist = false)
    @JSONField(name = "porgname")
    @JsonProperty("porgname")
    private String porgname;
    /**
     * 组织机构标识
     */
    @TableField(value = "porgid")
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg porg;



    /**
     * 设置 [区域补贴]
     */
    public void setBtqy(String btqy){
        this.btqy = btqy ;
        this.modify("btqy",btqy);
    }

    /**
     * 设置 [启停标识]
     */
    public void setStartstopsign(String startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [公司根组织ID]
     */
    public void setCompanyflag(String companyflag){
        this.companyflag = companyflag ;
        this.modify("companyflag",companyflag);
    }

    /**
     * 设置 [组织性质]
     */
    public void setLegalentity(String legalentity){
        this.legalentity = legalentity ;
        this.modify("legalentity",legalentity);
    }

    /**
     * 设置 [所属OU]
     */
    public void setSsou(String ssou){
        this.ssou = ssou ;
        this.modify("ssou",ssou);
    }

    /**
     * 设置 [组织地址编码]
     */
    public void setZzdzbm(String zzdzbm){
        this.zzdzbm = zzdzbm ;
        this.modify("zzdzbm",zzdzbm);
    }

    /**
     * 设置 [所属区域]
     */
    public void setGsss(String gsss){
        this.gsss = gsss ;
        this.modify("gsss",gsss);
    }

    /**
     * 设置 [级别编码]
     */
    public void setLevelcode(String levelcode){
        this.levelcode = levelcode ;
        this.modify("levelcode",levelcode);
    }

    /**
     * 设置 [排序号]
     */
    public void setPx(Integer px){
        this.px = px ;
        this.modify("px",px);
    }

    /**
     * 设置 [组织创建时间]
     */
    public void setZzcjsj(Timestamp zzcjsj){
        this.zzcjsj = zzcjsj ;
        this.modify("zzcjsj",zzcjsj);
    }

    /**
     * 格式化日期 [组织创建时间]
     */
    public String formatZzcjsj(){
        if (this.zzcjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zzcjsj);
    }
    /**
     * 设置 [组织地址一]
     */
    public void setZzdzy(String zzdzy){
        this.zzdzy = zzdzy ;
        this.modify("zzdzy",zzdzy);
    }

    /**
     * 设置 [对应OU]
     */
    public void setCorrespondingorg(String correspondingorg){
        this.correspondingorg = correspondingorg ;
        this.modify("correspondingorg",correspondingorg);
    }

    /**
     * 设置 [虚拟组织]
     */
    public void setXn(Integer xn){
        this.xn = xn ;
        this.modify("xn",xn);
    }

    /**
     * 设置 [组织地址二]
     */
    public void setZzdze(String zzdze){
        this.zzdze = zzdze ;
        this.modify("zzdze",zzdze);
    }

    /**
     * 设置 [组织编号]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [组织显示名称]
     */
    public void setZzdzs(String zzdzs){
        this.zzdzs = zzdzs ;
        this.modify("zzdzs",zzdzs);
    }

    /**
     * 设置 [简称]
     */
    public void setShortname(String shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [ERP组织ID]
     */
    public void setErporgid(String erporgid){
        this.erporgid = erporgid ;
        this.modify("erporgid",erporgid);
    }

    /**
     * 设置 [组织类型]
     */
    public void setZzlx(String zzlx){
        this.zzlx = zzlx ;
        this.modify("zzlx",zzlx);
    }

    /**
     * 设置 [组织机构标识]
     */
    public void setPorgid(String porgid){
        this.porgid = porgid ;
        this.modify("porgid",porgid);
    }


}


