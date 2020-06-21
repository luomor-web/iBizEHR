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
 * 实体[异动兼职明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYDJZMX",resultMap = "PcmYdjzmxResultMap")
public class PcmYdjzmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 异动兼职明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmydjzmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmydjzmxid")
    @JsonProperty("pcmydjzmxid")
    private String pcmydjzmxid;
    /**
     * 是否到期
     */
    @TableField(exist = false)
    @JSONField(name = "sfdq")
    @JsonProperty("sfdq")
    private String sfdq;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 生效日期
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 分配id
     */
    @TableField(value = "pimdistirbutionid")
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;
    /**
     * 兼职结束日期
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 所属职务
     */
    @TableField(exist = false)
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
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
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 所属岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
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
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 剩余月份
     */
    @TableField(exist = false)
    @JSONField(name = "syyf")
    @JsonProperty("syyf")
    private Integer syyf;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 审核状态
     */
    @TableField(exist = false)
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 剩余月份颜色
     */
    @TableField(exist = false)
    @JSONField(name = "syyf_color")
    @JsonProperty("syyf_color")
    private String syyfColor;
    /**
     * 人员信息标识
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 兼职开始日期
     */
    @TableField(value = "ksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksrq" , format="yyyy-MM-dd")
    @JsonProperty("ksrq")
    private Timestamp ksrq;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 异动兼职明细名称
     */
    @TableField(value = "pcmydjzmxname")
    @JSONField(name = "pcmydjzmxname")
    @JsonProperty("pcmydjzmxname")
    private String pcmydjzmxname;
    /**
     * 分组类型
     */
    @TableField(exist = false)
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 兼职岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 兼职组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 兼职职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 兼职部门
     */
    @TableField(exist = false)
    @JSONField(name = "jzshortname")
    @JsonProperty("jzshortname")
    private String jzshortname;
    /**
     * 兼职组织
     */
    @TableField(exist = false)
    @JSONField(name = "jzzzdzs")
    @JsonProperty("jzzzdzs")
    private String jzzzdzs;
    /**
     * 兼职部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 兼职岗位管理标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 兼职组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 兼职职务标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 兼职部门标识
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
     * 兼职职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 兼职部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 兼职组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 兼职岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;



    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [分配id]
     */
    public void setPimdistirbutionid(String pimdistirbutionid){
        this.pimdistirbutionid = pimdistirbutionid ;
        this.modify("pimdistirbutionid",pimdistirbutionid);
    }

    /**
     * 设置 [兼职结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [兼职结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [兼职开始日期]
     */
    public void setKsrq(Timestamp ksrq){
        this.ksrq = ksrq ;
        this.modify("ksrq",ksrq);
    }

    /**
     * 格式化日期 [兼职开始日期]
     */
    public String formatKsrq(){
        if (this.ksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ksrq);
    }
    /**
     * 设置 [异动兼职明细名称]
     */
    public void setPcmydjzmxname(String pcmydjzmxname){
        this.pcmydjzmxname = pcmydjzmxname ;
        this.modify("pcmydjzmxname",pcmydjzmxname);
    }

    /**
     * 设置 [兼职岗位管理标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [兼职组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [兼职职务标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [兼职部门标识]
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


