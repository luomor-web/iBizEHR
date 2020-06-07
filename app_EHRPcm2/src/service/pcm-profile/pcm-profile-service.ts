import { Http,Util } from '@/utils';
import PcmProfileServiceBase from './pcm-profile-service-base';


/**
 * 应聘者基本信息服务对象
 *
 * @export
 * @class PcmProfileService
 * @extends {PcmProfileServiceBase}
 */
export default class PcmProfileService extends PcmProfileServiceBase {

    /**
     * Creates an instance of  PcmProfileService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmProfileService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}