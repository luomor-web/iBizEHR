import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * B/Y类员工转正申请服务对象基类
 *
 * @export
 * @class PimByygzzsqServiceBase
 * @extends {EntityServie}
 */
export default class PimByygzzsqServiceBase extends EntityService {

    /**
     * Creates an instance of  PimByygzzsqServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimByygzzsqServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimByygzzsqServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimbyygzzsq';
        this.APPDEKEY = 'pimbyygzzsqid';
        this.APPDENAME = 'pimbyygzzsqs';
        this.APPDETEXT = 'pimbyygzzsqname';
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
     * @memberof PimByygzzsqServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimbyzzjlmxes',JSON.stringify(res.data.pimbyzzjlmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimbyzzjlmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes'),'undefined')){
            pimbyzzjlmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes') as any);
            if(pimbyzzjlmxesData && pimbyzzjlmxesData.length && pimbyzzjlmxesData.length > 0){
                pimbyzzjlmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimbyzzjlmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimbyzzjlmxes = pimbyzzjlmxesData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimbyygzzsqs/${context.pimbyygzzsq}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimbyzzjlmxes',JSON.stringify(res.data.pimbyzzjlmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pimbyygzzsqs/${context.pimbyygzzsq}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimbyzzjlmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes'),'undefined')){
            pimbyzzjlmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes') as any);
            if(pimbyzzjlmxesData && pimbyzzjlmxesData.length && pimbyzzjlmxesData.length > 0){
                pimbyzzjlmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimbyzzjlmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimbyzzjlmxes = pimbyzzjlmxesData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimbyzzjlmxes',JSON.stringify(res.data.pimbyzzjlmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pimbyygzzsqs/getdraft`,isloading);
        res.data.pimbyygzzsq = data.pimbyygzzsq;
            this.tempStorage.setItem(context.srfsessionkey+'_pimbyzzjlmxes',JSON.stringify(res.data.pimbyzzjlmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimbyzzjlmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes'),'undefined')){
            pimbyzzjlmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimbyzzjlmxes') as any);
            if(pimbyzzjlmxesData && pimbyzzjlmxesData.length && pimbyzzjlmxesData.length > 0){
                pimbyzzjlmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimbyzzjlmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimbyzzjlmxes = pimbyzzjlmxesData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pimbyygzzsqs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimbyzzjlmxes',JSON.stringify(res.data.pimbyzzjlmxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByygzzsqServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyygzzsqs/fetchdefault`,tempData,isloading);
    }
}