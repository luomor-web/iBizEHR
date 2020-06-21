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
 * 实体[档案借阅及归还记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMARCHIVESLOANANDRETURN",resultMap = "PimArchiveSloanandreturnResultMap")
public class PimArchiveSloanandreturn extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 借阅人
     */
    @TableField(value = "jyr")
    @JSONField(name = "jyr")
    @JsonProperty("jyr")
    private String jyr;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 审批时间
     */
    @TableField(value = "spdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "spdate" , format="yyyy-MM-dd")
    @JsonProperty("spdate")
    private Timestamp spdate;
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
     * 档案借阅及归还记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimarchivesloanandreturnid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimarchivesloanandreturnid")
    @JsonProperty("pimarchivesloanandreturnid")
    private String pimarchivesloanandreturnid;
    /**
     * 借阅原因
     */
    @TableField(value = "jyyy")
    @JSONField(name = "jyyy")
    @JsonProperty("jyyy")
    private String jyyy;
    /**
     * 归还时间
     */
    @TableField(value = "ghrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ghrq" , format="yyyy-MM-dd")
    @JsonProperty("ghrq")
    private Timestamp ghrq;
    /**
     * 状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 借阅时间
     */
    @TableField(value = "jyqssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jyqssj" , format="yyyy-MM-dd")
    @JsonProperty("jyqssj")
    private Timestamp jyqssj;
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
     * 档案借阅及归还记录名称
     */
    @TableField(value = "pimarchivesloanandreturnname")
    @JSONField(name = "pimarchivesloanandreturnname")
    @JsonProperty("pimarchivesloanandreturnname")
    private String pimarchivesloanandreturnname;
    /**
     * 审批同意人
     */
    @TableField(value = "spperson")
    @JSONField(name = "spperson")
    @JsonProperty("spperson")
    private String spperson;
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
     * 档案信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;
    /**
     * 借阅人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;
    /**
     * 审批人
     */
    @TableField(value = "pimpersonname3")
    @JSONField(name = "pimpersonname3")
    @JsonProperty("pimpersonname3")
    private String pimpersonname3;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid3")
    @JSONField(name = "pimpersonid3")
    @JsonProperty("pimpersonid3")
    private String pimpersonid3;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 档案信息标识
     */
    @TableField(value = "pimarchivesid")
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid2")
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;

    /**
     * 档案信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimArchives pimarchives;

    /**
     * 档案借阅及归还记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 借阅人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2;

    /**
     * 审批同意人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson3;



    /**
     * 设置 [借阅人]
     */
    public void setJyr(String jyr){
        this.jyr = jyr ;
        this.modify("jyr",jyr);
    }

    /**
     * 设置 [审批时间]
     */
    public void setSpdate(Timestamp spdate){
        this.spdate = spdate ;
        this.modify("spdate",spdate);
    }

    /**
     * 格式化日期 [审批时间]
     */
    public String formatSpdate(){
        if (this.spdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(spdate);
    }
    /**
     * 设置 [借阅原因]
     */
    public void setJyyy(String jyyy){
        this.jyyy = jyyy ;
        this.modify("jyyy",jyyy);
    }

    /**
     * 设置 [归还时间]
     */
    public void setGhrq(Timestamp ghrq){
        this.ghrq = ghrq ;
        this.modify("ghrq",ghrq);
    }

    /**
     * 格式化日期 [归还时间]
     */
    public String formatGhrq(){
        if (this.ghrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ghrq);
    }
    /**
     * 设置 [状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [借阅时间]
     */
    public void setJyqssj(Timestamp jyqssj){
        this.jyqssj = jyqssj ;
        this.modify("jyqssj",jyqssj);
    }

    /**
     * 格式化日期 [借阅时间]
     */
    public String formatJyqssj(){
        if (this.jyqssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jyqssj);
    }
    /**
     * 设置 [档案借阅及归还记录名称]
     */
    public void setPimarchivesloanandreturnname(String pimarchivesloanandreturnname){
        this.pimarchivesloanandreturnname = pimarchivesloanandreturnname ;
        this.modify("pimarchivesloanandreturnname",pimarchivesloanandreturnname);
    }

    /**
     * 设置 [审批同意人]
     */
    public void setSpperson(String spperson){
        this.spperson = spperson ;
        this.modify("spperson",spperson);
    }

    /**
     * 设置 [审批人]
     */
    public void setPimpersonname3(String pimpersonname3){
        this.pimpersonname3 = pimpersonname3 ;
        this.modify("pimpersonname3",pimpersonname3);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid3(String pimpersonid3){
        this.pimpersonid3 = pimpersonid3 ;
        this.modify("pimpersonid3",pimpersonid3);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [档案信息标识]
     */
    public void setPimarchivesid(String pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid2(String pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }


}


