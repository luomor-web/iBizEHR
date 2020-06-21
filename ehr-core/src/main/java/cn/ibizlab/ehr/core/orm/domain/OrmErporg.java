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
 * 实体[ERP组织中间表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMERPORG",resultMap = "OrmErporgResultMap")
public class OrmErporg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织类型
     */
    @TableField(value = "orgtype")
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;
    /**
     * 省市
     */
    @TableField(value = "towncity")
    @JSONField(name = "towncity")
    @JsonProperty("towncity")
    private String towncity;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isenable")
    @JSONField(name = "isenable")
    @JsonProperty("isenable")
    private String isenable;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 有效期至
     */
    @TableField(value = "dateto")
    @JSONField(name = "dateto")
    @JsonProperty("dateto")
    private String dateto;
    /**
     * 组织地址1
     */
    @TableField(value = "orgaddressline1")
    @JSONField(name = "orgaddressline1")
    @JsonProperty("orgaddressline1")
    private String orgaddressline1;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 组织类型释义
     */
    @TableField(value = "orgtypename")
    @JSONField(name = "orgtypename")
    @JsonProperty("orgtypename")
    private String orgtypename;
    /**
     * 组织地址3
     */
    @TableField(value = "orgaddressline3")
    @JSONField(name = "orgaddressline3")
    @JsonProperty("orgaddressline3")
    private String orgaddressline3;
    /**
     * 组织地址2
     */
    @TableField(value = "orgaddressline2")
    @JSONField(name = "orgaddressline2")
    @JsonProperty("orgaddressline2")
    private String orgaddressline2;
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
     * 组织ID
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormerporgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormerporgid")
    @JsonProperty("ormerporgid")
    private String ormerporgid;
    /**
     * 所属OU的组织编码
     */
    @TableField(value = "oucode")
    @JSONField(name = "oucode")
    @JsonProperty("oucode")
    private String oucode;
    /**
     * 所属OU的组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "belongou")
    @JsonProperty("belongou")
    private String belongou;
    /**
     * 最近更新时间
     */
    @TableField(value = "lastupdatedate")
    @JSONField(name = "lastupdatedate")
    @JsonProperty("lastupdatedate")
    private String lastupdatedate;
    /**
     * 有效期从
     */
    @TableField(value = "datefrom")
    @JSONField(name = "datefrom")
    @JsonProperty("datefrom")
    private String datefrom;
    /**
     * 行政编码
     */
    @TableField(exist = false)
    @JSONField(name = "admcoding")
    @JsonProperty("admcoding")
    private String admcoding;
    /**
     * 引用标志
     */
    @DEField(defaultValue = "0")
    @TableField(value = "yyflag")
    @JSONField(name = "yyflag")
    @JsonProperty("yyflag")
    private String yyflag;
    /**
     * 组织简称
     */
    @TableField(value = "orgshortname")
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;
    /**
     * 组织名称
     */
    @TableField(value = "ormerporgname")
    @JSONField(name = "ormerporgname")
    @JsonProperty("ormerporgname")
    private String ormerporgname;
    /**
     * 创建日期
     */
    @TableField(value = "orgcreatedate")
    @JSONField(name = "orgcreatedate")
    @JsonProperty("orgcreatedate")
    private String orgcreatedate;
    /**
     * 父级组织ID
     */
    @TableField(value = "parentorgid")
    @JSONField(name = "parentorgid")
    @JsonProperty("parentorgid")
    private String parentorgid;
    /**
     * 组织排序编号
     */
    @TableField(value = "ordernum")
    @JSONField(name = "ordernum")
    @JsonProperty("ordernum")
    private String ordernum;
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
     * 邮编
     */
    @TableField(value = "orgzipcode")
    @JSONField(name = "orgzipcode")
    @JsonProperty("orgzipcode")
    private String orgzipcode;
    /**
     * 所属OU的组织ID
     */
    @TableField(value = "ouid")
    @JSONField(name = "ouid")
    @JsonProperty("ouid")
    private String ouid;
    /**
     * 人数编制
     */
    @TableField(value = "numcomp")
    @JSONField(name = "numcomp")
    @JsonProperty("numcomp")
    private Integer numcomp;
    /**
     * 组织编码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;



    /**
     * 设置 [组织类型]
     */
    public void setOrgtype(String orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [省市]
     */
    public void setTowncity(String towncity){
        this.towncity = towncity ;
        this.modify("towncity",towncity);
    }

    /**
     * 设置 [是否有效]
     */
    public void setIsenable(String isenable){
        this.isenable = isenable ;
        this.modify("isenable",isenable);
    }

    /**
     * 设置 [有效期至]
     */
    public void setDateto(String dateto){
        this.dateto = dateto ;
        this.modify("dateto",dateto);
    }

    /**
     * 设置 [组织地址1]
     */
    public void setOrgaddressline1(String orgaddressline1){
        this.orgaddressline1 = orgaddressline1 ;
        this.modify("orgaddressline1",orgaddressline1);
    }

    /**
     * 设置 [组织类型释义]
     */
    public void setOrgtypename(String orgtypename){
        this.orgtypename = orgtypename ;
        this.modify("orgtypename",orgtypename);
    }

    /**
     * 设置 [组织地址3]
     */
    public void setOrgaddressline3(String orgaddressline3){
        this.orgaddressline3 = orgaddressline3 ;
        this.modify("orgaddressline3",orgaddressline3);
    }

    /**
     * 设置 [组织地址2]
     */
    public void setOrgaddressline2(String orgaddressline2){
        this.orgaddressline2 = orgaddressline2 ;
        this.modify("orgaddressline2",orgaddressline2);
    }

    /**
     * 设置 [所属OU的组织编码]
     */
    public void setOucode(String oucode){
        this.oucode = oucode ;
        this.modify("oucode",oucode);
    }

    /**
     * 设置 [最近更新时间]
     */
    public void setLastupdatedate(String lastupdatedate){
        this.lastupdatedate = lastupdatedate ;
        this.modify("lastupdatedate",lastupdatedate);
    }

    /**
     * 设置 [有效期从]
     */
    public void setDatefrom(String datefrom){
        this.datefrom = datefrom ;
        this.modify("datefrom",datefrom);
    }

    /**
     * 设置 [引用标志]
     */
    public void setYyflag(String yyflag){
        this.yyflag = yyflag ;
        this.modify("yyflag",yyflag);
    }

    /**
     * 设置 [组织简称]
     */
    public void setOrgshortname(String orgshortname){
        this.orgshortname = orgshortname ;
        this.modify("orgshortname",orgshortname);
    }

    /**
     * 设置 [组织名称]
     */
    public void setOrmerporgname(String ormerporgname){
        this.ormerporgname = ormerporgname ;
        this.modify("ormerporgname",ormerporgname);
    }

    /**
     * 设置 [创建日期]
     */
    public void setOrgcreatedate(String orgcreatedate){
        this.orgcreatedate = orgcreatedate ;
        this.modify("orgcreatedate",orgcreatedate);
    }

    /**
     * 设置 [父级组织ID]
     */
    public void setParentorgid(String parentorgid){
        this.parentorgid = parentorgid ;
        this.modify("parentorgid",parentorgid);
    }

    /**
     * 设置 [组织排序编号]
     */
    public void setOrdernum(String ordernum){
        this.ordernum = ordernum ;
        this.modify("ordernum",ordernum);
    }

    /**
     * 设置 [邮编]
     */
    public void setOrgzipcode(String orgzipcode){
        this.orgzipcode = orgzipcode ;
        this.modify("orgzipcode",orgzipcode);
    }

    /**
     * 设置 [所属OU的组织ID]
     */
    public void setOuid(String ouid){
        this.ouid = ouid ;
        this.modify("ouid",ouid);
    }

    /**
     * 设置 [人数编制]
     */
    public void setNumcomp(Integer numcomp){
        this.numcomp = numcomp ;
        this.modify("numcomp",numcomp);
    }

    /**
     * 设置 [组织编码]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }


}


