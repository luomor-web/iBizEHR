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
 * 服务DTO对象[ParAssessTemplateDTO]
 */
@Data
public class ParAssessTemplateDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARASSESSTEMPLATEID]
     *
     */
    @JSONField(name = "parassesstemplateid")
    @JsonProperty("parassesstemplateid")
    private String parassesstemplateid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PARASSESSTEMPLATENAME]
     *
     */
    @JSONField(name = "parassesstemplatename")
    @JsonProperty("parassesstemplatename")
    private String parassesstemplatename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

    /**
     * 属性 [SFYX]
     *
     */
    @JSONField(name = "sfyx")
    @JsonProperty("sfyx")
    private String sfyx;


    /**
     * 设置 [PARASSESSTEMPLATENAME]
     */
    public void setParassesstemplatename(String  parassesstemplatename){
        this.parassesstemplatename = parassesstemplatename ;
        this.modify("parassesstemplatename",parassesstemplatename);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [KHDX]
     */
    public void setKhdx(String  khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [SFYX]
     */
    public void setSfyx(String  sfyx){
        this.sfyx = sfyx ;
        this.modify("sfyx",sfyx);
    }


}

