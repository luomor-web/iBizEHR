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
 * 实体[培训资源评估]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINRESMENT",resultMap = "TrmTrainResmentResultMap")
public class TrmTrainResment extends EntityMP implements Serializable {

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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 调查问卷题目
     */
    @TableField(value = "dcwjtm")
    @JSONField(name = "dcwjtm")
    @JsonProperty("dcwjtm")
    private String dcwjtm;
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
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 评估结果
     */
    @TableField(value = "pgjg")
    @JSONField(name = "pgjg")
    @JsonProperty("pgjg")
    private String pgjg;
    /**
     * 培训资源评估名称
     */
    @TableField(value = "trmtrainresmentname")
    @JSONField(name = "trmtrainresmentname")
    @JsonProperty("trmtrainresmentname")
    private String trmtrainresmentname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训资源评估标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainresmentid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainresmentid")
    @JsonProperty("trmtrainresmentid")
    private String trmtrainresmentid;



    /**
     * 设置 [调查问卷题目]
     */
    public void setDcwjtm(String dcwjtm){
        this.dcwjtm = dcwjtm ;
        this.modify("dcwjtm",dcwjtm);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [评估结果]
     */
    public void setPgjg(String pgjg){
        this.pgjg = pgjg ;
        this.modify("pgjg",pgjg);
    }

    /**
     * 设置 [培训资源评估名称]
     */
    public void setTrmtrainresmentname(String trmtrainresmentname){
        this.trmtrainresmentname = trmtrainresmentname ;
        this.modify("trmtrainresmentname",trmtrainresmentname);
    }


}


