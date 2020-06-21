package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[休假明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACSITUATIONDETAIL",resultMap = "VacSituationDetailResultMap")
public class VacSituationDetail extends EntityMP implements Serializable {

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
     * 休假类型
     */
    @TableField(value = "xjlx")
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;
    /**
     * 休假明细名称
     */
    @TableField(value = "vacsituationdetailname")
    @JSONField(name = "vacsituationdetailname")
    @JsonProperty("vacsituationdetailname")
    private String vacsituationdetailname;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
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
     * 休假天数
     */
    @TableField(value = "xjts")
    @JSONField(name = "xjts")
    @JsonProperty("xjts")
    private Integer xjts;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 休假明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacsituationdetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacsituationdetailid")
    @JsonProperty("vacsituationdetailid")
    private String vacsituationdetailid;



    /**
     * 设置 [休假类型]
     */
    public void setXjlx(String xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [休假明细名称]
     */
    public void setVacsituationdetailname(String vacsituationdetailname){
        this.vacsituationdetailname = vacsituationdetailname ;
        this.modify("vacsituationdetailname",vacsituationdetailname);
    }

    /**
     * 设置 [休假天数]
     */
    public void setXjts(Integer xjts){
        this.xjts = xjts ;
        this.modify("xjts",xjts);
    }


}


