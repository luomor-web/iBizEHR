import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工资单服务对象基类
 *
 * @export
 * @class SalSchemeServiceBase
 * @extends {EntityServie}
 */
export default class SalSchemeServiceBase extends EntityService {

    /**
     * Creates an instance of  SalSchemeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSchemeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SalSchemeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='salscheme';
        this.APPDEKEY = 'salschemeid';
        this.APPDENAME = 'salschemes';
        this.APPDETEXT = 'salschemename';
        this.APPNAME = 'ehrsal';
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
     * @memberof SalSchemeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/salschemes/${context.salscheme}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalSchemeServiceBase
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
        let res:any = await Http.getInstance().post(`/salschemes`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalSchemeServiceBase
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
            let res:any = await  Http.getInstance().put(`/salschemes/${context.salscheme}`,data,isloading);
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
     * @memberof SalSchemeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/salschemes/getdraft`,isloading);
        res.data.salscheme = data.salscheme;
            this.tempStorage.setItem(context.srfsessionkey+'_salschemeitems',JSON.stringify(res.data.salschemeitems));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalSchemeServiceBase
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
            let res:any = await  Http.getInstance().post(`/salschemes/${context.salscheme}/save`,data,isloading);
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
     * @memberof SalSchemeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/salschemes/${context.salscheme}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalSchemeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/salschemes/${context.salscheme}`,isloading);
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
     * @memberof SalSchemeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/salschemes/${context.salscheme}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SalSchemeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/salschemes/fetchdefault`,tempData,isloading);
    }
}