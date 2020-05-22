import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 代码项***服务对象基类
 *
 * @export
 * @class CodeItemServiceBase
 * @extends {EntityServie}
 */
export default class CodeItemServiceBase extends EntityService {

    /**
     * Creates an instance of  CodeItemServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CodeItemServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof CodeItemServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='codeitem';
        this.APPDEKEY = 'codeitemid';
        this.APPDENAME = 'codeitems';
        this.APPDETEXT = 'codeitemname';
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
     * @memberof CodeItemServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/codeitems/${context.codeitem}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof CodeItemServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/codeitems/select`,tempData,isloading);
    }

    /**
     * FetchCurCL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof CodeItemServiceBase
     */
    public async FetchCurCL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/codeitems/select`,tempData,isloading);
    }
}