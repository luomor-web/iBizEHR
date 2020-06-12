import { Http,Util } from '@/utils';
import PimTitleServiceBase from './pim-title-service-base';


/**
 * 职称信息服务对象
 *
 * @export
 * @class PimTitleService
 * @extends {PimTitleServiceBase}
 */
export default class PimTitleService extends PimTitleServiceBase {

    /**
     * Creates an instance of  PimTitleService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimTitleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}