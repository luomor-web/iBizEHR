import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 岗位库服务对象基类
 *
 * @export
 * @class OrmPostLibServiceBase
 * @extends {EntityServie}
 */
export default class OrmPostLibServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmPostLibServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmPostLibServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmPostLibServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormpostlib';
        this.APPDEKEY = 'ormpostlibid';
        this.APPDENAME = 'ormpostlibs';
        this.APPDETEXT = 'ormpostlibname';
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
     * @memberof OrmPostLibServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormpostlibs/${context.ormpostlib}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormpostlibs/${context.ormpostlib}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormpostlibs/${context.ormpostlib}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormpostlibs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormpostlibs/getdraft`,isloading);
        res.data.ormpostlib = data.ormpostlib;
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormpostdetails',JSON.stringify(res.data.ormpostdetails));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormpostlibs/${context.ormpostlib}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostLibServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormpostlibs/fetchdefault`,tempData,isloading);
    }
}