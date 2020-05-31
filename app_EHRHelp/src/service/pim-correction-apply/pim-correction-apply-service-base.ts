import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * B/Y类员工转正申请明细（停用）服务对象基类
 *
 * @export
 * @class PimCorrectionApplyServiceBase
 * @extends {EntityServie}
 */
export default class PimCorrectionApplyServiceBase extends EntityService {

    /**
     * Creates an instance of  PimCorrectionApplyServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimCorrectionApplyServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimCorrectionApplyServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimcorrectionapply';
        this.APPDEKEY = 'pimcorrectionapplyid';
        this.APPDENAME = 'pimcorrectionapplies';
        this.APPDETEXT = 'pimcorrectionapplyname';
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
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}/select`,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}/select`,isloading);
        }
            return Http.getInstance().get(`/pimcorrectionapplies/${context.pimcorrectionapply}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcorrectionapplies`,data,isloading);
        }
        if(context.pimbyygzzsq && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimcorrectionapplies`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcorrectionapplies/getdraft`,isloading);
        }
        if(context.pimbyygzzsq && true){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimcorrectionapplies/getdraft`,isloading);
        res.data.pimcorrectionapply = data.pimcorrectionapply;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}/checkkey`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimcorrectionapplies/${context.pimcorrectionapply}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}/save`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimcorrectionapplies/${context.pimcorrectionapply}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().put(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimcorrectionapplies/${context.pimcorrectionapply}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcorrectionapply){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);
        }
        if(context.pimbyygzzsq && context.pimcorrectionapply){
            return Http.getInstance().delete(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);
        }
            return Http.getInstance().delete(`/pimcorrectionapplies/${context.pimcorrectionapply}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimCorrectionApplyServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcorrectionapplies/fetchdefault`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimcorrectionapplies/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcorrectionapplies/fetchdefault`,tempData,isloading);
    }
}