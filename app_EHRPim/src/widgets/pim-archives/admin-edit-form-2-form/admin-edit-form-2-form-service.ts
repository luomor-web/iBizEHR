import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimArchivesService from '@/service/pim-archives/pim-archives-service';
import AdminEditForm_2Model from './admin-edit-form-2-form-model';
import PimPersonService from '@/service/pim-person/pim-person-service';
import OrmOrgService from '@/service/orm-org/orm-org-service';


/**
 * AdminEditForm_2 部件服务对象
 *
 * @export
 * @class AdminEditForm_2Service
 */
export default class AdminEditForm_2Service extends ControlService {

    /**
     * 档案信息服务对象
     *
     * @type {PimArchivesService}
     * @memberof AdminEditForm_2Service
     */
    public appEntityService: PimArchivesService = new PimArchivesService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof AdminEditForm_2Service
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of AdminEditForm_2Service.
     * 
     * @param {*} [opts={}]
     * @memberof AdminEditForm_2Service
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new AdminEditForm_2Model();
    }

    /**
     * 人员信息服务对象
     *
     * @type {PimPersonService}
     * @memberof AdminEditForm_2Service
     */
    public pimpersonService: PimPersonService = new PimPersonService();

    /**
     * 组织管理服务对象
     *
     * @type {OrmOrgService}
     * @memberof AdminEditForm_2Service
     */
    public ormorgService: OrmOrgService = new OrmOrgService();

    /**
     * 处理数据
     *
     * @private
     * @param {Promise<any>} promise
     * @returns {Promise<any>}
     * @memberof AdminEditForm_2Service
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
     * @memberof  AdminEditForm_2Service
     */
    @Errorlog
    public getItems(serviceName: string, interfaceName: string, context: any = {}, data: any, isloading?: boolean): Promise<any[]> {
        if (Object.is(serviceName, 'PimPersonService') && Object.is(interfaceName, 'FetchAuthPerson')) {
            return this.doItems(this.pimpersonService.FetchAuthPerson(JSON.parse(JSON.stringify(context)),data, isloading), 'pimpersonid', 'pimperson');
        }
        if (Object.is(serviceName, 'OrmOrgService') && Object.is(interfaceName, 'FetchGSGWZY')) {
            return this.doItems(this.ormorgService.FetchGSGWZY(JSON.parse(JSON.stringify(context)),data, isloading), 'orgid', 'ormorg');
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
     */
    @Errorlog
    public loadDraft(action: string,context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        //仿真主键数据
        const PrimaryKey = Util.createUUID();
        Data.pimarchivesid = PrimaryKey;
        Data.pimarchives = PrimaryKey;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.GetDraft(Context,Data, isloading);
            }
            result.then((response) => {
                response.data.pimarchivesid = PrimaryKey;
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
     * @memberof AdminEditForm_2Service
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
     * @memberof AdminEditForm_2Service
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