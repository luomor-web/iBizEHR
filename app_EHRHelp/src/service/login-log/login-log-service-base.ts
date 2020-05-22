import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 帐户使用记录***服务对象基类
 *
 * @export
 * @class LoginLogServiceBase
 * @extends {EntityServie}
 */
export default class LoginLogServiceBase extends EntityService {

    /**
     * Creates an instance of  LoginLogServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  LoginLogServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof LoginLogServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='loginlog';
        this.APPDEKEY = 'loginlogid';
        this.APPDENAME = 'loginlogs';
        this.APPDETEXT = 'loginlogname';
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
     * @memberof LoginLogServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/loginlogs/${context.loginlog}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof LoginLogServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/loginlogs/select`,tempData,isloading);
    }
}