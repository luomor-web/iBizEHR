import { Http,Util } from '@/utils';
import PimAchievementsServiceBase from './pim-achievements-service-base';


/**
 * 绩效信息服务对象
 *
 * @export
 * @class PimAchievementsService
 * @extends {PimAchievementsServiceBase}
 */
export default class PimAchievementsService extends PimAchievementsServiceBase {

    /**
     * Creates an instance of  PimAchievementsService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimAchievementsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}