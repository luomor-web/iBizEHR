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
 * 实体[用户组]
 */
@Data
@TableName(value = "T_SRFUSERGROUP",resultMap = "UserGroupResultMap")
public class UserGroup extends EntityMP implements Serializable {

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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 自定义数据2
     */
    @TableField(exist = false)
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 所有者标识
     */
    @TableField(exist = false)
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;
    /**
     * 备注
     */
    @TableField(exist = false)
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 自定义数据
     */
    @TableField(exist = false)
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 子类型
     */
    @TableField(exist = false)
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;
    /**
     * 用户对象类型
     */
    @TableField(exist = false)
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 用户对象级别
     */
    @TableField(exist = false)
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;
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
     * 用户组名称
     */
    @TableField(value = "usergroupname")
    @JSONField(name = "usergroupname")
    @JsonProperty("usergroupname")
    private String usergroupname;
    /**
     * 所有者类型
     */
    @TableField(exist = false)
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;
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
     * 用户组标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "usergroupid",type=IdType.UUID)
    @JSONField(name = "usergroupid")
    @JsonProperty("usergroupid")
    private String usergroupid;



    /**
     * 设置 [用户组名称]
     */
    public void setUsergroupname(String usergroupname){
        this.usergroupname = usergroupname ;
        this.modify("usergroupname",usergroupname);
    }

}


