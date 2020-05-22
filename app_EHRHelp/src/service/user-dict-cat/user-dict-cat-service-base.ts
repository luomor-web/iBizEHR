import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户词条类别***服务对象基类
 *
 * @export
 * @class UserDictCatServiceBase
 * @extends {EntityServie}
 */
export default class UserDictCatServiceBase extends EntityService {

    /**
     * Creates an instance of  UserDictCatServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictCatServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserDictCatServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userdictcat';
        this.APPDEKEY = 'userdictcatid';
        this.APPDENAME = 'userdictcats';
        this.APPDETEXT = 'userdictcatname';
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
     * @memberof UserDictCatServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userdictcats/${context.userdictcat}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserDictCatServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userdictcats/select`,tempData,isloading);
    }
}