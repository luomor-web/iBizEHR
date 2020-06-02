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
 * 服务DTO对象[OrmTitleDTO]
 */
@Data
public class OrmTitleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TITLETYPE]
     *
     */
    @JSONField(name = "titletype")
    @JsonProperty("titletype")
    private String titletype;

    /**
     * 属性 [ORMTITLENAME]
     *
     */
    @JSONField(name = "ormtitlename")
    @JsonProperty("ormtitlename")
    private String ormtitlename;

    /**
     * 属性 [ORMTITLEID]
     *
     */
    @JSONField(name = "ormtitleid")
    @JsonProperty("ormtitleid")
    private String ormtitleid;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;


    /**
     * 设置 [TITLETYPE]
     */
    public void setTitletype(String  titletype){
        this.titletype = titletype ;
        this.modify("titletype",titletype);
    }

    /**
     * 设置 [ORMTITLENAME]
     */
    public void setOrmtitlename(String  ormtitlename){
        this.ormtitlename = ormtitlename ;
        this.modify("ormtitlename",ormtitlename);
    }


}

