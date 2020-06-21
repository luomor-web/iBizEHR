package cn.ibizlab.ehr.core.sal.domain;

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
 * 实体[薪酬计算指标]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALPARAM",resultMap = "SalParamResultMap")
public class SalParam extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 对应计算源属性
     */
    @TableField(value = "param")
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;
    /**
     * 薪酬计算指标标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salparamid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salparamid")
    @JsonProperty("salparamid")
    private String salparamid;
    /**
     * 薪酬计算指标名称
     */
    @TableField(value = "salparamname")
    @JSONField(name = "salparamname")
    @JsonProperty("salparamname")
    private String salparamname;
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
     * 薪酬计算源
     */
    @TableField(exist = false)
    @JSONField(name = "salsourcename")
    @JsonProperty("salsourcename")
    private String salsourcename;
    /**
     * 薪酬计算源
     */
    @TableField(value = "salsourceid")
    @JSONField(name = "salsourceid")
    @JsonProperty("salsourceid")
    private String salsourceid;

    /**
     * 薪酬计算指标
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSource salsource;



    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [对应计算源属性]
     */
    public void setParam(String param){
        this.param = param ;
        this.modify("param",param);
    }

    /**
     * 设置 [薪酬计算指标名称]
     */
    public void setSalparamname(String salparamname){
        this.salparamname = salparamname ;
        this.modify("salparamname",salparamname);
    }

    /**
     * 设置 [薪酬计算源]
     */
    public void setSalsourceid(String salsourceid){
        this.salsourceid = salsourceid ;
        this.modify("salsourceid",salsourceid);
    }


}


