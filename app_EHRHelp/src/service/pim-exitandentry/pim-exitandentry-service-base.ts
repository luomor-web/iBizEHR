import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 出入境管理服务对象基类
 *
 * @export
 * @class PimExitandentryServiceBase
 * @extends {EntityServie}
 */
export default class PimExitandentryServiceBase extends EntityService {

    /**
     * Creates an instance of  PimExitandentryServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimExitandentryServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimExitandentryServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimexitandentry';
        this.APPDEKEY = 'pimexitandentryid';
        this.APPDENAME = 'pimexitandentries';
        this.APPDETEXT = 'pimexitandentryname';
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
     * @memberof PimExitandentryServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/select`,isloading);
        }
            return Http.getInstance().get(`/pimexitandentries/${context.pimexitandentry}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimexitandentries/${context.pimexitandentry}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/save`,data,isloading);
            return res;
    }

    /**
     * CX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async CX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/cx`,data,isloading);
        }
            return Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/cx`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimexitandentries/${context.pimexitandentry}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimexitandentries/getdraft`,isloading);
        res.data.pimexitandentry = data.pimexitandentry;
        return res;
    }

    /**
     * MobStart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async MobStart(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/mobstart`,data,isloading);
        }
            return Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/mobstart`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimexitandentries`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}`,isloading);
        }
            return Http.getInstance().delete(`/pimexitandentries/${context.pimexitandentry}`,isloading);

    }

    /**
     * CB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async CB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/cb`,data,isloading);
        }
            return Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/cb`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/checkkey`,data,isloading);
    }

    /**
     * Start接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async Start(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimexitandentry){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimexitandentries/${context.pimexitandentry}/start`,data,isloading);
        }
            return Http.getInstance().post(`/pimexitandentries/${context.pimexitandentry}/start`,data,isloading);
    }

    /**
     * FetchYGCGJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchYGCGJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchygcgj`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchygcgj`,tempData,isloading);
    }

    /**
     * FetchYGZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchYGZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchygzz`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchygzz`,tempData,isloading);
    }

    /**
     * FetchMOBJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchMOBJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchmobjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchmobjlss`,tempData,isloading);
    }

    /**
     * FetchYSCGJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchYSCGJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchyscgj`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchyscgj`,tempData,isloading);
    }

    /**
     * FetchFormType接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchFormType(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchformtype`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchformtype`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimExitandentryServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimexitandentries/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimexitandentries/fetchdefault`,tempData,isloading);
    }
}