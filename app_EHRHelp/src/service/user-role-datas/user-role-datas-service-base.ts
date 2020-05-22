import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色数据能力***服务对象基类
 *
 * @export
 * @class UserRoleDatasServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDatasServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDatasServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDatasServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDatasServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledatas';
        this.APPDEKEY = 'userroledatasid';
        this.APPDENAME = 'userroledatas';
        this.APPDETEXT = 'userroledatasname';
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
     * @memberof UserRoleDatasServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledatas/${context.userroledatas}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDatasServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledatas/select`,tempData,isloading);
    }
}