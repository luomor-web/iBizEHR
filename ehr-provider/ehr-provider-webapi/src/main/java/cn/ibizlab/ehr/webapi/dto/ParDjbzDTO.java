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
 * 服务DTO对象[ParDjbzDTO]
 */
@Data
public class ParDjbzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KHPGDJ]
     *
     */
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;

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
     * 属性 [PARDJBZNAME]
     *
     */
    @JSONField(name = "pardjbzname")
    @JsonProperty("pardjbzname")
    private String pardjbzname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARDJBZID]
     *
     */
    @JSONField(name = "pardjbzid")
    @JsonProperty("pardjbzid")
    private String pardjbzid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [FBBL]
     *
     */
    @JSONField(name = "fbbl")
    @JsonProperty("fbbl")
    private Double fbbl;


    /**
     * 设置 [KHPGDJ]
     */
    public void setKhpgdj(String  khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [PARDJBZNAME]
     */
    public void setPardjbzname(String  pardjbzname){
        this.pardjbzname = pardjbzname ;
        this.modify("pardjbzname",pardjbzname);
    }

    /**
     * 设置 [FBBL]
     */
    public void setFbbl(Double  fbbl){
        this.fbbl = fbbl ;
        this.modify("fbbl",fbbl);
    }


}

