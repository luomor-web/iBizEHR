package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[老干部费用]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMLGBCOST",resultMap = "TrmLgbCostResultMap")
public class TrmLgbCost extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开始时间
     */
    @TableField(value = "kssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;
    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
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
     * 金额
     */
    @TableField(value = "je")
    @JSONField(name = "je")
    @JsonProperty("je")
    private Double je;
    /**
     * 活动说明
     */
    @TableField(value = "hdsm")
    @JSONField(name = "hdsm")
    @JsonProperty("hdsm")
    private String hdsm;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 组织iD
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 活动
     */
    @TableField(value = "trmlgbcostname")
    @JSONField(name = "trmlgbcostname")
    @JsonProperty("trmlgbcostname")
    private String trmlgbcostname;
    /**
     * 老干部费用标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmlgbcostid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmlgbcostid")
    @JsonProperty("trmlgbcostid")
    private String trmlgbcostid;
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
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 组织名称
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
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [开始时间]
     */
    public void setKssj(Timestamp kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }

    /**
     * 格式化日期 [开始时间]
     */
    public String formatKssj(){
        if (this.kssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kssj);
    }
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jssj);
    }
    /**
     * 设置 [金额]
     */
    public void setJe(Double je){
        this.je = je ;
        this.modify("je",je);
    }

    /**
     * 设置 [活动说明]
     */
    public void setHdsm(String hdsm){
        this.hdsm = hdsm ;
        this.modify("hdsm",hdsm);
    }

    /**
     * 设置 [活动]
     */
    public void setTrmlgbcostname(String trmlgbcostname){
        this.trmlgbcostname = trmlgbcostname ;
        this.modify("trmlgbcostname",trmlgbcostname);
    }

    /**
     * 设置 [附件]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


