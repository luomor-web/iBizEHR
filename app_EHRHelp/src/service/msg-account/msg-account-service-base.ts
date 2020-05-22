import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 消息账户***服务对象基类
 *
 * @export
 * @class MsgAccountServiceBase
 * @extends {EntityServie}
 */
export default class MsgAccountServiceBase extends EntityService {

    /**
     * Creates an instance of  MsgAccountServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgAccountServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof MsgAccountServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='msgaccount';
        this.APPDEKEY = 'msgaccountid';
        this.APPDENAME = 'msgaccounts';
        this.APPDETEXT = 'msgaccountname';
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
     * @memberof MsgAccountServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/msgaccounts/${context.msgaccount}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MsgAccountServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/msgaccounts/select`,tempData,isloading);
    }
}