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
 * 实体[岗位类型对照表]
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "T_PIMGWTYPE",resultMap = "PimGwTypeResultMap")
public class PimGwType extends EntityMP implements Serializable {

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
     * 岗位类型对照表名称
     */
    @TableField(value = "pimgwtypename")
    @JSONField(name = "pimgwtypename")
    @JsonProperty("pimgwtypename")
    private String pimgwtypename;
    /**
     * 岗位类型
     */
    @TableField(value = "gwlx")
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;
    /**
     * 排序值
     */
    @TableField(value = "ordervalue")
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
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
     * 岗位类型对照表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimgwtypeid",type=IdType.UUID)
    @JSONField(name = "pimgwtypeid")
    @JsonProperty("pimgwtypeid")
    private String pimgwtypeid;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;



    /**
     * 设置 [岗位类型对照表名称]
     */
    public void setPimgwtypename(String pimgwtypename){
        this.pimgwtypename = pimgwtypename ;
        this.modify("pimgwtypename",pimgwtypename);
    }
    /**
     * 设置 [岗位类型]
     */
    public void setGwlx(String gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }
    /**
     * 设置 [排序值]
     */
    public void setOrdervalue(Integer ordervalue){
        this.ordervalue = ordervalue ;
        this.modify("ordervalue",ordervalue);
    }

}


