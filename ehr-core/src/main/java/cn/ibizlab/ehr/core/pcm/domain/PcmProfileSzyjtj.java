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
 * 实体[应聘者社招引进条件]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMPROFILESZYJTJ",resultMap = "PcmProfileSzyjtjResultMap")
public class PcmProfileSzyjtj extends EntityMP implements Serializable {

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
     * 序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 应聘者社招引进条件标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmprofileszyjtjid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmprofileszyjtjid")
    @JsonProperty("pcmprofileszyjtjid")
    private String pcmprofileszyjtjid;
    /**
     * 申报类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 应聘者社招引进条件
     */
    @TableField(value = "pcmprofileszyjtjname")
    @JSONField(name = "pcmprofileszyjtjname")
    @JsonProperty("pcmprofileszyjtjname")
    private String pcmprofileszyjtjname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;



    /**
     * 设置 [序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [申报类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [应聘者社招引进条件]
     */
    public void setPcmprofileszyjtjname(String pcmprofileszyjtjname){
        this.pcmprofileszyjtjname = pcmprofileszyjtjname ;
        this.modify("pcmprofileszyjtjname",pcmprofileszyjtjname);
    }


}


