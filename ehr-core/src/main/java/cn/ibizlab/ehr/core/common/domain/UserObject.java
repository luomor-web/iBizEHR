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
 * 实体[用户对象]
 */
@Data
@TableName(value = "T_SRFUSEROBJECT",resultMap = "UserObjectResultMap")
public class UserObject extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户对象级别
     */
    @TableField(value = "userobjectlevel")
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;
    /**
     * 子类型
     */
    @TableField(value = "subtype")
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;
    /**
     * 自定义数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
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
     * 用户对象类型
     */
    @TableField(value = "userobjecttype")
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 用户对象标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userobjectid",type=IdType.UUID)
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;
    /**
     * 所有者标识
     */
    @TableField(value = "ownerid")
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;
    /**
     * 所有者类型
     */
    @TableField(value = "ownertype")
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;
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
     * 自定义数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 用户对象名称
     */
    @TableField(value = "userobjectname")
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;



    /**
     * 设置 [用户对象级别]
     */
    public void setUserobjectlevel(Integer userobjectlevel){
        this.userobjectlevel = userobjectlevel ;
        this.modify("userobjectlevel",userobjectlevel);
    }
    /**
     * 设置 [子类型]
     */
    public void setSubtype(String subtype){
        this.subtype = subtype ;
        this.modify("subtype",subtype);
    }
    /**
     * 设置 [自定义数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [用户对象类型]
     */
    public void setUserobjecttype(String userobjecttype){
        this.userobjecttype = userobjecttype ;
        this.modify("userobjecttype",userobjecttype);
    }
    /**
     * 设置 [所有者标识]
     */
    public void setOwnerid(String ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }
    /**
     * 设置 [所有者类型]
     */
    public void setOwnertype(String ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }
    /**
     * 设置 [自定义数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [用户对象名称]
     */
    public void setUserobjectname(String userobjectname){
        this.userobjectname = userobjectname ;
        this.modify("userobjectname",userobjectname);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

}


