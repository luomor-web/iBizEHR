import { Store } from 'vuex';
import { Util } from '@/utils/util/util';

/**
 * 部件服务基类
 *
 * @export
 * @class ControlService
 */
export default class ControlService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof Service
     */
    private $store: Store<any> | null = null;

    /**
     * 部件模型
     *
     * @type {(any | null)}
     * @memberof ControlService
     */
    public model: any | null = null;

    /**
     * 是否为从数据模式
     *
     * @type {boolean}
     * @memberof ControlService
     */
    public isTempMode:boolean = false;

    /**
     * Creates an instance of ControlService.
     * 
     * @param {*} [opts={}]
     * @memberof ControlService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
        this.setTempMode();
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof ControlService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 获取部件模型
     *
     * @returns {*}
     * @memberof ControlService
     */
    public getMode(): any {
        return this.model;
    }

    /**
     * 设置零时模式
     *
     * @returns {(any | null)}
     * @memberof ControlService
     */
    protected setTempMode(){
        
    }

    /**
     * 处理请求数据
     * 
     * @param action 行为 
     * @param data 数据
     * @memberof ControlService
     */
    public handleRequestData(action: string,context:any ={},data: any = {},isMerge:boolean = false){
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let dataItems: any[] = model.getDataItems();
        let requestData:any = {};
        dataItems.forEach((item:any) =>{
            if(item && item.dataType && Object.is(item.dataType,'FONTKEY')){
                if(item && item.prop && item.name ){
                    requestData[item.prop] = context[item.name];
                }
            }else{
                if(item && item.prop && item.name && (data[item.name] || Object.is(data[item.name],0)) ){
                    requestData[item.prop] = data[item.name];
                }
            }
        });
        if(isMerge && (data && data.viewparams)){
            Object.assign(requestData,data.viewparams);
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        if(tempContext && tempContext.srfsessionid){
            tempContext.srfsessionkey = tempContext.srfsessionid;
            delete tempContext.srfsessionid;
        }
        return {context:tempContext,data:requestData};
    }

    /**
     * 处理response
     *
     * @param {string} action
     * @param {*} response
     * @memberof ControlService
     */
    public handleResponse(action: string, response: any,isCreate:boolean = false){
        let result = null;
        if (!response.data) {
            return
        } else if (response.data instanceof Array) {
            result = [];
            response.data.forEach((item:any) =>{
                result.push(this.handleResponseData(action, item, isCreate));
            });
        }else{
            result = this.handleResponseData(action, response.data, isCreate);
        }
        // response状态，头文件
        if(response.headers){
            if(response.headers['x-page']){
                Object.assign(response,{page:Number(response.headers['x-page'])});
            }
            if(response.headers['x-per-page']){
                Object.assign(response,{size:Number(response.headers['x-per-page'])});
            }
            if(response.headers['x-total']){
                Object.assign(response,{total:Number(response.headers['x-total'])});
            }
        }
        response.data = result;
    }

    /**
     * 处理返回数据
     *
     * @param {string} action
     * @param {*} response
     * @memberof ControlService
     */
    public handleResponseData(action: string, data: any = {},isCreate?:boolean){
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let item: any = {};
        let dataItems: any[] = model.getDataItems();
        dataItems.forEach(dataitem => {
            let val = data.hasOwnProperty(dataitem.prop) ? data[dataitem.prop] : null;
            if (!val) {
                val = data.hasOwnProperty(dataitem.name) ? data[dataitem.name] : null;
            }
            if((isCreate === undefined || isCreate === null ) && Object.is(dataitem.dataType, 'GUID') && Object.is(dataitem.name, 'srfkey') && (val && !Object.is(val, ''))){
                isCreate = true;
            }
            // if((Object.is(dataitem.dataType,'DATE') || Object.is(dataitem.dataType,'DATETIME')) && !Object.is(Date.parse(val),NaN)){
            //     val = Util.dateFormat(new Date(val));
            // }
            item[dataitem.name] = val;
        });
        item.srfuf = data.srfuf ? data.srfuf : (isCreate ? "0" : "1");
        return item;
    }

    /**
     * 处理工作流数据
     * 
     * @param data 传入数据
     */
    public handleWFData(data:any, isMerge:boolean = false){
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let dataItems: any[] = model.getDataItems();
        let requestData:any = {};
        dataItems.forEach((item:any) =>{
            if(item && item.prop){
                requestData[item.prop] = data[item.name];
            }
        });
        if(isMerge && (data.viewparams && Object.keys(data.viewparams).length > 0)){
            Object.assign(requestData,data.viewparams);
        }
        return requestData;
    }

}