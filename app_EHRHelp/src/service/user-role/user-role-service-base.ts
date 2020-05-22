import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色***服务对象基类
 *
 * @export
 * @class UserRoleServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userrole';
        this.APPDEKEY = 'userroleid';
        this.APPDENAME = 'userroles';
        this.APPDETEXT = 'userrolename';
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
     * @memberof UserRoleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroles/${context.userrole}/select`,isloading);
    }

    /**
     * FetchLevelC接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleServiceBase
     */
    public async FetchLevelC(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroles/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroles/select`,tempData,isloading);
    }
}