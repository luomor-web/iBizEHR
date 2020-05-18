package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[组消息账户明细]
 */
@Data
@TableName(value = "T_SRFMSGACCOUNTDETAIL",resultMap = "MsgAccountDetailResultMap")
public class MsgAccountDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组消息账户明细名称
     */
    @TableField(value = "msgaccountdetailname")
    @JSONField(name = "msgaccountdetailname")
    @JsonProperty("msgaccountdetailname")
    private String msgaccountdetailname;
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
     * 组消息账户明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "msgaccountdetailid",type=IdType.UUID)
    @JSONField(name = "msgaccountdetailid")
    @JsonProperty("msgaccountdetailid")
    private String msgaccountdetailid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组账户
     */
    @TableField(exist = false)
    @JSONField(name = "majormsgaccountname")
    @JsonProperty("majormsgaccountname")
    private String majormsgaccountname;
    /**
     * 包含账户
     */
    @TableField(exist = false)
    @JSONField(name = "minormsgaccountname")
    @JsonProperty("minormsgaccountname")
    private String minormsgaccountname;
    /**
     * 组消息账户_组账户
     */
    @TableField(value = "majormsgaccountid")
    @JSONField(name = "majormsgaccountid")
    @JsonProperty("majormsgaccountid")
    private String majormsgaccountid;
    /**
     * 组消息账户_明细账户
     */
    @TableField(value = "minormsgaccountid")
    @JSONField(name = "minormsgaccountid")
    @JsonProperty("minormsgaccountid")
    private String minormsgaccountid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.MsgAccount majormsgaccount;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.MsgAccount minormsgaccount;



    /**
     * 设置 [组消息账户明细名称]
     */
    public void setMsgaccountdetailname(String msgaccountdetailname){
        this.msgaccountdetailname = msgaccountdetailname ;
        this.modify("msgaccountdetailname",msgaccountdetailname);
    }
    /**
     * 设置 [组消息账户_组账户]
     */
    public void setMajormsgaccountid(String majormsgaccountid){
        this.majormsgaccountid = majormsgaccountid ;
        this.modify("majormsgaccountid",majormsgaccountid);
    }
    /**
     * 设置 [组消息账户_明细账户]
     */
    public void setMinormsgaccountid(String minormsgaccountid){
        this.minormsgaccountid = minormsgaccountid ;
        this.modify("minormsgaccountid",minormsgaccountid);
    }

}


