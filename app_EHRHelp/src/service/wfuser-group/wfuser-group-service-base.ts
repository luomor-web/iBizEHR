import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户组***服务对象基类
 *
 * @export
 * @class WFUserGroupServiceBase
 * @extends {EntityServie}
 */
export default class WFUserGroupServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserGroupServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserGroupServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserGroupServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfusergroup';
        this.APPDEKEY = 'wfusergroupid';
        this.APPDENAME = 'wfusergroups';
        this.APPDETEXT = 'wfusergroupname';
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
     * @memberof WFUserGroupServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfusergroups/${context.wfusergroup}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserGroupServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfusergroups/select`,tempData,isloading);
    }
}