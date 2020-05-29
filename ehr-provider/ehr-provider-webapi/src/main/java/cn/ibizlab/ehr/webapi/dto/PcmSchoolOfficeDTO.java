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
 * 服务DTO对象[PcmSchoolOfficeDTO]
 */
@Data
public class PcmSchoolOfficeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMSCHOOLOFFICENAME]
     *
     */
    @JSONField(name = "pcmschoolofficename")
    @JsonProperty("pcmschoolofficename")
    private String pcmschoolofficename;

    /**
     * 属性 [CADRENAME]
     *
     */
    @JSONField(name = "cadrename")
    @JsonProperty("cadrename")
    private String cadrename;

    /**
     * 属性 [CADREENDDATETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cadreenddatetime" , format="yyyy-MM-dd")
    @JsonProperty("cadreenddatetime")
    private Timestamp cadreenddatetime;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMSCHOOLOFFICEID]
     *
     */
    @JSONField(name = "pcmschoolofficeid")
    @JsonProperty("pcmschoolofficeid")
    private String pcmschoolofficeid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CADRESTARTDATETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cadrestartdatetime" , format="yyyy-MM-dd")
    @JsonProperty("cadrestartdatetime")
    private Timestamp cadrestartdatetime;

    /**
     * 属性 [CADREDESCRIPTION]
     *
     */
    @JSONField(name = "cadredescription")
    @JsonProperty("cadredescription")
    private String cadredescription;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [PCMSCHOOLOFFICENAME]
     */
    public void setPcmschoolofficename(String  pcmschoolofficename){
        this.pcmschoolofficename = pcmschoolofficename ;
        this.modify("pcmschoolofficename",pcmschoolofficename);
    }

    /**
     * 设置 [CADRENAME]
     */
    public void setCadrename(String  cadrename){
        this.cadrename = cadrename ;
        this.modify("cadrename",cadrename);
    }

    /**
     * 设置 [CADREENDDATETIME]
     */
    public void setCadreenddatetime(Timestamp  cadreenddatetime){
        this.cadreenddatetime = cadreenddatetime ;
        this.modify("cadreenddatetime",cadreenddatetime);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [CADRESTARTDATETIME]
     */
    public void setCadrestartdatetime(Timestamp  cadrestartdatetime){
        this.cadrestartdatetime = cadrestartdatetime ;
        this.modify("cadrestartdatetime",cadrestartdatetime);
    }

    /**
     * 设置 [CADREDESCRIPTION]
     */
    public void setCadredescription(String  cadredescription){
        this.cadredescription = cadredescription ;
        this.modify("cadredescription",cadredescription);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

