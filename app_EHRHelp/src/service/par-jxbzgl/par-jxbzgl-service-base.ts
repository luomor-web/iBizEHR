import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 绩效标准管理服务对象基类
 *
 * @export
 * @class ParJxbzglServiceBase
 * @extends {EntityServie}
 */
export default class ParJxbzglServiceBase extends EntityService {

    /**
     * Creates an instance of  ParJxbzglServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParJxbzglServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParJxbzglServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parjxbzgl';
        this.APPDEKEY = 'parjxbzglid';
        this.APPDENAME = 'parjxbzgls';
        this.APPDETEXT = 'parjxbzglname';
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
     * @memberof ParJxbzglServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parjxbzglmxes',JSON.stringify(res.data.parjxbzglmxes));
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/parjxbzgls/getdraft`,isloading);
        res.data.parjxbzgl = data.parjxbzgl;
            this.tempStorage.setItem(context.srfsessionkey+'_parjxbzglmxes',JSON.stringify(res.data.parjxbzglmxes));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parjxbzglmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes'),'undefined')){
            parjxbzglmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes') as any);
            if(parjxbzglmxesData && parjxbzglmxesData.length && parjxbzglmxesData.length > 0){
                parjxbzglmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxbzglmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxbzglmxes = parjxbzglmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parjxbzgls/${context.parjxbzgl}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parjxbzglmxes',JSON.stringify(res.data.parjxbzglmxes));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parjxbzglmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes'),'undefined')){
            parjxbzglmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes') as any);
            if(parjxbzglmxesData && parjxbzglmxesData.length && parjxbzglmxesData.length > 0){
                parjxbzglmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxbzglmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxbzglmxes = parjxbzglmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/parjxbzgls`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parjxbzglmxes',JSON.stringify(res.data.parjxbzglmxes));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parjxbzglmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes'),'undefined')){
            parjxbzglmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parjxbzglmxes') as any);
            if(parjxbzglmxesData && parjxbzglmxesData.length && parjxbzglmxesData.length > 0){
                parjxbzglmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parjxbzglmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parjxbzglmxes = parjxbzglmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parjxbzgls/${context.parjxbzgl}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parjxbzglmxes',JSON.stringify(res.data.parjxbzglmxes));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/parjxbzgls/${context.parjxbzgl}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/parjxbzgls/${context.parjxbzgl}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parjxbzgls/fetchdefault`,tempData,isloading);
    }
}