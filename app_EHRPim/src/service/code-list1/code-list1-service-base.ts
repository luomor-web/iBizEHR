import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 代码表***服务对象基类
 *
 * @export
 * @class CodeList1ServiceBase
 * @extends {EntityServie}
 */
export default class CodeList1ServiceBase extends EntityService {

    /**
     * Creates an instance of  CodeList1ServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CodeList1ServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof CodeList1ServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='codelist1';
        this.APPDEKEY = 'codelistid';
        this.APPDENAME = 'codelist1s';
        this.APPDETEXT = 'codelistname';
        this.APPNAME = 'ehrpim';
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
     * @memberof CodeList1ServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/codelist1s/${context.codelist1}/select`,isloading);
    }

    /**
     * RefreshModel接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof CodeList1ServiceBase
     */
    public async RefreshModel(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * FetchPersonUse接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof CodeList1ServiceBase
     */
    public async FetchPersonUse(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/codelist1s/select`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof CodeList1ServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/codelist1s/select`,tempData,isloading);
    }
}