import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 请假提示服务对象基类
 *
 * @export
 * @class VacLeaveTipsServiceBase
 * @extends {EntityServie}
 */
export default class VacLeaveTipsServiceBase extends EntityService {

    /**
     * Creates an instance of  VacLeaveTipsServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveTipsServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof VacLeaveTipsServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='vacleavetips';
        this.APPDEKEY = 'vacleavetipsid';
        this.APPDENAME = 'vacleavetips';
        this.APPDETEXT = 'vacleavetipsname';
        this.APPNAME = 'ehratt';
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
     * @memberof VacLeaveTipsServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}/select`,isloading);
        }
            return Http.getInstance().get(`/vacleavetips/${context.vacleavetips}/select`,isloading);
    }

    /**
     * CheckQJZL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async CheckQJZL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}/checkqjzl`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavetips/${context.vacleavetips}/checkqjzl`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacleavetips`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/vacleavetips`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/vacleavetips/getdraft`,isloading);
        res.data.vacleavetips = data.vacleavetips;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().delete(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}`,isloading);
        }
            return Http.getInstance().delete(`/vacleavetips/${context.vacleavetips}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavetips/${context.vacleavetips}/checkkey`,data,isloading);
    }

    /**
     * CheckRepeat接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async CheckRepeat(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}/checkrepeat`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavetips/${context.vacleavetips}/checkrepeat`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/vacleavetips/${context.vacleavetips}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().put(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/vacleavetips/${context.vacleavetips}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacleavetips){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/${context.vacleavetips}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/vacleavetips/${context.vacleavetips}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveTipsServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacleavetips/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavetips/fetchdefault`,tempData,isloading);
    }
}