import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信多媒体内容***服务对象基类
 *
 * @export
 * @class WXMediaServiceBase
 * @extends {EntityServie}
 */
export default class WXMediaServiceBase extends EntityService {

    /**
     * Creates an instance of  WXMediaServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXMediaServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXMediaServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxmedia';
        this.APPDEKEY = 'wxmediaid';
        this.APPDENAME = 'wxmedia';
        this.APPDETEXT = 'wxmedianame';
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
     * @memberof WXMediaServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxmedia/${context.wxmedia}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXMediaServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxmedia/select`,tempData,isloading);
    }
}