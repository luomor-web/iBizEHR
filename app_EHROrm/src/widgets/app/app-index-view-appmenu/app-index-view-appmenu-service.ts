import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import AppIndexViewModel from './app-index-view-appmenu-model';


/**
 * AppIndexView 部件服务对象
 *
 * @export
 * @class AppIndexViewService
 */
export default class AppIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof AppIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of AppIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof AppIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new AppIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof AppIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/app-index-viewappmenu', params);
    }

}