import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门人员关系类型***服务对象基类
 *
 * @export
 * @class OrgSecUserTypeServiceBase
 * @extends {EntityServie}
 */
export default class OrgSecUserTypeServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgSecUserTypeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgSecUserTypeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgSecUserTypeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orgsecusertype';
        this.APPDEKEY = 'orgsecusertypeid';
        this.APPDENAME = 'orgsecusertypes';
        this.APPDETEXT = 'orgsecusertypename';
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
     * @memberof OrgSecUserTypeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgsecusertypes/${context.orgsecusertype}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgSecUserTypeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgsecusertypes/select`,tempData,isloading);
    }
}