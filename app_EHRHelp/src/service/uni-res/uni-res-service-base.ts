import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 统一资源***服务对象基类
 *
 * @export
 * @class UniResServiceBase
 * @extends {EntityServie}
 */
export default class UniResServiceBase extends EntityService {

    /**
     * Creates an instance of  UniResServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UniResServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof UniResServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='unires';
        this.APPDEKEY = 'uniresid';
        this.APPDENAME = 'unires';
        this.APPDETEXT = 'uniresname';
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
     * @memberof UniResServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/unires/${context.unires}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof UniResServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/unires/select`,tempData,isloading);
    }
}