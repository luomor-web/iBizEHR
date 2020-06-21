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
 * 实体[培训需求汇总明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINDEMANDSUM",resultMap = "TrmTrainDemandSumResultMap")
public class TrmTrainDemandSum extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训需求汇总明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtraindemandsumid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtraindemandsumid")
    @JsonProperty("trmtraindemandsumid")
    private String trmtraindemandsumid;
    /**
     * 需求人数
     */
    @TableField(value = "xqrs")
    @JSONField(name = "xqrs")
    @JsonProperty("xqrs")
    private Integer xqrs;
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
     * 汇总日期
     */
    @TableField(value = "hzrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "hzrq" , format="yyyy-MM-dd")
    @JsonProperty("hzrq")
    private Timestamp hzrq;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 培训需求汇总明细名称
     */
    @TableField(value = "trmtraindemandsumname")
    @JSONField(name = "trmtraindemandsumname")
    @JsonProperty("trmtraindemandsumname")
    private String trmtraindemandsumname;
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
     * 课程编码
     */
    @TableField(exist = false)
    @JSONField(name = "kcbm")
    @JsonProperty("kcbm")
    private String kcbm;
    /**
     * 培训需求汇总名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraindemandname")
    @JsonProperty("trmtraindemandname")
    private String trmtraindemandname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训课程名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训需求汇总标识
     */
    @TableField(value = "trmtraindemandid")
    @JSONField(name = "trmtraindemandid")
    @JsonProperty("trmtraindemandid")
    private String trmtraindemandid;

    /**
     * 汇总机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse;

    /**
     * 培训需求汇总
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainDemand trmtraindemand;



    /**
     * 设置 [需求人数]
     */
    public void setXqrs(Integer xqrs){
        this.xqrs = xqrs ;
        this.modify("xqrs",xqrs);
    }

    /**
     * 设置 [汇总日期]
     */
    public void setHzrq(Timestamp hzrq){
        this.hzrq = hzrq ;
        this.modify("hzrq",hzrq);
    }

    /**
     * 格式化日期 [汇总日期]
     */
    public String formatHzrq(){
        if (this.hzrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(hzrq);
    }
    /**
     * 设置 [培训需求汇总明细名称]
     */
    public void setTrmtraindemandsumname(String trmtraindemandsumname){
        this.trmtraindemandsumname = trmtraindemandsumname ;
        this.modify("trmtraindemandsumname",trmtraindemandsumname);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训需求汇总标识]
     */
    public void setTrmtraindemandid(String trmtraindemandid){
        this.trmtraindemandid = trmtraindemandid ;
        this.modify("trmtraindemandid",trmtraindemandid);
    }


}


