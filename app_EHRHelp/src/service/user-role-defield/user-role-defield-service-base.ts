import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色实体属性访问***服务对象基类
 *
 * @export
 * @class UserRoleDEFieldServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDEFieldServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDEFieldServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDEFieldServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDEFieldServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledefield';
        this.APPDEKEY = 'userroledefieldid';
        this.APPDENAME = 'userroledefields';
        this.APPDETEXT = 'userroledefieldname';
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
     * @memberof UserRoleDEFieldServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledefields/${context.userroledefield}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDEFieldServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledefields/select`,tempData,isloading);
    }
}