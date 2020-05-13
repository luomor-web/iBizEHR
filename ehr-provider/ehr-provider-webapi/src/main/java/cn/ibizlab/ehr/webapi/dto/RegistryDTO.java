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
 * 服务DTO对象[RegistryDTO]
 */
@Data
public class RegistryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARAM8]
     *
     */
    @JSONField(name = "param8")
    @JsonProperty("param8")
    private String param8;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PARAM5]
     *
     */
    @JSONField(name = "param5")
    @JsonProperty("param5")
    private String param5;

    /**
     * 属性 [PARAM1]
     *
     */
    @JSONField(name = "param1")
    @JsonProperty("param1")
    private String param1;

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
     * 属性 [PARAM4]
     *
     */
    @JSONField(name = "param4")
    @JsonProperty("param4")
    private String param4;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [PARAM7]
     *
     */
    @JSONField(name = "param7")
    @JsonProperty("param7")
    private String param7;

    /**
     * 属性 [PARAM6]
     *
     */
    @JSONField(name = "param6")
    @JsonProperty("param6")
    private String param6;

    /**
     * 属性 [SECTION]
     *
     */
    @JSONField(name = "sector")
    @JsonProperty("sector")
    private String sector;

    /**
     * 属性 [REGISTRYID]
     *
     */
    @JSONField(name = "registryid")
    @JsonProperty("registryid")
    private String registryid;

    /**
     * 属性 [REGISTRYNAME]
     *
     */
    @JSONField(name = "registryname")
    @JsonProperty("registryname")
    private String registryname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARAM2]
     *
     */
    @JSONField(name = "param2")
    @JsonProperty("param2")
    private String param2;

    /**
     * 属性 [PARAM9]
     *
     */
    @JSONField(name = "param9")
    @JsonProperty("param9")
    private String param9;

    /**
     * 属性 [PARAM3]
     *
     */
    @JSONField(name = "param3")
    @JsonProperty("param3")
    private String param3;


    /**
     * 设置 [PARAM8]
     */
    public void setParam8(String  param8){
        this.param8 = param8 ;
        this.modify("param8",param8);
    }

    /**
     * 设置 [PARAM5]
     */
    public void setParam5(String  param5){
        this.param5 = param5 ;
        this.modify("param5",param5);
    }

    /**
     * 设置 [PARAM1]
     */
    public void setParam1(String  param1){
        this.param1 = param1 ;
        this.modify("param1",param1);
    }

    /**
     * 设置 [PARAM4]
     */
    public void setParam4(String  param4){
        this.param4 = param4 ;
        this.modify("param4",param4);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [PARAM7]
     */
    public void setParam7(String  param7){
        this.param7 = param7 ;
        this.modify("param7",param7);
    }

    /**
     * 设置 [PARAM6]
     */
    public void setParam6(String  param6){
        this.param6 = param6 ;
        this.modify("param6",param6);
    }

    /**
     * 设置 [SECTION]
     */
    public void setSector(String  sector){
        this.sector = sector ;
        this.modify("section",sector);
    }

    /**
     * 设置 [REGISTRYNAME]
     */
    public void setRegistryname(String  registryname){
        this.registryname = registryname ;
        this.modify("registryname",registryname);
    }

    /**
     * 设置 [PARAM2]
     */
    public void setParam2(String  param2){
        this.param2 = param2 ;
        this.modify("param2",param2);
    }

    /**
     * 设置 [PARAM9]
     */
    public void setParam9(String  param9){
        this.param9 = param9 ;
        this.modify("param9",param9);
    }

    /**
     * 设置 [PARAM3]
     */
    public void setParam3(String  param3){
        this.param3 = param3 ;
        this.modify("param3",param3);
    }


}

