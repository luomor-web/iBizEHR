import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 项目人员需求服务对象基类
 *
 * @export
 * @class OrmXmrypzxqServiceBase
 * @extends {EntityServie}
 */
export default class OrmXmrypzxqServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmXmrypzxqServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmXmrypzxqServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmXmrypzxqServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormxmrypzxq';
        this.APPDEKEY = 'ormxmrypzxqid';
        this.APPDENAME = 'ormxmrypzxqs';
        this.APPDETEXT = 'ormxmrypzxqname';
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
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormxmrypzxqs/${context.ormxmrypzxq}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormxmrypzxqs/getdraft`,isloading);
        res.data.ormxmrypzxq = data.ormxmrypzxq;
        return res;
    }

    /**
     * SynTJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SynTJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/syntj`,data,isloading);
    }

    /**
     * MODSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async MODSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/modsptg`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/checkkey`,data,isloading);
    }

    /**
     * SFBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SFBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/sfbh`,data,isloading);
    }

    /**
     * Ensure接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Ensure(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/ensure`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormxmrypzxqs/${context.ormxmrypzxq}`,isloading);
            return res;

    }

    /**
     * SynDeployInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SynDeployInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/syndeployinfo`,data,isloading);
    }

    /**
     * MODBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async MODBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/modbh`,data,isloading);
    }

    /**
     * SFQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SFQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/sfqr`,data,isloading);
    }

    /**
     * SynPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SynPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/synpersoninfo`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormxmrypzxqs/${context.ormxmrypzxq}`,isloading);

    }

    /**
     * SynRelease接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SynRelease(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/synrelease`,data,isloading);
    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/shtg`,data,isloading);
    }

    /**
     * TPSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async TPSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/tpsptg`,data,isloading);
    }

    /**
     * BH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async BH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/bh`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/save`,data,isloading);
            return res;
    }

    /**
     * SFSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async SFSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/sfsptg`,data,isloading);
    }

    /**
     * TPBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async TPBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/tpbh`,data,isloading);
    }

    /**
     * TPQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async TPQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormxmrypzxqs/${context.ormxmrypzxq}/tpqr`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
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
        let res:any = await Http.getInstance().post(`/ormxmrypzxqs`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormxmrypzxqs/${context.ormxmrypzxq}`,data,isloading);
            return res;
    }

    /**
     * FetchRSSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchRSSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchrssh`,tempData,isloading);
    }

    /**
     * FetchCURFQTP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchCURFQTP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchcurfqtp`,tempData,isloading);
    }

    /**
     * FetchCXSJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchCXSJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchcxsj`,tempData,isloading);
    }

    /**
     * FetchKZXMQX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchKZXMQX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchkzxmqx`,tempData,isloading);
    }

    /**
     * FetchSFSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchSFSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchsfsh`,tempData,isloading);
    }

    /**
     * FetchCURFQSF接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchCURFQSF(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchcurfqsf`,tempData,isloading);
    }

    /**
     * FetchTPSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchTPSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchtpsh`,tempData,isloading);
    }

    /**
     * FetchSFCXSJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchSFCXSJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchsfcxsj`,tempData,isloading);
    }

    /**
     * FetchMODSPSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchMODSPSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchmodspsh`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchXMCBMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmrypzxqServiceBase
     */
    public async FetchXMCBMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmrypzxqs/fetchxmcbmx`,tempData,isloading);
    }
}