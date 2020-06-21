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
 * 实体[机构培训记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMAGENCYRECORD",resultMap = "TrmAgencyRecordResultMap")
public class TrmAgencyRecord extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 机构培训记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmagencyrecordid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmagencyrecordid")
    @JsonProperty("trmagencyrecordid")
    private String trmagencyrecordid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 培训次数
     */
    @TableField(value = "pxcs")
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;
    /**
     * 培训总时长
     */
    @TableField(value = "pxzsc")
    @JSONField(name = "pxzsc")
    @JsonProperty("pxzsc")
    private Double pxzsc;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训记录
     */
    @TableField(value = "trmagencyrecordname")
    @JSONField(name = "trmagencyrecordname")
    @JsonProperty("trmagencyrecordname")
    private String trmagencyrecordname;
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
     * 培训机构
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 培训机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [培训次数]
     */
    public void setPxcs(Integer pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [培训总时长]
     */
    public void setPxzsc(Double pxzsc){
        this.pxzsc = pxzsc ;
        this.modify("pxzsc",pxzsc);
    }

    /**
     * 设置 [培训记录]
     */
    public void setTrmagencyrecordname(String trmagencyrecordname){
        this.trmagencyrecordname = trmagencyrecordname ;
        this.modify("trmagencyrecordname",trmagencyrecordname);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


