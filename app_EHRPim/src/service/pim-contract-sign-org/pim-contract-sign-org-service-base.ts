import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 签约主体单位服务对象基类
 *
 * @export
 * @class PimContractSignOrgServiceBase
 * @extends {EntityServie}
 */
export default class PimContractSignOrgServiceBase extends EntityService {

    /**
     * Creates an instance of  PimContractSignOrgServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimContractSignOrgServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimContractSignOrgServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimcontractsignorg';
        this.APPDEKEY = 'contractsignorgid';
        this.APPDENAME = 'pimcontractsignorgs';
        this.APPDETEXT = 'contractsignorgname';
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
     * @memberof PimContractSignOrgServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}/select`,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}/select`,isloading);
        }
            return Http.getInstance().get(`/pimcontractsignorgs/${context.pimcontractsignorg}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().post(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimcontractsignorgs/${context.pimcontractsignorg}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().put(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,data,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimcontractsignorgs/${context.pimcontractsignorg}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().delete(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);
        }
            return Http.getInstance().delete(`/pimcontractsignorgs/${context.pimcontractsignorg}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs`,data,isloading);
        }
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pimcontractsignorgs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimcontractsignorgs`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && true){
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/getdraft`,isloading);
        }
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pimcontractsignorgs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimcontractsignorgs/getdraft`,isloading);
        res.data.pimcontractsignorg = data.pimcontractsignorg;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && context.pimcontractsignorg){
            return Http.getInstance().post(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/${context.pimcontractsignorg}/save`,data,isloading);
        }
        if(context.ormorg && context.pimcontractsignorg){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pimcontractsignorgs/${context.pimcontractsignorg}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimcontractsignorgs/${context.pimcontractsignorg}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pimcontractsignorgs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontractsignorgs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchDefault2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractSignOrgServiceBase
     */
    public async FetchDefault2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormsignorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormsignorgs/${context.ormsignorg}/pimcontractsignorgs/fetchdefault2`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pimcontractsignorgs/fetchdefault2`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontractsignorgs/fetchdefault2`,tempData,isloading);
    }
}