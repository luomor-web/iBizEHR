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
 * 实体[职称目录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMTITLECATALOGUE",resultMap = "PimTitleCatalogueResultMap")
public class PimTitleCatalogue extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 职称代码
     */
    @TableField(value = "dh")
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;
    /**
     * 职称类型
     */
    @TableField(value = "titletype")
    @JSONField(name = "titletype")
    @JsonProperty("titletype")
    private String titletype;
    /**
     * 职称类型
     */
    @TableField(value = "zclc")
    @JSONField(name = "zclc")
    @JsonProperty("zclc")
    private String zclc;
    /**
     * 职称目录名称
     */
    @TableField(value = "pimtitlecataloguename")
    @JSONField(name = "pimtitlecataloguename")
    @JsonProperty("pimtitlecataloguename")
    private String pimtitlecataloguename;
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
     * 职称等级
     */
    @TableField(value = "zcdj")
    @JSONField(name = "zcdj")
    @JsonProperty("zcdj")
    private String zcdj;
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
     * 排序号
     */
    @TableField(value = "pxh")
    @JSONField(name = "pxh")
    @JsonProperty("pxh")
    private Integer pxh;
    /**
     * 职称标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimtitlecatalogueid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimtitlecatalogueid")
    @JsonProperty("pimtitlecatalogueid")
    private String pimtitlecatalogueid;
    /**
     * 职称目录类型
     */
    @TableField(exist = false)
    @JSONField(name = "pimtitlecataloguename2")
    @JsonProperty("pimtitlecataloguename2")
    private String pimtitlecataloguename2;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 职称标识
     */
    @TableField(value = "pimtitlecatalogueid2")
    @JSONField(name = "pimtitlecatalogueid2")
    @JsonProperty("pimtitlecatalogueid2")
    private String pimtitlecatalogueid2;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 职称目录类型
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue pimtitlecatalogue2;



    /**
     * 设置 [职称代码]
     */
    public void setDh(String dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [职称类型]
     */
    public void setTitletype(String titletype){
        this.titletype = titletype ;
        this.modify("titletype",titletype);
    }

    /**
     * 设置 [职称类型]
     */
    public void setZclc(String zclc){
        this.zclc = zclc ;
        this.modify("zclc",zclc);
    }

    /**
     * 设置 [职称目录名称]
     */
    public void setPimtitlecataloguename(String pimtitlecataloguename){
        this.pimtitlecataloguename = pimtitlecataloguename ;
        this.modify("pimtitlecataloguename",pimtitlecataloguename);
    }

    /**
     * 设置 [职称等级]
     */
    public void setZcdj(String zcdj){
        this.zcdj = zcdj ;
        this.modify("zcdj",zcdj);
    }

    /**
     * 设置 [排序号]
     */
    public void setPxh(Integer pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [职称标识]
     */
    public void setPimtitlecatalogueid2(String pimtitlecatalogueid2){
        this.pimtitlecatalogueid2 = pimtitlecatalogueid2 ;
        this.modify("pimtitlecatalogueid2",pimtitlecatalogueid2);
    }


}


