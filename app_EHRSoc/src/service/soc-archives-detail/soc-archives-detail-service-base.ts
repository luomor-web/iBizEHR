import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 社保档案明细服务对象基类
 *
 * @export
 * @class SocArchivesDetailServiceBase
 * @extends {EntityServie}
 */
export default class SocArchivesDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  SocArchivesDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SocArchivesDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SocArchivesDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='socarchivesdetail';
        this.APPDEKEY = 'socarchivesdetailid';
        this.APPDENAME = 'socarchivesdetails';
        this.APPDETEXT = 'socarchivesdetailname';
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
     * @memberof SocArchivesDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/select`,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().get(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/select`,isloading);
        }
            return Http.getInstance().get(`/socarchivesdetails/${context.socarchivesdetail}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails`,data,isloading);
        }
        if(context.socarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/socarchives/${context.socarchives}/socarchivesdetails`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/socarchivesdetails`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/save`,data,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().post(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/socarchivesdetails/${context.socarchivesdetail}/save`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/checkkey`,data,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().post(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/socarchivesdetails/${context.socarchivesdetail}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/getdraft`,isloading);
        }
        if(context.socarchives && true){
            return Http.getInstance().get(`/socarchives/${context.socarchives}/socarchivesdetails/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/socarchivesdetails/getdraft`,isloading);
        res.data.socarchivesdetail = data.socarchivesdetail;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,data,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().put(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/socarchivesdetails/${context.socarchivesdetail}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().get(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/socarchivesdetails/${context.socarchivesdetail}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && context.socarchivesdetail){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,isloading);
        }
        if(context.socarchives && context.socarchivesdetail){
            return Http.getInstance().delete(`/socarchives/${context.socarchives}/socarchivesdetails/${context.socarchivesdetail}`,isloading);
        }
            return Http.getInstance().delete(`/socarchivesdetails/${context.socarchivesdetail}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocArchivesDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.socarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/socarchives/${context.socarchives}/socarchivesdetails/fetchdefault`,tempData,isloading);
        }
        if(context.socarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/socarchives/${context.socarchives}/socarchivesdetails/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socarchivesdetails/fetchdefault`,tempData,isloading);
    }
}