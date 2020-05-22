import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流动态用户***服务对象基类
 *
 * @export
 * @class WFDynamicUserServiceBase
 * @extends {EntityServie}
 */
export default class WFDynamicUserServiceBase extends EntityService {

    /**
     * Creates an instance of  WFDynamicUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFDynamicUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFDynamicUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfdynamicuser';
        this.APPDEKEY = 'wfdynamicuserid';
        this.APPDENAME = 'wfdynamicusers';
        this.APPDETEXT = 'wfdynamicusername';
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
     * @memberof WFDynamicUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfdynamicusers/${context.wfdynamicuser}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFDynamicUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfdynamicusers/select`,tempData,isloading);
    }
}