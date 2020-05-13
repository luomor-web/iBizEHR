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
 * 实体[工作流操作者]
 */
@Data
@TableName(value = "T_SRFWFACTOR",resultMap = "WFActorResultMap")
public class WFActor extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色类型
     */
    @TableField(value = "wfactortype")
    @JSONField(name = "wfactortype")
    @JsonProperty("wfactortype")
    private String wfactortype;
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
     * 操作者参数2
     */
    @TableField(value = "wfactorparam2")
    @JSONField(name = "wfactorparam2")
    @JsonProperty("wfactorparam2")
    private String wfactorparam2;
    /**
     * 操作者参数
     */
    @TableField(value = "wfactorparam")
    @JSONField(name = "wfactorparam")
    @JsonProperty("wfactorparam")
    private String wfactorparam;
    /**
     * 工作流操作者名称
     */
    @TableField(value = "wfactorname")
    @JSONField(name = "wfactorname")
    @JsonProperty("wfactorname")
    private String wfactorname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 工作流操作者标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfactorid",type=IdType.UUID)
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;
    /**
     * 处理变量
     */
    @TableField(value = "params")
    @JSONField(name = "params")
    @JsonProperty("params")
    private String params;



    /**
     * 设置 [角色类型]
     */
    public void setWfactortype(String wfactortype){
        this.wfactortype = wfactortype ;
        this.modify("wfactortype",wfactortype);
    }
    /**
     * 设置 [操作者参数2]
     */
    public void setWfactorparam2(String wfactorparam2){
        this.wfactorparam2 = wfactorparam2 ;
        this.modify("wfactorparam2",wfactorparam2);
    }
    /**
     * 设置 [操作者参数]
     */
    public void setWfactorparam(String wfactorparam){
        this.wfactorparam = wfactorparam ;
        this.modify("wfactorparam",wfactorparam);
    }
    /**
     * 设置 [工作流操作者名称]
     */
    public void setWfactorname(String wfactorname){
        this.wfactorname = wfactorname ;
        this.modify("wfactorname",wfactorname);
    }
    /**
     * 设置 [处理变量]
     */
    public void setParams(String params){
        this.params = params ;
        this.modify("params",params);
    }
}






