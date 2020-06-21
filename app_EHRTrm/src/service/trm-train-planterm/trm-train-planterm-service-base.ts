import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训立项服务对象基类
 *
 * @export
 * @class TrmTrainPlantermServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainPlantermServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainPlantermServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainPlantermServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainPlantermServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainplanterm';
        this.APPDEKEY = 'trmtrainplantermid';
        this.APPDENAME = 'trmtrainplanterms';
        this.APPDETEXT = 'trmtrainplanname';
        this.APPNAME = 'ehrtrm';
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
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainbuapplies',JSON.stringify(res.data.trmtrainbuapplies));
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().delete(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().put(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtrainbuappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies'),'undefined')){
            trmtrainbuappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies') as any);
            if(trmtrainbuappliesData && trmtrainbuappliesData.length && trmtrainbuappliesData.length > 0){
                trmtrainbuappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainbuapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainbuapplies = trmtrainbuappliesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainbuapplies',JSON.stringify(res.data.trmtrainbuapplies));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtrainbuappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies'),'undefined')){
            trmtrainbuappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies') as any);
            if(trmtrainbuappliesData && trmtrainbuappliesData.length && trmtrainbuappliesData.length > 0){
                trmtrainbuappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainbuapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainbuapplies = trmtrainbuappliesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainbuapplies',JSON.stringify(res.data.trmtrainbuapplies));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/getdraft`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/getdraft`,isloading);
        }
        if(context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/getdraft`,isloading);
        }
        if(context.trmtrainplan && true){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainplanterms/getdraft`,isloading);
        res.data.trmtrainplanterm = data.trmtrainplanterm;
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainbuapplies',JSON.stringify(res.data.trmtrainbuapplies));
        return res;
    }

    /**
     * KB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async KB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/kb`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/kb`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/kb`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/kb`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/kb`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms`,data,isloading);
        }
        if(context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms`,data,isloading);
        }
        if(context.trmtrainplan && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms`,data,isloading);
        }
        let masterData:any = {};
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
        let trmtrainbuappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies'),'undefined')){
            trmtrainbuappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainbuapplies') as any);
            if(trmtrainbuappliesData && trmtrainbuappliesData.length && trmtrainbuappliesData.length > 0){
                trmtrainbuappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainbuapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainbuapplies = trmtrainbuappliesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainplanterms`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmteachercharges',JSON.stringify(res.data.trmteachercharges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainbuapplies',JSON.stringify(res.data.trmtrainbuapplies));
        return res;
    }

    /**
     * QX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async QX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/qx`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/qx`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/qx`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/qx`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/qx`,data,isloading);
    }

    /**
     * LX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async LX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/lx`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/lx`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/lx`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/lx`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/lx`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlantermServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/fetchdefault`,tempData,isloading);
        }
        if(context.pimperson && context.trmtrainplan && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainplan && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainplanterms/fetchdefault`,tempData,isloading);
    }
}