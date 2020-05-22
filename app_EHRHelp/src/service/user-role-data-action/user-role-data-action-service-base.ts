import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色数据操作***服务对象基类
 *
 * @export
 * @class UserRoleDataActionServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDataActionServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDataActionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataActionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDataActionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledataaction';
        this.APPDEKEY = 'userroledataactionid';
        this.APPDENAME = 'userroledataactions';
        this.APPDETEXT = 'userroledataactionname';
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
     * @memberof UserRoleDataActionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledataactions/${context.userroledataaction}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDataActionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledataactions/select`,tempData,isloading);
    }
}