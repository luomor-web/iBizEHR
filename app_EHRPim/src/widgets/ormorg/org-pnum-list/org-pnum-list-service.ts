import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import ORMORGService from '@/service/ormorg/ormorg-service';
import OrgPNumModel from './org-pnum-list-model';


/**
 * OrgPNum 部件服务对象
 *
 * @export
 * @class OrgPNumService
 */
export default class OrgPNumService extends ControlService {

    /**
     * 组织管理服务对象
     *
     * @type {ORMORGService}
     * @memberof OrgPNumService
     */
    public appEntityService: ORMORGService = new ORMORGService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OrgPNumService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OrgPNumService.
     * 
     * @param {*} [opts={}]
     * @memberof OrgPNumService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OrgPNumModel();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgPNumService
     */
    @Errorlog
    public search(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof OrgPNumService
     */
    @Errorlog
    public delete(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            }else{
                result =_appEntityService.remove(Context,Data , isloading);
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