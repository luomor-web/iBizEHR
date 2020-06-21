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
 * 实体[平台流程配置]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMWORKFLOWREF",resultMap = "PimWorkflowRefResultMap")
public class PimWorkflowRef extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 平台流程配置标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimworkflowrefid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimworkflowrefid")
    @JsonProperty("pimworkflowrefid")
    private String pimworkflowrefid;
    /**
     * 平台流程配置名称
     */
    @TableField(value = "pimworkflowrefname")
    @JSONField(name = "pimworkflowrefname")
    @JsonProperty("pimworkflowrefname")
    private String pimworkflowrefname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 流程配置
     */
    @TableField(exist = false)
    @JSONField(name = "pimworkflowname")
    @JsonProperty("pimworkflowname")
    private String pimworkflowname;
    /**
     * 流程所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 流程配置
     */
    @TableField(value = "pimworkflowid")
    @JSONField(name = "pimworkflowid")
    @JsonProperty("pimworkflowid")
    private String pimworkflowid;

    /**
     * 平台流程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimWorkflow pimworkflow;



    /**
     * 设置 [平台流程配置名称]
     */
    public void setPimworkflowrefname(String pimworkflowrefname){
        this.pimworkflowrefname = pimworkflowrefname ;
        this.modify("pimworkflowrefname",pimworkflowrefname);
    }

    /**
     * 设置 [流程配置]
     */
    public void setPimworkflowid(String pimworkflowid){
        this.pimworkflowid = pimworkflowid ;
        this.modify("pimworkflowid",pimworkflowid);
    }


    /**
     * 获取 [平台流程配置标识]
     */
    public String getPimworkflowrefid(){
        if(ObjectUtils.isEmpty(pimworkflowrefid)){
            pimworkflowrefid=(String)getDefaultKey(true);
        }
        return pimworkflowrefid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getPimworkflowid())))
            return DigestUtils.md5DigestAsHex(String.format("%s" ,this.getPimworkflowid()).getBytes());
        return null;
    }
}


