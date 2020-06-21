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
 * 实体[招聘名额管理明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMZPMEGLMX",resultMap = "PcmZpmeglmxResultMap")
public class PcmZpmeglmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 招聘名额管理明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmzpmeglmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmzpmeglmxid")
    @JsonProperty("pcmzpmeglmxid")
    private String pcmzpmeglmxid;
    /**
     * 批复日期
     */
    @TableField(value = "pfrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pfrq" , format="yyyy-MM-dd")
    @JsonProperty("pfrq")
    private Timestamp pfrq;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 招聘名额管理明细名称
     */
    @TableField(value = "pcmzpmeglmxname")
    @JSONField(name = "pcmzpmeglmxname")
    @JsonProperty("pcmzpmeglmxname")
    private String pcmzpmeglmxname;
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
     * 招聘名额管理名称
     */
    @TableField(exist = false)
    @JSONField(name = "pcmzpmeglname")
    @JsonProperty("pcmzpmeglname")
    private String pcmzpmeglname;
    /**
     * 招聘名额管理标识
     */
    @TableField(value = "pcmzpmeglid")
    @JSONField(name = "pcmzpmeglid")
    @JsonProperty("pcmzpmeglid")
    private String pcmzpmeglid;

    /**
     * 招聘名额管理-招聘名额管理明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmZpmegl pcmzpmegl;



    /**
     * 设置 [批复日期]
     */
    public void setPfrq(Timestamp pfrq){
        this.pfrq = pfrq ;
        this.modify("pfrq",pfrq);
    }

    /**
     * 格式化日期 [批复日期]
     */
    public String formatPfrq(){
        if (this.pfrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pfrq);
    }
    /**
     * 设置 [招聘名额管理明细名称]
     */
    public void setPcmzpmeglmxname(String pcmzpmeglmxname){
        this.pcmzpmeglmxname = pcmzpmeglmxname ;
        this.modify("pcmzpmeglmxname",pcmzpmeglmxname);
    }

    /**
     * 设置 [招聘名额管理标识]
     */
    public void setPcmzpmeglid(String pcmzpmeglid){
        this.pcmzpmeglid = pcmzpmeglid ;
        this.modify("pcmzpmeglid",pcmzpmeglid);
    }


}


