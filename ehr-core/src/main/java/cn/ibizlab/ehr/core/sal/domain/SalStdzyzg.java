package cn.ibizlab.ehr.core.sal.domain;

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
 * 实体[执业资格津贴标准]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALSTDZYZG",resultMap = "SalStdzyzgResultMap")
public class SalStdzyzg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执业资格津贴标准名称
     */
    @TableField(value = "salstdzyzgname")
    @JSONField(name = "salstdzyzgname")
    @JsonProperty("salstdzyzgname")
    private String salstdzyzgname;
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
     * 补贴标准
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 执业资格津贴标准标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salstdzyzgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salstdzyzgid")
    @JsonProperty("salstdzyzgid")
    private String salstdzyzgid;
    /**
     * 专业分类
     */
    @TableField(value = "zyfl")
    @JSONField(name = "zyfl")
    @JsonProperty("zyfl")
    private String zyfl;
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
     * 级别分类
     */
    @TableField(value = "jbfl")
    @JSONField(name = "jbfl")
    @JsonProperty("jbfl")
    private String jbfl;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [执业资格津贴标准名称]
     */
    public void setSalstdzyzgname(String salstdzyzgname){
        this.salstdzyzgname = salstdzyzgname ;
        this.modify("salstdzyzgname",salstdzyzgname);
    }

    /**
     * 设置 [补贴标准]
     */
    public void setBz(Double bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [专业分类]
     */
    public void setZyfl(String zyfl){
        this.zyfl = zyfl ;
        this.modify("zyfl",zyfl);
    }

    /**
     * 设置 [级别分类]
     */
    public void setJbfl(String jbfl){
        this.jbfl = jbfl ;
        this.modify("jbfl",jbfl);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


