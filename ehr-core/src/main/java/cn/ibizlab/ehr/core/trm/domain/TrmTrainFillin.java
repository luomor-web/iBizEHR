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
 * 实体[培训需求填报]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINFILLIN",resultMap = "TrmTrainFillinResultMap")
public class TrmTrainFillin extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 需求填报
     */
    @TableField(value = "trmtrainfillinname")
    @JSONField(name = "trmtrainfillinname")
    @JsonProperty("trmtrainfillinname")
    private String trmtrainfillinname;
    /**
     * 培训项目部门填报标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainfillinid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainfillinid")
    @JsonProperty("trmtrainfillinid")
    private String trmtrainfillinid;
    /**
     * 需求填报
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainfillinname2")
    @JsonProperty("trmtrainfillinname2")
    private String trmtrainfillinname2;
    /**
     * 年度
     */
    @TableField(exist = false)
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 季度
     */
    @TableField(exist = false)
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训需求通知
     */
    @TableField(exist = false)
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 截止时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzrq" , format="yyyy-MM-dd")
    @JsonProperty("jzrq")
    private Timestamp jzrq;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训项目部门填报标识
     */
    @TableField(value = "trmtrainfillinid2")
    @JSONField(name = "trmtrainfillinid2")
    @JsonProperty("trmtrainfillinid2")
    private String trmtrainfillinid2;
    /**
     * 培训需求通知标识
     */
    @TableField(value = "trmdepartid")
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 需求填报
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmDepart trmdepart;

    /**
     * 培训需求填报
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin trmtrainfillin2;



    /**
     * 设置 [需求填报]
     */
    public void setTrmtrainfillinname(String trmtrainfillinname){
        this.trmtrainfillinname = trmtrainfillinname ;
        this.modify("trmtrainfillinname",trmtrainfillinname);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训项目部门填报标识]
     */
    public void setTrmtrainfillinid2(String trmtrainfillinid2){
        this.trmtrainfillinid2 = trmtrainfillinid2 ;
        this.modify("trmtrainfillinid2",trmtrainfillinid2);
    }

    /**
     * 设置 [培训需求通知标识]
     */
    public void setTrmdepartid(String trmdepartid){
        this.trmdepartid = trmdepartid ;
        this.modify("trmdepartid",trmdepartid);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


