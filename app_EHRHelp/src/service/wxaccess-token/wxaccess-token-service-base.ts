import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信访问票据***服务对象基类
 *
 * @export
 * @class WXAccessTokenServiceBase
 * @extends {EntityServie}
 */
export default class WXAccessTokenServiceBase extends EntityService {

    /**
     * Creates an instance of  WXAccessTokenServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXAccessTokenServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXAccessTokenServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxaccesstoken';
        this.APPDEKEY = 'wxaccesstokenid';
        this.APPDENAME = 'wxaccesstokens';
        this.APPDETEXT = 'wxaccesstokenname';
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
     * @memberof WXAccessTokenServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxaccesstokens/${context.wxaccesstoken}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXAccessTokenServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxaccesstokens/select`,tempData,isloading);
    }
}