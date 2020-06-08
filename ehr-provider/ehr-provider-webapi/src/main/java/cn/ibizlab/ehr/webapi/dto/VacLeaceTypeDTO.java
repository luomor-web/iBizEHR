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
 * 服务DTO对象[VacLeaceTypeDTO]
 */
@Data
public class VacLeaceTypeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [VACLEACETYPEID]
     *
     */
    @JSONField(name = "vacleacetypeid")
    @JsonProperty("vacleacetypeid")
    private String vacleacetypeid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TYPECODE]
     *
     */
    @JSONField(name = "typecode")
    @JsonProperty("typecode")
    private String typecode;

    /**
     * 属性 [VACLEACETYPENAME]
     *
     */
    @JSONField(name = "vacleacetypename")
    @JsonProperty("vacleacetypename")
    private String vacleacetypename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;


    /**
     * 设置 [TYPECODE]
     */
    public void setTypecode(String  typecode){
        this.typecode = typecode ;
        this.modify("typecode",typecode);
    }

    /**
     * 设置 [VACLEACETYPENAME]
     */
    public void setVacleacetypename(String  vacleacetypename){
        this.vacleacetypename = vacleacetypename ;
        this.modify("vacleacetypename",vacleacetypename);
    }


}

