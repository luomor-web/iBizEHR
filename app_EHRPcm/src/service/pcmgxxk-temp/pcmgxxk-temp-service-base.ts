import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 高校学科中间表服务对象基类
 *
 * @export
 * @class PCMGxxkTempServiceBase
 * @extends {EntityServie}
 */
export default class PCMGxxkTempServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMGxxkTempServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMGxxkTempServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMGxxkTempServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmgxxktemp';
        this.APPDEKEY = 'pcmgxxktempid';
        this.APPDENAME = 'pcmgxxktemps';
        this.APPDETEXT = 'pcmgxxktempname';
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
     * @memberof PCMGxxkTempServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}/select`,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmgxxktemps/${context.pcmgxxktemp}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && true){
            return Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/getdraft`,isloading);
        }
        if(context.pcmgxml && true){
            return Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmgxxktemps/getdraft`,isloading);
        res.data.pcmgxxktemp = data.pcmgxxktemp;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps`,data,isloading);
        }
        if(context.pcmgxml && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmgxxktemps`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().delete(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().delete(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
        }
            return Http.getInstance().delete(`/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().post(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}/checkkey`,data,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().post(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmgxxktemps/${context.pcmgxxktemp}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().post(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}/save`,data,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().post(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmgxxktemps/${context.pcmgxxktemp}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && context.pcmgxxktemp){
            return Http.getInstance().put(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/${context.pcmgxxktemp}`,data,isloading);
        }
        if(context.pcmgxml && context.pcmgxxktemp){
            return Http.getInstance().put(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/${context.pcmgxxktemp}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmgxxktemps/${context.pcmgxxktemp}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGxxkTempServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmxkml && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmxkmls/${context.pcmxkml}/pcmgxxktemps/fetchdefault`,tempData,isloading);
        }
        if(context.pcmgxml && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}/pcmgxxktemps/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmgxxktemps/fetchdefault`,tempData,isloading);
    }
}