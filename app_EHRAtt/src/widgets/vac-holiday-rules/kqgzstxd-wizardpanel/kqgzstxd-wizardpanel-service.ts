import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import VacHolidayRulesService from '@/service/vac-holiday-rules/vac-holiday-rules-service';
import KQGZSTXDModel from './kqgzstxd-wizardpanel-model';


/**
 * KQGZSTXD 部件服务对象
 *
 * @export
 * @class KQGZSTXDService
 */
export default class KQGZSTXDService extends ControlService {

    /**
     * 考勤规则服务对象
     *
     * @type {VacHolidayRulesService}
     * @memberof KQGZSTXDService
     */
    public appEntityService: VacHolidayRulesService = new VacHolidayRulesService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof KQGZSTXDService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of KQGZSTXDService.
     * 
     * @param {*} [opts={}]
     * @memberof KQGZSTXDService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new KQGZSTXDModel();
    }

    /**
     * 初始化向导
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof KQGZSTXDService
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
     * @memberof KQGZSTXDService
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