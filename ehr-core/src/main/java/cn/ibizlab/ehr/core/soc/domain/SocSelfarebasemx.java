package cn.ibizlab.ehr.core.soc.domain;

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
 * 实体[社保明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCSELFAREBASEMX",resultMap = "SocSelfarebasemxResultMap")
public class SocSelfarebasemx extends EntityMP implements Serializable {

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
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
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
     * 个人比例(%)
     */
    @TableField(value = "grbl")
    @JSONField(name = "grbl")
    @JsonProperty("grbl")
    private String grbl;
    /**
     * 说明
     */
    @TableField(value = "sm")
    @JSONField(name = "sm")
    @JsonProperty("sm")
    private String sm;
    /**
     * 单位比例(%)
     */
    @TableField(value = "dwbl")
    @JSONField(name = "dwbl")
    @JsonProperty("dwbl")
    private String dwbl;
    /**
     * 社保明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socselfarebasemxid",type=IdType.UUID)
    @JSONField(name = "socselfarebasemxid")
    @JsonProperty("socselfarebasemxid")
    private String socselfarebasemxid;
    /**
     * 社保明细名称
     */
    @TableField(value = "socselfarebasemxname")
    @JSONField(name = "socselfarebasemxname")
    @JsonProperty("socselfarebasemxname")
    private String socselfarebasemxname;
    /**
     * 社保福利类型
     */
    @TableField(value = "sbfllx")
    @JSONField(name = "sbfllx")
    @JsonProperty("sbfllx")
    private String sbfllx;
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
     * 上限(￥)
     */
    @TableField(value = "de")
    @JSONField(name = "de")
    @JsonProperty("de")
    private String de;
    /**
     * 单位社保账户名称
     */
    @TableField(exist = false)
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;
    /**
     * 参保地标识
     */
    @TableField(value = "socselfarebaseid")
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;
    /**
     * 单位社保账户标识
     */
    @TableField(value = "soccompanywelid")
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;

    /**
     * 社保明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocCompanyWel soccompanywel;

    /**
     * 参保地明细管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocSelfareBase socselfarebase;



    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [个人比例(%)]
     */
    public void setGrbl(String grbl){
        this.grbl = grbl ;
        this.modify("grbl",grbl);
    }

    /**
     * 设置 [说明]
     */
    public void setSm(String sm){
        this.sm = sm ;
        this.modify("sm",sm);
    }

    /**
     * 设置 [单位比例(%)]
     */
    public void setDwbl(String dwbl){
        this.dwbl = dwbl ;
        this.modify("dwbl",dwbl);
    }

    /**
     * 设置 [社保明细名称]
     */
    public void setSocselfarebasemxname(String socselfarebasemxname){
        this.socselfarebasemxname = socselfarebasemxname ;
        this.modify("socselfarebasemxname",socselfarebasemxname);
    }

    /**
     * 设置 [社保福利类型]
     */
    public void setSbfllx(String sbfllx){
        this.sbfllx = sbfllx ;
        this.modify("sbfllx",sbfllx);
    }

    /**
     * 设置 [上限(￥)]
     */
    public void setDe(String de){
        this.de = de ;
        this.modify("de",de);
    }

    /**
     * 设置 [参保地标识]
     */
    public void setSocselfarebaseid(String socselfarebaseid){
        this.socselfarebaseid = socselfarebaseid ;
        this.modify("socselfarebaseid",socselfarebaseid);
    }

    /**
     * 设置 [单位社保账户标识]
     */
    public void setSoccompanywelid(String soccompanywelid){
        this.soccompanywelid = soccompanywelid ;
        this.modify("soccompanywelid",soccompanywelid);
    }


}


