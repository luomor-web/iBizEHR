import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流工作列表***服务对象基类
 *
 * @export
 * @class WFWorkListServiceBase
 * @extends {EntityServie}
 */
export default class WFWorkListServiceBase extends EntityService {

    /**
     * Creates an instance of  WFWorkListServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFWorkListServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFWorkListServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfworklist';
        this.APPDEKEY = 'wfworklistid';
        this.APPDENAME = 'wfworklists';
        this.APPDETEXT = 'wfworklistname';
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
     * @memberof WFWorkListServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfworklists/${context.wfworklist}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFWorkListServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfworklists/select`,tempData,isloading);
    }
}