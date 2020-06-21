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
 * 实体[B/Y类员工转正记录引用明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMBYZZJLMX",resultMap = "PimByzzjlmxResultMap")
public class PimByzzjlmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 拟申请员工编号类型
     */
    @TableField(value = "nzzyglx")
    @JSONField(name = "nzzyglx")
    @JsonProperty("nzzyglx")
    private String nzzyglx;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 所属劳务派遣公司名称
     */
    @TableField(value = "sslwgs")
    @JSONField(name = "sslwgs")
    @JsonProperty("sslwgs")
    private String sslwgs;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 是否为临时数据
     */
    @TableField(value = "istemp")
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 是否完成
     */
    @TableField(value = "finished")
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;
    /**
     * 邮政编码
     */
    @TableField(value = "yzbm")
    @JSONField(name = "yzbm")
    @JsonProperty("yzbm")
    private String yzbm;
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
     * 当前状态
     */
    @TableField(exist = false)
    @JSONField(name = "dqzt")
    @JsonProperty("dqzt")
    private String dqzt;
    /**
     * 审核状态
     */
    @TableField(value = "checkstatus")
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 新员工编号
     */
    @TableField(value = "xygbh")
    @JSONField(name = "xygbh")
    @JsonProperty("xygbh")
    private String xygbh;
    /**
     * 原员工编号类型
     */
    @TableField(value = "oldyglx")
    @JSONField(name = "oldyglx")
    @JsonProperty("oldyglx")
    private String oldyglx;
    /**
     * 局审核意见
     */
    @TableField(value = "jzbshyj")
    @JSONField(name = "jzbshyj")
    @JsonProperty("jzbshyj")
    private String jzbshyj;
    /**
     * 所属劳务派遣公司地址
     */
    @TableField(value = "sslwgsdz")
    @JSONField(name = "sslwgsdz")
    @JsonProperty("sslwgsdz")
    private String sslwgsdz;
    /**
     * 拟签订劳动合同结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 局总部意见
     */
    @TableField(exist = false)
    @JSONField(name = "yj")
    @JsonProperty("yj")
    private String yj;
    /**
     * 局初审意见
     */
    @TableField(value = "jzpspyj")
    @JSONField(name = "jzpspyj")
    @JsonProperty("jzpspyj")
    private String jzpspyj;
    /**
     * 申请日期
     */
    @DEField(defaultValueType = DEFieldDefaultValueType.CURTIME)
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 人员列表
     */
    @TableField(value = "profilelist")
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 体检情况
     */
    @TableField(value = "tjqk")
    @JSONField(name = "tjqk")
    @JsonProperty("tjqk")
    private String tjqk;
    /**
     * 有无重大疾病史
     */
    @TableField(value = "ywzdjbs")
    @JSONField(name = "ywzdjbs")
    @JsonProperty("ywzdjbs")
    private String ywzdjbs;
    /**
     * 申报材料
     */
    @TableField(value = "sbcl")
    @JSONField(name = "sbcl")
    @JsonProperty("sbcl")
    private String sbcl;
    /**
     * 局审批意见
     */
    @TableField(value = "jzbspyj")
    @JSONField(name = "jzbspyj")
    @JsonProperty("jzbspyj")
    private String jzbspyj;
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
     * 拟签订劳动合同起始日期
     */
    @TableField(value = "qsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 申请前员工编号
     */
    @TableField(value = "oldygbh")
    @JSONField(name = "oldygbh")
    @JsonProperty("oldygbh")
    private String oldygbh;
    /**
     * 档案调转情况
     */
    @TableField(value = "datzqk")
    @JSONField(name = "datzqk")
    @JsonProperty("datzqk")
    private String datzqk;
    /**
     * 状态原因
     */
    @TableField(value = "ztyy")
    @JSONField(name = "ztyy")
    @JsonProperty("ztyy")
    private String ztyy;
    /**
     * 标准原因
     */
    @TableField(value = "standardcause")
    @JSONField(name = "standardcause")
    @JsonProperty("standardcause")
    private String standardcause;
    /**
     * B/Y类员工转正记录引用明细名称
     */
    @TableField(value = "pimbyzzjlmxname")
    @JSONField(name = "pimbyzzjlmxname")
    @JsonProperty("pimbyzzjlmxname")
    private String pimbyzzjlmxname;
    /**
     * B/Y类员工转正记录引用明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimbyzzjlmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimbyzzjlmxid")
    @JsonProperty("pimbyzzjlmxid")
    private String pimbyzzjlmxid;
    /**
     * 人数
     */
    @TableField(value = "peoplenum")
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;
    /**
     * 参加工作时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;
    /**
     * 申请前员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 转正前岗位名称
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 转正后拟安排岗位名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 性别
     */
    @TableField(exist = false)
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 部门ID
     */
    @TableField(value = "bmid")
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 户籍类型
     */
    @TableField(exist = false)
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;
    /**
     * 部门名称
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 分数
     */
    @TableField(value = "fs")
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;
    /**
     * 原员工编号类型
     */
    @TableField(value = "yyglx")
    @JSONField(name = "yyglx")
    @JsonProperty("yyglx")
    private String yyglx;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimexaminationresultsname")
    @JsonProperty("pimexaminationresultsname")
    private String pimexaminationresultsname;
    /**
     * 原编号启用时间
     */
    @TableField(value = "ybhqysj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ybhqysj" , format="yyyy-MM-dd")
    @JsonProperty("ybhqysj")
    private Timestamp ybhqysj;
    /**
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 技术职称
     */
    @TableField(exist = false)
    @JSONField(name = "hightitle")
    @JsonProperty("hightitle")
    private String hightitle;
    /**
     * 现住址
     */
    @TableField(exist = false)
    @JSONField(name = "postaladdress")
    @JsonProperty("postaladdress")
    private String postaladdress;
    /**
     * 户籍地址
     */
    @TableField(exist = false)
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;
    /**
     * 身份证号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 到局工作时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 籍贯
     */
    @TableField(exist = false)
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;
    /**
     * 组织名称
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 政治面貌
     */
    @TableField(exist = false)
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 考核起始时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "pimbyygzzsqname")
    @JsonProperty("pimbyygzzsqname")
    private String pimbyygzzsqname;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 考核结束时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 健康状况
     */
    @TableField(exist = false)
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;
    /**
     * 民族
     */
    @TableField(exist = false)
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;
    /**
     * 组织ID
     */
    @TableField(value = "zzid")
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * B/Y员工转正考核结果记录ID
     */
    @TableField(value = "pimexaminationresultsid")
    @JSONField(name = "pimexaminationresultsid")
    @JsonProperty("pimexaminationresultsid")
    private String pimexaminationresultsid;
    /**
     * B/Y类员工转正申请ID
     */
    @TableField(value = "pimbyygzzsqid")
    @JSONField(name = "pimbyygzzsqid")
    @JsonProperty("pimbyygzzsqid")
    private String pimbyygzzsqid;
    /**
     * 转正后岗位标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * B/Y类员工转正申请
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimByygzzsq pimbyygzzsq;

    /**
     * B/Y员工转正考核结果记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimExaminationResults pimexaminationresults;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [拟申请员工编号类型]
     */
    public void setNzzyglx(String nzzyglx){
        this.nzzyglx = nzzyglx ;
        this.modify("nzzyglx",nzzyglx);
    }

    /**
     * 设置 [所属劳务派遣公司名称]
     */
    public void setSslwgs(String sslwgs){
        this.sslwgs = sslwgs ;
        this.modify("sslwgs",sslwgs);
    }

    /**
     * 设置 [是否为临时数据]
     */
    public void setIstemp(Integer istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [是否完成]
     */
    public void setFinished(Integer finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [邮政编码]
     */
    public void setYzbm(String yzbm){
        this.yzbm = yzbm ;
        this.modify("yzbm",yzbm);
    }

    /**
     * 设置 [审核状态]
     */
    public void setCheckstatus(String checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [新员工编号]
     */
    public void setXygbh(String xygbh){
        this.xygbh = xygbh ;
        this.modify("xygbh",xygbh);
    }

    /**
     * 设置 [原员工编号类型]
     */
    public void setOldyglx(String oldyglx){
        this.oldyglx = oldyglx ;
        this.modify("oldyglx",oldyglx);
    }

    /**
     * 设置 [局审核意见]
     */
    public void setJzbshyj(String jzbshyj){
        this.jzbshyj = jzbshyj ;
        this.modify("jzbshyj",jzbshyj);
    }

    /**
     * 设置 [所属劳务派遣公司地址]
     */
    public void setSslwgsdz(String sslwgsdz){
        this.sslwgsdz = sslwgsdz ;
        this.modify("sslwgsdz",sslwgsdz);
    }

    /**
     * 设置 [拟签订劳动合同结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [拟签订劳动合同结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [局初审意见]
     */
    public void setJzpspyj(String jzpspyj){
        this.jzpspyj = jzpspyj ;
        this.modify("jzpspyj",jzpspyj);
    }

    /**
     * 设置 [申请日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [申请日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [人员列表]
     */
    public void setProfilelist(String profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [体检情况]
     */
    public void setTjqk(String tjqk){
        this.tjqk = tjqk ;
        this.modify("tjqk",tjqk);
    }

    /**
     * 设置 [有无重大疾病史]
     */
    public void setYwzdjbs(String ywzdjbs){
        this.ywzdjbs = ywzdjbs ;
        this.modify("ywzdjbs",ywzdjbs);
    }

    /**
     * 设置 [申报材料]
     */
    public void setSbcl(String sbcl){
        this.sbcl = sbcl ;
        this.modify("sbcl",sbcl);
    }

    /**
     * 设置 [局审批意见]
     */
    public void setJzbspyj(String jzbspyj){
        this.jzbspyj = jzbspyj ;
        this.modify("jzbspyj",jzbspyj);
    }

    /**
     * 设置 [拟签订劳动合同起始日期]
     */
    public void setQsrq(Timestamp qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 格式化日期 [拟签订劳动合同起始日期]
     */
    public String formatQsrq(){
        if (this.qsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qsrq);
    }
    /**
     * 设置 [申请前员工编号]
     */
    public void setOldygbh(String oldygbh){
        this.oldygbh = oldygbh ;
        this.modify("oldygbh",oldygbh);
    }

    /**
     * 设置 [档案调转情况]
     */
    public void setDatzqk(String datzqk){
        this.datzqk = datzqk ;
        this.modify("datzqk",datzqk);
    }

    /**
     * 设置 [状态原因]
     */
    public void setZtyy(String ztyy){
        this.ztyy = ztyy ;
        this.modify("ztyy",ztyy);
    }

    /**
     * 设置 [标准原因]
     */
    public void setStandardcause(String standardcause){
        this.standardcause = standardcause ;
        this.modify("standardcause",standardcause);
    }

    /**
     * 设置 [B/Y类员工转正记录引用明细名称]
     */
    public void setPimbyzzjlmxname(String pimbyzzjlmxname){
        this.pimbyzzjlmxname = pimbyzzjlmxname ;
        this.modify("pimbyzzjlmxname",pimbyzzjlmxname);
    }

    /**
     * 设置 [人数]
     */
    public void setPeoplenum(Integer peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [申请前员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [部门ID]
     */
    public void setBmid(String bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [部门名称]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [分数]
     */
    public void setFs(Double fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [原员工编号类型]
     */
    public void setYyglx(String yyglx){
        this.yyglx = yyglx ;
        this.modify("yyglx",yyglx);
    }

    /**
     * 设置 [原编号启用时间]
     */
    public void setYbhqysj(Timestamp ybhqysj){
        this.ybhqysj = ybhqysj ;
        this.modify("ybhqysj",ybhqysj);
    }

    /**
     * 格式化日期 [原编号启用时间]
     */
    public String formatYbhqysj(){
        if (this.ybhqysj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ybhqysj);
    }
    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [组织名称]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [组织ID]
     */
    public void setZzid(String zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [B/Y员工转正考核结果记录ID]
     */
    public void setPimexaminationresultsid(String pimexaminationresultsid){
        this.pimexaminationresultsid = pimexaminationresultsid ;
        this.modify("pimexaminationresultsid",pimexaminationresultsid);
    }

    /**
     * 设置 [B/Y类员工转正申请ID]
     */
    public void setPimbyygzzsqid(String pimbyygzzsqid){
        this.pimbyygzzsqid = pimbyygzzsqid ;
        this.modify("pimbyygzzsqid",pimbyygzzsqid);
    }

    /**
     * 设置 [转正后岗位标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }


}


