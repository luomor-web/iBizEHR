import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训讲师服务对象基类
 *
 * @export
 * @class TrmTrainTeacherServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainTeacherServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainTeacherServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainTeacherServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainTeacherServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainteacher';
        this.APPDEKEY = 'trmtrainteacherid';
        this.APPDENAME = 'trmtrainteachers';
        this.APPDETEXT = 'trmtrainteachername';
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
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}`,data,isloading);
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
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        let trmteachertrainsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains'),'undefined')){
            trmteachertrainsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains') as any);
            if(trmteachertrainsData && trmteachertrainsData.length && trmteachertrainsData.length > 0){
                trmteachertrainsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteachertrainid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachertrains = trmteachertrainsData;
        let trmteacherchargesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges'),'undefined')){
            trmteacherchargesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges') as any);
            if(trmteacherchargesData && trmteacherchargesData.length && trmteacherchargesData.length > 0){
                trmteacherchargesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteacherchargeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachercharges = trmteacherchargesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainteachers/getdraft`,isloading);
        res.data.trmtrainteacher = data.trmtrainteacher;
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/save`,data,isloading);
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
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        let trmteachertrainsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains'),'undefined')){
            trmteachertrainsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains') as any);
            if(trmteachertrainsData && trmteachertrainsData.length && trmteachertrainsData.length > 0){
                trmteachertrainsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteachertrainid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachertrains = trmteachertrainsData;
        let trmteacherchargesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges'),'undefined')){
            trmteacherchargesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges') as any);
            if(trmteacherchargesData && trmteacherchargesData.length && trmteacherchargesData.length > 0){
                trmteacherchargesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteacherchargeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachercharges = trmteacherchargesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers`,data,isloading);
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
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        let trmteachertrainsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains'),'undefined')){
            trmteachertrainsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachertrains') as any);
            if(trmteachertrainsData && trmteachertrainsData.length && trmteachertrainsData.length > 0){
                trmteachertrainsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteachertrainid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachertrains = trmteachertrainsData;
        let trmteacherchargesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges'),'undefined')){
            trmteacherchargesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmteachercharges') as any);
            if(trmteacherchargesData && trmteacherchargesData.length && trmteacherchargesData.length > 0){
                trmteacherchargesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmteacherchargeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmteachercharges = trmteacherchargesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainteachers`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
        return res;
    }

    /**
     * FetchNBJS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async FetchNBJS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/fetchnbjs`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainteachers/fetchnbjs`,tempData,isloading);
    }

    /**
     * FetchWBJS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async FetchWBJS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/fetchwbjs`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainteachers/fetchwbjs`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainTeacherServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainteachers/fetchdefault`,tempData,isloading);
    }
}