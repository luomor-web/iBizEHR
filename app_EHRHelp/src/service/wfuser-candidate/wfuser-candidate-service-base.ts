import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户候选者***服务对象基类
 *
 * @export
 * @class WFUserCandidateServiceBase
 * @extends {EntityServie}
 */
export default class WFUserCandidateServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserCandidateServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserCandidateServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserCandidateServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfusercandidate';
        this.APPDEKEY = 'wfusercandidateid';
        this.APPDENAME = 'wfusercandidates';
        this.APPDETEXT = 'wfusercandidatename';
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
     * @memberof WFUserCandidateServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfusercandidates/${context.wfusercandidate}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserCandidateServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfusercandidates/select`,tempData,isloading);
    }
}