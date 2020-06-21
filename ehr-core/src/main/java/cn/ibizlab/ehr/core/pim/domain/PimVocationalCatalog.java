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
 * 实体[执（职）业资格管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMVOCATIONALCATALOG",resultMap = "PimVocationalCatalogResultMap")
public class PimVocationalCatalog extends EntityMP implements Serializable {

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
     * 资格证书代码
     */
    @TableField(value = "dh")
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;
    /**
     * 职（执）业资格名称
     */
    @TableField(value = "pimvocationalcatalogname")
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;
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
     * 职（执）业资格管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimvocationalcatalogid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimvocationalcatalogid")
    @JsonProperty("pimvocationalcatalogid")
    private String pimvocationalcatalogid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 排序号
     */
    @TableField(value = "pxh")
    @JSONField(name = "pxh")
    @JsonProperty("pxh")
    private Integer pxh;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;



    /**
     * 设置 [资格证书代码]
     */
    public void setDh(String dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [职（执）业资格名称]
     */
    public void setPimvocationalcatalogname(String pimvocationalcatalogname){
        this.pimvocationalcatalogname = pimvocationalcatalogname ;
        this.modify("pimvocationalcatalogname",pimvocationalcatalogname);
    }

    /**
     * 设置 [排序号]
     */
    public void setPxh(Integer pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }


}


