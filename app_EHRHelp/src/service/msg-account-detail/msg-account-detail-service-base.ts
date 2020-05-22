import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组消息账户明细***服务对象基类
 *
 * @export
 * @class MsgAccountDetailServiceBase
 * @extends {EntityServie}
 */
export default class MsgAccountDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  MsgAccountDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgAccountDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof MsgAccountDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='msgaccountdetail';
        this.APPDEKEY = 'msgaccountdetailid';
        this.APPDENAME = 'msgaccountdetails';
        this.APPDETEXT = 'msgaccountdetailname';
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
     * @memberof MsgAccountDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/msgaccountdetails/${context.msgaccountdetail}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MsgAccountDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/msgaccountdetails/select`,tempData,isloading);
    }
}