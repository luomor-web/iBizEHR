import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤设置服务对象基类
 *
 * @export
 * @class AttEndenceSetupServiceBase
 * @extends {EntityServie}
 */
export default class AttEndenceSetupServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndenceSetupServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndenceSetupServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndenceSetupServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendencesetup';
        this.APPDEKEY = 'attendencesetupid';
        this.APPDENAME = 'attendencesetups';
        this.APPDETEXT = 'attendencesetupname';
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
     * @memberof AttEndenceSetupServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendenceormorgscetorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors'),'undefined')){
            attendenceormorgscetorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors') as any);
            if(attendenceormorgscetorsData && attendenceormorgscetorsData.length && attendenceormorgscetorsData.length > 0){
                attendenceormorgscetorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendenceormorgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendenceormorgscetors = attendenceormorgscetorsData;
        let attendancesettingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings'),'undefined')){
            attendancesettingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings') as any);
            if(attendancesettingsData && attendancesettingsData.length && attendancesettingsData.length > 0){
                attendancesettingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancesettingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancesettings = attendancesettingsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendencesetups/${context.attendencesetup}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendenceormorgscetors',JSON.stringify(res.data.attendenceormorgscetors));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancesettings',JSON.stringify(res.data.attendancesettings));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendenceormorgscetorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors'),'undefined')){
            attendenceormorgscetorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors') as any);
            if(attendenceormorgscetorsData && attendenceormorgscetorsData.length && attendenceormorgscetorsData.length > 0){
                attendenceormorgscetorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendenceormorgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendenceormorgscetors = attendenceormorgscetorsData;
        let attendancesettingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings'),'undefined')){
            attendancesettingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings') as any);
            if(attendancesettingsData && attendancesettingsData.length && attendancesettingsData.length > 0){
                attendancesettingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancesettingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancesettings = attendancesettingsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendenceormorgscetors',JSON.stringify(res.data.attendenceormorgscetors));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancesettings',JSON.stringify(res.data.attendancesettings));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/attendencesetups/${context.attendencesetup}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_attendenceormorgscetors',JSON.stringify(res.data.attendenceormorgscetors));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancesettings',JSON.stringify(res.data.attendancesettings));
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/attendencesetups/getdraft`,isloading);
        res.data.attendencesetup = data.attendencesetup;
            this.tempStorage.setItem(context.srfsessionkey+'_attendenceormorgscetors',JSON.stringify(res.data.attendenceormorgscetors));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancesettings',JSON.stringify(res.data.attendancesettings));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/attendencesetups/${context.attendencesetup}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let attendenceormorgscetorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors'),'undefined')){
            attendenceormorgscetorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendenceormorgscetors') as any);
            if(attendenceormorgscetorsData && attendenceormorgscetorsData.length && attendenceormorgscetorsData.length > 0){
                attendenceormorgscetorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendenceormorgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendenceormorgscetors = attendenceormorgscetorsData;
        let attendancesettingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings'),'undefined')){
            attendancesettingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancesettings') as any);
            if(attendancesettingsData && attendancesettingsData.length && attendancesettingsData.length > 0){
                attendancesettingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancesettingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancesettings = attendancesettingsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/attendencesetups`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_attendenceormorgscetors',JSON.stringify(res.data.attendenceormorgscetors));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_attendancesettings',JSON.stringify(res.data.attendancesettings));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendencesetups/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurOrgKQSZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async FetchCurOrgKQSZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendencesetups/fetchcurorgkqsz`,tempData,isloading);
    }

    /**
     * FetchKQYBXKQB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async FetchKQYBXKQB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendencesetups/fetchkqybxkqb`,tempData,isloading);
    }

    /**
     * FetchKQYCZKQSZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async FetchKQYCZKQSZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendencesetups/fetchkqyczkqsz`,tempData,isloading);
    }

    /**
     * ReflushUpdatedate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceSetupServiceBase
     */
    public async ReflushUpdatedate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }
}