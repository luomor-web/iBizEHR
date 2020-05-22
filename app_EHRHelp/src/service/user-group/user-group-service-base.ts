import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户组***服务对象基类
 *
 * @export
 * @class UserGroupServiceBase
 * @extends {EntityServie}
 */
export default class UserGroupServiceBase extends EntityService {

    /**
     * Creates an instance of  UserGroupServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserGroupServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserGroupServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='usergroup';
        this.APPDEKEY = 'usergroupid';
        this.APPDENAME = 'usergroups';
        this.APPDETEXT = 'usergroupname';
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
     * @memberof UserGroupServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/usergroups/${context.usergroup}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserGroupServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/usergroups/select`,tempData,isloading);
    }
}