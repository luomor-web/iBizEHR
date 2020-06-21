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
 * 实体[B/Y类员工转正申请明细（停用）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMCORRECTIONAPPLY",resultMap = "PimCorrectionApplyResultMap")
public class PimCorrectionApply extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * B/Y类员工转正申请明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimcorrectionapplyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimcorrectionapplyid")
    @JsonProperty("pimcorrectionapplyid")
    private String pimcorrectionapplyid;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
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
     * B/Y类员工转正申请明细名称
     */
    @TableField(value = "pimcorrectionapplyname")
    @JSONField(name = "pimcorrectionapplyname")
    @JsonProperty("pimcorrectionapplyname")
    private String pimcorrectionapplyname;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "pimbyygzzsqname")
    @JsonProperty("pimbyygzzsqname")
    private String pimbyygzzsqname;
    /**
     * 员工
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * B/Y类员工转正申请ID
     */
    @TableField(value = "pimbyygzzsqid")
    @JSONField(name = "pimbyygzzsqid")
    @JsonProperty("pimbyygzzsqid")
    private String pimbyygzzsqid;
    /**
     * 员工标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * B/Y类员工转正申请
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimByygzzsq pimbyygzzsq;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [B/Y类员工转正申请明细名称]
     */
    public void setPimcorrectionapplyname(String pimcorrectionapplyname){
        this.pimcorrectionapplyname = pimcorrectionapplyname ;
        this.modify("pimcorrectionapplyname",pimcorrectionapplyname);
    }

    /**
     * 设置 [B/Y类员工转正申请ID]
     */
    public void setPimbyygzzsqid(String pimbyygzzsqid){
        this.pimbyygzzsqid = pimbyygzzsqid ;
        this.modify("pimbyygzzsqid",pimbyygzzsqid);
    }

    /**
     * 设置 [员工标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


