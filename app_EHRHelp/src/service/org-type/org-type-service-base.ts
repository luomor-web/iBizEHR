import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织类型***服务对象基类
 *
 * @export
 * @class OrgTypeServiceBase
 * @extends {EntityServie}
 */
export default class OrgTypeServiceBase extends EntityService {

    /**
     * Creates an instance of  OrgTypeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgTypeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrgTypeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='orgtype';
        this.APPDEKEY = 'orgtypeid';
        this.APPDENAME = 'orgtypes';
        this.APPDETEXT = 'orgtypename';
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
     * @memberof OrgTypeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/orgtypes/${context.orgtype}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrgTypeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/orgtypes/select`,tempData,isloading);
    }
}