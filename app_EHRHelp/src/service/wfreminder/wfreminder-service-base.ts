import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流工作催办***服务对象基类
 *
 * @export
 * @class WFReminderServiceBase
 * @extends {EntityServie}
 */
export default class WFReminderServiceBase extends EntityService {

    /**
     * Creates an instance of  WFReminderServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFReminderServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFReminderServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfreminder';
        this.APPDEKEY = 'wfreminderid';
        this.APPDENAME = 'wfreminders';
        this.APPDETEXT = 'wfremindername';
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
     * @memberof WFReminderServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfreminders/${context.wfreminder}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFReminderServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfreminders/select`,tempData,isloading);
    }
}