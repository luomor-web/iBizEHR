import { Http,Util } from '@/utils';
import PimExitandentryServiceBase from './pim-exitandentry-service-base';


/**
 * 出入境管理服务对象
 *
 * @export
 * @class PimExitandentryService
 * @extends {PimExitandentryServiceBase}
 */
export default class PimExitandentryService extends PimExitandentryServiceBase {

    /**
     * Creates an instance of  PimExitandentryService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimExitandentryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}