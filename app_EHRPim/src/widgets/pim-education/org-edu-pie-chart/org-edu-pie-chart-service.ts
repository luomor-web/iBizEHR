import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimEducationService from '@/service/pim-education/pim-education-service';
import OrgEduPieModel from './org-edu-pie-chart-model';


/**
 * OrgEduPie 部件服务对象
 *
 * @export
 * @class OrgEduPieService
 */
export default class OrgEduPieService extends ControlService {

    /**
     * 教育信息服务对象
     *
     * @type {PimEducationService}
     * @memberof OrgEduPieService
     */
    public appEntityService: PimEducationService = new PimEducationService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgEduPieService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgEduPieService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgEduPieService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgEduPieModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgEduPieService
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