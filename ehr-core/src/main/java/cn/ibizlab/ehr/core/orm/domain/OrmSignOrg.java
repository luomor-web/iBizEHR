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
 * 实体[法人主体]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMSIGNORG",resultMap = "OrmSignOrgResultMap")
public class OrmSignOrg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织编号
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 法人主体标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormsignorgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 简称
     */
    @TableField(value = "zzjc")
    @JSONField(name = "zzjc")
    @JsonProperty("zzjc")
    private String zzjc;
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
     * 法人主体名称
     */
    @TableField(value = "ormsignorgname")
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;



    /**
     * 设置 [组织编号]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [简称]
     */
    public void setZzjc(String zzjc){
        this.zzjc = zzjc ;
        this.modify("zzjc",zzjc);
    }

    /**
     * 设置 [法人主体名称]
     */
    public void setOrmsignorgname(String ormsignorgname){
        this.ormsignorgname = ormsignorgname ;
        this.modify("ormsignorgname",ormsignorgname);
    }


}


