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
 * 实体[试用期员工转正考核结果记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMXYGZZKHJGJL",resultMap = "PcmXygzzkhjgjlResultMap")
public class PcmXygzzkhjgjl extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 员工
     */
    @TableField(value = "pcmxygzzkhjgjlname")
    @JSONField(name = "pcmxygzzkhjgjlname")
    @JsonProperty("pcmxygzzkhjgjlname")
    private String pcmxygzzkhjgjlname;
    /**
     * 逻辑有效标志
     */
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 新员工转正考核结果记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmxygzzkhjgjlid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmxygzzkhjgjlid")
    @JsonProperty("pcmxygzzkhjgjlid")
    private String pcmxygzzkhjgjlid;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 分数
     */
    @TableField(value = "fs")
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;
    /**
     * 起始时间
     */
    @TableField(value = "qssj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("qssj")
    private Timestamp qssj;



    /**
     * 设置 [结束时间]
     */
    public void setJssj(Timestamp jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 格式化日期 [结束时间]
     */
    public String formatJssj(){
        if (this.jssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(jssj);
    }
    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [员工]
     */
    public void setPcmxygzzkhjgjlname(String pcmxygzzkhjgjlname){
        this.pcmxygzzkhjgjlname = pcmxygzzkhjgjlname ;
        this.modify("pcmxygzzkhjgjlname",pcmxygzzkhjgjlname);
    }

    /**
     * 设置 [逻辑有效标志]
     */
    public void setEnable(Integer enable){
        this.enable = enable ;
        this.modify("enable",enable);
    }

    /**
     * 设置 [分数]
     */
    public void setFs(Double fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [起始时间]
     */
    public void setQssj(Timestamp qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }

    /**
     * 格式化日期 [起始时间]
     */
    public String formatQssj(){
        if (this.qssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(qssj);
    }

}


