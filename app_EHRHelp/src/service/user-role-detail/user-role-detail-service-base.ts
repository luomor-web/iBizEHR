import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色成员***服务对象基类
 *
 * @export
 * @class UserRoleDetailServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledetail';
        this.APPDEKEY = 'userroledetailid';
        this.APPDENAME = 'userroledetails';
        this.APPDETEXT = 'userroledetailname';
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
     * @memberof UserRoleDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledetails/${context.userroledetail}/select`,isloading);
    }

    /**
     * FetchCurrentCompany接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDetailServiceBase
     */
    public async FetchCurrentCompany(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledetails/select`,tempData,isloading);
    }

    /**
     * FetchOrderByUserCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDetailServiceBase
     */
    public async FetchOrderByUserCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledetails/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledetails/select`,tempData,isloading);
    }

    /**
     * FetchSysManager接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDetailServiceBase
     */
    public async FetchSysManager(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledetails/select`,tempData,isloading);
    }
}