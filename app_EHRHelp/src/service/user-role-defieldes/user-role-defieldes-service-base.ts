import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色相关实体属性访问控制***服务对象基类
 *
 * @export
 * @class UserRoleDEFieldesServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDEFieldesServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDEFieldesServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDEFieldesServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDEFieldesServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledefieldes';
        this.APPDEKEY = 'userroledefieldsid';
        this.APPDENAME = 'userroledefieldes';
        this.APPDETEXT = 'userroledefieldsname';
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
     * @memberof UserRoleDEFieldesServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledefieldes/${context.userroledefieldes}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDEFieldesServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledefieldes/select`,tempData,isloading);
    }
}