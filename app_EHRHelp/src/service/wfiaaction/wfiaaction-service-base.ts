import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流交互操作***服务对象基类
 *
 * @export
 * @class WFIAActionServiceBase
 * @extends {EntityServie}
 */
export default class WFIAActionServiceBase extends EntityService {

    /**
     * Creates an instance of  WFIAActionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFIAActionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFIAActionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfiaaction';
        this.APPDEKEY = 'wfiaactionid';
        this.APPDENAME = 'wfiaactions';
        this.APPDETEXT = 'wfiaactionname';
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
     * @memberof WFIAActionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfiaactions/${context.wfiaaction}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFIAActionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfiaactions/select`,tempData,isloading);
    }
}