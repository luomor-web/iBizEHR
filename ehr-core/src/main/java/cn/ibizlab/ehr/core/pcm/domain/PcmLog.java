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
 * 实体[配置变动日志]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMLOG",resultMap = "PcmLogResultMap")
public class PcmLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作的实体数据id
     */
    @TableField(value = "optdeid")
    @JSONField(name = "optdeid")
    @JsonProperty("optdeid")
    private String optdeid;
    /**
     * 变动类型
     */
    @TableField(value = "type")
    @JSONField(name = "type")
    @JsonProperty("type")
    private String type;
    /**
     * 操作的实体行为
     */
    @TableField(value = "optdeaction")
    @JSONField(name = "optdeaction")
    @JsonProperty("optdeaction")
    private String optdeaction;
    /**
     * 操作的实体名称
     */
    @TableField(value = "optdename")
    @JSONField(name = "optdename")
    @JsonProperty("optdename")
    private String optdename;
    /**
     * 配置变动日志标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmlogid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmlogid")
    @JsonProperty("pcmlogid")
    private String pcmlogid;
    /**
     * 是否生效
     */
    @TableField(value = "sfsx")
    @JSONField(name = "sfsx")
    @JsonProperty("sfsx")
    private Integer sfsx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 配置变动日志名称
     */
    @TableField(value = "pcmlogname")
    @JSONField(name = "pcmlogname")
    @JsonProperty("pcmlogname")
    private String pcmlogname;
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
     * 变动内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 操作实体内容
     */
    @TableField(value = "optcontent")
    @JSONField(name = "optcontent")
    @JsonProperty("optcontent")
    private String optcontent;
    /**
     * 是否需要定时操作
     */
    @TableField(value = "needopt")
    @JSONField(name = "needopt")
    @JsonProperty("needopt")
    private Integer needopt;
    /**
     * 生效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 组织机构标示
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [操作的实体数据id]
     */
    public void setOptdeid(String optdeid){
        this.optdeid = optdeid ;
        this.modify("optdeid",optdeid);
    }

    /**
     * 设置 [变动类型]
     */
    public void setType(String type){
        this.type = type ;
        this.modify("type",type);
    }

    /**
     * 设置 [操作的实体行为]
     */
    public void setOptdeaction(String optdeaction){
        this.optdeaction = optdeaction ;
        this.modify("optdeaction",optdeaction);
    }

    /**
     * 设置 [操作的实体名称]
     */
    public void setOptdename(String optdename){
        this.optdename = optdename ;
        this.modify("optdename",optdename);
    }

    /**
     * 设置 [是否生效]
     */
    public void setSfsx(Integer sfsx){
        this.sfsx = sfsx ;
        this.modify("sfsx",sfsx);
    }

    /**
     * 设置 [配置变动日志名称]
     */
    public void setPcmlogname(String pcmlogname){
        this.pcmlogname = pcmlogname ;
        this.modify("pcmlogname",pcmlogname);
    }

    /**
     * 设置 [变动内容]
     */
    public void setContent(String content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [操作实体内容]
     */
    public void setOptcontent(String optcontent){
        this.optcontent = optcontent ;
        this.modify("optcontent",optcontent);
    }

    /**
     * 设置 [是否需要定时操作]
     */
    public void setNeedopt(Integer needopt){
        this.needopt = needopt ;
        this.modify("needopt",needopt);
    }

    /**
     * 设置 [生效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [生效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


