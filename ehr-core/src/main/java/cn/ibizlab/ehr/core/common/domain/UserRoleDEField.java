package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[用户角色实体属性访问]
 */
@Data
@TableName(value = "T_SRFUSERROLEDEFIELD",resultMap = "UserRoleDEFieldResultMap")
public class UserRoleDEField extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体属性访问能力
     */
    @TableField(value = "userroledefieldname")
    @JSONField(name = "userroledefieldname")
    @JsonProperty("userroledefieldname")
    private String userroledefieldname;
    /**
     * 访问行为
     */
    @TableField(value = "defaction")
    @JSONField(name = "defaction")
    @JsonProperty("defaction")
    private String defaction;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 实体属性访问能力标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userroledefieldid",type=IdType.UUID)
    @JSONField(name = "userroledefieldid")
    @JsonProperty("userroledefieldid")
    private String userroledefieldid;
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
     * 框架发布
     */
    @TableField(value = "srfsyspub")
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
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
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 应用发布
     */
    @TableField(value = "srfuserpub")
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;
    /**
     * 相关属性
     */
    @TableField(value = "relateddefield")
    @JSONField(name = "relateddefield")
    @JsonProperty("relateddefield")
    private String relateddefield;
    /**
     * 数据实体
     */
    @TableField(value = "dename")
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 数据实体
     */
    @TableField(value = "deid")
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.DataEntity de;



    /**
     * 设置 [实体属性访问能力]
     */
    public void setUserroledefieldname(String userroledefieldname){
        this.userroledefieldname = userroledefieldname ;
        this.modify("userroledefieldname",userroledefieldname);
    }
    /**
     * 设置 [访问行为]
     */
    public void setDefaction(String defaction){
        this.defaction = defaction ;
        this.modify("defaction",defaction);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [框架发布]
     */
    public void setSrfsyspub(Integer srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [应用发布]
     */
    public void setSrfuserpub(Integer srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }
    /**
     * 设置 [相关属性]
     */
    public void setRelateddefield(String relateddefield){
        this.relateddefield = relateddefield ;
        this.modify("relateddefield",relateddefield);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDename(String dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDeid(String deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }

}


