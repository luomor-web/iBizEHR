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
 * 实体[执业资格专业]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMQUALMAJOR",resultMap = "PimQualMajorResultMap")
public class PimQualMajor extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 岗位类型
     */
    @TableField(value = "gwzs")
    @JSONField(name = "gwzs")
    @JsonProperty("gwzs")
    private String gwzs;
    /**
     * 岗位类型
     */
    @TableField(value = "gwtype")
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;
    /**
     * 专业技术职务
     */
    @TableField(value = "zyjszw")
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;
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
     * 专业
     */
    @TableField(value = "quamajor")
    @JSONField(name = "quamajor")
    @JsonProperty("quamajor")
    private String quamajor;
    /**
     * 岗位类型
     */
    @TableField(value = "gwlx")
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 级别
     */
    @TableField(value = "qualevel")
    @JSONField(name = "qualevel")
    @JsonProperty("qualevel")
    private String qualevel;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 执业资格专业编码
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimqualmajorid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;
    /**
     * 执业资格名称
     */
    @TableField(exist = false)
    @JSONField(name = "zyzgzy")
    @JsonProperty("zyzgzy")
    private String zyzgzy;
    /**
     * 执业资格
     */
    @TableField(value = "pimqualmajorname")
    @JSONField(name = "pimqualmajorname")
    @JsonProperty("pimqualmajorname")
    private String pimqualmajorname;
    /**
     * 执业资格类别
     */
    @TableField(value = "professionaltype")
    @JSONField(name = "professionaltype")
    @JsonProperty("professionaltype")
    private String professionaltype;
    /**
     * 执业资格类别
     */
    @TableField(exist = false)
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 执业资格类别标识
     */
    @TableField(value = "pimqualtypeid")
    @JSONField(name = "pimqualtypeid")
    @JsonProperty("pimqualtypeid")
    private String pimqualtypeid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 执业资格类别
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimQualType pimqualtype;



    /**
     * 设置 [岗位类型]
     */
    public void setGwzs(String gwzs){
        this.gwzs = gwzs ;
        this.modify("gwzs",gwzs);
    }

    /**
     * 设置 [岗位类型]
     */
    public void setGwtype(String gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [专业技术职务]
     */
    public void setZyjszw(String zyjszw){
        this.zyjszw = zyjszw ;
        this.modify("zyjszw",zyjszw);
    }

    /**
     * 设置 [专业]
     */
    public void setQuamajor(String quamajor){
        this.quamajor = quamajor ;
        this.modify("quamajor",quamajor);
    }

    /**
     * 设置 [岗位类型]
     */
    public void setGwlx(String gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }

    /**
     * 设置 [级别]
     */
    public void setQualevel(String qualevel){
        this.qualevel = qualevel ;
        this.modify("qualevel",qualevel);
    }

    /**
     * 设置 [执业资格]
     */
    public void setPimqualmajorname(String pimqualmajorname){
        this.pimqualmajorname = pimqualmajorname ;
        this.modify("pimqualmajorname",pimqualmajorname);
    }

    /**
     * 设置 [执业资格类别]
     */
    public void setProfessionaltype(String professionaltype){
        this.professionaltype = professionaltype ;
        this.modify("professionaltype",professionaltype);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [执业资格类别标识]
     */
    public void setPimqualtypeid(String pimqualtypeid){
        this.pimqualtypeid = pimqualtypeid ;
        this.modify("pimqualtypeid",pimqualtypeid);
    }


}


