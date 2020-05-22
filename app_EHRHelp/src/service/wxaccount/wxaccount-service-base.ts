import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信公众号***服务对象基类
 *
 * @export
 * @class WXAccountServiceBase
 * @extends {EntityServie}
 */
export default class WXAccountServiceBase extends EntityService {

    /**
     * Creates an instance of  WXAccountServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXAccountServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXAccountServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxaccount';
        this.APPDEKEY = 'wxaccountid';
        this.APPDENAME = 'wxaccounts';
        this.APPDETEXT = 'wxaccountname';
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
     * @memberof WXAccountServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxaccounts/${context.wxaccount}/select`,isloading);
    }

    /**
     * SyncOrgSector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXAccountServiceBase
     */
    public async SyncOrgSector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * PubMenu接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXAccountServiceBase
     */
    public async PubMenu(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * SyncOrgUser接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXAccountServiceBase
     */
    public async SyncOrgUser(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXAccountServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxaccounts/select`,tempData,isloading);
    }
}