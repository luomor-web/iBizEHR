import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 休假信息服务对象基类
 *
 * @export
 * @class PimVacationServiceBase
 * @extends {EntityServie}
 */
export default class PimVacationServiceBase extends EntityService {

    /**
     * Creates an instance of  PimVacationServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimVacationServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimVacationServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimvacation';
        this.APPDEKEY = 'pimvacationid';
        this.APPDENAME = 'pimvacations';
        this.APPDETEXT = 'pimvacationname';
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
     * @memberof PimVacationServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}/select`,isloading);
        }
            return Http.getInstance().get(`/pimvacations/${context.pimvacation}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimvacations/${context.pimvacation}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}`,isloading);
        }
            return Http.getInstance().delete(`/pimvacations/${context.pimvacation}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimvacations/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimvacations/getdraft`,isloading);
        res.data.pimvacation = data.pimvacation;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimvacations/${context.pimvacation}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimvacations`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimvacations`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimvacations/${context.pimvacation}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimvacation){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimvacations/${context.pimvacation}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimvacations/${context.pimvacation}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimVacationServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimvacations/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimvacations/fetchdefault`,tempData,isloading);
    }
}