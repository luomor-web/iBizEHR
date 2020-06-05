import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import FillPersonInfoLogic from '@/service/pcm-jxsygzzjlmx/fill-person-info-logic';



/**
 * 见习生员工转正记录引用明细服务对象基类
 *
 * @export
 * @class PcmJxsygzzjlmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmJxsygzzjlmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmJxsygzzjlmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmJxsygzzjlmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmjxsygzzjlmx';
        this.APPDEKEY = 'pcmjxsygzzjlmxid';
        this.APPDENAME = 'pcmjxsygzzjlmxes';
        this.APPDETEXT = 'pcmjxsygzzjlmxname';
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
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/select`,isloading);
    }

    /**
     * SHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/shbtg`,data,isloading);
    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/shtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/save`,data,isloading);
            return res;
    }

    /**
     * FillPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async FillPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:FillPersonInfoLogic = new FillPersonInfoLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * ZZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async ZZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/zzcz`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmjxsygzzjlmxes/getdraft`,isloading);
        res.data.pcmjxsygzzjlmx = data.pcmjxsygzzjlmx;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmjxsygzzjlmxes`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxsygzzjlmxes/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchWSHSQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async FetchWSHSQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxsygzzjlmxes/fetchwshsq`,tempData,isloading);
    }

    /**
     * FetchJXSZZJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async FetchJXSZZJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxsygzzjlmxes/fetchjxszzjl`,tempData,isloading);
    }

    /**
     * FetchALLDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async FetchALLDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxsygzzjlmxes/fetchallds`,tempData,isloading);
    }
}