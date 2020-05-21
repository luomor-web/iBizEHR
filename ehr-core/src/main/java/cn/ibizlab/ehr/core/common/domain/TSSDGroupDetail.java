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
 * 实体[任务时刻策略组明细]
 */
@Data
@TableName(value = "T_SRFTSSDGROUPDETAIL",resultMap = "TSSDGroupDetailResultMap")
public class TSSDGroupDetail extends EntityMP implements Serializable {

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
     * 任务时刻策略组明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tssdgroupdetailid",type=IdType.UUID)
    @JSONField(name = "tssdgroupdetailid")
    @JsonProperty("tssdgroupdetailid")
    private String tssdgroupdetailid;
    /**
     * 任务时刻策略组明细名称
     */
    @TableField(value = "tssdgroupdetailname")
    @JSONField(name = "tssdgroupdetailname")
    @JsonProperty("tssdgroupdetailname")
    private String tssdgroupdetailname;
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
     * 任务时刻策略组
     */
    @TableField(exist = false)
    @JSONField(name = "tssdgroupname")
    @JsonProperty("tssdgroupname")
    private String tssdgroupname;
    /**
     * 任务时刻策略项
     */
    @TableField(exist = false)
    @JSONField(name = "tssditemname")
    @JsonProperty("tssditemname")
    private String tssditemname;
    /**
     * 任务时刻策略组
     */
    @TableField(value = "tssdgroupid")
    @JSONField(name = "tssdgroupid")
    @JsonProperty("tssdgroupid")
    private String tssdgroupid;
    /**
     * 任务时刻策略项
     */
    @TableField(value = "tssditemid")
    @JSONField(name = "tssditemid")
    @JsonProperty("tssditemid")
    private String tssditemid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDGroup tssdgroup;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.TSSDItem tssditem;



    /**
     * 设置 [任务时刻策略组明细名称]
     */
    public void setTssdgroupdetailname(String tssdgroupdetailname){
        this.tssdgroupdetailname = tssdgroupdetailname ;
        this.modify("tssdgroupdetailname",tssdgroupdetailname);
    }
    /**
     * 设置 [任务时刻策略组]
     */
    public void setTssdgroupid(String tssdgroupid){
        this.tssdgroupid = tssdgroupid ;
        this.modify("tssdgroupid",tssdgroupid);
    }
    /**
     * 设置 [任务时刻策略项]
     */
    public void setTssditemid(String tssditemid){
        this.tssditemid = tssditemid ;
        this.modify("tssditemid",tssditemid);
    }

}


