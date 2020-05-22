import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织部门***服务对象基类
 *
 * @export
 * @class OrgSectorServiceBase
 * @extends {EntityServie}
 */
export default class OrgSectorServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgSectorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgSectorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgSectorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orgsector';
        this.APPDEKEY = 'orgsectorid';
        this.APPDENAME = 'orgsectors';
        this.APPDETEXT = 'orgsectorname';
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
     * @memberof OrgSectorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgsectors/${context.orgsector}/select`,isloading);
    }

    /**
     * InitUserObject接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async InitUserObject(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchCurChild接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchCurChild(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchCurOrgOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchCurOrgOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchUserOrgSector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchUserOrgSector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchOrgRoot接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchOrgRoot(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchUserOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchUserOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchCurOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchCurOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSectorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsectors/select`,tempData,isloading);
    }
}