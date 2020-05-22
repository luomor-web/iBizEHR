import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户词条***服务对象基类
 *
 * @export
 * @class UserDictItemServiceBase
 * @extends {EntityServie}
 */
export default class UserDictItemServiceBase extends EntityService {

    /**
     * Creates an instance of  UserDictItemServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictItemServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserDictItemServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userdictitem';
        this.APPDEKEY = 'userdictitemid';
        this.APPDENAME = 'userdictitems';
        this.APPDETEXT = 'userdictitemname';
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
     * @memberof UserDictItemServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userdictitems/${context.userdictitem}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserDictItemServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userdictitems/select`,tempData,isloading);
    }
}