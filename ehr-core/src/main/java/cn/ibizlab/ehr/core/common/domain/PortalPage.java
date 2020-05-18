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
 * 实体[门户页面]
 */
@Data
@TableName(value = "T_SRFPORTALPAGE",resultMap = "PortalPageResultMap")
public class PortalPage extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 门户页面标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "portalpageid",type=IdType.UUID)
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;
    /**
     * 支持上下文参数
     */
    @TableField(value = "enablectx")
    @JSONField(name = "enablectx")
    @JsonProperty("enablectx")
    private Integer enablectx;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 门户页面逻辑名称
     */
    @TableField(value = "portalpagememo")
    @JSONField(name = "portalpagememo")
    @JsonProperty("portalpagememo")
    private String portalpagememo;
    /**
     * 门户页面名称
     */
    @TableField(value = "portalpagename")
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;



    /**
     * 设置 [支持上下文参数]
     */
    public void setEnablectx(Integer enablectx){
        this.enablectx = enablectx ;
        this.modify("enablectx",enablectx);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [门户页面逻辑名称]
     */
    public void setPortalpagememo(String portalpagememo){
        this.portalpagememo = portalpagememo ;
        this.modify("portalpagememo",portalpagememo);
    }
    /**
     * 设置 [门户页面名称]
     */
    public void setPortalpagename(String portalpagename){
        this.portalpagename = portalpagename ;
        this.modify("portalpagename",portalpagename);
    }

}


