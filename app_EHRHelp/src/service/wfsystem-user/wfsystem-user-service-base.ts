import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流系统用户***服务对象基类
 *
 * @export
 * @class WFSystemUserServiceBase
 * @extends {EntityServie}
 */
export default class WFSystemUserServiceBase extends EntityService {

    /**
     * Creates an instance of  WFSystemUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFSystemUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFSystemUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfsystemuser';
        this.APPDEKEY = 'wfsystemuserid';
        this.APPDENAME = 'wfsystemusers';
        this.APPDETEXT = 'wfsystemusername';
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
     * @memberof WFSystemUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfsystemusers/${context.wfsystemuser}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFSystemUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfsystemusers/select`,tempData,isloading);
    }
}