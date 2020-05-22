import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织人员级别***服务对象基类
 *
 * @export
 * @class OrgUserLevelServiceBase
 * @extends {EntityServie}
 */
export default class OrgUserLevelServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgUserLevelServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgUserLevelServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgUserLevelServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orguserlevel';
        this.APPDEKEY = 'orguserlevelid';
        this.APPDENAME = 'orguserlevels';
        this.APPDETEXT = 'orguserlevelname';
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
     * @memberof OrgUserLevelServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orguserlevels/${context.orguserlevel}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgUserLevelServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orguserlevels/select`,tempData,isloading);
    }
}