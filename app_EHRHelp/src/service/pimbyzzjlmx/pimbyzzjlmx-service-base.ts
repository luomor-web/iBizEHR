import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import FillPersonInfoLogic from '@/service/pimbyzzjlmx/fill-person-info-logic';
import SetSXRQLogic from '@/service/pimbyzzjlmx/set-sxrq-logic';



/**
 * B/Y类员工转正记录引用明细服务对象基类
 *
 * @export
 * @class PIMBYZZJLMXServiceBase
 * @extends {EntityServie}
 */
export default class PIMBYZZJLMXServiceBase extends EntityService {

    /**
     * Creates an instance of  PIMBYZZJLMXServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMBYZZJLMXServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PIMBYZZJLMXServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimbyzzjlmx';
        this.APPDEKEY = 'pimbyzzjlmxid';
        this.APPDENAME = 'pimbyzzjlmxes';
        this.APPDETEXT = 'pimbyzzjlmxname';
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
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/select`,isloading);
    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/shtg`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
            return res;

    }

    /**
     * ReturnYPZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async ReturnYPZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/returnypz`,data,isloading);
    }

    /**
     * JSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jsptg`,data,isloading);
    }

    /**
     * FillPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FillPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:FillPersonInfoLogic = new FillPersonInfoLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pimbyzzjlmxes/getdraft`,isloading);
        res.data.pimbyzzjlmx = data.pimbyzzjlmx;
        return res;
    }

    /**
     * JSHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JSHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshtg`,data,isloading);
    }

    /**
     * JSHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JSHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshbtg`,data,isloading);
    }

    /**
     * Ensure接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Ensure(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/ensure`,data,isloading);
    }

    /**
     * SHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/shbtg`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);

    }

    /**
     * GSDSZSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async GSDSZSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszsp`,data,isloading);
    }

    /**
     * ZZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async ZZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/zzcz`,data,isloading);
    }

    /**
     * DSB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async DSB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/dsb`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pimbyzzjlmxes`,data,isloading);
        return res;
    }

    /**
     * JZBSHQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JZBSHQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbshqr`,data,isloading);
    }

    /**
     * GSDSZSPBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async GSDSZSPBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszspbtg`,data,isloading);
    }

    /**
     * GSCSBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async GSCSBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscsbtg`,data,isloading);
    }

    /**
     * JSPBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JSPBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jspbtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/save`,data,isloading);
            return res;
    }

    /**
     * GSCS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async GSCS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscs`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/checkkey`,data,isloading);
    }

    /**
     * UpdatePeopleNum接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async UpdatePeopleNum(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/updatepeoplenum`,data,isloading);
    }

    /**
     * JZBSPQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async JZBSPQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbspqr`,data,isloading);
    }

    /**
     * FetchZZWSHDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchZZWSHDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchzzwshds`,tempData,isloading);
    }

    /**
     * FetchUnApproved接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchUnApproved(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchunapproved`,tempData,isloading);
    }

    /**
     * FetchDDJZBSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDDJZBSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchddjzbsh`,tempData,isloading);
    }

    /**
     * FetchBYLZZJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchBYLZZJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchbylzzjl`,tempData,isloading);
    }

    /**
     * FetchDGSDSZSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDGSDSZSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdgsdszsh`,tempData,isloading);
    }

    /**
     * FetchHTRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchHTRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchhtry`,tempData,isloading);
    }

    /**
     * FetchDJZBSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDJZBSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdjzbsp`,tempData,isloading);
    }

    /**
     * FetchDSB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDSB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdsb`,tempData,isloading);
    }

    /**
     * FetchFinishYGBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchFinishYGBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchfinishygbh`,tempData,isloading);
    }

    /**
     * FetchDJZBSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDJZBSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdjzbsh`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMBYZZJLMXServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdefault`,tempData,isloading);
    }
}