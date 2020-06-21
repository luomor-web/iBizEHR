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
 * 实体[人员花名册]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMDETAIL",resultMap = "PcmDetailResultMap")
public class PcmDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 联系方式
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 参加工作时间
     */
    @TableField(value = "cjgzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 最高学历所学专业
     */
    @TableField(value = "zgxlsxzy")
    @JSONField(name = "zgxlsxzy")
    @JsonProperty("zgxlsxzy")
    private String zgxlsxzy;
    /**
     * 证件号码
     */
    @TableField(value = "zjhm")
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 是否注册会计师
     */
    @TableField(value = "sfzckjs")
    @JSONField(name = "sfzckjs")
    @JsonProperty("sfzckjs")
    private Integer sfzckjs;
    /**
     * 婚姻状况
     */
    @TableField(value = "hyzk")
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;
    /**
     * 最高学历毕业院校
     */
    @TableField(value = "zgxlbyyx")
    @JSONField(name = "zgxlbyyx")
    @JsonProperty("zgxlbyyx")
    private String zgxlbyyx;
    /**
     * 是否第一学历
     */
    @TableField(value = "firsteducation")
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private Integer firsteducation;
    /**
     * 签订日期
     */
    @TableField(value = "qsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;
    /**
     * 最高学历学校类别
     */
    @TableField(value = "zgxxlb")
    @JSONField(name = "zgxxlb")
    @JsonProperty("zgxxlb")
    private String zgxxlb;
    /**
     * 合同试用期
     */
    @TableField(value = "htsyq")
    @JSONField(name = "htsyq")
    @JsonProperty("htsyq")
    private String htsyq;
    /**
     * 第一学历毕业院校
     */
    @TableField(value = "dyxlbyyx")
    @JSONField(name = "dyxlbyyx")
    @JsonProperty("dyxlbyyx")
    private String dyxlbyyx;
    /**
     * 人员明细表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmdetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmdetailid")
    @JsonProperty("pcmdetailid")
    private String pcmdetailid;
    /**
     * 出生日期
     */
    @TableField(value = "csrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 社保参缴地
     */
    @TableField(value = "sbcjd")
    @JSONField(name = "sbcjd")
    @JsonProperty("sbcjd")
    private String sbcjd;
    /**
     * 第一学历
     */
    @TableField(value = "dyxl")
    @JSONField(name = "dyxl")
    @JsonProperty("dyxl")
    private String dyxl;
    /**
     * 第一学历所学专业
     */
    @TableField(value = "dyxlsxzy")
    @JSONField(name = "dyxlsxzy")
    @JsonProperty("dyxlsxzy")
    private String dyxlsxzy;
    /**
     * 最高学历毕业时间
     */
    @TableField(value = "zgxljssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zgxljssj" , format="yyyy-MM-dd")
    @JsonProperty("zgxljssj")
    private Timestamp zgxljssj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 本单位工作时间
     */
    @TableField(value = "dbdwsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;
    /**
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 员工姓名
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 岗位类别
     */
    @TableField(value = "gwtype")
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;
    /**
     * 入党时间
     */
    @TableField(value = "rdsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;
    /**
     * 第一学历学校类别
     */
    @TableField(value = "xxlb")
    @JSONField(name = "xxlb")
    @JsonProperty("xxlb")
    private String xxlb;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 培训
     */
    @TableField(value = "px")
    @JSONField(name = "px")
    @JsonProperty("px")
    private String px;
    /**
     * 结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 劳动合同性质
     */
    @TableField(value = "contracttype")
    @JSONField(name = "contracttype")
    @JsonProperty("contracttype")
    private String contracttype;
    /**
     * 岗位证书
     */
    @TableField(value = "pimqualtypename")
    @JSONField(name = "pimqualtypename")
    @JsonProperty("pimqualtypename")
    private String pimqualtypename;
    /**
     * 第一学历学习形式
     */
    @TableField(value = "xllx")
    @JSONField(name = "xllx")
    @JsonProperty("xllx")
    private String xllx;
    /**
     * 专业技术资格（职称）
     */
    @TableField(value = "careername")
    @JSONField(name = "careername")
    @JsonProperty("careername")
    private String careername;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 最高学历学习形式
     */
    @TableField(value = "zgxllx")
    @JSONField(name = "zgxllx")
    @JsonProperty("zgxllx")
    private String zgxllx;
    /**
     * 建筑系统工作时间
     */
    @TableField(value = "tozjdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;
    /**
     * 绩效考核成绩（近两年）
     */
    @TableField(value = "jxkhcj")
    @JSONField(name = "jxkhcj")
    @JsonProperty("jxkhcj")
    private String jxkhcj;
    /**
     * 第一学历毕业时间
     */
    @TableField(value = "dyxljssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dyxljssj" , format="yyyy-MM-dd")
    @JsonProperty("dyxljssj")
    private Timestamp dyxljssj;
    /**
     * 员工类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 人员明细表名称
     */
    @TableField(value = "pcmdetailname")
    @JSONField(name = "pcmdetailname")
    @JsonProperty("pcmdetailname")
    private String pcmdetailname;
    /**
     * 局工作时间
     */
    @TableField(value = "dzjbjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;
    /**
     * 政治面貌
     */
    @TableField(value = "zzmm")
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 注册会计师专业阶段考试已通过科目数
     */
    @TableField(value = "kstgkms")
    @JSONField(name = "kstgkms")
    @JsonProperty("kstgkms")
    private String kstgkms;
    /**
     * 注册会计师证书编号
     */
    @TableField(value = "zgzsbh")
    @JSONField(name = "zgzsbh")
    @JsonProperty("zgzsbh")
    private String zgzsbh;
    /**
     * 入职渠道
     */
    @TableField(value = "rzqd")
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;
    /**
     * 执(职)业资格证书
     */
    @TableField(value = "pimvocationalcatalogname")
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;
    /**
     * 职级
     */
    @TableField(value = "rank")
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 职称编号
     */
    @TableField(value = "zcbh")
    @JSONField(name = "zcbh")
    @JsonProperty("zcbh")
    private String zcbh;
    /**
     * 所属业务系统
     */
    @TableField(value = "pimmajorsetypename")
    @JSONField(name = "pimmajorsetypename")
    @JsonProperty("pimmajorsetypename")
    private String pimmajorsetypename;
    /**
     * 建筑系统工作年限
     */
    @TableField(value = "zjxtgznx")
    @JSONField(name = "zjxtgznx")
    @JsonProperty("zjxtgznx")
    private Double zjxtgznx;
    /**
     * 工作年限
     */
    @TableField(value = "gznx")
    @JSONField(name = "gznx")
    @JsonProperty("gznx")
    private Double gznx;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
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
     * 合同类别
     */
    @TableField(value = "htlb")
    @JSONField(name = "htlb")
    @JsonProperty("htlb")
    private String htlb;
    /**
     * 工作单位
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 最高学历
     */
    @TableField(value = "zgxl")
    @JSONField(name = "zgxl")
    @JsonProperty("zgxl")
    private String zgxl;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 局工作年限
     */
    @TableField(value = "bjgznx")
    @JSONField(name = "bjgznx")
    @JsonProperty("bjgznx")
    private Double bjgznx;
    /**
     * 籍贯
     */
    @TableField(value = "jg")
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;
    /**
     * 户籍地址
     */
    @TableField(value = "hjdz")
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;
    /**
     * 本单位工作年限
     */
    @TableField(value = "bdwgznx")
    @JSONField(name = "bdwgznx")
    @JsonProperty("bdwgznx")
    private Double bdwgznx;
    /**
     * 合同期限
     */
    @TableField(value = "htqx")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "htqx" , format="yyyy-MM-dd")
    @JsonProperty("htqx")
    private Timestamp htqx;
    /**
     * 年龄
     */
    @TableField(value = "nj")
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
    /**
     * 户口性质
     */
    @TableField(value = "hkxz")
    @JSONField(name = "hkxz")
    @JsonProperty("hkxz")
    private String hkxz;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 是否最高学历
     */
    @TableField(value = "sfzgxl")
    @JSONField(name = "sfzgxl")
    @JsonProperty("sfzgxl")
    private Integer sfzgxl;
    /**
     * 民族
     */
    @TableField(value = "mz")
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 工作单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
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
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [联系方式]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [参加工作时间]
     */
    public void setCjgzsj(Timestamp cjgzsj){
        this.cjgzsj = cjgzsj ;
        this.modify("cjgzsj",cjgzsj);
    }

    /**
     * 格式化日期 [参加工作时间]
     */
    public String formatCjgzsj(){
        if (this.cjgzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cjgzsj);
    }
    /**
     * 设置 [最高学历所学专业]
     */
    public void setZgxlsxzy(String zgxlsxzy){
        this.zgxlsxzy = zgxlsxzy ;
        this.modify("zgxlsxzy",zgxlsxzy);
    }

    /**
     * 设置 [证件号码]
     */
    public void setZjhm(String zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [是否注册会计师]
     */
    public void setSfzckjs(Integer sfzckjs){
        this.sfzckjs = sfzckjs ;
        this.modify("sfzckjs",sfzckjs);
    }

    /**
     * 设置 [婚姻状况]
     */
    public void setHyzk(String hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }

    /**
     * 设置 [最高学历毕业院校]
     */
    public void setZgxlbyyx(String zgxlbyyx){
        this.zgxlbyyx = zgxlbyyx ;
        this.modify("zgxlbyyx",zgxlbyyx);
    }

    /**
     * 设置 [是否第一学历]
     */
    public void setFirsteducation(Integer firsteducation){
        this.firsteducation = firsteducation ;
        this.modify("firsteducation",firsteducation);
    }

    /**
     * 设置 [签订日期]
     */
    public void setQsrq(Timestamp qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 格式化日期 [签订日期]
     */
    public String formatQsrq(){
        if (this.qsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qsrq);
    }
    /**
     * 设置 [最高学历学校类别]
     */
    public void setZgxxlb(String zgxxlb){
        this.zgxxlb = zgxxlb ;
        this.modify("zgxxlb",zgxxlb);
    }

    /**
     * 设置 [合同试用期]
     */
    public void setHtsyq(String htsyq){
        this.htsyq = htsyq ;
        this.modify("htsyq",htsyq);
    }

    /**
     * 设置 [第一学历毕业院校]
     */
    public void setDyxlbyyx(String dyxlbyyx){
        this.dyxlbyyx = dyxlbyyx ;
        this.modify("dyxlbyyx",dyxlbyyx);
    }

    /**
     * 设置 [出生日期]
     */
    public void setCsrq(Timestamp csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 格式化日期 [出生日期]
     */
    public String formatCsrq(){
        if (this.csrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(csrq);
    }
    /**
     * 设置 [社保参缴地]
     */
    public void setSbcjd(String sbcjd){
        this.sbcjd = sbcjd ;
        this.modify("sbcjd",sbcjd);
    }

    /**
     * 设置 [第一学历]
     */
    public void setDyxl(String dyxl){
        this.dyxl = dyxl ;
        this.modify("dyxl",dyxl);
    }

    /**
     * 设置 [第一学历所学专业]
     */
    public void setDyxlsxzy(String dyxlsxzy){
        this.dyxlsxzy = dyxlsxzy ;
        this.modify("dyxlsxzy",dyxlsxzy);
    }

    /**
     * 设置 [最高学历毕业时间]
     */
    public void setZgxljssj(Timestamp zgxljssj){
        this.zgxljssj = zgxljssj ;
        this.modify("zgxljssj",zgxljssj);
    }

    /**
     * 格式化日期 [最高学历毕业时间]
     */
    public String formatZgxljssj(){
        if (this.zgxljssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zgxljssj);
    }
    /**
     * 设置 [本单位工作时间]
     */
    public void setDbdwsj(Timestamp dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 格式化日期 [本单位工作时间]
     */
    public String formatDbdwsj(){
        if (this.dbdwsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dbdwsj);
    }
    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [员工姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [岗位类别]
     */
    public void setGwtype(String gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [入党时间]
     */
    public void setRdsj(Timestamp rdsj){
        this.rdsj = rdsj ;
        this.modify("rdsj",rdsj);
    }

    /**
     * 格式化日期 [入党时间]
     */
    public String formatRdsj(){
        if (this.rdsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rdsj);
    }
    /**
     * 设置 [第一学历学校类别]
     */
    public void setXxlb(String xxlb){
        this.xxlb = xxlb ;
        this.modify("xxlb",xxlb);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [培训]
     */
    public void setPx(String px){
        this.px = px ;
        this.modify("px",px);
    }

    /**
     * 设置 [结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [劳动合同性质]
     */
    public void setContracttype(String contracttype){
        this.contracttype = contracttype ;
        this.modify("contracttype",contracttype);
    }

    /**
     * 设置 [岗位证书]
     */
    public void setPimqualtypename(String pimqualtypename){
        this.pimqualtypename = pimqualtypename ;
        this.modify("pimqualtypename",pimqualtypename);
    }

    /**
     * 设置 [第一学历学习形式]
     */
    public void setXllx(String xllx){
        this.xllx = xllx ;
        this.modify("xllx",xllx);
    }

    /**
     * 设置 [专业技术资格（职称）]
     */
    public void setCareername(String careername){
        this.careername = careername ;
        this.modify("careername",careername);
    }

    /**
     * 设置 [最高学历学习形式]
     */
    public void setZgxllx(String zgxllx){
        this.zgxllx = zgxllx ;
        this.modify("zgxllx",zgxllx);
    }

    /**
     * 设置 [建筑系统工作时间]
     */
    public void setTozjdate(Timestamp tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 格式化日期 [建筑系统工作时间]
     */
    public String formatTozjdate(){
        if (this.tozjdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tozjdate);
    }
    /**
     * 设置 [绩效考核成绩（近两年）]
     */
    public void setJxkhcj(String jxkhcj){
        this.jxkhcj = jxkhcj ;
        this.modify("jxkhcj",jxkhcj);
    }

    /**
     * 设置 [第一学历毕业时间]
     */
    public void setDyxljssj(Timestamp dyxljssj){
        this.dyxljssj = dyxljssj ;
        this.modify("dyxljssj",dyxljssj);
    }

    /**
     * 格式化日期 [第一学历毕业时间]
     */
    public String formatDyxljssj(){
        if (this.dyxljssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dyxljssj);
    }
    /**
     * 设置 [员工类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [人员明细表名称]
     */
    public void setPcmdetailname(String pcmdetailname){
        this.pcmdetailname = pcmdetailname ;
        this.modify("pcmdetailname",pcmdetailname);
    }

    /**
     * 设置 [局工作时间]
     */
    public void setDzjbjsj(Timestamp dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 格式化日期 [局工作时间]
     */
    public String formatDzjbjsj(){
        if (this.dzjbjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dzjbjsj);
    }
    /**
     * 设置 [政治面貌]
     */
    public void setZzmm(String zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [注册会计师专业阶段考试已通过科目数]
     */
    public void setKstgkms(String kstgkms){
        this.kstgkms = kstgkms ;
        this.modify("kstgkms",kstgkms);
    }

    /**
     * 设置 [注册会计师证书编号]
     */
    public void setZgzsbh(String zgzsbh){
        this.zgzsbh = zgzsbh ;
        this.modify("zgzsbh",zgzsbh);
    }

    /**
     * 设置 [入职渠道]
     */
    public void setRzqd(String rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [执(职)业资格证书]
     */
    public void setPimvocationalcatalogname(String pimvocationalcatalogname){
        this.pimvocationalcatalogname = pimvocationalcatalogname ;
        this.modify("pimvocationalcatalogname",pimvocationalcatalogname);
    }

    /**
     * 设置 [职级]
     */
    public void setRank(String rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [职称编号]
     */
    public void setZcbh(String zcbh){
        this.zcbh = zcbh ;
        this.modify("zcbh",zcbh);
    }

    /**
     * 设置 [所属业务系统]
     */
    public void setPimmajorsetypename(String pimmajorsetypename){
        this.pimmajorsetypename = pimmajorsetypename ;
        this.modify("pimmajorsetypename",pimmajorsetypename);
    }

    /**
     * 设置 [建筑系统工作年限]
     */
    public void setZjxtgznx(Double zjxtgznx){
        this.zjxtgznx = zjxtgznx ;
        this.modify("zjxtgznx",zjxtgznx);
    }

    /**
     * 设置 [工作年限]
     */
    public void setGznx(Double gznx){
        this.gznx = gznx ;
        this.modify("gznx",gznx);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [合同类别]
     */
    public void setHtlb(String htlb){
        this.htlb = htlb ;
        this.modify("htlb",htlb);
    }

    /**
     * 设置 [工作单位]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [最高学历]
     */
    public void setZgxl(String zgxl){
        this.zgxl = zgxl ;
        this.modify("zgxl",zgxl);
    }

    /**
     * 设置 [局工作年限]
     */
    public void setBjgznx(Double bjgznx){
        this.bjgznx = bjgznx ;
        this.modify("bjgznx",bjgznx);
    }

    /**
     * 设置 [籍贯]
     */
    public void setJg(String jg){
        this.jg = jg ;
        this.modify("jg",jg);
    }

    /**
     * 设置 [户籍地址]
     */
    public void setHjdz(String hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [本单位工作年限]
     */
    public void setBdwgznx(Double bdwgznx){
        this.bdwgznx = bdwgznx ;
        this.modify("bdwgznx",bdwgznx);
    }

    /**
     * 设置 [合同期限]
     */
    public void setHtqx(Timestamp htqx){
        this.htqx = htqx ;
        this.modify("htqx",htqx);
    }

    /**
     * 格式化日期 [合同期限]
     */
    public String formatHtqx(){
        if (this.htqx == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(htqx);
    }
    /**
     * 设置 [年龄]
     */
    public void setNj(Integer nj){
        this.nj = nj ;
        this.modify("nj",nj);
    }

    /**
     * 设置 [户口性质]
     */
    public void setHkxz(String hkxz){
        this.hkxz = hkxz ;
        this.modify("hkxz",hkxz);
    }

    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [是否最高学历]
     */
    public void setSfzgxl(Integer sfzgxl){
        this.sfzgxl = sfzgxl ;
        this.modify("sfzgxl",sfzgxl);
    }

    /**
     * 设置 [民族]
     */
    public void setMz(String mz){
        this.mz = mz ;
        this.modify("mz",mz);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


