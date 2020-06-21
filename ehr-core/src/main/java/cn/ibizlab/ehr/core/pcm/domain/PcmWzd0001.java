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
 * 实体[向导实体1]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_WZD0001",resultMap = "PcmWzd0001ResultMap")
public class PcmWzd0001 extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 人数
     */
    @TableField(value = "peoplenum")
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 审核原因
     */
    @TableField(value = "shyy")
    @JSONField(name = "shyy")
    @JsonProperty("shyy")
    private String shyy;
    /**
     * 初审意见
     */
    @TableField(value = "csyj")
    @JSONField(name = "csyj")
    @JsonProperty("csyj")
    private String csyj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 向导实体1标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wzd0001id",type=IdType.ASSIGN_UUID)
    @JSONField(name = "wzd0001id")
    @JsonProperty("wzd0001id")
    private String wzd0001id;
    /**
     * 初审原因
     */
    @TableField(value = "csyy")
    @JSONField(name = "csyy")
    @JsonProperty("csyy")
    private String csyy;
    /**
     * 审批原因
     */
    @TableField(value = "spyy")
    @JSONField(name = "spyy")
    @JsonProperty("spyy")
    private String spyy;
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
     * 招聘名额
     */
    @TableField(value = "zpme")
    @JSONField(name = "zpme")
    @JsonProperty("zpme")
    private String zpme;
    /**
     * 向导实体1名称
     */
    @TableField(value = "wzd0001name")
    @JSONField(name = "wzd0001name")
    @JsonProperty("wzd0001name")
    private String wzd0001name;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 报到时间
     */
    @TableField(value = "bdsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bdsj" , format="yyyy-MM-dd")
    @JsonProperty("bdsj")
    private Timestamp bdsj;
    /**
     * 审批意见
     */
    @TableField(value = "spyj")
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;
    /**
     * 员工类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 人员列表
     */
    @TableField(value = "profilelist")
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;
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
     * 审核意见
     */
    @TableField(value = "shyj")
    @JSONField(name = "shyj")
    @JsonProperty("shyj")
    private String shyj;



    /**
     * 设置 [人数]
     */
    public void setPeoplenum(Integer peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [审核原因]
     */
    public void setShyy(String shyy){
        this.shyy = shyy ;
        this.modify("shyy",shyy);
    }

    /**
     * 设置 [初审意见]
     */
    public void setCsyj(String csyj){
        this.csyj = csyj ;
        this.modify("csyj",csyj);
    }

    /**
     * 设置 [初审原因]
     */
    public void setCsyy(String csyy){
        this.csyy = csyy ;
        this.modify("csyy",csyy);
    }

    /**
     * 设置 [审批原因]
     */
    public void setSpyy(String spyy){
        this.spyy = spyy ;
        this.modify("spyy",spyy);
    }

    /**
     * 设置 [招聘名额]
     */
    public void setZpme(String zpme){
        this.zpme = zpme ;
        this.modify("zpme",zpme);
    }

    /**
     * 设置 [向导实体1名称]
     */
    public void setWzd0001name(String wzd0001name){
        this.wzd0001name = wzd0001name ;
        this.modify("wzd0001name",wzd0001name);
    }

    /**
     * 设置 [报到时间]
     */
    public void setBdsj(Timestamp bdsj){
        this.bdsj = bdsj ;
        this.modify("bdsj",bdsj);
    }

    /**
     * 格式化日期 [报到时间]
     */
    public String formatBdsj(){
        if (this.bdsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bdsj);
    }
    /**
     * 设置 [审批意见]
     */
    public void setSpyj(String spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [员工类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [人员列表]
     */
    public void setProfilelist(String profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [审核意见]
     */
    public void setShyj(String shyj){
        this.shyj = shyj ;
        this.modify("shyj",shyj);
    }


}


