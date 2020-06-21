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
 * 实体[员工状态管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PERSONSTATEMGR",resultMap = "PersonStateMgrResultMap")
public class PersonStateMgr extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 员工状态管理名称
     */
    @TableField(value = "personstatemgrname")
    @JSONField(name = "personstatemgrname")
    @JsonProperty("personstatemgrname")
    private String personstatemgrname;
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
     * 员工状态管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "personstatemgrid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "personstatemgrid")
    @JsonProperty("personstatemgrid")
    private String personstatemgrid;
    /**
     * 排序值
     */
    @TableField(value = "orderno")
    @JSONField(name = "orderno")
    @JsonProperty("orderno")
    private Integer orderno;
    /**
     * 状态编码
     */
    @TableField(value = "personstatecode")
    @JSONField(name = "personstatecode")
    @JsonProperty("personstatecode")
    private String personstatecode;



    /**
     * 设置 [员工状态管理名称]
     */
    public void setPersonstatemgrname(String personstatemgrname){
        this.personstatemgrname = personstatemgrname ;
        this.modify("personstatemgrname",personstatemgrname);
    }

    /**
     * 设置 [排序值]
     */
    public void setOrderno(Integer orderno){
        this.orderno = orderno ;
        this.modify("orderno",orderno);
    }

    /**
     * 设置 [状态编码]
     */
    public void setPersonstatecode(String personstatecode){
        this.personstatecode = personstatecode ;
        this.modify("personstatecode",personstatecode);
    }


}


