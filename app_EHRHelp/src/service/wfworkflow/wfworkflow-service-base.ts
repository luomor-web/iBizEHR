import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流配置***服务对象基类
 *
 * @export
 * @class WFWorkflowServiceBase
 * @extends {EntityServie}
 */
export default class WFWorkflowServiceBase extends EntityService {

    /**
     * Creates an instance of  WFWorkflowServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFWorkflowServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFWorkflowServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfworkflow';
        this.APPDEKEY = 'wfworkflowid';
        this.APPDENAME = 'wfworkflows';
        this.APPDETEXT = 'wfworkflowname';
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
     * @memberof WFWorkflowServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfworkflows/${context.wfworkflow}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFWorkflowServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfworkflows/select`,tempData,isloading);
    }
}