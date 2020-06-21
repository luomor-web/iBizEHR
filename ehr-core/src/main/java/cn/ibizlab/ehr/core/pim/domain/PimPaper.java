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
 * 实体[论文信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPAPER",resultMap = "PimPaperResultMap")
public class PimPaper extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 个人在论文著作中的排名
     */
    @TableField(value = "grzlwzzzdpm")
    @JSONField(name = "grzlwzzzdpm")
    @JsonProperty("grzlwzzzdpm")
    private Integer grzlwzzzdpm;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 论文信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpaperid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpaperid")
    @JsonProperty("pimpaperid")
    private String pimpaperid;
    /**
     * 审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
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
     * 刊物名称(*)
     */
    @TableField(value = "kwmc")
    @JSONField(name = "kwmc")
    @JsonProperty("kwmc")
    private String kwmc;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 发表时间(*)
     */
    @TableField(value = "fbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "fbsj" , format="yyyy-MM-dd")
    @JsonProperty("fbsj")
    private Timestamp fbsj;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 论文名称(*)
     */
    @TableField(value = "pimpapername")
    @JSONField(name = "pimpapername")
    @JsonProperty("pimpapername")
    private String pimpapername;
    /**
     * 刊物期数
     */
    @TableField(value = "kwqs")
    @JSONField(name = "kwqs")
    @JsonProperty("kwqs")
    private Integer kwqs;
    /**
     * 出版社(*)
     */
    @TableField(value = "cbs")
    @JSONField(name = "cbs")
    @JsonProperty("cbs")
    private String cbs;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 出版社或刊物名称
     */
    @TableField(value = "cbshkwmc")
    @JSONField(name = "cbshkwmc")
    @JsonProperty("cbshkwmc")
    private String cbshkwmc;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
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
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 论文信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [个人在论文著作中的排名]
     */
    public void setGrzlwzzzdpm(Integer grzlwzzzdpm){
        this.grzlwzzzdpm = grzlwzzzdpm ;
        this.modify("grzlwzzzdpm",grzlwzzzdpm);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [刊物名称(*)]
     */
    public void setKwmc(String kwmc){
        this.kwmc = kwmc ;
        this.modify("kwmc",kwmc);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [发表时间(*)]
     */
    public void setFbsj(Timestamp fbsj){
        this.fbsj = fbsj ;
        this.modify("fbsj",fbsj);
    }

    /**
     * 格式化日期 [发表时间(*)]
     */
    public String formatFbsj(){
        if (this.fbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fbsj);
    }
    /**
     * 设置 [论文名称(*)]
     */
    public void setPimpapername(String pimpapername){
        this.pimpapername = pimpapername ;
        this.modify("pimpapername",pimpapername);
    }

    /**
     * 设置 [刊物期数]
     */
    public void setKwqs(Integer kwqs){
        this.kwqs = kwqs ;
        this.modify("kwqs",kwqs);
    }

    /**
     * 设置 [出版社(*)]
     */
    public void setCbs(String cbs){
        this.cbs = cbs ;
        this.modify("cbs",cbs);
    }

    /**
     * 设置 [出版社或刊物名称]
     */
    public void setCbshkwmc(String cbshkwmc){
        this.cbshkwmc = cbshkwmc ;
        this.modify("cbshkwmc",cbshkwmc);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


