import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 岗位服务对象基类
 *
 * @export
 * @class OrmPostServiceBase
 * @extends {EntityServie}
 */
export default class OrmPostServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmPostServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmPostServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmPostServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormpost';
        this.APPDEKEY = 'ormpostid';
        this.APPDENAME = 'ormposts';
        this.APPDETEXT = 'ormpostname';
        this.APPNAME = 'ehrorm';
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
     * @memberof OrmPostServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/select`,isloading);
        }
            return Http.getInstance().get(`/ormposts/${context.ormpost}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/save`,data,isloading);
        }
        let masterData:any = {};
        let ormpostdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails'),'undefined')){
            ormpostdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails') as any);
            if(ormpostdetailsData && ormpostdetailsData.length && ormpostdetailsData.length > 0){
                ormpostdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostdetailsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormpostdetails = ormpostdetailsData;
        let ormbmgwbzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs'),'undefined')){
            ormbmgwbzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs') as any);
            if(ormbmgwbzsData && ormbmgwbzsData.length && ormbmgwbzsData.length > 0){
                ormbmgwbzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormbmgwbzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormbmgwbzs = ormbmgwbzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormposts/${context.ormpost}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            this.tempStorage.setItem(context.srfsessionkey+'_ormbmgwbzs',JSON.stringify(res.data.ormbmgwbzs));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormposts/${context.ormpost}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts`,data,isloading);
        }
        let masterData:any = {};
        let ormpostdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails'),'undefined')){
            ormpostdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails') as any);
            if(ormpostdetailsData && ormpostdetailsData.length && ormpostdetailsData.length > 0){
                ormpostdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostdetailsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormpostdetails = ormpostdetailsData;
        let ormbmgwbzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs'),'undefined')){
            ormbmgwbzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs') as any);
            if(ormbmgwbzsData && ormbmgwbzsData.length && ormbmgwbzsData.length > 0){
                ormbmgwbzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormbmgwbzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormbmgwbzs = ormbmgwbzsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormposts`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormbmgwbzs',JSON.stringify(res.data.ormbmgwbzs));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormposts/${context.ormpost}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            this.tempStorage.setItem(context.srfsessionkey+'_ormbmgwbzs',JSON.stringify(res.data.ormbmgwbzs));
            return res;

    }

    /**
     * SetGwJb接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async SetGwJb(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/setgwjb`,data,isloading);
        }
            return Http.getInstance().post(`/ormposts/${context.ormpost}/setgwjb`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}`,data,isloading);
        }
        let masterData:any = {};
        let ormpostdetailsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails'),'undefined')){
            ormpostdetailsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormpostdetails') as any);
            if(ormpostdetailsData && ormpostdetailsData.length && ormpostdetailsData.length > 0){
                ormpostdetailsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormpostdetailsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormpostdetails = ormpostdetailsData;
        let ormbmgwbzsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs'),'undefined')){
            ormbmgwbzsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormbmgwbzs') as any);
            if(ormbmgwbzsData && ormbmgwbzsData.length && ormbmgwbzsData.length > 0){
                ormbmgwbzsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormbmgwbzid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormbmgwbzs = ormbmgwbzsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormposts/${context.ormpost}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            this.tempStorage.setItem(context.srfsessionkey+'_ormbmgwbzs',JSON.stringify(res.data.ormbmgwbzs));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}`,isloading);
        }
            return Http.getInstance().delete(`/ormposts/${context.ormpost}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormposts/getdraft`,isloading);
        res.data.ormpost = data.ormpost;
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            this.tempStorage.setItem(context.srfsessionkey+'_ormbmgwbzs',JSON.stringify(res.data.ormbmgwbzs));
        return res;
    }

    /**
     * FetchEJZZGW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchEJZZGW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchejzzgw`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchejzzgw`,tempData,isloading);
    }

    /**
     * FetchAuthPost接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchAuthPost(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchauthpost`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchauthpost`,tempData,isloading);
    }

    /**
     * FetchCurOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchCurOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchcurorg`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchcurorg`,tempData,isloading);
    }

    /**
     * FetchDQGW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchDQGW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchdqgw`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchdqgw`,tempData,isloading);
    }

    /**
     * FetchDQORGGW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchDQORGGW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchdqorggw`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchdqorggw`,tempData,isloading);
    }

    /**
     * FetchGWXH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchGWXH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchgwxh`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchgwxh`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJZBGWCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchJZBGWCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchjzbgwcx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchjzbgwcx`,tempData,isloading);
    }

    /**
     * FetchCXGW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostServiceBase
     */
    public async FetchCXGW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/fetchcxgw`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormposts/fetchcxgw`,tempData,isloading);
    }
}