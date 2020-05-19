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
 * 实体[用户表格自定义]
 */
@Data
@TableName(value = "T_SRFUSERDGTHEME",resultMap = "UserDGThemeResultMap")
public class UserDGTheme extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表格编号
     */
    @TableField(value = "datagridid")
    @JSONField(name = "datagridid")
    @JsonProperty("datagridid")
    private String datagridid;
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
     * 表格列定义标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userdgthemeid",type=IdType.UUID)
    @JSONField(name = "userdgthemeid")
    @JsonProperty("userdgthemeid")
    private String userdgthemeid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * RESERVER3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * RESERVER
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 表格主题模型
     */
    @TableField(value = "dgthememodel")
    @JSONField(name = "dgthememodel")
    @JsonProperty("dgthememodel")
    private String dgthememodel;
    /**
     * RESERVER2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 项目编号
     */
    @TableField(value = "projectid")
    @JSONField(name = "projectid")
    @JsonProperty("projectid")
    private String projectid;
    /**
     * 人员编号
     */
    @TableField(value = "personid")
    @JSONField(name = "personid")
    @JsonProperty("personid")
    private String personid;
    /**
     * 表格列定义名称
     */
    @TableField(value = "userdgthemename")
    @JSONField(name = "userdgthemename")
    @JsonProperty("userdgthemename")
    private String userdgthemename;
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
     * 设置 [表格编号]
     */
    public void setDatagridid(String datagridid){
        this.datagridid = datagridid ;
        this.modify("datagridid",datagridid);
    }
    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [表格主题模型]
     */
    public void setDgthememodel(String dgthememodel){
        this.dgthememodel = dgthememodel ;
        this.modify("dgthememodel",dgthememodel);
    }
    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [项目编号]
     */
    public void setProjectid(String projectid){
        this.projectid = projectid ;
        this.modify("projectid",projectid);
    }
    /**
     * 设置 [人员编号]
     */
    public void setPersonid(String personid){
        this.personid = personid ;
        this.modify("personid",personid);
    }
    /**
     * 设置 [表格列定义名称]
     */
    public void setUserdgthemename(String userdgthemename){
        this.userdgthemename = userdgthemename ;
        this.modify("userdgthemename",userdgthemename);
    }

}


