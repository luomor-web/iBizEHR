import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 问题收集服务对象基类
 *
 * @export
 * @class QUESTIONSServiceBase
 * @extends {EntityServie}
 */
export default class QUESTIONSServiceBase extends EntityService {

    /**
     * Creates an instance of  QUESTIONSServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  QUESTIONSServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof QUESTIONSServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='questions';
        this.APPDEKEY = 'questionsid';
        this.APPDENAME = 'questions';
        this.APPDETEXT = 'questionsname';
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
     * @memberof QUESTIONSServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/questions/${context.questions}/select`,isloading);
    }

    /**
     * SelectTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async SelectTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        // URI参数传递情况未实现
    }

    /**
     * RemoveTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async RemoveTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/questions/${context.questions}/removetemp`,isloading);

    }

    /**
     * GetTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async GetTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/questions/${context.questions}/gettemp`,isloading);
            return res;

    }

    /**
     * GetDraftTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async GetDraftTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/questions/${context.questions}/getdrafttempmajor`,isloading);
            return res;

    }

    /**
     * UpdateTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async UpdateTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/questions/${context.questions}/updatetemp`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/questions/${context.questions}/save`,data,isloading);
            return res;
    }

    /**
     * CreateTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async CreateTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/questions/${context.questions}/createtempmajor`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/questions/${context.questions}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/questions/${context.questions}`,isloading);
            return res;

    }

    /**
     * UpdateTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async UpdateTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/questions/${context.questions}/updatetempmajor`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/questions/${context.questions}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/questions/${context.questions}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/questions`,data,isloading);
        return res;
    }

    /**
     * GetTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async GetTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/questions/${context.questions}/gettempmajor`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/questions/getdraft`,isloading);
        res.data.questions = data.questions;
        return res;
    }

    /**
     * CreateTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async CreateTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/questions/${context.questions}/createtemp`,data,isloading);
    }

    /**
     * RemoveTempMajor接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async RemoveTempMajor(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/questions/${context.questions}/removetempmajor`,isloading);

    }

    /**
     * GetDraftTemp接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async GetDraftTemp(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/questions/getdrafttemp`,isloading);
        res.data.questions = data.questions;
        return res;
    }

    /**
     * FetchQUERYcurrentQUESTION接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async FetchQUERYcurrentQUESTION(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/questions/fetchquerycurrentquestion`,tempData,isloading);
    }

    /**
     * FetchTempQUERYcurrentQUESTION接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async FetchTempQUERYcurrentQUESTION(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/questions/fetchtempquerycurrentquestion`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/questions/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchTempDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof QUESTIONSServiceBase
     */
    public async FetchTempDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/questions/fetchtempdefault`,data,isloading);
    }
}