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
 * 实体[岗位]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMPOST",resultMap = "OrmPostResultMap")
public class OrmPost extends EntityMP implements Serializable {

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
     * 轮岗年限
     */
    @TableField(value = "lgnx")
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private Integer lgnx;
    /**
     * 必须交流年限
     */
    @TableField(value = "bxjlnx")
    @JSONField(name = "bxjlnx")
    @JsonProperty("bxjlnx")
    private Integer bxjlnx;
    /**
     * 是否临时数据
     */
    @TableField(value = "istemp")
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private String istemp;
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
     * 强制轮岗年限
     */
    @TableField(value = "qzlgnx")
    @JSONField(name = "qzlgnx")
    @JsonProperty("qzlgnx")
    private Integer qzlgnx;
    /**
     * 岗位性质
     */
    @TableField(value = "postnature")
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;
    /**
     * 是否关键岗位
     */
    @DEField(defaultValue = "0")
    @TableField(value = "iskeypostion")
    @JSONField(name = "iskeypostion")
    @JsonProperty("iskeypostion")
    private String iskeypostion;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 岗位标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormpostid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 建议交流年限
     */
    @TableField(value = "nx")
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Integer nx;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 是否保密岗
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isconfidential")
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 岗位名称
     */
    @TableField(value = "ormpostname")
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 岗位分类
     */
    @TableField(value = "gwfl")
    @JSONField(name = "gwfl")
    @JsonProperty("gwfl")
    private String gwfl;
    /**
     * 启用标识
     */
    @DEField(defaultValue = "1")
    @TableField(value = "startstopsign")
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;
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
     * 设置 [轮岗年限]
     */
    public void setLgnx(Integer lgnx){
        this.lgnx = lgnx ;
        this.modify("lgnx",lgnx);
    }

    /**
     * 设置 [必须交流年限]
     */
    public void setBxjlnx(Integer bxjlnx){
        this.bxjlnx = bxjlnx ;
        this.modify("bxjlnx",bxjlnx);
    }

    /**
     * 设置 [是否临时数据]
     */
    public void setIstemp(String istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [岗位类型]
     */
    public void setGwtype(String gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [强制轮岗年限]
     */
    public void setQzlgnx(Integer qzlgnx){
        this.qzlgnx = qzlgnx ;
        this.modify("qzlgnx",qzlgnx);
    }

    /**
     * 设置 [岗位性质]
     */
    public void setPostnature(String postnature){
        this.postnature = postnature ;
        this.modify("postnature",postnature);
    }

    /**
     * 设置 [是否关键岗位]
     */
    public void setIskeypostion(String iskeypostion){
        this.iskeypostion = iskeypostion ;
        this.modify("iskeypostion",iskeypostion);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [建议交流年限]
     */
    public void setNx(Integer nx){
        this.nx = nx ;
        this.modify("nx",nx);
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
    public void setOrmpostname(String ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [岗位分类]
     */
    public void setGwfl(String gwfl){
        this.gwfl = gwfl ;
        this.modify("gwfl",gwfl);
    }

    /**
     * 设置 [启用标识]
     */
    public void setStartstopsign(String startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


