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
 * 实体[讲师收费记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTEACHERCHARGE",resultMap = "TrmTeacherChargeResultMap")
public class TrmTeacherCharge extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 讲师等级
     */
    @TableField(value = "jsdj")
    @JSONField(name = "jsdj")
    @JsonProperty("jsdj")
    private String jsdj;
    /**
     * 讲师收费记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmteacherchargeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmteacherchargeid")
    @JsonProperty("trmteacherchargeid")
    private String trmteacherchargeid;
    /**
     * 单价
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private Double dj;
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
     * 讲师收费记录名称
     */
    @TableField(value = "trmteacherchargename")
    @JSONField(name = "trmteacherchargename")
    @JsonProperty("trmteacherchargename")
    private String trmteacherchargename;
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
     * 总费用
     */
    @TableField(value = "zfy")
    @JSONField(name = "zfy")
    @JsonProperty("zfy")
    private Double zfy;
    /**
     * 学时
     */
    @TableField(value = "xs")
    @JSONField(name = "xs")
    @JsonProperty("xs")
    private Double xs;
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
     * 讲师
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 培训班
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;
    /**
     * 培训教师标识
     */
    @TableField(value = "trmtrainteacherid")
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;

    /**
     * 培训班
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;

    /**
     * 讲师
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher;



    /**
     * 设置 [讲师等级]
     */
    public void setJsdj(String jsdj){
        this.jsdj = jsdj ;
        this.modify("jsdj",jsdj);
    }

    /**
     * 设置 [单价]
     */
    public void setDj(Double dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [讲师收费记录名称]
     */
    public void setTrmteacherchargename(String trmteacherchargename){
        this.trmteacherchargename = trmteacherchargename ;
        this.modify("trmteacherchargename",trmteacherchargename);
    }

    /**
     * 设置 [总费用]
     */
    public void setZfy(Double zfy){
        this.zfy = zfy ;
        this.modify("zfy",zfy);
    }

    /**
     * 设置 [学时]
     */
    public void setXs(Double xs){
        this.xs = xs ;
        this.modify("xs",xs);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [培训教师标识]
     */
    public void setTrmtrainteacherid(String trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }


}


