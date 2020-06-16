import Vue, { VNode, CreateElement } from "vue";

/**
 * 工具类
 *
 * @export
 * @interface Verify
 */
export declare interface Verify {
    /**
     * 错误提示信息
     *
     * @type {string}
     * @memberof Verify
     */
    errorInfo: string;
    /**
     * 判断条件是否成立
     *
     * @param {*} value
     * @param {*} op
     * @param {*} value2
     * @returns {boolean}
     * @memberof Verify
     */
    testCond(value: any, op: any, value2: any): boolean;
    /**
     * 文本包含
     *
     * @param {*} value
     * @param {*} value2
     * @returns {boolean}
     * @memberof Verify
     */
    contains(value: any, value2: any): boolean;
    /**
     * 值比较
     *
     * @param {*} value
     * @param {*} value2
     * @returns {number}
     * @memberof Verify
     */
    compare(value: any, value2: any): number;
    /**
     * 是否是时间
     *
     * @param {string} value
     * @returns {boolean}
     * @memberof Verify
     */
    isParseDate(value: string): boolean;
    /**
     * 时间值比较（毫秒数）
     *
     * @param {number} value
     * @param {number} value2
     * @returns {number}
     * @memberof Verify
     */
    compareDate(value: number, value2: number): number;
    /**
     * 数值比较
     *
     * @param {number} value
     * @param {number} value2
     * @returns {number}
     * @memberof Verify
     */
    compareNumber(value: number, value2: number): number;
    /**
     * 字符串比较
     *
     * @param {*} value
     * @param {*} value2
     * @returns {number}
     * @memberof Verify
     */
    compareString(value: any, value2: any): number;
    /**
     * boolean 值比较
     *
     * @param {*} value
     * @param {*} value2
     * @returns {number}
     * @memberof Verify
     */
    compareBoolean(value: any, value2: any): number;
    /**
     * 检查属性常规条件
     *
     * @param {*} value 属性值
     * @param {string} op 检测条件
     * @param {*} value2 预定义值
     * @param {string} errorInfo 错误信息
     * @param {string} paramType 参数类型
     * @param {*} form 表单对象
     * @param {boolean} primaryModel 是否必须条件
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldSimpleRule(value: any, op: string, value2: any, errorInfo: string, paramType: string, form: any, primaryModel: boolean): boolean;
    /**
     * 检查属性字符长度规则
     *
     * @param {string} viewValue
     * @param {number} minLength
     * @param {boolean} indexOfMin
     * @param {number} maxLength
     * @param {boolean} indexOfMax
     * @param {string} errorInfo
     * @param {boolean} primaryModel
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldStringLengthRule(viewValue: string, minLength: number, indexOfMin: boolean, maxLength: number, indexOfMax: boolean, errorInfo: string, primaryModel: boolean): boolean;
    /**
     * 检查属性值正则式规则
     *
     * @param {string} viewValue
     * @param {*} strReg
     * @param {string} errorInfo
     * @param {boolean} primaryModel
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldRegExRule(viewValue: string, strReg: any, errorInfo: string, primaryModel: boolean): boolean;
    /**
     * 检查属性值范围规则
     *
     * @param {string} viewValue
     * @param {*} minNumber
     * @param {boolean} indexOfMin
     * @param {*} maxNumber
     * @param {boolean} indexOfMax
     * @param {string} errorInfo
     * @param {boolean} primaryModel
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldValueRangeRule(viewValue: string, minNumber: any, indexOfMin: boolean, maxNumber: any, indexOfMax: boolean, errorInfo: string, primaryModel: boolean): boolean;
    /**
     * 检查属性值范围规则
     *
     * @param {string} viewValue
     * @param {*} minNumber
     * @param {boolean} indexOfMin
     * @param {*} maxNumber
     * @param {boolean} indexOfMax
     * @param {string} errorInfo
     * @param {boolean} primaryModel
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldValueRangeRule(viewValue: string, minNumber: any, indexOfMin: boolean, maxNumber: any, indexOfMax: boolean, errorInfo: string, primaryModel: boolean): boolean;
    /**
     * 检查属性值系统值范围规则  暂时支持正则表达式
     *
     * @param {string} viewValue
     * @param {*} strReg
     * @param {string} errorInfo
     * @param {boolean} primaryModel
     * @returns {boolean}
     * @memberof Verify
     */
    checkFieldSysValueRule(viewValue: string, strReg: any, errorInfo: string, primaryModel: boolean): boolean;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 工具类
         *
         * @type {Verify}
         * @memberof Vue
         */
        $verify: Verify;
    }
}