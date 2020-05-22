import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流步骤操作者（临时）***服务对象基类
 *
 * @export
 * @class WFTmpStepActorServiceBase
 * @extends {EntityServie}
 */
export default class WFTmpStepActorServiceBase extends EntityService {

    /**
     * Creates an instance of  WFTmpStepActorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFTmpStepActorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFTmpStepActorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wftmpstepactor';
        this.APPDEKEY = 'wftmpstepactorid';
        this.APPDENAME = 'wftmpstepactors';
        this.APPDETEXT = 'wftmpstepactorname';
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
     * @memberof WFTmpStepActorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wftmpstepactors/${context.wftmpstepactor}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFTmpStepActorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wftmpstepactors/select`,tempData,isloading);
    }
}