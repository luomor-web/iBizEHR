import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户操作***服务对象基类
 *
 * @export
 * @class WFActionServiceBase
 * @extends {EntityServie}
 */
export default class WFActionServiceBase extends EntityService {

    /**
     * Creates an instance of  WFActionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFActionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFActionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfaction';
        this.APPDEKEY = 'wfactionid';
        this.APPDENAME = 'wfactions';
        this.APPDETEXT = 'wfactionname';
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
     * @memberof WFActionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfactions/${context.wfaction}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFActionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfactions/select`,tempData,isloading);
    }
}