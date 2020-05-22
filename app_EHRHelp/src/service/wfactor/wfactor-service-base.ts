import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流操作者***服务对象基类
 *
 * @export
 * @class WFActorServiceBase
 * @extends {EntityServie}
 */
export default class WFActorServiceBase extends EntityService {

    /**
     * Creates an instance of  WFActorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFActorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFActorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfactor';
        this.APPDEKEY = 'wfactorid';
        this.APPDENAME = 'wfactors';
        this.APPDETEXT = 'wfactorname';
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
     * @memberof WFActorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfactors/${context.wfactor}/select`,isloading);
    }

    /**
     * FetchIndexDER接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFActorServiceBase
     */
    public async FetchIndexDER(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfactors/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFActorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfactors/select`,tempData,isloading);
    }
}