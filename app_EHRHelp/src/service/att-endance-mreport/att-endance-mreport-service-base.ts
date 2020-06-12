import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤月报服务对象基类
 *
 * @export
 * @class AttEndanceMreportServiceBase
 * @extends {EntityServie}
 */
export default class AttEndanceMreportServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndanceMreportServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceMreportServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndanceMreportServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendancemreport';
        this.APPDEKEY = 'attendancemreportid';
        this.APPDENAME = 'attendancemreports';
        this.APPDETEXT = 'attendancemreportname';
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
     * @memberof AttEndanceMreportServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/attendancemreports/${context.attendancemreport}/select`,isloading);
    }

    /**
     * GetAttendencemanOfKQSZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async GetAttendencemanOfKQSZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/attendancemreports/${context.attendancemreport}/getattendencemanofkqsz`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendancemreports/${context.attendancemreport}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/attendancemreports/${context.attendancemreport}`,isloading);

    }

    /**
     * ExportKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async ExportKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/attendancemreports/${context.attendancemreport}/exportkqyb`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/attendancemreports`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
        return res;
    }

    /**
     * SCKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async SCKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/attendancemreports/${context.attendancemreport}/sckqyb`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/attendancemreports/${context.attendancemreport}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/attendancemreports/${context.attendancemreport}/checkkey`,data,isloading);
    }

    /**
     * QR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async QR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/attendancemreports/${context.attendancemreport}/qr`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendancemreports/${context.attendancemreport}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/attendancemreports/getdraft`,isloading);
        res.data.attendancemreport = data.attendancemreport;
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
        return res;
    }

    /**
     * FetchKQYBDY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async FetchKQYBDY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreports/fetchkqybdy`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreports/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchKQYCZKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async FetchKQYCZKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreports/fetchkqyczkqyb`,tempData,isloading);
    }

    /**
     * FetchCurORMORGKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async FetchCurORMORGKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreports/fetchcurormorgkqyb`,tempData,isloading);
    }

    /**
     * FetchCurORMORGSECTORKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async FetchCurORMORGSECTORKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendancemreports/fetchcurormorgsectorkqyb`,tempData,isloading);
    }

    /**
     * PrintKQYB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndanceMreportServiceBase
     */
    public async PrintKQYB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }
}