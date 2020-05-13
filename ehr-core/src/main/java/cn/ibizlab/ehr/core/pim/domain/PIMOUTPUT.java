package cn.ibizlab.ehr.core.pim.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[产值表]
 */
@Data
@TableName(value = "T_PIMOUTPUT",resultMap = "PIMOUTPUTResultMap")
public class PIMOUTPUT extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 月度
     */
    @TableField(value = "yd")
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 标题
     */
    @TableField(value = "pimoutputname")
    @JSONField(name = "pimoutputname")
    @JsonProperty("pimoutputname")
    private String pimoutputname;
    /**
     * 产值标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimoutputid",type=IdType.UUID)
    @JSONField(name = "pimoutputid")
    @JsonProperty("pimoutputid")
    private String pimoutputid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 产值（亿）
     */
    @TableField(value = "output")
    @JSONField(name = "output")
    @JsonProperty("output")
    private Double output;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
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
     * 组织显示
     */
    @TableField(exist = false)
    @JSONField(name = "zzxs")
    @JsonProperty("zzxs")
    private String zzxs;
    /**
     * 组织编码
     */
    @TableField(exist = false)
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织ID
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg;



    /**
     * 设置 [月度]
     */
    public void setYd(String yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }
    /**
     * 设置 [标题]
     */
    public void setPimoutputname(String pimoutputname){
        this.pimoutputname = pimoutputname ;
        this.modify("pimoutputname",pimoutputname);
    }
    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }
    /**
     * 设置 [产值（亿）]
     */
    public void setOutput(Double output){
        this.output = output ;
        this.modify("output",output);
    }
    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }
}






