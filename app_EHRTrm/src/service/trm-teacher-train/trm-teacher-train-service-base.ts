import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 讲师授课记录服务对象基类
 *
 * @export
 * @class TrmTeacherTrainServiceBase
 * @extends {EntityServie}
 */
export default class TrmTeacherTrainServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTeacherTrainServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTeacherTrainServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTeacherTrainServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmteachertrain';
        this.APPDEKEY = 'trmteachertrainid';
        this.APPDENAME = 'trmteachertrains';
        this.APPDETEXT = 'trmteachertrainname';
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
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/select`,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}/select`,isloading);
        }
            return Http.getInstance().get(`/trmteachertrains/${context.trmteachertrain}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/save`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmteachertrains/${context.trmteachertrain}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/getdraft`,isloading);
        }
        if(context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/getdraft`,isloading);
        }
        if(context.trmtrainaddress && true){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmteachertrains/getdraft`,isloading);
        res.data.trmteachertrain = data.trmteachertrain;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains`,data,isloading);
        }
        if(context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains`,data,isloading);
        }
        if(context.trmtrainaddress && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmteachertrains`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
            return Http.getInstance().delete(`/trmteachertrains/${context.trmteachertrain}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmteachertrains/${context.trmteachertrain}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmteachertrains/${context.trmteachertrain}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/${context.trmteachertrain}/checkkey`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmteachertrain){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/${context.trmteachertrain}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmteachertrains/${context.trmteachertrain}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherTrainServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachertrains/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainaddress && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmteachertrains/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmteachertrains/fetchdefault`,tempData,isloading);
    }
}