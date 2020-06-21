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
 * 实体[项目工资标准(绩效比例)]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALSTDXMGZRATE",resultMap = "SalStdXmgzRateResultMap")
public class SalStdXmgzRate extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 绩效工资系数
     */
    @TableField(value = "jxgzbl")
    @JSONField(name = "jxgzbl")
    @JsonProperty("jxgzbl")
    private Double jxgzbl;
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
     * 项目工资标准(绩效比例)名称
     */
    @TableField(value = "salstdxmgzratename")
    @JSONField(name = "salstdxmgzratename")
    @JsonProperty("salstdxmgzratename")
    private String salstdxmgzratename;
    /**
     * 项目工资标准(绩效比例)标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salstdxmgzrateid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salstdxmgzrateid")
    @JsonProperty("salstdxmgzrateid")
    private String salstdxmgzrateid;
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
     * 绩效考核结论
     */
    @TableField(value = "khjl")
    @JSONField(name = "khjl")
    @JsonProperty("khjl")
    private String khjl;
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
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [绩效工资系数]
     */
    public void setJxgzbl(Double jxgzbl){
        this.jxgzbl = jxgzbl ;
        this.modify("jxgzbl",jxgzbl);
    }

    /**
     * 设置 [项目工资标准(绩效比例)名称]
     */
    public void setSalstdxmgzratename(String salstdxmgzratename){
        this.salstdxmgzratename = salstdxmgzratename ;
        this.modify("salstdxmgzratename",salstdxmgzratename);
    }

    /**
     * 设置 [绩效考核结论]
     */
    public void setKhjl(String khjl){
        this.khjl = khjl ;
        this.modify("khjl",khjl);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


