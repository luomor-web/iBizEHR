import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 见习生员工转正考核结果记录服务对象基类
 *
 * @export
 * @class PcmJxszzkhjgjlServiceBase
 * @extends {EntityServie}
 */
export default class PcmJxszzkhjgjlServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmJxszzkhjgjlServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmJxszzkhjgjlServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmjxszzkhjgjl';
        this.APPDEKEY = 'pcmjxszzkhjgjlid';
        this.APPDENAME = 'pcmjxszzkhjgjls';
        this.APPDETEXT = 'pcmjxszzkhjgjlname';
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
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmjxszzkhjgjls/getdraft`,isloading);
        res.data.pcmjxszzkhjgjl = data.pcmjxszzkhjgjl;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmjxszzkhjgjls`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmjxszzkhjgjls/${context.pcmjxszzkhjgjl}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmJxszzkhjgjlServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmjxszzkhjgjls/fetchdefault`,tempData,isloading);
    }
}