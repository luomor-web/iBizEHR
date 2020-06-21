package cn.ibizlab.ehr.core.att.domain;

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
 * 实体[考勤汇总]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENSUMMARY",resultMap = "AttEnsummaryResultMap")
public class AttEnsummary extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工伤假
     */
    @TableField(value = "gs")
    @JSONField(name = "gs")
    @JsonProperty("gs")
    private Double gs;
    /**
     * 早退（分）
     */
    @TableField(value = "ztf")
    @JSONField(name = "ztf")
    @JsonProperty("ztf")
    private Double ztf;
    /**
     * 病假
     */
    @TableField(value = "bj")
    @JSONField(name = "bj")
    @JsonProperty("bj")
    private Double bj;
    /**
     * 出差
     */
    @TableField(value = "cc")
    @JSONField(name = "cc")
    @JsonProperty("cc")
    private Double cc;
    /**
     * 开始日期
     */
    @TableField(value = "begindate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "begindate" , format="yyyy-MM-dd")
    @JsonProperty("begindate")
    private Timestamp begindate;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 年休假
     */
    @TableField(value = "nx")
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Double nx;
    /**
     * 旷工
     */
    @TableField(value = "kg")
    @JSONField(name = "kg")
    @JsonProperty("kg")
    private Double kg;
    /**
     * 月份
     */
    @TableField(value = "yf")
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;
    /**
     * 工作日加班
     */
    @TableField(value = "gzrjb")
    @JSONField(name = "gzrjb")
    @JsonProperty("gzrjb")
    private Double gzrjb;
    /**
     * 计划生育手术假
     */
    @TableField(value = "js")
    @JSONField(name = "js")
    @JsonProperty("js")
    private Double js;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 法定假日加班
     */
    @TableField(value = "fdjrjb")
    @JSONField(name = "fdjrjb")
    @JsonProperty("fdjrjb")
    private Double fdjrjb;
    /**
     * 迟到（分）
     */
    @TableField(value = "cdf")
    @JSONField(name = "cdf")
    @JsonProperty("cdf")
    private Double cdf;
    /**
     * 早退（次）
     */
    @TableField(value = "ztc")
    @JSONField(name = "ztc")
    @JsonProperty("ztc")
    private Integer ztc;
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
     * 早退
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private Double zt;
    /**
     * 脱产学习
     */
    @TableField(value = "tcxx")
    @JSONField(name = "tcxx")
    @JsonProperty("tcxx")
    private Double tcxx;
    /**
     * 部门审核并注明未签到（或缺勤）原因
     */
    @TableField(value = "remarkreason")
    @JSONField(name = "remarkreason")
    @JsonProperty("remarkreason")
    private String remarkreason;
    /**
     * 本月在沪出勤天数
     */
    @TableField(value = "zhts")
    @JSONField(name = "zhts")
    @JsonProperty("zhts")
    private Double zhts;
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
     * 调休假
     */
    @TableField(value = "tx")
    @JSONField(name = "tx")
    @JsonProperty("tx")
    private Double tx;
    /**
     * 未签到天数
     */
    @TableField(value = "wqdts")
    @JSONField(name = "wqdts")
    @JsonProperty("wqdts")
    private Double wqdts;
    /**
     * 哺乳假
     */
    @TableField(value = "br")
    @JSONField(name = "br")
    @JsonProperty("br")
    private Double br;
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
     * 探亲假
     */
    @TableField(value = "tq")
    @JSONField(name = "tq")
    @JsonProperty("tq")
    private Double tq;
    /**
     * 事假
     */
    @TableField(value = "sj")
    @JSONField(name = "sj")
    @JsonProperty("sj")
    private Double sj;
    /**
     * 全勤
     */
    @TableField(value = "qq")
    @JSONField(name = "qq")
    @JsonProperty("qq")
    private Double qq;
    /**
     * 陪产假
     */
    @TableField(value = "pc")
    @JSONField(name = "pc")
    @JsonProperty("pc")
    private Double pc;
    /**
     * 丧葬假
     */
    @TableField(value = "sz")
    @JSONField(name = "sz")
    @JsonProperty("sz")
    private Double sz;
    /**
     * 迟到
     */
    @TableField(value = "cd")
    @JSONField(name = "cd")
    @JsonProperty("cd")
    private Double cd;
    /**
     * 半勤
     */
    @TableField(value = "bq")
    @JSONField(name = "bq")
    @JsonProperty("bq")
    private Double bq;
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
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 结婚假
     */
    @TableField(value = "jh")
    @JSONField(name = "jh")
    @JsonProperty("jh")
    private Double jh;
    /**
     * 休息日加班
     */
    @TableField(value = "xxrjb")
    @JSONField(name = "xxrjb")
    @JsonProperty("xxrjb")
    private Double xxrjb;
    /**
     * 本月实际出勤天数
     */
    @TableField(value = "sjcqts")
    @JSONField(name = "sjcqts")
    @JsonProperty("sjcqts")
    private Double sjcqts;
    /**
     * 考勤汇总名称
     */
    @TableField(value = "attensummaryname")
    @JSONField(name = "attensummaryname")
    @JsonProperty("attensummaryname")
    private String attensummaryname;
    /**
     * 说明
     */
    @TableField(value = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    private String description;
    /**
     * 产假
     */
    @TableField(value = "cj")
    @JSONField(name = "cj")
    @JsonProperty("cj")
    private Double cj;
    /**
     * 其他
     */
    @TableField(value = "qt")
    @JSONField(name = "qt")
    @JsonProperty("qt")
    private Double qt;
    /**
     * 迟到（次）
     */
    @TableField(value = "cdc")
    @JSONField(name = "cdc")
    @JsonProperty("cdc")
    private Integer cdc;
    /**
     * 考勤汇总标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attensummaryid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attensummaryid")
    @JsonProperty("attensummaryid")
    private String attensummaryid;
    /**
     * 结束日期
     */
    @TableField(value = "enddate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "enddate" , format="yyyy-MM-dd")
    @JsonProperty("enddate")
    private Timestamp enddate;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 孕期假
     */
    @TableField(value = "yq")
    @JSONField(name = "yq")
    @JsonProperty("yq")
    private Double yq;
    /**
     * 其他带薪假
     */
    @TableField(value = "qtdxj")
    @JSONField(name = "qtdxj")
    @JsonProperty("qtdxj")
    private Double qtdxj;
    /**
     * 实到（天）
     */
    @TableField(value = "sdt")
    @JSONField(name = "sdt")
    @JsonProperty("sdt")
    private Double sdt;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 身份证号
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工姓名
     */
    @TableField(value = "pimpersonname")
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
     * 部门/项目部
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [工伤假]
     */
    public void setGs(Double gs){
        this.gs = gs ;
        this.modify("gs",gs);
    }

    /**
     * 设置 [早退（分）]
     */
    public void setZtf(Double ztf){
        this.ztf = ztf ;
        this.modify("ztf",ztf);
    }

    /**
     * 设置 [病假]
     */
    public void setBj(Double bj){
        this.bj = bj ;
        this.modify("bj",bj);
    }

    /**
     * 设置 [出差]
     */
    public void setCc(Double cc){
        this.cc = cc ;
        this.modify("cc",cc);
    }

    /**
     * 设置 [开始日期]
     */
    public void setBegindate(Timestamp begindate){
        this.begindate = begindate ;
        this.modify("begindate",begindate);
    }

    /**
     * 格式化日期 [开始日期]
     */
    public String formatBegindate(){
        if (this.begindate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(begindate);
    }
    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [年休假]
     */
    public void setNx(Double nx){
        this.nx = nx ;
        this.modify("nx",nx);
    }

    /**
     * 设置 [旷工]
     */
    public void setKg(Double kg){
        this.kg = kg ;
        this.modify("kg",kg);
    }

    /**
     * 设置 [月份]
     */
    public void setYf(String yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [工作日加班]
     */
    public void setGzrjb(Double gzrjb){
        this.gzrjb = gzrjb ;
        this.modify("gzrjb",gzrjb);
    }

    /**
     * 设置 [计划生育手术假]
     */
    public void setJs(Double js){
        this.js = js ;
        this.modify("js",js);
    }

    /**
     * 设置 [法定假日加班]
     */
    public void setFdjrjb(Double fdjrjb){
        this.fdjrjb = fdjrjb ;
        this.modify("fdjrjb",fdjrjb);
    }

    /**
     * 设置 [迟到（分）]
     */
    public void setCdf(Double cdf){
        this.cdf = cdf ;
        this.modify("cdf",cdf);
    }

    /**
     * 设置 [早退（次）]
     */
    public void setZtc(Integer ztc){
        this.ztc = ztc ;
        this.modify("ztc",ztc);
    }

    /**
     * 设置 [早退]
     */
    public void setZt(Double zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [脱产学习]
     */
    public void setTcxx(Double tcxx){
        this.tcxx = tcxx ;
        this.modify("tcxx",tcxx);
    }

    /**
     * 设置 [部门审核并注明未签到（或缺勤）原因]
     */
    public void setRemarkreason(String remarkreason){
        this.remarkreason = remarkreason ;
        this.modify("remarkreason",remarkreason);
    }

    /**
     * 设置 [本月在沪出勤天数]
     */
    public void setZhts(Double zhts){
        this.zhts = zhts ;
        this.modify("zhts",zhts);
    }

    /**
     * 设置 [调休假]
     */
    public void setTx(Double tx){
        this.tx = tx ;
        this.modify("tx",tx);
    }

    /**
     * 设置 [未签到天数]
     */
    public void setWqdts(Double wqdts){
        this.wqdts = wqdts ;
        this.modify("wqdts",wqdts);
    }

    /**
     * 设置 [哺乳假]
     */
    public void setBr(Double br){
        this.br = br ;
        this.modify("br",br);
    }

    /**
     * 设置 [探亲假]
     */
    public void setTq(Double tq){
        this.tq = tq ;
        this.modify("tq",tq);
    }

    /**
     * 设置 [事假]
     */
    public void setSj(Double sj){
        this.sj = sj ;
        this.modify("sj",sj);
    }

    /**
     * 设置 [全勤]
     */
    public void setQq(Double qq){
        this.qq = qq ;
        this.modify("qq",qq);
    }

    /**
     * 设置 [陪产假]
     */
    public void setPc(Double pc){
        this.pc = pc ;
        this.modify("pc",pc);
    }

    /**
     * 设置 [丧葬假]
     */
    public void setSz(Double sz){
        this.sz = sz ;
        this.modify("sz",sz);
    }

    /**
     * 设置 [迟到]
     */
    public void setCd(Double cd){
        this.cd = cd ;
        this.modify("cd",cd);
    }

    /**
     * 设置 [半勤]
     */
    public void setBq(Double bq){
        this.bq = bq ;
        this.modify("bq",bq);
    }

    /**
     * 设置 [结婚假]
     */
    public void setJh(Double jh){
        this.jh = jh ;
        this.modify("jh",jh);
    }

    /**
     * 设置 [休息日加班]
     */
    public void setXxrjb(Double xxrjb){
        this.xxrjb = xxrjb ;
        this.modify("xxrjb",xxrjb);
    }

    /**
     * 设置 [本月实际出勤天数]
     */
    public void setSjcqts(Double sjcqts){
        this.sjcqts = sjcqts ;
        this.modify("sjcqts",sjcqts);
    }

    /**
     * 设置 [考勤汇总名称]
     */
    public void setAttensummaryname(String attensummaryname){
        this.attensummaryname = attensummaryname ;
        this.modify("attensummaryname",attensummaryname);
    }

    /**
     * 设置 [说明]
     */
    public void setDescription(String description){
        this.description = description ;
        this.modify("description",description);
    }

    /**
     * 设置 [产假]
     */
    public void setCj(Double cj){
        this.cj = cj ;
        this.modify("cj",cj);
    }

    /**
     * 设置 [其他]
     */
    public void setQt(Double qt){
        this.qt = qt ;
        this.modify("qt",qt);
    }

    /**
     * 设置 [迟到（次）]
     */
    public void setCdc(Integer cdc){
        this.cdc = cdc ;
        this.modify("cdc",cdc);
    }

    /**
     * 设置 [结束日期]
     */
    public void setEnddate(Timestamp enddate){
        this.enddate = enddate ;
        this.modify("enddate",enddate);
    }

    /**
     * 格式化日期 [结束日期]
     */
    public String formatEnddate(){
        if (this.enddate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(enddate);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [孕期假]
     */
    public void setYq(Double yq){
        this.yq = yq ;
        this.modify("yq",yq);
    }

    /**
     * 设置 [其他带薪假]
     */
    public void setQtdxj(Double qtdxj){
        this.qtdxj = qtdxj ;
        this.modify("qtdxj",qtdxj);
    }

    /**
     * 设置 [实到（天）]
     */
    public void setSdt(Double sdt){
        this.sdt = sdt ;
        this.modify("sdt",sdt);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [员工姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


