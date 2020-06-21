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
 * 实体[培训需求明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMDEPARTNEEDS",resultMap = "TrmDepartNeedsResultMap")
public class TrmDepartNeeds extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 培训方式
     */
    @TableField(value = "pxdfs")
    @JSONField(name = "pxdfs")
    @JsonProperty("pxdfs")
    private String pxdfs;
    /**
     * 培训内容
     */
    @TableField(value = "pxnr")
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 预计开始时间
     */
    @TableField(value = "yjkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yjkssj" , format="yyyy-MM-dd")
    @JsonProperty("yjkssj")
    private Timestamp yjkssj;
    /**
     * 部门需求填报名称
     */
    @TableField(value = "trmdepartneedsname")
    @JSONField(name = "trmdepartneedsname")
    @JsonProperty("trmdepartneedsname")
    private String trmdepartneedsname;
    /**
     * 部门需求填报标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmdepartneedsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmdepartneedsid")
    @JsonProperty("trmdepartneedsid")
    private String trmdepartneedsid;
    /**
     * 培训时长单位
     */
    @TableField(value = "pxscdw")
    @JSONField(name = "pxscdw")
    @JsonProperty("pxscdw")
    private String pxscdw;
    /**
     * 预计结束时间
     */
    @TableField(value = "yjjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yjjssj" , format="yyyy-MM-dd")
    @JsonProperty("yjjssj")
    private Timestamp yjjssj;
    /**
     * 培训类别
     */
    @TableField(value = "pxlb")
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;
    /**
     * 培训目标
     */
    @TableField(value = "pxmb")
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;
    /**
     * 审批意见
     */
    @TableField(value = "spyj")
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;
    /**
     * 需求原因
     */
    @TableField(value = "xqyy")
    @JSONField(name = "xqyy")
    @JsonProperty("xqyy")
    private String xqyy;
    /**
     * 预计费用总额
     */
    @TableField(value = "yjfyze")
    @JSONField(name = "yjfyze")
    @JsonProperty("yjfyze")
    private Double yjfyze;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训地点
     */
    @TableField(value = "pxdd")
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
    /**
     * 紧迫程度
     */
    @TableField(value = "jpcd")
    @JSONField(name = "jpcd")
    @JsonProperty("jpcd")
    private String jpcd;
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
     * 培训时长
     */
    @TableField(value = "pxsc")
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;
    /**
     * 填报时间
     */
    @TableField(value = "tbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tbsj" , format="yyyy-MM-dd")
    @JsonProperty("tbsj")
    private Timestamp tbsj;
    /**
     * 预计参训人数
     */
    @TableField(value = "yjcxrs")
    @JSONField(name = "yjcxrs")
    @JsonProperty("yjcxrs")
    private Integer yjcxrs;
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
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 培训课程名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 培训机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse;



    /**
     * 设置 [培训方式]
     */
    public void setPxdfs(String pxdfs){
        this.pxdfs = pxdfs ;
        this.modify("pxdfs",pxdfs);
    }

    /**
     * 设置 [培训内容]
     */
    public void setPxnr(String pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [预计开始时间]
     */
    public void setYjkssj(Timestamp yjkssj){
        this.yjkssj = yjkssj ;
        this.modify("yjkssj",yjkssj);
    }

    /**
     * 格式化日期 [预计开始时间]
     */
    public String formatYjkssj(){
        if (this.yjkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(yjkssj);
    }
    /**
     * 设置 [部门需求填报名称]
     */
    public void setTrmdepartneedsname(String trmdepartneedsname){
        this.trmdepartneedsname = trmdepartneedsname ;
        this.modify("trmdepartneedsname",trmdepartneedsname);
    }

    /**
     * 设置 [培训时长单位]
     */
    public void setPxscdw(String pxscdw){
        this.pxscdw = pxscdw ;
        this.modify("pxscdw",pxscdw);
    }

    /**
     * 设置 [预计结束时间]
     */
    public void setYjjssj(Timestamp yjjssj){
        this.yjjssj = yjjssj ;
        this.modify("yjjssj",yjjssj);
    }

    /**
     * 格式化日期 [预计结束时间]
     */
    public String formatYjjssj(){
        if (this.yjjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(yjjssj);
    }
    /**
     * 设置 [培训类别]
     */
    public void setPxlb(String pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [培训目标]
     */
    public void setPxmb(String pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [审批意见]
     */
    public void setSpyj(String spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [需求原因]
     */
    public void setXqyy(String xqyy){
        this.xqyy = xqyy ;
        this.modify("xqyy",xqyy);
    }

    /**
     * 设置 [预计费用总额]
     */
    public void setYjfyze(Double yjfyze){
        this.yjfyze = yjfyze ;
        this.modify("yjfyze",yjfyze);
    }

    /**
     * 设置 [培训地点]
     */
    public void setPxdd(String pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [紧迫程度]
     */
    public void setJpcd(String jpcd){
        this.jpcd = jpcd ;
        this.modify("jpcd",jpcd);
    }

    /**
     * 设置 [培训时长]
     */
    public void setPxsc(Double pxsc){
        this.pxsc = pxsc ;
        this.modify("pxsc",pxsc);
    }

    /**
     * 设置 [填报时间]
     */
    public void setTbsj(Timestamp tbsj){
        this.tbsj = tbsj ;
        this.modify("tbsj",tbsj);
    }

    /**
     * 格式化日期 [填报时间]
     */
    public String formatTbsj(){
        if (this.tbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tbsj);
    }
    /**
     * 设置 [预计参训人数]
     */
    public void setYjcxrs(Integer yjcxrs){
        this.yjcxrs = yjcxrs ;
        this.modify("yjcxrs",yjcxrs);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


