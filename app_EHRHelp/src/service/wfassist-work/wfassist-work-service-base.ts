import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流代办工作***服务对象基类
 *
 * @export
 * @class WFAssistWorkServiceBase
 * @extends {EntityServie}
 */
export default class WFAssistWorkServiceBase extends EntityService {

    /**
     * Creates an instance of  WFAssistWorkServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFAssistWorkServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFAssistWorkServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfassistwork';
        this.APPDEKEY = 'wfassistworkid';
        this.APPDENAME = 'wfassistworks';
        this.APPDETEXT = 'wfassistworkname';
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
     * @memberof WFAssistWorkServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfassistworks/${context.wfassistwork}/select`,isloading);
    }

    /**
     * FetchCurUserAssistWork接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFAssistWorkServiceBase
     */
    public async FetchCurUserAssistWork(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfassistworks/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFAssistWorkServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfassistworks/select`,tempData,isloading);
    }
}