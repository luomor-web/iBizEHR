package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[绩效模板明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXKHMBMX",resultMap = "ParJxkhmbmxResultMap")
public class ParJxkhmbmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核模板明细名称
     */
    @TableField(value = "parjxkhmbmxname")
    @JSONField(name = "parjxkhmbmxname")
    @JsonProperty("parjxkhmbmxname")
    private String parjxkhmbmxname;
    /**
     * 最大得分
     */
    @TableField(value = "zdfz")
    @JSONField(name = "zdfz")
    @JsonProperty("zdfz")
    private Double zdfz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 考核模板明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxkhmbmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxkhmbmxid")
    @JsonProperty("parjxkhmbmxid")
    private String parjxkhmbmxid;
    /**
     * 分值
     */
    @TableField(value = "fz")
    @JSONField(name = "fz")
    @JsonProperty("fz")
    private String fz;
    /**
     * 指标
     */
    @TableField(value = "zb")
    @JSONField(name = "zb")
    @JsonProperty("zb")
    private String zb;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 最小得分
     */
    @TableField(value = "zxfz")
    @JSONField(name = "zxfz")
    @JsonProperty("zxfz")
    private Double zxfz;
    /**
     * 模板名称
     */
    @TableField(exist = false)
    @JSONField(name = "parjxkhmbname")
    @JsonProperty("parjxkhmbname")
    private String parjxkhmbname;
    /**
     * 模板ID
     */
    @TableField(value = "parjxkhmbid")
    @JSONField(name = "parjxkhmbid")
    @JsonProperty("parjxkhmbid")
    private String parjxkhmbid;

    /**
     * 模板
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParJxkhmb parjxkhmb;



    /**
     * 设置 [考核模板明细名称]
     */
    public void setParjxkhmbmxname(String parjxkhmbmxname){
        this.parjxkhmbmxname = parjxkhmbmxname ;
        this.modify("parjxkhmbmxname",parjxkhmbmxname);
    }

    /**
     * 设置 [最大得分]
     */
    public void setZdfz(Double zdfz){
        this.zdfz = zdfz ;
        this.modify("zdfz",zdfz);
    }

    /**
     * 设置 [分值]
     */
    public void setFz(String fz){
        this.fz = fz ;
        this.modify("fz",fz);
    }

    /**
     * 设置 [指标]
     */
    public void setZb(String zb){
        this.zb = zb ;
        this.modify("zb",zb);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [最小得分]
     */
    public void setZxfz(Double zxfz){
        this.zxfz = zxfz ;
        this.modify("zxfz",zxfz);
    }

    /**
     * 设置 [模板ID]
     */
    public void setParjxkhmbid(String parjxkhmbid){
        this.parjxkhmbid = parjxkhmbid ;
        this.modify("parjxkhmbid",parjxkhmbid);
    }


}


