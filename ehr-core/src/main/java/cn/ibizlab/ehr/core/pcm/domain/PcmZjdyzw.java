package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[职级和职务对应关系]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMZJDYZW",resultMap = "PcmZjdyzwResultMap")
public class PcmZjdyzw extends EntityMP implements Serializable {

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
     * 职级和职务对应关系标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmzjdyzwid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmzjdyzwid")
    @JsonProperty("pcmzjdyzwid")
    private String pcmzjdyzwid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职级和职务对应关系名称
     */
    @TableField(value = "pcmzjdyzwname")
    @JSONField(name = "pcmzjdyzwname")
    @JsonProperty("pcmzjdyzwname")
    private String pcmzjdyzwname;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 职务ID
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 职级ID
     */
    @TableField(value = "ormrankid")
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;

    /**
     * 职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 职级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmRank ormrank;



    /**
     * 设置 [职级和职务对应关系名称]
     */
    public void setPcmzjdyzwname(String pcmzjdyzwname){
        this.pcmzjdyzwname = pcmzjdyzwname ;
        this.modify("pcmzjdyzwname",pcmzjdyzwname);
    }

    /**
     * 设置 [职务ID]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [职级ID]
     */
    public void setOrmrankid(String ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }


}


