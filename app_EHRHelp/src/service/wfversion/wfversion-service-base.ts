import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流配置版本***服务对象基类
 *
 * @export
 * @class WFVersionServiceBase
 * @extends {EntityServie}
 */
export default class WFVersionServiceBase extends EntityService {

    /**
     * Creates an instance of  WFVersionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFVersionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFVersionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfversion';
        this.APPDEKEY = 'wfversionid';
        this.APPDENAME = 'wfversions';
        this.APPDETEXT = 'wfversionname';
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
     * @memberof WFVersionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfversions/${context.wfversion}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFVersionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfversions/select`,tempData,isloading);
    }
}