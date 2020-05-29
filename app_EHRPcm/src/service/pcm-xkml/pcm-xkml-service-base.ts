import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 学科目录服务对象基类
 *
 * @export
 * @class PcmXkmlServiceBase
 * @extends {EntityServie}
 */
export default class PcmXkmlServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmXkmlServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmXkmlServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmXkmlServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmxkml';
        this.APPDEKEY = 'pcmxkmlid';
        this.APPDENAME = 'pcmxkmls';
        this.APPDETEXT = 'pcmxkmlname';
        this.APPNAME = 'ehrpcm';
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
     * @memberof PcmXkmlServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmxkmls/${context.pcmxkml}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmxkmls/${context.pcmxkml}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmxkmls`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmxkmls/${context.pcmxkml}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmxkmls/${context.pcmxkml}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmxkmls/getdraft`,isloading);
        res.data.pcmxkml = data.pcmxkml;
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxkmls/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurND接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmXkmlServiceBase
     */
    public async FetchCurND(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmxkmls/fetchcurnd`,tempData,isloading);
    }
}