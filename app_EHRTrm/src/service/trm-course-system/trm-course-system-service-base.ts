import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训模块服务对象基类
 *
 * @export
 * @class TrmCourseSystemServiceBase
 * @extends {EntityServie}
 */
export default class TrmCourseSystemServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmCourseSystemServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmCourseSystemServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmCourseSystemServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmcoursesystem';
        this.APPDEKEY = 'trmcoursesystemid';
        this.APPDENAME = 'trmcoursesystems';
        this.APPDETEXT = 'trmcoursesystemname';
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
     * @memberof TrmCourseSystemServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/select`,isloading);
        }
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmcoursesystems/${context.trmcoursesystem}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/save`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmcoursesystems/getdraft`,isloading);
        res.data.trmcoursesystem = data.trmcoursesystem;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}`,isloading);
        }
            return Http.getInstance().delete(`/trmcoursesystems/${context.trmcoursesystem}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmcoursesystems`,data,isloading);
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCourseSystemServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmcoursesystems/fetchdefault`,tempData,isloading);
    }
}