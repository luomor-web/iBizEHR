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
 * 服务DTO对象[CodeList1DTO]
 */
@Data
public class CodeList1DTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VALUESEPERATOR]
     *
     */
    @JSONField(name = "valueseperator")
    @JsonProperty("valueseperator")
    private String valueseperator;

    /**
     * 属性 [CLPATH]
     *
     */
    @JSONField(name = "clpath")
    @JsonProperty("clpath")
    private String clpath;

    /**
     * 属性 [ISUSERSCOPE]
     *
     */
    @JSONField(name = "isuserscope")
    @JsonProperty("isuserscope")
    private Integer isuserscope;

    /**
     * 属性 [ISSYSTEM]
     *
     */
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;

    /**
     * 属性 [SEPERATOR]
     *
     */
    @JSONField(name = "seperator")
    @JsonProperty("seperator")
    private String seperator;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SRFSYSPUB]
     *
     */
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [RESERVER5]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver5" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver5")
    private Timestamp reserver5;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [ORMODE]
     *
     */
    @JSONField(name = "ormode")
    @JsonProperty("ormode")
    private String ormode;

    /**
     * 属性 [EMPTYTEXT]
     *
     */
    @JSONField(name = "emptytext")
    @JsonProperty("emptytext")
    private String emptytext;

    /**
     * 属性 [FILLER]
     *
     */
    @JSONField(name = "filler")
    @JsonProperty("filler")
    private String filler;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CODELISTID]
     *
     */
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;

    /**
     * 属性 [CLVERSION]
     *
     */
    @JSONField(name = "clversion")
    @JsonProperty("clversion")
    private Integer clversion;

    /**
     * 属性 [NOVALUEEMPTY]
     *
     */
    @JSONField(name = "novalueempty")
    @JsonProperty("novalueempty")
    private Integer novalueempty;

    /**
     * 属性 [CODELISTNAME]
     *
     */
    @JSONField(name = "codelistname")
    @JsonProperty("codelistname")
    private String codelistname;

    /**
     * 属性 [CLMODEL]
     *
     */
    @JSONField(name = "clmodel")
    @JsonProperty("clmodel")
    private String clmodel;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [CLPARAM]
     *
     */
    @JSONField(name = "clparam")
    @JsonProperty("clparam")
    private String clparam;

    /**
     * 属性 [SRFUSERPUB]
     *
     */
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;


    /**
     * 设置 [VALUESEPERATOR]
     */
    public void setValueseperator(String  valueseperator){
        this.valueseperator = valueseperator ;
        this.modify("valueseperator",valueseperator);
    }

    /**
     * 设置 [CLPATH]
     */
    public void setClpath(String  clpath){
        this.clpath = clpath ;
        this.modify("clpath",clpath);
    }

    /**
     * 设置 [ISUSERSCOPE]
     */
    public void setIsuserscope(Integer  isuserscope){
        this.isuserscope = isuserscope ;
        this.modify("isuserscope",isuserscope);
    }

    /**
     * 设置 [ISSYSTEM]
     */
    public void setIssystem(Integer  issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }

    /**
     * 设置 [SEPERATOR]
     */
    public void setSeperator(String  seperator){
        this.seperator = seperator ;
        this.modify("seperator",seperator);
    }

    /**
     * 设置 [SRFSYSPUB]
     */
    public void setSrfsyspub(Integer  srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [RESERVER5]
     */
    public void setReserver5(Timestamp  reserver5){
        this.reserver5 = reserver5 ;
        this.modify("reserver5",reserver5);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [ORMODE]
     */
    public void setOrmode(String  ormode){
        this.ormode = ormode ;
        this.modify("ormode",ormode);
    }

    /**
     * 设置 [EMPTYTEXT]
     */
    public void setEmptytext(String  emptytext){
        this.emptytext = emptytext ;
        this.modify("emptytext",emptytext);
    }

    /**
     * 设置 [FILLER]
     */
    public void setFiller(String  filler){
        this.filler = filler ;
        this.modify("filler",filler);
    }

    /**
     * 设置 [CLVERSION]
     */
    public void setClversion(Integer  clversion){
        this.clversion = clversion ;
        this.modify("clversion",clversion);
    }

    /**
     * 设置 [NOVALUEEMPTY]
     */
    public void setNovalueempty(Integer  novalueempty){
        this.novalueempty = novalueempty ;
        this.modify("novalueempty",novalueempty);
    }

    /**
     * 设置 [CODELISTNAME]
     */
    public void setCodelistname(String  codelistname){
        this.codelistname = codelistname ;
        this.modify("codelistname",codelistname);
    }

    /**
     * 设置 [CLMODEL]
     */
    public void setClmodel(String  clmodel){
        this.clmodel = clmodel ;
        this.modify("clmodel",clmodel);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [CLPARAM]
     */
    public void setClparam(String  clparam){
        this.clparam = clparam ;
        this.modify("clparam",clparam);
    }

    /**
     * 设置 [SRFUSERPUB]
     */
    public void setSrfuserpub(Integer  srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }


}

