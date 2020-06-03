import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 节假日管理服务对象基类
 *
 * @export
 * @class VacHolidayServiceBase
 * @extends {EntityServie}
 */
export default class VacHolidayServiceBase extends EntityService {

    /**
     * Creates an instance of  VacHolidayServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  VacHolidayServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof VacHolidayServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='vacholiday';
        this.APPDEKEY = 'vacholidayid';
        this.APPDENAME = 'vacholidays';
        this.APPDETEXT = 'vacholidayname';
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
     * @memberof VacHolidayServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}/select`,isloading);
        }
            return Http.getInstance().get(`/vacholidays/${context.vacholiday}/select`,isloading);
    }

    /**
     * APPOINTJZBJJR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async APPOINTJZBJJR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}/appointjzbjjr`,data,isloading);
        }
            return Http.getInstance().post(`/vacholidays/${context.vacholiday}/appointjzbjjr`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().put(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/vacholidays/${context.vacholiday}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().delete(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}`,isloading);
        }
            return Http.getInstance().delete(`/vacholidays/${context.vacholiday}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/vacholidays/${context.vacholiday}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacholidays/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/vacholidays/getdraft`,isloading);
        res.data.vacholiday = data.vacholiday;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/vacholidays/${context.vacholiday}`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && context.vacholiday){
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacholidays/${context.vacholiday}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/vacholidays/${context.vacholiday}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/vacholidays`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/vacholidays`,data,isloading);
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacHolidayServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.vacholidayrules && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/vacholidays/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacholidays/fetchdefault`,tempData,isloading);
    }
}