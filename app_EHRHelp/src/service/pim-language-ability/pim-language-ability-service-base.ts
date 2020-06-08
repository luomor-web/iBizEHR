import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 语言能力服务对象基类
 *
 * @export
 * @class PimLanguageAbilityServiceBase
 * @extends {EntityServie}
 */
export default class PimLanguageAbilityServiceBase extends EntityService {

    /**
     * Creates an instance of  PimLanguageAbilityServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimLanguageAbilityServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimLanguageAbilityServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimlanguageability';
        this.APPDEKEY = 'pimlanguageabilityid';
        this.APPDENAME = 'pimlanguageabilities';
        this.APPDETEXT = 'pimlanguageabilityname';
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
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}/select`,isloading);
        }
            return Http.getInstance().get(`/pimlanguageabilities/${context.pimlanguageability}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimlanguageabilities/getdraft`,isloading);
        res.data.pimlanguageability = data.pimlanguageability;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimlanguageabilities/${context.pimlanguageability}`,isloading);
            return res;

    }

    /**
     * CustRemove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async CustRemove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}/custremove`,isloading);
        }
            return Http.getInstance().delete(`/pimlanguageabilities/${context.pimlanguageability}/custremove`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimlanguageabilities/${context.pimlanguageability}/save`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimlanguageabilities/${context.pimlanguageability}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}`,isloading);
        }
            return Http.getInstance().delete(`/pimlanguageabilities/${context.pimlanguageability}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimlanguageability){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimlanguageabilities/${context.pimlanguageability}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimlanguageabilities/${context.pimlanguageability}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimlanguageabilities`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimlanguageabilities`,data,isloading);
        return res;
    }

    /**
     * FetchJLSSGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async FetchJLSSGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/fetchjlssgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimlanguageabilities/fetchjlssgr`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimlanguageabilities/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimlanguageabilities/fetchjlss`,tempData,isloading);
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimlanguageabilities/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchJLSSGLY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimLanguageAbilityServiceBase
     */
    public async FetchJLSSGLY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimlanguageabilities/fetchjlssgly`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimlanguageabilities/fetchjlssgly`,tempData,isloading);
    }
}