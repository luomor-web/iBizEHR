import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 微信消息***服务对象基类
 *
 * @export
 * @class WXMessageServiceBase
 * @extends {EntityServie}
 */
export default class WXMessageServiceBase extends EntityService {

    /**
     * Creates an instance of  WXMessageServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WXMessageServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WXMessageServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wxmessage';
        this.APPDEKEY = 'wxmessageid';
        this.APPDENAME = 'wxmessages';
        this.APPDETEXT = 'wxmessagename';
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
     * @memberof WXMessageServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wxmessages/${context.wxmessage}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WXMessageServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wxmessages/select`,tempData,isloading);
    }
}