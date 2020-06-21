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
 * 实体[合同类型]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMTYPECONTRACT",resultMap = "PimTypeContractResultMap")
public class PimTypeContract extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否允许删除
     */
    @TableField(value = "isorno")
    @JSONField(name = "isorno")
    @JsonProperty("isorno")
    private Integer isorno;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 排序号
     */
    @TableField(value = "sortno")
    @JSONField(name = "sortno")
    @JsonProperty("sortno")
    private Integer sortno;
    /**
     * 合同类型标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimtypecontractid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimtypecontractid")
    @JsonProperty("pimtypecontractid")
    private String pimtypecontractid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 合同年限
     */
    @TableField(value = "contractlife")
    @JSONField(name = "contractlife")
    @JsonProperty("contractlife")
    private Integer contractlife;
    /**
     * 合同类型代码
     */
    @TableField(value = "typecode")
    @JSONField(name = "typecode")
    @JsonProperty("typecode")
    private String typecode;
    /**
     * 合同类型名称
     */
    @TableField(value = "pimtypecontractname")
    @JSONField(name = "pimtypecontractname")
    @JsonProperty("pimtypecontractname")
    private String pimtypecontractname;
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
     * 设置 [是否允许删除]
     */
    public void setIsorno(Integer isorno){
        this.isorno = isorno ;
        this.modify("isorno",isorno);
    }

    /**
     * 设置 [排序号]
     */
    public void setSortno(Integer sortno){
        this.sortno = sortno ;
        this.modify("sortno",sortno);
    }

    /**
     * 设置 [合同年限]
     */
    public void setContractlife(Integer contractlife){
        this.contractlife = contractlife ;
        this.modify("contractlife",contractlife);
    }

    /**
     * 设置 [合同类型代码]
     */
    public void setTypecode(String typecode){
        this.typecode = typecode ;
        this.modify("typecode",typecode);
    }

    /**
     * 设置 [合同类型名称]
     */
    public void setPimtypecontractname(String pimtypecontractname){
        this.pimtypecontractname = pimtypecontractname ;
        this.modify("pimtypecontractname",pimtypecontractname);
    }


}


