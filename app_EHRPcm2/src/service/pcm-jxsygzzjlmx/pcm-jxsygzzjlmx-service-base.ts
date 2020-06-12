import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetRejectLogic from '@/service/pcm-jxsygzzjlmx/set-reject-logic';
import SetPassLogic from '@/service/pcm-jxsygzzjlmx/set-pass-logic';
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
        this.APPNAME = 'ehrpcm2';
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/select`,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/shbtg`,data,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/shtg`,data,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/save`,data,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/zzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/zzcz`,data,isloading);
    }

    /**
     * SetPass接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async SetPass(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPassLogic = new SetPassLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
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
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/getdraft`,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,isloading);
            return res;

    }

    /**
     * SetReject接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxsygzzjlmxServiceBase
     */
    public async SetReject(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetRejectLogic = new SetRejectLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,isloading);
        }
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
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes`,data,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}`,data,isloading);
        }
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
        if(context.pimperson && context.pcmjxsygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/${context.pcmjxsygzzjlmx}/checkkey`,data,isloading);
        }
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
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/fetchdefault`,tempData,isloading);
        }
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
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/fetchwshsq`,tempData,isloading);
        }
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
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/fetchjxszzjl`,tempData,isloading);
        }
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
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmjxsygzzjlmxes/fetchallds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxsygzzjlmxes/fetchallds`,tempData,isloading);
    }
}