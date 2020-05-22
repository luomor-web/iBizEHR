import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织机构***服务对象基类
 *
 * @export
 * @class OrgServiceBase
 * @extends {EntityServie}
 */
export default class OrgServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='org';
        this.APPDEKEY = 'orgid';
        this.APPDENAME = 'orgs';
        this.APPDETEXT = 'orgname';
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
     * @memberof OrgServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgs/${context.org}/select`,isloading);
    }

    /**
     * InitAll接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async InitAll(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * InitUserObject接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async InitUserObject(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgs/select`,tempData,isloading);
    }

    /**
     * FetchCurCat接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async FetchCurCat(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgs/select`,tempData,isloading);
    }

    /**
     * FetchAllRoot接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async FetchAllRoot(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgs/select`,tempData,isloading);
    }

    /**
     * FetchCurChild接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgServiceBase
     */
    public async FetchCurChild(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgs/select`,tempData,isloading);
    }
}