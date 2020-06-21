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
 * 实体[档案目录缺失记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMARCHIVESRECORD",resultMap = "PimArchivesRecordResultMap")
public class PimArchivesRecord extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 档案目录缺失记录名称
     */
    @TableField(value = "pimarchivesrecordname")
    @JSONField(name = "pimarchivesrecordname")
    @JsonProperty("pimarchivesrecordname")
    private String pimarchivesrecordname;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
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
     * 档案目录缺失记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimarchivesrecordid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimarchivesrecordid")
    @JsonProperty("pimarchivesrecordid")
    private String pimarchivesrecordid;
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
     * 档案信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;
    /**
     * 目录序号
     */
    @TableField(exist = false)
    @JSONField(name = "serialnumber")
    @JsonProperty("serialnumber")
    private Integer serialnumber;
    /**
     * 档案目录名称
     */
    @TableField(exist = false)
    @JSONField(name = "archivalcataloguename")
    @JsonProperty("archivalcataloguename")
    private String archivalcataloguename;
    /**
     * 档案目录标识
     */
    @TableField(value = "archivalcatalogueid")
    @JSONField(name = "archivalcatalogueid")
    @JsonProperty("archivalcatalogueid")
    private String archivalcatalogueid;
    /**
     * 档案信息标识
     */
    @TableField(value = "pimarchivesid")
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimArchivalCatalogue archivalcatalogue;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimArchives pimarchives;



    /**
     * 设置 [档案目录缺失记录名称]
     */
    public void setPimarchivesrecordname(String pimarchivesrecordname){
        this.pimarchivesrecordname = pimarchivesrecordname ;
        this.modify("pimarchivesrecordname",pimarchivesrecordname);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [档案目录标识]
     */
    public void setArchivalcatalogueid(String archivalcatalogueid){
        this.archivalcatalogueid = archivalcatalogueid ;
        this.modify("archivalcatalogueid",archivalcatalogueid);
    }

    /**
     * 设置 [档案信息标识]
     */
    public void setPimarchivesid(String pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }


}


