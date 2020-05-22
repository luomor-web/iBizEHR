import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作流预定义处理***服务对象基类
 *
 * @export
 * @class WFCustomProcessServiceBase
 * @extends {EntityServie}
 */
export default class WFCustomProcessServiceBase extends EntityService {

    /**
     * Creates an instance of  WFCustomProcessServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFCustomProcessServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFCustomProcessServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfcustomprocess';
        this.APPDEKEY = 'wfcustomprocessid';
        this.APPDENAME = 'wfcustomprocesses';
        this.APPDETEXT = 'wfcustomprocessname';
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
     * @memberof WFCustomProcessServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfcustomprocesses/${context.wfcustomprocess}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFCustomProcessServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfcustomprocesses/select`,tempData,isloading);
    }
}