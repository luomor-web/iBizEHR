import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 年度量化目标（公司领导类）服务对象基类
 *
 * @export
 * @class ParLdndlhmbServiceBase
 * @extends {EntityServie}
 */
export default class ParLdndlhmbServiceBase extends EntityService {

    /**
     * Creates an instance of  ParLdndlhmbServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParLdndlhmbServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParLdndlhmbServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parldndlhmb';
        this.APPDEKEY = 'parldndlhmbid';
        this.APPDENAME = 'parldndlhmbs';
        this.APPDETEXT = 'parldndlhmbname';
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
     * @memberof ParLdndlhmbServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parldndlhmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes'),'undefined')){
            parldndlhmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes') as any);
            if(parldndlhmbmxesData && parldndlhmbmxesData.length && parldndlhmbmxesData.length > 0){
                parldndlhmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parldndlhmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parldndlhmbmxes = parldndlhmbmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parldndlhmbs/${context.parldndlhmb}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parldndlhmbmxes',JSON.stringify(res.data.parldndlhmbmxes));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/parldndlhmbs/getdraft`,isloading);
        res.data.parldndlhmb = data.parldndlhmb;
            this.tempStorage.setItem(context.srfsessionkey+'_parldndlhmbmxes',JSON.stringify(res.data.parldndlhmbmxes));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/parldndlhmbs/${context.parldndlhmb}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parldndlhmbmxes',JSON.stringify(res.data.parldndlhmbmxes));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parldndlhmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes'),'undefined')){
            parldndlhmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes') as any);
            if(parldndlhmbmxesData && parldndlhmbmxesData.length && parldndlhmbmxesData.length > 0){
                parldndlhmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parldndlhmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parldndlhmbmxes = parldndlhmbmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/parldndlhmbs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parldndlhmbmxes',JSON.stringify(res.data.parldndlhmbmxes));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let parldndlhmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes'),'undefined')){
            parldndlhmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_parldndlhmbmxes') as any);
            if(parldndlhmbmxesData && parldndlhmbmxesData.length && parldndlhmbmxesData.length > 0){
                parldndlhmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.parldndlhmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.parldndlhmbmxes = parldndlhmbmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parldndlhmbs/${context.parldndlhmb}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parldndlhmbmxes',JSON.stringify(res.data.parldndlhmbmxes));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/parldndlhmbs/${context.parldndlhmb}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parldndlhmbs/fetchdefault`,tempData,isloading);
    }
}