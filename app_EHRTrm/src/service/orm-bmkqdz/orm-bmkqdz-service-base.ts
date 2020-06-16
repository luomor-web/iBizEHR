import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门地址维护服务对象基类
 *
 * @export
 * @class OrmBmkqdzServiceBase
 * @extends {EntityServie}
 */
export default class OrmBmkqdzServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmBmkqdzServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmBmkqdzServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmBmkqdzServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormbmkqdz';
        this.APPDEKEY = 'ormbmkqdzid';
        this.APPDENAME = 'ormbmkqdzs';
        this.APPDETEXT = 'ormbmkqdzname';
        this.APPNAME = 'ehrtrm';
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
     * @memberof OrmBmkqdzServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/select`,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/select`,isloading);
        }
            return Http.getInstance().get(`/ormbmkqdzs/${context.ormbmkqdz}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,isloading);
        }
            return Http.getInstance().delete(`/ormbmkqdzs/${context.ormbmkqdz}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormbmkqdzs/getdraft`,isloading);
        res.data.ormbmkqdz = data.ormbmkqdz;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormbmkqdzs/${context.ormbmkqdz}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/save`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormbmkqdzs/${context.ormbmkqdz}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormbmkqdzs/${context.ormbmkqdz}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormbmkqdzs`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,isloading);
        }
        if(context.ormorgsector && context.ormbmkqdz){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/${context.ormbmkqdz}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormbmkqdzs/${context.ormbmkqdz}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmkqdzServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmkqdzs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormbmkqdzs/fetchdefault`,tempData,isloading);
    }
}