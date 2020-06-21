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
 * 实体[员工能力明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPERSONABILITYDETAIL",resultMap = "PimPersonAbilityDetailResultMap")
public class PimPersonAbilityDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工能力明细名称
     */
    @TableField(value = "pimpersonabilitydetailname")
    @JSONField(name = "pimpersonabilitydetailname")
    @JsonProperty("pimpersonabilitydetailname")
    private String pimpersonabilitydetailname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工能力明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpersonabilitydetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpersonabilitydetailid")
    @JsonProperty("pimpersonabilitydetailid")
    private String pimpersonabilitydetailid;
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
     * 员工能力标识
     */
    @TableField(value = "pimpersonabilityid")
    @JSONField(name = "pimpersonabilityid")
    @JsonProperty("pimpersonabilityid")
    private String pimpersonabilityid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPersonAbility pimpersonability;



    /**
     * 设置 [员工能力明细名称]
     */
    public void setPimpersonabilitydetailname(String pimpersonabilitydetailname){
        this.pimpersonabilitydetailname = pimpersonabilitydetailname ;
        this.modify("pimpersonabilitydetailname",pimpersonabilitydetailname);
    }

    /**
     * 设置 [员工能力标识]
     */
    public void setPimpersonabilityid(String pimpersonabilityid){
        this.pimpersonabilityid = pimpersonabilityid ;
        this.modify("pimpersonabilityid",pimpersonabilityid);
    }


}


