import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 岗位明细服务对象基类
 *
 * @export
 * @class OrmPostDetailsServiceBase
 * @extends {EntityServie}
 */
export default class OrmPostDetailsServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmPostDetailsServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmPostDetailsServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmPostDetailsServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormpostdetails';
        this.APPDEKEY = 'ormpostdetailsid';
        this.APPDENAME = 'ormpostdetails';
        this.APPDETEXT = 'ormpostdetailsname';
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
     * @memberof OrmPostDetailsServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/select`,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/select`,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}/select`,isloading);
        }
            return Http.getInstance().get(`/ormpostdetails/${context.ormpostdetails}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails`,data,isloading);
        }
        if(context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormpostdetails`,data,isloading);
        }
        if(context.ormpostlib && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormpostlibs/${context.ormpostlib}/ormpostdetails`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormpostdetails`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormpostdetails/${context.ormpostdetails}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/checkkey`,data,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/checkkey`,data,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().post(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormpostdetails/${context.ormpostdetails}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,data,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().put(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,data,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().put(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormpostdetails/${context.ormpostdetails}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/getdraft`,isloading);
        }
        if(context.ormpost && true){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormpostdetails/getdraft`,isloading);
        }
        if(context.ormpostlib && true){
            return Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormpostdetails/getdraft`,isloading);
        res.data.ormpostdetails = data.ormpostdetails;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/save`,data,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}/save`,data,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().post(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormpostdetails/${context.ormpostdetails}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && context.ormpostdetails){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
        if(context.ormpost && context.ormpostdetails){
            return Http.getInstance().delete(`/ormposts/${context.ormpost}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
        if(context.ormpostlib && context.ormpostdetails){
            return Http.getInstance().delete(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/${context.ormpostdetails}`,isloading);
        }
            return Http.getInstance().delete(`/ormpostdetails/${context.ormpostdetails}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmPostDetailsServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/ormpostdetails/fetchdefault`,tempData,isloading);
        }
        if(context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormposts/${context.ormpost}/ormpostdetails/fetchdefault`,tempData,isloading);
        }
        if(context.ormpostlib && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormpostlibs/${context.ormpostlib}/ormpostdetails/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormpostdetails/fetchdefault`,tempData,isloading);
    }
}