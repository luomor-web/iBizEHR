import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 数据对象能力***服务对象基类
 *
 * @export
 * @class UserRoleDataServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDataServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDataServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDataServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledata';
        this.APPDEKEY = 'userroledataid';
        this.APPDENAME = 'userroledata';
        this.APPDETEXT = 'userroledataname';
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
     * @memberof UserRoleDataServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledata/${context.userroledata}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDataServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledata/select`,tempData,isloading);
    }
}