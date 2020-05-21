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
 * 实体[工作流步骤操作者（临时）]
 */
@Data
@TableName(value = "T_SRFWFTMPSTEPACTOR",resultMap = "WFTmpStepActorResultMap")
public class WFTmpStepActor extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 工作流步骤操作者（临时）标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wftmpstepactorid",type=IdType.UUID)
    @JSONField(name = "wftmpstepactorid")
    @JsonProperty("wftmpstepactorid")
    private String wftmpstepactorid;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 操作连接
     */
    @TableField(value = "connection")
    @JSONField(name = "connection")
    @JsonProperty("connection")
    private String connection;
    /**
     * 上一个处理
     */
    @TableField(value = "prevprocess")
    @JSONField(name = "prevprocess")
    @JsonProperty("prevprocess")
    private String prevprocess;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作流步骤操作者（临时）名称
     */
    @DEField(defaultValue = "工作流步骤操作者（临时）")
    @TableField(value = "wftmpstepactorname")
    @JSONField(name = "wftmpstepactorname")
    @JsonProperty("wftmpstepactorname")
    private String wftmpstepactorname;
    /**
     * 工作流临时步骤操作者_工作流操作者
     */
    @TableField(value = "wfactorname")
    @JSONField(name = "wfactorname")
    @JsonProperty("wfactorname")
    private String wfactorname;
    /**
     * 工作流临时步骤操作者（上一步骤）
     */
    @TableField(value = "prevwfstepname")
    @JSONField(name = "prevwfstepname")
    @JsonProperty("prevwfstepname")
    private String prevwfstepname;
    /**
     * 工作流临时步骤操作者（上一步骤）
     */
    @TableField(value = "prevwfstepid")
    @JSONField(name = "prevwfstepid")
    @JsonProperty("prevwfstepid")
    private String prevwfstepid;
    /**
     * 工作流临时步骤操作者_工作流操作者
     */
    @TableField(value = "wfactorid")
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFActor wfactor;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFStep wfstep;



    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [操作连接]
     */
    public void setConnection(String connection){
        this.connection = connection ;
        this.modify("connection",connection);
    }
    /**
     * 设置 [上一个处理]
     */
    public void setPrevprocess(String prevprocess){
        this.prevprocess = prevprocess ;
        this.modify("prevprocess",prevprocess);
    }
    /**
     * 设置 [工作流步骤操作者（临时）名称]
     */
    public void setWftmpstepactorname(String wftmpstepactorname){
        this.wftmpstepactorname = wftmpstepactorname ;
        this.modify("wftmpstepactorname",wftmpstepactorname);
    }
    /**
     * 设置 [工作流临时步骤操作者_工作流操作者]
     */
    public void setWfactorname(String wfactorname){
        this.wfactorname = wfactorname ;
        this.modify("wfactorname",wfactorname);
    }
    /**
     * 设置 [工作流临时步骤操作者（上一步骤）]
     */
    public void setPrevwfstepname(String prevwfstepname){
        this.prevwfstepname = prevwfstepname ;
        this.modify("prevwfstepname",prevwfstepname);
    }
    /**
     * 设置 [工作流临时步骤操作者（上一步骤）]
     */
    public void setPrevwfstepid(String prevwfstepid){
        this.prevwfstepid = prevwfstepid ;
        this.modify("prevwfstepid",prevwfstepid);
    }
    /**
     * 设置 [工作流临时步骤操作者_工作流操作者]
     */
    public void setWfactorid(String wfactorid){
        this.wfactorid = wfactorid ;
        this.modify("wfactorid",wfactorid);
    }

}


