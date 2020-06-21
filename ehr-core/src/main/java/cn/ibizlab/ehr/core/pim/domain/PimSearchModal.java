package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[组合查询记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMSEARCHMODAL",resultMap = "PimSearchModalResultMap")
public class PimSearchModal extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组合查询模版名称
     */
    @TableField(value = "pimsearchmodalname")
    @JSONField(name = "pimsearchmodalname")
    @JsonProperty("pimsearchmodalname")
    private String pimsearchmodalname;
    /**
     * 查询列
     */
    @TableField(value = "searchfields")
    @JSONField(name = "searchfields")
    @JsonProperty("searchfields")
    private String searchfields;
    /**
     * 查询条件
     */
    @TableField(value = "conditions")
    @JSONField(name = "conditions")
    @JsonProperty("conditions")
    private String conditions;
    /**
     * 包含下级组织
     */
    @TableField(value = "contain")
    @JSONField(name = "contain")
    @JsonProperty("contain")
    private Integer contain;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否快速搜素
     */
    @TableField(value = "isquick")
    @JSONField(name = "isquick")
    @JsonProperty("isquick")
    private Integer isquick;
    /**
     * 组合查询模版标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimsearchmodalid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimsearchmodalid")
    @JsonProperty("pimsearchmodalid")
    private String pimsearchmodalid;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;



    /**
     * 设置 [组合查询模版名称]
     */
    public void setPimsearchmodalname(String pimsearchmodalname){
        this.pimsearchmodalname = pimsearchmodalname ;
        this.modify("pimsearchmodalname",pimsearchmodalname);
    }

    /**
     * 设置 [查询列]
     */
    public void setSearchfields(String searchfields){
        this.searchfields = searchfields ;
        this.modify("searchfields",searchfields);
    }

    /**
     * 设置 [查询条件]
     */
    public void setConditions(String conditions){
        this.conditions = conditions ;
        this.modify("conditions",conditions);
    }

    /**
     * 设置 [包含下级组织]
     */
    public void setContain(Integer contain){
        this.contain = contain ;
        this.modify("contain",contain);
    }

    /**
     * 设置 [是否快速搜素]
     */
    public void setIsquick(Integer isquick){
        this.isquick = isquick ;
        this.modify("isquick",isquick);
    }


}


