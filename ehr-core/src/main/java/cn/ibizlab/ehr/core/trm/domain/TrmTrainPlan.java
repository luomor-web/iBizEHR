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
 * 实体[培训计划]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINPLAN",resultMap = "TrmTrainPlanResultMap")
public class TrmTrainPlan extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流程类型
     */
    @TableField(value = "lclx")
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;
    /**
     * 预计培训费用
     */
    @TableField(value = "sdfy")
    @JSONField(name = "sdfy")
    @JsonProperty("sdfy")
    private Double sdfy;
    /**
     * 预算总额
     */
    @TableField(value = "ysze")
    @JSONField(name = "ysze")
    @JsonProperty("ysze")
    private Double ysze;
    /**
     * 发布状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "shfs")
    @JSONField(name = "shfs")
    @JsonProperty("shfs")
    private String shfs;
    /**
     * 计划开始时间
     */
    @TableField(value = "jhkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;
    /**
     * 排序
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;
    /**
     * 计划月度
     */
    @TableField(value = "jhyd")
    @JSONField(name = "jhyd")
    @JsonProperty("jhyd")
    private String jhyd;
    /**
     * 编制时间
     */
    @TableField(value = "bzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bzsj" , format="yyyy-MM-dd")
    @JsonProperty("bzsj")
    private Timestamp bzsj;
    /**
     * 拟培训期数
     */
    @TableField(value = "npxqs")
    @JSONField(name = "npxqs")
    @JsonProperty("npxqs")
    private String npxqs;
    /**
     * 年度
     */
    @TableField(value = "jhnd")
    @JSONField(name = "jhnd")
    @JsonProperty("jhnd")
    private String jhnd;
    /**
     * 计划结束时间
     */
    @TableField(value = "jhjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;
    /**
     * 计划级别
     */
    @TableField(value = "jhjb")
    @JSONField(name = "jhjb")
    @JsonProperty("jhjb")
    private String jhjb;
    /**
     * 报名截止时间
     */
    @TableField(value = "bmjzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzsj" , format="yyyy-MM-dd")
    @JsonProperty("bmjzsj")
    private Timestamp bmjzsj;
    /**
     * 计划编码
     */
    @TableField(value = "jhbm")
    @JSONField(name = "jhbm")
    @JsonProperty("jhbm")
    private String jhbm;
    /**
     * 培训计划标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainplanid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainplanid")
    @JsonProperty("trmtrainplanid")
    private String trmtrainplanid;
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
     * 类型
     */
    @TableField(value = "jhlx")
    @JSONField(name = "jhlx")
    @JsonProperty("jhlx")
    private String jhlx;
    /**
     * 培训计划名称
     */
    @TableField(value = "trmtrainplanname")
    @JSONField(name = "trmtrainplanname")
    @JsonProperty("trmtrainplanname")
    private String trmtrainplanname;
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
     * 拟培训课时
     */
    @TableField(value = "npxks")
    @JSONField(name = "npxks")
    @JsonProperty("npxks")
    private Double npxks;
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
     * 计划季度
     */
    @TableField(value = "jhjd")
    @JSONField(name = "jhjd")
    @JsonProperty("jhjd")
    private String jhjd;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 培训对象
     */
    @TableField(exist = false)
    @JSONField(name = "pxdx")
    @JsonProperty("pxdx")
    private String pxdx;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 培训计划
     */
    @TableField(exist = false)
    @JSONField(name = "trmplanformuname")
    @JsonProperty("trmplanformuname")
    private String trmplanformuname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训班名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;
    /**
     * 拟培训人数
     */
    @TableField(exist = false)
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;
    /**
     * 拟培训内容
     */
    @TableField(exist = false)
    @JSONField(name = "pxzynr")
    @JsonProperty("pxzynr")
    private String pxzynr;
    /**
     * 培训开始时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;
    /**
     * 培训地点
     */
    @TableField(exist = false)
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
    /**
     * 培训结束时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 培训需求标识
     */
    @TableField(value = "trmdemdeftionid")
    @JSONField(name = "trmdemdeftionid")
    @JsonProperty("trmdemdeftionid")
    private String trmdemdeftionid;
    /**
     * 培训计划制定标识
     */
    @TableField(value = "trmplanformuid")
    @JSONField(name = "trmplanformuid")
    @JsonProperty("trmplanformuid")
    private String trmplanformuid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 拟培训地点
     */
    @TableField(value = "pxadress")
    @JSONField(name = "pxadress")
    @JsonProperty("pxadress")
    private String pxadress;
    /**
     * 拟培训内容
     */
    @TableField(value = "pxcontent")
    @JSONField(name = "pxcontent")
    @JsonProperty("pxcontent")
    private String pxcontent;
    /**
     * 拟培训人数
     */
    @TableField(value = "pxnum")
    @JSONField(name = "pxnum")
    @JsonProperty("pxnum")
    private Integer pxnum;
    /**
     * 审批状态
     */
    @DEField(defaultValue = "2")
    @TableField(value = "approvalstatus")
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;

    /**
     * 所属单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 编制人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 培训需求
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion trmdemdeftion;

    /**
     * 培训计划
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmPlanFormu trmplanformu;



    /**
     * 设置 [流程类型]
     */
    public void setLclx(String lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [预计培训费用]
     */
    public void setSdfy(Double sdfy){
        this.sdfy = sdfy ;
        this.modify("sdfy",sdfy);
    }

    /**
     * 设置 [预算总额]
     */
    public void setYsze(Double ysze){
        this.ysze = ysze ;
        this.modify("ysze",ysze);
    }

    /**
     * 设置 [发布状态]
     */
    public void setShfs(String shfs){
        this.shfs = shfs ;
        this.modify("shfs",shfs);
    }

    /**
     * 设置 [计划开始时间]
     */
    public void setJhkssj(Timestamp jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }

    /**
     * 格式化日期 [计划开始时间]
     */
    public String formatJhkssj(){
        if (this.jhkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jhkssj);
    }
    /**
     * 设置 [排序]
     */
    public void setXh(String xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [计划月度]
     */
    public void setJhyd(String jhyd){
        this.jhyd = jhyd ;
        this.modify("jhyd",jhyd);
    }

    /**
     * 设置 [编制时间]
     */
    public void setBzsj(Timestamp bzsj){
        this.bzsj = bzsj ;
        this.modify("bzsj",bzsj);
    }

    /**
     * 格式化日期 [编制时间]
     */
    public String formatBzsj(){
        if (this.bzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bzsj);
    }
    /**
     * 设置 [拟培训期数]
     */
    public void setNpxqs(String npxqs){
        this.npxqs = npxqs ;
        this.modify("npxqs",npxqs);
    }

    /**
     * 设置 [年度]
     */
    public void setJhnd(String jhnd){
        this.jhnd = jhnd ;
        this.modify("jhnd",jhnd);
    }

    /**
     * 设置 [计划结束时间]
     */
    public void setJhjssj(Timestamp jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }

    /**
     * 格式化日期 [计划结束时间]
     */
    public String formatJhjssj(){
        if (this.jhjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jhjssj);
    }
    /**
     * 设置 [计划级别]
     */
    public void setJhjb(String jhjb){
        this.jhjb = jhjb ;
        this.modify("jhjb",jhjb);
    }

    /**
     * 设置 [报名截止时间]
     */
    public void setBmjzsj(Timestamp bmjzsj){
        this.bmjzsj = bmjzsj ;
        this.modify("bmjzsj",bmjzsj);
    }

    /**
     * 格式化日期 [报名截止时间]
     */
    public String formatBmjzsj(){
        if (this.bmjzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bmjzsj);
    }
    /**
     * 设置 [计划编码]
     */
    public void setJhbm(String jhbm){
        this.jhbm = jhbm ;
        this.modify("jhbm",jhbm);
    }

    /**
     * 设置 [类型]
     */
    public void setJhlx(String jhlx){
        this.jhlx = jhlx ;
        this.modify("jhlx",jhlx);
    }

    /**
     * 设置 [培训计划名称]
     */
    public void setTrmtrainplanname(String trmtrainplanname){
        this.trmtrainplanname = trmtrainplanname ;
        this.modify("trmtrainplanname",trmtrainplanname);
    }

    /**
     * 设置 [拟培训课时]
     */
    public void setNpxks(Double npxks){
        this.npxks = npxks ;
        this.modify("npxks",npxks);
    }

    /**
     * 设置 [计划季度]
     */
    public void setJhjd(String jhjd){
        this.jhjd = jhjd ;
        this.modify("jhjd",jhjd);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [培训需求标识]
     */
    public void setTrmdemdeftionid(String trmdemdeftionid){
        this.trmdemdeftionid = trmdemdeftionid ;
        this.modify("trmdemdeftionid",trmdemdeftionid);
    }

    /**
     * 设置 [培训计划制定标识]
     */
    public void setTrmplanformuid(String trmplanformuid){
        this.trmplanformuid = trmplanformuid ;
        this.modify("trmplanformuid",trmplanformuid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [拟培训地点]
     */
    public void setPxadress(String pxadress){
        this.pxadress = pxadress ;
        this.modify("pxadress",pxadress);
    }

    /**
     * 设置 [拟培训内容]
     */
    public void setPxcontent(String pxcontent){
        this.pxcontent = pxcontent ;
        this.modify("pxcontent",pxcontent);
    }

    /**
     * 设置 [拟培训人数]
     */
    public void setPxnum(Integer pxnum){
        this.pxnum = pxnum ;
        this.modify("pxnum",pxnum);
    }

    /**
     * 设置 [审批状态]
     */
    public void setApprovalstatus(String approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }


}


