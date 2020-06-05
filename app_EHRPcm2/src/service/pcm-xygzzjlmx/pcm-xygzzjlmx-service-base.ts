import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetRejectLogic from '@/service/pcm-xygzzjlmx/set-reject-logic';
import SetPersonInfoLogic from '@/service/pcm-xygzzjlmx/set-person-info-logic';
import SetPassLogic from '@/service/pcm-xygzzjlmx/set-pass-logic';



/**
 * 试用期员工转正记录引用明细服务对象基类
 *
 * @export
 * @class PcmXygzzjlmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmXygzzjlmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmXygzzjlmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmXygzzjlmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmXygzzjlmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmxygzzjlmx';
        this.APPDEKEY = 'pcmxygzzjlmxid';
        this.APPDENAME = 'pcmxygzzjlmxes';
        this.APPDETEXT = 'pcmxygzzjlmxname';
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
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/select`,isloading);
    }

    /**
     * XYGZZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async XYGZZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/xygzzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/xygzzcz`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,isloading);
            return res;

    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/shtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/shtg`,data,isloading);
    }

    /**
     * FillPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async FillPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoLogic = new SetPersonInfoLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SetPass接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async SetPass(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPassLogic = new SetPassLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmxygzzjlmxes`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,isloading);
        }
            return Http.getInstance().delete(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmxygzzjlmxes/getdraft`,isloading);
        res.data.pcmxygzzjlmx = data.pcmxygzzjlmx;
        return res;
    }

    /**
     * SetRejcet接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async SetRejcet(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetRejectLogic = new SetRejectLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/shbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/shbtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmxygzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmxygzzjlmxes/${context.pcmxygzzjlmx}/save`,data,isloading);
            return res;
    }

    /**
     * FetchZZWSHDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async FetchZZWSHDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/fetchzzwshds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxygzzjlmxes/fetchzzwshds`,tempData,isloading);
    }

    /**
     * FetchALLDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async FetchALLDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/fetchallds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxygzzjlmxes/fetchallds`,tempData,isloading);
    }

    /**
     * FetchSYQZZJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async FetchSYQZZJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/fetchsyqzzjl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxygzzjlmxes/fetchsyqzzjl`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXygzzjlmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmxygzzjlmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxygzzjlmxes/fetchdefault`,tempData,isloading);
    }
}