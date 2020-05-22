import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流步骤***服务对象基类
 *
 * @export
 * @class WFStepServiceBase
 * @extends {EntityServie}
 */
export default class WFStepServiceBase extends EntityService {

    /**
     * Creates an instance of  WFStepServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFStepServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfstep';
        this.APPDEKEY = 'wfstepid';
        this.APPDENAME = 'wfsteps';
        this.APPDETEXT = 'wfstepname';
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
     * @memberof WFStepServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfsteps/${context.wfstep}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFStepServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfsteps/select`,tempData,isloading);
    }
}