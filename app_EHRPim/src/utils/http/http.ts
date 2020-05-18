import axios from 'axios';
import { ElLoadingComponent } from 'element-ui/types/loading';
import qs from 'qs';
import Vue from 'vue';
/**
 * Http net 对象
 * 调用 getInstance() 获取实例
 *
 * @class Http
 */
export class Http {

    /**
     * 获取 Http 单例对象
     *
     * @static
     * @returns {Http}
     * @memberof Http
     */
    public static getInstance(): Http {
        if (!Http.Http) {
            Http.Http = new Http();
        }
        return this.Http;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {Http}
     * @memberof Http
     */
    private static Http: Http;

    /**
     * 统计加载
     *
     * @type {number}
     * @memberof Http
     */
    private loadingCount: number = 0;

    /**
     * load状态管理器
     *
     * @private
     * @type {(ElLoadingComponent | any)}
     * @memberof Http
     */
    private elLoadingComponent: ElLoadingComponent | any;

    /**
     * Creates an instance of Http.
     * 私有构造，拒绝通过 new 创建对象
     * 
     * @memberof Http
     */
    private constructor() { }

    /**
     * post请求
     *
     * @param {string} url
     * @param {*} [params={}]
     * @param {boolean} [isloading]
     * @param {number} [serialnumber]
     * @returns {Promise<any>}
     * @memberof Http
     */
    public post(url: string, params: any = {}, isloading?: boolean, serialnumber?: number): Promise<any> {
        if (isloading) {
            this.beginLoading();
        }
        params = this.handleRequestData(params);
        return new Promise((resolve: any, reject: any) => {
            axios({
                method: 'post',
                url: url,
                data: params,
                headers: { 'Content-Type': 'application/json;charset=UTF-8', 'Accept': 'application/json' },
                // transformResponse: [(data: any) => {
                //     let _data: any = null;
                //     try {
                //         _data = JSON.parse(JSON.stringify(data));
                //     } catch (error) {
                //     }
                //     return _data;
                // }],
            }).then((response: any) => {
                this.doResponseRresult(response, resolve, isloading, serialnumber);
            }).catch((response: any) => {
                this.doResponseRresult(response, reject, isloading, serialnumber);
            });
        });
    }

    /**
     * 获取
     *
     * @param {string} url
     * @param {*} [params={}]
     * @param {boolean} [isloading]
     * @param {number} [serialnumber]
     * @returns {Promise<any>}
     * @memberof Http
     */
    public get(url: string, params: any = {}, isloading?: boolean, serialnumber?: number): Promise<any> {
        params = this.handleRequestData(params);
        if (params.srfparentdata) {
            Object.assign(params, params.srfparentdata);
            delete params.srfparentdata;
        }
        if ((Object.keys(params)).length > 0) {
            let tempParam: any = {};
            let sort: any = null;
            Object.keys(params).forEach((item: any) => {
                if (params[item] || Object.is(params[item], 0)) {
                    if (Object.is(item, 'sort')) {
                        sort = params[item];
                    } else {
                        tempParam[item] = params[item];
                    }
                }
            })
            url += `?${qs.stringify(tempParam)}`;
            if (sort) {
                url += '&sort=' + sort;
            }
        }
        if (isloading) {
            this.beginLoading();
        }
        return new Promise((resolve: any, reject: any) => {
            axios.get(url).then((response: any) => {
                this.doResponseRresult(response, resolve, isloading, serialnumber);
            }).catch((response: any) => {
                this.doResponseRresult(response, reject, isloading, serialnumber);
            });
        });
    }

    /**
     * 删除
     *
     * @param {string} url
     * @param {boolean} [isloading]
     * @param {number} [serialnumber]
     * @returns {Promise<any>}
     * @memberof Http
     */
    public delete(url: string, isloading?: boolean,data?:any, serialnumber?: number): Promise<any> {
        if (isloading) {
            this.beginLoading();
        }
        return new Promise((resolve: any, reject: any) => {
            if(!data){
                axios.delete(url).then((response: any) => {
                    this.doResponseRresult(response, resolve, isloading, serialnumber);
                }).catch((response: any) => {
                    this.doResponseRresult(response, reject, isloading, serialnumber);
                });
            }else{
                axios.delete(url,{data:data}).then((response: any) => {
                    this.doResponseRresult(response, resolve, isloading, serialnumber);
                }).catch((response: any) => {
                    this.doResponseRresult(response, reject, isloading, serialnumber);
                });
            }
        });
    }

    /**
     * 修改数据
     *
     * @param {string} url
     * @param {*} data
     * @param {boolean} [isloading]
     * @param {number} [serialnumber]
     * @returns {Promise<any>}
     * @memberof Http
     */
    public put(url: string, data: any, isloading?: boolean, serialnumber?: number): Promise<any> {
        if (isloading) {
            this.beginLoading();
        }
        data = this.handleRequestData(data);
        return new Promise((resolve: any, reject: any) => {
            axios.put(url, data).then((response: any) => {
                this.doResponseRresult(response, resolve, isloading, serialnumber);
            }).catch((response: any) => {
                this.doResponseRresult(response, reject, isloading, serialnumber);
            });
        });
    }

    /**
     * 处理响应结果
     *
     * @private
     * @param {*} response
     * @param {Function} funt
     * @param {boolean} [isloading]
     * @param {number} [serialnumber]
     * @memberof Http
     */
    private doResponseRresult(response: any, funt: Function, isloading?: boolean, serialnumber?: number): void {
        if (isloading) {
            this.endLoading();
        }
        if (serialnumber) {
            Object.assign(response, { serialnumber: serialnumber });
        }
        funt(response);
    }

    /**
     * 开始加载
     *
     * @private
     * @memberof Http
     */
    private beginLoading(): void {
        if (this.loadingCount === 0) {
            Vue.prototype.$Spin.show();
        }
        this.loadingCount++;
    }

    /**
     * 加载结束
     *
     * @private
     * @memberof Http
     */
    private endLoading(): void {
        if (this.loadingCount > 0) {
            this.loadingCount--;
        }
        setTimeout(() => {
            if (this.loadingCount === 0) {
                Vue.prototype.$Spin.hide();
            }
        }, 500);
    }

    /**
     * 处理请求数据
     * 
     * @private
     * @param data 
     * @memberof Http
     */
    private handleRequestData(data: any) {
        if (data.srfsessionkey) {
            delete data.srfsessionkey;
        }
        if (data.srfsessionid) {
            delete data.srfsessionid;
        }
        return data;
    }

}