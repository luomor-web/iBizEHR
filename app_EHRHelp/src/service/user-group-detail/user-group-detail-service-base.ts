import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户组成员***服务对象基类
 *
 * @export
 * @class UserGroupDetailServiceBase
 * @extends {EntityServie}
 */
export default class UserGroupDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  UserGroupDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserGroupDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserGroupDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='usergroupdetail';
        this.APPDEKEY = 'usergroupdetailid';
        this.APPDENAME = 'usergroupdetails';
        this.APPDETEXT = 'usergroupdetailname';
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
     * @memberof UserGroupDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/usergroupdetails/${context.usergroupdetail}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserGroupDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/usergroupdetails/select`,tempData,isloading);
    }
}