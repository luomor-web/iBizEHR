package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[劳务派遣公司管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMLABOURCAMPANY",resultMap = "PimLabourcampanyResultMap")
public class PimLabourcampany extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 联系电话
     */
    @TableField(value = "lxfs")
    @JSONField(name = "lxfs")
    @JsonProperty("lxfs")
    private String lxfs;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 法人
     */
    @TableField(value = "legalperosn")
    @JSONField(name = "legalperosn")
    @JsonProperty("legalperosn")
    private String legalperosn;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 注册资本金
     */
    @TableField(value = "regcapital")
    @JSONField(name = "regcapital")
    @JsonProperty("regcapital")
    private String regcapital;
    /**
     * 公司名称
     */
    @TableField(value = "pimlabourcampanyname")
    @JSONField(name = "pimlabourcampanyname")
    @JsonProperty("pimlabourcampanyname")
    private String pimlabourcampanyname;
    /**
     * 经营范围
     */
    @TableField(value = "jyfw")
    @JSONField(name = "jyfw")
    @JsonProperty("jyfw")
    private String jyfw;
    /**
     * 劳务派遣公司管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimlabourcampanyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimlabourcampanyid")
    @JsonProperty("pimlabourcampanyid")
    private String pimlabourcampanyid;
    /**
     * 联系人
     */
    @TableField(value = "lxr")
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;
    /**
     * 公司简介
     */
    @TableField(value = "gsjj")
    @JSONField(name = "gsjj")
    @JsonProperty("gsjj")
    private String gsjj;
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
     * 联系地址
     */
    @TableField(value = "lxdz")
    @JSONField(name = "lxdz")
    @JsonProperty("lxdz")
    private String lxdz;
    /**
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
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
     * 劳务派遣公司管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [联系电话]
     */
    public void setLxfs(String lxfs){
        this.lxfs = lxfs ;
        this.modify("lxfs",lxfs);
    }

    /**
     * 设置 [法人]
     */
    public void setLegalperosn(String legalperosn){
        this.legalperosn = legalperosn ;
        this.modify("legalperosn",legalperosn);
    }

    /**
     * 设置 [注册资本金]
     */
    public void setRegcapital(String regcapital){
        this.regcapital = regcapital ;
        this.modify("regcapital",regcapital);
    }

    /**
     * 设置 [公司名称]
     */
    public void setPimlabourcampanyname(String pimlabourcampanyname){
        this.pimlabourcampanyname = pimlabourcampanyname ;
        this.modify("pimlabourcampanyname",pimlabourcampanyname);
    }

    /**
     * 设置 [经营范围]
     */
    public void setJyfw(String jyfw){
        this.jyfw = jyfw ;
        this.modify("jyfw",jyfw);
    }

    /**
     * 设置 [联系人]
     */
    public void setLxr(String lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [公司简介]
     */
    public void setGsjj(String gsjj){
        this.gsjj = gsjj ;
        this.modify("gsjj",gsjj);
    }

    /**
     * 设置 [联系地址]
     */
    public void setLxdz(String lxdz){
        this.lxdz = lxdz ;
        this.modify("lxdz",lxdz);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


