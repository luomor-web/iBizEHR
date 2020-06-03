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
 * 服务DTO对象[AttEndenceTypeDTO]
 */
@Data
public class AttEndenceTypeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ATTENDENCETYPEID]
     *
     */
    @JSONField(name = "attendencetypeid")
    @JsonProperty("attendencetypeid")
    private String attendencetypeid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TYPECODE]
     *
     */
    @JSONField(name = "typecode")
    @JsonProperty("typecode")
    private String typecode;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ATTENDENCETYPENAME]
     *
     */
    @JSONField(name = "attendencetypename")
    @JsonProperty("attendencetypename")
    private String attendencetypename;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;


    /**
     * 设置 [TYPECODE]
     */
    public void setTypecode(String  typecode){
        this.typecode = typecode ;
        this.modify("typecode",typecode);
    }

    /**
     * 设置 [ATTENDENCETYPENAME]
     */
    public void setAttendencetypename(String  attendencetypename){
        this.attendencetypename = attendencetypename ;
        this.modify("attendencetypename",attendencetypename);
    }


}

