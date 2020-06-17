import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训设施服务对象基类
 *
 * @export
 * @class TrmTrainFaciesServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainFaciesServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainFaciesServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainFaciesServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainFaciesServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainfacies';
        this.APPDEKEY = 'trmtrainfaciesid';
        this.APPDENAME = 'trmtrainfacies';
        this.APPDETEXT = 'trmtrainfaciesname';
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
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainfacies/${context.trmtrainfacies}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainfacies/${context.trmtrainfacies}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainfacies/getdraft`,isloading);
        res.data.trmtrainfacies = data.trmtrainfacies;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainfacies/${context.trmtrainfacies}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtrainfacies`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainfacies/${context.trmtrainfacies}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainfacies/${context.trmtrainfacies}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtrainfacies){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/${context.trmtrainfacies}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainfacies/${context.trmtrainfacies}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainFaciesServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtrainfacies/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainfacies/fetchdefault`,tempData,isloading);
    }
}