import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训需求通知服务对象基类
 *
 * @export
 * @class TrmDepartServiceBase
 * @extends {EntityServie}
 */
export default class TrmDepartServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmDepartServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmDepartServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmDepartServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmdepart';
        this.APPDEKEY = 'trmdepartid';
        this.APPDENAME = 'trmdeparts';
        this.APPDETEXT = 'trmdepartname';
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
     * @memberof TrmDepartServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/trmdeparts/${context.trmdepart}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmdeparts/${context.trmdepart}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmdeparts`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/trmdeparts/${context.trmdepart}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmdeparts/${context.trmdepart}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/trmdeparts/getdraft`,isloading);
        res.data.trmdepart = data.trmdepart;
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDepartServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmdeparts/fetchdefault`,tempData,isloading);
    }
}