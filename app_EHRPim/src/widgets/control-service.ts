import { Store } from 'vuex';
import { Util } from '@/utils/util/util';
import CodeListService from "@service/app/codelist-service";

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
     * 代码表服务对象
     *
     * @type {any}
     * @memberof ControlService
     */  
    public codeListService:any;

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
        this.codeListService = new CodeListService({ $store:opts.$store });
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
    public async handleResponse(action: string, response: any,isCreate:boolean = false){
        let result = null;
        if (!response.data) {
            return
        }
        const handleResult:any = (action: string, response: any,isCreate:boolean,codelistArray?:any) =>{
            if (response.data instanceof Array) {
                result = [];
                response.data.forEach((item:any) =>{
                    result.push(this.handleResponseData(action, item, isCreate,codelistArray));
                });
            }else{
                result = this.handleResponseData(action, response.data, isCreate,codelistArray);
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
        let codelistModel:Array<any> = this.handleCodelist();
        if(codelistModel.length >0){
            let res:any = await this.getAllCodeList(codelistModel);
            handleResult(action, response,isCreate,res);
        }else{
            handleResult(action, response,isCreate);
        }
    }

    /**
     * 处理返回数据
     *
     * @param {string} action
     * @param {*} response
     * @memberof ControlService
     */
    public handleResponseData(action: string, data: any = {},isCreate?:boolean,codelistArray?:any){
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
            item[dataitem.name] = val;
            // 转化代码表
            if(codelistArray && dataitem.codelist){
                if(codelistArray.get(dataitem.codelist.tag) && codelistArray.get(dataitem.codelist.tag).get(val)){
                    item[dataitem.name] = codelistArray.get(dataitem.codelist.tag).get(val);
                }
            }
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

    /**
     * 处理代码表
     * 
     * @memberof ControlService
     */
    public handleCodelist(){
        let model: any = this.getMode();
        if (!model) {
            return [];
        }
        let dataItems: any[] = model.getDataItems();
        let codelistMap:Map<string,any> = new Map();
        if(dataItems && dataItems.length >0){
            dataItems.forEach((item:any) =>{
                if(item.codelist){
                    codelistMap.set(item.name,item.codelist);
                }
            })
        }
        if(codelistMap.size >0){
            return  Array.from(codelistMap).map(item => item[1]);
        }else{
            return [];
        }
    }

    /**
     * 获取所有代码表
     * 
     * @param codelistArray 代码表模型数组
     * @memberof ControlService
     */
    public getAllCodeList(codelistArray:Array<any>):Promise<any>{
        return new Promise((resolve:any,reject:any) =>{
            let codeListMap:Map<string,any> = new Map();
            let promiseArray:Array<any> = [];
            codelistArray.forEach((item:any) =>{
                if(!codeListMap.get(item.tag)){
                    promiseArray.push(this.getCodeList(item));
                    Promise.all(promiseArray).then((result:any) =>{
                        if(result && result.length >0){
                            result.forEach((codeList:any) =>{
                                let tempCodeListMap:Map<number,any> = new Map();
                                if(codeList.length >0){
                                    codeList.forEach((codeListItem:any) =>{
                                        tempCodeListMap.set(codeListItem.value,codeListItem.text);
                                    })
                                }
                                codeListMap.set(item.tag,tempCodeListMap);       
                            })
                            resolve(codeListMap);
                        }
                    })
                }
            })
        })
    }

    /**
     * 获取代码表
     * 
     * @param codeListObject 传入代码表对象
     * @memberof ControlService
     */
    public getCodeList(codeListObject:any):Promise<any>{
        return new Promise((resolve:any,reject:any) =>{
            if(codeListObject.tag && Object.is(codeListObject.codelistType,"STATIC")){
                const codelist = (this.getStore() as Store<any>).getters.getCodeList(codeListObject.tag);
                if (codelist) {
                    resolve([...JSON.parse(JSON.stringify(codelist.items))]);
                } else {
                    resolve([]);
                    console.log(`----${codeListObject.tag}----代码表不存在`);
                }
            }else if(codeListObject.tag && Object.is(codeListObject.codelistType,"DYNAMIC")){
                this.codeListService.getItems(codeListObject.tag).then((res:any) => {
                    resolve(res);
                }).catch((error:any) => {
                    resolve([]);
                    console.log(`----${codeListObject.tag}----代码表不存在`);
                });
            }
        })
    }
}