import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 实体查询模型***服务对象基类
 *
 * @export
 * @class QueryModelServiceBase
 * @extends {EntityServie}
 */
export default class QueryModelServiceBase extends EntityService {

    /**
     * Creates an instance of  QueryModelServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  QueryModelServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof QueryModelServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='querymodel';
        this.APPDEKEY = 'querymodelid';
        this.APPDENAME = 'querymodels';
        this.APPDETEXT = 'querymodelname';
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
     * @memberof QueryModelServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/querymodels/${context.querymodel}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QueryModelServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/querymodels/select`,tempData,isloading);
    }

    /**
     * FetchCurDE接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QueryModelServiceBase
     */
    public async FetchCurDE(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/querymodels/select`,tempData,isloading);
    }
}