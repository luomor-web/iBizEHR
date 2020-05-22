import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信部门***服务对象基类
 *
 * @export
 * @class WXOrgSectorServiceBase
 * @extends {EntityServie}
 */
export default class WXOrgSectorServiceBase extends EntityService {

    /**
     * Creates an instance of  WXOrgSectorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXOrgSectorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXOrgSectorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxorgsector';
        this.APPDEKEY = 'wxorgsectorid';
        this.APPDENAME = 'wxorgsectors';
        this.APPDETEXT = 'wxorgsectorname';
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
     * @memberof WXOrgSectorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxorgsectors/${context.wxorgsector}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXOrgSectorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxorgsectors/select`,tempData,isloading);
    }
}