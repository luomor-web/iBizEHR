import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流实例***服务对象基类
 *
 * @export
 * @class WFInstanceServiceBase
 * @extends {EntityServie}
 */
export default class WFInstanceServiceBase extends EntityService {

    /**
     * Creates an instance of  WFInstanceServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFInstanceServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFInstanceServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfinstance';
        this.APPDEKEY = 'wfinstanceid';
        this.APPDENAME = 'wfinstances';
        this.APPDETEXT = 'wfinstancename';
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
     * @memberof WFInstanceServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfinstances/${context.wfinstance}/select`,isloading);
    }

    /**
     * Restart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFInstanceServiceBase
     */
    public async Restart(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * UserCancel接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFInstanceServiceBase
     */
    public async UserCancel(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFInstanceServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfinstances/select`,tempData,isloading);
    }
}