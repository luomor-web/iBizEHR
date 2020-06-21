package cn.ibizlab.ehr.core.sal.domain;

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
 * 实体[薪酬要素项维护]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALITEMSUB",resultMap = "SalItemSubResultMap")
public class SalItemSub extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 薪酬要素项维护标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salitemsubid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salitemsubid")
    @JsonProperty("salitemsubid")
    private String salitemsubid;
    /**
     * 薪酬要素项维护名称
     */
    @TableField(value = "salitemsubname")
    @JSONField(name = "salitemsubname")
    @JsonProperty("salitemsubname")
    private String salitemsubname;
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
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 要素项
     */
    @TableField(exist = false)
    @JSONField(name = "salitemname")
    @JsonProperty("salitemname")
    private String salitemname;
    /**
     * 财务科目
     */
    @TableField(exist = false)
    @JSONField(name = "salsubjectname")
    @JsonProperty("salsubjectname")
    private String salsubjectname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 财务科目标识
     */
    @TableField(value = "salsubjectid")
    @JSONField(name = "salsubjectid")
    @JsonProperty("salsubjectid")
    private String salsubjectid;
    /**
     * 薪酬要素项标识
     */
    @TableField(value = "salitemid")
    @JSONField(name = "salitemid")
    @JsonProperty("salitemid")
    private String salitemid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalItem salitem;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSubject salsubject;



    /**
     * 设置 [薪酬要素项维护名称]
     */
    public void setSalitemsubname(String salitemsubname){
        this.salitemsubname = salitemsubname ;
        this.modify("salitemsubname",salitemsubname);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [财务科目标识]
     */
    public void setSalsubjectid(String salsubjectid){
        this.salsubjectid = salsubjectid ;
        this.modify("salsubjectid",salsubjectid);
    }

    /**
     * 设置 [薪酬要素项标识]
     */
    public void setSalitemid(String salitemid){
        this.salitemid = salitemid ;
        this.modify("salitemid",salitemid);
    }


}


