import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流系统设定***服务对象基类
 *
 * @export
 * @class WFAppSettingServiceBase
 * @extends {EntityServie}
 */
export default class WFAppSettingServiceBase extends EntityService {

    /**
     * Creates an instance of  WFAppSettingServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFAppSettingServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFAppSettingServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfappsetting';
        this.APPDEKEY = 'wfappsettingid';
        this.APPDENAME = 'wfappsettings';
        this.APPDETEXT = 'wfappsettingname';
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
     * @memberof WFAppSettingServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfappsettings/${context.wfappsetting}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFAppSettingServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfappsettings/select`,tempData,isloading);
    }
}