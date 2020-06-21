package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[代码项]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SRFCODEITEM",resultMap = "CodeItemResultMap")
public class CodeItem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序值
     */
    @DEField(preType = DEPredefinedFieldType.ORDERVALUE)
    @TableField(value = "ordervalue")
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 快捷输入
     */
    @TableField(value = "shortkey")
    @JSONField(name = "shortkey")
    @JsonProperty("shortkey")
    private String shortkey;
    /**
     * 代码项名称
     */
    @TableField(value = "codeitemname")
    @JSONField(name = "codeitemname")
    @JsonProperty("codeitemname")
    private String codeitemname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 代码项值
     */
    @TableField(value = "codeitemvalue")
    @JSONField(name = "codeitemvalue")
    @JsonProperty("codeitemvalue")
    private String codeitemvalue;
    /**
     * 代码项标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "codeitemid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "codeitemid")
    @JsonProperty("codeitemid")
    private String codeitemid;
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
     * 代码表
     */
    @TableField(exist = false)
    @JSONField(name = "codelistname")
    @JsonProperty("codelistname")
    private String codelistname;
    /**
     * 上级代码项
     */
    @TableField(exist = false)
    @JSONField(name = "pcodeitemname")
    @JsonProperty("pcodeitemname")
    private String pcodeitemname;
    /**
     * 上级代码项
     */
    @TableField(value = "pcodeitemid")
    @JSONField(name = "pcodeitemid")
    @JsonProperty("pcodeitemid")
    private String pcodeitemid;
    /**
     * 代码表
     */
    @TableField(value = "codelistid")
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.CodeItem pcodeitem;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.CodeList1 codelist;



    /**
     * 设置 [快捷输入]
     */
    public void setShortkey(String shortkey){
        this.shortkey = shortkey ;
        this.modify("shortkey",shortkey);
    }

    /**
     * 设置 [代码项名称]
     */
    public void setCodeitemname(String codeitemname){
        this.codeitemname = codeitemname ;
        this.modify("codeitemname",codeitemname);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [代码项值]
     */
    public void setCodeitemvalue(String codeitemvalue){
        this.codeitemvalue = codeitemvalue ;
        this.modify("codeitemvalue",codeitemvalue);
    }

    /**
     * 设置 [上级代码项]
     */
    public void setPcodeitemid(String pcodeitemid){
        this.pcodeitemid = pcodeitemid ;
        this.modify("pcodeitemid",pcodeitemid);
    }

    /**
     * 设置 [代码表]
     */
    public void setCodelistid(String codelistid){
        this.codelistid = codelistid ;
        this.modify("codelistid",codelistid);
    }


}


