import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 数据对象能力明细***服务对象基类
 *
 * @export
 * @class UserRoleDataDetailServiceBase
 * @extends {EntityServie}
 */
export default class UserRoleDataDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  UserRoleDataDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserRoleDataDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userroledatadetail';
        this.APPDEKEY = 'userroledatadetailid';
        this.APPDENAME = 'userroledatadetails';
        this.APPDETEXT = 'userroledatadetailname';
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
     * @memberof UserRoleDataDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userroledatadetails/${context.userroledatadetail}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserRoleDataDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userroledatadetails/select`,tempData,isloading);
    }
}