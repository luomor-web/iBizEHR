import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import GetPersonOrgLogic from '@/service/pim-archives/get-person-org-logic';



/**
 * 档案信息服务对象基类
 *
 * @export
 * @class PimArchivesServiceBase
 * @extends {EntityServie}
 */
export default class PimArchivesServiceBase extends EntityService {

    /**
     * Creates an instance of  PimArchivesServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimArchivesServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimarchives';
        this.APPDEKEY = 'pimarchivesid';
        this.APPDENAME = 'pimarchives';
        this.APPDETEXT = 'pimpersonname';
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
     * @memberof PimArchivesServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/select`,isloading);
        }
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/select`,isloading);
    }

    /**
     * GetPersonOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async GetPersonOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:GetPersonOrgLogic = new GetPersonOrgLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimarchives/getdraft`,isloading);
        res.data.pimarchives = data.pimarchives;
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesloanandreturns',JSON.stringify(res.data.pimarchivesloanandreturns));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesrecords',JSON.stringify(res.data.pimarchivesrecords));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchiveschanges',JSON.stringify(res.data.pimarchiveschanges));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/save`,data,isloading);
        }
        let masterData:any = {};
        let pimarchivesloanandreturnsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns'),'undefined')){
            pimarchivesloanandreturnsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns') as any);
            if(pimarchivesloanandreturnsData && pimarchivesloanandreturnsData.length && pimarchivesloanandreturnsData.length > 0){
                pimarchivesloanandreturnsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesloanandreturnid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesloanandreturns = pimarchivesloanandreturnsData;
        let pimarchivesrecordsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords'),'undefined')){
            pimarchivesrecordsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords') as any);
            if(pimarchivesrecordsData && pimarchivesrecordsData.length && pimarchivesrecordsData.length > 0){
                pimarchivesrecordsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesrecordid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesrecords = pimarchivesrecordsData;
        let pimarchiveschangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges'),'undefined')){
            pimarchiveschangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges') as any);
            if(pimarchiveschangesData && pimarchiveschangesData.length && pimarchiveschangesData.length > 0){
                pimarchiveschangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchiveschangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchiveschanges = pimarchiveschangesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimarchives/${context.pimarchives}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesloanandreturns',JSON.stringify(res.data.pimarchivesloanandreturns));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesrecords',JSON.stringify(res.data.pimarchivesrecords));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchiveschanges',JSON.stringify(res.data.pimarchiveschanges));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimarchives/${context.pimarchives}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesloanandreturns',JSON.stringify(res.data.pimarchivesloanandreturns));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesrecords',JSON.stringify(res.data.pimarchivesrecords));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchiveschanges',JSON.stringify(res.data.pimarchiveschanges));
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}`,data,isloading);
        }
        let masterData:any = {};
        let pimarchivesloanandreturnsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns'),'undefined')){
            pimarchivesloanandreturnsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns') as any);
            if(pimarchivesloanandreturnsData && pimarchivesloanandreturnsData.length && pimarchivesloanandreturnsData.length > 0){
                pimarchivesloanandreturnsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesloanandreturnid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesloanandreturns = pimarchivesloanandreturnsData;
        let pimarchivesrecordsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords'),'undefined')){
            pimarchivesrecordsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords') as any);
            if(pimarchivesrecordsData && pimarchivesrecordsData.length && pimarchivesrecordsData.length > 0){
                pimarchivesrecordsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesrecordid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesrecords = pimarchivesrecordsData;
        let pimarchiveschangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges'),'undefined')){
            pimarchiveschangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges') as any);
            if(pimarchiveschangesData && pimarchiveschangesData.length && pimarchiveschangesData.length > 0){
                pimarchiveschangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchiveschangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchiveschanges = pimarchiveschangesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimarchives/${context.pimarchives}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesloanandreturns',JSON.stringify(res.data.pimarchivesloanandreturns));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchivesrecords',JSON.stringify(res.data.pimarchivesrecords));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchiveschanges',JSON.stringify(res.data.pimarchiveschanges));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives`,data,isloading);
        }
        let masterData:any = {};
        let pimarchivesloanandreturnsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns'),'undefined')){
            pimarchivesloanandreturnsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesloanandreturns') as any);
            if(pimarchivesloanandreturnsData && pimarchivesloanandreturnsData.length && pimarchivesloanandreturnsData.length > 0){
                pimarchivesloanandreturnsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesloanandreturnid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesloanandreturns = pimarchivesloanandreturnsData;
        let pimarchivesrecordsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords'),'undefined')){
            pimarchivesrecordsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchivesrecords') as any);
            if(pimarchivesrecordsData && pimarchivesrecordsData.length && pimarchivesrecordsData.length > 0){
                pimarchivesrecordsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesrecordid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchivesrecords = pimarchivesrecordsData;
        let pimarchiveschangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges'),'undefined')){
            pimarchiveschangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchiveschanges') as any);
            if(pimarchiveschangesData && pimarchiveschangesData.length && pimarchiveschangesData.length > 0){
                pimarchiveschangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchiveschangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchiveschanges = pimarchiveschangesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pimarchives`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimarchivesloanandreturns',JSON.stringify(res.data.pimarchivesloanandreturns));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimarchivesrecords',JSON.stringify(res.data.pimarchivesrecords));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimarchiveschanges',JSON.stringify(res.data.pimarchiveschanges));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}`,isloading);
        }
            return Http.getInstance().delete(`/pimarchives/${context.pimarchives}`,isloading);

    }

    /**
     * FetchEMLOYEENOFILE接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchEMLOYEENOFILE(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchemloyeenofile`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchemloyeenofile`,tempData,isloading);
    }

    /**
     * FetchSysOrgIsSrfOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchSysOrgIsSrfOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchsysorgissrforg`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchsysorgissrforg`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchjlss`,tempData,isloading);
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchNOEMLOYEENOFILE接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchNOEMLOYEENOFILE(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchnoemloyeenofile`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchnoemloyeenofile`,tempData,isloading);
    }

    /**
     * FetchPIMREADGJD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesServiceBase
     */
    public async FetchPIMREADGJD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/fetchpimreadgjd`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchives/fetchpimreadgjd`,tempData,isloading);
    }
}