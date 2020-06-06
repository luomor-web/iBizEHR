import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 员工能力服务对象基类
 *
 * @export
 * @class PimPersonAbilityServiceBase
 * @extends {EntityServie}
 */
export default class PimPersonAbilityServiceBase extends EntityService {

    /**
     * Creates an instance of  PimPersonAbilityServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonAbilityServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimPersonAbilityServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimpersonability';
        this.APPDEKEY = 'pimpersonabilityid';
        this.APPDENAME = 'pimpersonabilities';
        this.APPDETEXT = 'pimpersonabilityname';
        this.APPNAME = 'ehrpim';
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
     * @memberof PimPersonAbilityServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}/select`,isloading);
        }
            return Http.getInstance().get(`/pimpersonabilities/${context.pimpersonability}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimpersonabilities/${context.pimpersonability}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}`,isloading);
        }
            return Http.getInstance().delete(`/pimpersonabilities/${context.pimpersonability}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimpersonabilities/${context.pimpersonability}`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimpersonabilities/${context.pimpersonability}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonabilities/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimpersonabilities/getdraft`,isloading);
        res.data.pimpersonability = data.pimpersonability;
        return res;
    }

    /**
     * InitData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async InitData(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}/initdata`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonabilities/${context.pimpersonability}/initdata`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonabilities`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimpersonabilities`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonability){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonabilities/${context.pimpersonability}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonabilities/${context.pimpersonability}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonAbilityServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonabilities/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpersonabilities/fetchdefault`,tempData,isloading);
    }
}