import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信企业应用***服务对象基类
 *
 * @export
 * @class WXEntAppServiceBase
 * @extends {EntityServie}
 */
export default class WXEntAppServiceBase extends EntityService {

    /**
     * Creates an instance of  WXEntAppServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXEntAppServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXEntAppServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxentapp';
        this.APPDEKEY = 'wxentappid';
        this.APPDENAME = 'wxentapps';
        this.APPDETEXT = 'wxentappname';
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
     * @memberof WXEntAppServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxentapps/${context.wxentapp}/select`,isloading);
    }

    /**
     * PubMenu接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXEntAppServiceBase
     */
    public async PubMenu(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXEntAppServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxentapps/select`,tempData,isloading);
    }
}