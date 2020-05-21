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
 * 实体[工作流系统设定]
 */
@Data
@TableName(value = "T_WFAPPSETTING",resultMap = "WFAppSettingResultMap")
public class WFAppSetting extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 工作流应用设定标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfappsettingid",type=IdType.UUID)
    @JSONField(name = "wfappsettingid")
    @JsonProperty("wfappsettingid")
    private String wfappsettingid;
    /**
     * 系统工作流设定
     */
    @TableField(value = "wfappsettingname")
    @JSONField(name = "wfappsettingname")
    @JsonProperty("wfappsettingname")
    private String wfappsettingname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * APPLICATIONID
     */
    @TableField(value = "applicationid")
    @JSONField(name = "applicationid")
    @JsonProperty("applicationid")
    private String applicationid;
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
     * 催办消息模板
     */
    @TableField(value = "remindmsgtemplname")
    @JSONField(name = "remindmsgtemplname")
    @JsonProperty("remindmsgtemplname")
    private String remindmsgtemplname;
    /**
     * 催办消息模板
     */
    @DEField(name = "remindmsgtempid")
    @TableField(value = "remindmsgtempid")
    @JSONField(name = "remindmsgtemplid")
    @JsonProperty("remindmsgtemplid")
    private String remindmsgtemplid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.MsgTemplate remindmsgtempl;



    /**
     * 设置 [系统工作流设定]
     */
    public void setWfappsettingname(String wfappsettingname){
        this.wfappsettingname = wfappsettingname ;
        this.modify("wfappsettingname",wfappsettingname);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [APPLICATIONID]
     */
    public void setApplicationid(String applicationid){
        this.applicationid = applicationid ;
        this.modify("applicationid",applicationid);
    }
    /**
     * 设置 [催办消息模板]
     */
    public void setRemindmsgtemplname(String remindmsgtemplname){
        this.remindmsgtemplname = remindmsgtemplname ;
        this.modify("remindmsgtemplname",remindmsgtemplname);
    }
    /**
     * 设置 [催办消息模板]
     */
    public void setRemindmsgtemplid(String remindmsgtemplid){
        this.remindmsgtemplid = remindmsgtemplid ;
        this.modify("remindmsgtempid",remindmsgtemplid);
    }

}


