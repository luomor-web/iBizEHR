import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤人员服务对象基类
 *
 * @export
 * @class AttEndanceSettingsServiceBase
 * @extends {EntityServie}
 */
export default class AttEndanceSettingsServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndanceSettingsServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceSettingsServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndanceSettingsServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendancesettings';
        this.APPDEKEY = 'attendancesettingsid';
        this.APPDENAME = 'attendancesettings';
        this.APPDETEXT = 'attendancesettingsname';
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
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}/select`,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}/select`,isloading);
        }
            return Http.getInstance().get(`/attendancesettings/${context.attendancesettings}/select`,isloading);
    }

    /**
     * AddToKqz接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async AddToKqz(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}/addtokqz`,data,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}/addtokqz`,data,isloading);
        }
            return Http.getInstance().post(`/attendancesettings/${context.attendancesettings}/addtokqz`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().put(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}`,data,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendancesettings/${context.attendancesettings}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendancesettings`,data,isloading);
        }
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancesettings`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/attendancesettings`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}/save`,data,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendancesettings/${context.attendancesettings}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}`,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/attendancesettings/${context.attendancesettings}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().delete(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}`,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}`,isloading);
        }
            return Http.getInstance().delete(`/attendancesettings/${context.attendancesettings}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendancesettings){
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendancesettings/${context.attendancesettings}/checkkey`,data,isloading);
        }
        if(context.pimperson && context.attendancesettings){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancesettings/${context.attendancesettings}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/attendancesettings/${context.attendancesettings}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/getdraft`,isloading);
        }
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/attendancesettings/getdraft`,isloading);
        res.data.attendancesettings = data.attendancesettings;
        return res;
    }

    /**
     * FetchYGSZKQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async FetchYGSZKQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/fetchygszkq`,tempData,isloading);
        }
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/fetchygszkq`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancesettings/fetchygszkq`,tempData,isloading);
    }

    /**
     * FetchFYGZZKQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async FetchFYGZZKQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/fetchfygzzkq`,tempData,isloading);
        }
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/fetchfygzzkq`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancesettings/fetchfygzzkq`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceSettingsServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendancesettings/fetchdefault`,tempData,isloading);
        }
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancesettings/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancesettings/fetchdefault`,tempData,isloading);
    }
}