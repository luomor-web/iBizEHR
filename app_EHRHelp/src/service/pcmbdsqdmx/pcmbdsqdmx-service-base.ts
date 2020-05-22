import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetSXRQLogic from '@/service/pcmbdsqdmx/set-sxrq-logic';
import SetPersonInfoNewLogic from '@/service/pcmbdsqdmx/set-person-info-new-logic';
import SetPersonInfoNew2Logic from '@/service/pcmbdsqdmx/set-person-info-new2-logic';
import SetSJLogic from '@/service/pcmbdsqdmx/set-sj-logic';
import ZJJScodelist3Logic from '@/service/pcmbdsqdmx/zjjscodelist3-logic';
import SetPersonInfoLogic from '@/service/pcmbdsqdmx/set-person-info-logic';
import ZJJScodelist2Logic from '@/service/pcmbdsqdmx/zjjscodelist2-logic';
import ZJcodelistLogic from '@/service/pcmbdsqdmx/zjcodelist-logic';
import ZJJScodelistLogic from '@/service/pcmbdsqdmx/zjjscodelist-logic';



/**
 * 职级变动明细服务对象基类
 *
 * @export
 * @class PCMBDSQDMXServiceBase
 * @extends {EntityServie}
 */
export default class PCMBDSQDMXServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMBDSQDMXServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMBDSQDMXServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMBDSQDMXServiceBase
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/select`,isloading);
    }

    /**
     * ZJJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async ZJJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJJScodelist2Logic = new ZJJScodelist2Logic();
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async CQBXCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/cqbxcz`,data,isloading);
    }

    /**
     * SXJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SXJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoNewLogic = new SetPersonInfoNewLogic();
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async PDZJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/pdzj`,data,isloading);
    }

    /**
     * SXJSDMB2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SXJSDMB2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoNew2Logic = new SetPersonInfoNew2Logic();
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
     * @memberof PCMBDSQDMXServiceBase
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async ZZSQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/zzsq`,data,isloading);
    }

    /**
     * SXDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SXDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJcodelistLogic = new ZJcodelistLogic();
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async DGCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/dgcz`,data,isloading);
    }

    /**
     * SetPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SetPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetPersonInfoLogic = new SetPersonInfoLogic();
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async GZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/gzcz`,data,isloading);
    }

    /**
     * JPCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async JPCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/jpcz`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async LZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/lzcz`,data,isloading);
    }

    /**
     * NTCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async NTCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/ntcz`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmbdsqdmxes/${context.pcmbdsqdmx}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/shbtg`,data,isloading);
    }

    /**
     * ZJBDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async ZJBDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/zjbdcz`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/checkkey`,data,isloading);
    }

    /**
     * TXCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async TXCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/txcz`,data,isloading);
    }

    /**
     * JZJJSDMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async JZJJSDMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:ZJJScodelist3Logic = new ZJJScodelist3Logic();
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqdmxes/${context.pcmbdsqdmx}/shtg`,data,isloading);
    }

    /**
     * FetchJPSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchJPSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchNTSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchNTSQMXGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchTXSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchGZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchZJBDSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchDGSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchCQBXSQMXDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchLZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchLZSQMXGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
     * @memberof PCMBDSQDMXServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqdmxes/fetchdefault`,tempData,isloading);
    }
}