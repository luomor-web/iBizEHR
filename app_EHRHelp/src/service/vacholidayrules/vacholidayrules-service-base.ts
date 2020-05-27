import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤规则服务对象基类
 *
 * @export
 * @class VACHOLIDAYRULESServiceBase
 * @extends {EntityServie}
 */
export default class VACHOLIDAYRULESServiceBase extends EntityService {

    /**
     * Creates an instance of  VACHOLIDAYRULESServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  VACHOLIDAYRULESServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='vacholidayrules';
        this.APPDEKEY = 'vacholidayrulesid';
        this.APPDENAME = 'vacholidayrules';
        this.APPDETEXT = 'vacholidayrulesname';
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
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}/select`,isloading);
    }

    /**
     * CopyKQGZData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async CopyKQGZData(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/copykqgzdata`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/vacholidayrules/${context.vacholidayrules}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let vacholidaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays'),'undefined')){
            vacholidaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays') as any);
            if(vacholidaysData && vacholidaysData.length && vacholidaysData.length > 0){
                vacholidaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.vacholidayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.vacholidays = vacholidaysData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/vacholidayrules`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_vacholidays',JSON.stringify(res.data.vacholidays));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/vacholidayrules/getdraft`,isloading);
        res.data.vacholidayrules = data.vacholidayrules;
            this.tempStorage.setItem(context.srfsessionkey+'_vacholidays',JSON.stringify(res.data.vacholidays));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let vacholidaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays'),'undefined')){
            vacholidaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays') as any);
            if(vacholidaysData && vacholidaysData.length && vacholidaysData.length > 0){
                vacholidaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.vacholidayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.vacholidays = vacholidaysData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/vacholidayrules/${context.vacholidayrules}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_vacholidays',JSON.stringify(res.data.vacholidays));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/vacholidayrules/${context.vacholidayrules}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_vacholidays',JSON.stringify(res.data.vacholidays));
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let vacholidaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays'),'undefined')){
            vacholidaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_vacholidays') as any);
            if(vacholidaysData && vacholidaysData.length && vacholidaysData.length > 0){
                vacholidaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.vacholidayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.vacholidays = vacholidaysData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/vacholidayrules/${context.vacholidayrules}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_vacholidays',JSON.stringify(res.data.vacholidays));
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacholidayrules/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurOrmorg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VACHOLIDAYRULESServiceBase
     */
    public async FetchCurOrmorg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacholidayrules/fetchcurormorg`,tempData,isloading);
    }
}