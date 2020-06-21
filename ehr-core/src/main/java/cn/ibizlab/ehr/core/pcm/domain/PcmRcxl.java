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
 * 实体[人才序列]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMRCXL",resultMap = "PcmRcxlResultMap")
public class PcmRcxl extends EntityMP implements Serializable {

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
     * 序列号
     */
    @TableField(value = "code")
    @JSONField(name = "code")
    @JsonProperty("code")
    private String code;
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
     * 人才序列名称
     */
    @TableField(exist = false)
    @JSONField(name = "rcxlmc")
    @JsonProperty("rcxlmc")
    private String rcxlmc;
    /**
     * 人才序列标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmrcxlid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmrcxlid")
    @JsonProperty("pcmrcxlid")
    private String pcmrcxlid;
    /**
     * 排序编码
     */
    @TableField(value = "snumber")
    @JSONField(name = "snumber")
    @JsonProperty("snumber")
    private Integer snumber;
    /**
     * 人才序列类型
     */
    @TableField(value = "rcxllx")
    @JSONField(name = "rcxllx")
    @JsonProperty("rcxllx")
    private String rcxllx;
    /**
     * 人才序列名称
     */
    @TableField(value = "pcmrcxlname")
    @JSONField(name = "pcmrcxlname")
    @JsonProperty("pcmrcxlname")
    private String pcmrcxlname;
    /**
     * 序列等级
     */
    @TableField(value = "xldj")
    @JSONField(name = "xldj")
    @JsonProperty("xldj")
    private String xldj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 上级
     */
    @TableField(exist = false)
    @JSONField(name = "pcmrcxlname2")
    @JsonProperty("pcmrcxlname2")
    private String pcmrcxlname2;
    /**
     * 人才序列标识
     */
    @TableField(value = "pcmrcxlid2")
    @JSONField(name = "pcmrcxlid2")
    @JsonProperty("pcmrcxlid2")
    private String pcmrcxlid2;

    /**
     * 上级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmRcxl pcmrcxl2;



    /**
     * 设置 [序列号]
     */
    public void setCode(String code){
        this.code = code ;
        this.modify("code",code);
    }

    /**
     * 设置 [排序编码]
     */
    public void setSnumber(Integer snumber){
        this.snumber = snumber ;
        this.modify("snumber",snumber);
    }

    /**
     * 设置 [人才序列类型]
     */
    public void setRcxllx(String rcxllx){
        this.rcxllx = rcxllx ;
        this.modify("rcxllx",rcxllx);
    }

    /**
     * 设置 [人才序列名称]
     */
    public void setPcmrcxlname(String pcmrcxlname){
        this.pcmrcxlname = pcmrcxlname ;
        this.modify("pcmrcxlname",pcmrcxlname);
    }

    /**
     * 设置 [序列等级]
     */
    public void setXldj(String xldj){
        this.xldj = xldj ;
        this.modify("xldj",xldj);
    }

    /**
     * 设置 [人才序列标识]
     */
    public void setPcmrcxlid2(String pcmrcxlid2){
        this.pcmrcxlid2 = pcmrcxlid2 ;
        this.modify("pcmrcxlid2",pcmrcxlid2);
    }


}


