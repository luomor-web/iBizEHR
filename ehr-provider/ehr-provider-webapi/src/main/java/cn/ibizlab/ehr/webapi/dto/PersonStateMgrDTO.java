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
 * 服务DTO对象[PersonStateMgrDTO]
 */
@Data
public class PersonStateMgrDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PERSONSTATEMGRNAME]
     *
     */
    @JSONField(name = "personstatemgrname")
    @JsonProperty("personstatemgrname")
    private String personstatemgrname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PERSONSTATEMGRID]
     *
     */
    @JSONField(name = "personstatemgrid")
    @JsonProperty("personstatemgrid")
    private String personstatemgrid;

    /**
     * 属性 [ORDERNO]
     *
     */
    @JSONField(name = "orderno")
    @JsonProperty("orderno")
    private Integer orderno;

    /**
     * 属性 [PERSONSTATECODE]
     *
     */
    @JSONField(name = "personstatecode")
    @JsonProperty("personstatecode")
    private String personstatecode;


    /**
     * 设置 [PERSONSTATEMGRNAME]
     */
    public void setPersonstatemgrname(String  personstatemgrname){
        this.personstatemgrname = personstatemgrname ;
        this.modify("personstatemgrname",personstatemgrname);
    }

    /**
     * 设置 [ORDERNO]
     */
    public void setOrderno(Integer  orderno){
        this.orderno = orderno ;
        this.modify("orderno",orderno);
    }

    /**
     * 设置 [PERSONSTATECODE]
     */
    public void setPersonstatecode(String  personstatecode){
        this.personstatecode = personstatecode ;
        this.modify("personstatecode",personstatecode);
    }


}

