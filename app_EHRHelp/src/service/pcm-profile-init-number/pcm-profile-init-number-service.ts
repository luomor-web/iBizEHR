import { Http,Util } from '@/utils';
import PcmProfileInitNumberServiceBase from './pcm-profile-init-number-service-base';


/**
 * 应聘者起始编号（停用）服务对象
 *
 * @export
 * @class PcmProfileInitNumberService
 * @extends {PcmProfileInitNumberServiceBase}
 */
export default class PcmProfileInitNumberService extends PcmProfileInitNumberServiceBase {

    /**
     * Creates an instance of  PcmProfileInitNumberService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmProfileInitNumberService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}