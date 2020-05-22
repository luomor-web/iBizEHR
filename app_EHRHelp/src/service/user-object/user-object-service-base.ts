import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户对象***服务对象基类
 *
 * @export
 * @class UserObjectServiceBase
 * @extends {EntityServie}
 */
export default class UserObjectServiceBase extends EntityService {

    /**
     * Creates an instance of  UserObjectServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserObjectServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserObjectServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userobject';
        this.APPDEKEY = 'userobjectid';
        this.APPDENAME = 'userobjects';
        this.APPDETEXT = 'userobjectname';
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
     * @memberof UserObjectServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userobjects/${context.userobject}/select`,isloading);
    }

    /**
     * FetchIndexDER接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserObjectServiceBase
     */
    public async FetchIndexDER(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userobjects/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserObjectServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userobjects/select`,tempData,isloading);
    }
}