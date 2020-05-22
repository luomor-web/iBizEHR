import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色类型***服务对象基类
 *
 * @export
 * @class UserRoleTypeServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleTypeServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleTypeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleTypeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleTypeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroletype';
        this.APPDEKEY = 'userroletypeid';
        this.APPDENAME = 'userroletypes';
        this.APPDETEXT = 'userroletypename';
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
     * @memberof UserRoleTypeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroletypes/${context.userroletype}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleTypeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroletypes/select`,tempData,isloading);
    }
}