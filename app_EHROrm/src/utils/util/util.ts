import qs from 'qs';
import { Route } from 'vue-router';

/**
 * 平台工具类
 * 
 * @export
 * @class Util
 */
export class Util {

    /**
     * 创建 UUID
     *
     * @static
     * @returns {string}
     * @memberof Util
     */
    public static createUUID(): string {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1);
        }
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
    }

    /**
     * 创建序列号
     *
     * @static
     * @returns {number}
     * @memberof Util
     */
    public static createSerialNumber(): number {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000);
        }
        return s4();
    }

    /**
     * 判断是否为一个函数
     *
     * @static
     * @param {*} func
     * @returns {boolean}
     * @memberof Util
     */
    public static isFunction(func: any): boolean {
        return typeof (func) === 'function';
    }

    /**
     *
     *
     * @static
     * @param {*} [o={}]
     * @memberof Util
     */
    public static processResult(o: any = {}): void {
        if (o.url != null && o.url !== '') {
            window.location.href = o.url;
        }
        if (o.code != null && o.code !== '') {
            // tslint:disable-next-line:no-eval
            eval(o.code);
        }

        if (o.downloadurl != null && o.downloadurl !== '') {
            const downloadurl = this.parseURL2(o.downloadurl, '');
            this.download(downloadurl);
        }
    }

    /**
     * 下载文件
     * 
     * @static
     * @param {string} url 
     * @memberof Util
     */
    public static download(url: string): void {
        window.open(url, '_blank');
    }

    /**
     * 
     * 
     * @static
     * @param {any} url 
     * @param {any} params 
     * @returns {string} 
     * @memberof Util
     */
    public static parseURL2(url: string, params: any): string {
        let tmpURL;
        if (url.indexOf('../../') !== -1) {
            tmpURL = url.substring(url.indexOf('../../') + 6, url.length);
        } else if (url.indexOf('/') === 0) {
            tmpURL = url.substring(url.indexOf('/') + 1, url.length);
        } else {
            tmpURL = url;
        }

        if (params) {
            return tmpURL + (url.indexOf('?') === -1 ? '?' : '&');
        } else {
            return tmpURL;
        }
    }

    /**
     * 是否是数字
     * 
     * @param {*} num 
     * @returns {boolean} 
     * @memberof Util
     */
    public static isNumberNaN(num: any): boolean {
        return Number.isNaN(num) || num !== num;
    }

    /**
     * 是否未定义
     * 
     * @static
     * @param {*} value 
     * @returns {boolean} 
     * @memberof Util
     */
    public static isUndefined(value: any): boolean {
        return typeof value === 'undefined';
    }

    /**
     * 是否为空
     * 
     * @static
     * @param {*} value 
     * @returns {boolean} 
     * @memberof Util
     */
    public static isEmpty(value: any): boolean {
        return this.isUndefined(value) || Object.is(value, '') || value === null || value !== value;
    }

    /**
     * 转换为矩阵参数
     *
     * @static
     * @param {*} obj
     * @returns {*}
     * @memberof Util
     */
    public static formatMatrixStringify(obj: any): any {
        let str: string = '';
        if (obj && !(obj instanceof Array) && (obj instanceof Object)) {
            const keys: string[] = Object.keys(obj);
            keys.forEach((key: string) => {
                if (!obj[key]) {
                    return;
                }
                if (!Object.is(str, '')) {
                    str += ';';
                }
                str += `${key}=${obj[key]}`;
            });
        }
        return Object.is(str, '') ? undefined : str;
    }

    /**
     * 准备路由参数
     *
     * @static
     * @param {*} { route: route, sourceNode: sourceNode, targetNode: targetNode, data: data }
     * @returns {*}
     * @memberof Util
     */
    public static prepareRouteParmas({ route: route, sourceNode: sourceNode, targetNode: targetNode, data: data }: any): any {
        const params: any = {};
        if (!sourceNode || (sourceNode && Object.is(sourceNode, ''))) {
            return params;
        }
        if (!targetNode || (targetNode && Object.is(targetNode, ''))) {
            return params;
        }
        const indexName = route.matched[0].name;
        Object.assign(params, { [indexName]: route.params[indexName] });
        Object.assign(params, { [targetNode]: this.formatMatrixStringify(data) });
        return params;
    }

    /**
     * 获取当前值类型
     *
     * @static
     * @param {*} obj
     * @returns
     * @memberof Util
     */
    public static typeOf(obj: any): string {
        const toString = Object.prototype.toString;
        const map: any = {
            '[object Boolean]': 'boolean',
            '[object Number]': 'number',
            '[object String]': 'string',
            '[object Function]': 'function',
            '[object Array]': 'array',
            '[object Date]': 'date',
            '[object RegExp]': 'regExp',
            '[object Undefined]': 'undefined',
            '[object Null]': 'null',
            '[object Object]': 'object'
        };
        return map[toString.call(obj)];
    }

    /**
     * 深拷贝(deepCopy)
     *
     * @static
     * @param {*} data
     * @returns {*}
     * @memberof Util
     */
    public static deepCopy(data: any): any {
        const t = this.typeOf(data);
        let o: any;

        if (t === 'array') {
            o = [];
        } else if (t === 'object') {
            o = {};
        } else {
            return data;
        }

        if (t === 'array') {
            for (let i = 0; i < data.length; i++) {
                o.push(this.deepCopy(data[i]));
            }
        } else if (t === 'object') {
            for (let i in data) {
                o[i] = this.deepCopy(data[i]);
            }
        }
        return o;
    }

    /**
     * 名称格式化
     *
     * @static
     * @param {string} name
     * @returns {string}
     * @memberof Util
     */
    public static srfFilePath2(name: string): string {
        if (!name || (name && Object.is(name, ''))) {
            throw new Error('名称异常');
        }
        name = name.replace(/[_]/g, '-');
        let state: number = 0;
        let _str = '';
        const uPattern = /^[A-Z]{1}$/;

        const str1 = name.substring(0, 1);
        const str2 = name.substring(1)
        state = uPattern.test(str1) ? 1 : 0;
        _str = `${_str}${str1.toLowerCase()}`;

        for (let chr of str2) {
            if (uPattern.test(chr)) {
                if (state === 1) {
                    _str = `${_str}${chr.toLowerCase()}`;
                } else {
                    _str = `${_str}-${chr.toLowerCase()}`;
                }
                state = 1
            } else {
                _str = `${_str}${chr.toLowerCase()}`;
                state = 0
            }
        }
        _str = _str.replace(/---/g, '-').replace(/--/g, '-');

        return _str;
    }

    /**
     * 附加参数格式化
     *
     * @static
     * @param {any} arg 表单数据
     * @param {any} params 附加参数
     * @returns {any}
     * @memberof Util
     */
    public static formatData(arg: any, params: any): any {
        let _data: any = {};
        Object.keys(params).forEach((name: string) => {
            if (!name) {
                return;
            }
            let value: string | null = params[name];
            if (value && value.startsWith('%') && value.endsWith('%')) {
                const key = value.substring(1, value.length - 1);
                if (arg && arg.hasOwnProperty(key)) {
                    value = (arg[key] !== null && arg[key] !== undefined) ? arg[key] : null;
                } else {
                    value = null;
                }
            }
            Object.assign(_data, { [name]: value });
        });
        return _data;
    }

    /**
     * 日期格式化
     *
     * @static
     * @param {string} fmt 格式化字符串
     * @param {any} date 日期对象
     * @returns {string}
     * @memberof Util
     */
    public static dateFormat(date: any,fmt: string = "YYYY-mm-dd HH:MM:SS"):string {
        let ret;
        const opt: any = {
            "Y+": date.getFullYear().toString(),        // 年
            "m+": (date.getMonth() + 1).toString(),     // 月
            "d+": date.getDate().toString(),            // 日
            "H+": date.getHours().toString(),           // 时
            "M+": date.getMinutes().toString(),         // 分
            "S+": date.getSeconds().toString()          // 秒
            // 有其他格式化字符需求可以继续添加，必须转化成字符串
        };
        for (let k in opt) {
            ret = new RegExp("(" + k + ")").exec(fmt);
            if (ret) {
                fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
            };
        };
        return fmt;
    }


    /**
     * 深度合并对象
     * 
     * @param FirstOBJ 目标对象
     * @param SecondOBJ 原对象
     * @returns {Object}
     * @memberof Util
     */
    public static deepObjectMerge(FirstOBJ:any, SecondOBJ:any) {
        for (var key in SecondOBJ) {
            FirstOBJ[key] = FirstOBJ[key] && FirstOBJ[key].toString() === "[object Object]" ?
                this.deepObjectMerge(FirstOBJ[key], SecondOBJ[key]) : FirstOBJ[key] = SecondOBJ[key];
        }
        return FirstOBJ;
    }

}