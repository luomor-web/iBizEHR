import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤月报明细服务对象基类
 *
 * @export
 * @class AttEndanceMreportmxServiceBase
 * @extends {EntityServie}
 */
export default class AttEndanceMreportmxServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndanceMreportmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceMreportmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndanceMreportmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendancemreportmx';
        this.APPDEKEY = 'attendancemreportmxid';
        this.APPDENAME = 'attendancemreportmxes';
        this.APPDETEXT = 'attendancemreportname';
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
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}/select`,isloading);
        }
            return Http.getInstance().get(`/attendancemreportmxes/${context.attendancemreportmx}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/attendancemreportmxes/getdraft`,isloading);
        res.data.attendancemreportmx = data.attendancemreportmx;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendancemreportmxes/${context.attendancemreportmx}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}`,isloading);
        }
            return Http.getInstance().delete(`/attendancemreportmxes/${context.attendancemreportmx}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/attendancemreportmxes/${context.attendancemreportmx}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/attendancemreportmxes/${context.attendancemreportmx}`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendancemreportmxes/${context.attendancemreportmx}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancemreportmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/attendancemreportmxes`,data,isloading);
        return res;
    }

    /**
     * Export2Excel接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async Export2Excel(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancemreportmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancemreportmxes/${context.attendancemreportmx}/export2excel`,data,isloading);
        }
            return Http.getInstance().post(`/attendancemreportmxes/${context.attendancemreportmx}/export2excel`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreportmxes/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchKQYBMXDY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async FetchKQYBMXDY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/fetchkqybmxdy`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreportmxes/fetchkqybmxdy`,tempData,isloading);
    }

    /**
     * FetchCurPerson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportmxServiceBase
     */
    public async FetchCurPerson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancemreportmxes/fetchcurperson`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreportmxes/fetchcurperson`,tempData,isloading);
    }
}