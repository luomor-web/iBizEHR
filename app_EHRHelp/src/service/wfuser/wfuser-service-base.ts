import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户***服务对象基类
 *
 * @export
 * @class WFUserServiceBase
 * @extends {EntityServie}
 */
export default class WFUserServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfuser';
        this.APPDEKEY = 'wfuserid';
        this.APPDENAME = 'wfusers';
        this.APPDETEXT = 'wfusername';
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
     * @memberof WFUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfusers/${context.wfuser}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfusers/select`,tempData,isloading);
    }
}