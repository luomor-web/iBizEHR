import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核模板服务对象基类
 *
 * @export
 * @class ParAssessTemplateServiceBase
 * @extends {EntityServie}
 */
export default class ParAssessTemplateServiceBase extends EntityService {

    /**
     * Creates an instance of  ParAssessTemplateServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParAssessTemplateServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParAssessTemplateServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parassesstemplate';
        this.APPDEKEY = 'parassesstemplateid';
        this.APPDENAME = 'parassesstemplates';
        this.APPDETEXT = 'parassesstemplatename';
        this.APPNAME = 'ehrpar';
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
     * @memberof ParAssessTemplateServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/parassesstemplates/${context.parassesstemplate}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/parassesstemplates/getdraft`,isloading);
        res.data.parassesstemplate = data.parassesstemplate;
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parjxkhxhzs',JSON.stringify(res.data.parjxkhxhzs));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parjxkhxhzs',JSON.stringify(res.data.parjxkhxhzs));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parkhzcmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes'),'undefined')){
            parkhzcmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes') as any);
            if(parkhzcmxesData && parkhzcmxesData.length && parkhzcmxesData.length > 0){
                parkhzcmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parkhzcmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parkhzcmxes = parkhzcmxesData;
        let parjxkhxhzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs'),'undefined')){
            parjxkhxhzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs') as any);
            if(parjxkhxhzsData && parjxkhxhzsData.length && parjxkhxhzsData.length > 0){
                parjxkhxhzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxkhxhzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxkhxhzs = parjxkhxhzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parassesstemplates/${context.parassesstemplate}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parjxkhxhzs',JSON.stringify(res.data.parjxkhxhzs));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parkhzcmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes'),'undefined')){
            parkhzcmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes') as any);
            if(parkhzcmxesData && parkhzcmxesData.length && parkhzcmxesData.length > 0){
                parkhzcmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parkhzcmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parkhzcmxes = parkhzcmxesData;
        let parjxkhxhzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs'),'undefined')){
            parjxkhxhzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs') as any);
            if(parjxkhxhzsData && parjxkhxhzsData.length && parjxkhxhzsData.length > 0){
                parjxkhxhzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxkhxhzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxkhxhzs = parjxkhxhzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_parjxkhxhzs',JSON.stringify(res.data.parjxkhxhzs));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parkhzcmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes'),'undefined')){
            parkhzcmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parkhzcmxes') as any);
            if(parkhzcmxesData && parkhzcmxesData.length && parkhzcmxesData.length > 0){
                parkhzcmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parkhzcmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parkhzcmxes = parkhzcmxesData;
        let parjxkhxhzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs'),'undefined')){
            parjxkhxhzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxkhxhzs') as any);
            if(parjxkhxhzsData && parjxkhxhzsData.length && parjxkhxhzsData.length > 0){
                parjxkhxhzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxkhxhzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxkhxhzs = parjxkhxhzsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/parassesstemplates`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parjxkhxhzs',JSON.stringify(res.data.parjxkhxhzs));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParAssessTemplateServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parassesstemplates/fetchdefault`,tempData,isloading);
    }
}