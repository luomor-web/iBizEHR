import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import IndexModel from './index-appmenu-model';


/**
 * Index 部件服务对象
 *
 * @export
 * @class IndexService
 */
export default class IndexService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof IndexService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of IndexService.
     * 
     * @param {*} [opts={}]
     * @memberof IndexService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new IndexModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof Index
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/indexappmenu', params);
    }

}