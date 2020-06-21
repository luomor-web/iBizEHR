package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[教育经费]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINBUAPPLY",resultMap = "TrmTrainBuapplyResultMap")
public class TrmTrainBuapply extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 培训预算申请标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainbuapplyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainbuapplyid")
    @JsonProperty("trmtrainbuapplyid")
    private String trmtrainbuapplyid;
    /**
     * 机构费用
     */
    @TableField(value = "jgfy")
    @JSONField(name = "jgfy")
    @JsonProperty("jgfy")
    private Double jgfy;
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
     * 实际费用
     */
    @TableField(value = "tzje")
    @JSONField(name = "tzje")
    @JsonProperty("tzje")
    private Double tzje;
    /**
     * 培训预算申请名称
     */
    @TableField(value = "trmtrainbuapplyname")
    @JSONField(name = "trmtrainbuapplyname")
    @JsonProperty("trmtrainbuapplyname")
    private String trmtrainbuapplyname;
    /**
     * 师资费
     */
    @TableField(value = "szf")
    @JSONField(name = "szf")
    @JsonProperty("szf")
    private Double szf;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 差旅费
     */
    @TableField(value = "clf")
    @JSONField(name = "clf")
    @JsonProperty("clf")
    private Double clf;
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
     * 其他费用
     */
    @TableField(value = "qtfy")
    @JSONField(name = "qtfy")
    @JsonProperty("qtfy")
    private Double qtfy;
    /**
     * 场地租金
     */
    @TableField(value = "cdzj")
    @JSONField(name = "cdzj")
    @JsonProperty("cdzj")
    private Double cdzj;
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
     * 培训预算
     */
    @TableField(value = "yszje")
    @JSONField(name = "yszje")
    @JsonProperty("yszje")
    private Double yszje;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 调整预算项目
     */
    @TableField(value = "tzysxm")
    @JSONField(name = "tzysxm")
    @JsonProperty("tzysxm")
    private String tzysxm;
    /**
     * 经费类型
     */
    @TableField(value = "jflx")
    @JSONField(name = "jflx")
    @JsonProperty("jflx")
    private String jflx;
    /**
     * 培训班
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 组织名称
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
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 班级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;



    /**
     * 设置 [机构费用]
     */
    public void setJgfy(Double jgfy){
        this.jgfy = jgfy ;
        this.modify("jgfy",jgfy);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [实际费用]
     */
    public void setTzje(Double tzje){
        this.tzje = tzje ;
        this.modify("tzje",tzje);
    }

    /**
     * 设置 [培训预算申请名称]
     */
    public void setTrmtrainbuapplyname(String trmtrainbuapplyname){
        this.trmtrainbuapplyname = trmtrainbuapplyname ;
        this.modify("trmtrainbuapplyname",trmtrainbuapplyname);
    }

    /**
     * 设置 [师资费]
     */
    public void setSzf(Double szf){
        this.szf = szf ;
        this.modify("szf",szf);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [差旅费]
     */
    public void setClf(Double clf){
        this.clf = clf ;
        this.modify("clf",clf);
    }

    /**
     * 设置 [其他费用]
     */
    public void setQtfy(Double qtfy){
        this.qtfy = qtfy ;
        this.modify("qtfy",qtfy);
    }

    /**
     * 设置 [场地租金]
     */
    public void setCdzj(Double cdzj){
        this.cdzj = cdzj ;
        this.modify("cdzj",cdzj);
    }

    /**
     * 设置 [培训预算]
     */
    public void setYszje(Double yszje){
        this.yszje = yszje ;
        this.modify("yszje",yszje);
    }

    /**
     * 设置 [调整预算项目]
     */
    public void setTzysxm(String tzysxm){
        this.tzysxm = tzysxm ;
        this.modify("tzysxm",tzysxm);
    }

    /**
     * 设置 [经费类型]
     */
    public void setJflx(String jflx){
        this.jflx = jflx ;
        this.modify("jflx",jflx);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}


