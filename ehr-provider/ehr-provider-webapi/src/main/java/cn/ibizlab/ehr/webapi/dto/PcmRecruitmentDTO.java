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
 * 服务DTO对象[PcmRecruitmentDTO]
 */
@Data
public class PcmRecruitmentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 属性 [PCMRECRUITMENTID]
     *
     */
    @JSONField(name = "pcmrecruitmentid")
    @JsonProperty("pcmrecruitmentid")
    private String pcmrecruitmentid;

    /**
     * 属性 [REQUIREMENTS]
     *
     */
    @JSONField(name = "requirements")
    @JsonProperty("requirements")
    private String requirements;

    /**
     * 属性 [SJZPRS]
     *
     */
    @JSONField(name = "sjzprs")
    @JsonProperty("sjzprs")
    private Integer sjzprs;

    /**
     * 属性 [PCMRECRUITMENTNAME]
     *
     */
    @JSONField(name = "pcmrecruitmentname")
    @JsonProperty("pcmrecruitmentname")
    private String pcmrecruitmentname;

    /**
     * 属性 [YJZPRS]
     *
     */
    @JSONField(name = "yjzprs")
    @JsonProperty("yjzprs")
    private Integer yjzprs;

    /**
     * 属性 [SFZPWC]
     *
     */
    @JSONField(name = "sfzpwc")
    @JsonProperty("sfzpwc")
    private Integer sfzpwc;

    /**
     * 属性 [RECRUITMENTTYPE]
     *
     */
    @JSONField(name = "recruitmenttype")
    @JsonProperty("recruitmenttype")
    private String recruitmenttype;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;


    /**
     * 设置 [REQUIREMENTS]
     */
    public void setRequirements(String  requirements){
        this.requirements = requirements ;
        this.modify("requirements",requirements);
    }

    /**
     * 设置 [SJZPRS]
     */
    public void setSjzprs(Integer  sjzprs){
        this.sjzprs = sjzprs ;
        this.modify("sjzprs",sjzprs);
    }

    /**
     * 设置 [PCMRECRUITMENTNAME]
     */
    public void setPcmrecruitmentname(String  pcmrecruitmentname){
        this.pcmrecruitmentname = pcmrecruitmentname ;
        this.modify("pcmrecruitmentname",pcmrecruitmentname);
    }

    /**
     * 设置 [YJZPRS]
     */
    public void setYjzprs(Integer  yjzprs){
        this.yjzprs = yjzprs ;
        this.modify("yjzprs",yjzprs);
    }

    /**
     * 设置 [SFZPWC]
     */
    public void setSfzpwc(Integer  sfzpwc){
        this.sfzpwc = sfzpwc ;
        this.modify("sfzpwc",sfzpwc);
    }

    /**
     * 设置 [RECRUITMENTTYPE]
     */
    public void setRecruitmenttype(String  recruitmenttype){
        this.recruitmenttype = recruitmenttype ;
        this.modify("recruitmenttype",recruitmenttype);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}

