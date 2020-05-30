package cn.ibizlab.ehr.core.pim.domain;

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
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[岗位（技能）证书]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "T_PIMQUALTYPE",resultMap = "PimQualTypeResultMap")
public class PimQualType extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 排序号
     */
    @TableField(value = "seialno")
    @JSONField(name = "seialno")
    @JsonProperty("seialno")
    private Integer seialno;
    /**
     * 岗位（技能）证书目录ID
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimqualtypeid",type=IdType.UUID)
    @JSONField(name = "pimqualtypeid")
    @JsonProperty("pimqualtypeid")
    private String pimqualtypeid;
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
     * 岗位（技能）证书
     */
    @TableField(value = "pimqualtypename")
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;



    /**
     * 设置 [排序号]
     */
    public void setSeialno(Integer seialno){
        this.seialno = seialno ;
        this.modify("seialno",seialno);
    }
    /**
     * 设置 [岗位（技能）证书]
     */
    public void setPimqualtypename(String pimqualtypename){
        this.pimqualtypename = pimqualtypename ;
        this.modify("pimqualtypename",pimqualtypename);
    }

}


