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
 * 实体[部门需求汇总]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINDEMAND",resultMap = "TrmTrainDemandResultMap")
public class TrmTrainDemand extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 汇总年度
     */
    @TableField(value = "hznd")
    @JSONField(name = "hznd")
    @JsonProperty("hznd")
    private String hznd;
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
     * 汇总季度
     */
    @TableField(value = "hzjd")
    @JSONField(name = "hzjd")
    @JsonProperty("hzjd")
    private String hzjd;
    /**
     * 汇总人数
     */
    @TableField(value = "hzrs")
    @JSONField(name = "hzrs")
    @JsonProperty("hzrs")
    private Integer hzrs;
    /**
     * 培训需求汇总标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtraindemandid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtraindemandid")
    @JsonProperty("trmtraindemandid")
    private String trmtraindemandid;
    /**
     * 需求汇总
     */
    @TableField(value = "trmtraindemandname")
    @JSONField(name = "trmtraindemandname")
    @JsonProperty("trmtraindemandname")
    private String trmtraindemandname;
    /**
     * 汇总单位
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
     * 汇总单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [汇总年度]
     */
    public void setHznd(String hznd){
        this.hznd = hznd ;
        this.modify("hznd",hznd);
    }

    /**
     * 设置 [汇总季度]
     */
    public void setHzjd(String hzjd){
        this.hzjd = hzjd ;
        this.modify("hzjd",hzjd);
    }

    /**
     * 设置 [汇总人数]
     */
    public void setHzrs(Integer hzrs){
        this.hzrs = hzrs ;
        this.modify("hzrs",hzrs);
    }

    /**
     * 设置 [需求汇总]
     */
    public void setTrmtraindemandname(String trmtraindemandname){
        this.trmtraindemandname = trmtraindemandname ;
        this.modify("trmtraindemandname",trmtraindemandname);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


