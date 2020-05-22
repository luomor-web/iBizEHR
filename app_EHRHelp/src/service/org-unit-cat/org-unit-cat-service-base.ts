import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织单元类别***服务对象基类
 *
 * @export
 * @class OrgUnitCatServiceBase
 * @extends {EntityServie}
 */
export default class OrgUnitCatServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgUnitCatServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgUnitCatServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgUnitCatServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orgunitcat';
        this.APPDEKEY = 'orgunitcatid';
        this.APPDENAME = 'orgunitcats';
        this.APPDETEXT = 'orgunitcatname';
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
     * @memberof OrgUnitCatServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgunitcats/${context.orgunitcat}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUnitCatServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgunitcats/select`,tempData,isloading);
    }
}