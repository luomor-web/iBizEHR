package cn.ibizlab.ehr.core.wf.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[工作流工作催办]
 */
@Data
@TableName(value = "T_SRFWFREMINDER",resultMap = "WFReminderResultMap")
public class WFReminder extends EntityMP implements Serializable {

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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 催办备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 工作流工作催办标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfreminderid",type=IdType.UUID)
    @JSONField(name = "wfreminderid")
    @JsonProperty("wfreminderid")
    private String wfreminderid;
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
     * 催办时间
     */
    @TableField(value = "remindertime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "remindertime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("remindertime")
    private Timestamp remindertime;
    /**
     * 标题
     */
    @TableField(value = "wfremindername")
    @JSONField(name = "wfremindername")
    @JsonProperty("wfremindername")
    private String wfremindername;
    /**
     * 已催次数
     */
    @TableField(exist = false)
    @JSONField(name = "remindercount")
    @JsonProperty("remindercount")
    private Integer remindercount;
    /**
     * 工作操作者
     */
    @TableField(exist = false)
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;
    /**
     * 送交时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "wfcreatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("wfcreatedate")
    private Timestamp wfcreatedate;
    /**
     * 催办对象
     */
    @TableField(exist = false)
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;
    /**
     * 催办者
     */
    @TableField(value = "wfusername")
    @JSONField(name = "wfusername")
    @JsonProperty("wfusername")
    private String wfusername;
    /**
     * 工作流催办_操作者
     */
    @TableField(value = "wfstepactorid")
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;
    /**
     * 催办者
     */
    @TableField(value = "wfuserid")
    @JSONField(name = "wfuserid")
    @JsonProperty("wfuserid")
    private String wfuserid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFStepActor wfstepactor;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfuser;



    /**
     * 设置 [催办备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [催办时间]
     */
    public void setRemindertime(Timestamp remindertime){
        this.remindertime = remindertime ;
        this.modify("remindertime",remindertime);
    }
    /**
     * 设置 [标题]
     */
    public void setWfremindername(String wfremindername){
        this.wfremindername = wfremindername ;
        this.modify("wfremindername",wfremindername);
    }
    /**
     * 设置 [催办者]
     */
    public void setWfusername(String wfusername){
        this.wfusername = wfusername ;
        this.modify("wfusername",wfusername);
    }
    /**
     * 设置 [工作流催办_操作者]
     */
    public void setWfstepactorid(String wfstepactorid){
        this.wfstepactorid = wfstepactorid ;
        this.modify("wfstepactorid",wfstepactorid);
    }
    /**
     * 设置 [催办者]
     */
    public void setWfuserid(String wfuserid){
        this.wfuserid = wfuserid ;
        this.modify("wfuserid",wfuserid);
    }

}


