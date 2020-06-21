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
 * 实体[签约主体单位]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_CONTRACTSIGNORG",resultMap = "PimContractSignOrgResultMap")
public class PimContractSignOrg extends EntityMP implements Serializable {

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
     * 签约主体单位名称
     */
    @TableField(value = "contractsignorgname")
    @JSONField(name = "contractsignorgname")
    @JsonProperty("contractsignorgname")
    private String contractsignorgname;
    /**
     * 签约主体单位标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "contractsignorgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "contractsignorgid")
    @JsonProperty("contractsignorgid")
    private String contractsignorgid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 默认签约主体
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isdefaultsignorg")
    @JSONField(name = "isdefaultsignorg")
    @JsonProperty("isdefaultsignorg")
    private Integer isdefaultsignorg;
    /**
     * 法人主体名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;
    /**
     * 管理单位名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 法人主体标识
     */
    @TableField(value = "ormsignorgid")
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;
    /**
     * 管理单位标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 单位主体
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 法人主体
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg;



    /**
     * 设置 [签约主体单位名称]
     */
    public void setContractsignorgname(String contractsignorgname){
        this.contractsignorgname = contractsignorgname ;
        this.modify("contractsignorgname",contractsignorgname);
    }

    /**
     * 设置 [默认签约主体]
     */
    public void setIsdefaultsignorg(Integer isdefaultsignorg){
        this.isdefaultsignorg = isdefaultsignorg ;
        this.modify("isdefaultsignorg",isdefaultsignorg);
    }

    /**
     * 设置 [法人主体标识]
     */
    public void setOrmsignorgid(String ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }

    /**
     * 设置 [管理单位标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


