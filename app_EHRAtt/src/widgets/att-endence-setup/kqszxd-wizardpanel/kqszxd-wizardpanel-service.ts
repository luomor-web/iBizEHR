import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import AttEndenceSetupService from '@/service/att-endence-setup/att-endence-setup-service';
import KQSZXDModel from './kqszxd-wizardpanel-model';


/**
 * KQSZXD 部件服务对象
 *
 * @export
 * @class KQSZXDService
 */
export default class KQSZXDService extends ControlService {

    /**
     * 考勤设置服务对象
     *
     * @type {AttEndenceSetupService}
     * @memberof KQSZXDService
     */
    public appEntityService: AttEndenceSetupService = new AttEndenceSetupService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof KQSZXDService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of KQSZXDService.
     * 
     * @param {*} [opts={}]
     * @memberof KQSZXDService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new KQSZXDModel();
    }

    /**
     * 初始化向导
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof KQSZXDService
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
     * @memberof KQSZXDService
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