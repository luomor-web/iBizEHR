import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 登录帐户***服务对象基类
 *
 * @export
 * @class LoginAccountServiceBase
 * @extends {EntityServie}
 */
export default class LoginAccountServiceBase extends EntityService {

    /**
     * Creates an instance of  LoginAccountServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  LoginAccountServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof LoginAccountServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='loginaccount';
        this.APPDEKEY = 'loginaccountid';
        this.APPDENAME = 'loginaccounts';
        this.APPDETEXT = 'loginaccountname';
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
     * @memberof LoginAccountServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/loginaccounts/${context.loginaccount}/select`,isloading);
    }

    /**
     * SaveHashMode接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof LoginAccountServiceBase
     */
    public async SaveHashMode(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * GetHashMode接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof LoginAccountServiceBase
     */
    public async GetHashMode(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof LoginAccountServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/loginaccounts/select`,tempData,isloading);
    }
}