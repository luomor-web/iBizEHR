import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PcmProfileService from '@/service/pcm-profile/pcm-profile-service';
import XD_FPModel from './xd-fp-wizardpanel-model';


/**
 * XD_FP 部件服务对象
 *
 * @export
 * @class XD_FPService
 */
export default class XD_FPService extends ControlService {

    /**
     * 应聘者基本信息服务对象
     *
     * @type {PcmProfileService}
     * @memberof XD_FPService
     */
    public appEntityService: PcmProfileService = new PcmProfileService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof XD_FPService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of XD_FPService.
     * 
     * @param {*} [opts={}]
     * @memberof XD_FPService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new XD_FPModel();
    }

    /**
     * 初始化向导
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof XD_FPService
     */
    @Errorlog
    public init(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * 向导结束
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof XD_FPService
     */
    @Errorlog
    public finish(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
}