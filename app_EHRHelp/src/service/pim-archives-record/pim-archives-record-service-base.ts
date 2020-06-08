import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 档案目录缺失记录服务对象基类
 *
 * @export
 * @class PimArchivesRecordServiceBase
 * @extends {EntityServie}
 */
export default class PimArchivesRecordServiceBase extends EntityService {

    /**
     * Creates an instance of  PimArchivesRecordServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesRecordServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimArchivesRecordServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimarchivesrecord';
        this.APPDEKEY = 'pimarchivesrecordid';
        this.APPDENAME = 'pimarchivesrecords';
        this.APPDETEXT = 'pimarchivesrecordname';
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
     * @memberof PimArchivesRecordServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/select`,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/select`,isloading);
        }
            return Http.getInstance().get(`/pimarchivesrecords/${context.pimarchivesrecord}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords`,data,isloading);
        }
        if(context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesrecords`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimarchivesrecords`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/save`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimarchivesrecords/${context.pimarchivesrecord}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().put(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimarchivesrecords/${context.pimarchivesrecord}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/checkkey`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimarchivesrecords/${context.pimarchivesrecord}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/getdraft`,isloading);
        }
        if(context.pimarchives && true){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesrecords/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimarchivesrecords/getdraft`,isloading);
        res.data.pimarchivesrecord = data.pimarchivesrecord;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);
        }
        if(context.pimarchives && context.pimarchivesrecord){
            return Http.getInstance().delete(`/pimarchives/${context.pimarchives}/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);
        }
            return Http.getInstance().delete(`/pimarchivesrecords/${context.pimarchivesrecord}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchivesRecordServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesrecords/fetchdefault`,tempData,isloading);
        }
        if(context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesrecords/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchivesrecords/fetchdefault`,tempData,isloading);
    }
}