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
 * 服务DTO对象[PimQuestionsDTO]
 */
@Data
public class PimQuestionsDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [QUESTIONMAN]
     *
     */
    @JSONField(name = "questionman")
    @JsonProperty("questionman")
    private String questionman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TWURL]
     *
     */
    @JSONField(name = "twurl")
    @JsonProperty("twurl")
    private String twurl;

    /**
     * 属性 [JJCD]
     *
     */
    @JSONField(name = "jjcd")
    @JsonProperty("jjcd")
    private String jjcd;

    /**
     * 属性 [YMMC]
     *
     */
    @JSONField(name = "ymmc")
    @JsonProperty("ymmc")
    private String ymmc;

    /**
     * 属性 [YM]
     *
     */
    @JSONField(name = "ym")
    @JsonProperty("ym")
    private String ym;

    /**
     * 属性 [GN]
     *
     */
    @JSONField(name = "gn")
    @JsonProperty("gn")
    private String gn;

    /**
     * 属性 [JT]
     *
     */
    @JSONField(name = "jt")
    @JsonProperty("jt")
    private String jt;

    /**
     * 属性 [WTFK]
     *
     */
    @JSONField(name = "wtfk")
    @JsonProperty("wtfk")
    private String wtfk;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [WTMS]
     *
     */
    @JSONField(name = "wtms")
    @JsonProperty("wtms")
    private String wtms;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MK]
     *
     */
    @JSONField(name = "mk")
    @JsonProperty("mk")
    private String mk;

    /**
     * 属性 [QUESTIONSNAME]
     *
     */
    @JSONField(name = "questionsname")
    @JsonProperty("questionsname")
    private String questionsname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [KFZ]
     *
     */
    @JSONField(name = "kfz")
    @JsonProperty("kfz")
    private String kfz;

    /**
     * 属性 [TCSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tcsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("tcsj")
    private Timestamp tcsj;

    /**
     * 属性 [WCSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "wcsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("wcsj")
    private Timestamp wcsj;

    /**
     * 属性 [QUESTIONSID]
     *
     */
    @JSONField(name = "questionsid")
    @JsonProperty("questionsid")
    private String questionsid;

    /**
     * 属性 [WTZT]
     *
     */
    @JSONField(name = "wtzt")
    @JsonProperty("wtzt")
    private String wtzt;

    /**
     * 属性 [WTBH]
     *
     */
    @JSONField(name = "wtbh")
    @JsonProperty("wtbh")
    private String wtbh;


    /**
     * 设置 [QUESTIONMAN]
     */
    public void setQuestionman(String  questionman){
        this.questionman = questionman ;
        this.modify("questionman",questionman);
    }

    /**
     * 设置 [TWURL]
     */
    public void setTwurl(String  twurl){
        this.twurl = twurl ;
        this.modify("twurl",twurl);
    }

    /**
     * 设置 [JJCD]
     */
    public void setJjcd(String  jjcd){
        this.jjcd = jjcd ;
        this.modify("jjcd",jjcd);
    }

    /**
     * 设置 [YMMC]
     */
    public void setYmmc(String  ymmc){
        this.ymmc = ymmc ;
        this.modify("ymmc",ymmc);
    }

    /**
     * 设置 [YM]
     */
    public void setYm(String  ym){
        this.ym = ym ;
        this.modify("ym",ym);
    }

    /**
     * 设置 [GN]
     */
    public void setGn(String  gn){
        this.gn = gn ;
        this.modify("gn",gn);
    }

    /**
     * 设置 [JT]
     */
    public void setJt(String  jt){
        this.jt = jt ;
        this.modify("jt",jt);
    }

    /**
     * 设置 [WTFK]
     */
    public void setWtfk(String  wtfk){
        this.wtfk = wtfk ;
        this.modify("wtfk",wtfk);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [WTMS]
     */
    public void setWtms(String  wtms){
        this.wtms = wtms ;
        this.modify("wtms",wtms);
    }

    /**
     * 设置 [MK]
     */
    public void setMk(String  mk){
        this.mk = mk ;
        this.modify("mk",mk);
    }

    /**
     * 设置 [QUESTIONSNAME]
     */
    public void setQuestionsname(String  questionsname){
        this.questionsname = questionsname ;
        this.modify("questionsname",questionsname);
    }

    /**
     * 设置 [KFZ]
     */
    public void setKfz(String  kfz){
        this.kfz = kfz ;
        this.modify("kfz",kfz);
    }

    /**
     * 设置 [TCSJ]
     */
    public void setTcsj(Timestamp  tcsj){
        this.tcsj = tcsj ;
        this.modify("tcsj",tcsj);
    }

    /**
     * 设置 [WCSJ]
     */
    public void setWcsj(Timestamp  wcsj){
        this.wcsj = wcsj ;
        this.modify("wcsj",wcsj);
    }

    /**
     * 设置 [WTZT]
     */
    public void setWtzt(String  wtzt){
        this.wtzt = wtzt ;
        this.modify("wtzt",wtzt);
    }

    /**
     * 设置 [WTBH]
     */
    public void setWtbh(String  wtbh){
        this.wtbh = wtbh ;
        this.modify("wtbh",wtbh);
    }


}

