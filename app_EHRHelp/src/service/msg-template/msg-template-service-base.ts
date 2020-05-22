import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 消息模板***服务对象基类
 *
 * @export
 * @class MsgTemplateServiceBase
 * @extends {EntityServie}
 */
export default class MsgTemplateServiceBase extends EntityService {

    /**
     * Creates an instance of  MsgTemplateServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgTemplateServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof MsgTemplateServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='msgtemplate';
        this.APPDEKEY = 'msgtemplateid';
        this.APPDENAME = 'msgtemplates';
        this.APPDETEXT = 'msgtemplatename';
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
     * @memberof MsgTemplateServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/msgtemplates/${context.msgtemplate}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MsgTemplateServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/msgtemplates/select`,tempData,isloading);
    }
}