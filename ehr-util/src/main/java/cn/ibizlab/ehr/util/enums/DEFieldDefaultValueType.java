package cn.ibizlab.ehr.util.enums;

/**
 * 实体属性默认值类型
 */
public enum DEFieldDefaultValueType {
    /**
     * 用户全局对象
     */
    SESSION,
    /**
     * 系统全局对象
     */
    APPLICATION,
    /**
     * 唯一编码
     */
    UNIQUEID,
    /**
     * 网页请求
     */
    CONTEXT,
    /**
     * 数据对象属性
     */
    PARAM,
    /**
     * 当前时间
     */
    CURTIME,
    /**
     * 当前操作用户（编号）
     */
    OPERATOR,
    /**
     * 当前操作用户（名称）
     */
    OPERATORNAME,
    /**
     * 当前应用数据
     */
    APPDATA,
    /**
     * 默认值
     */
    NONE
}
