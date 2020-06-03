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
 * 服务DTO对象[PcmDdsqdmxDTO]
 */
@Data
public class PcmDdsqdmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMDDSQDMXID]
     *
     */
    @JSONField(name = "pcmddsqdmxid")
    @JsonProperty("pcmddsqdmxid")
    private String pcmddsqdmxid;

    /**
     * 属性 [FINISHDD]
     *
     */
    @JSONField(name = "finishdd")
    @JsonProperty("finishdd")
    private Integer finishdd;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [SFGBDD]
     *
     */
    @JSONField(name = "sfgbdd")
    @JsonProperty("sfgbdd")
    private Integer sfgbdd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JDJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jdjssj" , format="yyyy-MM-dd")
    @JsonProperty("jdjssj")
    private Timestamp jdjssj;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [SFJZB]
     *
     */
    @JSONField(name = "sfjzb")
    @JsonProperty("sfjzb")
    private Integer sfjzb;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DDTYPE]
     *
     */
    @JSONField(name = "ddtype")
    @JsonProperty("ddtype")
    private String ddtype;

    /**
     * 属性 [RZWJ]
     *
     */
    @JSONField(name = "rzwj")
    @JsonProperty("rzwj")
    private String rzwj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PCMDDSQDMXNAME]
     *
     */
    @JSONField(name = "pcmddsqdmxname")
    @JsonProperty("pcmddsqdmxname")
    private String pcmddsqdmxname;

    /**
     * 属性 [JDKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jdkssj" , format="yyyy-MM-dd")
    @JsonProperty("jdkssj")
    private Timestamp jdkssj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMYGW]
     *
     */
    @JSONField(name = "ormygw")
    @JsonProperty("ormygw")
    private String ormygw;

    /**
     * 属性 [PIMDISTIRBUTIONNAME]
     *
     */
    @JSONField(name = "pimdistirbutionname")
    @JsonProperty("pimdistirbutionname")
    private String pimdistirbutionname;

    /**
     * 属性 [PCMDDSQDNAME]
     *
     */
    @JSONField(name = "pcmddsqdname")
    @JsonProperty("pcmddsqdname")
    private String pcmddsqdname;

    /**
     * 属性 [ORMYZW]
     *
     */
    @JSONField(name = "ormyzw")
    @JsonProperty("ormyzw")
    private String ormyzw;

    /**
     * 属性 [ORGSECTORNAME]
     *
     */
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

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
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PCMDDSQDID]
     *
     */
    @JSONField(name = "pcmddsqdid")
    @JsonProperty("pcmddsqdid")
    private String pcmddsqdid;

    /**
     * 属性 [PIMDISTIRBUTIONID]
     *
     */
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;


    /**
     * 设置 [FINISHDD]
     */
    public void setFinishdd(Integer  finishdd){
        this.finishdd = finishdd ;
        this.modify("finishdd",finishdd);
    }

    /**
     * 设置 [CHECKSTATUS]
     */
    public void setCheckstatus(String  checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [SFGBDD]
     */
    public void setSfgbdd(Integer  sfgbdd){
        this.sfgbdd = sfgbdd ;
        this.modify("sfgbdd",sfgbdd);
    }

    /**
     * 设置 [JDJSSJ]
     */
    public void setJdjssj(Timestamp  jdjssj){
        this.jdjssj = jdjssj ;
        this.modify("jdjssj",jdjssj);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [SFJZB]
     */
    public void setSfjzb(Integer  sfjzb){
        this.sfjzb = sfjzb ;
        this.modify("sfjzb",sfjzb);
    }

    /**
     * 设置 [DDTYPE]
     */
    public void setDdtype(String  ddtype){
        this.ddtype = ddtype ;
        this.modify("ddtype",ddtype);
    }

    /**
     * 设置 [RZWJ]
     */
    public void setRzwj(String  rzwj){
        this.rzwj = rzwj ;
        this.modify("rzwj",rzwj);
    }

    /**
     * 设置 [PCMDDSQDMXNAME]
     */
    public void setPcmddsqdmxname(String  pcmddsqdmxname){
        this.pcmddsqdmxname = pcmddsqdmxname ;
        this.modify("pcmddsqdmxname",pcmddsqdmxname);
    }

    /**
     * 设置 [JDKSSJ]
     */
    public void setJdkssj(Timestamp  jdkssj){
        this.jdkssj = jdkssj ;
        this.modify("jdkssj",jdkssj);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [ORMYGW]
     */
    public void setOrmygw(String  ormygw){
        this.ormygw = ormygw ;
        this.modify("ormygw",ormygw);
    }

    /**
     * 设置 [ORMYZW]
     */
    public void setOrmyzw(String  ormyzw){
        this.ormyzw = ormyzw ;
        this.modify("ormyzw",ormyzw);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
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
     * 设置 [PCMDDSQDID]
     */
    public void setPcmddsqdid(String  pcmddsqdid){
        this.pcmddsqdid = pcmddsqdid ;
        this.modify("pcmddsqdid",pcmddsqdid);
    }

    /**
     * 设置 [PIMDISTIRBUTIONID]
     */
    public void setPimdistirbutionid(String  pimdistirbutionid){
        this.pimdistirbutionid = pimdistirbutionid ;
        this.modify("pimdistirbutionid",pimdistirbutionid);
    }


}

