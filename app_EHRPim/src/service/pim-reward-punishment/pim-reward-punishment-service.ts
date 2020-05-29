import { Http,Util } from '@/utils';
import PimRewardPunishmentServiceBase from './pim-reward-punishment-service-base';


/**
 * 奖惩信息服务对象
 *
 * @export
 * @class PimRewardPunishmentService
 * @extends {PimRewardPunishmentServiceBase}
 */
export default class PimRewardPunishmentService extends PimRewardPunishmentServiceBase {

    /**
     * Creates an instance of  PimRewardPunishmentService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimRewardPunishmentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}