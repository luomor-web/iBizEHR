import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训机构服务对象基类
 *
 * @export
 * @class TrmTrainAgencyServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainAgencyServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainAgencyServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainAgencyServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainAgencyServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainagency';
        this.APPDEKEY = 'trmtrainagencyid';
        this.APPDENAME = 'trmtrainagencies';
        this.APPDETEXT = 'trmtrainagencyname';
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
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let trmhmatsersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers'),'undefined')){
            trmhmatsersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers') as any);
            if(trmhmatsersData && trmhmatsersData.length && trmhmatsersData.length > 0){
                trmhmatsersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmhmatserid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmhmatsers = trmhmatsersData;
        let trmcouarrangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges'),'undefined')){
            trmcouarrangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges') as any);
            if(trmcouarrangesData && trmcouarrangesData.length && trmcouarrangesData.length > 0){
                trmcouarrangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcouarrangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcouarranges = trmcouarrangesData;
        let trmcoursesystemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems'),'undefined')){
            trmcoursesystemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems') as any);
            if(trmcoursesystemsData && trmcoursesystemsData.length && trmcoursesystemsData.length > 0){
                trmcoursesystemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcoursesystemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcoursesystems = trmcoursesystemsData;
        let trmtrainagenciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies'),'undefined')){
            trmtrainagenciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies') as any);
            if(trmtrainagenciesData && trmtrainagenciesData.length && trmtrainagenciesData.length > 0){
                trmtrainagenciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainagencyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainagencies = trmtrainagenciesData;
        let trmtrainteachersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers'),'undefined')){
            trmtrainteachersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers') as any);
            if(trmtrainteachersData && trmtrainteachersData.length && trmtrainteachersData.length > 0){
                trmtrainteachersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainteacherid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainteachers = trmtrainteachersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmhmatsers',JSON.stringify(res.data.trmhmatsers));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcoursesystems',JSON.stringify(res.data.trmcoursesystems));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainagencies',JSON.stringify(res.data.trmtrainagencies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainteachers',JSON.stringify(res.data.trmtrainteachers));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/trmtrainagencies/getdraft`,isloading);
        res.data.trmtrainagency = data.trmtrainagency;
            this.tempStorage.setItem(context.srfsessionkey+'_trmhmatsers',JSON.stringify(res.data.trmhmatsers));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcoursesystems',JSON.stringify(res.data.trmcoursesystems));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainagencies',JSON.stringify(res.data.trmtrainagencies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainteachers',JSON.stringify(res.data.trmtrainteachers));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmhmatsers',JSON.stringify(res.data.trmhmatsers));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcoursesystems',JSON.stringify(res.data.trmcoursesystems));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainagencies',JSON.stringify(res.data.trmtrainagencies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainteachers',JSON.stringify(res.data.trmtrainteachers));
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let trmhmatsersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers'),'undefined')){
            trmhmatsersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers') as any);
            if(trmhmatsersData && trmhmatsersData.length && trmhmatsersData.length > 0){
                trmhmatsersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmhmatserid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmhmatsers = trmhmatsersData;
        let trmcouarrangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges'),'undefined')){
            trmcouarrangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges') as any);
            if(trmcouarrangesData && trmcouarrangesData.length && trmcouarrangesData.length > 0){
                trmcouarrangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcouarrangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcouarranges = trmcouarrangesData;
        let trmcoursesystemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems'),'undefined')){
            trmcoursesystemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems') as any);
            if(trmcoursesystemsData && trmcoursesystemsData.length && trmcoursesystemsData.length > 0){
                trmcoursesystemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcoursesystemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcoursesystems = trmcoursesystemsData;
        let trmtrainagenciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies'),'undefined')){
            trmtrainagenciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies') as any);
            if(trmtrainagenciesData && trmtrainagenciesData.length && trmtrainagenciesData.length > 0){
                trmtrainagenciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainagencyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainagencies = trmtrainagenciesData;
        let trmtrainteachersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers'),'undefined')){
            trmtrainteachersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers') as any);
            if(trmtrainteachersData && trmtrainteachersData.length && trmtrainteachersData.length > 0){
                trmtrainteachersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainteacherid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainteachers = trmtrainteachersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmhmatsers',JSON.stringify(res.data.trmhmatsers));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmcoursesystems',JSON.stringify(res.data.trmcoursesystems));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainagencies',JSON.stringify(res.data.trmtrainagencies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainteachers',JSON.stringify(res.data.trmtrainteachers));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let trmhmatsersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers'),'undefined')){
            trmhmatsersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmhmatsers') as any);
            if(trmhmatsersData && trmhmatsersData.length && trmhmatsersData.length > 0){
                trmhmatsersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmhmatserid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmhmatsers = trmhmatsersData;
        let trmcouarrangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges'),'undefined')){
            trmcouarrangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcouarranges') as any);
            if(trmcouarrangesData && trmcouarrangesData.length && trmcouarrangesData.length > 0){
                trmcouarrangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcouarrangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcouarranges = trmcouarrangesData;
        let trmcoursesystemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems'),'undefined')){
            trmcoursesystemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmcoursesystems') as any);
            if(trmcoursesystemsData && trmcoursesystemsData.length && trmcoursesystemsData.length > 0){
                trmcoursesystemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmcoursesystemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmcoursesystems = trmcoursesystemsData;
        let trmtrainagenciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies'),'undefined')){
            trmtrainagenciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainagencies') as any);
            if(trmtrainagenciesData && trmtrainagenciesData.length && trmtrainagenciesData.length > 0){
                trmtrainagenciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainagencyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainagencies = trmtrainagenciesData;
        let trmtrainteachersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers'),'undefined')){
            trmtrainteachersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainteachers') as any);
            if(trmtrainteachersData && trmtrainteachersData.length && trmtrainteachersData.length > 0){
                trmtrainteachersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainteacherid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainteachers = trmtrainteachersData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainagencies`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmhmatsers',JSON.stringify(res.data.trmhmatsers));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmcoursesystems',JSON.stringify(res.data.trmcoursesystems));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainagencies',JSON.stringify(res.data.trmtrainagencies));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainteachers',JSON.stringify(res.data.trmtrainteachers));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAgencyServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainagencies/fetchdefault`,tempData,isloading);
    }
}