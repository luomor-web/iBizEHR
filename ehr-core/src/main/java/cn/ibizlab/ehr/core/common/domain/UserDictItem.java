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
 * 实体[用户词条]
 */
@Data
@TableName(value = "T_SRFUSERDICTITEM",resultMap = "UserDictItemResultMap")
public class UserDictItem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 完整内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 用户词典词条标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userdictitemid",type=IdType.UUID)
    @JSONField(name = "userdictitemid")
    @JsonProperty("userdictitemid")
    private String userdictitemid;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 词条名称
     */
    @TableField(value = "userdictitemname")
    @JSONField(name = "userdictitemname")
    @JsonProperty("userdictitemname")
    private String userdictitemname;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 标记常用
     */
    @TableField(value = "markflag")
    @JSONField(name = "markflag")
    @JsonProperty("markflag")
    private Integer markflag;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 词条类别
     */
    @TableField(exist = false)
    @JSONField(name = "userdictcatname")
    @JsonProperty("userdictcatname")
    private String userdictcatname;
    /**
     * 用户词典
     */
    @TableField(exist = false)
    @JSONField(name = "userdictname")
    @JsonProperty("userdictname")
    private String userdictname;
    /**
     * 用户词典
     */
    @TableField(value = "userdictid")
    @JSONField(name = "userdictid")
    @JsonProperty("userdictid")
    private String userdictid;
    /**
     * 词条类别
     */
    @TableField(value = "userdictcatid")
    @JSONField(name = "userdictcatid")
    @JsonProperty("userdictcatid")
    private String userdictcatid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserDictCat userdictcat;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserDict userdict;



    /**
     * 设置 [完整内容]
     */
    public void setContent(String content){
        this.content = content ;
        this.modify("content",content);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [词条名称]
     */
    public void setUserdictitemname(String userdictitemname){
        this.userdictitemname = userdictitemname ;
        this.modify("userdictitemname",userdictitemname);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [标记常用]
     */
    public void setMarkflag(Integer markflag){
        this.markflag = markflag ;
        this.modify("markflag",markflag);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [用户词典]
     */
    public void setUserdictid(String userdictid){
        this.userdictid = userdictid ;
        this.modify("userdictid",userdictid);
    }
    /**
     * 设置 [词条类别]
     */
    public void setUserdictcatid(String userdictcatid){
        this.userdictcatid = userdictcatid ;
        this.modify("userdictcatid",userdictcatid);
    }
}





