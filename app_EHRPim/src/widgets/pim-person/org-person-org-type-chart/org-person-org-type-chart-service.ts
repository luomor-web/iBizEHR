import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimPersonService from '@/service/pim-person/pim-person-service';
import OrgPersonOrgTypeModel from './org-person-org-type-chart-model';


/**
 * OrgPersonOrgType 部件服务对象
 *
 * @export
 * @class OrgPersonOrgTypeService
 */
export default class OrgPersonOrgTypeService extends ControlService {

    /**
     * 人员信息服务对象
     *
     * @type {PimPersonService}
     * @memberof OrgPersonOrgTypeService
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgPersonOrgTypeService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgPersonOrgTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgPersonOrgTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgPersonOrgTypeModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgPersonOrgTypeService
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