import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考勤部门服务对象基类
 *
 * @export
 * @class AttEndenceOrmorgscetorServiceBase
 * @extends {EntityServie}
 */
export default class AttEndenceOrmorgscetorServiceBase extends EntityService {

    /**
     * Creates an instance of  AttEndenceOrmorgscetorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndenceOrmorgscetorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='attendenceormorgscetor';
        this.APPDEKEY = 'attendenceormorgsectorid';
        this.APPDENAME = 'attendenceormorgscetors';
        this.APPDETEXT = 'attendenceormorgsectorname';
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
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}/select`,isloading);
        }
            return Http.getInstance().get(`/attendenceormorgscetors/${context.attendenceormorgscetor}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/attendenceormorgscetors/${context.attendenceormorgscetor}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/attendenceormorgscetors`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().put(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/attendenceormorgscetors/${context.attendenceormorgscetor}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/attendenceormorgscetors/${context.attendenceormorgscetor}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().delete(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}`,isloading);
        }
            return Http.getInstance().delete(`/attendenceormorgscetors/${context.attendenceormorgscetor}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/attendenceormorgscetors/getdraft`,isloading);
        res.data.attendenceormorgscetor = data.attendenceormorgscetor;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && context.attendenceormorgscetor){
            return Http.getInstance().post(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/${context.attendenceormorgscetor}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/attendenceormorgscetors/${context.attendenceormorgscetor}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AttEndenceOrmorgscetorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.attendencesetup && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/attendencesetups/${context.attendencesetup}/attendenceormorgscetors/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/attendenceormorgscetors/fetchdefault`,tempData,isloading);
    }
}