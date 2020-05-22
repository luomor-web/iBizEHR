import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流步骤子实例***服务对象基类
 *
 * @export
 * @class WFStepInstServiceBase
 * @extends {EntityServie}
 */
export default class WFStepInstServiceBase extends EntityService {

    /**
     * Creates an instance of  WFStepInstServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepInstServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFStepInstServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfstepinst';
        this.APPDEKEY = 'wfstepinstid';
        this.APPDENAME = 'wfstepinsts';
        this.APPDETEXT = 'wfstepinstname';
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
     * @memberof WFStepInstServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfstepinsts/${context.wfstepinst}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFStepInstServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfstepinsts/select`,tempData,isloading);
    }
}