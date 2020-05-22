import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户代办***服务对象基类
 *
 * @export
 * @class WFUserAssistServiceBase
 * @extends {EntityServie}
 */
export default class WFUserAssistServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserAssistServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserAssistServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserAssistServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfuserassist';
        this.APPDEKEY = 'wfuserassistid';
        this.APPDENAME = 'wfuserassists';
        this.APPDETEXT = 'wfuserassistname';
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
     * @memberof WFUserAssistServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfuserassists/${context.wfuserassist}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserAssistServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfuserassists/select`,tempData,isloading);
    }
}