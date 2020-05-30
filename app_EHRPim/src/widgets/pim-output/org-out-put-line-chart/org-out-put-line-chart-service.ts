import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimOutputService from '@/service/pim-output/pim-output-service';
import OrgOutPutLineModel from './org-out-put-line-chart-model';


/**
 * OrgOutPutLine 部件服务对象
 *
 * @export
 * @class OrgOutPutLineService
 */
export default class OrgOutPutLineService extends ControlService {

    /**
     * 产值表服务对象
     *
     * @type {PimOutputService}
     * @memberof OrgOutPutLineService
     */
    public appEntityService: PimOutputService = new PimOutputService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgOutPutLineService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgOutPutLineService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgOutPutLineService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgOutPutLineModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgOutPutLineService
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