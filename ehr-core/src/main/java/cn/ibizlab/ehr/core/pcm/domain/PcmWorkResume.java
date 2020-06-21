package cn.ibizlab.ehr.core.pcm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[工作履历]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMWORKRESUME",resultMap = "PcmWorkResumeResultMap")
public class PcmWorkResume extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作单位
     */
    @TableField(value = "workunit")
    @JSONField(name = "workunit")
    @JsonProperty("workunit")
    private String workunit;
    /**
     * 任职结束时间
     */
    @TableField(value = "serveendtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "serveendtime" , format="yyyy-MM-dd")
    @JsonProperty("serveendtime")
    private Timestamp serveendtime;
    /**
     * 履历说明
     */
    @TableField(value = "resumecontent")
    @JSONField(name = "resumecontent")
    @JsonProperty("resumecontent")
    private String resumecontent;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 工作履历名称
     */
    @TableField(value = "pcmworkresumename")
    @JSONField(name = "pcmworkresumename")
    @JsonProperty("pcmworkresumename")
    private String pcmworkresumename;
    /**
     * 任职开始时间
     */
    @TableField(value = "servebegintime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "servebegintime" , format="yyyy-MM-dd")
    @JsonProperty("servebegintime")
    private Timestamp servebegintime;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 工作履历标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmworkresumeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmworkresumeid")
    @JsonProperty("pcmworkresumeid")
    private String pcmworkresumeid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-工作履历
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [工作单位]
     */
    public void setWorkunit(String workunit){
        this.workunit = workunit ;
        this.modify("workunit",workunit);
    }

    /**
     * 设置 [任职结束时间]
     */
    public void setServeendtime(Timestamp serveendtime){
        this.serveendtime = serveendtime ;
        this.modify("serveendtime",serveendtime);
    }

    /**
     * 格式化日期 [任职结束时间]
     */
    public String formatServeendtime(){
        if (this.serveendtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(serveendtime);
    }
    /**
     * 设置 [履历说明]
     */
    public void setResumecontent(String resumecontent){
        this.resumecontent = resumecontent ;
        this.modify("resumecontent",resumecontent);
    }

    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [工作履历名称]
     */
    public void setPcmworkresumename(String pcmworkresumename){
        this.pcmworkresumename = pcmworkresumename ;
        this.modify("pcmworkresumename",pcmworkresumename);
    }

    /**
     * 设置 [任职开始时间]
     */
    public void setServebegintime(Timestamp servebegintime){
        this.servebegintime = servebegintime ;
        this.modify("servebegintime",servebegintime);
    }

    /**
     * 格式化日期 [任职开始时间]
     */
    public String formatServebegintime(){
        if (this.servebegintime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(servebegintime);
    }
    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


