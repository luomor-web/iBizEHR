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
 * 实体[应聘者基本信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMPROFILE",resultMap = "PcmProfileResultMap")
public class PcmProfile extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位类别
     */
    @TableField(value = "gwlb")
    @JSONField(name = "gwlb")
    @JsonProperty("gwlb")
    private String gwlb;
    /**
     * 专业名称
     */
    @DEField(name = "r_lastdiscipline")
    @TableField(value = "r_lastdiscipline")
    @JSONField(name = "r_lastdiscipline")
    @JsonProperty("r_lastdiscipline")
    private String rLastdiscipline;
    /**
     * 入党时间
     */
    @TableField(value = "rdsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;
    /**
     * 外部组织机构代码
     */
    @TableField(value = "wbzzjgdm")
    @JSONField(name = "wbzzjgdm")
    @JsonProperty("wbzzjgdm")
    private String wbzzjgdm;
    /**
     * 血型
     */
    @TableField(value = "bloodtype")
    @JSONField(name = "bloodtype")
    @JsonProperty("bloodtype")
    private String bloodtype;
    /**
     * 体检情况
     */
    @TableField(value = "tjqk")
    @JSONField(name = "tjqk")
    @JsonProperty("tjqk")
    private String tjqk;
    /**
     * 是否211
     */
    @DEField(name = "r_schoolis211")
    @TableField(value = "r_schoolis211")
    @JSONField(name = "r_schoolis211")
    @JsonProperty("r_schoolis211")
    private String rSchoolis211;
    /**
     * 社招引进条件
     */
    @TableField(value = "szyjtj")
    @JSONField(name = "szyjtj")
    @JsonProperty("szyjtj")
    private String szyjtj;
    /**
     * 应聘者ID（北森）
     */
    @TableField(value = "applicantid")
    @JSONField(name = "applicantid")
    @JsonProperty("applicantid")
    private String applicantid;
    /**
     * 是否985
     */
    @DEField(name = "r_schoolis985")
    @TableField(value = "r_schoolis985")
    @JSONField(name = "r_schoolis985")
    @JsonProperty("r_schoolis985")
    private String rSchoolis985;
    /**
     * 邮政编码
     */
    @TableField(value = "yzbm")
    @JSONField(name = "yzbm")
    @JsonProperty("yzbm")
    private String yzbm;
    /**
     * 现居住地
     */
    @TableField(value = "residencestate")
    @JSONField(name = "residencestate")
    @JsonProperty("residencestate")
    private String residencestate;
    /**
     * 一级学科
     */
    @TableField(value = "xkml")
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;
    /**
     * 局初审意见原因
     */
    @TableField(value = "jzpspyjyy")
    @JSONField(name = "jzpspyjyy")
    @JsonProperty("jzpspyjyy")
    private String jzpspyjyy;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 操作2
     */
    @DEField(defaultValue = "1")
    @TableField(value = "cz2")
    @JSONField(name = "cz2")
    @JsonProperty("cz2")
    private String cz2;
    /**
     * 年份
     */
    @TableField(value = "nf")
    @JSONField(name = "nf")
    @JsonProperty("nf")
    private String nf;
    /**
     * 简历状态
     */
    @TableField(value = "phaseinfo")
    @JSONField(name = "phaseinfo")
    @JsonProperty("phaseinfo")
    private String phaseinfo;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 挂职开始时间
     */
    @TableField(value = "gzkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;
    /**
     * 拟签订劳动合同期
     */
    @TableField(value = "nqdldhtqx")
    @JSONField(name = "nqdldhtqx")
    @JsonProperty("nqdldhtqx")
    private String nqdldhtqx;
    /**
     * 员工类型审核规则
     */
    @TableField(value = "yglxshgz")
    @JSONField(name = "yglxshgz")
    @JsonProperty("yglxshgz")
    private String yglxshgz;
    /**
     * 最高学位
     */
    @TableField(value = "highestdegree")
    @JSONField(name = "highestdegree")
    @JsonProperty("highestdegree")
    private String highestdegree;
    /**
     * 姓名
     */
    @TableField(value = "pcmprofilename")
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 入职渠道
     */
    @TableField(value = "rzqd")
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;
    /**
     * 曾用名
     */
    @TableField(value = "cym")
    @JSONField(name = "cym")
    @JsonProperty("cym")
    private String cym;
    /**
     * 户籍所在地
     */
    @TableField(value = "rpr")
    @JSONField(name = "rpr")
    @JsonProperty("rpr")
    private String rpr;
    /**
     * 局审批意见原因
     */
    @TableField(value = "jzbspyjyy")
    @JSONField(name = "jzbspyjyy")
    @JsonProperty("jzbspyjyy")
    private String jzbspyjyy;
    /**
     * 申报类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 有无重大疾病史
     */
    @TableField(value = "ywzdjbs")
    @JSONField(name = "ywzdjbs")
    @JsonProperty("ywzdjbs")
    private String ywzdjbs;
    /**
     * 爱好/特长
     */
    @TableField(value = "hobbies")
    @JSONField(name = "hobbies")
    @JsonProperty("hobbies")
    private String hobbies;
    /**
     * 应聘者状态（人力上报使用）
     */
    @TableField(exist = false)
    @JSONField(name = "rlsb_ypzzt")
    @JsonProperty("rlsb_ypzzt")
    private String rlsbYpzzt;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 应聘者Elink详情
     */
    @TableField(value = "elinkurl")
    @JSONField(name = "elinkurl")
    @JsonProperty("elinkurl")
    private String elinkurl;
    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;
    /**
     * 外部职务
     */
    @TableField(value = "wbzw")
    @JSONField(name = "wbzw")
    @JsonProperty("wbzw")
    private String wbzw;
    /**
     * 人事档案所在单位
     */
    @TableField(value = "personnelfileplace")
    @JSONField(name = "personnelfileplace")
    @JsonProperty("personnelfileplace")
    private String personnelfileplace;
    /**
     * 状态原因
     */
    @TableField(value = "ztyy")
    @JSONField(name = "ztyy")
    @JsonProperty("ztyy")
    private String ztyy;
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
     * 注册证书
     */
    @TableField(value = "zczs")
    @JSONField(name = "zczs")
    @JsonProperty("zczs")
    private String zczs;
    /**
     * 操作
     */
    @DEField(defaultValue = "1")
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 应聘者编号
     */
    @TableField(value = "cadidateid")
    @JSONField(name = "cadidateid")
    @JsonProperty("cadidateid")
    private String cadidateid;
    /**
     * 黑名单原因
     */
    @TableField(value = "isblacklistreason")
    @JSONField(name = "isblacklistreason")
    @JsonProperty("isblacklistreason")
    private String isblacklistreason;
    /**
     * 签字照片上传
     */
    @TableField(value = "qzfj")
    @JSONField(name = "qzfj")
    @JsonProperty("qzfj")
    private String qzfj;
    /**
     * 最高学历
     */
    @TableField(value = "educationlevel")
    @JSONField(name = "educationlevel")
    @JsonProperty("educationlevel")
    private String educationlevel;
    /**
     * 学位类型
     */
    @TableField(value = "degreetype")
    @JSONField(name = "degreetype")
    @JsonProperty("degreetype")
    private String degreetype;
    /**
     * 户籍地址
     */
    @TableField(value = "hjdz")
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;
    /**
     * 招聘类型
     */
    @TableField(value = "zplx")
    @JSONField(name = "zplx")
    @JsonProperty("zplx")
    private String zplx;
    /**
     * 毕业年份
     */
    @TableField(value = "yjsnf")
    @JSONField(name = "yjsnf")
    @JsonProperty("yjsnf")
    private String yjsnf;
    /**
     * 应聘者状态标识
     */
    @TableField(exist = false)
    @JSONField(name = "ztcode")
    @JsonProperty("ztcode")
    private String ztcode;
    /**
     * 通讯地址
     */
    @TableField(value = "address")
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;
    /**
     * 应聘者ID
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmprofileid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;
    /**
     * 试用期到期时间
     */
    @TableField(value = "syqdqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syqdqsj" , format="yyyy-MM-dd")
    @JsonProperty("syqdqsj")
    private Timestamp syqdqsj;
    /**
     * 毕业学校
     */
    @DEField(name = "r_lastschool")
    @TableField(value = "r_lastschool")
    @JSONField(name = "r_lastschool")
    @JsonProperty("r_lastschool")
    private String rLastschool;
    /**
     * 最新投递时间
     */
    @DEField(name = "r_initializeapplydate")
    @TableField(value = "r_initializeapplydate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "r_initializeapplydate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("r_initializeapplydate")
    private Timestamp rInitializeapplydate;
    /**
     * 籍贯
     */
    @TableField(value = "nativeplace")
    @JSONField(name = "nativeplace")
    @JsonProperty("nativeplace")
    private String nativeplace;
    /**
     * 操作5
     */
    @DEField(defaultValue = "1")
    @TableField(value = "cz5")
    @JSONField(name = "cz5")
    @JsonProperty("cz5")
    private String cz5;
    /**
     * 证件号码
     */
    @TableField(value = "certificatenumber")
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 局审批意见
     */
    @TableField(value = "jzbspyj")
    @JSONField(name = "jzbspyj")
    @JsonProperty("jzbspyj")
    private String jzbspyj;
    /**
     * 毕业时间
     */
    @TableField(value = "graduationdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "graduationdate" , format="yyyy-MM-dd")
    @JsonProperty("graduationdate")
    private Timestamp graduationdate;
    /**
     * 身份证
     */
    @TableField(value = "sfz")
    @JSONField(name = "sfz")
    @JsonProperty("sfz")
    private String sfz;
    /**
     * 证件类型
     */
    @TableField(value = "certificatetype")
    @JSONField(name = "certificatetype")
    @JsonProperty("certificatetype")
    private String certificatetype;
    /**
     * 是否黑名单
     */
    @TableField(value = "isblacklist")
    @JSONField(name = "isblacklist")
    @JsonProperty("isblacklist")
    private Integer isblacklist;
    /**
     * 语言等级证书
     */
    @TableField(value = "otherfile")
    @JSONField(name = "otherfile")
    @JsonProperty("otherfile")
    private String otherfile;
    /**
     * 民族
     */
    @TableField(value = "nation")
    @JSONField(name = "nation")
    @JsonProperty("nation")
    private String nation;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;
    /**
     * 有无留学经历
     */
    @TableField(value = "isabroad")
    @JSONField(name = "isabroad")
    @JsonProperty("isabroad")
    private String isabroad;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 是否通过测评
     */
    @TableField(value = "sftgcp")
    @JSONField(name = "sftgcp")
    @JsonProperty("sftgcp")
    private String sftgcp;
    /**
     * 健康状况
     */
    @TableField(value = "jkzk")
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;
    /**
     * 出生地
     */
    @TableField(value = "csd")
    @JSONField(name = "csd")
    @JsonProperty("csd")
    private String csd;
    /**
     * 局审核意见原因
     */
    @TableField(value = "jldspyjyy")
    @JSONField(name = "jldspyjyy")
    @JsonProperty("jldspyjyy")
    private String jldspyjyy;
    /**
     * 挂职进明细id
     */
    @TableField(value = "pcmydgzmxid")
    @JSONField(name = "pcmydgzmxid")
    @JsonProperty("pcmydgzmxid")
    private String pcmydgzmxid;
    /**
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 照片
     */
    @TableField(value = "zp")
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;
    /**
     * 拟安排岗位
     */
    @TableField(value = "napxmjgwmc")
    @JSONField(name = "napxmjgwmc")
    @JsonProperty("napxmjgwmc")
    private String napxmjgwmc;
    /**
     * 是否小专业
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sfxzy")
    @JSONField(name = "sfxzy")
    @JsonProperty("sfxzy")
    private String sfxzy;
    /**
     * 其他证书
     */
    @TableField(value = "zczs2")
    @JSONField(name = "zczs2")
    @JsonProperty("zczs2")
    private String zczs2;
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
     * 局总部审批意见（人力上报）
     */
    @TableField(exist = false)
    @JSONField(name = "jspyj_rlsb")
    @JsonProperty("jspyj_rlsb")
    private String jspyjRlsb;
    /**
     * 性别
     */
    @TableField(value = "gender")
    @JSONField(name = "gender")
    @JsonProperty("gender")
    private String gender;
    /**
     * 参加工作时间
     */
    @TableField(value = "workbegindate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "workbegindate" , format="yyyy-MM-dd")
    @JsonProperty("workbegindate")
    private Timestamp workbegindate;
    /**
     * 外部岗位
     */
    @TableField(value = "wbgw")
    @JSONField(name = "wbgw")
    @JsonProperty("wbgw")
    private String wbgw;
    /**
     * 外部组织
     */
    @TableField(value = "wbzz")
    @JSONField(name = "wbzz")
    @JsonProperty("wbzz")
    private String wbzz;
    /**
     * 证书名称
     */
    @DEField(name = "r_certnames")
    @TableField(value = "r_certnames")
    @JSONField(name = "r_certnames")
    @JsonProperty("r_certnames")
    private String rCertnames;
    /**
     * 上报时间
     */
    @TableField(value = "sbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="yyyy-MM-dd")
    @JsonProperty("sbsj")
    private Timestamp sbsj;
    /**
     * 工资补贴
     */
    @TableField(value = "gzbt")
    @JSONField(name = "gzbt")
    @JsonProperty("gzbt")
    private Double gzbt;
    /**
     * 入团时间
     */
    @TableField(value = "rtsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rtsj" , format="yyyy-MM-dd")
    @JsonProperty("rtsj")
    private Timestamp rtsj;
    /**
     * 拟安排项目
     */
    @TableField(value = "napxm")
    @JSONField(name = "napxm")
    @JsonProperty("napxm")
    private String napxm;
    /**
     * 学校性质
     */
    @TableField(value = "xxxz")
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;
    /**
     * 操作3
     */
    @DEField(defaultValue = "1")
    @TableField(value = "cz3")
    @JSONField(name = "cz3")
    @JsonProperty("cz3")
    private String cz3;
    /**
     * 局审核意见
     */
    @TableField(value = "jldspyj")
    @JSONField(name = "jldspyj")
    @JsonProperty("jldspyj")
    private String jldspyj;
    /**
     * 外部部门
     */
    @TableField(value = "wbbm")
    @JSONField(name = "wbbm")
    @JsonProperty("wbbm")
    private String wbbm;
    /**
     * 选择内部人员
     */
    @TableField(value = "sfxzbjnbry")
    @JSONField(name = "sfxzbjnbry")
    @JsonProperty("sfxzbjnbry")
    private String sfxzbjnbry;
    /**
     * 报到时间
     */
    @TableField(value = "entrantdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "entrantdate" , format="yyyy-MM-dd")
    @JsonProperty("entrantdate")
    private Timestamp entrantdate;
    /**
     * 局初审意见
     */
    @TableField(value = "jzpspyj")
    @JSONField(name = "jzpspyj")
    @JsonProperty("jzpspyj")
    private String jzpspyj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 语言等级名称
     */
    @TableField(value = "yydjmc")
    @JSONField(name = "yydjmc")
    @JsonProperty("yydjmc")
    private String yydjmc;
    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "birthday" , format="yyyy-MM-dd")
    @JsonProperty("birthday")
    private Timestamp birthday;
    /**
     * 语言等级
     */
    @TableField(value = "yydj")
    @JSONField(name = "yydj")
    @JsonProperty("yydj")
    private String yydj;
    /**
     * 政治面貌
     */
    @TableField(value = "polity")
    @JSONField(name = "polity")
    @JsonProperty("polity")
    private String polity;
    /**
     * 挂职结束时间
     */
    @TableField(value = "gzjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;
    /**
     * 婚姻状况
     */
    @TableField(value = "wedstate")
    @JSONField(name = "wedstate")
    @JsonProperty("wedstate")
    private String wedstate;
    /**
     * 操作4
     */
    @DEField(defaultValue = "1")
    @TableField(value = "cz4")
    @JSONField(name = "cz4")
    @JsonProperty("cz4")
    private String cz4;
    /**
     * 人工校验通过
     */
    @TableField(value = "rgjytg")
    @JSONField(name = "rgjytg")
    @JsonProperty("rgjytg")
    private String rgjytg;
    /**
     * 现职称
     */
    @TableField(value = "xzc")
    @JSONField(name = "xzc")
    @JsonProperty("xzc")
    private String xzc;
    /**
     * 户口类型
     */
    @TableField(value = "hklx")
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;
    /**
     * 本人承诺以上内容均属实并签字
     */
    @TableField(value = "qzsm")
    @JSONField(name = "qzsm")
    @JsonProperty("qzsm")
    private String qzsm;
    /**
     * 招聘年份
     */
    @TableField(value = "xznf")
    @JSONField(name = "xznf")
    @JsonProperty("xznf")
    private String xznf;
    /**
     * 学习形式
     */
    @TableField(value = "educationstudymode")
    @JSONField(name = "educationstudymode")
    @JsonProperty("educationstudymode")
    private String educationstudymode;
    /**
     * 应聘者状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "profiletype")
    @JSONField(name = "profiletype")
    @JsonProperty("profiletype")
    private String profiletype;
    /**
     * 挂职进职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 虚拟部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 退休员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 挂职进岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 虚拟部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 挂职进岗位标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 挂职进职务标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 校验结果
     */
    @DEField(defaultValue = "4")
    @TableField(value = "checkresult")
    @JSONField(name = "checkresult")
    @JsonProperty("checkresult")
    private String checkresult;

    /**
     * 挂职进职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 虚拟部门-应聘者信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 所属组织-应聘者信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 挂职进岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 退休人员-应聘者信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [岗位类别]
     */
    public void setGwlb(String gwlb){
        this.gwlb = gwlb ;
        this.modify("gwlb",gwlb);
    }

    /**
     * 设置 [专业名称]
     */
    public void setRLastdiscipline(String rLastdiscipline){
        this.rLastdiscipline = rLastdiscipline ;
        this.modify("r_lastdiscipline",rLastdiscipline);
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
     * 设置 [外部组织机构代码]
     */
    public void setWbzzjgdm(String wbzzjgdm){
        this.wbzzjgdm = wbzzjgdm ;
        this.modify("wbzzjgdm",wbzzjgdm);
    }

    /**
     * 设置 [血型]
     */
    public void setBloodtype(String bloodtype){
        this.bloodtype = bloodtype ;
        this.modify("bloodtype",bloodtype);
    }

    /**
     * 设置 [体检情况]
     */
    public void setTjqk(String tjqk){
        this.tjqk = tjqk ;
        this.modify("tjqk",tjqk);
    }

    /**
     * 设置 [是否211]
     */
    public void setRSchoolis211(String rSchoolis211){
        this.rSchoolis211 = rSchoolis211 ;
        this.modify("r_schoolis211",rSchoolis211);
    }

    /**
     * 设置 [社招引进条件]
     */
    public void setSzyjtj(String szyjtj){
        this.szyjtj = szyjtj ;
        this.modify("szyjtj",szyjtj);
    }

    /**
     * 设置 [应聘者ID（北森）]
     */
    public void setApplicantid(String applicantid){
        this.applicantid = applicantid ;
        this.modify("applicantid",applicantid);
    }

    /**
     * 设置 [是否985]
     */
    public void setRSchoolis985(String rSchoolis985){
        this.rSchoolis985 = rSchoolis985 ;
        this.modify("r_schoolis985",rSchoolis985);
    }

    /**
     * 设置 [邮政编码]
     */
    public void setYzbm(String yzbm){
        this.yzbm = yzbm ;
        this.modify("yzbm",yzbm);
    }

    /**
     * 设置 [现居住地]
     */
    public void setResidencestate(String residencestate){
        this.residencestate = residencestate ;
        this.modify("residencestate",residencestate);
    }

    /**
     * 设置 [一级学科]
     */
    public void setXkml(String xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [局初审意见原因]
     */
    public void setJzpspyjyy(String jzpspyjyy){
        this.jzpspyjyy = jzpspyjyy ;
        this.modify("jzpspyjyy",jzpspyjyy);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [操作2]
     */
    public void setCz2(String cz2){
        this.cz2 = cz2 ;
        this.modify("cz2",cz2);
    }

    /**
     * 设置 [年份]
     */
    public void setNf(String nf){
        this.nf = nf ;
        this.modify("nf",nf);
    }

    /**
     * 设置 [简历状态]
     */
    public void setPhaseinfo(String phaseinfo){
        this.phaseinfo = phaseinfo ;
        this.modify("phaseinfo",phaseinfo);
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
     * 设置 [拟签订劳动合同期]
     */
    public void setNqdldhtqx(String nqdldhtqx){
        this.nqdldhtqx = nqdldhtqx ;
        this.modify("nqdldhtqx",nqdldhtqx);
    }

    /**
     * 设置 [员工类型审核规则]
     */
    public void setYglxshgz(String yglxshgz){
        this.yglxshgz = yglxshgz ;
        this.modify("yglxshgz",yglxshgz);
    }

    /**
     * 设置 [最高学位]
     */
    public void setHighestdegree(String highestdegree){
        this.highestdegree = highestdegree ;
        this.modify("highestdegree",highestdegree);
    }

    /**
     * 设置 [姓名]
     */
    public void setPcmprofilename(String pcmprofilename){
        this.pcmprofilename = pcmprofilename ;
        this.modify("pcmprofilename",pcmprofilename);
    }

    /**
     * 设置 [入职渠道]
     */
    public void setRzqd(String rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [曾用名]
     */
    public void setCym(String cym){
        this.cym = cym ;
        this.modify("cym",cym);
    }

    /**
     * 设置 [户籍所在地]
     */
    public void setRpr(String rpr){
        this.rpr = rpr ;
        this.modify("rpr",rpr);
    }

    /**
     * 设置 [局审批意见原因]
     */
    public void setJzbspyjyy(String jzbspyjyy){
        this.jzbspyjyy = jzbspyjyy ;
        this.modify("jzbspyjyy",jzbspyjyy);
    }

    /**
     * 设置 [申报类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [有无重大疾病史]
     */
    public void setYwzdjbs(String ywzdjbs){
        this.ywzdjbs = ywzdjbs ;
        this.modify("ywzdjbs",ywzdjbs);
    }

    /**
     * 设置 [爱好/特长]
     */
    public void setHobbies(String hobbies){
        this.hobbies = hobbies ;
        this.modify("hobbies",hobbies);
    }

    /**
     * 设置 [应聘者Elink详情]
     */
    public void setElinkurl(String elinkurl){
        this.elinkurl = elinkurl ;
        this.modify("elinkurl",elinkurl);
    }

    /**
     * 设置 [手机号]
     */
    public void setMobile(String mobile){
        this.mobile = mobile ;
        this.modify("mobile",mobile);
    }

    /**
     * 设置 [外部职务]
     */
    public void setWbzw(String wbzw){
        this.wbzw = wbzw ;
        this.modify("wbzw",wbzw);
    }

    /**
     * 设置 [人事档案所在单位]
     */
    public void setPersonnelfileplace(String personnelfileplace){
        this.personnelfileplace = personnelfileplace ;
        this.modify("personnelfileplace",personnelfileplace);
    }

    /**
     * 设置 [状态原因]
     */
    public void setZtyy(String ztyy){
        this.ztyy = ztyy ;
        this.modify("ztyy",ztyy);
    }

    /**
     * 设置 [注册证书]
     */
    public void setZczs(String zczs){
        this.zczs = zczs ;
        this.modify("zczs",zczs);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [应聘者编号]
     */
    public void setCadidateid(String cadidateid){
        this.cadidateid = cadidateid ;
        this.modify("cadidateid",cadidateid);
    }

    /**
     * 设置 [黑名单原因]
     */
    public void setIsblacklistreason(String isblacklistreason){
        this.isblacklistreason = isblacklistreason ;
        this.modify("isblacklistreason",isblacklistreason);
    }

    /**
     * 设置 [签字照片上传]
     */
    public void setQzfj(String qzfj){
        this.qzfj = qzfj ;
        this.modify("qzfj",qzfj);
    }

    /**
     * 设置 [最高学历]
     */
    public void setEducationlevel(String educationlevel){
        this.educationlevel = educationlevel ;
        this.modify("educationlevel",educationlevel);
    }

    /**
     * 设置 [学位类型]
     */
    public void setDegreetype(String degreetype){
        this.degreetype = degreetype ;
        this.modify("degreetype",degreetype);
    }

    /**
     * 设置 [户籍地址]
     */
    public void setHjdz(String hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [招聘类型]
     */
    public void setZplx(String zplx){
        this.zplx = zplx ;
        this.modify("zplx",zplx);
    }

    /**
     * 设置 [毕业年份]
     */
    public void setYjsnf(String yjsnf){
        this.yjsnf = yjsnf ;
        this.modify("yjsnf",yjsnf);
    }

    /**
     * 设置 [通讯地址]
     */
    public void setAddress(String address){
        this.address = address ;
        this.modify("address",address);
    }

    /**
     * 设置 [试用期到期时间]
     */
    public void setSyqdqsj(Timestamp syqdqsj){
        this.syqdqsj = syqdqsj ;
        this.modify("syqdqsj",syqdqsj);
    }

    /**
     * 格式化日期 [试用期到期时间]
     */
    public String formatSyqdqsj(){
        if (this.syqdqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(syqdqsj);
    }
    /**
     * 设置 [毕业学校]
     */
    public void setRLastschool(String rLastschool){
        this.rLastschool = rLastschool ;
        this.modify("r_lastschool",rLastschool);
    }

    /**
     * 设置 [最新投递时间]
     */
    public void setRInitializeapplydate(Timestamp rInitializeapplydate){
        this.rInitializeapplydate = rInitializeapplydate ;
        this.modify("r_initializeapplydate",rInitializeapplydate);
    }

    /**
     * 格式化日期 [最新投递时间]
     */
    public String formatRInitializeapplydate(){
        if (this.rInitializeapplydate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(rInitializeapplydate);
    }
    /**
     * 设置 [籍贯]
     */
    public void setNativeplace(String nativeplace){
        this.nativeplace = nativeplace ;
        this.modify("nativeplace",nativeplace);
    }

    /**
     * 设置 [操作5]
     */
    public void setCz5(String cz5){
        this.cz5 = cz5 ;
        this.modify("cz5",cz5);
    }

    /**
     * 设置 [证件号码]
     */
    public void setCertificatenumber(String certificatenumber){
        this.certificatenumber = certificatenumber ;
        this.modify("certificatenumber",certificatenumber);
    }

    /**
     * 设置 [局审批意见]
     */
    public void setJzbspyj(String jzbspyj){
        this.jzbspyj = jzbspyj ;
        this.modify("jzbspyj",jzbspyj);
    }

    /**
     * 设置 [毕业时间]
     */
    public void setGraduationdate(Timestamp graduationdate){
        this.graduationdate = graduationdate ;
        this.modify("graduationdate",graduationdate);
    }

    /**
     * 格式化日期 [毕业时间]
     */
    public String formatGraduationdate(){
        if (this.graduationdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(graduationdate);
    }
    /**
     * 设置 [身份证]
     */
    public void setSfz(String sfz){
        this.sfz = sfz ;
        this.modify("sfz",sfz);
    }

    /**
     * 设置 [证件类型]
     */
    public void setCertificatetype(String certificatetype){
        this.certificatetype = certificatetype ;
        this.modify("certificatetype",certificatetype);
    }

    /**
     * 设置 [是否黑名单]
     */
    public void setIsblacklist(Integer isblacklist){
        this.isblacklist = isblacklist ;
        this.modify("isblacklist",isblacklist);
    }

    /**
     * 设置 [语言等级证书]
     */
    public void setOtherfile(String otherfile){
        this.otherfile = otherfile ;
        this.modify("otherfile",otherfile);
    }

    /**
     * 设置 [民族]
     */
    public void setNation(String nation){
        this.nation = nation ;
        this.modify("nation",nation);
    }

    /**
     * 设置 [邮箱]
     */
    public void setEmail(String email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [有无留学经历]
     */
    public void setIsabroad(String isabroad){
        this.isabroad = isabroad ;
        this.modify("isabroad",isabroad);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [是否通过测评]
     */
    public void setSftgcp(String sftgcp){
        this.sftgcp = sftgcp ;
        this.modify("sftgcp",sftgcp);
    }

    /**
     * 设置 [健康状况]
     */
    public void setJkzk(String jkzk){
        this.jkzk = jkzk ;
        this.modify("jkzk",jkzk);
    }

    /**
     * 设置 [出生地]
     */
    public void setCsd(String csd){
        this.csd = csd ;
        this.modify("csd",csd);
    }

    /**
     * 设置 [局审核意见原因]
     */
    public void setJldspyjyy(String jldspyjyy){
        this.jldspyjyy = jldspyjyy ;
        this.modify("jldspyjyy",jldspyjyy);
    }

    /**
     * 设置 [挂职进明细id]
     */
    public void setPcmydgzmxid(String pcmydgzmxid){
        this.pcmydgzmxid = pcmydgzmxid ;
        this.modify("pcmydgzmxid",pcmydgzmxid);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [照片]
     */
    public void setZp(String zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [拟安排岗位]
     */
    public void setNapxmjgwmc(String napxmjgwmc){
        this.napxmjgwmc = napxmjgwmc ;
        this.modify("napxmjgwmc",napxmjgwmc);
    }

    /**
     * 设置 [是否小专业]
     */
    public void setSfxzy(String sfxzy){
        this.sfxzy = sfxzy ;
        this.modify("sfxzy",sfxzy);
    }

    /**
     * 设置 [其他证书]
     */
    public void setZczs2(String zczs2){
        this.zczs2 = zczs2 ;
        this.modify("zczs2",zczs2);
    }

    /**
     * 设置 [性别]
     */
    public void setGender(String gender){
        this.gender = gender ;
        this.modify("gender",gender);
    }

    /**
     * 设置 [参加工作时间]
     */
    public void setWorkbegindate(Timestamp workbegindate){
        this.workbegindate = workbegindate ;
        this.modify("workbegindate",workbegindate);
    }

    /**
     * 格式化日期 [参加工作时间]
     */
    public String formatWorkbegindate(){
        if (this.workbegindate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(workbegindate);
    }
    /**
     * 设置 [外部岗位]
     */
    public void setWbgw(String wbgw){
        this.wbgw = wbgw ;
        this.modify("wbgw",wbgw);
    }

    /**
     * 设置 [外部组织]
     */
    public void setWbzz(String wbzz){
        this.wbzz = wbzz ;
        this.modify("wbzz",wbzz);
    }

    /**
     * 设置 [证书名称]
     */
    public void setRCertnames(String rCertnames){
        this.rCertnames = rCertnames ;
        this.modify("r_certnames",rCertnames);
    }

    /**
     * 设置 [上报时间]
     */
    public void setSbsj(Timestamp sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 格式化日期 [上报时间]
     */
    public String formatSbsj(){
        if (this.sbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sbsj);
    }
    /**
     * 设置 [工资补贴]
     */
    public void setGzbt(Double gzbt){
        this.gzbt = gzbt ;
        this.modify("gzbt",gzbt);
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
     * 设置 [拟安排项目]
     */
    public void setNapxm(String napxm){
        this.napxm = napxm ;
        this.modify("napxm",napxm);
    }

    /**
     * 设置 [学校性质]
     */
    public void setXxxz(String xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [操作3]
     */
    public void setCz3(String cz3){
        this.cz3 = cz3 ;
        this.modify("cz3",cz3);
    }

    /**
     * 设置 [局审核意见]
     */
    public void setJldspyj(String jldspyj){
        this.jldspyj = jldspyj ;
        this.modify("jldspyj",jldspyj);
    }

    /**
     * 设置 [外部部门]
     */
    public void setWbbm(String wbbm){
        this.wbbm = wbbm ;
        this.modify("wbbm",wbbm);
    }

    /**
     * 设置 [选择内部人员]
     */
    public void setSfxzbjnbry(String sfxzbjnbry){
        this.sfxzbjnbry = sfxzbjnbry ;
        this.modify("sfxzbjnbry",sfxzbjnbry);
    }

    /**
     * 设置 [报到时间]
     */
    public void setEntrantdate(Timestamp entrantdate){
        this.entrantdate = entrantdate ;
        this.modify("entrantdate",entrantdate);
    }

    /**
     * 格式化日期 [报到时间]
     */
    public String formatEntrantdate(){
        if (this.entrantdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(entrantdate);
    }
    /**
     * 设置 [局初审意见]
     */
    public void setJzpspyj(String jzpspyj){
        this.jzpspyj = jzpspyj ;
        this.modify("jzpspyj",jzpspyj);
    }

    /**
     * 设置 [语言等级名称]
     */
    public void setYydjmc(String yydjmc){
        this.yydjmc = yydjmc ;
        this.modify("yydjmc",yydjmc);
    }

    /**
     * 设置 [出生日期]
     */
    public void setBirthday(Timestamp birthday){
        this.birthday = birthday ;
        this.modify("birthday",birthday);
    }

    /**
     * 格式化日期 [出生日期]
     */
    public String formatBirthday(){
        if (this.birthday == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birthday);
    }
    /**
     * 设置 [语言等级]
     */
    public void setYydj(String yydj){
        this.yydj = yydj ;
        this.modify("yydj",yydj);
    }

    /**
     * 设置 [政治面貌]
     */
    public void setPolity(String polity){
        this.polity = polity ;
        this.modify("polity",polity);
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
     * 设置 [婚姻状况]
     */
    public void setWedstate(String wedstate){
        this.wedstate = wedstate ;
        this.modify("wedstate",wedstate);
    }

    /**
     * 设置 [操作4]
     */
    public void setCz4(String cz4){
        this.cz4 = cz4 ;
        this.modify("cz4",cz4);
    }

    /**
     * 设置 [人工校验通过]
     */
    public void setRgjytg(String rgjytg){
        this.rgjytg = rgjytg ;
        this.modify("rgjytg",rgjytg);
    }

    /**
     * 设置 [现职称]
     */
    public void setXzc(String xzc){
        this.xzc = xzc ;
        this.modify("xzc",xzc);
    }

    /**
     * 设置 [户口类型]
     */
    public void setHklx(String hklx){
        this.hklx = hklx ;
        this.modify("hklx",hklx);
    }

    /**
     * 设置 [本人承诺以上内容均属实并签字]
     */
    public void setQzsm(String qzsm){
        this.qzsm = qzsm ;
        this.modify("qzsm",qzsm);
    }

    /**
     * 设置 [招聘年份]
     */
    public void setXznf(String xznf){
        this.xznf = xznf ;
        this.modify("xznf",xznf);
    }

    /**
     * 设置 [学习形式]
     */
    public void setEducationstudymode(String educationstudymode){
        this.educationstudymode = educationstudymode ;
        this.modify("educationstudymode",educationstudymode);
    }

    /**
     * 设置 [应聘者状态]
     */
    public void setProfiletype(String profiletype){
        this.profiletype = profiletype ;
        this.modify("profiletype",profiletype);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [虚拟部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [挂职进岗位标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [挂职进职务标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [校验结果]
     */
    public void setCheckresult(String checkresult){
        this.checkresult = checkresult ;
        this.modify("checkresult",checkresult);
    }


}


