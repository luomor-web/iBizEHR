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
 * 实体[高校名录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMGXML",resultMap = "PcmGxmlResultMap")
public class PcmGxml extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 高校名录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmgxmlid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmgxmlid")
    @JsonProperty("pcmgxmlid")
    private String pcmgxmlid;
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
     * 学校性质
     */
    @TableField(value = "xxxz")
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;
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
     * 高校类型（停用）
     */
    @TableField(value = "gxlb")
    @JSONField(name = "gxlb")
    @JsonProperty("gxlb")
    private String gxlb;
    /**
     * 国家或地区
     */
    @TableField(value = "nationarea")
    @JSONField(name = "nationarea")
    @JsonProperty("nationarea")
    private String nationarea;
    /**
     * 高校名称
     */
    @TableField(value = "pcmgxmlname")
    @JSONField(name = "pcmgxmlname")
    @JsonProperty("pcmgxmlname")
    private String pcmgxmlname;



    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [学校性质]
     */
    public void setXxxz(String xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [高校类型（停用）]
     */
    public void setGxlb(String gxlb){
        this.gxlb = gxlb ;
        this.modify("gxlb",gxlb);
    }

    /**
     * 设置 [国家或地区]
     */
    public void setNationarea(String nationarea){
        this.nationarea = nationarea ;
        this.modify("nationarea",nationarea);
    }

    /**
     * 设置 [高校名称]
     */
    public void setPcmgxmlname(String pcmgxmlname){
        this.pcmgxmlname = pcmgxmlname ;
        this.modify("pcmgxmlname",pcmgxmlname);
    }


}


