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
 * 实体[民族管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_NATIONMGR",resultMap = "PimNationMgrResultMap")
public class PimNationMgr extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序值
     */
    @TableField(value = "orderno")
    @JSONField(name = "orderno")
    @JsonProperty("orderno")
    private Integer orderno;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 民族编码
     */
    @TableField(value = "nationcode")
    @JSONField(name = "nationcode")
    @JsonProperty("nationcode")
    private String nationcode;
    /**
     * 民族管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "nationmgrid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "nationmgrid")
    @JsonProperty("nationmgrid")
    private String nationmgrid;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 民族管理名称
     */
    @TableField(value = "nationmgrname")
    @JSONField(name = "nationmgrname")
    @JsonProperty("nationmgrname")
    private String nationmgrname;



    /**
     * 设置 [排序值]
     */
    public void setOrderno(Integer orderno){
        this.orderno = orderno ;
        this.modify("orderno",orderno);
    }

    /**
     * 设置 [民族编码]
     */
    public void setNationcode(String nationcode){
        this.nationcode = nationcode ;
        this.modify("nationcode",nationcode);
    }

    /**
     * 设置 [民族管理名称]
     */
    public void setNationmgrname(String nationmgrname){
        this.nationmgrname = nationmgrname ;
        this.modify("nationmgrname",nationmgrname);
    }


}


