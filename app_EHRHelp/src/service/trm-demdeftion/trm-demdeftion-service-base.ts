import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训需求汇总服务对象基类
 *
 * @export
 * @class TrmDemdeftionServiceBase
 * @extends {EntityServie}
 */
export default class TrmDemdeftionServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmDemdeftionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmDemdeftionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmDemdeftionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmdemdeftion';
        this.APPDEKEY = 'trmdemdeftionid';
        this.APPDENAME = 'trmdemdeftions';
        this.APPDETEXT = 'trmdemdeftionname';
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
     * @memberof TrmDemdeftionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
        }
            return Http.getInstance().get(`/trmdemdeftions/${context.trmdemdeftion}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/getdraft`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && true){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/getdraft`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/getdraft`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/getdraft`,isloading);
        }
        if(context.trmtrainfillin && true){
            return Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmdemdeftions/getdraft`,isloading);
        res.data.trmdemdeftion = data.trmdemdeftion;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions`,data,isloading);
        }
        if(context.trmtrainfillin && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmdemdeftions`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().put(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().put(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmdemdeftions/${context.trmdemdeftion}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().delete(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().delete(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
            return Http.getInstance().delete(`/trmdemdeftions/${context.trmdemdeftion}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmdemdeftions/${context.trmdemdeftion}/save`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().post(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmdemdeftions/${context.trmdemdeftion}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
        if(context.trmtrainfillin && context.trmdemdeftion){
            return Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/${context.trmdemdeftion}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmdemdeftions/${context.trmdemdeftion}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmDemdeftionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.trmtrainfillin && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/fetchdefault`,tempData,isloading);
        }
        if(context.trmdepart && context.trmtrainfillin && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmdeparts/${context.trmdepart}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && context.trmtrainfillin && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && context.trmtrainfillin && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainfillin && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainfillins/${context.trmtrainfillin}/trmdemdeftions/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmdemdeftions/fetchdefault`,tempData,isloading);
    }
}