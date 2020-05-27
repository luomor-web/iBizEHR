import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 变动申请单（停用）服务对象基类
 *
 * @export
 * @class PCMBDSQDServiceBase
 * @extends {EntityServie}
 */
export default class PCMBDSQDServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMBDSQDServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMBDSQDServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMBDSQDServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmbdsqd';
        this.APPDEKEY = 'pcmbdsqdid';
        this.APPDENAME = 'pcmbdsqds';
        this.APPDETEXT = 'pcmbdsqdname';
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
     * @memberof PCMBDSQDServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmbdsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes'),'undefined')){
            pcmbdsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes') as any);
            if(pcmbdsqdmxesData && pcmbdsqdmxesData.length && pcmbdsqdmxesData.length > 0){
                pcmbdsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmbdsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmbdsqdmxes = pcmbdsqdmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmbdsqds/${context.pcmbdsqd}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmbdsqdmxes',JSON.stringify(res.data.pcmbdsqdmxes));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmbdsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes'),'undefined')){
            pcmbdsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes') as any);
            if(pcmbdsqdmxesData && pcmbdsqdmxesData.length && pcmbdsqdmxesData.length > 0){
                pcmbdsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmbdsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmbdsqdmxes = pcmbdsqdmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmbdsqdmxes',JSON.stringify(res.data.pcmbdsqdmxes));
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmbdsqds/${context.pcmbdsqd}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmbdsqdmxes',JSON.stringify(res.data.pcmbdsqdmxes));
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmbdsqds/getdraft`,isloading);
        res.data.pcmbdsqd = data.pcmbdsqd;
            this.tempStorage.setItem(context.srfsessionkey+'_pcmbdsqdmxes',JSON.stringify(res.data.pcmbdsqdmxes));
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmbdsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes'),'undefined')){
            pcmbdsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmbdsqdmxes') as any);
            if(pcmbdsqdmxesData && pcmbdsqdmxesData.length && pcmbdsqdmxesData.length > 0){
                pcmbdsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmbdsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmbdsqdmxes = pcmbdsqdmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmbdsqds`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmbdsqdmxes',JSON.stringify(res.data.pcmbdsqdmxes));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmbdsqds/${context.pcmbdsqd}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmbdsqds/${context.pcmbdsqd}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMBDSQDServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmbdsqds/fetchdefault`,tempData,isloading);
    }
}