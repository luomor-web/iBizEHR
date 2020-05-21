import { Store } from 'vuex';
import { Http } from '@/utils';

/**
 * 实体服务基类
 *
 * @export
 * @class EntityService
 */
export default class EntityService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof EntityService
     */
    private $store: Store<any> | null = null;

    /**
     * 获取实体数据服务
     *
     * @protected
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['entityServiceRegister'].getService(name);
    }

    /**
     * 零时储存,localStorage指向
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public tempStorage:any;

    /**
     * 当前DE标识
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public APPDEKEY:string= '';

    /**
     * 当前APPDE标识
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public APPLYDEKEY:string= '';

    /**
     * 当前NAME
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public APPDENAME:string= '';

    /**
     * 当前主信息名
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public APPDETEXT:string= '';

    /**
     * 当前系统名
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public SYSTEMNAME:string= '';

    /**
     * 当前应用名
     * 
     * @public
     * @type {(string)}
     * @memberof EntityService
     */ 
    public APPNAME:string= '';

    /**
     * Creates an instance of EntityService.
     * 
     * @param {*} [opts={}]
     * @memberof EntityService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
        this.tempStorage = localStorage;
        this.initBasicData();
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof EntityService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 初始化基础数据
     *
     * @memberof EntityService
     */
    public initBasicData(){
        
    }

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.SelectTemp(context,data,isloading);
    }

    /**
     * SelectTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async SelectTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let result:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            if(result){
                let tempResult:any = result.filter((item:any) =>{
                    return Object.is(item[this.APPDEKEY],data[this.APPDEKEY]);
                })
                let tempResultData:any = tempResult.length>0?tempResult[0]:Object.assign({},data);
                return {"status":200,"data":tempResultData};
            }else{
                return {"status":500,"data":null};
            } 
        }
    }

    /**
     * CreateTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async CreateTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let tempData:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            data.srffrontuf = "0";
            tempData.push(data);
            this.tempStorage.setItem(context.srfsessionkey+'_'+this.APPDENAME,JSON.stringify(tempData));
            return {"status":200,"data":data};
        }else{
            return {"status":200,"data":{}};
        }
    }

    /**
     * GetTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let result:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            if(result){
                let tempResult:any = result.filter((item:any) =>{
                    return Object.is(item[this.APPDEKEY],data[this.APPDEKEY]);
                })
                let tempResultData:any = tempResult.length>0?tempResult[0]:Object.assign({},data);
                return {"status":200,"data":tempResultData};
            }else{
                return {"status":500,"data":null};
            } 
        }
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.UpdateTemp(context,data,isloading);
    }

    /**
     * UpdateTempMajor接口方法
     * 
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async UpdateTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Update(context,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return { status: 500, data: { title: '失败', message: '预置实体行为 Save 未实现' }};
    }

    /**
     * UpdateTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async UpdateTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let result:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            let tempData:Array<any> = [];
            if(result && result.length >0){
                result.forEach((item:any) => {
                    let singleData:any = {};
                    if(Object.is(item[this.APPDEKEY],data[this.APPDEKEY])){
                        Object.keys(item).forEach((field:any) =>{
                            singleData[field] = data[field]?data[field]:item[field];
                        })
                    }
                    if(Object.keys(singleData).length >0){
                        tempData.push(singleData);
                    }else{
                        tempData.push(item);
                    }  
                });
                this.tempStorage.setItem(context.srfsessionkey+'_'+this.APPDENAME,JSON.stringify(tempData));
                return {"status":200,"data":data};
            }else{
                return {"status":500,"data":null};
            }
        }
    }

    /**
     * RemoveTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async RemoveTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let result:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            if(result){
                let tempResult:any = result.filter((item:any) =>{
                    return !( Object.is(item[this.APPDEKEY],data[this.APPDEKEY]) && Object.is(item[this.APPDETEXT],data[this.APPDETEXT]));
                })
                this.tempStorage.setItem(context.srfsessionkey+'_'+this.APPDENAME,JSON.stringify(tempResult));
                 return {"status":200,"data":data};
            }else{
                return {"status":500,"data":null};
            } 
        }
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.srfsessionkey && !Object.is(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME),'undefined')){
            let result:any = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_'+this.APPDENAME) as any);
            if(result){
               let flag:boolean = false;
                result.forEach((item:any) => {
                    if(Object.is(item[this.APPDEKEY],data[this.APPDEKEY])){
                        flag = true;
                    }
                });
                return {"status":200,"data":flag};
            }else{
                return {"status":500,"data":null};
            } 
        }
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.GetDraftTemp(context,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.RemoveTemp(context,data,isloading);
    }

    /**
     * CreateTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async CreateTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Create(context,data,isloading);
    }

    /**
     * RemoveTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async RemoveTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Remove(context,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.GetTemp(context,data,isloading);
    }

    /**
     * GetDraftTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetDraftTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.GetDraft(context,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.CreateTemp(context,data,isloading);
    }

    /**
     * GetTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Get(context,data,isloading);
    }

    /**
     * GetDraftTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetDraftTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData = {srfsessionkey:context.srfsessionkey};
        Object.defineProperty(tempData, this.APPDEKEY, {
            enumerable: true,
            value: data[this.APPDEKEY]
        });
        Object.assign(data,tempData);
        return {"status":200,"data":data}; 
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return { status: 500, data: { title: '失败', message: '预置实体行为 FetchDefault 未实现' }};
    }

    /**
     * FetchTempDefault接口方法
     *
     * @param {*} [context={}] 
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FetchTempDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return { status: 500, data: { title: '失败', message: '预置实体行为 FetchDefault 未实现' }};
    }

    /**
     * FilterUpdate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterUpdate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Update(context,data,isloading);
    }

    /**
     * FilterSearch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterSearch(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.FetchDefault(context,data,isloading);
    }

    /**
     * FilterGet接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterGet(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Get(context,data,isloading);
    }

    /**
     * FilterCreate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterCreate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Create(context,data,isloading);
    }

    /**
     * FilterGetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterGetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.GetDraft(context,data,isloading);
    }

    /**
     * FilterRemove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterRemove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.Remove(context,data,isloading);
    }

    /**
     * FilterFetch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async FilterFetch(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return this.FetchDefault(context,data,isloading);
    }

    /**
     * ImportData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async ImportData(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/import`,data,isloading);
    }

    /**
     * createBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async createBatch(context: any = {},data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/batch`,data,isloading);
    }

    /**
     * updateBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async updateBatch(context: any = {},data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().put(`/${this.APPDENAME}/batch`,data,isloading);
    }

    /**
     * removeBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async removeBatch(context: any = {},data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().delete(`/${this.APPDENAME}/batch`,isloading,data);
    }

	/**
     * WFStart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFStart(context: any = {},data: any = {}, isloading?: boolean,localdata?:any): Promise<any> {
        if(localdata && Object.keys(localdata).length > 0){
            const requestData:any = {};
            Object.assign(requestData,{activedata:data});
            Object.assign(requestData,localdata);
            return Http.getInstance().post(`/wfcore/${this.SYSTEMNAME}-app-${this.APPNAME}/${this.APPDENAME}/${data[this.APPDEKEY]}/process-instances`,requestData,isloading);
        }else{
            const requestData:any = {};
            Object.assign(requestData,{wfdata:data});
            return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfstart`,requestData,isloading);
        }
    }


    /**
     * WFClose接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFClose(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfclose`,data,isloading);
    }


    /**
     * WFMarkRead接口方法
     * 
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFMarkRead(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfmarkread`,data,isloading);
    }

    /**
     * WFGoto接口方法
     * 
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGoto(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfgoto`,data,isloading);
    }

    /**
     * WFRollback接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFRollback(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfrollback`,data,isloading);
    }

    /**
     * WFRestart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFRestart(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfrestart`,data,isloading);
    }

    /**
     * WFReassign接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFReassign(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfreassign`,data,isloading);
    }


    /**
     * WFGetWorkFlow接口方法(获取工作流定义)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetWorkFlow(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/wfcore/${this.SYSTEMNAME}-app-${this.APPNAME}/${this.APPDENAME}/process-definitions`);
    }

    /**
     * WFGetWFStep接口方法(根据系统实体查找当前适配的工作流模型步骤)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetWFStep(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/wfcore/${this.SYSTEMNAME}-app-${this.APPNAME}/${this.APPDENAME}/process-definitions-nodes`);
    }

    /**
     * GetWFLink接口方法(根据业务主键和当前步骤获取操作路径)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetWFLink(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/wfcore/${this.SYSTEMNAME}-app-${this.APPNAME}/${this.APPDENAME}/${context[this.APPLYDEKEY]}/usertasks/${data['taskDefinitionKey']}/ways`);
    }

    /**
     * WFSubmit接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFSubmit(context: any = {},data: any = {}, isloading?: boolean,localdata?:any): Promise<any> {
        if(localdata && Object.keys(localdata).length > 0){
            const requestData:any = {};
            if(data.viewparams){
                delete data.viewparams;
            }
            Object.assign(requestData,{activedata:data});
            Object.assign(requestData,localdata);
            return Http.getInstance().post(`/wfcore/${this.SYSTEMNAME}-app-${this.APPNAME}/${this.APPDENAME}/${data[this.APPDEKEY]}/tasks/${localdata['taskId']}`,requestData,isloading);
        }else{
            const requestData:any = {};
            if(data.srfwfmemo){
                requestData.srfwfmemo = JSON.parse(JSON.stringify(data)).srfwfmemo;
                delete data.srfwfmemo;
            }
            if(data.viewparams){
                delete data.viewparams;
            }
            Object.assign(requestData,{wfdata:data});
            Object.assign(requestData,{opdata:{srfwfiatag:context.srfwfiatag,srfwfstep:context.srfwfstep}});
            return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/wfsubmit`,requestData,isloading);
        }
    }

    /**
     * WFGetProxyData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetProxyData(context: any = {},data: any = {}, isloading?: boolean): Promise<any>{
        return Http.getInstance().get(`/${this.APPDENAME}/${context[this.APPLYDEKEY]}/wfgetproxydata`,data,isloading);
    }

    /**
     * 测试数据是否在工作流中
     * 
     * @param context 
     * @param data 
     * @param isloading 
     */
    public async testDataInWF(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(!context.stateField || !context.stateValue) return false;
        if(context.stateValue == data[context.stateField]){
            return true;
        }
        return false;
    }

    /**
     * 测试当前用户是否提交过工作流
     * 
     * @param context 
     * @param data 
     * @param isloading 
     */
    public async testUserWFSubmit(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return true;
    }

    /**
     * 测试当前用户是否存在待办列表
     * 
     * @param context 
     * @param data 
     * @param isloading 
     */
    public async testUserExistWorklist(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const requestData:any = {};
        Object.assign(requestData,{wfdata:data});
        return Http.getInstance().post(`/${this.APPDENAME}/${data[this.APPDEKEY]}/testuserexistworklist`,requestData,isloading);
    }

}