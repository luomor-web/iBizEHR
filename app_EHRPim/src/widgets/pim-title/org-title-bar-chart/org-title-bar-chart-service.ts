import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimTitleService from '@/service/pim-title/pim-title-service';
import OrgTitleBarModel from './org-title-bar-chart-model';


/**
 * OrgTitleBar 部件服务对象
 *
 * @export
 * @class OrgTitleBarService
 */
export default class OrgTitleBarService extends ControlService {

    /**
     * 职称信息服务对象
     *
     * @type {PimTitleService}
     * @memberof OrgTitleBarService
     */
    public appEntityService: PimTitleService = new PimTitleService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgTitleBarService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgTitleBarService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgTitleBarService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgTitleBarModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgTitleBarService
     */
    @Errorlog
    public search(action: string,context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            }else{
                result =_appEntityService.FetchDefault(Context,Data, isloading);
            }
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });      
        });
    }
}