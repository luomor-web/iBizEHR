import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤记录服务对象基类
 *
 * @export
 * @class AttEndanceRecordServiceBase
 * @extends {EntityServie}
 */
export default class AttEndanceRecordServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndanceRecordServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceRecordServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndanceRecordServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendancerecord';
        this.APPDEKEY = 'attendancerecordid';
        this.APPDENAME = 'attendancerecords';
        this.APPDETEXT = 'attendancerecordname';
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
     * @memberof AttEndanceRecordServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}/select`,isloading);
        }
            return Http.getInstance().get(`/attendancerecords/${context.attendancerecord}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancerecords/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/attendancerecords/getdraft`,isloading);
        res.data.attendancerecord = data.attendancerecord;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancerecords`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/attendancerecords`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendancerecords/${context.attendancerecord}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}`,isloading);
        }
            return Http.getInstance().delete(`/attendancerecords/${context.attendancerecord}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendancerecords/${context.attendancerecord}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/attendancerecords/${context.attendancerecord}`,isloading);
            return res;

    }

    /**
     * ReflushPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async ReflushPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}/reflushpersoninfo`,data,isloading);
        }
            return Http.getInstance().post(`/attendancerecords/${context.attendancerecord}/reflushpersoninfo`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.attendancerecord){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/attendancerecords/${context.attendancerecord}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/attendancerecords/${context.attendancerecord}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceRecordServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/attendancerecords/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancerecords/fetchdefault`,tempData,isloading);
    }
}