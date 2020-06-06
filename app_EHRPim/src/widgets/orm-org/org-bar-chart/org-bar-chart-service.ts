import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import OrmOrgService from '@/service/orm-org/orm-org-service';
import OrgBarModel from './org-bar-chart-model';


/**
 * OrgBar 部件服务对象
 *
 * @export
 * @class OrgBarService
 */
export default class OrgBarService extends ControlService {

    /**
     * 组织管理服务对象
     *
     * @type {OrmOrgService}
     * @memberof OrgBarService
     */
    public appEntityService: OrmOrgService = new OrmOrgService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgBarService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgBarService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgBarService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgBarModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgBarService
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