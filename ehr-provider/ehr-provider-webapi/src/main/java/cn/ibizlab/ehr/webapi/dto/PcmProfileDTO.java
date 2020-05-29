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
 * 服务DTO对象[PcmProfileDTO]
 */
@Data
public class PcmProfileDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GWLB]
     *
     */
    @JSONField(name = "gwlb")
    @JsonProperty("gwlb")
    private String gwlb;

    /**
     * 属性 [R_LASTDISCIPLINE]
     *
     */
    @JSONField(name = "r_lastdiscipline")
    @JsonProperty("r_lastdiscipline")
    private String rLastdiscipline;

    /**
     * 属性 [RDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rdsj" , format="yyyy-MM-dd")
    @JsonProperty("rdsj")
    private Timestamp rdsj;

    /**
     * 属性 [WBZZJGDM]
     *
     */
    @JSONField(name = "wbzzjgdm")
    @JsonProperty("wbzzjgdm")
    private String wbzzjgdm;

    /**
     * 属性 [BLOODTYPE]
     *
     */
    @JSONField(name = "bloodtype")
    @JsonProperty("bloodtype")
    private String bloodtype;

    /**
     * 属性 [TJQK]
     *
     */
    @JSONField(name = "tjqk")
    @JsonProperty("tjqk")
    private String tjqk;

    /**
     * 属性 [R_SCHOOLIS211]
     *
     */
    @JSONField(name = "r_schoolis211")
    @JsonProperty("r_schoolis211")
    private String rSchoolis211;

    /**
     * 属性 [SZYJTJ]
     *
     */
    @JSONField(name = "szyjtj")
    @JsonProperty("szyjtj")
    private String szyjtj;

    /**
     * 属性 [APPLICANTID]
     *
     */
    @JSONField(name = "applicantid")
    @JsonProperty("applicantid")
    private String applicantid;

    /**
     * 属性 [R_SCHOOLIS985]
     *
     */
    @JSONField(name = "r_schoolis985")
    @JsonProperty("r_schoolis985")
    private String rSchoolis985;

    /**
     * 属性 [YZBM]
     *
     */
    @JSONField(name = "yzbm")
    @JsonProperty("yzbm")
    private String yzbm;

    /**
     * 属性 [RESIDENCESTATE]
     *
     */
    @JSONField(name = "residencestate")
    @JsonProperty("residencestate")
    private String residencestate;

    /**
     * 属性 [XKML]
     *
     */
    @JSONField(name = "xkml")
    @JsonProperty("xkml")
    private String xkml;

    /**
     * 属性 [JZPSPYJYY]
     *
     */
    @JSONField(name = "jzpspyjyy")
    @JsonProperty("jzpspyjyy")
    private String jzpspyjyy;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CZ2]
     *
     */
    @JSONField(name = "cz2")
    @JsonProperty("cz2")
    private String cz2;

    /**
     * 属性 [NF]
     *
     */
    @JSONField(name = "nf")
    @JsonProperty("nf")
    private String nf;

    /**
     * 属性 [PHASEINFO]
     *
     */
    @JSONField(name = "phaseinfo")
    @JsonProperty("phaseinfo")
    private String phaseinfo;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [GZKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;

    /**
     * 属性 [NQDLDHTQX]
     *
     */
    @JSONField(name = "nqdldhtqx")
    @JsonProperty("nqdldhtqx")
    private String nqdldhtqx;

    /**
     * 属性 [YGLXSHGZ]
     *
     */
    @JSONField(name = "yglxshgz")
    @JsonProperty("yglxshgz")
    private String yglxshgz;

    /**
     * 属性 [HIGHESTDEGREE]
     *
     */
    @JSONField(name = "highestdegree")
    @JsonProperty("highestdegree")
    private String highestdegree;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [RZQD]
     *
     */
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;

    /**
     * 属性 [CYM]
     *
     */
    @JSONField(name = "cym")
    @JsonProperty("cym")
    private String cym;

    /**
     * 属性 [RPR]
     *
     */
    @JSONField(name = "rpr")
    @JsonProperty("rpr")
    private String rpr;

    /**
     * 属性 [JZBSPYJYY]
     *
     */
    @JSONField(name = "jzbspyjyy")
    @JsonProperty("jzbspyjyy")
    private String jzbspyjyy;

    /**
     * 属性 [YGLX]
     *
     */
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;

    /**
     * 属性 [YWZDJBS]
     *
     */
    @JSONField(name = "ywzdjbs")
    @JsonProperty("ywzdjbs")
    private String ywzdjbs;

    /**
     * 属性 [HOBBIES]
     *
     */
    @JSONField(name = "hobbies")
    @JsonProperty("hobbies")
    private String hobbies;

    /**
     * 属性 [RLSB_YPZZT]
     *
     */
    @JSONField(name = "rlsb_ypzzt")
    @JsonProperty("rlsb_ypzzt")
    private String rlsbYpzzt;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ELINKURL]
     *
     */
    @JSONField(name = "elinkurl")
    @JsonProperty("elinkurl")
    private String elinkurl;

    /**
     * 属性 [MOBILE]
     *
     */
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 属性 [WBZW]
     *
     */
    @JSONField(name = "wbzw")
    @JsonProperty("wbzw")
    private String wbzw;

    /**
     * 属性 [PERSONNELFILEPLACE]
     *
     */
    @JSONField(name = "personnelfileplace")
    @JsonProperty("personnelfileplace")
    private String personnelfileplace;

    /**
     * 属性 [ZTYY]
     *
     */
    @JSONField(name = "ztyy")
    @JsonProperty("ztyy")
    private String ztyy;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZCZS]
     *
     */
    @JSONField(name = "zczs")
    @JsonProperty("zczs")
    private String zczs;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [CADIDATEID]
     *
     */
    @JSONField(name = "cadidateid")
    @JsonProperty("cadidateid")
    private String cadidateid;

    /**
     * 属性 [ISBLACKLISTREASON]
     *
     */
    @JSONField(name = "isblacklistreason")
    @JsonProperty("isblacklistreason")
    private String isblacklistreason;

    /**
     * 属性 [QZFJ]
     *
     */
    @JSONField(name = "qzfj")
    @JsonProperty("qzfj")
    private String qzfj;

    /**
     * 属性 [EDUCATIONLEVEL]
     *
     */
    @JSONField(name = "educationlevel")
    @JsonProperty("educationlevel")
    private String educationlevel;

    /**
     * 属性 [DEGREETYPE]
     *
     */
    @JSONField(name = "degreetype")
    @JsonProperty("degreetype")
    private String degreetype;

    /**
     * 属性 [HJDZ]
     *
     */
    @JSONField(name = "hjdz")
    @JsonProperty("hjdz")
    private String hjdz;

    /**
     * 属性 [ZPLX]
     *
     */
    @JSONField(name = "zplx")
    @JsonProperty("zplx")
    private String zplx;

    /**
     * 属性 [YJSNF]
     *
     */
    @JSONField(name = "yjsnf")
    @JsonProperty("yjsnf")
    private String yjsnf;

    /**
     * 属性 [ZTCODE]
     *
     */
    @JSONField(name = "ztcode")
    @JsonProperty("ztcode")
    private String ztcode;

    /**
     * 属性 [ADDRESS]
     *
     */
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 属性 [SYQDQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "syqdqsj" , format="yyyy-MM-dd")
    @JsonProperty("syqdqsj")
    private Timestamp syqdqsj;

    /**
     * 属性 [R_LASTSCHOOL]
     *
     */
    @JSONField(name = "r_lastschool")
    @JsonProperty("r_lastschool")
    private String rLastschool;

    /**
     * 属性 [R_INITIALIZEAPPLYDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "r_initializeapplydate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("r_initializeapplydate")
    private Timestamp rInitializeapplydate;

    /**
     * 属性 [NATIVEPLACE]
     *
     */
    @JSONField(name = "nativeplace")
    @JsonProperty("nativeplace")
    private String nativeplace;

    /**
     * 属性 [CZ5]
     *
     */
    @JSONField(name = "cz5")
    @JsonProperty("cz5")
    private String cz5;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [JZBSPYJ]
     *
     */
    @JSONField(name = "jzbspyj")
    @JsonProperty("jzbspyj")
    private String jzbspyj;

    /**
     * 属性 [GRADUATIONDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "graduationdate" , format="yyyy-MM-dd")
    @JsonProperty("graduationdate")
    private Timestamp graduationdate;

    /**
     * 属性 [SFZ]
     *
     */
    @JSONField(name = "sfz")
    @JsonProperty("sfz")
    private String sfz;

    /**
     * 属性 [CERTIFICATETYPE]
     *
     */
    @JSONField(name = "certificatetype")
    @JsonProperty("certificatetype")
    private String certificatetype;

    /**
     * 属性 [ISBLACKLIST]
     *
     */
    @JSONField(name = "isblacklist")
    @JsonProperty("isblacklist")
    private Integer isblacklist;

    /**
     * 属性 [OTHERFILE]
     *
     */
    @JSONField(name = "otherfile")
    @JsonProperty("otherfile")
    private String otherfile;

    /**
     * 属性 [NATION]
     *
     */
    @JSONField(name = "nation")
    @JsonProperty("nation")
    private String nation;

    /**
     * 属性 [EMAIL]
     *
     */
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;

    /**
     * 属性 [ISABROAD]
     *
     */
    @JSONField(name = "isabroad")
    @JsonProperty("isabroad")
    private String isabroad;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [SFTGCP]
     *
     */
    @JSONField(name = "sftgcp")
    @JsonProperty("sftgcp")
    private String sftgcp;

    /**
     * 属性 [JKZK]
     *
     */
    @JSONField(name = "jkzk")
    @JsonProperty("jkzk")
    private String jkzk;

    /**
     * 属性 [CSD]
     *
     */
    @JSONField(name = "csd")
    @JsonProperty("csd")
    private String csd;

    /**
     * 属性 [JLDSPYJYY]
     *
     */
    @JSONField(name = "jldspyjyy")
    @JsonProperty("jldspyjyy")
    private String jldspyjyy;

    /**
     * 属性 [PCMYDGZMXID]
     *
     */
    @JSONField(name = "pcmydgzmxid")
    @JsonProperty("pcmydgzmxid")
    private String pcmydgzmxid;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [ZP]
     *
     */
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;

    /**
     * 属性 [NAPXMJGWMC]
     *
     */
    @JSONField(name = "napxmjgwmc")
    @JsonProperty("napxmjgwmc")
    private String napxmjgwmc;

    /**
     * 属性 [SFXZY]
     *
     */
    @JSONField(name = "sfxzy")
    @JsonProperty("sfxzy")
    private String sfxzy;

    /**
     * 属性 [ZCZS2]
     *
     */
    @JSONField(name = "zczs2")
    @JsonProperty("zczs2")
    private String zczs2;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [JSPYJ_RLSB]
     *
     */
    @JSONField(name = "jspyj_rlsb")
    @JsonProperty("jspyj_rlsb")
    private String jspyjRlsb;

    /**
     * 属性 [GENDER]
     *
     */
    @JSONField(name = "gender")
    @JsonProperty("gender")
    private String gender;

    /**
     * 属性 [WORKBEGINDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "workbegindate" , format="yyyy-MM-dd")
    @JsonProperty("workbegindate")
    private Timestamp workbegindate;

    /**
     * 属性 [WBGW]
     *
     */
    @JSONField(name = "wbgw")
    @JsonProperty("wbgw")
    private String wbgw;

    /**
     * 属性 [WBZZ]
     *
     */
    @JSONField(name = "wbzz")
    @JsonProperty("wbzz")
    private String wbzz;

    /**
     * 属性 [R_CERTNAMES]
     *
     */
    @JSONField(name = "r_certnames")
    @JsonProperty("r_certnames")
    private String rCertnames;

    /**
     * 属性 [SBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="yyyy-MM-dd")
    @JsonProperty("sbsj")
    private Timestamp sbsj;

    /**
     * 属性 [GZBT]
     *
     */
    @JSONField(name = "gzbt")
    @JsonProperty("gzbt")
    private Double gzbt;

    /**
     * 属性 [RTSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rtsj" , format="yyyy-MM-dd")
    @JsonProperty("rtsj")
    private Timestamp rtsj;

    /**
     * 属性 [NAPXM]
     *
     */
    @JSONField(name = "napxm")
    @JsonProperty("napxm")
    private String napxm;

    /**
     * 属性 [XXXZ]
     *
     */
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;

    /**
     * 属性 [CZ3]
     *
     */
    @JSONField(name = "cz3")
    @JsonProperty("cz3")
    private String cz3;

    /**
     * 属性 [JLDSPYJ]
     *
     */
    @JSONField(name = "jldspyj")
    @JsonProperty("jldspyj")
    private String jldspyj;

    /**
     * 属性 [WBBM]
     *
     */
    @JSONField(name = "wbbm")
    @JsonProperty("wbbm")
    private String wbbm;

    /**
     * 属性 [SFXZBJNBRY]
     *
     */
    @JSONField(name = "sfxzbjnbry")
    @JsonProperty("sfxzbjnbry")
    private String sfxzbjnbry;

    /**
     * 属性 [ENTRANTDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "entrantdate" , format="yyyy-MM-dd")
    @JsonProperty("entrantdate")
    private Timestamp entrantdate;

    /**
     * 属性 [JZPSPYJ]
     *
     */
    @JSONField(name = "jzpspyj")
    @JsonProperty("jzpspyj")
    private String jzpspyj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [YYDJMC]
     *
     */
    @JSONField(name = "yydjmc")
    @JsonProperty("yydjmc")
    private String yydjmc;

    /**
     * 属性 [BIRTHDAY]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "birthday" , format="yyyy-MM-dd")
    @JsonProperty("birthday")
    private Timestamp birthday;

    /**
     * 属性 [YYDJ]
     *
     */
    @JSONField(name = "yydj")
    @JsonProperty("yydj")
    private String yydj;

    /**
     * 属性 [POLITY]
     *
     */
    @JSONField(name = "polity")
    @JsonProperty("polity")
    private String polity;

    /**
     * 属性 [GZJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;

    /**
     * 属性 [WEDSTATE]
     *
     */
    @JSONField(name = "wedstate")
    @JsonProperty("wedstate")
    private String wedstate;

    /**
     * 属性 [CZ4]
     *
     */
    @JSONField(name = "cz4")
    @JsonProperty("cz4")
    private String cz4;

    /**
     * 属性 [RGJYTG]
     *
     */
    @JSONField(name = "rgjytg")
    @JsonProperty("rgjytg")
    private String rgjytg;

    /**
     * 属性 [XZC]
     *
     */
    @JSONField(name = "xzc")
    @JsonProperty("xzc")
    private String xzc;

    /**
     * 属性 [HKLX]
     *
     */
    @JSONField(name = "hklx")
    @JsonProperty("hklx")
    private String hklx;

    /**
     * 属性 [QZSM]
     *
     */
    @JSONField(name = "qzsm")
    @JsonProperty("qzsm")
    private String qzsm;

    /**
     * 属性 [XZNF]
     *
     */
    @JSONField(name = "xznf")
    @JsonProperty("xznf")
    private String xznf;

    /**
     * 属性 [EDUCATIONSTUDYMODE]
     *
     */
    @JSONField(name = "educationstudymode")
    @JsonProperty("educationstudymode")
    private String educationstudymode;

    /**
     * 属性 [PROFILETYPE]
     *
     */
    @JSONField(name = "profiletype")
    @JsonProperty("profiletype")
    private String profiletype;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [CHECKRESULT]
     *
     */
    @JSONField(name = "checkresult")
    @JsonProperty("checkresult")
    private String checkresult;


    /**
     * 设置 [GWLB]
     */
    public void setGwlb(String  gwlb){
        this.gwlb = gwlb ;
        this.modify("gwlb",gwlb);
    }

    /**
     * 设置 [R_LASTDISCIPLINE]
     */
    public void setRLastdiscipline(String  rLastdiscipline){
        this.rLastdiscipline = rLastdiscipline ;
        this.modify("r_lastdiscipline",rLastdiscipline);
    }

    /**
     * 设置 [RDSJ]
     */
    public void setRdsj(Timestamp  rdsj){
        this.rdsj = rdsj ;
        this.modify("rdsj",rdsj);
    }

    /**
     * 设置 [WBZZJGDM]
     */
    public void setWbzzjgdm(String  wbzzjgdm){
        this.wbzzjgdm = wbzzjgdm ;
        this.modify("wbzzjgdm",wbzzjgdm);
    }

    /**
     * 设置 [BLOODTYPE]
     */
    public void setBloodtype(String  bloodtype){
        this.bloodtype = bloodtype ;
        this.modify("bloodtype",bloodtype);
    }

    /**
     * 设置 [TJQK]
     */
    public void setTjqk(String  tjqk){
        this.tjqk = tjqk ;
        this.modify("tjqk",tjqk);
    }

    /**
     * 设置 [R_SCHOOLIS211]
     */
    public void setRSchoolis211(String  rSchoolis211){
        this.rSchoolis211 = rSchoolis211 ;
        this.modify("r_schoolis211",rSchoolis211);
    }

    /**
     * 设置 [SZYJTJ]
     */
    public void setSzyjtj(String  szyjtj){
        this.szyjtj = szyjtj ;
        this.modify("szyjtj",szyjtj);
    }

    /**
     * 设置 [APPLICANTID]
     */
    public void setApplicantid(String  applicantid){
        this.applicantid = applicantid ;
        this.modify("applicantid",applicantid);
    }

    /**
     * 设置 [R_SCHOOLIS985]
     */
    public void setRSchoolis985(String  rSchoolis985){
        this.rSchoolis985 = rSchoolis985 ;
        this.modify("r_schoolis985",rSchoolis985);
    }

    /**
     * 设置 [YZBM]
     */
    public void setYzbm(String  yzbm){
        this.yzbm = yzbm ;
        this.modify("yzbm",yzbm);
    }

    /**
     * 设置 [RESIDENCESTATE]
     */
    public void setResidencestate(String  residencestate){
        this.residencestate = residencestate ;
        this.modify("residencestate",residencestate);
    }

    /**
     * 设置 [XKML]
     */
    public void setXkml(String  xkml){
        this.xkml = xkml ;
        this.modify("xkml",xkml);
    }

    /**
     * 设置 [JZPSPYJYY]
     */
    public void setJzpspyjyy(String  jzpspyjyy){
        this.jzpspyjyy = jzpspyjyy ;
        this.modify("jzpspyjyy",jzpspyjyy);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [CZ2]
     */
    public void setCz2(String  cz2){
        this.cz2 = cz2 ;
        this.modify("cz2",cz2);
    }

    /**
     * 设置 [NF]
     */
    public void setNf(String  nf){
        this.nf = nf ;
        this.modify("nf",nf);
    }

    /**
     * 设置 [PHASEINFO]
     */
    public void setPhaseinfo(String  phaseinfo){
        this.phaseinfo = phaseinfo ;
        this.modify("phaseinfo",phaseinfo);
    }

    /**
     * 设置 [GZKSSJ]
     */
    public void setGzkssj(Timestamp  gzkssj){
        this.gzkssj = gzkssj ;
        this.modify("gzkssj",gzkssj);
    }

    /**
     * 设置 [NQDLDHTQX]
     */
    public void setNqdldhtqx(String  nqdldhtqx){
        this.nqdldhtqx = nqdldhtqx ;
        this.modify("nqdldhtqx",nqdldhtqx);
    }

    /**
     * 设置 [YGLXSHGZ]
     */
    public void setYglxshgz(String  yglxshgz){
        this.yglxshgz = yglxshgz ;
        this.modify("yglxshgz",yglxshgz);
    }

    /**
     * 设置 [HIGHESTDEGREE]
     */
    public void setHighestdegree(String  highestdegree){
        this.highestdegree = highestdegree ;
        this.modify("highestdegree",highestdegree);
    }

    /**
     * 设置 [PCMPROFILENAME]
     */
    public void setPcmprofilename(String  pcmprofilename){
        this.pcmprofilename = pcmprofilename ;
        this.modify("pcmprofilename",pcmprofilename);
    }

    /**
     * 设置 [RZQD]
     */
    public void setRzqd(String  rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [CYM]
     */
    public void setCym(String  cym){
        this.cym = cym ;
        this.modify("cym",cym);
    }

    /**
     * 设置 [RPR]
     */
    public void setRpr(String  rpr){
        this.rpr = rpr ;
        this.modify("rpr",rpr);
    }

    /**
     * 设置 [JZBSPYJYY]
     */
    public void setJzbspyjyy(String  jzbspyjyy){
        this.jzbspyjyy = jzbspyjyy ;
        this.modify("jzbspyjyy",jzbspyjyy);
    }

    /**
     * 设置 [YGLX]
     */
    public void setYglx(String  yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [YWZDJBS]
     */
    public void setYwzdjbs(String  ywzdjbs){
        this.ywzdjbs = ywzdjbs ;
        this.modify("ywzdjbs",ywzdjbs);
    }

    /**
     * 设置 [HOBBIES]
     */
    public void setHobbies(String  hobbies){
        this.hobbies = hobbies ;
        this.modify("hobbies",hobbies);
    }

    /**
     * 设置 [ELINKURL]
     */
    public void setElinkurl(String  elinkurl){
        this.elinkurl = elinkurl ;
        this.modify("elinkurl",elinkurl);
    }

    /**
     * 设置 [MOBILE]
     */
    public void setMobile(String  mobile){
        this.mobile = mobile ;
        this.modify("mobile",mobile);
    }

    /**
     * 设置 [WBZW]
     */
    public void setWbzw(String  wbzw){
        this.wbzw = wbzw ;
        this.modify("wbzw",wbzw);
    }

    /**
     * 设置 [PERSONNELFILEPLACE]
     */
    public void setPersonnelfileplace(String  personnelfileplace){
        this.personnelfileplace = personnelfileplace ;
        this.modify("personnelfileplace",personnelfileplace);
    }

    /**
     * 设置 [ZTYY]
     */
    public void setZtyy(String  ztyy){
        this.ztyy = ztyy ;
        this.modify("ztyy",ztyy);
    }

    /**
     * 设置 [ZCZS]
     */
    public void setZczs(String  zczs){
        this.zczs = zczs ;
        this.modify("zczs",zczs);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [CADIDATEID]
     */
    public void setCadidateid(String  cadidateid){
        this.cadidateid = cadidateid ;
        this.modify("cadidateid",cadidateid);
    }

    /**
     * 设置 [ISBLACKLISTREASON]
     */
    public void setIsblacklistreason(String  isblacklistreason){
        this.isblacklistreason = isblacklistreason ;
        this.modify("isblacklistreason",isblacklistreason);
    }

    /**
     * 设置 [QZFJ]
     */
    public void setQzfj(String  qzfj){
        this.qzfj = qzfj ;
        this.modify("qzfj",qzfj);
    }

    /**
     * 设置 [EDUCATIONLEVEL]
     */
    public void setEducationlevel(String  educationlevel){
        this.educationlevel = educationlevel ;
        this.modify("educationlevel",educationlevel);
    }

    /**
     * 设置 [DEGREETYPE]
     */
    public void setDegreetype(String  degreetype){
        this.degreetype = degreetype ;
        this.modify("degreetype",degreetype);
    }

    /**
     * 设置 [HJDZ]
     */
    public void setHjdz(String  hjdz){
        this.hjdz = hjdz ;
        this.modify("hjdz",hjdz);
    }

    /**
     * 设置 [ZPLX]
     */
    public void setZplx(String  zplx){
        this.zplx = zplx ;
        this.modify("zplx",zplx);
    }

    /**
     * 设置 [YJSNF]
     */
    public void setYjsnf(String  yjsnf){
        this.yjsnf = yjsnf ;
        this.modify("yjsnf",yjsnf);
    }

    /**
     * 设置 [ADDRESS]
     */
    public void setAddress(String  address){
        this.address = address ;
        this.modify("address",address);
    }

    /**
     * 设置 [SYQDQSJ]
     */
    public void setSyqdqsj(Timestamp  syqdqsj){
        this.syqdqsj = syqdqsj ;
        this.modify("syqdqsj",syqdqsj);
    }

    /**
     * 设置 [R_LASTSCHOOL]
     */
    public void setRLastschool(String  rLastschool){
        this.rLastschool = rLastschool ;
        this.modify("r_lastschool",rLastschool);
    }

    /**
     * 设置 [R_INITIALIZEAPPLYDATE]
     */
    public void setRInitializeapplydate(Timestamp  rInitializeapplydate){
        this.rInitializeapplydate = rInitializeapplydate ;
        this.modify("r_initializeapplydate",rInitializeapplydate);
    }

    /**
     * 设置 [NATIVEPLACE]
     */
    public void setNativeplace(String  nativeplace){
        this.nativeplace = nativeplace ;
        this.modify("nativeplace",nativeplace);
    }

    /**
     * 设置 [CZ5]
     */
    public void setCz5(String  cz5){
        this.cz5 = cz5 ;
        this.modify("cz5",cz5);
    }

    /**
     * 设置 [CERTIFICATENUMBER]
     */
    public void setCertificatenumber(String  certificatenumber){
        this.certificatenumber = certificatenumber ;
        this.modify("certificatenumber",certificatenumber);
    }

    /**
     * 设置 [JZBSPYJ]
     */
    public void setJzbspyj(String  jzbspyj){
        this.jzbspyj = jzbspyj ;
        this.modify("jzbspyj",jzbspyj);
    }

    /**
     * 设置 [GRADUATIONDATE]
     */
    public void setGraduationdate(Timestamp  graduationdate){
        this.graduationdate = graduationdate ;
        this.modify("graduationdate",graduationdate);
    }

    /**
     * 设置 [SFZ]
     */
    public void setSfz(String  sfz){
        this.sfz = sfz ;
        this.modify("sfz",sfz);
    }

    /**
     * 设置 [CERTIFICATETYPE]
     */
    public void setCertificatetype(String  certificatetype){
        this.certificatetype = certificatetype ;
        this.modify("certificatetype",certificatetype);
    }

    /**
     * 设置 [ISBLACKLIST]
     */
    public void setIsblacklist(Integer  isblacklist){
        this.isblacklist = isblacklist ;
        this.modify("isblacklist",isblacklist);
    }

    /**
     * 设置 [OTHERFILE]
     */
    public void setOtherfile(String  otherfile){
        this.otherfile = otherfile ;
        this.modify("otherfile",otherfile);
    }

    /**
     * 设置 [NATION]
     */
    public void setNation(String  nation){
        this.nation = nation ;
        this.modify("nation",nation);
    }

    /**
     * 设置 [EMAIL]
     */
    public void setEmail(String  email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [ISABROAD]
     */
    public void setIsabroad(String  isabroad){
        this.isabroad = isabroad ;
        this.modify("isabroad",isabroad);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [SFTGCP]
     */
    public void setSftgcp(String  sftgcp){
        this.sftgcp = sftgcp ;
        this.modify("sftgcp",sftgcp);
    }

    /**
     * 设置 [JKZK]
     */
    public void setJkzk(String  jkzk){
        this.jkzk = jkzk ;
        this.modify("jkzk",jkzk);
    }

    /**
     * 设置 [CSD]
     */
    public void setCsd(String  csd){
        this.csd = csd ;
        this.modify("csd",csd);
    }

    /**
     * 设置 [JLDSPYJYY]
     */
    public void setJldspyjyy(String  jldspyjyy){
        this.jldspyjyy = jldspyjyy ;
        this.modify("jldspyjyy",jldspyjyy);
    }

    /**
     * 设置 [PCMYDGZMXID]
     */
    public void setPcmydgzmxid(String  pcmydgzmxid){
        this.pcmydgzmxid = pcmydgzmxid ;
        this.modify("pcmydgzmxid",pcmydgzmxid);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [ZP]
     */
    public void setZp(String  zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [NAPXMJGWMC]
     */
    public void setNapxmjgwmc(String  napxmjgwmc){
        this.napxmjgwmc = napxmjgwmc ;
        this.modify("napxmjgwmc",napxmjgwmc);
    }

    /**
     * 设置 [SFXZY]
     */
    public void setSfxzy(String  sfxzy){
        this.sfxzy = sfxzy ;
        this.modify("sfxzy",sfxzy);
    }

    /**
     * 设置 [ZCZS2]
     */
    public void setZczs2(String  zczs2){
        this.zczs2 = zczs2 ;
        this.modify("zczs2",zczs2);
    }

    /**
     * 设置 [GENDER]
     */
    public void setGender(String  gender){
        this.gender = gender ;
        this.modify("gender",gender);
    }

    /**
     * 设置 [WORKBEGINDATE]
     */
    public void setWorkbegindate(Timestamp  workbegindate){
        this.workbegindate = workbegindate ;
        this.modify("workbegindate",workbegindate);
    }

    /**
     * 设置 [WBGW]
     */
    public void setWbgw(String  wbgw){
        this.wbgw = wbgw ;
        this.modify("wbgw",wbgw);
    }

    /**
     * 设置 [WBZZ]
     */
    public void setWbzz(String  wbzz){
        this.wbzz = wbzz ;
        this.modify("wbzz",wbzz);
    }

    /**
     * 设置 [R_CERTNAMES]
     */
    public void setRCertnames(String  rCertnames){
        this.rCertnames = rCertnames ;
        this.modify("r_certnames",rCertnames);
    }

    /**
     * 设置 [SBSJ]
     */
    public void setSbsj(Timestamp  sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 设置 [GZBT]
     */
    public void setGzbt(Double  gzbt){
        this.gzbt = gzbt ;
        this.modify("gzbt",gzbt);
    }

    /**
     * 设置 [RTSJ]
     */
    public void setRtsj(Timestamp  rtsj){
        this.rtsj = rtsj ;
        this.modify("rtsj",rtsj);
    }

    /**
     * 设置 [NAPXM]
     */
    public void setNapxm(String  napxm){
        this.napxm = napxm ;
        this.modify("napxm",napxm);
    }

    /**
     * 设置 [XXXZ]
     */
    public void setXxxz(String  xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [CZ3]
     */
    public void setCz3(String  cz3){
        this.cz3 = cz3 ;
        this.modify("cz3",cz3);
    }

    /**
     * 设置 [JLDSPYJ]
     */
    public void setJldspyj(String  jldspyj){
        this.jldspyj = jldspyj ;
        this.modify("jldspyj",jldspyj);
    }

    /**
     * 设置 [WBBM]
     */
    public void setWbbm(String  wbbm){
        this.wbbm = wbbm ;
        this.modify("wbbm",wbbm);
    }

    /**
     * 设置 [SFXZBJNBRY]
     */
    public void setSfxzbjnbry(String  sfxzbjnbry){
        this.sfxzbjnbry = sfxzbjnbry ;
        this.modify("sfxzbjnbry",sfxzbjnbry);
    }

    /**
     * 设置 [ENTRANTDATE]
     */
    public void setEntrantdate(Timestamp  entrantdate){
        this.entrantdate = entrantdate ;
        this.modify("entrantdate",entrantdate);
    }

    /**
     * 设置 [JZPSPYJ]
     */
    public void setJzpspyj(String  jzpspyj){
        this.jzpspyj = jzpspyj ;
        this.modify("jzpspyj",jzpspyj);
    }

    /**
     * 设置 [YYDJMC]
     */
    public void setYydjmc(String  yydjmc){
        this.yydjmc = yydjmc ;
        this.modify("yydjmc",yydjmc);
    }

    /**
     * 设置 [BIRTHDAY]
     */
    public void setBirthday(Timestamp  birthday){
        this.birthday = birthday ;
        this.modify("birthday",birthday);
    }

    /**
     * 设置 [YYDJ]
     */
    public void setYydj(String  yydj){
        this.yydj = yydj ;
        this.modify("yydj",yydj);
    }

    /**
     * 设置 [POLITY]
     */
    public void setPolity(String  polity){
        this.polity = polity ;
        this.modify("polity",polity);
    }

    /**
     * 设置 [GZJSSJ]
     */
    public void setGzjssj(Timestamp  gzjssj){
        this.gzjssj = gzjssj ;
        this.modify("gzjssj",gzjssj);
    }

    /**
     * 设置 [WEDSTATE]
     */
    public void setWedstate(String  wedstate){
        this.wedstate = wedstate ;
        this.modify("wedstate",wedstate);
    }

    /**
     * 设置 [CZ4]
     */
    public void setCz4(String  cz4){
        this.cz4 = cz4 ;
        this.modify("cz4",cz4);
    }

    /**
     * 设置 [RGJYTG]
     */
    public void setRgjytg(String  rgjytg){
        this.rgjytg = rgjytg ;
        this.modify("rgjytg",rgjytg);
    }

    /**
     * 设置 [XZC]
     */
    public void setXzc(String  xzc){
        this.xzc = xzc ;
        this.modify("xzc",xzc);
    }

    /**
     * 设置 [HKLX]
     */
    public void setHklx(String  hklx){
        this.hklx = hklx ;
        this.modify("hklx",hklx);
    }

    /**
     * 设置 [QZSM]
     */
    public void setQzsm(String  qzsm){
        this.qzsm = qzsm ;
        this.modify("qzsm",qzsm);
    }

    /**
     * 设置 [XZNF]
     */
    public void setXznf(String  xznf){
        this.xznf = xznf ;
        this.modify("xznf",xznf);
    }

    /**
     * 设置 [EDUCATIONSTUDYMODE]
     */
    public void setEducationstudymode(String  educationstudymode){
        this.educationstudymode = educationstudymode ;
        this.modify("educationstudymode",educationstudymode);
    }

    /**
     * 设置 [PROFILETYPE]
     */
    public void setProfiletype(String  profiletype){
        this.profiletype = profiletype ;
        this.modify("profiletype",profiletype);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [CHECKRESULT]
     */
    public void setCheckresult(String  checkresult){
        this.checkresult = checkresult ;
        this.modify("checkresult",checkresult);
    }


}

