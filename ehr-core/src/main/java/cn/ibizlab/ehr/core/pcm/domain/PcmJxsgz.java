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
 * 实体[见习生规则]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMJXSGZ",resultMap = "PcmJxsgzResultMap")
public class PcmJxsgz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 见习期（计算）
     */
    @TableField(value = "jxqjs")
    @JSONField(name = "jxqjs")
    @JsonProperty("jxqjs")
    private Double jxqjs;
    /**
     * 开始日期
     */
    @TableField(value = "ksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksrq" , format="yyyy-MM-dd")
    @JsonProperty("ksrq")
    private Timestamp ksrq;
    /**
     * 学历类型
     */
    @TableField(value = "xllx")
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 适用学历
     */
    @TableField(value = "applyedu")
    @JSONField(name = "applyedu")
    @JsonProperty("applyedu")
    private String applyedu;
    /**
     * 见习生规则标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmjxsgzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmjxsgzid")
    @JsonProperty("pcmjxsgzid")
    private String pcmjxsgzid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 见习期限
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;
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
     * 见习生规则名称
     */
    @TableField(value = "pcmjxsgzname")
    @JSONField(name = "pcmjxsgzname")
    @JsonProperty("pcmjxsgzname")
    private String pcmjxsgzname;
    /**
     * 结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 设置 [见习期（计算）]
     */
    public void setJxqjs(Double jxqjs){
        this.jxqjs = jxqjs ;
        this.modify("jxqjs",jxqjs);
    }

    /**
     * 设置 [开始日期]
     */
    public void setKsrq(Timestamp ksrq){
        this.ksrq = ksrq ;
        this.modify("ksrq",ksrq);
    }

    /**
     * 格式化日期 [开始日期]
     */
    public String formatKsrq(){
        if (this.ksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ksrq);
    }
    /**
     * 设置 [学历类型]
     */
    public void setXllx(String xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [适用学历]
     */
    public void setApplyedu(String applyedu){
        this.applyedu = applyedu ;
        this.modify("applyedu",applyedu);
    }

    /**
     * 设置 [见习期限]
     */
    public void setDuration(String duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [见习生规则名称]
     */
    public void setPcmjxsgzname(String pcmjxsgzname){
        this.pcmjxsgzname = pcmjxsgzname ;
        this.modify("pcmjxsgzname",pcmjxsgzname);
    }

    /**
     * 设置 [结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }


}


