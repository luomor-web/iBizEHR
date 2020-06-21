import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import InitRuleDetailLogic from '@/service/soc-rule/init-rule-detail-logic';



/**
 * 社保规则服务对象基类
 *
 * @export
 * @class SocRuleServiceBase
 * @extends {EntityServie}
 */
export default class SocRuleServiceBase extends EntityService {

    /**
     * Creates an instance of  SocRuleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SocRuleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SocRuleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='socrule';
        this.APPDEKEY = 'socruleid';
        this.APPDENAME = 'socrules';
        this.APPDETEXT = 'socrulename';
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
     * @memberof SocRuleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/socrules/${context.socrule}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/socrules/${context.socrule}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socruledetails',JSON.stringify(res.data.socruledetails));
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/socrules/getdraft`,isloading);
        res.data.socrule = data.socrule;
            this.tempStorage.setItem(context.srfsessionkey+'_socruledetails',JSON.stringify(res.data.socruledetails));
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let socruledetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails'),'undefined')){
            socruledetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails') as any);
            if(socruledetailsData && socruledetailsData.length && socruledetailsData.length > 0){
                socruledetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socruledetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socruledetails = socruledetailsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/socrules`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_socruledetails',JSON.stringify(res.data.socruledetails));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let socruledetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails'),'undefined')){
            socruledetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails') as any);
            if(socruledetailsData && socruledetailsData.length && socruledetailsData.length > 0){
                socruledetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socruledetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socruledetails = socruledetailsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/socrules/${context.socrule}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socruledetails',JSON.stringify(res.data.socruledetails));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let socruledetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails'),'undefined')){
            socruledetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_socruledetails') as any);
            if(socruledetailsData && socruledetailsData.length && socruledetailsData.length > 0){
                socruledetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.socruledetailid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.socruledetails = socruledetailsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/socrules/${context.socrule}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_socruledetails',JSON.stringify(res.data.socruledetails));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/socrules/${context.socrule}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/socrules/${context.socrule}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRuleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socrules/fetchdefault`,tempData,isloading);
    }
}