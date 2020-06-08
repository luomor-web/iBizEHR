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
 * 服务DTO对象[PcmGbhmcDTO]
 */
@Data
public class PcmGbhmcDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [DAXL]
     *
     */
    @JSONField(name = "daxl")
    @JsonProperty("daxl")
    private String daxl;

    /**
     * 属性 [RZNLDQ]
     *
     */
    @JSONField(name = "rznldq")
    @JsonProperty("rznldq")
    private String rznldq;

    /**
     * 属性 [ZYJSZW]
     *
     */
    @JSONField(name = "zyjszw")
    @JsonProperty("zyjszw")
    private String zyjszw;

    /**
     * 属性 [ISLEADERTEAM]
     *
     */
    @JSONField(name = "isleaderteam")
    @JsonProperty("isleaderteam")
    private Integer isleaderteam;

    /**
     * 属性 [MZ]
     *
     */
    @JSONField(name = "mz")
    @JsonProperty("mz")
    private String mz;

    /**
     * 属性 [HIGHEDUCATION]
     *
     */
    @JSONField(name = "higheducation")
    @JsonProperty("higheducation")
    private String higheducation;

    /**
     * 属性 [ZYZG2]
     *
     */
    @JSONField(name = "zyzg2")
    @JsonProperty("zyzg2")
    private String zyzg2;

    /**
     * 属性 [DYXLSSZY2]
     *
     */
    @JSONField(name = "dyxlsszy2")
    @JsonProperty("dyxlsszy2")
    private String dyxlsszy2;

    /**
     * 属性 [ZT2]
     *
     */
    @JSONField(name = "zt2")
    @JsonProperty("zt2")
    private String zt2;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [LGNX2]
     *
     */
    @JSONField(name = "lgnx2")
    @JsonProperty("lgnx2")
    private String lgnx2;

    /**
     * 属性 [RANKRQ]
     *
     */
    @JSONField(name = "rankrq")
    @JsonProperty("rankrq")
    private Timestamp rankrq;

    /**
     * 属性 [RZSJ]
     *
     */
    @JSONField(name = "rzsj")
    @JsonProperty("rzsj")
    private Timestamp rzsj;

    /**
     * 属性 [SGKSRQ2]
     *
     */
    @JSONField(name = "sgksrq2")
    @JsonProperty("sgksrq2")
    private Timestamp sgksrq2;

    /**
     * 属性 [RZDQ]
     *
     */
    @JSONField(name = "rzdq")
    @JsonProperty("rzdq")
    private Timestamp rzdq;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [DARDSJ]
     *
     */
    @JSONField(name = "dardsj")
    @JsonProperty("dardsj")
    private Timestamp dardsj;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [ZWRQ]
     *
     */
    @JSONField(name = "zwrq")
    @JsonProperty("zwrq")
    private Timestamp zwrq;

    /**
     * 属性 [CFYXJSRQ2]
     *
     */
    @JSONField(name = "cfyxjsrq2")
    @JsonProperty("cfyxjsrq2")
    private Timestamp cfyxjsrq2;

    /**
     * 属性 [POSTEXPIRATION2]
     *
     */
    @JSONField(name = "postexpiration2")
    @JsonProperty("postexpiration2")
    private String postexpiration2;

    /**
     * 属性 [KHCJTX2]
     *
     */
    @JSONField(name = "khcjtx2")
    @JsonProperty("khcjtx2")
    private Double khcjtx2;

    /**
     * 属性 [ZJNX2]
     *
     */
    @JSONField(name = "zjnx2")
    @JsonProperty("zjnx2")
    private Double zjnx2;

    /**
     * 属性 [HQXLBYYX2]
     *
     */
    @JSONField(name = "hqxlbyyx2")
    @JsonProperty("hqxlbyyx2")
    private String hqxlbyyx2;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [JZRZ2]
     *
     */
    @JSONField(name = "jzrz2")
    @JsonProperty("jzrz2")
    private String jzrz2;

    /**
     * 属性 [RZNLDQ_COLOR]
     *
     */
    @JSONField(name = "rznldq_color")
    @JsonProperty("rznldq_color")
    private String rznldqColor;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [KHCJ]
     *
     */
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;

    /**
     * 属性 [DACSRQ]
     *
     */
    @JSONField(name = "dacsrq")
    @JsonProperty("dacsrq")
    private Timestamp dacsrq;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [LGNX2_COLOR]
     *
     */
    @JSONField(name = "lgnx2_color")
    @JsonProperty("lgnx2_color")
    private String lgnx2Color;

    /**
     * 属性 [HQXLSXZY2]
     *
     */
    @JSONField(name = "hqxlsxzy2")
    @JsonProperty("hqxlsxzy2")
    private String hqxlsxzy2;

    /**
     * 属性 [DACJGZSJ]
     *
     */
    @JSONField(name = "dacjgzsj")
    @JsonProperty("dacjgzsj")
    private Timestamp dacjgzsj;

    /**
     * 属性 [RDSJ]
     *
     */
    @JSONField(name = "rdsj")
    @JsonProperty("rdsj")
    private Timestamp rdsj;

    /**
     * 属性 [LGKSSJ2]
     *
     */
    @JSONField(name = "lgkssj2")
    @JsonProperty("lgkssj2")
    private Timestamp lgkssj2;

    /**
     * 属性 [SYCZJRQ2]
     *
     */
    @JSONField(name = "syczjrq2")
    @JsonProperty("syczjrq2")
    private Timestamp syczjrq2;

    /**
     * 属性 [JG]
     *
     */
    @JSONField(name = "jg")
    @JsonProperty("jg")
    private String jg;

    /**
     * 属性 [KHCJTX]
     *
     */
    @JSONField(name = "khcjtx")
    @JsonProperty("khcjtx")
    private Double khcjtx;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [RZNX]
     *
     */
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Double rznx;

    /**
     * 属性 [RZNX2]
     *
     */
    @JSONField(name = "rznx2")
    @JsonProperty("rznx2")
    private Double rznx2;

    /**
     * 属性 [ORGTYPE]
     *
     */
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;

    /**
     * 属性 [RTSJ]
     *
     */
    @JSONField(name = "rtsj")
    @JsonProperty("rtsj")
    private Timestamp rtsj;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [FIRSTEDUCATION]
     *
     */
    @JSONField(name = "firsteducation")
    @JsonProperty("firsteducation")
    private String firsteducation;

    /**
     * 属性 [DZJBJSJ]
     *
     */
    @JSONField(name = "dzjbjsj")
    @JsonProperty("dzjbjsj")
    private Timestamp dzjbjsj;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [ZWNX2]
     *
     */
    @JSONField(name = "zwnx2")
    @JsonProperty("zwnx2")
    private String zwnx2;

    /**
     * 属性 [DYXLBYSJ2]
     *
     */
    @JSONField(name = "dyxlbysj2")
    @JsonProperty("dyxlbysj2")
    private Timestamp dyxlbysj2;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [SYCZJRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syczjrq" , format="yyyy-MM-dd")
    @JsonProperty("syczjrq")
    private Timestamp syczjrq;

    /**
     * 属性 [CJGZSJ]
     *
     */
    @JSONField(name = "cjgzsj")
    @JsonProperty("cjgzsj")
    private Timestamp cjgzsj;

    /**
     * 属性 [SGJSRQ2]
     *
     */
    @JSONField(name = "sgjsrq2")
    @JsonProperty("sgjsrq2")
    private Timestamp sgjsrq2;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [CSRQ]
     *
     */
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [DYXLBYYX2]
     *
     */
    @JSONField(name = "dyxlbyyx2")
    @JsonProperty("dyxlbyyx2")
    private String dyxlbyyx2;

    /**
     * 属性 [ZGCODE]
     *
     */
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;



}

