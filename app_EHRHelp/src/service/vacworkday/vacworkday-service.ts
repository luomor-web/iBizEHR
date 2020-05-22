import { Http,Util } from '@/utils';
import VACWORKDAYServiceBase from './vacworkday-service-base';


/**
 * 工作日管理（停用）服务对象
 *
 * @export
 * @class VACWORKDAYService
 * @extends {VACWORKDAYServiceBase}
 */
export default class VACWORKDAYService extends VACWORKDAYServiceBase {

    /**
     * Creates an instance of  VACWORKDAYService.
     * 
     * @param {*} [opts={}]
     * @memberof  VACWORKDAYService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}