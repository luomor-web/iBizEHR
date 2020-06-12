import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核方案服务对象基类
 *
 * @export
 * @class ParJxkhjcszServiceBase
 * @extends {EntityServie}
 */
export default class ParJxkhjcszServiceBase extends EntityService {

    /**
     * Creates an instance of  ParJxkhjcszServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParJxkhjcszServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParJxkhjcszServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parjxkhjcsz';
        this.APPDEKEY = 'parjxkhjcszid';
        this.APPDENAME = 'parjxkhjcszs';
        this.APPDETEXT = 'parjxkhjcszname';
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
     * @memberof ParJxkhjcszServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parjxkhjcszs/${context.parjxkhjcsz}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/parjxkhjcszs/getdraft`,isloading);
        res.data.parjxkhjcsz = data.parjxkhjcsz;
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/parjxkhjcszs/${context.parjxkhjcsz}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/parjxkhjcszs/${context.parjxkhjcsz}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parjxkhjcszs/${context.parjxkhjcsz}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
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
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/parjxkhjcszs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_parkhzcmxes',JSON.stringify(res.data.parkhzcmxes));
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhjcszServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parjxkhjcszs/fetchdefault`,tempData,isloading);
    }
}