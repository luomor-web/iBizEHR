import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门岗位编制服务对象基类
 *
 * @export
 * @class OrmBmgwbzServiceBase
 * @extends {EntityServie}
 */
export default class OrmBmgwbzServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmBmgwbzServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmBmgwbzServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmBmgwbzServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormbmgwbz';
        this.APPDEKEY = 'ormbmgwbzid';
        this.APPDENAME = 'ormbmgwbzs';
        this.APPDETEXT = 'ormbmgwbzname';
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
     * @memberof OrmBmgwbzServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/select`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/select`,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/select`,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/select`,isloading);
        }
            return Http.getInstance().get(`/ormbmgwbzs/${context.ormbmgwbz}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs`,data,isloading);
        }
        if(context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormbmgwbzs`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormbmgwbzs`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/checkkey`,data,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormbmgwbzs/${context.ormbmgwbz}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/save`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/save`,data,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}/save`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormbmgwbzs/${context.ormbmgwbz}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,data,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().put(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,data,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormbmgwbzs/${context.ormbmgwbz}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/getdraft`,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/getdraft`,isloading);
        }
        if(context.ormpost && true){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormbmgwbzs/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormbmgwbzs/getdraft`,isloading);
        res.data.ormbmgwbz = data.ormbmgwbz;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormbmgwbz){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormpost && context.ormbmgwbz){
            return Http.getInstance().delete(`/ormposts/${context.ormpost}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
        if(context.ormorgsector && context.ormbmgwbz){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/${context.ormbmgwbz}`,isloading);
        }
            return Http.getInstance().delete(`/ormbmgwbzs/${context.ormbmgwbz}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmBmgwbzServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormbmgwbzs/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/fetchdefault`,tempData,isloading);
        }
        if(context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormbmgwbzs/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormbmgwbzs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormbmgwbzs/fetchdefault`,tempData,isloading);
    }
}