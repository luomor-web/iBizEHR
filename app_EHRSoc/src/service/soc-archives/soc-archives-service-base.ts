import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import StopArchivesLogic from '@/service/soc-archives/stop-archives-logic';
import InitArchivesDetailLogic from '@/service/soc-archives/init-archives-detail-logic';



/**
 * 社保档案服务对象基类
 *
 * @export
 * @class SocArchivesServiceBase
 * @extends {EntityServie}
 */
export default class SocArchivesServiceBase extends EntityService {

    /**
     * Creates an instance of  SocArchivesServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SocArchivesServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SocArchivesServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='socarchives';
        this.APPDEKEY = 'socarchivesid';
        this.APPDENAME = 'socarchives';
        this.APPDETEXT = 'socarchivesname';
        this.APPNAME = 'ehrsoc';
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
     * @memberof SocArchivesServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/select`,isloading);
        }
            return Http.getInstance().get(`/socarchives/${context.socarchives}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}`,isloading);
        }
            return Http.getInstance().delete(`/socarchives/${context.socarchives}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/socarchives/getdraft`,isloading);
        res.data.socarchives = data.socarchives;
            this.tempStorage.setItem(context.srfsessionkey+'_socarchivesdetails',JSON.stringify(res.data.socarchivesdetails));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}`,data,isloading);
        }
        let masterData:any = {};
        let socarchivesdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails'),'undefined')){
            socarchivesdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails') as any);
            if(socarchivesdetailsData && socarchivesdetailsData.length && socarchivesdetailsData.length > 0){
                socarchivesdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socarchivesdetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socarchivesdetails = socarchivesdetailsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/socarchives/${context.socarchives}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socarchivesdetails',JSON.stringify(res.data.socarchivesdetails));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/socarchives/${context.socarchives}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socarchivesdetails',JSON.stringify(res.data.socarchivesdetails));
            return res;

    }

    /**
     * StopArchives接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async StopArchives(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:StopArchivesLogic = new StopArchivesLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/save`,data,isloading);
        }
        let masterData:any = {};
        let socarchivesdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails'),'undefined')){
            socarchivesdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails') as any);
            if(socarchivesdetailsData && socarchivesdetailsData.length && socarchivesdetailsData.length > 0){
                socarchivesdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socarchivesdetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socarchivesdetails = socarchivesdetailsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/socarchives/${context.socarchives}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socarchivesdetails',JSON.stringify(res.data.socarchivesdetails));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives`,data,isloading);
        }
        let masterData:any = {};
        let socarchivesdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails'),'undefined')){
            socarchivesdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socarchivesdetails') as any);
            if(socarchivesdetailsData && socarchivesdetailsData.length && socarchivesdetailsData.length > 0){
                socarchivesdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socarchivesdetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socarchivesdetails = socarchivesdetailsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/socarchives`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_socarchivesdetails',JSON.stringify(res.data.socarchivesdetails));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/socarchives/${context.socarchives}/checkkey`,data,isloading);
    }

    /**
     * FetchOrgArchives接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async FetchOrgArchives(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/fetchorgarchives`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socarchives/fetchorgarchives`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socarchives/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchStopArchives接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesServiceBase
     */
    public async FetchStopArchives(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/fetchstoparchives`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socarchives/fetchstoparchives`,tempData,isloading);
    }
}