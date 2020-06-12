import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 调动申请单服务对象基类
 *
 * @export
 * @class PcmDdsqdServiceBase
 * @extends {EntityServie}
 */
export default class PcmDdsqdServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmDdsqdServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmDdsqdServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmDdsqdServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmddsqd';
        this.APPDEKEY = 'pcmddsqdid';
        this.APPDENAME = 'pcmddsqds';
        this.APPDETEXT = 'pcmddsqdname';
        this.APPNAME = 'ehrpcm2';
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
     * @memberof PcmDdsqdServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmddsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes'),'undefined')){
            pcmddsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes') as any);
            if(pcmddsqdmxesData && pcmddsqdmxesData.length && pcmddsqdmxesData.length > 0){
                pcmddsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmddsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmddsqdmxes = pcmddsqdmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmddsqds`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmddsqdmxes',JSON.stringify(res.data.pcmddsqdmxes));
        return res;
    }

    /**
     * PDD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async PDD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pdd`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmddsqdmxes',JSON.stringify(res.data.pcmddsqdmxes));
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmddsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes'),'undefined')){
            pcmddsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes') as any);
            if(pcmddsqdmxesData && pcmddsqdmxesData.length && pcmddsqdmxesData.length > 0){
                pcmddsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmddsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmddsqdmxes = pcmddsqdmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmddsqds/${context.pcmddsqd}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmddsqdmxes',JSON.stringify(res.data.pcmddsqdmxes));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmddsqdmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes'),'undefined')){
            pcmddsqdmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmddsqdmxes') as any);
            if(pcmddsqdmxesData && pcmddsqdmxesData.length && pcmddsqdmxesData.length > 0){
                pcmddsqdmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmddsqdmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmddsqdmxes = pcmddsqdmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmddsqdmxes',JSON.stringify(res.data.pcmddsqdmxes));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmddsqds/${context.pcmddsqd}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmddsqds/getdraft`,isloading);
        res.data.pcmddsqd = data.pcmddsqd;
            this.tempStorage.setItem(context.srfsessionkey+'_pcmddsqdmxes',JSON.stringify(res.data.pcmddsqdmxes));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqds/fetchdefault`,tempData,isloading);
    }
}