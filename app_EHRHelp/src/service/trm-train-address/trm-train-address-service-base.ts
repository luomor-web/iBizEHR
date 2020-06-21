import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训场地服务对象基类
 *
 * @export
 * @class TrmTrainAddressServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainAddressServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainAddressServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainAddressServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainAddressServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainaddress';
        this.APPDEKEY = 'trmtrainaddressid';
        this.APPDENAME = 'trmtrainaddresses';
        this.APPDETEXT = 'trmtrainaddressname';
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
     * @memberof TrmTrainAddressServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        let trmtrainfaciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies'),'undefined')){
            trmtrainfaciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies') as any);
            if(trmtrainfaciesData && trmtrainfaciesData.length && trmtrainfaciesData.length > 0){
                trmtrainfaciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfaciesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfacies = trmtrainfaciesData;
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
        let trmstaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmstays'),'undefined')){
            trmstaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmstays') as any);
            if(trmstaysData && trmstaysData.length && trmstaysData.length > 0){
                trmstaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmstayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmstays = trmstaysData;
        let trmtrafficsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics'),'undefined')){
            trmtrafficsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics') as any);
            if(trmtrafficsData && trmtrafficsData.length && trmtrafficsData.length > 0){
                trmtrafficsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrafficid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraffics = trmtrafficsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfacies',JSON.stringify(res.data.trmtrainfacies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmstays',JSON.stringify(res.data.trmstays));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraffics',JSON.stringify(res.data.trmtraffics));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/trmtrainaddresses/getdraft`,isloading);
        res.data.trmtrainaddress = data.trmtrainaddress;
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfacies',JSON.stringify(res.data.trmtrainfacies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmstays',JSON.stringify(res.data.trmstays));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraffics',JSON.stringify(res.data.trmtraffics));
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        let trmtrainfaciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies'),'undefined')){
            trmtrainfaciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies') as any);
            if(trmtrainfaciesData && trmtrainfaciesData.length && trmtrainfaciesData.length > 0){
                trmtrainfaciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfaciesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfacies = trmtrainfaciesData;
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
        let trmstaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmstays'),'undefined')){
            trmstaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmstays') as any);
            if(trmstaysData && trmstaysData.length && trmstaysData.length > 0){
                trmstaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmstayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmstays = trmstaysData;
        let trmtrafficsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics'),'undefined')){
            trmtrafficsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics') as any);
            if(trmtrafficsData && trmtrafficsData.length && trmtrafficsData.length > 0){
                trmtrafficsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrafficid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraffics = trmtrafficsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainaddresses`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainfacies',JSON.stringify(res.data.trmtrainfacies));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmstays',JSON.stringify(res.data.trmstays));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtraffics',JSON.stringify(res.data.trmtraffics));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        let trmtrainfaciesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies'),'undefined')){
            trmtrainfaciesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfacies') as any);
            if(trmtrainfaciesData && trmtrainfaciesData.length && trmtrainfaciesData.length > 0){
                trmtrainfaciesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfaciesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfacies = trmtrainfaciesData;
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
        let trmstaysData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmstays'),'undefined')){
            trmstaysData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmstays') as any);
            if(trmstaysData && trmstaysData.length && trmstaysData.length > 0){
                trmstaysData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmstayid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmstays = trmstaysData;
        let trmtrafficsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics'),'undefined')){
            trmtrafficsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtraffics') as any);
            if(trmtrafficsData && trmtrafficsData.length && trmtrafficsData.length > 0){
                trmtrafficsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrafficid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtraffics = trmtrafficsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfacies',JSON.stringify(res.data.trmtrainfacies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmstays',JSON.stringify(res.data.trmstays));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraffics',JSON.stringify(res.data.trmtraffics));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmcouarranges',JSON.stringify(res.data.trmcouarranges));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfacies',JSON.stringify(res.data.trmtrainfacies));
            this.tempStorage.setItem(context.srfsessionkey+'_trmteachertrains',JSON.stringify(res.data.trmteachertrains));
            this.tempStorage.setItem(context.srfsessionkey+'_trmstays',JSON.stringify(res.data.trmstays));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtraffics',JSON.stringify(res.data.trmtraffics));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainAddressServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainaddresses/fetchdefault`,tempData,isloading);
    }
}