package cn.ibizlab.ehr.core.sal.domain;

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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[技术津贴标准]
 */
@Data
@TableName(value = "T_SALSTDZC",resultMap = "SALSTDZCResultMap")
public class SALSTDZC extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 补贴标准
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;
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
     * 技术津贴标准名称
     */
    @TableField(value = "salstdzcname")
    @JSONField(name = "salstdzcname")
    @JsonProperty("salstdzcname")
    private String salstdzcname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职称等级
     */
    @TableField(value = "zcdj")
    @JSONField(name = "zcdj")
    @JsonProperty("zcdj")
    private String zcdj;
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
     * 技术津贴标准标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salstdzcid",type=IdType.UUID)
    @JSONField(name = "salstdzcid")
    @JsonProperty("salstdzcid")
    private String salstdzcid;
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
    private cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg;



    /**
     * 设置 [补贴标准]
     */
    public void setBz(Double bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }
    /**
     * 设置 [技术津贴标准名称]
     */
    public void setSalstdzcname(String salstdzcname){
        this.salstdzcname = salstdzcname ;
        this.modify("salstdzcname",salstdzcname);
    }
    /**
     * 设置 [职称等级]
     */
    public void setZcdj(String zcdj){
        this.zcdj = zcdj ;
        this.modify("zcdj",zcdj);
    }
    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

}


