import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import CalContractTimeLogic from '@/service/pim-contract/cal-contract-time-logic';



/**
 * 合同信息服务对象基类
 *
 * @export
 * @class PimContractServiceBase
 * @extends {EntityServie}
 */
export default class PimContractServiceBase extends EntityService {

    /**
     * Creates an instance of  PimContractServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimContractServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimContractServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimcontract';
        this.APPDEKEY = 'pimcontractid';
        this.APPDENAME = 'pimcontracts';
        this.APPDETEXT = 'pimpersonname';
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
     * @memberof PimContractServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}/select`,isloading);
        }
            return Http.getInstance().get(`/pimcontracts/${context.pimcontract}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimcontracts/${context.pimcontract}/checkkey`,data,isloading);
    }

    /**
     * CalContractTime接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async CalContractTime(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}/calcontracttime`,data,isloading);
        }
            return Http.getInstance().post(`/pimcontracts/${context.pimcontract}/calcontracttime`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}`,isloading);
        }
            return Http.getInstance().delete(`/pimcontracts/${context.pimcontract}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimcontracts/${context.pimcontract}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcontracts`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimcontracts`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimcontracts/${context.pimcontract}/save`,data,isloading);
            return res;
    }

    /**
     * StopContract接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async StopContract(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}/stopcontract`,data,isloading);
        }
            return Http.getInstance().post(`/pimcontracts/${context.pimcontract}/stopcontract`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimcontract){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimcontracts/${context.pimcontract}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimcontracts/${context.pimcontract}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimcontracts/getdraft`,isloading);
        res.data.pimcontract = data.pimcontract;
        return res;
    }

    /**
     * FetchRSTXDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchRSTXDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchrstxds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchrstxds`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchjlss`,tempData,isloading);
    }

    /**
     * FetchOrderByOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchOrderByOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchorderbyorg`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchorderbyorg`,tempData,isloading);
    }

    /**
     * FetchStopContracts接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchStopContracts(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchstopcontracts`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchstopcontracts`,tempData,isloading);
    }

    /**
     * FetchSignContracts接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchSignContracts(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchsigncontracts`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchsigncontracts`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchXYHT接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchXYHT(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchxyht`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchxyht`,tempData,isloading);
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchLDHT接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchLDHT(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchldht`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchldht`,tempData,isloading);
    }

    /**
     * FetchLWHT接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimContractServiceBase
     */
    public async FetchLWHT(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimcontracts/fetchlwht`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimcontracts/fetchlwht`,tempData,isloading);
    }
}