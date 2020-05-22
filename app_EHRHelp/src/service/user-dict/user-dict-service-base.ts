import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户词典***服务对象基类
 *
 * @export
 * @class UserDictServiceBase
 * @extends {EntityServie}
 */
export default class UserDictServiceBase extends EntityService {

    /**
     * Creates an instance of  UserDictServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserDictServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userdict';
        this.APPDEKEY = 'userdictid';
        this.APPDENAME = 'userdicts';
        this.APPDETEXT = 'userdictname';
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
     * @memberof UserDictServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userdicts/${context.userdict}/select`,isloading);
    }

    /**
     * ReloadCurUser接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserDictServiceBase
     */
    public async ReloadCurUser(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserDictServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userdicts/select`,tempData,isloading);
    }
}