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
 * 实体[在校职务]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMSCHOOLOFFICE",resultMap = "PcmSchoolOfficeResultMap")
public class PcmSchoolOffice extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 在校职务名称
     */
    @TableField(value = "pcmschoolofficename")
    @JSONField(name = "pcmschoolofficename")
    @JsonProperty("pcmschoolofficename")
    private String pcmschoolofficename;
    /**
     * 职务名称
     */
    @TableField(value = "cadrename")
    @JSONField(name = "cadrename")
    @JsonProperty("cadrename")
    private String cadrename;
    /**
     * 结束时间
     */
    @TableField(value = "cadreenddatetime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cadreenddatetime" , format="yyyy-MM-dd")
    @JsonProperty("cadreenddatetime")
    private Timestamp cadreenddatetime;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 在校职务标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmschoolofficeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmschoolofficeid")
    @JsonProperty("pcmschoolofficeid")
    private String pcmschoolofficeid;
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
     * 开始时间
     */
    @TableField(value = "cadrestartdatetime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cadrestartdatetime" , format="yyyy-MM-dd")
    @JsonProperty("cadrestartdatetime")
    private Timestamp cadrestartdatetime;
    /**
     * 在校职务描述
     */
    @TableField(value = "cadredescription")
    @JSONField(name = "cadredescription")
    @JsonProperty("cadredescription")
    private String cadredescription;
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
     * 应聘者信息-在校职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [在校职务名称]
     */
    public void setPcmschoolofficename(String pcmschoolofficename){
        this.pcmschoolofficename = pcmschoolofficename ;
        this.modify("pcmschoolofficename",pcmschoolofficename);
    }

    /**
     * 设置 [职务名称]
     */
    public void setCadrename(String cadrename){
        this.cadrename = cadrename ;
        this.modify("cadrename",cadrename);
    }

    /**
     * 设置 [结束时间]
     */
    public void setCadreenddatetime(Timestamp cadreenddatetime){
        this.cadreenddatetime = cadreenddatetime ;
        this.modify("cadreenddatetime",cadreenddatetime);
    }

    /**
     * 格式化日期 [结束时间]
     */
    public String formatCadreenddatetime(){
        if (this.cadreenddatetime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cadreenddatetime);
    }
    /**
     * 设置 [版本时间]
     */
    public void setBbsj(Timestamp bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 格式化日期 [版本时间]
     */
    public String formatBbsj(){
        if (this.bbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bbsj);
    }
    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [开始时间]
     */
    public void setCadrestartdatetime(Timestamp cadrestartdatetime){
        this.cadrestartdatetime = cadrestartdatetime ;
        this.modify("cadrestartdatetime",cadrestartdatetime);
    }

    /**
     * 格式化日期 [开始时间]
     */
    public String formatCadrestartdatetime(){
        if (this.cadrestartdatetime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cadrestartdatetime);
    }
    /**
     * 设置 [在校职务描述]
     */
    public void setCadredescription(String cadredescription){
        this.cadredescription = cadredescription ;
        this.modify("cadredescription",cadredescription);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


