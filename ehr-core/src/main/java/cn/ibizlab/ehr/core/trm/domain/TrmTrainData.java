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
 * 实体[培训资料]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINDATA",resultMap = "TrmTrainDataResultMap")
public class TrmTrainData extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 已用数量
     */
    @TableField(value = "yysl")
    @JSONField(name = "yysl")
    @JsonProperty("yysl")
    private Integer yysl;
    /**
     * 培训资料标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtraindataid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtraindataid")
    @JsonProperty("trmtraindataid")
    private String trmtraindataid;
    /**
     * 资料编码
     */
    @TableField(value = "zlbm")
    @JSONField(name = "zlbm")
    @JsonProperty("zlbm")
    private String zlbm;
    /**
     * 是否共享
     */
    @TableField(value = "sfgx")
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;
    /**
     * 出版社
     */
    @TableField(value = "cbs")
    @JSONField(name = "cbs")
    @JsonProperty("cbs")
    private String cbs;
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
     * 现有数量
     */
    @TableField(value = "xysl")
    @JSONField(name = "xysl")
    @JsonProperty("xysl")
    private Integer xysl;
    /**
     * 创建公司
     */
    @TableField(value = "cjgs")
    @JSONField(name = "cjgs")
    @JsonProperty("cjgs")
    private String cjgs;
    /**
     * 培训资料名称
     */
    @TableField(value = "trmtraindataname")
    @JSONField(name = "trmtraindataname")
    @JsonProperty("trmtraindataname")
    private String trmtraindataname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 是否封存
     */
    @TableField(value = "sfgc")
    @JSONField(name = "sfgc")
    @JsonProperty("sfgc")
    private Integer sfgc;
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
     * 作者
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 资料类别
     */
    @TableField(value = "zllb")
    @JSONField(name = "zllb")
    @JsonProperty("zllb")
    private String zllb;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 归属机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 所属机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [已用数量]
     */
    public void setYysl(Integer yysl){
        this.yysl = yysl ;
        this.modify("yysl",yysl);
    }

    /**
     * 设置 [资料编码]
     */
    public void setZlbm(String zlbm){
        this.zlbm = zlbm ;
        this.modify("zlbm",zlbm);
    }

    /**
     * 设置 [是否共享]
     */
    public void setSfgx(Integer sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [出版社]
     */
    public void setCbs(String cbs){
        this.cbs = cbs ;
        this.modify("cbs",cbs);
    }

    /**
     * 设置 [现有数量]
     */
    public void setXysl(Integer xysl){
        this.xysl = xysl ;
        this.modify("xysl",xysl);
    }

    /**
     * 设置 [创建公司]
     */
    public void setCjgs(String cjgs){
        this.cjgs = cjgs ;
        this.modify("cjgs",cjgs);
    }

    /**
     * 设置 [培训资料名称]
     */
    public void setTrmtraindataname(String trmtraindataname){
        this.trmtraindataname = trmtraindataname ;
        this.modify("trmtraindataname",trmtraindataname);
    }

    /**
     * 设置 [是否封存]
     */
    public void setSfgc(Integer sfgc){
        this.sfgc = sfgc ;
        this.modify("sfgc",sfgc);
    }

    /**
     * 设置 [作者]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [资料类别]
     */
    public void setZllb(String zllb){
        this.zllb = zllb ;
        this.modify("zllb",zllb);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


