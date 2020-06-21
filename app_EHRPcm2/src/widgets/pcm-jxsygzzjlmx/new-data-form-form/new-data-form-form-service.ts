import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PcmJxsygzzjlmxService from '@/service/pcm-jxsygzzjlmx/pcm-jxsygzzjlmx-service';
import NewDataFormModel from './new-data-form-form-model';
import PimPersonService from '@/service/pim-person/pim-person-service';
import PcmJxszzkhjgjlService from '@/service/pcm-jxszzkhjgjl/pcm-jxszzkhjgjl-service';


/**
 * NewDataForm 部件服务对象
 *
 * @export
 * @class NewDataFormService
 */
export default class NewDataFormService extends ControlService {

    /**
     * 见习生员工转正记录引用明细服务对象
     *
     * @type {PcmJxsygzzjlmxService}
     * @memberof NewDataFormService
     */
    public appEntityService: PcmJxsygzzjlmxService = new PcmJxsygzzjlmxService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof NewDataFormService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of NewDataFormService.
     * 
     * @param {*} [opts={}]
     * @memberof NewDataFormService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new NewDataFormModel();
    }

    /**
     * 人员信息服务对象
     *
     * @type {PimPersonService}
     * @memberof NewDataFormService
     */
    public pimpersonService: PimPersonService = new PimPersonService();

    /**
     * 见习生员工转正考核结果记录服务对象
     *
     * @type {PcmJxszzkhjgjlService}
     * @memberof NewDataFormService
     */
    public pcmjxszzkhjgjlService: PcmJxszzkhjgjlService = new PcmJxszzkhjgjlService();

    /**
     * 处理数据
     *
     * @private
     * @param {Promise<any>} promise
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    private doItems(promise: Promise<any>, deKeyField: string, deName: string): Promise<any> {
        return new Promise((resolve, reject) => {
            promise.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    data.forEach((item:any,index:number) =>{
                        item[deName] = item[deKeyField];
                        data[index] = item;
                    });
                    resolve(data);
                } else {
                    reject([])
                }
            }).catch((response: any) => {
                reject([])
            });
        });
    }

    /**
     * 获取跨实体数据集合
     *
     * @param {string} serviceName 服务名称
     * @param {string} interfaceName 接口名称
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any[]>}
     * @memberof  NewDataFormService
     */
    @Errorlog
    public getItems(serviceName: string, interfaceName: string, context: any = {}, data: any, isloading?: boolean): Promise<any[]> {
        if (Object.is(serviceName, 'PimPersonService') && Object.is(interfaceName, 'FetchJXQYGCX')) {
            return this.doItems(this.pimpersonService.FetchJXQYGCX(JSON.parse(JSON.stringify(context)),data, isloading), 'pimpersonid', 'pimperson');
        }
        if (Object.is(serviceName, 'PcmJxszzkhjgjlService') && Object.is(interfaceName, 'FetchDefault')) {
            return this.doItems(this.pcmjxszzkhjgjlService.FetchDefault(JSON.parse(JSON.stringify(context)),data, isloading), 'pcmjxszzkhjgjlid', 'pcmjxszzkhjgjl');
        }

        return Promise.reject([])
    }

    /**
     * 启动工作流
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public wfstart(action: string,context: any = {},data: any = {}, isloading?: boolean,localdata?:any): Promise<any> {
        data = this.handleWFData(data);
        context = this.handleRequestData(action,context,data).context;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](context,data, isloading,localdata);
            } else {
                result = this.appEntityService.WFStart(context,data, isloading,localdata);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 提交工作流
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public wfsubmit(action: string,context: any = {}, data: any = {}, isloading?: boolean,localdata?:any): Promise<any> {
        data = this.handleWFData(data,true);
        context = this.handleRequestData(action,context,data,true).context;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](context,data, isloading,localdata);
            } else {
                result = this.appEntityService.WFSubmit(context,data, isloading,localdata);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }


    /**
     * 添加数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public add(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.Create(Context,Data, isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 删除数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public delete(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.Remove(Context,Data, isloading);
            }
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 修改数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public update(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.Update(Context,Data, isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public get(action: string,context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.Get(Context,Data, isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 加载草稿
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public loadDraft(action: string,context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        //仿真主键数据
        const PrimaryKey = Util.createUUID();
        Data.pcmjxsygzzjlmxid = PrimaryKey;
        Data.pcmjxsygzzjlmx = PrimaryKey;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.GetDraft(Context,Data, isloading);
            }
            result.then((response) => {
                response.data.pcmjxsygzzjlmxid = PrimaryKey;
                this.handleResponse(action, response, true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

     /**
     * 前台逻辑
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof NewDataFormService
     */
    @Errorlog
    public frontLogic(action:string,context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        return new Promise((resolve: any, reject: any)=>{
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                return Promise.reject({ status: 500, data: { title: '失败', message: '系统异常' } });
            }
            result.then((response) => {
                this.handleResponse(action, response,true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        })
    }

    /**
     * 处理请求数据
     * 
     * @param action 行为 
     * @param data 数据
     * @memberof NewDataFormService
     */
    public handleRequestData(action: string,context:any, data: any = {},isMerge:boolean = false){
        let mode: any = this.getMode();
        if (!mode && mode.getDataItems instanceof Function) {
            return data;
        }
        let formItemItems: any[] = mode.getDataItems();
        let requestData:any = {};
        if(isMerge && (data && data.viewparams)){
            Object.assign(requestData,data.viewparams);
        }
        formItemItems.forEach((item:any) =>{
            if(item && item.dataType && Object.is(item.dataType,'FONTKEY')){
                if(item && item.prop){
                    requestData[item.prop] = context[item.name];
                }
            }else{
                if(item && item.prop){
                    requestData[item.prop] = data[item.name];
                }
            }
        });
        let tempContext:any = JSON.parse(JSON.stringify(context));
        if(tempContext && tempContext.srfsessionid){
            tempContext.srfsessionkey = tempContext.srfsessionid;
            delete tempContext.srfsessionid;
        }
        return {context:tempContext,data:requestData};
    }

}