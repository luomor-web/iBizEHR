import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 社保规则明细服务对象基类
 *
 * @export
 * @class SocRuleDetailServiceBase
 * @extends {EntityServie}
 */
export default class SocRuleDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  SocRuleDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SocRuleDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SocRuleDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='socruledetail';
        this.APPDEKEY = 'socruledetailid';
        this.APPDENAME = 'socruledetails';
        this.APPDETEXT = 'socruledetailname';
        this.APPNAME = 'ehrsoc';
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
     * @memberof SocRuleDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().get(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}/select`,isloading);
        }
            return Http.getInstance().get(`/socruledetails/${context.socruledetail}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && true){
            return Http.getInstance().get(`/socrules/${context.socrule}/socruledetails/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/socruledetails/getdraft`,isloading);
        res.data.socruledetail = data.socruledetail;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().put(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/socruledetails/${context.socruledetail}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().get(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/socruledetails/${context.socruledetail}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/socrules/${context.socrule}/socruledetails`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/socruledetails`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().post(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/socruledetails/${context.socruledetail}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().delete(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}`,isloading);
        }
            return Http.getInstance().delete(`/socruledetails/${context.socruledetail}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && context.socruledetail){
            return Http.getInstance().post(`/socrules/${context.socrule}/socruledetails/${context.socruledetail}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/socruledetails/${context.socruledetail}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.socrule && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/socrules/${context.socrule}/socruledetails/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socruledetails/fetchdefault`,tempData,isloading);
    }
}