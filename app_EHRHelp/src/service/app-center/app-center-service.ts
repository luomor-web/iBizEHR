import { Http,Util } from '@/utils';
import AppCenterServiceBase from './app-center-service-base';


/**
 * 应用中心（工作流专用）服务对象
 *
 * @export
 * @class AppCenterService
 * @extends {AppCenterServiceBase}
 */
export default class AppCenterService extends AppCenterServiceBase {

    /**
     * Creates an instance of  AppCenterService.
     * 
     * @param {*} [opts={}]
     * @memberof  AppCenterService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}