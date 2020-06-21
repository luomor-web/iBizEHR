import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 通知发布服务对象基类
 *
 * @export
 * @class ParTzggServiceBase
 * @extends {EntityServie}
 */
export default class ParTzggServiceBase extends EntityService {

    /**
     * Creates an instance of  ParTzggServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParTzggServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParTzggServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='partzgg';
        this.APPDEKEY = 'partzggid';
        this.APPDENAME = 'partzggs';
        this.APPDETEXT = 'partzggname';
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
     * @memberof ParTzggServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/partzggs/${context.partzgg}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/partzggs/getdraft`,isloading);
        res.data.partzgg = data.partzgg;
            this.tempStorage.setItem(context.srfsessionkey+'_parbmfzjyxes',JSON.stringify(res.data.parbmfzjyxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parfzsmxes',JSON.stringify(res.data.parfzsmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parznbmmxes',JSON.stringify(res.data.parznbmmxes));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/partzggs/${context.partzgg}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parbmfzjyxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes'),'undefined')){
            parbmfzjyxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes') as any);
            if(parbmfzjyxesData && parbmfzjyxesData.length && parbmfzjyxesData.length > 0){
                parbmfzjyxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parbmfzjyxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parbmfzjyxes = parbmfzjyxesData;
        let parfzsmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes'),'undefined')){
            parfzsmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes') as any);
            if(parfzsmxesData && parfzsmxesData.length && parfzsmxesData.length > 0){
                parfzsmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parfzsmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parfzsmxes = parfzsmxesData;
        let parznbmmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes'),'undefined')){
            parznbmmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes') as any);
            if(parznbmmxesData && parznbmmxesData.length && parznbmmxesData.length > 0){
                parznbmmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parznbmmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parznbmmxes = parznbmmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/partzggs/${context.partzgg}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parbmfzjyxes',JSON.stringify(res.data.parbmfzjyxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parfzsmxes',JSON.stringify(res.data.parfzsmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parznbmmxes',JSON.stringify(res.data.parznbmmxes));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parbmfzjyxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes'),'undefined')){
            parbmfzjyxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes') as any);
            if(parbmfzjyxesData && parbmfzjyxesData.length && parbmfzjyxesData.length > 0){
                parbmfzjyxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parbmfzjyxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parbmfzjyxes = parbmfzjyxesData;
        let parfzsmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes'),'undefined')){
            parfzsmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes') as any);
            if(parfzsmxesData && parfzsmxesData.length && parfzsmxesData.length > 0){
                parfzsmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parfzsmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parfzsmxes = parfzsmxesData;
        let parznbmmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes'),'undefined')){
            parznbmmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes') as any);
            if(parznbmmxesData && parznbmmxesData.length && parznbmmxesData.length > 0){
                parznbmmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parznbmmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parznbmmxes = parznbmmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/partzggs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parbmfzjyxes',JSON.stringify(res.data.parbmfzjyxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parfzsmxes',JSON.stringify(res.data.parfzsmxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parznbmmxes',JSON.stringify(res.data.parznbmmxes));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/partzggs/${context.partzgg}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parbmfzjyxes',JSON.stringify(res.data.parbmfzjyxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parfzsmxes',JSON.stringify(res.data.parfzsmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parznbmmxes',JSON.stringify(res.data.parznbmmxes));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/partzggs/${context.partzgg}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parbmfzjyxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes'),'undefined')){
            parbmfzjyxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parbmfzjyxes') as any);
            if(parbmfzjyxesData && parbmfzjyxesData.length && parbmfzjyxesData.length > 0){
                parbmfzjyxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parbmfzjyxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parbmfzjyxes = parbmfzjyxesData;
        let parfzsmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes'),'undefined')){
            parfzsmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parfzsmxes') as any);
            if(parfzsmxesData && parfzsmxesData.length && parfzsmxesData.length > 0){
                parfzsmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parfzsmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parfzsmxes = parfzsmxesData;
        let parznbmmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes'),'undefined')){
            parznbmmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parznbmmxes') as any);
            if(parznbmmxesData && parznbmmxesData.length && parznbmmxesData.length > 0){
                parznbmmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parznbmmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parznbmmxes = parznbmmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/partzggs/${context.partzgg}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parbmfzjyxes',JSON.stringify(res.data.parbmfzjyxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parfzsmxes',JSON.stringify(res.data.parfzsmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parznbmmxes',JSON.stringify(res.data.parznbmmxes));
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParTzggServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/partzggs/fetchdefault`,tempData,isloading);
    }
}