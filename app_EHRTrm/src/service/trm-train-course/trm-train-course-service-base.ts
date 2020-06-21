import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训课程服务对象基类
 *
 * @export
 * @class TrmTrainCourseServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainCourseServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainCourseServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainCourseServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainCourseServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtraincourse';
        this.APPDEKEY = 'trmtraincourseid';
        this.APPDENAME = 'trmtraincourses';
        this.APPDETEXT = 'trmtraincoursename';
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
     * @memberof TrmTrainCourseServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/select`,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtraincourses/${context.trmtraincourse}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtraincourses/${context.trmtraincourse}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/checkkey`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtraincourses/${context.trmtraincourse}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().delete(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,isloading);
        }
            return Http.getInstance().delete(`/trmtraincourses/${context.trmtraincourse}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/getdraft`,isloading);
        }
        if(context.trmcoursesystem && true){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtraincourses/getdraft`,isloading);
        res.data.trmtraincourse = data.trmtraincourse;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses`,data,isloading);
        }
        if(context.trmcoursesystem && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtraincourses`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().put(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtraincourses/${context.trmtraincourse}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/save`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmtraincourse){
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/${context.trmtraincourse}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtraincourses/${context.trmtraincourse}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainCourseServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmcoursesystem && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/fetchdefault`,tempData,isloading);
        }
        if(context.trmcoursesystem && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmtraincourses/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtraincourses/fetchdefault`,tempData,isloading);
    }
}