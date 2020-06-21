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
 * 实体[培训需求汇总]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMDEMDEFTION",resultMap = "TrmDemdeftionResultMap")
public class TrmDemdeftion extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 调查表级别
     */
    @TableField(value = "dcbjb")
    @JSONField(name = "dcbjb")
    @JsonProperty("dcbjb")
    private String dcbjb;
    /**
     * 培训班名称
     */
    @TableField(value = "pxbmc")
    @JSONField(name = "pxbmc")
    @JsonProperty("pxbmc")
    private String pxbmc;
    /**
     * 是否发布
     */
    @TableField(value = "sffb")
    @JSONField(name = "sffb")
    @JsonProperty("sffb")
    private Integer sffb;
    /**
     * 报名截止时间
     */
    @TableField(value = "bmjzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzsj" , format="yyyy-MM-dd")
    @JsonProperty("bmjzsj")
    private Timestamp bmjzsj;
    /**
     * 调查所处季度
     */
    @TableField(value = "dcscjd")
    @JSONField(name = "dcscjd")
    @JsonProperty("dcscjd")
    private String dcscjd;
    /**
     * 培训结束时间
     */
    @TableField(value = "pxjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;
    /**
     * 培训地点
     */
    @TableField(value = "pxdd")
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 调查对象类型
     */
    @TableField(value = "dcdxlx")
    @JSONField(name = "dcdxlx")
    @JsonProperty("dcdxlx")
    private String dcdxlx;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训人数
     */
    @TableField(value = "pxrs")
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;
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
     * 培训主要内容
     */
    @TableField(value = "pxzynr")
    @JSONField(name = "pxzynr")
    @JsonProperty("pxzynr")
    private String pxzynr;
    /**
     * 调查员工类别
     */
    @TableField(value = "dcyglb")
    @JSONField(name = "dcyglb")
    @JsonProperty("dcyglb")
    private String dcyglb;
    /**
     * 调查表类型
     */
    @TableField(value = "dcblx")
    @JSONField(name = "dcblx")
    @JsonProperty("dcblx")
    private String dcblx;
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
     * 培训开始时间
     */
    @TableField(value = "pxkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;
    /**
     * 需求分类
     */
    @TableField(value = "xqfl")
    @JSONField(name = "xqfl")
    @JsonProperty("xqfl")
    private String xqfl;
    /**
     * 制定时间
     */
    @TableField(value = "zdsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zdsj" , format="yyyy-MM-dd")
    @JsonProperty("zdsj")
    private Timestamp zdsj;
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
     * 培训汇总
     */
    @TableField(value = "trmdemdeftionname")
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;
    /**
     * 培训对象
     */
    @TableField(value = "pxdx")
    @JSONField(name = "pxdx")
    @JsonProperty("pxdx")
    private String pxdx;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 调查截至日期
     */
    @TableField(value = "dcjzrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dcjzrq" , format="yyyy-MM-dd")
    @JsonProperty("dcjzrq")
    private Timestamp dcjzrq;
    /**
     * 需求调查定义标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmdemdeftionid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmdemdeftionid")
    @JsonProperty("trmdemdeftionid")
    private String trmdemdeftionid;
    /**
     * 调查所处年度
     */
    @TableField(value = "dcscnd")
    @JSONField(name = "dcscnd")
    @JsonProperty("dcscnd")
    private String dcscnd;
    /**
     * 培训模块
     */
    @TableField(value = "pxmk")
    @JSONField(name = "pxmk")
    @JsonProperty("pxmk")
    private String pxmk;
    /**
     * 培训课程
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 培训项目部门填报名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainfillinname")
    @JsonProperty("trmtrainfillinname")
    private String trmtrainfillinname;
    /**
     * 单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训需求名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训项目部门填报标识
     */
    @TableField(value = "trmtrainfillinid")
    @JSONField(name = "trmtrainfillinid")
    @JsonProperty("trmtrainfillinid")
    private String trmtrainfillinid;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 培训需求填报标识
     */
    @TableField(value = "trmdepartid")
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 制定人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 培训需求汇总
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmDepart trmdepart;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse;

    /**
     * 培训需求填报
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin trmtrainfillin;



    /**
     * 设置 [调查表级别]
     */
    public void setDcbjb(String dcbjb){
        this.dcbjb = dcbjb ;
        this.modify("dcbjb",dcbjb);
    }

    /**
     * 设置 [培训班名称]
     */
    public void setPxbmc(String pxbmc){
        this.pxbmc = pxbmc ;
        this.modify("pxbmc",pxbmc);
    }

    /**
     * 设置 [是否发布]
     */
    public void setSffb(Integer sffb){
        this.sffb = sffb ;
        this.modify("sffb",sffb);
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
     * 设置 [调查所处季度]
     */
    public void setDcscjd(String dcscjd){
        this.dcscjd = dcscjd ;
        this.modify("dcscjd",dcscjd);
    }

    /**
     * 设置 [培训结束时间]
     */
    public void setPxjssj(Timestamp pxjssj){
        this.pxjssj = pxjssj ;
        this.modify("pxjssj",pxjssj);
    }

    /**
     * 格式化日期 [培训结束时间]
     */
    public String formatPxjssj(){
        if (this.pxjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxjssj);
    }
    /**
     * 设置 [培训地点]
     */
    public void setPxdd(String pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [调查对象类型]
     */
    public void setDcdxlx(String dcdxlx){
        this.dcdxlx = dcdxlx ;
        this.modify("dcdxlx",dcdxlx);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(String xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [培训人数]
     */
    public void setPxrs(Integer pxrs){
        this.pxrs = pxrs ;
        this.modify("pxrs",pxrs);
    }

    /**
     * 设置 [培训主要内容]
     */
    public void setPxzynr(String pxzynr){
        this.pxzynr = pxzynr ;
        this.modify("pxzynr",pxzynr);
    }

    /**
     * 设置 [调查员工类别]
     */
    public void setDcyglb(String dcyglb){
        this.dcyglb = dcyglb ;
        this.modify("dcyglb",dcyglb);
    }

    /**
     * 设置 [调查表类型]
     */
    public void setDcblx(String dcblx){
        this.dcblx = dcblx ;
        this.modify("dcblx",dcblx);
    }

    /**
     * 设置 [培训开始时间]
     */
    public void setPxkssj(Timestamp pxkssj){
        this.pxkssj = pxkssj ;
        this.modify("pxkssj",pxkssj);
    }

    /**
     * 格式化日期 [培训开始时间]
     */
    public String formatPxkssj(){
        if (this.pxkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxkssj);
    }
    /**
     * 设置 [需求分类]
     */
    public void setXqfl(String xqfl){
        this.xqfl = xqfl ;
        this.modify("xqfl",xqfl);
    }

    /**
     * 设置 [制定时间]
     */
    public void setZdsj(Timestamp zdsj){
        this.zdsj = zdsj ;
        this.modify("zdsj",zdsj);
    }

    /**
     * 格式化日期 [制定时间]
     */
    public String formatZdsj(){
        if (this.zdsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zdsj);
    }
    /**
     * 设置 [培训汇总]
     */
    public void setTrmdemdeftionname(String trmdemdeftionname){
        this.trmdemdeftionname = trmdemdeftionname ;
        this.modify("trmdemdeftionname",trmdemdeftionname);
    }

    /**
     * 设置 [培训对象]
     */
    public void setPxdx(String pxdx){
        this.pxdx = pxdx ;
        this.modify("pxdx",pxdx);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [调查截至日期]
     */
    public void setDcjzrq(Timestamp dcjzrq){
        this.dcjzrq = dcjzrq ;
        this.modify("dcjzrq",dcjzrq);
    }

    /**
     * 格式化日期 [调查截至日期]
     */
    public String formatDcjzrq(){
        if (this.dcjzrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dcjzrq);
    }
    /**
     * 设置 [调查所处年度]
     */
    public void setDcscnd(String dcscnd){
        this.dcscnd = dcscnd ;
        this.modify("dcscnd",dcscnd);
    }

    /**
     * 设置 [培训模块]
     */
    public void setPxmk(String pxmk){
        this.pxmk = pxmk ;
        this.modify("pxmk",pxmk);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训项目部门填报标识]
     */
    public void setTrmtrainfillinid(String trmtrainfillinid){
        this.trmtrainfillinid = trmtrainfillinid ;
        this.modify("trmtrainfillinid",trmtrainfillinid);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [培训需求填报标识]
     */
    public void setTrmdepartid(String trmdepartid){
        this.trmdepartid = trmdepartid ;
        this.modify("trmdepartid",trmdepartid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


