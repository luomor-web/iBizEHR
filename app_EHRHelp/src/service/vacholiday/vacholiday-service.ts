import { Http,Util } from '@/utils';
import VACHOLIDAYServiceBase from './vacholiday-service-base';


/**
 * 节假日管理服务对象
 *
 * @export
 * @class VACHOLIDAYService
 * @extends {VACHOLIDAYServiceBase}
 */
export default class VACHOLIDAYService extends VACHOLIDAYServiceBase {

    /**
     * Creates an instance of  VACHOLIDAYService.
     * 
     * @param {*} [opts={}]
     * @memberof  VACHOLIDAYService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}