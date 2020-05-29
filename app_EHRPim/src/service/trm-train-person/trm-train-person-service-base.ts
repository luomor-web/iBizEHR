import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训记录服务对象基类
 *
 * @export
 * @class TrmTrainPersonServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainPersonServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainPersonServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainPersonServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainPersonServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainperson';
        this.APPDEKEY = 'trmtrianpersonid';
        this.APPDENAME = 'trmtrainpeople';
        this.APPDETEXT = 'trmtrianpersonname';
        this.APPNAME = 'ehrpim';
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
     * @memberof TrmTrainPersonServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainpeople/${context.trmtrainperson}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainpeople/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainpeople/getdraft`,isloading);
        res.data.trmtrainperson = data.trmtrainperson;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainpeople/${context.trmtrainperson}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainpeople/${context.trmtrainperson}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainpeople/${context.trmtrainperson}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainpeople`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtrainpeople`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainpeople/${context.trmtrainperson}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainperson){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrainpeople/${context.trmtrainperson}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainpeople/${context.trmtrainperson}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPersonServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainpeople/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainpeople/fetchdefault`,tempData,isloading);
    }
}