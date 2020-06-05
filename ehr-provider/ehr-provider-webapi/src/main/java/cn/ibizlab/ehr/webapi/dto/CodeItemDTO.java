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
 * 服务DTO对象[CodeItemDTO]
 */
@Data
public class CodeItemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [SHORTKEY]
     *
     */
    @JSONField(name = "shortkey")
    @JsonProperty("shortkey")
    private String shortkey;

    /**
     * 属性 [CODEITEMNAME]
     *
     */
    @JSONField(name = "codeitemname")
    @JsonProperty("codeitemname")
    private String codeitemname;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

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
     * 属性 [CODEITEMVALUE]
     *
     */
    @JSONField(name = "codeitemvalue")
    @JsonProperty("codeitemvalue")
    private String codeitemvalue;

    /**
     * 属性 [CODEITEMID]
     *
     */
    @JSONField(name = "codeitemid")
    @JsonProperty("codeitemid")
    private String codeitemid;

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
     * 属性 [CODELISTNAME]
     *
     */
    @JSONField(name = "codelistname")
    @JsonProperty("codelistname")
    private String codelistname;

    /**
     * 属性 [PCODEITEMNAME]
     *
     */
    @JSONField(name = "pcodeitemname")
    @JsonProperty("pcodeitemname")
    private String pcodeitemname;

    /**
     * 属性 [PCODEITEMID]
     *
     */
    @JSONField(name = "pcodeitemid")
    @JsonProperty("pcodeitemid")
    private String pcodeitemid;

    /**
     * 属性 [CODELISTID]
     *
     */
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;


    /**
     * 设置 [SHORTKEY]
     */
    public void setShortkey(String  shortkey){
        this.shortkey = shortkey ;
        this.modify("shortkey",shortkey);
    }

    /**
     * 设置 [CODEITEMNAME]
     */
    public void setCodeitemname(String  codeitemname){
        this.codeitemname = codeitemname ;
        this.modify("codeitemname",codeitemname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [CODEITEMVALUE]
     */
    public void setCodeitemvalue(String  codeitemvalue){
        this.codeitemvalue = codeitemvalue ;
        this.modify("codeitemvalue",codeitemvalue);
    }

    /**
     * 设置 [PCODEITEMID]
     */
    public void setPcodeitemid(String  pcodeitemid){
        this.pcodeitemid = pcodeitemid ;
        this.modify("pcodeitemid",pcodeitemid);
    }

    /**
     * 设置 [CODELISTID]
     */
    public void setCodelistid(String  codelistid){
        this.codelistid = codelistid ;
        this.modify("codelistid",codelistid);
    }


}

