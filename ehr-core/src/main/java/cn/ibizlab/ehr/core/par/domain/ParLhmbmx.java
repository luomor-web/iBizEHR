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
 * 实体[绩效量化目标明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARLHMBMX",resultMap = "ParLhmbmxResultMap")
public class ParLhmbmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 量化目标明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parlhmbmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parlhmbmxid")
    @JsonProperty("parlhmbmxid")
    private String parlhmbmxid;
    /**
     * 标准分值
     */
    @TableField(value = "bzfz")
    @JSONField(name = "bzfz")
    @JsonProperty("bzfz")
    private Double bzfz;
    /**
     * 量化目标
     */
    @TableField(value = "parlhmbmxname")
    @JSONField(name = "parlhmbmxname")
    @JsonProperty("parlhmbmxname")
    private String parlhmbmxname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 举证要求
     */
    @TableField(value = "jzyq")
    @JSONField(name = "jzyq")
    @JsonProperty("jzyq")
    private String jzyq;
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
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 完成标准
     */
    @TableField(value = "wcbz")
    @JSONField(name = "wcbz")
    @JsonProperty("wcbz")
    private String wcbz;
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
     * 考核办法
     */
    @TableField(value = "khbf")
    @JSONField(name = "khbf")
    @JsonProperty("khbf")
    private String khbf;
    /**
     * 绩效量化目标名称
     */
    @TableField(exist = false)
    @JSONField(name = "parjxlhmbname")
    @JsonProperty("parjxlhmbname")
    private String parjxlhmbname;
    /**
     * 量化目标ID
     */
    @TableField(value = "parjxlhmbid")
    @JSONField(name = "parjxlhmbid")
    @JsonProperty("parjxlhmbid")
    private String parjxlhmbid;

    /**
     * 量化目标
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParJxlhmb parjxlhmb;



    /**
     * 设置 [标准分值]
     */
    public void setBzfz(Double bzfz){
        this.bzfz = bzfz ;
        this.modify("bzfz",bzfz);
    }

    /**
     * 设置 [量化目标]
     */
    public void setParlhmbmxname(String parlhmbmxname){
        this.parlhmbmxname = parlhmbmxname ;
        this.modify("parlhmbmxname",parlhmbmxname);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [举证要求]
     */
    public void setJzyq(String jzyq){
        this.jzyq = jzyq ;
        this.modify("jzyq",jzyq);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [完成标准]
     */
    public void setWcbz(String wcbz){
        this.wcbz = wcbz ;
        this.modify("wcbz",wcbz);
    }

    /**
     * 设置 [考核办法]
     */
    public void setKhbf(String khbf){
        this.khbf = khbf ;
        this.modify("khbf",khbf);
    }

    /**
     * 设置 [量化目标ID]
     */
    public void setParjxlhmbid(String parjxlhmbid){
        this.parjxlhmbid = parjxlhmbid ;
        this.modify("parjxlhmbid",parjxlhmbid);
    }


}


