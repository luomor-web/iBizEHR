import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 消息发送队列（历史）***服务对象基类
 *
 * @export
 * @class MsgSendQueueHisServiceBase
 * @extends {EntityServie}
 */
export default class MsgSendQueueHisServiceBase extends EntityService {

    /**
     * Creates an instance of  MsgSendQueueHisServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgSendQueueHisServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof MsgSendQueueHisServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='msgsendqueuehis';
        this.APPDEKEY = 'msgsendqueuehisid';
        this.APPDENAME = 'msgsendqueuehis';
        this.APPDETEXT = 'msgsendqueuehisname';
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
     * @memberof MsgSendQueueHisServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/msgsendqueuehis/${context.msgsendqueuehis}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MsgSendQueueHisServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/msgsendqueuehis/select`,tempData,isloading);
    }
}