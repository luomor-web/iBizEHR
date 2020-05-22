import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import UpdateRelatedInfoLogic from '@/service/org-user/update-related-info-logic';
import UpdateCurUserLogic from '@/service/org-user/update-cur-user-logic';
import GetCurUserLogic from '@/service/org-user/get-cur-user-logic';
import CreateRelatedInfoLogic from '@/service/org-user/create-related-info-logic';



/**
 * 组织人员***服务对象基类
 *
 * @export
 * @class OrgUserServiceBase
 * @extends {EntityServie}
 */
export default class OrgUserServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orguser';
        this.APPDEKEY = 'orguserid';
        this.APPDENAME = 'orgusers';
        this.APPDETEXT = 'orgusername';
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
     * @memberof OrgUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgusers/${context.orguser}/select`,isloading);
    }

    /**
     * UpdateCurUser接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async UpdateCurUser(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:UpdateCurUserLogic = new UpdateCurUserLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GetCurUser接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async GetCurUser(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:GetCurUserLogic = new GetCurUserLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * FetchCurOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchCurOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }

    /**
     * FetchCurOrgSector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchCurOrgSector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }

    /**
     * FetchUserOrgSector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchUserOrgSector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }

    /**
     * FetchUserOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchUserOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }

    /**
     * FetchDQZZJXJZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserServiceBase
     */
    public async FetchDQZZJXJZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgusers/select`,tempData,isloading);
    }
}