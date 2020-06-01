import { Http,Util } from '@/utils';
import PcmAwardsWonsServiceBase from './pcm-awards-wons-service-base';


/**
 * 获奖情况服务对象
 *
 * @export
 * @class PcmAwardsWonsService
 * @extends {PcmAwardsWonsServiceBase}
 */
export default class PcmAwardsWonsService extends PcmAwardsWonsServiceBase {

    /**
     * Creates an instance of  PcmAwardsWonsService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmAwardsWonsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}