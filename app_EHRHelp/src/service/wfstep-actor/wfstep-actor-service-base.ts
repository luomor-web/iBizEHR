import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流步骤操作者***服务对象基类
 *
 * @export
 * @class WFStepActorServiceBase
 * @extends {EntityServie}
 */
export default class WFStepActorServiceBase extends EntityService {

    /**
     * Creates an instance of  WFStepActorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepActorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFStepActorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfstepactor';
        this.APPDEKEY = 'wfstepactorid';
        this.APPDENAME = 'wfstepactors';
        this.APPDETEXT = 'wfstepactorname';
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
     * @memberof WFStepActorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfstepactors/${context.wfstepactor}/select`,isloading);
    }

    /**
     * RemindSave接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFStepActorServiceBase
     */
    public async RemindSave(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFStepActorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfstepactors/select`,tempData,isloading);
    }
}