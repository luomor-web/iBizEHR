package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[干部退出（优秀年轻干部梯队）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_WZD0002",resultMap = "PcmWzd0002ResultMap")
public class PcmWzd0002 extends EntityMP implements Serializable {

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
     * 干部退出（优秀年轻干部梯队）标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wzd0002id",type=IdType.ASSIGN_UUID)
    @JSONField(name = "wzd0002id")
    @JsonProperty("wzd0002id")
    private String wzd0002id;
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
     * 退出原因
     */
    @TableField(value = "tcyy")
    @JSONField(name = "tcyy")
    @JsonProperty("tcyy")
    private String tcyy;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 具体原因
     */
    @TableField(value = "jtyy")
    @JSONField(name = "jtyy")
    @JsonProperty("jtyy")
    private String jtyy;
    /**
     * 状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;
    /**
     * 人员列表
     */
    @TableField(value = "profilelist")
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;
    /**
     * 人数
     */
    @TableField(value = "peoplenum")
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;
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
     * 干部退出（优秀年轻干部梯队）名称
     */
    @TableField(value = "wzd0002name")
    @JSONField(name = "wzd0002name")
    @JsonProperty("wzd0002name")
    private String wzd0002name;



    /**
     * 设置 [退出原因]
     */
    public void setTcyy(String tcyy){
        this.tcyy = tcyy ;
        this.modify("tcyy",tcyy);
    }

    /**
     * 设置 [具体原因]
     */
    public void setJtyy(String jtyy){
        this.jtyy = jtyy ;
        this.modify("jtyy",jtyy);
    }

    /**
     * 设置 [状态]
     */
    public void setStatus(String status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [人员列表]
     */
    public void setProfilelist(String profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [人数]
     */
    public void setPeoplenum(Integer peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [干部退出（优秀年轻干部梯队）名称]
     */
    public void setWzd0002name(String wzd0002name){
        this.wzd0002name = wzd0002name ;
        this.modify("wzd0002name",wzd0002name);
    }


}


