import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织部门人员***服务对象基类
 *
 * @export
 * @class OrgSecUserServiceBase
 * @extends {EntityServie}
 */
export default class OrgSecUserServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgSecUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgSecUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgSecUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orgsecuser';
        this.APPDEKEY = 'orgsecuserid';
        this.APPDENAME = 'orgsecusers';
        this.APPDETEXT = 'orgsecusername';
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
     * @memberof OrgSecUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgsecusers/${context.orgsecuser}/select`,isloading);
    }

    /**
     * RemoveDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSecUserServiceBase
     */
    public async RemoveDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSecUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsecusers/select`,tempData,isloading);
    }
}