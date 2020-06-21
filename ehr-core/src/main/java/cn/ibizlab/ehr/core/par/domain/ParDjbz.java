package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[定级规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARDJBZ",resultMap = "ParDjbzResultMap")
public class ParDjbz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核评估等级
     */
    @TableField(value = "khpgdj")
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 定级标准名称
     */
    @TableField(value = "pardjbzname")
    @JSONField(name = "pardjbzname")
    @JsonProperty("pardjbzname")
    private String pardjbzname;
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
     * 定级标准标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pardjbzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pardjbzid")
    @JsonProperty("pardjbzid")
    private String pardjbzid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 分布比例（%）
     */
    @TableField(value = "fbbl")
    @JSONField(name = "fbbl")
    @JsonProperty("fbbl")
    private Double fbbl;



    /**
     * 设置 [考核评估等级]
     */
    public void setKhpgdj(String khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [定级标准名称]
     */
    public void setPardjbzname(String pardjbzname){
        this.pardjbzname = pardjbzname ;
        this.modify("pardjbzname",pardjbzname);
    }

    /**
     * 设置 [分布比例（%）]
     */
    public void setFbbl(Double fbbl){
        this.fbbl = fbbl ;
        this.modify("fbbl",fbbl);
    }


}


