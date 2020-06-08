import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import ZIZHUModel from './zizhu-appmenu-model';


/**
 * ZIZHU 部件服务对象
 *
 * @export
 * @class ZIZHUService
 */
export default class ZIZHUService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof ZIZHUService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of ZIZHUService.
     * 
     * @param {*} [opts={}]
     * @memberof ZIZHUService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new ZIZHUModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof ZIZHU
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/zizhuappmenu', params);
    }

}