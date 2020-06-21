import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训模块服务对象基类
 *
 * @export
 * @class TrmCourseSystemServiceBase
 * @extends {EntityServie}
 */
export default class TrmCourseSystemServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmCourseSystemServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmCourseSystemServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmCourseSystemServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmcoursesystem';
        this.APPDEKEY = 'trmcoursesystemid';
        this.APPDENAME = 'trmcoursesystems';
        this.APPDETEXT = 'trmcoursesystemname';
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
     * @memberof TrmCourseSystemServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/select`,isloading);
        }
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtraincoursesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses'),'undefined')){
            trmtraincoursesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses') as any);
            if(trmtraincoursesData && trmtraincoursesData.length && trmtraincoursesData.length > 0){
                trmtraincoursesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtraincourseid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraincourses = trmtraincoursesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmcoursesystems/${context.trmcoursesystem}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraincourses',JSON.stringify(res.data.trmtraincourses));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/save`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtraincoursesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses'),'undefined')){
            trmtraincoursesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses') as any);
            if(trmtraincoursesData && trmtraincoursesData.length && trmtraincoursesData.length > 0){
                trmtraincoursesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtraincourseid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraincourses = trmtraincoursesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraincourses',JSON.stringify(res.data.trmtraincourses));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmcoursesystems/getdraft`,isloading);
        res.data.trmcoursesystem = data.trmcoursesystem;
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraincourses',JSON.stringify(res.data.trmtraincourses));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraincourses',JSON.stringify(res.data.trmtraincourses));
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,isloading);
        }
            return Http.getInstance().delete(`/trmcoursesystems/${context.trmcoursesystem}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtraincoursesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses'),'undefined')){
            trmtraincoursesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraincourses') as any);
            if(trmtraincoursesData && trmtraincoursesData.length && trmtraincoursesData.length > 0){
                trmtraincoursesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtraincourseid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraincourses = trmtraincoursesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmcoursesystems`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtraincourses',JSON.stringify(res.data.trmtraincourses));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmcoursesystems/fetchdefault`,tempData,isloading);
    }
}