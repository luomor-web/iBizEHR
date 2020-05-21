import { Http,Util } from '@/utils';
import VACDAYOFFServiceBase from './vacdayoff-service-base';


/**
 * 调休日管理（停用）服务对象
 *
 * @export
 * @class VACDAYOFFService
 * @extends {VACDAYOFFServiceBase}
 */
export default class VACDAYOFFService extends VACDAYOFFServiceBase {

    /**
     * Creates an instance of  VACDAYOFFService.
     * 
     * @param {*} [opts={}]
     * @memberof  VACDAYOFFService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}