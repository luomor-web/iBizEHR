import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 法人主体服务对象基类
 *
 * @export
 * @class OrmSignOrgServiceBase
 * @extends {EntityServie}
 */
export default class OrmSignOrgServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmSignOrgServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmSignOrgServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmSignOrgServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormsignorg';
        this.APPDEKEY = 'ormsignorgid';
        this.APPDENAME = 'ormsignorgs';
        this.APPDETEXT = 'ormsignorgname';
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
     * @memberof OrmSignOrgServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormsignorgs/${context.ormsignorg}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimcontractsignorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs'),'undefined')){
            pimcontractsignorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs') as any);
            if(pimcontractsignorgsData && pimcontractsignorgsData.length && pimcontractsignorgsData.length > 0){
                pimcontractsignorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.contractsignorgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontractsignorgs = pimcontractsignorgsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormsignorgs/${context.ormsignorg}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimcontractsignorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs'),'undefined')){
            pimcontractsignorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs') as any);
            if(pimcontractsignorgsData && pimcontractsignorgsData.length && pimcontractsignorgsData.length > 0){
                pimcontractsignorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.contractsignorgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontractsignorgs = pimcontractsignorgsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormsignorgs/${context.ormsignorg}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormsignorgs/getdraft`,isloading);
        res.data.ormsignorg = data.ormsignorg;
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pimcontractsignorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs'),'undefined')){
            pimcontractsignorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontractsignorgs') as any);
            if(pimcontractsignorgsData && pimcontractsignorgsData.length && pimcontractsignorgsData.length > 0){
                pimcontractsignorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.contractsignorgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontractsignorgs = pimcontractsignorgsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormsignorgs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormsignorgs/${context.ormsignorg}`,isloading);

    }

    /**
     * FetchHTQDDW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async FetchHTQDDW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormsignorgs/fetchhtqddw`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormsignorgs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCKBDWDFRZT接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmSignOrgServiceBase
     */
    public async FetchCKBDWDFRZT(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormsignorgs/fetchckbdwdfrzt`,tempData,isloading);
    }
}