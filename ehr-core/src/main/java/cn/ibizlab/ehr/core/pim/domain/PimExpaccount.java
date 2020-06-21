package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[费用台账]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMEXPACCOUNT",resultMap = "PimExpaccountResultMap")
public class PimExpaccount extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发放时间
     */
    @TableField(value = "ffsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ffsj" , format="yyyy-MM-dd")
    @JsonProperty("ffsj")
    private Timestamp ffsj;
    /**
     * 发放人数
     */
    @TableField(value = "ffrs")
    @JSONField(name = "ffrs")
    @JsonProperty("ffrs")
    private Integer ffrs;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 费用金额
     */
    @TableField(value = "fyje")
    @JSONField(name = "fyje")
    @JsonProperty("fyje")
    private Double fyje;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 费用台账名称
     */
    @TableField(value = "pimexpaccountname")
    @JSONField(name = "pimexpaccountname")
    @JsonProperty("pimexpaccountname")
    private String pimexpaccountname;
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
     * 费用标准
     */
    @TableField(value = "ffybz")
    @JSONField(name = "ffybz")
    @JsonProperty("ffybz")
    private String ffybz;
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
     * 费用台账标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimexpaccountid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimexpaccountid")
    @JsonProperty("pimexpaccountid")
    private String pimexpaccountid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 费用类别
     */
    @TableField(value = "fylb")
    @JSONField(name = "fylb")
    @JsonProperty("fylb")
    private String fylb;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [发放时间]
     */
    public void setFfsj(Timestamp ffsj){
        this.ffsj = ffsj ;
        this.modify("ffsj",ffsj);
    }

    /**
     * 格式化日期 [发放时间]
     */
    public String formatFfsj(){
        if (this.ffsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ffsj);
    }
    /**
     * 设置 [发放人数]
     */
    public void setFfrs(Integer ffrs){
        this.ffrs = ffrs ;
        this.modify("ffrs",ffrs);
    }

    /**
     * 设置 [费用金额]
     */
    public void setFyje(Double fyje){
        this.fyje = fyje ;
        this.modify("fyje",fyje);
    }

    /**
     * 设置 [费用台账名称]
     */
    public void setPimexpaccountname(String pimexpaccountname){
        this.pimexpaccountname = pimexpaccountname ;
        this.modify("pimexpaccountname",pimexpaccountname);
    }

    /**
     * 设置 [费用标准]
     */
    public void setFfybz(String ffybz){
        this.ffybz = ffybz ;
        this.modify("ffybz",ffybz);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [费用类别]
     */
    public void setFylb(String fylb){
        this.fylb = fylb ;
        this.modify("fylb",fylb);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


