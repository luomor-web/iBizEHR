import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetPersonInfoNewLogic from '@/service/pcm-bdsqdmx/set-person-info-new-logic';
import SetPersonInfoNew2Logic from '@/service/pcm-bdsqdmx/set-person-info-new2-logic';
import ZJJScodelist3Logic from '@/service/pcm-bdsqdmx/zjjscodelist3-logic';
import SetPersonInfoLogic from '@/service/pcm-bdsqdmx/set-person-info-logic';
import ZJJScodelist2Logic from '@/service/pcm-bdsqdmx/zjjscodelist2-logic';
import ZJcodelistLogic from '@/service/pcm-bdsqdmx/zjcodelist-logic';
import ZJJScodelistLogic from '@/service/pcm-bdsqdmx/zjjscodelist-logic';



/**
 * 职级变动明细服务对象基类
 *
 * @export
 * @class PcmBdsqdmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmBdsqdmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmBdsqdmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmBdsqdmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmBdsqdmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmbdsqdmx';
        this.APPDEKEY = 'pcmbdsqdmxid';
        this.APPDENAME = 'pcmbdsqdmxes';
        this.APPDETEXT = 'pcmbdsqdmxname';
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
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/select`,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/select`,isloading);
    }

    /**
     * ZJJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async ZJJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJJScodelist2Logic = new ZJJScodelist2Logic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * CQBXCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async CQBXCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/cqbxcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/cqbxcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/cqbxcz`,data,isloading);
    }

    /**
     * SXJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SXJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoNewLogic = new SetPersonInfoNewLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * PDZJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async PDZJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/pdzj`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/pdzj`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/pdzj`,data,isloading);
    }

    /**
     * SXJSDMB2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SXJSDMB2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoNew2Logic = new SetPersonInfoNew2Logic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
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
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes`,data,isloading);
        }
        if(context.pcmbdsqd && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmbdsqdmxes`,data,isloading);
        return res;
    }

    /**
     * ZZSQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async ZZSQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/zzsq`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/zzsq`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/zzsq`,data,isloading);
    }

    /**
     * SXDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SXDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJcodelistLogic = new ZJcodelistLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * DGCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async DGCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/dgcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/dgcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/dgcz`,data,isloading);
    }

    /**
     * SetPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SetPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoLogic = new SetPersonInfoLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async GZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/gzcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/gzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/gzcz`,data,isloading);
    }

    /**
     * JPCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async JPCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/jpcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/jpcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/jpcz`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/save`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/save`,data,isloading);
            return res;
    }

    /**
     * LZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async LZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/lzcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/lzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/lzcz`,data,isloading);
    }

    /**
     * NTCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async NTCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/ntcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/ntcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/ntcz`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().put(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmbdsqdmxes/${context.pcmbdsqdmx}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().delete(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);
        }
            return Http.getInstance().delete(`/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/getdraft`,isloading);
        }
        if(context.pcmbdsqd && true){
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmbdsqdmxes/getdraft`,isloading);
        res.data.pcmbdsqdmx = data.pcmbdsqdmx;
        return res;
    }

    /**
     * SHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/shbtg`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/shbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/shbtg`,data,isloading);
    }

    /**
     * ZJBDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async ZJBDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/zjbdcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/zjbdcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/zjbdcz`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/checkkey`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/checkkey`,data,isloading);
    }

    /**
     * TXCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async TXCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/txcz`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/txcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/txcz`,data,isloading);
    }

    /**
     * JZJJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async JZJJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJJScodelist3Logic = new ZJJScodelist3Logic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/${context.pcmbdsqdmx}/shtg`,data,isloading);
        }
        if(context.pcmbdsqd && context.pcmbdsqdmx){
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/${context.pcmbdsqdmx}/shtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/shtg`,data,isloading);
    }

    /**
     * FetchJPSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchJPSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchjpsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchjpsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchjpsqmx`,tempData,isloading);
    }

    /**
     * FetchNTSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchNTSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchntsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchntsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchntsqmx`,tempData,isloading);
    }

    /**
     * FetchNTSQMXGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchNTSQMXGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchntsqmxgr`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchntsqmxgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchntsqmxgr`,tempData,isloading);
    }

    /**
     * FetchTXSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchTXSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchtxsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchtxsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchtxsqmx`,tempData,isloading);
    }

    /**
     * FetchGZSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchGZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchgzsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchgzsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchgzsqmx`,tempData,isloading);
    }

    /**
     * FetchZJBDSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchZJBDSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchzjbdsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchzjbdsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchzjbdsqmx`,tempData,isloading);
    }

    /**
     * FetchDGSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchDGSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchdgsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchdgsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchdgsqmx`,tempData,isloading);
    }

    /**
     * FetchCQBXSQMXDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchCQBXSQMXDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchcqbxsqmxds`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchcqbxsqmxds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchcqbxsqmxds`,tempData,isloading);
    }

    /**
     * FetchLZSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchLZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchlzsqmx`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchlzsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchlzsqmx`,tempData,isloading);
    }

    /**
     * FetchLZSQMXGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchLZSQMXGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchlzsqmxgr`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchlzsqmxgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchlzsqmxgr`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmBdsqdmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pcmbdsqdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pcmbdsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/pcmbdsqdmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchdefault`,tempData,isloading);
    }
}