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
 * 实体[职数管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMZSGL",resultMap = "PcmZsglResultMap")
public class PcmZsgl extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 职级
     */
    @TableField(value = "zjname")
    @JSONField(name = "zjname")
    @JsonProperty("zjname")
    private String zjname;
    /**
     * 职数管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmzsglid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmzsglid")
    @JsonProperty("pcmzsglid")
    private String pcmzsglid;
    /**
     * 人数
     */
    @TableField(value = "zs")
    @JSONField(name = "zs")
    @JsonProperty("zs")
    private Integer zs;
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
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 组织名称
     */
    @TableField(value = "zzname")
    @JSONField(name = "zzname")
    @JsonProperty("zzname")
    private String zzname;
    /**
     * 职级ID
     */
    @TableField(value = "zjid")
    @JSONField(name = "zjid")
    @JsonProperty("zjid")
    private String zjid;
    /**
     * 组织ID
     */
    @TableField(value = "zzid")
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 职数管理名称
     */
    @TableField(value = "pcmzsglname")
    @JSONField(name = "pcmzsglname")
    @JsonProperty("pcmzsglname")
    private String pcmzsglname;



    /**
     * 设置 [职级]
     */
    public void setZjname(String zjname){
        this.zjname = zjname ;
        this.modify("zjname",zjname);
    }

    /**
     * 设置 [人数]
     */
    public void setZs(Integer zs){
        this.zs = zs ;
        this.modify("zs",zs);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [组织名称]
     */
    public void setZzname(String zzname){
        this.zzname = zzname ;
        this.modify("zzname",zzname);
    }

    /**
     * 设置 [职级ID]
     */
    public void setZjid(String zjid){
        this.zjid = zjid ;
        this.modify("zjid",zjid);
    }

    /**
     * 设置 [组织ID]
     */
    public void setZzid(String zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [职数管理名称]
     */
    public void setPcmzsglname(String pcmzsglname){
        this.pcmzsglname = pcmzsglname ;
        this.modify("pcmzsglname",pcmzsglname);
    }


}


