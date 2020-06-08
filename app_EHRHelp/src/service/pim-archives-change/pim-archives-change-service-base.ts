import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import UpdatePersonFileLogic from '@/service/pim-archives-change/update-person-file-logic';



/**
 * 档案归档地变更记录服务对象基类
 *
 * @export
 * @class PimArchivesChangeServiceBase
 * @extends {EntityServie}
 */
export default class PimArchivesChangeServiceBase extends EntityService {

    /**
     * Creates an instance of  PimArchivesChangeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesChangeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimArchivesChangeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimarchiveschange';
        this.APPDEKEY = 'pimarchiveschangeid';
        this.APPDENAME = 'pimarchiveschanges';
        this.APPDETEXT = 'pimarchiveschangename';
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
     * @memberof PimArchivesChangeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/select`,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/select`,isloading);
        }
            return Http.getInstance().get(`/pimarchiveschanges/${context.pimarchiveschange}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,data,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().put(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimarchiveschanges/${context.pimarchiveschange}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimarchiveschanges/${context.pimarchiveschange}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges`,data,isloading);
        }
        if(context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchiveschanges`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimarchiveschanges`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/getdraft`,isloading);
        }
        if(context.pimarchives && true){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchiveschanges/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimarchiveschanges/getdraft`,isloading);
        res.data.pimarchiveschange = data.pimarchiveschange;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/checkkey`,data,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimarchiveschanges/${context.pimarchiveschange}/checkkey`,data,isloading);
    }

    /**
     * UpdatePersonFile接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async UpdatePersonFile(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/updatepersonfile`,data,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().put(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/updatepersonfile`,data,isloading);
        }
            return Http.getInstance().put(`/pimarchiveschanges/${context.pimarchiveschange}/updatepersonfile`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/save`,data,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimarchiveschanges/${context.pimarchiveschange}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,isloading);
        }
        if(context.pimarchives && context.pimarchiveschange){
            return Http.getInstance().delete(`/pimarchives/${context.pimarchives}/pimarchiveschanges/${context.pimarchiveschange}`,isloading);
        }
            return Http.getInstance().delete(`/pimarchiveschanges/${context.pimarchiveschange}`,isloading);

    }

    /**
     * FetchDADCJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async FetchDADCJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/fetchdadcjl`,tempData,isloading);
        }
        if(context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchiveschanges/fetchdadcjl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchiveschanges/fetchdadcjl`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesChangeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchiveschanges/fetchdefault`,tempData,isloading);
        }
        if(context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchiveschanges/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchiveschanges/fetchdefault`,tempData,isloading);
    }
}