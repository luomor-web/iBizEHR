import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门职务编制服务对象基类
 *
 * @export
 * @class OrmDepEstManServiceBase
 * @extends {EntityServie}
 */
export default class OrmDepEstManServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmDepEstManServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmDepEstManServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmDepEstManServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormdepestman';
        this.APPDEKEY = 'ormdepestmanid';
        this.APPDENAME = 'ormdepestmen';
        this.APPDETEXT = 'ormdepestmanname';
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
     * @memberof OrmDepEstManServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/select`,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/select`,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}/select`,isloading);
        }
            return Http.getInstance().get(`/ormdepestmen/${context.ormdepestman}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/getdraft`,isloading);
        }
        if(context.ormduty && true){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/ormdepestmen/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormdepestmen/getdraft`,isloading);
        res.data.ormdepestman = data.ormdepestman;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/checkkey`,data,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().post(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormdepestmen/${context.ormdepestman}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormdepestmen`,data,isloading);
        }
        if(context.ormduty && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormduties/${context.ormduty}/ormdepestmen`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormdepestmen`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormdepestmen/${context.ormdepestman}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().delete(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}`,isloading);
        }
            return Http.getInstance().delete(`/ormdepestmen/${context.ormdepestman}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,data,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}`,data,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().put(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormdepestmen/${context.ormdepestman}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormdepestman){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/save`,data,isloading);
        }
        if(context.ormorgsector && context.ormdepestman){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/${context.ormdepestman}/save`,data,isloading);
        }
        if(context.ormduty && context.ormdepestman){
            return Http.getInstance().post(`/ormduties/${context.ormduty}/ormdepestmen/${context.ormdepestman}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormdepestmen/${context.ormdepestman}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDepEstManServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormdepestmen/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormdepestmen/fetchdefault`,tempData,isloading);
        }
        if(context.ormduty && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormduties/${context.ormduty}/ormdepestmen/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormdepestmen/fetchdefault`,tempData,isloading);
    }
}