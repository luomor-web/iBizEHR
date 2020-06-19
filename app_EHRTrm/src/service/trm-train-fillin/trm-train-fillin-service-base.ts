import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训需求填报服务对象基类
 *
 * @export
 * @class TrmTrainFillinServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainFillinServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainFillinServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainFillinServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainFillinServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainfillin';
        this.APPDEKEY = 'trmtrainfillinid';
        this.APPDENAME = 'trmtrainfillins';
        this.APPDETEXT = 'trmtrainfillinname';
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
     * @memberof TrmTrainFillinServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/select`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/select`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/select`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_trmdemdeftions',JSON.stringify(res.data.trmdemdeftions));
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().put(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainfillinsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins'),'undefined')){
            trmtrainfillinsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins') as any);
            if(trmtrainfillinsData && trmtrainfillinsData.length && trmtrainfillinsData.length > 0){
                trmtrainfillinsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfillinid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfillins = trmtrainfillinsData;
        let trmdemdeftionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions'),'undefined')){
            trmdemdeftionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions') as any);
            if(trmdemdeftionsData && trmdemdeftionsData.length && trmdemdeftionsData.length > 0){
                trmdemdeftionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmdemdeftionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmdemdeftions = trmdemdeftionsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainfillins/${context.trmtrainfillin}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_trmdemdeftions',JSON.stringify(res.data.trmdemdeftions));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/checkkey`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainfillins/${context.trmtrainfillin}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins`,data,isloading);
        }
        if(context.trmdepart && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins`,data,isloading);
        }
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainfillinsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins'),'undefined')){
            trmtrainfillinsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins') as any);
            if(trmtrainfillinsData && trmtrainfillinsData.length && trmtrainfillinsData.length > 0){
                trmtrainfillinsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfillinid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfillins = trmtrainfillinsData;
        let trmdemdeftionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions'),'undefined')){
            trmdemdeftionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions') as any);
            if(trmdemdeftionsData && trmdemdeftionsData.length && trmdemdeftionsData.length > 0){
                trmdemdeftionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmdemdeftionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmdemdeftions = trmdemdeftionsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainfillins`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmdemdeftions',JSON.stringify(res.data.trmdemdeftions));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/save`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/save`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/save`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/save`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainfillinsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins'),'undefined')){
            trmtrainfillinsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainfillins') as any);
            if(trmtrainfillinsData && trmtrainfillinsData.length && trmtrainfillinsData.length > 0){
                trmtrainfillinsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainfillinid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainfillins = trmtrainfillinsData;
        let trmdemdeftionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions'),'undefined')){
            trmdemdeftionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmdemdeftions') as any);
            if(trmdemdeftionsData && trmdemdeftionsData.length && trmdemdeftionsData.length > 0){
                trmdemdeftionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmdemdeftionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmdemdeftions = trmdemdeftionsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainfillins/${context.trmtrainfillin}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_trmdemdeftions',JSON.stringify(res.data.trmdemdeftions));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/getdraft`,isloading);
        }
        if(context.trmdepart && true){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/getdraft`,isloading);
        }
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainfillins/getdraft`,isloading);
        res.data.trmtrainfillin = data.trmtrainfillin;
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_trmdemdeftions',JSON.stringify(res.data.trmdemdeftions));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin){
            return Http.getInstance().delete(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainfillins/${context.trmtrainfillin}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFillinServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/fetchdefault`,tempData,isloading);
        }
        if(context.trmdepart && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainfillins/fetchdefault`,tempData,isloading);
    }
}