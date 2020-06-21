package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[员工类型管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMSTAFFTYPE",resultMap = "PimStafftypeResultMap")
public class PimStafftype extends EntityMP implements Serializable {

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
     * 员工类型管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimstafftypeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimstafftypeid")
    @JsonProperty("pimstafftypeid")
    private String pimstafftypeid;
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
     * 入职审核规则
     */
    @TableField(value = "shgz")
    @JSONField(name = "shgz")
    @JsonProperty("shgz")
    private String shgz;
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
     * 员工类型代码
     */
    @TableField(value = "sbm")
    @JSONField(name = "sbm")
    @JsonProperty("sbm")
    private String sbm;
    /**
     * 员工类型管理名称
     */
    @TableField(value = "pimstafftypename")
    @JSONField(name = "pimstafftypename")
    @JsonProperty("pimstafftypename")
    private String pimstafftypename;
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
     * 设置 [入职审核规则]
     */
    public void setShgz(String shgz){
        this.shgz = shgz ;
        this.modify("shgz",shgz);
    }

    /**
     * 设置 [员工类型代码]
     */
    public void setSbm(String sbm){
        this.sbm = sbm ;
        this.modify("sbm",sbm);
    }

    /**
     * 设置 [员工类型管理名称]
     */
    public void setPimstafftypename(String pimstafftypename){
        this.pimstafftypename = pimstafftypename ;
        this.modify("pimstafftypename",pimstafftypename);
    }


}


