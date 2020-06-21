import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 教育经费服务对象基类
 *
 * @export
 * @class TrmTrainBuapplyServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainBuapplyServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainBuapplyServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainBuapplyServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainBuapplyServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainbuapply';
        this.APPDEKEY = 'trmtrainbuapplyid';
        this.APPDENAME = 'trmtrainbuapplies';
        this.APPDETEXT = 'trmtrainbuapplyname';
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
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainbuapplies/${context.trmtrainbuapply}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies`,data,isloading);
        }
        if(context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtrainbuapplies`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().put(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().put(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainbuapplies/${context.trmtrainbuapply}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/getdraft`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/getdraft`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/getdraft`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/getdraft`,isloading);
        }
        if(context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainbuapplies/getdraft`,isloading);
        res.data.trmtrainbuapply = data.trmtrainbuapply;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainbuapplies/${context.trmtrainbuapply}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().delete(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().delete(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainbuapplies/${context.trmtrainbuapply}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmtrainbuapply){
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainbuapplies/${context.trmtrainbuapply}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainBuapplyServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/fetchdefault`,tempData,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmtrainbuapplies/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainbuapplies/fetchdefault`,tempData,isloading);
    }
}