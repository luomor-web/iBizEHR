import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织管理服务对象基类
 *
 * @export
 * @class OrmOrgServiceBase
 * @extends {EntityServie}
 */
export default class OrmOrgServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmOrgServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmOrgServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormorg';
        this.APPDEKEY = 'orgid';
        this.APPDENAME = 'ormorgs';
        this.APPDETEXT = 'orgname';
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
     * @memberof OrmOrgServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
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
        let ormorgsectorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors'),'undefined')){
            ormorgsectorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors') as any);
            if(ormorgsectorsData && ormorgsectorsData.length && ormorgsectorsData.length > 0){
                ormorgsectorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgsectors = ormorgsectorsData;
        let ormxmbqsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs'),'undefined')){
            ormxmbqsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs') as any);
            if(ormxmbqsData && ormxmbqsData.length && ormxmbqsData.length > 0){
                ormxmbqsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbqid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbqs = ormxmbqsData;
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
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
        let pcmydjdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes'),'undefined')){
            pcmydjdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes') as any);
            if(pcmydjdmxesData && pcmydjdmxesData.length && pcmydjdmxesData.length > 0){
                pcmydjdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmydjdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmydjdmxes = pcmydjdmxesData;
        let ormpostsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormposts'),'undefined')){
            ormpostsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormposts') as any);
            if(ormpostsData && ormpostsData.length && ormpostsData.length > 0){
                ormpostsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormposts = ormpostsData;
        let ormorgdzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs'),'undefined')){
            ormorgdzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs') as any);
            if(ormorgdzsData && ormorgdzsData.length && ormorgdzsData.length > 0){
                ormorgdzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormorgdzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgdzs = ormorgdzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormorgs/${context.ormorg}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgsectors',JSON.stringify(res.data.ormorgsectors));
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbqs',JSON.stringify(res.data.ormxmbqs));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmydjdmxes',JSON.stringify(res.data.pcmydjdmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_ormposts',JSON.stringify(res.data.ormposts));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgdzs',JSON.stringify(res.data.ormorgdzs));
            return res;
    }

    /**
     * SynOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async SynOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/synorg`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormorgs/getdraft`,isloading);
        res.data.ormorg = data.ormorg;
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgsectors',JSON.stringify(res.data.ormorgsectors));
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbqs',JSON.stringify(res.data.ormxmbqs));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmydjdmxes',JSON.stringify(res.data.pcmydjdmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_ormposts',JSON.stringify(res.data.ormposts));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgdzs',JSON.stringify(res.data.ormorgdzs));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormorgs/${context.ormorg}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgsectors',JSON.stringify(res.data.ormorgsectors));
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbqs',JSON.stringify(res.data.ormxmbqs));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmydjdmxes',JSON.stringify(res.data.pcmydjdmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_ormposts',JSON.stringify(res.data.ormposts));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgdzs',JSON.stringify(res.data.ormorgdzs));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
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
        let ormorgsectorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors'),'undefined')){
            ormorgsectorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors') as any);
            if(ormorgsectorsData && ormorgsectorsData.length && ormorgsectorsData.length > 0){
                ormorgsectorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgsectors = ormorgsectorsData;
        let ormxmbqsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs'),'undefined')){
            ormxmbqsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs') as any);
            if(ormxmbqsData && ormxmbqsData.length && ormxmbqsData.length > 0){
                ormxmbqsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbqid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbqs = ormxmbqsData;
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
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
        let pcmydjdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes'),'undefined')){
            pcmydjdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes') as any);
            if(pcmydjdmxesData && pcmydjdmxesData.length && pcmydjdmxesData.length > 0){
                pcmydjdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmydjdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmydjdmxes = pcmydjdmxesData;
        let ormpostsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormposts'),'undefined')){
            ormpostsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormposts') as any);
            if(ormpostsData && ormpostsData.length && ormpostsData.length > 0){
                ormpostsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormposts = ormpostsData;
        let ormorgdzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs'),'undefined')){
            ormorgdzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs') as any);
            if(ormorgdzsData && ormorgdzsData.length && ormorgdzsData.length > 0){
                ormorgdzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormorgdzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgdzs = ormorgdzsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormorgs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormorgsectors',JSON.stringify(res.data.ormorgsectors));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormxmbqs',JSON.stringify(res.data.ormxmbqs));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmydjdmxes',JSON.stringify(res.data.pcmydjdmxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormposts',JSON.stringify(res.data.ormposts));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormorgdzs',JSON.stringify(res.data.ormorgdzs));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
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
        let ormorgsectorsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors'),'undefined')){
            ormorgsectorsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgsectors') as any);
            if(ormorgsectorsData && ormorgsectorsData.length && ormorgsectorsData.length > 0){
                ormorgsectorsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgsectorid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgsectors = ormorgsectorsData;
        let ormxmbqsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs'),'undefined')){
            ormxmbqsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbqs') as any);
            if(ormxmbqsData && ormxmbqsData.length && ormxmbqsData.length > 0){
                ormxmbqsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbqid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbqs = ormxmbqsData;
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
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
        let pcmydjdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes'),'undefined')){
            pcmydjdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmydjdmxes') as any);
            if(pcmydjdmxesData && pcmydjdmxesData.length && pcmydjdmxesData.length > 0){
                pcmydjdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmydjdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmydjdmxes = pcmydjdmxesData;
        let ormpostsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormposts'),'undefined')){
            ormpostsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormposts') as any);
            if(ormpostsData && ormpostsData.length && ormpostsData.length > 0){
                ormpostsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormposts = ormpostsData;
        let ormorgdzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs'),'undefined')){
            ormorgdzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgdzs') as any);
            if(ormorgdzsData && ormorgdzsData.length && ormorgdzsData.length > 0){
                ormorgdzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormorgdzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgdzs = ormorgdzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormorgs/${context.ormorg}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainfillins',JSON.stringify(res.data.trmtrainfillins));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgsectors',JSON.stringify(res.data.ormorgsectors));
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbqs',JSON.stringify(res.data.ormxmbqs));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontractsignorgs',JSON.stringify(res.data.pimcontractsignorgs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmydjdmxes',JSON.stringify(res.data.pcmydjdmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_ormposts',JSON.stringify(res.data.ormposts));
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgdzs',JSON.stringify(res.data.ormorgdzs));
            return res;
    }

    /**
     * FetchALLSIGNORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchALLSIGNORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallsignorg`,tempData,isloading);
    }

    /**
     * FetchAllLevelTwoOrg2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAllLevelTwoOrg2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallleveltwoorg2`,tempData,isloading);
    }

    /**
     * FetchOrglist_Profile接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchOrglist_Profile(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchorglist_profile`,tempData,isloading);
    }

    /**
     * FetchREP_ORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchREP_ORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchrep_org`,tempData,isloading);
    }

    /**
     * FetchAuthOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAuthOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchauthorg`,tempData,isloading);
    }

    /**
     * FetchGSGWZY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchGSGWZY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchgsgwzy`,tempData,isloading);
    }

    /**
     * FetchSubSubOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSubSubOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsubsuborg`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurChild接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchCurChild(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchcurchild`,tempData,isloading);
    }

    /**
     * FetchSJYXZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSJYXZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsjyxzz`,tempData,isloading);
    }

    /**
     * FetchREP_ORGPNUM接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchREP_ORGPNUM(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchrep_orgpnum`,tempData,isloading);
    }

    /**
     * FetchKZSJZZXZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchKZSJZZXZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchkzsjzzxz`,tempData,isloading);
    }

    /**
     * FetchDanQian接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchDanQian(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchdanqian`,tempData,isloading);
    }

    /**
     * FetchAllLevelTwoOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAllLevelTwoOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallleveltwoorg`,tempData,isloading);
    }

    /**
     * FetchSubOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSubOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsuborg`,tempData,isloading);
    }

    /**
     * FetchHTGLDW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchHTGLDW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchhtgldw`,tempData,isloading);
    }

    /**
     * FetchKZXLXZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchKZXLXZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchkzxlxz`,tempData,isloading);
    }

    /**
     * FetchAuthSJYXZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAuthSJYXZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchauthsjyxzz`,tempData,isloading);
    }

    /**
     * FetchUseByFP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchUseByFP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchusebyfp`,tempData,isloading);
    }

    /**
     * FetchCurPorg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchCurPorg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchcurporg`,tempData,isloading);
    }
}