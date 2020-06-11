import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 积分规则服务对象基类
 *
 * @export
 * @class ParIntegralRuleServiceBase
 * @extends {EntityServie}
 */
export default class ParIntegralRuleServiceBase extends EntityService {

    /**
     * Creates an instance of  ParIntegralRuleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParIntegralRuleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParIntegralRuleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parintegralrule';
        this.APPDEKEY = 'parintegralruleid';
        this.APPDENAME = 'parintegralrules';
        this.APPDETEXT = 'parintegralrulename';
        this.APPNAME = 'ehrpar';
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
     * @memberof ParIntegralRuleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parintegralrules/${context.parintegralrule}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParIntegralRuleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parintegralrules/select`,tempData,isloading);
    }
}