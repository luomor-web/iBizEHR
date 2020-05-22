import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetSXRQLogic from '@/service/pcmddsqdmx/set-sxrq-logic';
import SetSJLogic from '@/service/pcmddsqdmx/set-sj-logic';



/**
 * 调动申请单明细服务对象基类
 *
 * @export
 * @class PCMDDSQDMXServiceBase
 * @extends {EntityServie}
 */
export default class PCMDDSQDMXServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMDDSQDMXServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMDDSQDMXServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMDDSQDMXServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmddsqdmx';
        this.APPDEKEY = 'pcmddsqdmxid';
        this.APPDENAME = 'pcmddsqdmxes';
        this.APPDETEXT = 'pcmddsqdmxname';
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
     * @memberof PCMDDSQDMXServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmddsqdmxes/${context.pcmddsqdmx}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmddsqdmxes/${context.pcmddsqdmx}`,data,isloading);
            return res;
    }

    /**
     * DDUpdate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async DDUpdate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddupdate`,data,isloading);
    }

    /**
     * SQBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async SQBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/sqbtg`,data,isloading);
    }

    /**
     * JDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async JDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/jdcz`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmddsqdmxes/getdraft`,isloading);
        res.data.pcmddsqdmx = data.pcmddsqdmx;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmddsqdmxes`,data,isloading);
        return res;
    }

    /**
     * DDCreate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async DDCreate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddcreate`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);

    }

    /**
     * ZZSQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async ZZSQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/zzsq`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/checkkey`,data,isloading);
    }

    /**
     * DDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async DDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddcz`,data,isloading);
    }

    /**
     * SQTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async SQTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/sqtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/save`,data,isloading);
            return res;
    }

    /**
     * JZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async JZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/jzcz`,data,isloading);
    }

    /**
     * FetchJZSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchJZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjzsqmx`,tempData,isloading);
    }

    /**
     * FetchJDSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchJDSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjdsqgr`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJDSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchJDSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjdsqmx`,tempData,isloading);
    }

    /**
     * FetchDDJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchDDJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddjl`,tempData,isloading);
    }

    /**
     * FetchGBDDJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchGBDDJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchgbddjl`,tempData,isloading);
    }

    /**
     * FetchDDSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchDDSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddsqgr`,tempData,isloading);
    }

    /**
     * FetchDDMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchDDMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddmx`,tempData,isloading);
    }

    /**
     * FetchJZSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMDDSQDMXServiceBase
     */
    public async FetchJZSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjzsqgr`,tempData,isloading);
    }
}