import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织地址维护服务对象基类
 *
 * @export
 * @class OrmOrgdzServiceBase
 * @extends {EntityServie}
 */
export default class OrmOrgdzServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmOrgdzServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgdzServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmOrgdzServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormorgdz';
        this.APPDEKEY = 'ormorgdzid';
        this.APPDENAME = 'ormorgdzs';
        this.APPDETEXT = 'ormorgdzname';
        this.APPNAME = 'ehrorm';
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
     * @memberof OrmOrgdzServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}/select`,isloading);
        }
            return Http.getInstance().get(`/ormorgdzs/${context.ormorgdz}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormorgdzs/${context.ormorgdz}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgdzs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormorgdzs/getdraft`,isloading);
        res.data.ormorgdz = data.ormorgdz;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}`,isloading);
        }
            return Http.getInstance().delete(`/ormorgdzs/${context.ormorgdz}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormorgdzs/${context.ormorgdz}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgdzs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormorgdzs`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormorgdzs/${context.ormorgdz}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgdz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgdzs/${context.ormorgdz}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgdzs/${context.ormorgdz}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgdzServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgdzs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgdzs/fetchdefault`,tempData,isloading);
    }
}