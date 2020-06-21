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
 * 实体[人员信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPERSON",resultMap = "PimPersonResultMap")
public class PimPerson extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 挂职状态
     */
    @TableField(value = "gzzt")
    @JSONField(name = "gzzt")
    @JsonProperty("gzzt")
    private String gzzt;
    /**
     * 证件类型
     */
    @TableField(value = "zjlx")
    @JSONField(name = "zjlx")
    @JsonProperty("zjlx")
    private String zjlx;
    /**
     * 在岗状态
     */
    @TableField(value = "zgzt")
    @JSONField(name = "zgzt")
    @JsonProperty("zgzt")
    private String zgzt;
    /**
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 员工类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 档案学历
     */
    @TableField(value = "daxl")
    @JSONField(name = "daxl")
    @JsonProperty("daxl")
    private String daxl;
    /**
     * 调动日期
     */
    @TableField(value = "transferdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "transferdate" , format="yyyy-MM-dd")
    @JsonProperty("transferdate")
    private Timestamp transferdate;
    /**
     * 爱好特长
     */
    @TableField(value = "ahtc")
    @JSONField(name = "ahtc")
    @JsonProperty("ahtc")
    private String ahtc;
    /**
     * 退休年限颜色
     */
    @TableField(exist = false)
    @JSONField(name = "txnx_color")
    @JsonProperty("txnx_color")
    private String txnxColor;
    /**
     * 任职年龄到期(年)_干部花名册（作废）
     */
    @TableField(value = "rznldq")
    @JSONField(name = "rznldq")
    @JsonProperty("rznldq")
    private String rznldq;
    /**
     * 通讯地址
     */
    @TableField(value = "postaladdress")
    @JSONField(name = "postaladdress")
    @JsonProperty("postaladdress")
    private String postaladdress;
    /**
     * 试用到期时间
     */
    @TableField(value = "sydq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sydq" , format="yyyy-MM-dd")
    @JsonProperty("sydq")
    private Timestamp sydq;
    /**
     * 到局时间
     */
    @TableField(value = "dzjbjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;
    /**
     * 家庭联系人ID
     */
    @TableField(value = "jtlxrid")
    @JSONField(name = "jtlxrid")
    @JsonProperty("jtlxrid")
    private String jtlxrid;
    /**
     * 在岗状态
     */
    @TableField(exist = false)
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;
    /**
     * 岗位到期(月)_干部花名册
     */
    @TableField(value = "postexpiration")
    @JSONField(name = "postexpiration")
    @JsonProperty("postexpiration")
    private String postexpiration;
    /**
     * 籍贯
     */
    @TableField(value = "jg")
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;
    /**
     * 职级
     */
    @TableField(value = "rank")
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 挂职组织
     */
    @TableField(value = "gzzz")
    @JSONField(name = "gzzz")
    @JsonProperty("gzzz")
    private String gzzz;
    /**
     * 上一次职级日期_干部花名册
     */
    @TableField(value = "syczjrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syczjrq" , format="yyyy-MM-dd")
    @JsonProperty("syczjrq")
    private Timestamp syczjrq;
    /**
     * 最高职称
     */
    @TableField(value = "hightitle")
    @JSONField(name = "hightitle")
    @JsonProperty("hightitle")
    private String hightitle;
    /**
     * 挂职开始时间
     */
    @TableField(value = "gzkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;
    /**
     * 审批的养老金额
     */
    @TableField(value = "spdylje")
    @JSONField(name = "spdylje")
    @JsonProperty("spdylje")
    private Double spdylje;
    /**
     * 原员工编号
     */
    @TableField(value = "yygbh")
    @JSONField(name = "yygbh")
    @JsonProperty("yygbh")
    private String yygbh;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 记录所属
     */
    @DEField(defaultValue = "10")
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 员工+编号
     */
    @TableField(exist = false)
    @JSONField(name = "employeeandno")
    @JsonProperty("employeeandno")
    private String employeeandno;
    /**
     * 是否属于领导班子
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isleaderteam")
    @JSONField(name = "isleaderteam")
    @JsonProperty("isleaderteam")
    private Integer isleaderteam;
    /**
     * 列入黑名单
     */
    @TableField(value = "hmd")
    @JSONField(name = "hmd")
    @JsonProperty("hmd")
    private Integer hmd;
    /**
     * 档案出生日期
     */
    @TableField(value = "dacsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dacsrq" , format="yyyy-MM-dd")
    @JsonProperty("dacsrq")
    private Timestamp dacsrq;
    /**
     * 健康状况
     */
    @TableField(value = "jkzk")
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;
    /**
     * 岗位状态
     */
    @TableField(value = "gwzt")
    @JSONField(name = "gwzt")
    @JsonProperty("gwzt")
    private String gwzt;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 到本单位时间
     */
    @TableField(value = "dbdwsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;
    /**
     * 执业资格_干部花名册
     */
    @TableField(value = "zyzg")
    @JSONField(name = "zyzg")
    @JsonProperty("zyzg")
    private String zyzg;
    /**
     * 出生地
     */
    @TableField(value = "csd")
    @JSONField(name = "csd")
    @JsonProperty("csd")
    private String csd;
    /**
     * 家庭联系人电话
     */
    @TableField(value = "jtlxrdh")
    @JSONField(name = "jtlxrdh")
    @JsonProperty("jtlxrdh")
    private String jtlxrdh;
    /**
     * 第一学历毕业时间_干部花名册
     */
    @TableField(value = "dyxlbysj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dyxlbysj" , format="yyyy-MM-dd")
    @JsonProperty("dyxlbysj")
    private Timestamp dyxlbysj;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 职级年限_干部花名册
     */
    @TableField(value = "zjnx")
    @JSONField(name = "zjnx")
    @JsonProperty("zjnx")
    private Double zjnx;
    /**
     * 任职年龄到期时间
     */
    @TableField(value = "rzdq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzdq" , format="yyyy-MM-dd")
    @JsonProperty("rzdq")
    private Timestamp rzdq;
    /**
     * 户籍所在地
     */
    @TableField(value = "hjszd")
    @JSONField(name = "hjszd")
    @JsonProperty("hjszd")
    private String hjszd;
    /**
     * 挂职结束时间
     */
    @TableField(value = "gzjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;
    /**
     * 专业技术职务
     */
    @TableField(exist = false)
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;
    /**
     * 是否内部返聘
     */
    @TableField(value = "sfnbfp")
    @JSONField(name = "sfnbfp")
    @JsonProperty("sfnbfp")
    private Integer sfnbfp;
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
     * 入党时间
     */
    @TableField(value = "rdsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;
    /**
     * 身份证年龄（废除）
     */
    @TableField(exist = false)
    @JSONField(name = "sfznl")
    @JsonProperty("sfznl")
    private Integer sfznl;
    /**
     * 轮岗开始时间_干部花名册
     */
    @TableField(value = "lgkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lgkssj" , format="yyyy-MM-dd")
    @JsonProperty("lgkssj")
    private Timestamp lgkssj;
    /**
     * 曾用名
     */
    @TableField(value = "cym")
    @JSONField(name = "cym")
    @JsonProperty("cym")
    private String cym;
    /**
     * 试岗状态_干部花名册
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 年龄（废除）
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 入职渠道
     */
    @TableField(value = "rzqd")
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;
    /**
     * 试岗结束日期_干部花名册
     */
    @TableField(value = "sgjsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sgjsrq" , format="yyyy-MM-dd")
    @JsonProperty("sgjsrq")
    private Timestamp sgjsrq;
    /**
     * 政治面貌
     */
    @TableField(value = "zzmm")
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 见习到期时间
     */
    @TableField(value = "jxdq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jxdq" , format="yyyy-MM-dd")
    @JsonProperty("jxdq")
    private Timestamp jxdq;
    /**
     * 考核成绩(近三年)
     */
    @TableField(value = "khcj")
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 超级用户
     */
    @TableField(value = "superuser")
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;
    /**
     * 试岗开始日期_干部花名册
     */
    @TableField(value = "sgksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sgksrq" , format="yyyy-MM-dd")
    @JsonProperty("sgksrq")
    private Timestamp sgksrq;
    /**
     * 数字主键
     */
    @TableField(value = "numcode")
    @JSONField(name = "numcode")
    @JsonProperty("numcode")
    private Integer numcode;
    /**
     * 惩罚影响结束日期_干部花名册
     */
    @TableField(value = "cfyxjsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cfyxjsrq" , format="yyyy-MM-dd")
    @JsonProperty("cfyxjsrq")
    private Timestamp cfyxjsrq;
    /**
     * 执业证书
     */
    @TableField(value = "certtificate")
    @JSONField(name = "certtificate")
    @JsonProperty("certtificate")
    private String certtificate;
    /**
     * 出生日期
     */
    @TableField(value = "csrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 离职日期
     */
    @TableField(value = "leavedate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "leavedate" , format="yyyy-MM-dd")
    @JsonProperty("leavedate")
    private Timestamp leavedate;
    /**
     * 第一学历
     */
    @TableField(value = "firsteducation")
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private String firsteducation;
    /**
     * 工龄
     */
    @TableField(value = "gly")
    @JSONField(name = "gly")
    @JsonProperty("gly")
    private Integer gly;
    /**
     * 见习期“业务导师”
     */
    @TableField(value = "jxsywds")
    @JSONField(name = "jxsywds")
    @JsonProperty("jxsywds")
    private String jxsywds;
    /**
     * 任职年限_干部花名册
     */
    @TableField(value = "rznx")
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Double rznx;
    /**
     * 后取学历毕业院校_干部花名册
     */
    @TableField(value = "hqxlbyyx")
    @JSONField(name = "hqxlbyyx")
    @JsonProperty("hqxlbyyx")
    private String hqxlbyyx;
    /**
     * 员工状态
     */
    @TableField(value = "ygzt")
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 实习/试用期限
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;
    /**
     * 人才序列类型
     */
    @TableField(value = "rcxllx")
    @JSONField(name = "rcxllx")
    @JsonProperty("rcxllx")
    private String rcxllx;
    /**
     * 后取学历所学专业_干部花名册
     */
    @TableField(value = "hqxlsxzy")
    @JSONField(name = "hqxlsxzy")
    @JsonProperty("hqxlsxzy")
    private String hqxlsxzy;
    /**
     * 挂职部门
     */
    @TableField(value = "gzbm")
    @JSONField(name = "gzbm")
    @JsonProperty("gzbm")
    private String gzbm;
    /**
     * 职务日期
     */
    @TableField(value = "zwrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;
    /**
     * 手机号码
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 档案入党时间
     */
    @TableField(value = "dardsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dardsj" , format="yyyy-MM-dd")
    @JsonProperty("dardsj")
    private Timestamp dardsj;
    /**
     * 电子邮箱
     */
    @TableField(value = "dzyx")
    @JSONField(name = "dzyx")
    @JsonProperty("dzyx")
    private String dzyx;
    /**
     * 户口类型
     */
    @TableField(value = "hklx")
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;
    /**
     * 工龄（明年）
     */
    @TableField(value = "gly2")
    @JSONField(name = "gly2")
    @JsonProperty("gly2")
    private Integer gly2;
    /**
     * 退休地
     */
    @TableField(value = "retiplace")
    @JSONField(name = "retiplace")
    @JsonProperty("retiplace")
    private String retiplace;
    /**
     * 最高学历
     */
    @TableField(value = "higheducation")
    @JSONField(name = "higheducation")
    @JsonProperty("higheducation")
    private String higheducation;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 专家类型
     */
    @TableField(value = "zj")
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;
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
     * 婚姻状况
     */
    @TableField(value = "hyzk")
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;
    /**
     * 第一学历所属专业_干部花名册
     */
    @TableField(value = "dyxlsszy")
    @JSONField(name = "dyxlsszy")
    @JsonProperty("dyxlsszy")
    private String dyxlsszy;
    /**
     * 退休时间
     */
    @TableField(value = "txdq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "txdq" , format="yyyy-MM-dd")
    @JsonProperty("txdq")
    private Timestamp txdq;
    /**
     * 门户系统用户id
     */
    @TableField(value = "portaluserid")
    @JSONField(name = "portaluserid")
    @JsonProperty("portaluserid")
    private String portaluserid;
    /**
     * 同步员工信息
     */
    @TableField(value = "sftberp")
    @JSONField(name = "sftberp")
    @JsonProperty("sftberp")
    private String sftberp;
    /**
     * 考核成绩提醒_干部花名册(作废)
     */
    @TableField(value = "khcjtx")
    @JSONField(name = "khcjtx")
    @JsonProperty("khcjtx")
    private Double khcjtx;
    /**
     * 档案参加工作时间
     */
    @TableField(value = "dacjgzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dacjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("dacjgzsj")
    private Timestamp dacjgzsj;
    /**
     * 兼职任职_干部花名册（作废）
     */
    @TableField(value = "jzrz")
    @JSONField(name = "jzrz")
    @JsonProperty("jzrz")
    private String jzrz;
    /**
     * 实际退休时间
     */
    @TableField(value = "sjtxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjtxrq" , format="yyyy-MM-dd")
    @JsonProperty("sjtxrq")
    private Timestamp sjtxrq;
    /**
     * 血型
     */
    @TableField(value = "xx")
    @JSONField(name = "xx")
    @JsonProperty("xx")
    private String xx;
    /**
     * 见习期“思想导师”
     */
    @TableField(value = "jxssxds")
    @JSONField(name = "jxssxds")
    @JsonProperty("jxssxds")
    private String jxssxds;
    /**
     * 第一学历毕业院校_干部花名册
     */
    @TableField(value = "dyxlbyyx")
    @JSONField(name = "dyxlbyyx")
    @JsonProperty("dyxlbyyx")
    private String dyxlbyyx;
    /**
     * 任职时间
     */
    @TableField(value = "rzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzsj" , format="yyyy-MM-dd")
    @JsonProperty("rzsj")
    private Timestamp rzsj;
    /**
     * 退休到期(月)
     */
    @TableField(exist = false)
    @JSONField(name = "txnx")
    @JsonProperty("txnx")
    private String txnx;
    /**
     * 有独生子女证
     */
    @TableField(value = "sfdszn")
    @JSONField(name = "sfdszn")
    @JsonProperty("sfdszn")
    private String sfdszn;
    /**
     * 系统编号
     */
    @TableField(value = "xtbh")
    @JSONField(name = "xtbh")
    @JsonProperty("xtbh")
    private String xtbh;
    /**
     * 员工姓名
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 工作状态
     */
    @TableField(value = "workstate")
    @JSONField(name = "workstate")
    @JsonProperty("workstate")
    private String workstate;
    /**
     * 参加工作时间
     */
    @TableField(value = "cjgzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;
    /**
     * 岗位开始日期
     */
    @TableField(value = "gwksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gwksrq" , format="yyyy-MM-dd")
    @JsonProperty("gwksrq")
    private Timestamp gwksrq;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 到建筑系统时间
     */
    @TableField(value = "tozjdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;
    /**
     * 证件号码
     */
    @TableField(value = "zjhm")
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 人员信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpersonid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 黑名单原因
     */
    @TableField(value = "blacklistreasons")
    @JSONField(name = "blacklistreasons")
    @JsonProperty("blacklistreasons")
    private String blacklistreasons;
    /**
     * 户籍地址
     */
    @TableField(value = "hjdz")
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;
    /**
     * 职务年限_干部花名册
     */
    @TableField(value = "zwnx")
    @JSONField(name = "zwnx")
    @JsonProperty("zwnx")
    private String zwnx;
    /**
     * 入团时间
     */
    @TableField(value = "rtsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rtsj" , format="yyyy-MM-dd")
    @JsonProperty("rtsj")
    private Timestamp rtsj;
    /**
     * 身故原因
     */
    @TableField(value = "sgyy")
    @JSONField(name = "sgyy")
    @JsonProperty("sgyy")
    private String sgyy;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 轮岗年限颜色_干部花名册
     */
    @DEField(name = "lgnx_color")
    @TableField(value = "lgnx_color")
    @JSONField(name = "lgnx_color")
    @JsonProperty("lgnx_color")
    private String lgnxColor;
    /**
     * XX届应届生
     */
    @TableField(value = "yjsnf")
    @JSONField(name = "yjsnf")
    @JsonProperty("yjsnf")
    private String yjsnf;
    /**
     * 职级日期
     */
    @TableField(value = "rankrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rankrq" , format="yyyy-MM-dd")
    @JsonProperty("rankrq")
    private Timestamp rankrq;
    /**
     * 照片
     */
    @TableField(value = "zp")
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;
    /**
     * 轮岗年限_干部花名册
     */
    @TableField(value = "lgnx")
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private String lgnx;
    /**
     * 家庭联系人
     */
    @TableField(value = "jtlxr")
    @JSONField(name = "jtlxr")
    @JsonProperty("jtlxr")
    private String jtlxr;
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
     * 试用期到期时间（停用）
     */
    @TableField(value = "syqdqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syqdqsj" , format="yyyy-MM-dd")
    @JsonProperty("syqdqsj")
    private Timestamp syqdqsj;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 合同签订次数
     */
    @TableField(value = "htqdcs")
    @JSONField(name = "htqdcs")
    @JsonProperty("htqdcs")
    private String htqdcs;
    /**
     * 民族
     */
    @TableField(value = "mz")
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;
    /**
     * 身份证
     */
    @TableField(value = "sfz")
    @JSONField(name = "sfz")
    @JsonProperty("sfz")
    private String sfz;
    /**
     * 任职年龄到期颜色_干部花名册（作废）
     */
    @DEField(name = "rznldq_color")
    @TableField(value = "rznldq_color")
    @JSONField(name = "rznldq_color")
    @JsonProperty("rznldq_color")
    private String rznldqColor;
    /**
     * 异动状态
     */
    @TableField(value = "ydzt")
    @JSONField(name = "ydzt")
    @JsonProperty("ydzt")
    private String ydzt;
    /**
     * 员工编号启用时间
     */
    @TableField(value = "ygbhqysj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ygbhqysj" , format="yyyy-MM-dd")
    @JsonProperty("ygbhqysj")
    private Timestamp ygbhqysj;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 部门排序号
     */
    @TableField(exist = false)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;
    /**
     * 业务导师
     */
    @TableField(value = "pimpersonname3")
    @JSONField(name = "pimpersonname3")
    @JsonProperty("pimpersonname3")
    private String pimpersonname3;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 专业序列类型
     */
    @TableField(exist = false)
    @JSONField(name = "pimmajorsetypename")
    @JsonProperty("pimmajorsetypename")
    private String pimmajorsetypename;
    /**
     * 人才序列
     */
    @TableField(exist = false)
    @JSONField(name = "pcmrcxlname")
    @JsonProperty("pcmrcxlname")
    private String pcmrcxlname;
    /**
     * 思想导师
     */
    @TableField(value = "pimpersonname2")
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;
    /**
     * 组织
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 出生地
     */
    @TableField(exist = false)
    @JSONField(name = "pimcityname")
    @JsonProperty("pimcityname")
    private String pimcityname;
    /**
     * 部门组织类型
     */
    @TableField(value = "orgtype")
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 人才序列标识
     */
    @TableField(value = "pcmrcxlid")
    @JSONField(name = "pcmrcxlid")
    @JsonProperty("pcmrcxlid")
    private String pcmrcxlid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid2")
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;
    /**
     * 市标识
     */
    @TableField(value = "pimcityid")
    @JSONField(name = "pimcityid")
    @JsonProperty("pimcityid")
    private String pimcityid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 见习生员工转正记录引用明细标识
     */
    @TableField(value = "pcmjxsygzzjlmxid")
    @JSONField(name = "pcmjxsygzzjlmxid")
    @JsonProperty("pcmjxsygzzjlmxid")
    private String pcmjxsygzzjlmxid;
    /**
     * 专业序列类型标识
     */
    @TableField(value = "pimmajorsetypeid")
    @JSONField(name = "pimmajorsetypeid")
    @JsonProperty("pimmajorsetypeid")
    private String pimmajorsetypeid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid3")
    @JSONField(name = "pimpersonid3")
    @JsonProperty("pimpersonid3")
    private String pimpersonid3;

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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx pcmjxsygzzjlmx;

    /**
     * 人才序列
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmRcxl pcmrcxl;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimCity pimcity;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimMajorSetype pimmajorsetype;

    /**
     * 思想导师
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2;

    /**
     * 业务导师
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson3;



    /**
     * 设置 [挂职状态]
     */
    public void setGzzt(String gzzt){
        this.gzzt = gzzt ;
        this.modify("gzzt",gzzt);
    }

    /**
     * 设置 [证件类型]
     */
    public void setZjlx(String zjlx){
        this.zjlx = zjlx ;
        this.modify("zjlx",zjlx);
    }

    /**
     * 设置 [在岗状态]
     */
    public void setZgzt(String zgzt){
        this.zgzt = zgzt ;
        this.modify("zgzt",zgzt);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [员工类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [档案学历]
     */
    public void setDaxl(String daxl){
        this.daxl = daxl ;
        this.modify("daxl",daxl);
    }

    /**
     * 设置 [调动日期]
     */
    public void setTransferdate(Timestamp transferdate){
        this.transferdate = transferdate ;
        this.modify("transferdate",transferdate);
    }

    /**
     * 格式化日期 [调动日期]
     */
    public String formatTransferdate(){
        if (this.transferdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(transferdate);
    }
    /**
     * 设置 [爱好特长]
     */
    public void setAhtc(String ahtc){
        this.ahtc = ahtc ;
        this.modify("ahtc",ahtc);
    }

    /**
     * 设置 [任职年龄到期(年)_干部花名册（作废）]
     */
    public void setRznldq(String rznldq){
        this.rznldq = rznldq ;
        this.modify("rznldq",rznldq);
    }

    /**
     * 设置 [通讯地址]
     */
    public void setPostaladdress(String postaladdress){
        this.postaladdress = postaladdress ;
        this.modify("postaladdress",postaladdress);
    }

    /**
     * 设置 [试用到期时间]
     */
    public void setSydq(Timestamp sydq){
        this.sydq = sydq ;
        this.modify("sydq",sydq);
    }

    /**
     * 格式化日期 [试用到期时间]
     */
    public String formatSydq(){
        if (this.sydq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sydq);
    }
    /**
     * 设置 [到局时间]
     */
    public void setDzjbjsj(Timestamp dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 格式化日期 [到局时间]
     */
    public String formatDzjbjsj(){
        if (this.dzjbjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dzjbjsj);
    }
    /**
     * 设置 [家庭联系人ID]
     */
    public void setJtlxrid(String jtlxrid){
        this.jtlxrid = jtlxrid ;
        this.modify("jtlxrid",jtlxrid);
    }

    /**
     * 设置 [岗位到期(月)_干部花名册]
     */
    public void setPostexpiration(String postexpiration){
        this.postexpiration = postexpiration ;
        this.modify("postexpiration",postexpiration);
    }

    /**
     * 设置 [籍贯]
     */
    public void setJg(String jg){
        this.jg = jg ;
        this.modify("jg",jg);
    }

    /**
     * 设置 [职级]
     */
    public void setRank(String rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [挂职组织]
     */
    public void setGzzz(String gzzz){
        this.gzzz = gzzz ;
        this.modify("gzzz",gzzz);
    }

    /**
     * 设置 [上一次职级日期_干部花名册]
     */
    public void setSyczjrq(Timestamp syczjrq){
        this.syczjrq = syczjrq ;
        this.modify("syczjrq",syczjrq);
    }

    /**
     * 格式化日期 [上一次职级日期_干部花名册]
     */
    public String formatSyczjrq(){
        if (this.syczjrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(syczjrq);
    }
    /**
     * 设置 [最高职称]
     */
    public void setHightitle(String hightitle){
        this.hightitle = hightitle ;
        this.modify("hightitle",hightitle);
    }

    /**
     * 设置 [挂职开始时间]
     */
    public void setGzkssj(Timestamp gzkssj){
        this.gzkssj = gzkssj ;
        this.modify("gzkssj",gzkssj);
    }

    /**
     * 格式化日期 [挂职开始时间]
     */
    public String formatGzkssj(){
        if (this.gzkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(gzkssj);
    }
    /**
     * 设置 [审批的养老金额]
     */
    public void setSpdylje(Double spdylje){
        this.spdylje = spdylje ;
        this.modify("spdylje",spdylje);
    }

    /**
     * 设置 [原员工编号]
     */
    public void setYygbh(String yygbh){
        this.yygbh = yygbh ;
        this.modify("yygbh",yygbh);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [是否属于领导班子]
     */
    public void setIsleaderteam(Integer isleaderteam){
        this.isleaderteam = isleaderteam ;
        this.modify("isleaderteam",isleaderteam);
    }

    /**
     * 设置 [列入黑名单]
     */
    public void setHmd(Integer hmd){
        this.hmd = hmd ;
        this.modify("hmd",hmd);
    }

    /**
     * 设置 [档案出生日期]
     */
    public void setDacsrq(Timestamp dacsrq){
        this.dacsrq = dacsrq ;
        this.modify("dacsrq",dacsrq);
    }

    /**
     * 格式化日期 [档案出生日期]
     */
    public String formatDacsrq(){
        if (this.dacsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dacsrq);
    }
    /**
     * 设置 [健康状况]
     */
    public void setJkzk(String jkzk){
        this.jkzk = jkzk ;
        this.modify("jkzk",jkzk);
    }

    /**
     * 设置 [岗位状态]
     */
    public void setGwzt(String gwzt){
        this.gwzt = gwzt ;
        this.modify("gwzt",gwzt);
    }

    /**
     * 设置 [到本单位时间]
     */
    public void setDbdwsj(Timestamp dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 格式化日期 [到本单位时间]
     */
    public String formatDbdwsj(){
        if (this.dbdwsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dbdwsj);
    }
    /**
     * 设置 [执业资格_干部花名册]
     */
    public void setZyzg(String zyzg){
        this.zyzg = zyzg ;
        this.modify("zyzg",zyzg);
    }

    /**
     * 设置 [出生地]
     */
    public void setCsd(String csd){
        this.csd = csd ;
        this.modify("csd",csd);
    }

    /**
     * 设置 [家庭联系人电话]
     */
    public void setJtlxrdh(String jtlxrdh){
        this.jtlxrdh = jtlxrdh ;
        this.modify("jtlxrdh",jtlxrdh);
    }

    /**
     * 设置 [第一学历毕业时间_干部花名册]
     */
    public void setDyxlbysj(Timestamp dyxlbysj){
        this.dyxlbysj = dyxlbysj ;
        this.modify("dyxlbysj",dyxlbysj);
    }

    /**
     * 格式化日期 [第一学历毕业时间_干部花名册]
     */
    public String formatDyxlbysj(){
        if (this.dyxlbysj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dyxlbysj);
    }
    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [职级年限_干部花名册]
     */
    public void setZjnx(Double zjnx){
        this.zjnx = zjnx ;
        this.modify("zjnx",zjnx);
    }

    /**
     * 设置 [任职年龄到期时间]
     */
    public void setRzdq(Timestamp rzdq){
        this.rzdq = rzdq ;
        this.modify("rzdq",rzdq);
    }

    /**
     * 格式化日期 [任职年龄到期时间]
     */
    public String formatRzdq(){
        if (this.rzdq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzdq);
    }
    /**
     * 设置 [户籍所在地]
     */
    public void setHjszd(String hjszd){
        this.hjszd = hjszd ;
        this.modify("hjszd",hjszd);
    }

    /**
     * 设置 [挂职结束时间]
     */
    public void setGzjssj(Timestamp gzjssj){
        this.gzjssj = gzjssj ;
        this.modify("gzjssj",gzjssj);
    }

    /**
     * 格式化日期 [挂职结束时间]
     */
    public String formatGzjssj(){
        if (this.gzjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(gzjssj);
    }
    /**
     * 设置 [是否内部返聘]
     */
    public void setSfnbfp(Integer sfnbfp){
        this.sfnbfp = sfnbfp ;
        this.modify("sfnbfp",sfnbfp);
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
     * 设置 [轮岗开始时间_干部花名册]
     */
    public void setLgkssj(Timestamp lgkssj){
        this.lgkssj = lgkssj ;
        this.modify("lgkssj",lgkssj);
    }

    /**
     * 格式化日期 [轮岗开始时间_干部花名册]
     */
    public String formatLgkssj(){
        if (this.lgkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(lgkssj);
    }
    /**
     * 设置 [曾用名]
     */
    public void setCym(String cym){
        this.cym = cym ;
        this.modify("cym",cym);
    }

    /**
     * 设置 [试岗状态_干部花名册]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [年龄（废除）]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [入职渠道]
     */
    public void setRzqd(String rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [试岗结束日期_干部花名册]
     */
    public void setSgjsrq(Timestamp sgjsrq){
        this.sgjsrq = sgjsrq ;
        this.modify("sgjsrq",sgjsrq);
    }

    /**
     * 格式化日期 [试岗结束日期_干部花名册]
     */
    public String formatSgjsrq(){
        if (this.sgjsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sgjsrq);
    }
    /**
     * 设置 [政治面貌]
     */
    public void setZzmm(String zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [见习到期时间]
     */
    public void setJxdq(Timestamp jxdq){
        this.jxdq = jxdq ;
        this.modify("jxdq",jxdq);
    }

    /**
     * 格式化日期 [见习到期时间]
     */
    public String formatJxdq(){
        if (this.jxdq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jxdq);
    }
    /**
     * 设置 [考核成绩(近三年)]
     */
    public void setKhcj(String khcj){
        this.khcj = khcj ;
        this.modify("khcj",khcj);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [超级用户]
     */
    public void setSuperuser(Integer superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
    }

    /**
     * 设置 [试岗开始日期_干部花名册]
     */
    public void setSgksrq(Timestamp sgksrq){
        this.sgksrq = sgksrq ;
        this.modify("sgksrq",sgksrq);
    }

    /**
     * 格式化日期 [试岗开始日期_干部花名册]
     */
    public String formatSgksrq(){
        if (this.sgksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sgksrq);
    }
    /**
     * 设置 [数字主键]
     */
    public void setNumcode(Integer numcode){
        this.numcode = numcode ;
        this.modify("numcode",numcode);
    }

    /**
     * 设置 [惩罚影响结束日期_干部花名册]
     */
    public void setCfyxjsrq(Timestamp cfyxjsrq){
        this.cfyxjsrq = cfyxjsrq ;
        this.modify("cfyxjsrq",cfyxjsrq);
    }

    /**
     * 格式化日期 [惩罚影响结束日期_干部花名册]
     */
    public String formatCfyxjsrq(){
        if (this.cfyxjsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cfyxjsrq);
    }
    /**
     * 设置 [执业证书]
     */
    public void setCerttificate(String certtificate){
        this.certtificate = certtificate ;
        this.modify("certtificate",certtificate);
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
     * 设置 [离职日期]
     */
    public void setLeavedate(Timestamp leavedate){
        this.leavedate = leavedate ;
        this.modify("leavedate",leavedate);
    }

    /**
     * 格式化日期 [离职日期]
     */
    public String formatLeavedate(){
        if (this.leavedate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(leavedate);
    }
    /**
     * 设置 [第一学历]
     */
    public void setFirsteducation(String firsteducation){
        this.firsteducation = firsteducation ;
        this.modify("firsteducation",firsteducation);
    }

    /**
     * 设置 [工龄]
     */
    public void setGly(Integer gly){
        this.gly = gly ;
        this.modify("gly",gly);
    }

    /**
     * 设置 [见习期“业务导师”]
     */
    public void setJxsywds(String jxsywds){
        this.jxsywds = jxsywds ;
        this.modify("jxsywds",jxsywds);
    }

    /**
     * 设置 [任职年限_干部花名册]
     */
    public void setRznx(Double rznx){
        this.rznx = rznx ;
        this.modify("rznx",rznx);
    }

    /**
     * 设置 [后取学历毕业院校_干部花名册]
     */
    public void setHqxlbyyx(String hqxlbyyx){
        this.hqxlbyyx = hqxlbyyx ;
        this.modify("hqxlbyyx",hqxlbyyx);
    }

    /**
     * 设置 [员工状态]
     */
    public void setYgzt(String ygzt){
        this.ygzt = ygzt ;
        this.modify("ygzt",ygzt);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [实习/试用期限]
     */
    public void setDuration(String duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [人才序列类型]
     */
    public void setRcxllx(String rcxllx){
        this.rcxllx = rcxllx ;
        this.modify("rcxllx",rcxllx);
    }

    /**
     * 设置 [后取学历所学专业_干部花名册]
     */
    public void setHqxlsxzy(String hqxlsxzy){
        this.hqxlsxzy = hqxlsxzy ;
        this.modify("hqxlsxzy",hqxlsxzy);
    }

    /**
     * 设置 [挂职部门]
     */
    public void setGzbm(String gzbm){
        this.gzbm = gzbm ;
        this.modify("gzbm",gzbm);
    }

    /**
     * 设置 [职务日期]
     */
    public void setZwrq(Timestamp zwrq){
        this.zwrq = zwrq ;
        this.modify("zwrq",zwrq);
    }

    /**
     * 格式化日期 [职务日期]
     */
    public String formatZwrq(){
        if (this.zwrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zwrq);
    }
    /**
     * 设置 [手机号码]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [档案入党时间]
     */
    public void setDardsj(Timestamp dardsj){
        this.dardsj = dardsj ;
        this.modify("dardsj",dardsj);
    }

    /**
     * 格式化日期 [档案入党时间]
     */
    public String formatDardsj(){
        if (this.dardsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dardsj);
    }
    /**
     * 设置 [电子邮箱]
     */
    public void setDzyx(String dzyx){
        this.dzyx = dzyx ;
        this.modify("dzyx",dzyx);
    }

    /**
     * 设置 [户口类型]
     */
    public void setHklx(String hklx){
        this.hklx = hklx ;
        this.modify("hklx",hklx);
    }

    /**
     * 设置 [工龄（明年）]
     */
    public void setGly2(Integer gly2){
        this.gly2 = gly2 ;
        this.modify("gly2",gly2);
    }

    /**
     * 设置 [退休地]
     */
    public void setRetiplace(String retiplace){
        this.retiplace = retiplace ;
        this.modify("retiplace",retiplace);
    }

    /**
     * 设置 [最高学历]
     */
    public void setHigheducation(String higheducation){
        this.higheducation = higheducation ;
        this.modify("higheducation",higheducation);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [专家类型]
     */
    public void setZj(String zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [婚姻状况]
     */
    public void setHyzk(String hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }

    /**
     * 设置 [第一学历所属专业_干部花名册]
     */
    public void setDyxlsszy(String dyxlsszy){
        this.dyxlsszy = dyxlsszy ;
        this.modify("dyxlsszy",dyxlsszy);
    }

    /**
     * 设置 [退休时间]
     */
    public void setTxdq(Timestamp txdq){
        this.txdq = txdq ;
        this.modify("txdq",txdq);
    }

    /**
     * 格式化日期 [退休时间]
     */
    public String formatTxdq(){
        if (this.txdq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(txdq);
    }
    /**
     * 设置 [门户系统用户id]
     */
    public void setPortaluserid(String portaluserid){
        this.portaluserid = portaluserid ;
        this.modify("portaluserid",portaluserid);
    }

    /**
     * 设置 [同步员工信息]
     */
    public void setSftberp(String sftberp){
        this.sftberp = sftberp ;
        this.modify("sftberp",sftberp);
    }

    /**
     * 设置 [考核成绩提醒_干部花名册(作废)]
     */
    public void setKhcjtx(Double khcjtx){
        this.khcjtx = khcjtx ;
        this.modify("khcjtx",khcjtx);
    }

    /**
     * 设置 [档案参加工作时间]
     */
    public void setDacjgzsj(Timestamp dacjgzsj){
        this.dacjgzsj = dacjgzsj ;
        this.modify("dacjgzsj",dacjgzsj);
    }

    /**
     * 格式化日期 [档案参加工作时间]
     */
    public String formatDacjgzsj(){
        if (this.dacjgzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dacjgzsj);
    }
    /**
     * 设置 [兼职任职_干部花名册（作废）]
     */
    public void setJzrz(String jzrz){
        this.jzrz = jzrz ;
        this.modify("jzrz",jzrz);
    }

    /**
     * 设置 [实际退休时间]
     */
    public void setSjtxrq(Timestamp sjtxrq){
        this.sjtxrq = sjtxrq ;
        this.modify("sjtxrq",sjtxrq);
    }

    /**
     * 格式化日期 [实际退休时间]
     */
    public String formatSjtxrq(){
        if (this.sjtxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sjtxrq);
    }
    /**
     * 设置 [血型]
     */
    public void setXx(String xx){
        this.xx = xx ;
        this.modify("xx",xx);
    }

    /**
     * 设置 [见习期“思想导师”]
     */
    public void setJxssxds(String jxssxds){
        this.jxssxds = jxssxds ;
        this.modify("jxssxds",jxssxds);
    }

    /**
     * 设置 [第一学历毕业院校_干部花名册]
     */
    public void setDyxlbyyx(String dyxlbyyx){
        this.dyxlbyyx = dyxlbyyx ;
        this.modify("dyxlbyyx",dyxlbyyx);
    }

    /**
     * 设置 [任职时间]
     */
    public void setRzsj(Timestamp rzsj){
        this.rzsj = rzsj ;
        this.modify("rzsj",rzsj);
    }

    /**
     * 格式化日期 [任职时间]
     */
    public String formatRzsj(){
        if (this.rzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzsj);
    }
    /**
     * 设置 [有独生子女证]
     */
    public void setSfdszn(String sfdszn){
        this.sfdszn = sfdszn ;
        this.modify("sfdszn",sfdszn);
    }

    /**
     * 设置 [系统编号]
     */
    public void setXtbh(String xtbh){
        this.xtbh = xtbh ;
        this.modify("xtbh",xtbh);
    }

    /**
     * 设置 [员工姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [工作状态]
     */
    public void setWorkstate(String workstate){
        this.workstate = workstate ;
        this.modify("workstate",workstate);
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
     * 设置 [岗位开始日期]
     */
    public void setGwksrq(Timestamp gwksrq){
        this.gwksrq = gwksrq ;
        this.modify("gwksrq",gwksrq);
    }

    /**
     * 格式化日期 [岗位开始日期]
     */
    public String formatGwksrq(){
        if (this.gwksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(gwksrq);
    }
    /**
     * 设置 [到建筑系统时间]
     */
    public void setTozjdate(Timestamp tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 格式化日期 [到建筑系统时间]
     */
    public String formatTozjdate(){
        if (this.tozjdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tozjdate);
    }
    /**
     * 设置 [证件号码]
     */
    public void setZjhm(String zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [黑名单原因]
     */
    public void setBlacklistreasons(String blacklistreasons){
        this.blacklistreasons = blacklistreasons ;
        this.modify("blacklistreasons",blacklistreasons);
    }

    /**
     * 设置 [户籍地址]
     */
    public void setHjdz(String hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [职务年限_干部花名册]
     */
    public void setZwnx(String zwnx){
        this.zwnx = zwnx ;
        this.modify("zwnx",zwnx);
    }

    /**
     * 设置 [入团时间]
     */
    public void setRtsj(Timestamp rtsj){
        this.rtsj = rtsj ;
        this.modify("rtsj",rtsj);
    }

    /**
     * 格式化日期 [入团时间]
     */
    public String formatRtsj(){
        if (this.rtsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rtsj);
    }
    /**
     * 设置 [身故原因]
     */
    public void setSgyy(String sgyy){
        this.sgyy = sgyy ;
        this.modify("sgyy",sgyy);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [轮岗年限颜色_干部花名册]
     */
    public void setLgnxColor(String lgnxColor){
        this.lgnxColor = lgnxColor ;
        this.modify("lgnx_color",lgnxColor);
    }

    /**
     * 设置 [XX届应届生]
     */
    public void setYjsnf(String yjsnf){
        this.yjsnf = yjsnf ;
        this.modify("yjsnf",yjsnf);
    }

    /**
     * 设置 [职级日期]
     */
    public void setRankrq(Timestamp rankrq){
        this.rankrq = rankrq ;
        this.modify("rankrq",rankrq);
    }

    /**
     * 格式化日期 [职级日期]
     */
    public String formatRankrq(){
        if (this.rankrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rankrq);
    }
    /**
     * 设置 [照片]
     */
    public void setZp(String zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [轮岗年限_干部花名册]
     */
    public void setLgnx(String lgnx){
        this.lgnx = lgnx ;
        this.modify("lgnx",lgnx);
    }

    /**
     * 设置 [家庭联系人]
     */
    public void setJtlxr(String jtlxr){
        this.jtlxr = jtlxr ;
        this.modify("jtlxr",jtlxr);
    }

    /**
     * 设置 [试用期到期时间（停用）]
     */
    public void setSyqdqsj(Timestamp syqdqsj){
        this.syqdqsj = syqdqsj ;
        this.modify("syqdqsj",syqdqsj);
    }

    /**
     * 格式化日期 [试用期到期时间（停用）]
     */
    public String formatSyqdqsj(){
        if (this.syqdqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(syqdqsj);
    }
    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [合同签订次数]
     */
    public void setHtqdcs(String htqdcs){
        this.htqdcs = htqdcs ;
        this.modify("htqdcs",htqdcs);
    }

    /**
     * 设置 [民族]
     */
    public void setMz(String mz){
        this.mz = mz ;
        this.modify("mz",mz);
    }

    /**
     * 设置 [身份证]
     */
    public void setSfz(String sfz){
        this.sfz = sfz ;
        this.modify("sfz",sfz);
    }

    /**
     * 设置 [任职年龄到期颜色_干部花名册（作废）]
     */
    public void setRznldqColor(String rznldqColor){
        this.rznldqColor = rznldqColor ;
        this.modify("rznldq_color",rznldqColor);
    }

    /**
     * 设置 [异动状态]
     */
    public void setYdzt(String ydzt){
        this.ydzt = ydzt ;
        this.modify("ydzt",ydzt);
    }

    /**
     * 设置 [员工编号启用时间]
     */
    public void setYgbhqysj(Timestamp ygbhqysj){
        this.ygbhqysj = ygbhqysj ;
        this.modify("ygbhqysj",ygbhqysj);
    }

    /**
     * 格式化日期 [员工编号启用时间]
     */
    public String formatYgbhqysj(){
        if (this.ygbhqysj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ygbhqysj);
    }
    /**
     * 设置 [业务导师]
     */
    public void setPimpersonname3(String pimpersonname3){
        this.pimpersonname3 = pimpersonname3 ;
        this.modify("pimpersonname3",pimpersonname3);
    }

    /**
     * 设置 [思想导师]
     */
    public void setPimpersonname2(String pimpersonname2){
        this.pimpersonname2 = pimpersonname2 ;
        this.modify("pimpersonname2",pimpersonname2);
    }

    /**
     * 设置 [组织]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [部门组织类型]
     */
    public void setOrgtype(String orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [人才序列标识]
     */
    public void setPcmrcxlid(String pcmrcxlid){
        this.pcmrcxlid = pcmrcxlid ;
        this.modify("pcmrcxlid",pcmrcxlid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid2(String pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }

    /**
     * 设置 [市标识]
     */
    public void setPimcityid(String pimcityid){
        this.pimcityid = pimcityid ;
        this.modify("pimcityid",pimcityid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [见习生员工转正记录引用明细标识]
     */
    public void setPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid){
        this.pcmjxsygzzjlmxid = pcmjxsygzzjlmxid ;
        this.modify("pcmjxsygzzjlmxid",pcmjxsygzzjlmxid);
    }

    /**
     * 设置 [专业序列类型标识]
     */
    public void setPimmajorsetypeid(String pimmajorsetypeid){
        this.pimmajorsetypeid = pimmajorsetypeid ;
        this.modify("pimmajorsetypeid",pimmajorsetypeid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid3(String pimpersonid3){
        this.pimpersonid3 = pimpersonid3 ;
        this.modify("pimpersonid3",pimpersonid3);
    }


}


