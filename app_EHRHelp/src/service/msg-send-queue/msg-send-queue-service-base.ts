import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 消息发送队列***服务对象基类
 *
 * @export
 * @class MsgSendQueueServiceBase
 * @extends {EntityServie}
 */
export default class MsgSendQueueServiceBase extends EntityService {

    /**
     * Creates an instance of  MsgSendQueueServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgSendQueueServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof MsgSendQueueServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='msgsendqueue';
        this.APPDEKEY = 'msgsendqueueid';
        this.APPDENAME = 'msgsendqueues';
        this.APPDETEXT = 'msgsendqueuename';
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
     * @memberof MsgSendQueueServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/msgsendqueues/${context.msgsendqueue}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MsgSendQueueServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/msgsendqueues/select`,tempData,isloading);
    }
}