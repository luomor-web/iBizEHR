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
 * 实体[异动待岗明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYDDGMX",resultMap = "PcmYddgmxResultMap")
public class PcmYddgmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 待岗开始日期
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 待岗地区
     */
    @TableField(value = "dgdq")
    @JSONField(name = "dgdq")
    @JsonProperty("dgdq")
    private String dgdq;
    /**
     * 待岗结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;
    /**
     * 人员信息标识
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
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
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 所属岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
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
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 异动待岗明细名称
     */
    @TableField(value = "pcmyddgmxname")
    @JSONField(name = "pcmyddgmxname")
    @JsonProperty("pcmyddgmxname")
    private String pcmyddgmxname;
    /**
     * 所属职务
     */
    @TableField(exist = false)
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 待岗类型
     */
    @TableField(value = "dglx")
    @JSONField(name = "dglx")
    @JsonProperty("dglx")
    private String dglx;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 异动待岗明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmyddgmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmyddgmxid")
    @JsonProperty("pcmyddgmxid")
    private String pcmyddgmxid;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 审核状态
     */
    @TableField(exist = false)
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 主分配id
     */
    @TableField(value = "distirbutionid")
    @JSONField(name = "distirbutionid")
    @JsonProperty("distirbutionid")
    private String distirbutionid;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 所属组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 分组类型
     */
    @TableField(exist = false)
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;
    /**
     * 待岗原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 待岗部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 待岗部门
     */
    @TableField(exist = false)
    @JSONField(name = "dgshortname")
    @JsonProperty("dgshortname")
    private String dgshortname;
    /**
     * 待岗部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 是否完成
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isfinished")
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;

    /**
     * 待岗部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;



    /**
     * 设置 [待岗地区]
     */
    public void setDgdq(String dgdq){
        this.dgdq = dgdq ;
        this.modify("dgdq",dgdq);
    }

    /**
     * 设置 [待岗结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [待岗结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [异动待岗明细名称]
     */
    public void setPcmyddgmxname(String pcmyddgmxname){
        this.pcmyddgmxname = pcmyddgmxname ;
        this.modify("pcmyddgmxname",pcmyddgmxname);
    }

    /**
     * 设置 [待岗类型]
     */
    public void setDglx(String dglx){
        this.dglx = dglx ;
        this.modify("dglx",dglx);
    }

    /**
     * 设置 [主分配id]
     */
    public void setDistirbutionid(String distirbutionid){
        this.distirbutionid = distirbutionid ;
        this.modify("distirbutionid",distirbutionid);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [待岗原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [待岗部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [是否完成]
     */
    public void setIsfinished(String isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}


