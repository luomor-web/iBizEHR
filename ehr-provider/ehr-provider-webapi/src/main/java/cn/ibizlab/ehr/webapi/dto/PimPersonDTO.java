package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[PimPersonDTO]
 */
@Data
public class PimPersonDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GZZT]
     *
     */
    @JSONField(name = "gzzt")
    @JsonProperty("gzzt")
    private String gzzt;

    /**
     * 属性 [ZJLX]
     *
     */
    @JSONField(name = "zjlx")
    @JsonProperty("zjlx")
    private String zjlx;

    /**
     * 属性 [ZGZT]
     *
     */
    @JSONField(name = "zgzt")
    @JsonProperty("zgzt")
    private String zgzt;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [YGLX]
     *
     */
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;

    /**
     * 属性 [DAXL]
     *
     */
    @JSONField(name = "daxl")
    @JsonProperty("daxl")
    private String daxl;

    /**
     * 属性 [TRANSFERDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "transferdate" , format="yyyy-MM-dd")
    @JsonProperty("transferdate")
    private Timestamp transferdate;

    /**
     * 属性 [AHTC]
     *
     */
    @JSONField(name = "ahtc")
    @JsonProperty("ahtc")
    private String ahtc;

    /**
     * 属性 [TXNX_COLOR]
     *
     */
    @JSONField(name = "txnx_color")
    @JsonProperty("txnx_color")
    private String txnxColor;

    /**
     * 属性 [RZNLDQ]
     *
     */
    @JSONField(name = "rznldq")
    @JsonProperty("rznldq")
    private String rznldq;

    /**
     * 属性 [POSTALADDRESS]
     *
     */
    @JSONField(name = "postaladdress")
    @JsonProperty("postaladdress")
    private String postaladdress;

    /**
     * 属性 [SYDQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sydq" , format="yyyy-MM-dd")
    @JsonProperty("sydq")
    private Timestamp sydq;

    /**
     * 属性 [DZJBJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dzjbjsj" , format="yyyy-MM-dd")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;

    /**
     * 属性 [JTLXRID]
     *
     */
    @JSONField(name = "jtlxrid")
    @JsonProperty("jtlxrid")
    private String jtlxrid;

    /**
     * 属性 [ZGCODE]
     *
     */
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;

    /**
     * 属性 [POSTEXPIRATION]
     *
     */
    @JSONField(name = "postexpiration")
    @JsonProperty("postexpiration")
    private String postexpiration;

    /**
     * 属性 [JG]
     *
     */
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [GZZZ]
     *
     */
    @JSONField(name = "gzzz")
    @JsonProperty("gzzz")
    private String gzzz;

    /**
     * 属性 [SYCZJRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syczjrq" , format="yyyy-MM-dd")
    @JsonProperty("syczjrq")
    private Timestamp syczjrq;

    /**
     * 属性 [HIGHTITLE]
     *
     */
    @JSONField(name = "hightitle")
    @JsonProperty("hightitle")
    private String hightitle;

    /**
     * 属性 [GZKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;

    /**
     * 属性 [SPDYLJE]
     *
     */
    @JSONField(name = "spdylje")
    @JsonProperty("spdylje")
    private Double spdylje;

    /**
     * 属性 [YYGBH]
     *
     */
    @JSONField(name = "yygbh")
    @JsonProperty("yygbh")
    private String yygbh;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [EMPLOYEEANDNO]
     *
     */
    @JSONField(name = "employeeandno")
    @JsonProperty("employeeandno")
    private String employeeandno;

    /**
     * 属性 [ISLEADERTEAM]
     *
     */
    @JSONField(name = "isleaderteam")
    @JsonProperty("isleaderteam")
    private Integer isleaderteam;

    /**
     * 属性 [HMD]
     *
     */
    @JSONField(name = "hmd")
    @JsonProperty("hmd")
    private Integer hmd;

    /**
     * 属性 [DACSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dacsrq" , format="yyyy-MM-dd")
    @JsonProperty("dacsrq")
    private Timestamp dacsrq;

    /**
     * 属性 [JKZK]
     *
     */
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;

    /**
     * 属性 [GWZT]
     *
     */
    @JSONField(name = "gwzt")
    @JsonProperty("gwzt")
    private String gwzt;

    /**
     * 属性 [NJ]
     *
     */
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [DBDWSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;

    /**
     * 属性 [ZYZG]
     *
     */
    @JSONField(name = "zyzg")
    @JsonProperty("zyzg")
    private String zyzg;

    /**
     * 属性 [CSD]
     *
     */
    @JSONField(name = "csd")
    @JsonProperty("csd")
    private String csd;

    /**
     * 属性 [JTLXRDH]
     *
     */
    @JSONField(name = "jtlxrdh")
    @JsonProperty("jtlxrdh")
    private String jtlxrdh;

    /**
     * 属性 [DYXLBYSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dyxlbysj" , format="yyyy-MM-dd")
    @JsonProperty("dyxlbysj")
    private Timestamp dyxlbysj;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ZJNX]
     *
     */
    @JSONField(name = "zjnx")
    @JsonProperty("zjnx")
    private Double zjnx;

    /**
     * 属性 [RZDQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzdq" , format="yyyy-MM-dd")
    @JsonProperty("rzdq")
    private Timestamp rzdq;

    /**
     * 属性 [HJSZD]
     *
     */
    @JSONField(name = "hjszd")
    @JsonProperty("hjszd")
    private String hjszd;

    /**
     * 属性 [GZJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;

    /**
     * 属性 [ZYJSZW]
     *
     */
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;

    /**
     * 属性 [SFNBFP]
     *
     */
    @JSONField(name = "sfnbfp")
    @JsonProperty("sfnbfp")
    private Integer sfnbfp;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [RDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;

    /**
     * 属性 [SFZNL]
     *
     */
    @JSONField(name = "sfznl")
    @JsonProperty("sfznl")
    private Integer sfznl;

    /**
     * 属性 [LGKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lgkssj" , format="yyyy-MM-dd")
    @JsonProperty("lgkssj")
    private Timestamp lgkssj;

    /**
     * 属性 [CYM]
     *
     */
    @JSONField(name = "cym")
    @JsonProperty("cym")
    private String cym;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [RZQD]
     *
     */
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;

    /**
     * 属性 [SGJSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sgjsrq" , format="yyyy-MM-dd")
    @JsonProperty("sgjsrq")
    private Timestamp sgjsrq;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [JXDQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jxdq" , format="yyyy-MM-dd")
    @JsonProperty("jxdq")
    private Timestamp jxdq;

    /**
     * 属性 [KHCJ]
     *
     */
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [SUPERUSER]
     *
     */
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;

    /**
     * 属性 [SGKSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sgksrq" , format="yyyy-MM-dd")
    @JsonProperty("sgksrq")
    private Timestamp sgksrq;

    /**
     * 属性 [NUMCODE]
     *
     */
    @JSONField(name = "numcode")
    @JsonProperty("numcode")
    private Integer numcode;

    /**
     * 属性 [CFYXJSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cfyxjsrq" , format="yyyy-MM-dd")
    @JsonProperty("cfyxjsrq")
    private Timestamp cfyxjsrq;

    /**
     * 属性 [CERTTIFICATE]
     *
     */
    @JSONField(name = "certtificate")
    @JsonProperty("certtificate")
    private String certtificate;

    /**
     * 属性 [CSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "csrq" , format="yyyy-MM-dd")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [LEAVEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "leavedate" , format="yyyy-MM-dd")
    @JsonProperty("leavedate")
    private Timestamp leavedate;

    /**
     * 属性 [FIRSTEDUCATION]
     *
     */
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private String firsteducation;

    /**
     * 属性 [GLY]
     *
     */
    @JSONField(name = "gly")
    @JsonProperty("gly")
    private Integer gly;

    /**
     * 属性 [JXSYWDS]
     *
     */
    @JSONField(name = "jxsywds")
    @JsonProperty("jxsywds")
    private String jxsywds;

    /**
     * 属性 [RZNX]
     *
     */
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Double rznx;

    /**
     * 属性 [HQXLBYYX]
     *
     */
    @JSONField(name = "hqxlbyyx")
    @JsonProperty("hqxlbyyx")
    private String hqxlbyyx;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;

    /**
     * 属性 [RCXLLX]
     *
     */
    @JSONField(name = "rcxllx")
    @JsonProperty("rcxllx")
    private String rcxllx;

    /**
     * 属性 [HQXLSXZY]
     *
     */
    @JSONField(name = "hqxlsxzy")
    @JsonProperty("hqxlsxzy")
    private String hqxlsxzy;

    /**
     * 属性 [GZBM]
     *
     */
    @JSONField(name = "gzbm")
    @JsonProperty("gzbm")
    private String gzbm;

    /**
     * 属性 [ZWRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [DARDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dardsj" , format="yyyy-MM-dd")
    @JsonProperty("dardsj")
    private Timestamp dardsj;

    /**
     * 属性 [DZYX]
     *
     */
    @JSONField(name = "dzyx")
    @JsonProperty("dzyx")
    private String dzyx;

    /**
     * 属性 [HKLX]
     *
     */
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;

    /**
     * 属性 [GLY2]
     *
     */
    @JSONField(name = "gly2")
    @JsonProperty("gly2")
    private Integer gly2;

    /**
     * 属性 [RETIPLACE]
     *
     */
    @JSONField(name = "retiplace")
    @JsonProperty("retiplace")
    private String retiplace;

    /**
     * 属性 [HIGHEDUCATION]
     *
     */
    @JSONField(name = "higheducation")
    @JsonProperty("higheducation")
    private String higheducation;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [ZJ]
     *
     */
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [HYZK]
     *
     */
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;

    /**
     * 属性 [DYXLSSZY]
     *
     */
    @JSONField(name = "dyxlsszy")
    @JsonProperty("dyxlsszy")
    private String dyxlsszy;

    /**
     * 属性 [TXDQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "txdq" , format="yyyy-MM-dd")
    @JsonProperty("txdq")
    private Timestamp txdq;

    /**
     * 属性 [PORTALUSERID]
     *
     */
    @JSONField(name = "portaluserid")
    @JsonProperty("portaluserid")
    private String portaluserid;

    /**
     * 属性 [SFTBERP]
     *
     */
    @JSONField(name = "sftberp")
    @JsonProperty("sftberp")
    private String sftberp;

    /**
     * 属性 [KHCJTX]
     *
     */
    @JSONField(name = "khcjtx")
    @JsonProperty("khcjtx")
    private Double khcjtx;

    /**
     * 属性 [DACJGZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dacjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("dacjgzsj")
    private Timestamp dacjgzsj;

    /**
     * 属性 [JZRZ]
     *
     */
    @JSONField(name = "jzrz")
    @JsonProperty("jzrz")
    private String jzrz;

    /**
     * 属性 [SJTXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjtxrq" , format="yyyy-MM-dd")
    @JsonProperty("sjtxrq")
    private Timestamp sjtxrq;

    /**
     * 属性 [XX]
     *
     */
    @JSONField(name = "xx")
    @JsonProperty("xx")
    private String xx;

    /**
     * 属性 [JXSSXDS]
     *
     */
    @JSONField(name = "jxssxds")
    @JsonProperty("jxssxds")
    private String jxssxds;

    /**
     * 属性 [DYXLBYYX]
     *
     */
    @JSONField(name = "dyxlbyyx")
    @JsonProperty("dyxlbyyx")
    private String dyxlbyyx;

    /**
     * 属性 [RZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzsj" , format="yyyy-MM-dd")
    @JsonProperty("rzsj")
    private Timestamp rzsj;

    /**
     * 属性 [TXNX]
     *
     */
    @JSONField(name = "txnx")
    @JsonProperty("txnx")
    private String txnx;

    /**
     * 属性 [SFDSZN]
     *
     */
    @JSONField(name = "sfdszn")
    @JsonProperty("sfdszn")
    private String sfdszn;

    /**
     * 属性 [XTBH]
     *
     */
    @JSONField(name = "xtbh")
    @JsonProperty("xtbh")
    private String xtbh;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [WORKSTATE]
     *
     */
    @JSONField(name = "workstate")
    @JsonProperty("workstate")
    private String workstate;

    /**
     * 属性 [CJGZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjgzsj" , format="yyyy-MM-dd")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;

    /**
     * 属性 [GWKSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gwksrq" , format="yyyy-MM-dd")
    @JsonProperty("gwksrq")
    private Timestamp gwksrq;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [TOZJDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tozjdate" , format="yyyy-MM-dd")
    @JsonProperty("tozjdate")
    private Timestamp tozjdate;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [BLACKLISTREASONS]
     *
     */
    @JSONField(name = "blacklistreasons")
    @JsonProperty("blacklistreasons")
    private String blacklistreasons;

    /**
     * 属性 [HJDZ]
     *
     */
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;

    /**
     * 属性 [ZWNX]
     *
     */
    @JSONField(name = "zwnx")
    @JsonProperty("zwnx")
    private String zwnx;

    /**
     * 属性 [RTSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rtsj" , format="yyyy-MM-dd")
    @JsonProperty("rtsj")
    private Timestamp rtsj;

    /**
     * 属性 [SGYY]
     *
     */
    @JSONField(name = "sgyy")
    @JsonProperty("sgyy")
    private String sgyy;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [LGNX_COLOR]
     *
     */
    @JSONField(name = "lgnx_color")
    @JsonProperty("lgnx_color")
    private String lgnxColor;

    /**
     * 属性 [YJSNF]
     *
     */
    @JSONField(name = "yjsnf")
    @JsonProperty("yjsnf")
    private String yjsnf;

    /**
     * 属性 [RANKRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rankrq" , format="yyyy-MM-dd")
    @JsonProperty("rankrq")
    private Timestamp rankrq;

    /**
     * 属性 [ZP]
     *
     */
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;

    /**
     * 属性 [LGNX]
     *
     */
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private String lgnx;

    /**
     * 属性 [JTLXR]
     *
     */
    @JSONField(name = "jtlxr")
    @JsonProperty("jtlxr")
    private String jtlxr;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SYQDQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syqdqsj" , format="yyyy-MM-dd")
    @JsonProperty("syqdqsj")
    private Timestamp syqdqsj;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [HTQDCS]
     *
     */
    @JSONField(name = "htqdcs")
    @JsonProperty("htqdcs")
    private String htqdcs;

    /**
     * 属性 [MZ]
     *
     */
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;

    /**
     * 属性 [SFZ]
     *
     */
    @JSONField(name = "sfz")
    @JsonProperty("sfz")
    private String sfz;

    /**
     * 属性 [RZNLDQ_COLOR]
     *
     */
    @JSONField(name = "rznldq_color")
    @JsonProperty("rznldq_color")
    private String rznldqColor;

    /**
     * 属性 [YDZT]
     *
     */
    @JSONField(name = "ydzt")
    @JsonProperty("ydzt")
    private String ydzt;

    /**
     * 属性 [YGBHQYSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ygbhqysj" , format="yyyy-MM-dd")
    @JsonProperty("ygbhqysj")
    private Timestamp ygbhqysj;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [PIMPERSONNAME3]
     *
     */
    @JSONField(name = "pimpersonname3")
    @JsonProperty("pimpersonname3")
    private String pimpersonname3;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMMAJORSETYPENAME]
     *
     */
    @JSONField(name = "pimmajorsetypename")
    @JsonProperty("pimmajorsetypename")
    private String pimmajorsetypename;

    /**
     * 属性 [PCMRCXLNAME]
     *
     */
    @JSONField(name = "pcmrcxlname")
    @JsonProperty("pcmrcxlname")
    private String pcmrcxlname;

    /**
     * 属性 [PIMPERSONNAME2]
     *
     */
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMCITYNAME]
     *
     */
    @JSONField(name = "pimcityname")
    @JsonProperty("pimcityname")
    private String pimcityname;

    /**
     * 属性 [ORGTYPE]
     *
     */
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PCMRCXLID]
     *
     */
    @JSONField(name = "pcmrcxlid")
    @JsonProperty("pcmrcxlid")
    private String pcmrcxlid;

    /**
     * 属性 [PIMPERSONID2]
     *
     */
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;

    /**
     * 属性 [PIMCITYID]
     *
     */
    @JSONField(name = "pimcityid")
    @JsonProperty("pimcityid")
    private String pimcityid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PCMJXSYGZZJLMXID]
     *
     */
    @JSONField(name = "pcmjxsygzzjlmxid")
    @JsonProperty("pcmjxsygzzjlmxid")
    private String pcmjxsygzzjlmxid;

    /**
     * 属性 [PIMMAJORSETYPEID]
     *
     */
    @JSONField(name = "pimmajorsetypeid")
    @JsonProperty("pimmajorsetypeid")
    private String pimmajorsetypeid;

    /**
     * 属性 [PIMPERSONID3]
     *
     */
    @JSONField(name = "pimpersonid3")
    @JsonProperty("pimpersonid3")
    private String pimpersonid3;


    /**
     * 设置 [GZZT]
     */
    public void setGzzt(String  gzzt){
        this.gzzt = gzzt ;
        this.modify("gzzt",gzzt);
    }

    /**
     * 设置 [ZJLX]
     */
    public void setZjlx(String  zjlx){
        this.zjlx = zjlx ;
        this.modify("zjlx",zjlx);
    }

    /**
     * 设置 [ZGZT]
     */
    public void setZgzt(String  zgzt){
        this.zgzt = zgzt ;
        this.modify("zgzt",zgzt);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [YGLX]
     */
    public void setYglx(String  yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [DAXL]
     */
    public void setDaxl(String  daxl){
        this.daxl = daxl ;
        this.modify("daxl",daxl);
    }

    /**
     * 设置 [TRANSFERDATE]
     */
    public void setTransferdate(Timestamp  transferdate){
        this.transferdate = transferdate ;
        this.modify("transferdate",transferdate);
    }

    /**
     * 设置 [AHTC]
     */
    public void setAhtc(String  ahtc){
        this.ahtc = ahtc ;
        this.modify("ahtc",ahtc);
    }

    /**
     * 设置 [RZNLDQ]
     */
    public void setRznldq(String  rznldq){
        this.rznldq = rznldq ;
        this.modify("rznldq",rznldq);
    }

    /**
     * 设置 [POSTALADDRESS]
     */
    public void setPostaladdress(String  postaladdress){
        this.postaladdress = postaladdress ;
        this.modify("postaladdress",postaladdress);
    }

    /**
     * 设置 [SYDQ]
     */
    public void setSydq(Timestamp  sydq){
        this.sydq = sydq ;
        this.modify("sydq",sydq);
    }

    /**
     * 设置 [DZJBJSJ]
     */
    public void setDzjbjsj(Timestamp  dzjbjsj){
        this.dzjbjsj = dzjbjsj ;
        this.modify("dzjbjsj",dzjbjsj);
    }

    /**
     * 设置 [JTLXRID]
     */
    public void setJtlxrid(String  jtlxrid){
        this.jtlxrid = jtlxrid ;
        this.modify("jtlxrid",jtlxrid);
    }

    /**
     * 设置 [POSTEXPIRATION]
     */
    public void setPostexpiration(String  postexpiration){
        this.postexpiration = postexpiration ;
        this.modify("postexpiration",postexpiration);
    }

    /**
     * 设置 [JG]
     */
    public void setJg(String  jg){
        this.jg = jg ;
        this.modify("jg",jg);
    }

    /**
     * 设置 [RANK]
     */
    public void setRank(String  rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [GZZZ]
     */
    public void setGzzz(String  gzzz){
        this.gzzz = gzzz ;
        this.modify("gzzz",gzzz);
    }

    /**
     * 设置 [SYCZJRQ]
     */
    public void setSyczjrq(Timestamp  syczjrq){
        this.syczjrq = syczjrq ;
        this.modify("syczjrq",syczjrq);
    }

    /**
     * 设置 [HIGHTITLE]
     */
    public void setHightitle(String  hightitle){
        this.hightitle = hightitle ;
        this.modify("hightitle",hightitle);
    }

    /**
     * 设置 [GZKSSJ]
     */
    public void setGzkssj(Timestamp  gzkssj){
        this.gzkssj = gzkssj ;
        this.modify("gzkssj",gzkssj);
    }

    /**
     * 设置 [SPDYLJE]
     */
    public void setSpdylje(Double  spdylje){
        this.spdylje = spdylje ;
        this.modify("spdylje",spdylje);
    }

    /**
     * 设置 [YYGBH]
     */
    public void setYygbh(String  yygbh){
        this.yygbh = yygbh ;
        this.modify("yygbh",yygbh);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [ISLEADERTEAM]
     */
    public void setIsleaderteam(Integer  isleaderteam){
        this.isleaderteam = isleaderteam ;
        this.modify("isleaderteam",isleaderteam);
    }

    /**
     * 设置 [HMD]
     */
    public void setHmd(Integer  hmd){
        this.hmd = hmd ;
        this.modify("hmd",hmd);
    }

    /**
     * 设置 [DACSRQ]
     */
    public void setDacsrq(Timestamp  dacsrq){
        this.dacsrq = dacsrq ;
        this.modify("dacsrq",dacsrq);
    }

    /**
     * 设置 [JKZK]
     */
    public void setJkzk(String  jkzk){
        this.jkzk = jkzk ;
        this.modify("jkzk",jkzk);
    }

    /**
     * 设置 [GWZT]
     */
    public void setGwzt(String  gwzt){
        this.gwzt = gwzt ;
        this.modify("gwzt",gwzt);
    }

    /**
     * 设置 [DBDWSJ]
     */
    public void setDbdwsj(Timestamp  dbdwsj){
        this.dbdwsj = dbdwsj ;
        this.modify("dbdwsj",dbdwsj);
    }

    /**
     * 设置 [ZYZG]
     */
    public void setZyzg(String  zyzg){
        this.zyzg = zyzg ;
        this.modify("zyzg",zyzg);
    }

    /**
     * 设置 [CSD]
     */
    public void setCsd(String  csd){
        this.csd = csd ;
        this.modify("csd",csd);
    }

    /**
     * 设置 [JTLXRDH]
     */
    public void setJtlxrdh(String  jtlxrdh){
        this.jtlxrdh = jtlxrdh ;
        this.modify("jtlxrdh",jtlxrdh);
    }

    /**
     * 设置 [DYXLBYSJ]
     */
    public void setDyxlbysj(Timestamp  dyxlbysj){
        this.dyxlbysj = dyxlbysj ;
        this.modify("dyxlbysj",dyxlbysj);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ZJNX]
     */
    public void setZjnx(Double  zjnx){
        this.zjnx = zjnx ;
        this.modify("zjnx",zjnx);
    }

    /**
     * 设置 [RZDQ]
     */
    public void setRzdq(Timestamp  rzdq){
        this.rzdq = rzdq ;
        this.modify("rzdq",rzdq);
    }

    /**
     * 设置 [HJSZD]
     */
    public void setHjszd(String  hjszd){
        this.hjszd = hjszd ;
        this.modify("hjszd",hjszd);
    }

    /**
     * 设置 [GZJSSJ]
     */
    public void setGzjssj(Timestamp  gzjssj){
        this.gzjssj = gzjssj ;
        this.modify("gzjssj",gzjssj);
    }

    /**
     * 设置 [SFNBFP]
     */
    public void setSfnbfp(Integer  sfnbfp){
        this.sfnbfp = sfnbfp ;
        this.modify("sfnbfp",sfnbfp);
    }

    /**
     * 设置 [RDSJ]
     */
    public void setRdsj(Timestamp  rdsj){
        this.rdsj = rdsj ;
        this.modify("rdsj",rdsj);
    }

    /**
     * 设置 [LGKSSJ]
     */
    public void setLgkssj(Timestamp  lgkssj){
        this.lgkssj = lgkssj ;
        this.modify("lgkssj",lgkssj);
    }

    /**
     * 设置 [CYM]
     */
    public void setCym(String  cym){
        this.cym = cym ;
        this.modify("cym",cym);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [RZQD]
     */
    public void setRzqd(String  rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [SGJSRQ]
     */
    public void setSgjsrq(Timestamp  sgjsrq){
        this.sgjsrq = sgjsrq ;
        this.modify("sgjsrq",sgjsrq);
    }

    /**
     * 设置 [ZZMM]
     */
    public void setZzmm(String  zzmm){
        this.zzmm = zzmm ;
        this.modify("zzmm",zzmm);
    }

    /**
     * 设置 [JXDQ]
     */
    public void setJxdq(Timestamp  jxdq){
        this.jxdq = jxdq ;
        this.modify("jxdq",jxdq);
    }

    /**
     * 设置 [KHCJ]
     */
    public void setKhcj(String  khcj){
        this.khcj = khcj ;
        this.modify("khcj",khcj);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [SUPERUSER]
     */
    public void setSuperuser(Integer  superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
    }

    /**
     * 设置 [SGKSRQ]
     */
    public void setSgksrq(Timestamp  sgksrq){
        this.sgksrq = sgksrq ;
        this.modify("sgksrq",sgksrq);
    }

    /**
     * 设置 [NUMCODE]
     */
    public void setNumcode(Integer  numcode){
        this.numcode = numcode ;
        this.modify("numcode",numcode);
    }

    /**
     * 设置 [CFYXJSRQ]
     */
    public void setCfyxjsrq(Timestamp  cfyxjsrq){
        this.cfyxjsrq = cfyxjsrq ;
        this.modify("cfyxjsrq",cfyxjsrq);
    }

    /**
     * 设置 [CERTTIFICATE]
     */
    public void setCerttificate(String  certtificate){
        this.certtificate = certtificate ;
        this.modify("certtificate",certtificate);
    }

    /**
     * 设置 [CSRQ]
     */
    public void setCsrq(Timestamp  csrq){
        this.csrq = csrq ;
        this.modify("csrq",csrq);
    }

    /**
     * 设置 [LEAVEDATE]
     */
    public void setLeavedate(Timestamp  leavedate){
        this.leavedate = leavedate ;
        this.modify("leavedate",leavedate);
    }

    /**
     * 设置 [FIRSTEDUCATION]
     */
    public void setFirsteducation(String  firsteducation){
        this.firsteducation = firsteducation ;
        this.modify("firsteducation",firsteducation);
    }

    /**
     * 设置 [GLY]
     */
    public void setGly(Integer  gly){
        this.gly = gly ;
        this.modify("gly",gly);
    }

    /**
     * 设置 [JXSYWDS]
     */
    public void setJxsywds(String  jxsywds){
        this.jxsywds = jxsywds ;
        this.modify("jxsywds",jxsywds);
    }

    /**
     * 设置 [RZNX]
     */
    public void setRznx(Double  rznx){
        this.rznx = rznx ;
        this.modify("rznx",rznx);
    }

    /**
     * 设置 [HQXLBYYX]
     */
    public void setHqxlbyyx(String  hqxlbyyx){
        this.hqxlbyyx = hqxlbyyx ;
        this.modify("hqxlbyyx",hqxlbyyx);
    }

    /**
     * 设置 [YGZT]
     */
    public void setYgzt(String  ygzt){
        this.ygzt = ygzt ;
        this.modify("ygzt",ygzt);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(String  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [RCXLLX]
     */
    public void setRcxllx(String  rcxllx){
        this.rcxllx = rcxllx ;
        this.modify("rcxllx",rcxllx);
    }

    /**
     * 设置 [HQXLSXZY]
     */
    public void setHqxlsxzy(String  hqxlsxzy){
        this.hqxlsxzy = hqxlsxzy ;
        this.modify("hqxlsxzy",hqxlsxzy);
    }

    /**
     * 设置 [GZBM]
     */
    public void setGzbm(String  gzbm){
        this.gzbm = gzbm ;
        this.modify("gzbm",gzbm);
    }

    /**
     * 设置 [ZWRQ]
     */
    public void setZwrq(Timestamp  zwrq){
        this.zwrq = zwrq ;
        this.modify("zwrq",zwrq);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [DARDSJ]
     */
    public void setDardsj(Timestamp  dardsj){
        this.dardsj = dardsj ;
        this.modify("dardsj",dardsj);
    }

    /**
     * 设置 [DZYX]
     */
    public void setDzyx(String  dzyx){
        this.dzyx = dzyx ;
        this.modify("dzyx",dzyx);
    }

    /**
     * 设置 [HKLX]
     */
    public void setHklx(String  hklx){
        this.hklx = hklx ;
        this.modify("hklx",hklx);
    }

    /**
     * 设置 [GLY2]
     */
    public void setGly2(Integer  gly2){
        this.gly2 = gly2 ;
        this.modify("gly2",gly2);
    }

    /**
     * 设置 [RETIPLACE]
     */
    public void setRetiplace(String  retiplace){
        this.retiplace = retiplace ;
        this.modify("retiplace",retiplace);
    }

    /**
     * 设置 [HIGHEDUCATION]
     */
    public void setHigheducation(String  higheducation){
        this.higheducation = higheducation ;
        this.modify("higheducation",higheducation);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [ZJ]
     */
    public void setZj(String  zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [HYZK]
     */
    public void setHyzk(String  hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }

    /**
     * 设置 [DYXLSSZY]
     */
    public void setDyxlsszy(String  dyxlsszy){
        this.dyxlsszy = dyxlsszy ;
        this.modify("dyxlsszy",dyxlsszy);
    }

    /**
     * 设置 [TXDQ]
     */
    public void setTxdq(Timestamp  txdq){
        this.txdq = txdq ;
        this.modify("txdq",txdq);
    }

    /**
     * 设置 [PORTALUSERID]
     */
    public void setPortaluserid(String  portaluserid){
        this.portaluserid = portaluserid ;
        this.modify("portaluserid",portaluserid);
    }

    /**
     * 设置 [SFTBERP]
     */
    public void setSftberp(String  sftberp){
        this.sftberp = sftberp ;
        this.modify("sftberp",sftberp);
    }

    /**
     * 设置 [KHCJTX]
     */
    public void setKhcjtx(Double  khcjtx){
        this.khcjtx = khcjtx ;
        this.modify("khcjtx",khcjtx);
    }

    /**
     * 设置 [DACJGZSJ]
     */
    public void setDacjgzsj(Timestamp  dacjgzsj){
        this.dacjgzsj = dacjgzsj ;
        this.modify("dacjgzsj",dacjgzsj);
    }

    /**
     * 设置 [JZRZ]
     */
    public void setJzrz(String  jzrz){
        this.jzrz = jzrz ;
        this.modify("jzrz",jzrz);
    }

    /**
     * 设置 [SJTXRQ]
     */
    public void setSjtxrq(Timestamp  sjtxrq){
        this.sjtxrq = sjtxrq ;
        this.modify("sjtxrq",sjtxrq);
    }

    /**
     * 设置 [XX]
     */
    public void setXx(String  xx){
        this.xx = xx ;
        this.modify("xx",xx);
    }

    /**
     * 设置 [JXSSXDS]
     */
    public void setJxssxds(String  jxssxds){
        this.jxssxds = jxssxds ;
        this.modify("jxssxds",jxssxds);
    }

    /**
     * 设置 [DYXLBYYX]
     */
    public void setDyxlbyyx(String  dyxlbyyx){
        this.dyxlbyyx = dyxlbyyx ;
        this.modify("dyxlbyyx",dyxlbyyx);
    }

    /**
     * 设置 [RZSJ]
     */
    public void setRzsj(Timestamp  rzsj){
        this.rzsj = rzsj ;
        this.modify("rzsj",rzsj);
    }

    /**
     * 设置 [SFDSZN]
     */
    public void setSfdszn(String  sfdszn){
        this.sfdszn = sfdszn ;
        this.modify("sfdszn",sfdszn);
    }

    /**
     * 设置 [XTBH]
     */
    public void setXtbh(String  xtbh){
        this.xtbh = xtbh ;
        this.modify("xtbh",xtbh);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [WORKSTATE]
     */
    public void setWorkstate(String  workstate){
        this.workstate = workstate ;
        this.modify("workstate",workstate);
    }

    /**
     * 设置 [CJGZSJ]
     */
    public void setCjgzsj(Timestamp  cjgzsj){
        this.cjgzsj = cjgzsj ;
        this.modify("cjgzsj",cjgzsj);
    }

    /**
     * 设置 [GWKSRQ]
     */
    public void setGwksrq(Timestamp  gwksrq){
        this.gwksrq = gwksrq ;
        this.modify("gwksrq",gwksrq);
    }

    /**
     * 设置 [TOZJDATE]
     */
    public void setTozjdate(Timestamp  tozjdate){
        this.tozjdate = tozjdate ;
        this.modify("tozjdate",tozjdate);
    }

    /**
     * 设置 [ZJHM]
     */
    public void setZjhm(String  zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [BLACKLISTREASONS]
     */
    public void setBlacklistreasons(String  blacklistreasons){
        this.blacklistreasons = blacklistreasons ;
        this.modify("blacklistreasons",blacklistreasons);
    }

    /**
     * 设置 [HJDZ]
     */
    public void setHjdz(String  hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [ZWNX]
     */
    public void setZwnx(String  zwnx){
        this.zwnx = zwnx ;
        this.modify("zwnx",zwnx);
    }

    /**
     * 设置 [RTSJ]
     */
    public void setRtsj(Timestamp  rtsj){
        this.rtsj = rtsj ;
        this.modify("rtsj",rtsj);
    }

    /**
     * 设置 [SGYY]
     */
    public void setSgyy(String  sgyy){
        this.sgyy = sgyy ;
        this.modify("sgyy",sgyy);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [LGNX_COLOR]
     */
    public void setLgnxColor(String  lgnxColor){
        this.lgnxColor = lgnxColor ;
        this.modify("lgnx_color",lgnxColor);
    }

    /**
     * 设置 [YJSNF]
     */
    public void setYjsnf(String  yjsnf){
        this.yjsnf = yjsnf ;
        this.modify("yjsnf",yjsnf);
    }

    /**
     * 设置 [RANKRQ]
     */
    public void setRankrq(Timestamp  rankrq){
        this.rankrq = rankrq ;
        this.modify("rankrq",rankrq);
    }

    /**
     * 设置 [ZP]
     */
    public void setZp(String  zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [LGNX]
     */
    public void setLgnx(String  lgnx){
        this.lgnx = lgnx ;
        this.modify("lgnx",lgnx);
    }

    /**
     * 设置 [JTLXR]
     */
    public void setJtlxr(String  jtlxr){
        this.jtlxr = jtlxr ;
        this.modify("jtlxr",jtlxr);
    }

    /**
     * 设置 [SYQDQSJ]
     */
    public void setSyqdqsj(Timestamp  syqdqsj){
        this.syqdqsj = syqdqsj ;
        this.modify("syqdqsj",syqdqsj);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [HTQDCS]
     */
    public void setHtqdcs(String  htqdcs){
        this.htqdcs = htqdcs ;
        this.modify("htqdcs",htqdcs);
    }

    /**
     * 设置 [MZ]
     */
    public void setMz(String  mz){
        this.mz = mz ;
        this.modify("mz",mz);
    }

    /**
     * 设置 [SFZ]
     */
    public void setSfz(String  sfz){
        this.sfz = sfz ;
        this.modify("sfz",sfz);
    }

    /**
     * 设置 [RZNLDQ_COLOR]
     */
    public void setRznldqColor(String  rznldqColor){
        this.rznldqColor = rznldqColor ;
        this.modify("rznldq_color",rznldqColor);
    }

    /**
     * 设置 [YDZT]
     */
    public void setYdzt(String  ydzt){
        this.ydzt = ydzt ;
        this.modify("ydzt",ydzt);
    }

    /**
     * 设置 [YGBHQYSJ]
     */
    public void setYgbhqysj(Timestamp  ygbhqysj){
        this.ygbhqysj = ygbhqysj ;
        this.modify("ygbhqysj",ygbhqysj);
    }

    /**
     * 设置 [PIMPERSONNAME3]
     */
    public void setPimpersonname3(String  pimpersonname3){
        this.pimpersonname3 = pimpersonname3 ;
        this.modify("pimpersonname3",pimpersonname3);
    }

    /**
     * 设置 [PIMPERSONNAME2]
     */
    public void setPimpersonname2(String  pimpersonname2){
        this.pimpersonname2 = pimpersonname2 ;
        this.modify("pimpersonname2",pimpersonname2);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [ORGTYPE]
     */
    public void setOrgtype(String  orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [PCMRCXLID]
     */
    public void setPcmrcxlid(String  pcmrcxlid){
        this.pcmrcxlid = pcmrcxlid ;
        this.modify("pcmrcxlid",pcmrcxlid);
    }

    /**
     * 设置 [PIMPERSONID2]
     */
    public void setPimpersonid2(String  pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }

    /**
     * 设置 [PIMCITYID]
     */
    public void setPimcityid(String  pimcityid){
        this.pimcityid = pimcityid ;
        this.modify("pimcityid",pimcityid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PCMJXSYGZZJLMXID]
     */
    public void setPcmjxsygzzjlmxid(String  pcmjxsygzzjlmxid){
        this.pcmjxsygzzjlmxid = pcmjxsygzzjlmxid ;
        this.modify("pcmjxsygzzjlmxid",pcmjxsygzzjlmxid);
    }

    /**
     * 设置 [PIMMAJORSETYPEID]
     */
    public void setPimmajorsetypeid(String  pimmajorsetypeid){
        this.pimmajorsetypeid = pimmajorsetypeid ;
        this.modify("pimmajorsetypeid",pimmajorsetypeid);
    }

    /**
     * 设置 [PIMPERSONID3]
     */
    public void setPimpersonid3(String  pimpersonid3){
        this.pimpersonid3 = pimpersonid3 ;
        this.modify("pimpersonid3",pimpersonid3);
    }


}

