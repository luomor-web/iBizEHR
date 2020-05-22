import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 实体***服务对象基类
 *
 * @export
 * @class DataEntityServiceBase
 * @extends {EntityServie}
 */
export default class DataEntityServiceBase extends EntityService {

    /**
     * Creates an instance of  DataEntityServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DataEntityServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof DataEntityServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='dataentity';
        this.APPDEKEY = 'deid';
        this.APPDENAME = 'dataentities';
        this.APPDETEXT = 'dename';
        this.APPNAME = 'ehrhelp';
        this.SYSTEMNAME = 'ehr';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DataEntityServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/dataentities/${context.dataentity}/select`,isloading);
    }

    /**
     * InitUserRoleData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DataEntityServiceBase
     */
    public async InitUserRoleData(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * InitAll接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DataEntityServiceBase
     */
    public async InitAll(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DataEntityServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/dataentities/select`,tempData,isloading);
    }
}