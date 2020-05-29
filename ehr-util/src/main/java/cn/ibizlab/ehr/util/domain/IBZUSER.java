package cn.ibizlab.ehr.util.domain;

import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 实体[IBZUSER] 数据对象
 */
@TableName(value = "IBZUSER")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class IBZUSER implements Serializable{

    @Size(min = 0, max = 100, message = "[用户标识]长度必须在[100]以内!")
    @TableId(value= "userid",type=IdType.INPUT)//指定主键生成策略
    private String userid;

    @Size(min = 0, max = 200, message = "[用户全局名]长度必须在[200]以内!")
    private String username;

    @Size(min = 0, max = 100, message = "[用户姓名]长度必须在[100]以内!")
    private String personname;

    @Size(min = 0, max = 100, message = "[用户代码]长度必须在[100]以内!")
    private String usercode;

    @Size(min = 0, max = 100, message = "[登录别名]长度必须在[100]以内!")
    private String loginname;

    @Size(min = 0, max = 100, message = "[登录密码]长度必须在[100]以内!")
    private String password;

    @Size(min = 0, max = 100, message = "[区属]长度必须在[100]以内!")
    private String domains;

    @Size(min = 0, max = 100, message = "[主部门id]长度必须在[100]以内!")
    private String mdeptid;

    @Size(min = 0, max = 100, message = "[主部门代码]长度必须在[100]以内!")
    private String mdeptcode;

    @Size(min = 0, max = 200, message = "[主部门名称]长度必须在[200]以内!")
    private String mdeptname;

    @Size(min = 0, max = 100, message = "[业务编码]长度必须在[100]以内!")
    private String bcode;

    @Size(min = 0, max = 100, message = "[岗位id]长度必须在[100]以内!")
    private String postid;

    @Size(min = 0, max = 100, message = "[岗位代码]长度必须在[100]以内!")
    private String postcode;

    @Size(min = 0, max = 200, message = "[岗位名称]长度必须在[200]以内!")
    private String postname;

    @Size(min = 0, max = 100, message = "[单位id]长度必须在[100]以内!")
    private String orgid;

    @Size(min = 0, max = 100, message = "[单位代码]长度必须在[100]以内!")
    private String orgcode;

    @Size(min = 0, max = 200, message = "[单位名称]长度必须在[200]以内!")
    private String orgname;

    @Size(min = 0, max = 36, message = "[昵称]长度必须在[36]以内!")
    private String nickname;

    @Size(min = 0, max = 100, message = "[邮箱]长度必须在[100]以内!")
    private String email;

    @Size(min = 0, max = 100, message = "[通信账号]长度必须在[100]以内!")
    private String avatar;

    @Size(min = 0, max = 100, message = "[联系电话]长度必须在[100]以内!")
    private String phone;

    @Size(min = 0, max = 100, message = "[保留字段]长度必须在[100]以内!")
    private String reserver;

    @Size(min = 0, max = 100, message = "[头像]长度必须在[100]以内!")
    private String usericon;

    @Size(min = 0, max = 10, message = "[性别]长度必须在[10]以内!")
    private String sex;

    private Timestamp birthday;

    @Size(min = 0, max = 36, message = "[证件号码]长度必须在[36]以内!")
    private String certcode;

    @Size(min = 0, max = 200, message = "[地址]长度必须在[200]以内!")
    private String addr;

    @Size(min = 0, max = 100, message = "[主题]长度必须在[100]以内!")
    private String theme;

    @Size(min = 0, max = 100, message = "[语言]长度必须在[100]以内!")
    private String lang;

    @Size(min = 0, max = 10, message = "[字号]长度必须在[10]以内!")
    private String fontsize;

    @Size(min = 0, max = 500, message = "[备注]长度必须在[500]以内!")
    private String memo;

    private int superuser;

}