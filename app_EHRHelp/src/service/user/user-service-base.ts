import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import CreateRelatedInfoLogic from '@/service/user/create-related-info-logic';



/**
 * 用户***服务对象基类
 *
 * @export
 * @class UserServiceBase
 * @extends {EntityServie}
 */
export default class UserServiceBase extends EntityService {

    /**
     * Creates an instance of  UserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='user';
        this.APPDEKEY = 'userid';
        this.APPDENAME = 'users';
        this.APPDETEXT = 'username';
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
     * @memberof UserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/users/${context.user}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/users/select`,tempData,isloading);
    }
}