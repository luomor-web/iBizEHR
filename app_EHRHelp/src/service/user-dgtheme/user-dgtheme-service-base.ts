import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户表格自定义***服务对象基类
 *
 * @export
 * @class UserDGThemeServiceBase
 * @extends {EntityServie}
 */
export default class UserDGThemeServiceBase extends EntityService {

    /**
     * Creates an instance of  UserDGThemeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDGThemeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UserDGThemeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='userdgtheme';
        this.APPDEKEY = 'userdgthemeid';
        this.APPDENAME = 'userdgthemes';
        this.APPDETEXT = 'userdgthemename';
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
     * @memberof UserDGThemeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/userdgthemes/${context.userdgtheme}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UserDGThemeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/userdgthemes/select`,tempData,isloading);
    }
}