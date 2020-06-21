package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[组织管理关系表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMRELATION",resultMap = "OrmRelationResultMap")
public class OrmRelation extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织名称
     */
    @DEField(name = "ormrelationname")
    @TableField(value = "ormrelationname")
    @JSONField(name = "ormorgrelationname")
    @JsonProperty("ormorgrelationname")
    private String ormorgrelationname;
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
     * 组织ID
     */
    @DEField(name = "ormrelationid" , isKeyField=true)
    @TableId(value= "ormrelationid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormorgrelationid")
    @JsonProperty("ormorgrelationid")
    private String ormorgrelationid;
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
     * 管理单位ID
     */
    @TableField(value = "magunitid")
    @JSONField(name = "magunitid")
    @JsonProperty("magunitid")
    private String magunitid;
    /**
     * 组织编码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 管理单位
     */
    @TableField(value = "managementunits")
    @JSONField(name = "managementunits")
    @JsonProperty("managementunits")
    private String managementunits;
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
     * 设置 [组织名称]
     */
    public void setOrmorgrelationname(String ormorgrelationname){
        this.ormorgrelationname = ormorgrelationname ;
        this.modify("ormrelationname",ormorgrelationname);
    }

    /**
     * 设置 [管理单位ID]
     */
    public void setMagunitid(String magunitid){
        this.magunitid = magunitid ;
        this.modify("magunitid",magunitid);
    }

    /**
     * 设置 [组织编码]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [管理单位]
     */
    public void setManagementunits(String managementunits){
        this.managementunits = managementunits ;
        this.modify("managementunits",managementunits);
    }


}


