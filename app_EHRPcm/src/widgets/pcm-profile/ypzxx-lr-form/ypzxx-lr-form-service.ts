import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PcmProfileService from '@/service/pcm-profile/pcm-profile-service';
import YPZXX_LRModel from './ypzxx-lr-form-model';
import PIMPERSONService from '@/service/pimperson/pimperson-service';
import PIMCITYService from '@/service/pimcity/pimcity-service';
import OrmOrgService from '@/service/orm-org/orm-org-service';
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';
import OrmPostService from '@/service/orm-post/orm-post-service';
import ORMDUTYService from '@/service/ormduty/ormduty-service';


/**
 * YPZXX_LR 部件服务对象
 *
 * @export
 * @class YPZXX_LRService
 */
export default class YPZXX_LRService extends ControlService {

    /**
     * 应聘者基本信息服务对象
     *
     * @type {PcmProfileService}
     * @memberof YPZXX_LRService
     */
    public appEntityService: PcmProfileService = new PcmProfileService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof YPZXX_LRService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of YPZXX_LRService.
     * 
     * @param {*} [opts={}]
     * @memberof YPZXX_LRService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new YPZXX_LRModel();
    }

    /**
     * 人员信息服务对象
     *
     * @type {PIMPERSONService}
     * @memberof YPZXX_LRService
     */
    public pimpersonService: PIMPERSONService = new PIMPERSONService();

    /**
     * 市服务对象
     *
     * @type {PIMCITYService}
     * @memberof YPZXX_LRService
     */
    public pimcityService: PIMCITYService = new PIMCITYService();

    /**
     * 组织管理服务对象
     *
     * @type {OrmOrgService}
     * @memberof YPZXX_LRService
     */
    public ormorgService: OrmOrgService = new OrmOrgService();

    /**
     * 部门管理服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof YPZXX_LRService
     */
    public ormorgsectorService: OrmOrgsectorService = new OrmOrgsectorService();

    /**
     * 岗位服务对象
     *
     * @type {OrmPostService}
     * @memberof YPZXX_LRService
     */
    public ormpostService: OrmPostService = new OrmPostService();

    /**
     * 职务管理服务对象
     *
     * @type {ORMDUTYService}
     * @memberof YPZXX_LRService
     */
    public ormdutyService: ORMDUTYService = new ORMDUTYService();

    /**
     * 处理数据
     *
     * @private
     * @param {Promise<any>} promise
     * @returns {Promise<any>}
     * @memberof YPZXX_LRService
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
     * @memberof  YPZXX_LRService
     */
    @Errorlog
    public getItems(serviceName: string, interfaceName: string, context: any = {}, data: any, isloading?: boolean): Promise<any[]> {
        if (Object.is(serviceName, 'PIMPERSONService') && Object.is(interfaceName, 'FetchTXRYCX')) {
            return this.doItems(this.pimpersonService.FetchTXRYCX(JSON.parse(JSON.stringify(context)),data, isloading), 'pimpersonid', 'pimperson');
        }
        if (Object.is(serviceName, 'PIMCITYService') && Object.is(interfaceName, 'FetchDefault')) {
            return this.doItems(this.pimcityService.FetchDefault(JSON.parse(JSON.stringify(context)),data, isloading), 'pimcityid', 'pimcity');
        }
        if (Object.is(serviceName, 'OrmOrgService') && Object.is(interfaceName, 'FetchOrglist_Profile')) {
            return this.doItems(this.ormorgService.FetchOrglist_Profile(JSON.parse(JSON.stringify(context)),data, isloading), 'orgid', 'ormorg');
        }
        if (Object.is(serviceName, 'OrmOrgsectorService') && Object.is(interfaceName, 'FetchCURORMORG')) {
            return this.doItems(this.ormorgsectorService.FetchCURORMORG(JSON.parse(JSON.stringify(context)),data, isloading), 'orgsectorid', 'ormorgsector');
        }
        if (Object.is(serviceName, 'OrmPostService') && Object.is(interfaceName, 'FetchEJZZGW')) {
            return this.doItems(this.ormpostService.FetchEJZZGW(JSON.parse(JSON.stringify(context)),data, isloading), 'ormpostid', 'ormpost');
        }
        if (Object.is(serviceName, 'ORMDUTYService') && Object.is(interfaceName, 'FetchCurOrmorgsector')) {
            return this.doItems(this.ormdutyService.FetchCurOrmorgsector(JSON.parse(JSON.stringify(context)),data, isloading), 'ormdutyid', 'ormduty');
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
     */
    @Errorlog
    public wfsubmit(action: string,context: any = {}, data: any = {}, isloading?: boolean,localdata?:any): Promise<any> {
        data = this.handleWFData(data,true);
        context = this.handleRequestData(action,context,data).context;
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
     */
    @Errorlog
    public loadDraft(action: string,context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data);
        //仿真主键数据
        const PrimaryKey = Util.createUUID();
        Data.pcmprofileid = PrimaryKey;
        Data.pcmprofile = PrimaryKey;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.GetDraft(Context,Data, isloading);
            }
            result.then((response) => {
                response.data.pcmprofileid = PrimaryKey;
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
     * @memberof YPZXX_LRService
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
     * @memberof YPZXX_LRService
     */
    public handleRequestData(action: string,context:any, data: any = {}){
        let mode: any = this.getMode();
        if (!mode && mode.getDataItems instanceof Function) {
            return data;
        }
        let formItemItems: any[] = mode.getDataItems();
        let requestData:any = {};
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
        if(data && data.viewparams){
            Object.assign(requestData,data.viewparams);
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        if(tempContext && tempContext.srfsessionid){
            tempContext.srfsessionkey = tempContext.srfsessionid;
            delete tempContext.srfsessionid;
        }
        return {context:tempContext,data:requestData};
    }

}