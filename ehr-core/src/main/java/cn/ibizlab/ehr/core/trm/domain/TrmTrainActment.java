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
 * 实体[培训活动评估]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINACTMENT",resultMap = "TrmTrainActmentResultMap")
public class TrmTrainActment extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 调查问卷附件
     */
    @TableField(value = "dcwjtm")
    @JSONField(name = "dcwjtm")
    @JsonProperty("dcwjtm")
    private String dcwjtm;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训后评估标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainactmentid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainactmentid")
    @JsonProperty("trmtrainactmentid")
    private String trmtrainactmentid;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 评估结果
     */
    @TableField(value = "pxjg")
    @JSONField(name = "pxjg")
    @JsonProperty("pxjg")
    private String pxjg;
    /**
     * 培训后评估名称
     */
    @TableField(value = "trmtrainactmentname")
    @JSONField(name = "trmtrainactmentname")
    @JsonProperty("trmtrainactmentname")
    private String trmtrainactmentname;
    /**
     * 培训后评估名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;
    /**
     * 培训后评估标识
     */
    @TableField(value = "trmtrainactapplyid")
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;
    /**
     * 评估对象
     */
    @TableField(value = "evaltarget")
    @JSONField(name = "evaltarget")
    @JsonProperty("evaltarget")
    private String evaltarget;
    /**
     * 评估内容
     */
    @TableField(value = "evalcontents")
    @JSONField(name = "evalcontents")
    @JsonProperty("evalcontents")
    private String evalcontents;
    /**
     * 评估时间
     */
    @TableField(value = "evaltime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "evaltime" , format="yyyy-MM-dd")
    @JsonProperty("evaltime")
    private Timestamp evaltime;

    /**
     * 培训活动
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply trmtrainactapply;



    /**
     * 设置 [调查问卷附件]
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
    public void setPxjg(String pxjg){
        this.pxjg = pxjg ;
        this.modify("pxjg",pxjg);
    }

    /**
     * 设置 [培训后评估名称]
     */
    public void setTrmtrainactmentname(String trmtrainactmentname){
        this.trmtrainactmentname = trmtrainactmentname ;
        this.modify("trmtrainactmentname",trmtrainactmentname);
    }

    /**
     * 设置 [培训后评估标识]
     */
    public void setTrmtrainactapplyid(String trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [评估对象]
     */
    public void setEvaltarget(String evaltarget){
        this.evaltarget = evaltarget ;
        this.modify("evaltarget",evaltarget);
    }

    /**
     * 设置 [评估内容]
     */
    public void setEvalcontents(String evalcontents){
        this.evalcontents = evalcontents ;
        this.modify("evalcontents",evalcontents);
    }

    /**
     * 设置 [评估时间]
     */
    public void setEvaltime(Timestamp evaltime){
        this.evaltime = evaltime ;
        this.modify("evaltime",evaltime);
    }

    /**
     * 格式化日期 [评估时间]
     */
    public String formatEvaltime(){
        if (this.evaltime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(evaltime);
    }

}


