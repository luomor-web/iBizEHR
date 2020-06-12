import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 薪酬要素项服务对象基类
 *
 * @export
 * @class SalItemServiceBase
 * @extends {EntityServie}
 */
export default class SalItemServiceBase extends EntityService {

    /**
     * Creates an instance of  SalItemServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SalItemServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SalItemServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='salitem';
        this.APPDEKEY = 'salitemid';
        this.APPDENAME = 'salitems';
        this.APPDETEXT = 'salitemname';
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
     * @memberof SalItemServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/salitems/${context.salitem}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/salitems/${context.salitem}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/salitems/${context.salitem}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let salschemeitemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems'),'undefined')){
            salschemeitemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems') as any);
            if(salschemeitemsData && salschemeitemsData.length && salschemeitemsData.length > 0){
                salschemeitemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.salschemeitemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.salschemeitems = salschemeitemsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/salitems/${context.salitem}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/salitems/getdraft`,isloading);
        res.data.salitem = data.salitem;
            this.tempStorage.setItem(context.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/salitems/${context.salitem}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let salschemeitemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems'),'undefined')){
            salschemeitemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems') as any);
            if(salschemeitemsData && salschemeitemsData.length && salschemeitemsData.length > 0){
                salschemeitemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.salschemeitemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.salschemeitems = salschemeitemsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/salitems/${context.salitem}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let salschemeitemsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems'),'undefined')){
            salschemeitemsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_salschemeitems') as any);
            if(salschemeitemsData && salschemeitemsData.length && salschemeitemsData.length > 0){
                salschemeitemsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.salschemeitemid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.salschemeitems = salschemeitemsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/salitems`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalItemServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/salitems/fetchdefault`,tempData,isloading);
    }
}