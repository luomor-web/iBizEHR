import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色资源能力***服务对象基类
 *
 * @export
 * @class UserRoleResServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleResServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleResServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleResServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleResServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroleres';
        this.APPDEKEY = 'userroleresid';
        this.APPDENAME = 'userroleres';
        this.APPDETEXT = 'userroleresname';
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
     * @memberof UserRoleResServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroleres/${context.userroleres}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleResServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroleres/select`,tempData,isloading);
    }
}