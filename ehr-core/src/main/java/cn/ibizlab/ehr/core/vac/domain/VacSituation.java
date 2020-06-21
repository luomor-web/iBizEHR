package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[用户休假情况]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACSITUATION",resultMap = "VacSituationResultMap")
public class VacSituation extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 已用天数
     */
    @TableField(value = "yyts")
    @JSONField(name = "yyts")
    @JsonProperty("yyts")
    private Integer yyts;
    /**
     * 用户休假情况名称
     */
    @TableField(value = "vacsituationname")
    @JSONField(name = "vacsituationname")
    @JsonProperty("vacsituationname")
    private String vacsituationname;
    /**
     * 补偿天数
     */
    @TableField(value = "bcts")
    @JSONField(name = "bcts")
    @JsonProperty("bcts")
    private Integer bcts;
    /**
     * 用户休假情况标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacsituationid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacsituationid")
    @JsonProperty("vacsituationid")
    private String vacsituationid;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 本年天数
     */
    @TableField(value = "bnts")
    @JSONField(name = "bnts")
    @JsonProperty("bnts")
    private Integer bnts;
    /**
     * 上年转入天数
     */
    @TableField(value = "snzrts")
    @JSONField(name = "snzrts")
    @JsonProperty("snzrts")
    private Integer snzrts;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 累计剩余天数
     */
    @TableField(value = "ljsyts")
    @JSONField(name = "ljsyts")
    @JsonProperty("ljsyts")
    private Integer ljsyts;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 本年剩余天数
     */
    @TableField(value = "bnsyts")
    @JSONField(name = "bnsyts")
    @JsonProperty("bnsyts")
    private Integer bnsyts;
    /**
     * 总天数
     */
    @TableField(value = "zts")
    @JSONField(name = "zts")
    @JsonProperty("zts")
    private Integer zts;
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
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [已用天数]
     */
    public void setYyts(Integer yyts){
        this.yyts = yyts ;
        this.modify("yyts",yyts);
    }

    /**
     * 设置 [用户休假情况名称]
     */
    public void setVacsituationname(String vacsituationname){
        this.vacsituationname = vacsituationname ;
        this.modify("vacsituationname",vacsituationname);
    }

    /**
     * 设置 [补偿天数]
     */
    public void setBcts(Integer bcts){
        this.bcts = bcts ;
        this.modify("bcts",bcts);
    }

    /**
     * 设置 [本年天数]
     */
    public void setBnts(Integer bnts){
        this.bnts = bnts ;
        this.modify("bnts",bnts);
    }

    /**
     * 设置 [上年转入天数]
     */
    public void setSnzrts(Integer snzrts){
        this.snzrts = snzrts ;
        this.modify("snzrts",snzrts);
    }

    /**
     * 设置 [累计剩余天数]
     */
    public void setLjsyts(Integer ljsyts){
        this.ljsyts = ljsyts ;
        this.modify("ljsyts",ljsyts);
    }

    /**
     * 设置 [本年剩余天数]
     */
    public void setBnsyts(Integer bnsyts){
        this.bnsyts = bnsyts ;
        this.modify("bnsyts",bnsyts);
    }

    /**
     * 设置 [总天数]
     */
    public void setZts(Integer zts){
        this.zts = zts ;
        this.modify("zts",zts);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


