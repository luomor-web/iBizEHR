package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[干部花名册]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPERSON",resultMap = "PcmGbhmcResultMap")
public class PcmGbhmc extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门排序号
     */
    @TableField(exist = false)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 档案学历
     */
    @TableField(exist = false)
    @JSONField(name = "daxl")
    @JsonProperty("daxl")
    private String daxl;
    /**
     * 任职年龄到期(年)
     */
    @TableField(exist = false)
    @JSONField(name = "rznldq")
    @JsonProperty("rznldq")
    private String rznldq;
    /**
     * 专业技术职务
     */
    @TableField(exist = false)
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;
    /**
     * 是否属于领导班子
     */
    @TableField(exist = false)
    @JSONField(name = "isleaderteam")
    @JsonProperty("isleaderteam")
    private Integer isleaderteam;
    /**
     * 民族
     */
    @TableField(exist = false)
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;
    /**
     * 最高学历
     */
    @TableField(exist = false)
    @JSONField(name = "higheducation")
    @JsonProperty("higheducation")
    private String higheducation;
    /**
     * 执业资格
     */
    @TableField(exist = false)
    @JSONField(name = "zyzg2")
    @JsonProperty("zyzg2")
    private String zyzg2;
    /**
     * 第一学历所属专业
     */
    @TableField(exist = false)
    @JSONField(name = "dyxlsszy2")
    @JsonProperty("dyxlsszy2")
    private String dyxlsszy2;
    /**
     * 试岗状态
     */
    @TableField(exist = false)
    @JSONField(name = "zt2")
    @JsonProperty("zt2")
    private String zt2;
    /**
     * 记录审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 轮岗年限
     */
    @TableField(exist = false)
    @JSONField(name = "lgnx2")
    @JsonProperty("lgnx2")
    private String lgnx2;
    /**
     * 职级日期
     */
    @TableField(exist = false)
    @JSONField(name = "rankrq")
    @JsonProperty("rankrq")
    private Timestamp rankrq;
    /**
     * 任职时间
     */
    @TableField(exist = false)
    @JSONField(name = "rzsj")
    @JsonProperty("rzsj")
    private Timestamp rzsj;
    /**
     * 试岗开始日期
     */
    @TableField(exist = false)
    @JSONField(name = "sgksrq2")
    @JsonProperty("sgksrq2")
    private Timestamp sgksrq2;
    /**
     * 任职年龄到期时间
     */
    @TableField(exist = false)
    @JSONField(name = "rzdq")
    @JsonProperty("rzdq")
    private Timestamp rzdq;
    /**
     * 记录所属
     */
    @TableField(exist = false)
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 档案入党时间
     */
    @TableField(exist = false)
    @JSONField(name = "dardsj")
    @JsonProperty("dardsj")
    private Timestamp dardsj;
    /**
     * 记录管理编号
     */
    @TableField(exist = false)
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 职务日期
     */
    @TableField(exist = false)
    @JSONField(name = "zwrq")
    @JsonProperty("zwrq")
    private Timestamp zwrq;
    /**
     * 惩罚影响结束日期
     */
    @TableField(exist = false)
    @JSONField(name = "cfyxjsrq2")
    @JsonProperty("cfyxjsrq2")
    private Timestamp cfyxjsrq2;
    /**
     * 岗位到期(月)
     */
    @TableField(exist = false)
    @JSONField(name = "postexpiration2")
    @JsonProperty("postexpiration2")
    private String postexpiration2;
    /**
     * 考核成绩提醒
     */
    @TableField(exist = false)
    @JSONField(name = "khcjtx2")
    @JsonProperty("khcjtx2")
    private Double khcjtx2;
    /**
     * 职级年限
     */
    @TableField(exist = false)
    @JSONField(name = "zjnx2")
    @JsonProperty("zjnx2")
    private Double zjnx2;
    /**
     * 后取学历毕业院校
     */
    @TableField(exist = false)
    @JSONField(name = "hqxlbyyx2")
    @JsonProperty("hqxlbyyx2")
    private String hqxlbyyx2;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 部门/项目
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 兼职任职
     */
    @TableField(exist = false)
    @JSONField(name = "jzrz2")
    @JsonProperty("jzrz2")
    private String jzrz2;
    /**
     * 任职年龄到期颜色
     */
    @TableField(exist = false)
    @JSONField(name = "rznldq_color")
    @JsonProperty("rznldq_color")
    private String rznldqColor;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 考核成绩
     */
    @TableField(exist = false)
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;
    /**
     * 档案出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "dacsrq")
    @JsonProperty("dacsrq")
    private Timestamp dacsrq;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 性别
     */
    @TableField(exist = false)
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 轮岗年限颜色
     */
    @TableField(exist = false)
    @JSONField(name = "lgnx2_color")
    @JsonProperty("lgnx2_color")
    private String lgnx2Color;
    /**
     * 后取学历所学专业
     */
    @TableField(exist = false)
    @JSONField(name = "hqxlsxzy2")
    @JsonProperty("hqxlsxzy2")
    private String hqxlsxzy2;
    /**
     * 档案参加工作时间
     */
    @TableField(exist = false)
    @JSONField(name = "dacjgzsj")
    @JsonProperty("dacjgzsj")
    private Timestamp dacjgzsj;
    /**
     * 入党时间
     */
    @TableField(exist = false)
    @JSONField(name = "rdsj")
    @JsonProperty("rdsj")
    private Timestamp rdsj;
    /**
     * 轮岗开始时间
     */
    @TableField(exist = false)
    @JSONField(name = "lgkssj2")
    @JsonProperty("lgkssj2")
    private Timestamp lgkssj2;
    /**
     * 上一次职级日期
     */
    @TableField(exist = false)
    @JSONField(name = "syczjrq2")
    @JsonProperty("syczjrq2")
    private Timestamp syczjrq2;
    /**
     * 籍贯
     */
    @TableField(exist = false)
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;
    /**
     * 考核成绩提醒
     */
    @TableField(exist = false)
    @JSONField(name = "khcjtx")
    @JsonProperty("khcjtx")
    private Double khcjtx;
    /**
     * 记录操作者
     */
    @TableField(exist = false)
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 人员信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpersonid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 任职年限
     */
    @TableField(exist = false)
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Double rznx;
    /**
     * 任职年限
     */
    @TableField(exist = false)
    @JSONField(name = "rznx2")
    @JsonProperty("rznx2")
    private Double rznx2;
    /**
     * 部门组织类型
     */
    @TableField(exist = false)
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;
    /**
     * 入团时间
     */
    @TableField(exist = false)
    @JSONField(name = "rtsj")
    @JsonProperty("rtsj")
    private Timestamp rtsj;
    /**
     * 政治面貌
     */
    @TableField(exist = false)
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 第一学历
     */
    @TableField(exist = false)
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private String firsteducation;
    /**
     * 到局时间
     */
    @TableField(exist = false)
    @JSONField(name = "dzjbjsj")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 职务年限
     */
    @TableField(exist = false)
    @JSONField(name = "zwnx2")
    @JsonProperty("zwnx2")
    private String zwnx2;
    /**
     * 第一学历毕业时间
     */
    @TableField(exist = false)
    @JSONField(name = "dyxlbysj2")
    @JsonProperty("dyxlbysj2")
    private Timestamp dyxlbysj2;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 上一次职级日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syczjrq" , format="yyyy-MM-dd")
    @JsonProperty("syczjrq")
    private Timestamp syczjrq;
    /**
     * 参加工作时间
     */
    @TableField(exist = false)
    @JSONField(name = "cjgzsj")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;
    /**
     * 试岗结束日期
     */
    @TableField(exist = false)
    @JSONField(name = "sgjsrq2")
    @JsonProperty("sgjsrq2")
    private Timestamp sgjsrq2;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 第一学历毕业院校
     */
    @TableField(exist = false)
    @JSONField(name = "dyxlbyyx2")
    @JsonProperty("dyxlbyyx2")
    private String dyxlbyyx2;
    /**
     * 在岗状态
     */
    @TableField(exist = false)
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;




}


