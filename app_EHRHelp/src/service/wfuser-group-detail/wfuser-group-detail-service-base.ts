import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流用户组成员***服务对象基类
 *
 * @export
 * @class WFUserGroupDetailServiceBase
 * @extends {EntityServie}
 */
export default class WFUserGroupDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserGroupDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserGroupDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserGroupDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfusergroupdetail';
        this.APPDEKEY = 'wfusergroupdetailid';
        this.APPDENAME = 'wfusergroupdetails';
        this.APPDETEXT = 'wfusergroupdetailname';
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
     * @memberof WFUserGroupDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfusergroupdetails/${context.wfusergroupdetail}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserGroupDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfusergroupdetails/select`,tempData,isloading);
    }
}