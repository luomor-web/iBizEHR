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
 * 实体[档案室管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ARCHIVESCENTER",resultMap = "PimArchivesCenterResultMap")
public class PimArchivesCenter extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 柜号
     */
    @TableField(value = "cabinetno")
    @JSONField(name = "cabinetno")
    @JsonProperty("cabinetno")
    private String cabinetno;
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
     * 编号
     */
    @TableField(value = "bnumber")
    @JSONField(name = "bnumber")
    @JsonProperty("bnumber")
    private String bnumber;
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
     * 档案存放位置
     */
    @TableField(exist = false)
    @JSONField(name = "position")
    @JsonProperty("position")
    private String position;
    /**
     * 档案室管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "archivescenterid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "archivescenterid")
    @JsonProperty("archivescenterid")
    private String archivescenterid;
    /**
     * 排序号
     */
    @TableField(value = "serialno")
    @JSONField(name = "serialno")
    @JsonProperty("serialno")
    private Integer serialno;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 档案室名称
     */
    @TableField(value = "archivescentername")
    @JSONField(name = "archivescentername")
    @JsonProperty("archivescentername")
    private String archivescentername;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 层号
     */
    @TableField(value = "layerno")
    @JSONField(name = "layerno")
    @JsonProperty("layerno")
    private String layerno;
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
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @DEField(defaultValue = "SRFORGID" , defaultValueType = DEFieldDefaultValueType.SESSION)
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [柜号]
     */
    public void setCabinetno(String cabinetno){
        this.cabinetno = cabinetno ;
        this.modify("cabinetno",cabinetno);
    }

    /**
     * 设置 [编号]
     */
    public void setBnumber(String bnumber){
        this.bnumber = bnumber ;
        this.modify("bnumber",bnumber);
    }

    /**
     * 设置 [排序号]
     */
    public void setSerialno(Integer serialno){
        this.serialno = serialno ;
        this.modify("serialno",serialno);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [档案室名称]
     */
    public void setArchivescentername(String archivescentername){
        this.archivescentername = archivescentername ;
        this.modify("archivescentername",archivescentername);
    }

    /**
     * 设置 [层号]
     */
    public void setLayerno(String layerno){
        this.layerno = layerno ;
        this.modify("layerno",layerno);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


